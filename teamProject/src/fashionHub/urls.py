"""fashionHub URL Configuration

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
from django.urls import path
from Import.views import portal_view, portalLogin_view, import_view, insertImportOrder_view, displayImportOrders_view, editImportOrders_view, deleteImportOrders_view, updateImportOrders_view
urlpatterns = [
    path('admin/', admin.site.urls),
    path('', portal_view, name='portalPage'),
    path('login', portalLogin_view, name='portalLogin'),
    path('menu', import_view, name='importMain'),
    path('import', insertImportOrder_view, name="importOrder"),
    path('displayOrders', displayImportOrders_view, name='showOrders'),
    path('edit/<int:id>',editImportOrders_view, name="editOrders"),
    path('update/<int:id>',updateImportOrders_view, name="updateOrders"),
    path('delete/<int:id>',deleteImportOrders_view, name="deleteOrder")
]
