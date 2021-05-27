from django.urls import path

from . import views

urlpatterns = [
    path('', views.base, name='base'),
    path("login", views.login, name="login"),
    path("dashboard", views.dashboard, name="dashboard"),
    path("employeeLogin", views.employeeLogin, name="employeeLogin"),
    path("empdashboard", views.empdashboard, name="empdashboard"),
    path("logout", views.logout, name="logout"),
]
