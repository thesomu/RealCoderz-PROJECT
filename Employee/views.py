from django.contrib import auth, messages
from django.shortcuts import render, redirect

import Employee
from Employee.forms import EmployeeForm
from Employee.models import empTable

"""This is to register the employee
    It would use POST method if data is coming from web page
    It would use GET method to redirect to the web page
"""


def register(request):
    if request.method == 'POST':
        name = request.POST['name']
        address = request.POST['address']
        phone = request.POST['phone']
        email = request.POST['email']
        designation = request.POST['designation']
        password = phone

        countAddress = address.count(',')
        countName = name.count(' ')

        if countAddress >= 2 and countName > 0:
            emp = empTable(name=name, address=address, phone=phone, email=email, designation=designation,
                           password=password)
            emp.save()
            print("Employee registered")
            return redirect('details')
        else:
            if countName < 1:
                messages.error(request, 'Name should have first and last name')
            if countAddress < 2:
                messages.error(request, 'Address should have society, city and pin code')
            return render(request, 'EmployeeRegistration.html')
    else:
        return render(request, 'EmployeeRegistration.html')


"""To get the details of all employees"""


def details(request):
    emp = empTable.objects.all()
    return render(request, 'Details.html', {'details': emp})


"""This is a dynamic page for a particular employee"""


def employeeProfile(request):
    if 'emp' in request.session:
        current_emp = request.session['emp']
        return render(request, 'EmployeeProfile.html', {'current_emp': current_emp})
    else:
        return redirect('employeeLogin')


"""To move to the update page"""


def edit(request):
    id2 = request.POST.get('id')
    employee = empTable.objects.get(id=id2)
    return render(request, 'Update.html', {'employee': employee})


"""To update the employee details"""


def update(request):
    id2 = request.POST['id']   # primary key
    name = request.POST['name']
    address = request.POST['address']
    phone = request.POST['phone']
    email = request.POST['email']
    designation = request.POST['designation']
    print(type(designation))
    password = phone

    countAddress = address.count(',')
    countName = name.count(' ')

    if countAddress >= 2 and countName > 0:
        emp = empTable(id=id2, name=name, address=address, phone=phone, email=email, designation=designation,
                       password=password)
        emp.save()
        print("Employee registered")
        return redirect('details')
    # employee = empTable.objects.get(id=id2)
    # print(id2)
    # form = EmployeeForm(request.POST, instance=employee)
    # if form.is_valid():
    #     form.save()
    else:
        if countName < 1:
            messages.error(request, 'Name should have first and last name')
        if countAddress < 2:
            messages.error(request, 'Address should have society, city and pin code')
        employee = empTable.objects.get(id=id2)
        return render(request, 'Update.html', {'employee': employee})

    emp = empTable.objects.all()
    return render(request, 'Details.html', {'details': emp})


"""To delete an employee"""


def destroy(request):
    id2 = request.POST.get('id')
    employee = empTable.objects.get(id=id2)
    employee.delete()
    emp = empTable.objects.all()
    return render(request, 'Details.html', {'details': emp})
