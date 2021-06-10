from datetime import datetime

from django.contrib import auth, messages
from django.shortcuts import render, redirect

from Employee.models import empTable
from Management.models import dailyAttendance, empAttendance, totalAttendance

import logging

logging.basicConfig(filename='logfile.log', level=logging.DEBUG, format='%(asctime)s:%(levelname)s:%(message)s')


def base(request):
    return render(request, 'Base.html')


"""This is to authenticate the HR"""


def login(request):
    if request.method == 'POST':
        id2 = str(request.POST['id'])
        password = str(request.POST['password'])
        if id2 == "kanishk" and password == "admin":
            request.session['login'] = id2
            logging.info('HR login successful')
            return redirect('dashboard')
            # return render(request, "HRProfile.html", {'name': name})
        else:
            messages.error(request, 'Invalid Credentials')
            logging.error('HR login fails')
            return render(request, 'HRLogin.html')
    else:
        return render(request, 'HRLogin.html')


"""To go to the HR dashboard"""


def dashboard(request):
    if 'login' in request.session:
        name = request.session['login']
        logging.info('HR session starts')
        return render(request, "HRProfile.html", {'name': name})
    else:
        messages.error(request, 'Login first')
        logging.warning('Wrong session')
        return render(request, 'HRLogin.html')


"""This is to authenticate the employee"""


def employeeLogin(request):
    if request.method == 'POST':
        id2 = int(request.POST['id'])
        password = str(request.POST['password'])

        emp = empTable.objects.filter(id=id2, password=password)
        print(emp)
        if emp:
            request.session['login'] = id2
            logging.info('Employee login successful')
            return redirect('empdashboard')
        else:
            messages.error(request, 'Invalid Credentials')
            logging.error('Employee login fails')
            return render(request, 'EmployeeLogin.html')
    else:
        return render(request, 'EmployeeLogin.html')


"""To go to the dashboard of a particular employee"""


def empdashboard(request):
    if 'login' in request.session:
        id2 = request.session['login']
        employee = empTable.objects.get(id=id2)
        logging.info('Employee session starts')
        return render(request, 'EmployeeProfile.html', {'employee': employee})
    else:
        messages.error(request, 'Login first')
        return render(request, 'EmployeeLogin.html')


"""For HR/employee Logout"""


def logout(request):
    try:
        logging.info('HR/employee session ends')
        del request.session['login']
        logging.info('HR/employee logout')
    except:
        pass
    return redirect('/')


def team(request):
    return render(request, 'Team.html')


def achievements(request):
    return render(request, 'Achievements.html')


def adventures(request):
    return render(request, 'Adventures.html')


def attendanceIn(request):
    id2 = request.POST['id']
    emp = empTable.objects.get(id=id2)
    daily = dailyAttendance.objects.get(empId=id2)
    inTime = request.POST['in']
    outTime = daily.outTime
    last = datetime.strptime(daily.inTime, "%Y-%m-%d %H:%M:%S")
    print(datetime.date(datetime.today()))
    if datetime.date(last) <= datetime.date(datetime.today()) or daily.inTime == 'null':
        attendance = dailyAttendance(id=daily.id, empId=emp, inTime=inTime, outTime=outTime)
        attendance.save()
    return redirect('empdashboard')


def attendanceOut(request):
    id2 = request.POST['id']
    emp = empTable.objects.get(id=id2)
    daily = dailyAttendance.objects.get(empId=id2)
    inTime = daily.inTime
    outTime = request.POST['out']
    currentIn = datetime.strptime(inTime, "%Y-%m-%d %H:%M:%S")
    currentOut = datetime.strptime(outTime, "%Y-%m-%d %H:%M:%S")
    currentInDate = datetime.date(currentIn)
    currentOutDate = datetime.date(currentOut)
    print(currentOut.month)
    if currentInDate == currentOutDate:
        attendance = dailyAttendance(id=daily.id, empId=emp, inTime=inTime, outTime=outTime)
        attendance.save()

        empAtt = empAttendance.objects.get(empId=id2)
        dayOne = empAtt.dayOne
        dayTwo = empAtt.dayTwo
        dayThree = empAtt.dayThree
        if currentOutDate.day == 3:
            dayThree = (currentOut - currentIn).total_seconds() / 3600
            print(dayThree)
        EmpAtt = empAttendance(id=empAtt.id, empId=emp, dayOne=dayOne, dayTwo=dayTwo, dayThree=dayThree)
        EmpAtt.save()

        totalAtt = totalAttendance.objects.get(empId=id2)
        May = totalAtt.May
        June = totalAtt.June
        July = totalAtt.July
        if currentOutDate.month == 6:
            June = (dayOne + dayTwo + dayThree) / 8
        TotalAtt = totalAttendance(id=totalAtt.id, empId=emp, May=May, June=June, July=July)
        TotalAtt.save()
    return redirect('empdashboard')


def attendanceDetails(request):
    id2 = request.POST['id']
    attendance = empAttendance.objects.filter(empId=id2)
    logging.info('Getting employees attendance')
    return render(request, 'EmployeeAttendance.html', {'details': attendance})


def HRAttendanceDetails(request):
    attendance = totalAttendance.objects.all()
    logging.info('Getting all employees attendance')
    return render(request, 'HRAttendance.html', {'details': attendance})
