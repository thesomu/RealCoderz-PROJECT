from django.http import request
from django.shortcuts import redirect, render
from datetime import datetime
from billing_details.models import billing
from django.contrib import messages
import logging



# Create your views here.
logger = logging.getLogger('django')
         
 #inserting credit card values   
def billing_view(request):
   if request.method =="POST":
       logger.info(" credit card data inserted")
       fname = request.POST['fullname']
       emailid = request.POST['emailid']
       address = request.POST['address'] 
       city = request.POST['city'] 
       state = request.POST['state']
       zip = request.POST['zip'] 
       cardname = request.POST['cardname'] 
       cardnumber = request.POST['cardnumber'] 
       expiry_month = request.POST['expiry_month']
       expiry_year = request.POST['expiry_year']
       cvv = request.POST['cvv']  
       bill=billing(fullname=fname,emailid=emailid,address=address,city=city,state=state,zip=zip,cardname=cardname,cardnumber=cardnumber,expiry_month=expiry_month,expiry_year=expiry_year,cvv=cvv)
       bill.save()

       return render(request,'home.html')

   else:
        return render(request,'index.html')       

#showing credit card value
def show(request):
     
     bill=billing.objects.all()
     return render(request,'showdata.html',{'bills': bill})
#deleting credit card details
def destroy(request, id):  
    employee = billing.objects.get(id=id)  
    employee.delete()  
    return redirect("/billing/")  
#login function with session
def login(request):
    if request.method =="POST":
        print("jai")
        username=request.POST['username']
        password=request.POST['password']
        if(username=="jai" and password=="123"):
            request.session['/'] = username
            
            return redirect('dashboard/')
        else:
            messages.error("wrong")
            return redirect('/')
    else:
        return render(request,'login.html')  
#showing all the fuctionalities
def dashboard(request):
    if '/' in request.session:
        name = request.session['/']
        
        return render(request, "home.html", {'name': name})
    else:
        messages.error(request, 'Login first')
        return render(request, '')
#logut fucntion to logout from session
def Logout(request):
    
    try:
        
        del request.session['/']
    except:
        pass
    return redirect('/')


