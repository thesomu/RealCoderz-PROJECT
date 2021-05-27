"""codingfreaks URL Configuration

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

#Flow of the program starts from codingfreaks(project) urls.
#Here path will be checked and redirected to shopping(app) urls.
urlpatterns = [
    path('',include('shopping.urls')),
    path('wrogn',include('shopping.urls')),
    path('flying',include('shopping.urls')),
    path('peter',include('shopping.urls')),
    path('product',include('shopping.urls')),
    path('admin/', admin.site.urls),
]
