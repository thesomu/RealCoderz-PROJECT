from django.conf import settings
from django.conf.urls.static import static
from django.urls import path

from . import views

urlpatterns = [
    path('home', views.home, name='home'),
    path('', views.customer, name='customer'),
    path('register', views.register, name='register'),
    path('login', views.login, name='login'),
    path('dashboard', views.dashboard, name='dashboard'),
    path('logout', views.logout, name='logout'),
    path('shipping', views.shipping, name='shipping'),
    path('profile', views.Profile, name='profile'),
    path('delete/<int:id>', views.destroy, name='delete'),
    path('edit/<int:id>', views.edit, name='edit'),
    path('update/<int:id>', views.update, name='edit')
]
