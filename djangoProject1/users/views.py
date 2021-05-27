from django.contrib.auth import authenticate
from django.shortcuts import render, redirect
from django.http import HttpResponse
from .models import Customer, Shipping
from django.contrib import messages, auth


# Create your views here.

def login(request):
    if request.method == 'POST':
        username = request.POST['username']
        password = request.POST['password']

        if Customer.objects.filter(cust_uname=username, cust_password=password):
            request.session['cust'] = username
            return redirect('dashboard')
        else:
            messages.info(request, 'invalid credentials')
            return redirect('login')
    else:
        return render(request, 'login.html')


def logout(request):
    try:
        del request.session['cust']
    except:
        return redirect('login')
    return redirect('login')


def customer(request):
    return render(request, 'register.html');


def register(request):
    if request.method == 'POST':
        first_name = request.POST['first_name']
        last_name = request.POST['last_name']
        username = request.POST['username']
        email = request.POST['email']
        password = request.POST['password']
        confirm_password = request.POST['confirm_password']
        phone_no = request.POST['phoneno']

        if password == confirm_password:
            if Customer.objects.filter(cust_uname=username).exists():
                messages.info(request, 'Username already taken')
                return redirect('/')
            elif Customer.objects.filter(cust_email=email).exists():
                messages.info(request, 'Email already registered')
                return redirect('/')
            else:
                cust = Customer(cust_uname=username, cust_phone=phone_no, cust_password=password, cust_email=email,
                                cust_fname=first_name, cust_lname=last_name)
                cust.save()
                print('user created')
                return redirect('login')
        else:
            messages.info(request, 'Password not matching')
            return redirect('/')
    else:
        return redirect('register.html')


def dashboard(request):
    if 'cust' in request.session:
        current_user = request.session['cust']
        param = {'current_user': current_user}
        return render(request, 'dashboard.html', param)
    else:
        return redirect('login')


def shipping(request):
    if request.method == 'POST':
        shipfname = request.POST['first_name']
        shiplname = request.POST['last_name']
        shipphoneno = request.POST['phoneno']
        shipaddress = request.POST['address']
        print(shipfname, shiplname, shipaddress, shipphoneno)
        ship = Shipping(ship_fname=shipfname, ship_lname=shiplname, ship_phone=shipphoneno, ship_address=shipaddress)
        ship.save()
        print('detail added')
        return redirect('profile')
    else:
        return redirect('dashboard')


def Profile(request):
    # if 'cust' in request.session:
    #   current_user = request.session['cust']
    #  param = {'current_user': current_user}
    # return render(request, 'custprofile.html', param)
    # else:
    #   return redirect('login')
    prof = Shipping.objects.all()
    return render(request, 'custprofile.html', {'prof': prof})


def destroy(request, id):
    ship = Shipping.objects.get(id=id)
    ship.delete()
    return redirect('profile')


def edit(request, id):
    ship = Shipping.objects.get(id=id)
    return render(request, 'edit.html')


def update(request, id):
    pass


def home(request):
    return render(request, 'home.html')
