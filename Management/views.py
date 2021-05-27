from django.contrib import auth, messages
from django.shortcuts import render, redirect

from Employee.models import empTable


def base(request):
    return render(request, 'Base.html')


"""This is to authenticate the HR"""


def login(request):
    if request.method == 'POST':
        id2 = str(request.POST['id'])
        password = str(request.POST['password'])
        if id2 == "kanishk" and password == "admin":
            request.session['login'] = id2
            return redirect('dashboard')
            # return render(request, "HRProfile.html", {'name': name})
        else:
            messages.error(request, 'Invalid Credentials')
            return render(request, 'HRLogin.html')
    else:
        return render(request, 'HRLogin.html')


"""To go to the HR dashboard"""


def dashboard(request):
    if 'login' in request.session:
        name = request.session['login']
        return render(request, "HRProfile.html", {'name': name})
    else:
        messages.error(request, 'Login first')
        return render(request, 'HRLogin.html')


"""This is to authenticate the employee"""


def employeeLogin(request):
    if request.method == 'POST':
        id2 = int(request.POST['id'])
        password = str(request.POST['password'])

        emp = empTable.objects.filter(id=id2, password=password)
        print(emp)
        if emp:
            request.session['emp'] = id2
            return redirect('empdashboard')
            # employee = empTable.objects.get(id=id2)
            # return render(request, 'EmployeeProfile.html', {'employee': employee})
        else:
            messages.error(request, 'Invalid Credentials')
            return render(request, 'EmployeeLogin.html')
    else:
        return render(request, 'EmployeeLogin.html')


"""To go to the dashboard of a particular employee"""


def empdashboard(request):
    if 'emp' in request.session:
        id2 = request.session['emp']
        employee = empTable.objects.get(id=id2)
        return render(request, 'EmployeeProfile.html', {'employee': employee})
    else:
        messages.error(request, 'Login first')
        return render(request, 'EmployeeLogin.html')


"""For HR/employee Logout"""


def employeeLogout(request):
    # auth.logout(request)
    try:
        del request.session['login']
    except:
        pass
    return redirect('/')
