from django.http import request
from django.urls import path

from . import views

urlpatterns = [
    path("register", views.register, name="register"),
    path("details", views.details, name="details"),
    path("employeeProfile", views.employeeProfile, name="employeeProfile"),
    path("edit", views.edit, name="edit"),
    path("update", views.update, name="update"),
    path("delete", views.destroy, name="delete"),
]
