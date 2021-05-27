from django.http import HttpResponse
from django.contrib import messages
from django.shortcuts import redirect, render

from Import.models import Import

# Create your views here.
def portal_view(request, *args, **kwargs):
    return render(request, "importAndExportPortal.html", {})

def portalLogin_view(request):
    """
    """
    if request.method == "POST":
        userId = request.POST['user']
        password = request.POST['password']
        if((userId == 'harsh1234') and (password == "1998")):
            return render(request, "menuPage.html", {})
        else:
            messages.error(request, "Wrong credentials")
            return redirect('/')
    
def import_view(request):
    """
    """
    if request.method == "POST":
        if(request.POST['imp'] != None):
            return render(request, "importPage.html", {})

def insertImportOrder_view(request):
    """
    """
    if request.method == "POST":
        id = request.POST['orderid']
        date = request.POST['orderdate']
        country = request.POST['orderCountry']
        product = request.POST['orderProduct']
        status = request.POST['list']
        print(status)
        totalCost = request.POST['orderCost']

        order = Import(orderImport_id=id, order_date=date, import_product=product, orderImport_country=country, status_of_import=status, total_cost=totalCost)
        order.save()
        return redirect('/displayOrders')

def displayImportOrders_view(request):
    """
    """
    importOrders = Import.objects.all()
    return render(request, "importOrders.html",{'importOrders': importOrders})

def editImportOrders_view(request,id):
    """
    """
    orders = Import.objects.get(id=id)
    return render(request,'editImportPage.html',{'orders':orders})

def updateImportOrders_view(request, id):
    """
    """
    orderImport_id = request.POST['orderid']
    date = request.POST['orderdate']
    country = request.POST['orderCountry']
    product = request.POST['orderProduct']
    status = request.POST['list']
    totalCost = request.POST['orderCost']
    order = Import(id=id, orderImport_id=orderImport_id, order_date=date, import_product=product, orderImport_country=country, status_of_import=status, total_cost=totalCost)
    order.save()
    return redirect('/displayOrders')
    

def deleteImportOrders_view(request, id):
    """
    """
    orders = Import.objects.get(id=id)
    orders.delete()
    return redirect('/displayOrders')
