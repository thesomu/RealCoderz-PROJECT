"""Fasion_Hub URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path,include
from billing_details.views import login,billing_view,show,destroy,dashboard,Logout
from bill_logs.views import shows,destroys,destroyss,showss,edit,update,GeneratePdf


urlpatterns = [
    path('admin/', admin.site.urls),
    path('',login),
    path('bills',billing_view ,name="billing_details"),
    path('billing/',show),
    path('delete/<int:id>',destroy),
    path('exports/',shows),
    path('deletes/<int:id>',destroys),
    path('imports/',showss),
    path('deletess/<int:id>',destroyss),
    path('edit/<int:id>',edit),  
    path('update/<int:id>',update),
    path('dashboard/',dashboard), 
    path('logout',Logout),
    path('pdf/',GeneratePdf.as_view()),
    
      
    
]
