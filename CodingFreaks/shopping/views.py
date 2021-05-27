from django.shortcuts import render
from django.views import View
from .models import Company, User,Product,Cart,OrderPlaced
#from django.http import httpResponse

# Create your views here.

#Now this class will return the flow to home.html page
class ProductViewHome(View):
    def get(self,request):
        slider = Product.objects.filter(category='slider')
        onsale = Product.objects.filter(category='onsale')
        newarrivals = Product.objects.filter(category='newarrivals')
        

        return render(request,'home.html',{'onsale':onsale,'newarrivals':newarrivals})
#def home(request):
 #   return render(request,'home.html')

#Now this class will return the flow to wrogn.html page
class ProductViewWrogn(View):
    def get(self,request):
        upperwears = Product.objects.filter(category='UW',comp_id=1)
        bottomwears = Product.objects.filter(category='BW',comp_id=1)
        footwears = Product.objects.filter(category='FW',comp_id=1)

        return render(request,'wrogn.html',{'upperwears':upperwears,'bottomwears':bottomwears,'footwears':footwears})
#def wrogn(request):
 #   return render(request,'wrogn.html')


 #Now this class will return the flow to flying.html page
class ProductViewFlying(View):
    def get(self,request):
        upperwears = Product.objects.filter(category='UW',comp_id=2)
        bottomwears = Product.objects.filter(category='BW',comp_id=2)
        footwears = Product.objects.filter(category='FW',comp_id=2)

        return render(request,'flying.html',{'upperwears':upperwears,'bottomwears':bottomwears,'footwears':footwears})
#def flying(request):
 #    return render(request,'flying.html')


#Now this class will return the flow to peter.html page
class ProductViewPeter(View):
    def get(self,request):
        upperwears = Product.objects.filter(category='UW',comp_id=3)
        bottomwears = Product.objects.filter(category='BW',comp_id=3)
        footwears = Product.objects.filter(category='FW',comp_id=3)

        return render(request,'peter.html',{'upperwears':upperwears,'bottomwears':bottomwears,'footwears':footwears})
#def peter(request):
 #   return render(request,'peter.html')


class ProductViewProduct(View):
    def get(self,request,pk):
        product = Product.objects.get(prod_id=pk)
        return render(request,'product.html',{'product':product})

