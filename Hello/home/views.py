from django.shortcuts import render,HttpResponse

#def index(request):
 #   return HttpResponse("this is home page")
def index(request):
    return render(request,'index.html') 

def add(request):
    val1=int(request.POST["num1"])
    val2=int(request.POST["num2"])
    res=val1+val2
    return render(request,'result.html',{'Result':res})    