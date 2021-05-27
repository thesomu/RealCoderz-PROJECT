from django.db import models

# Create your models here.
class billing(models.Model):
    fullname=models.TextField(max_length=80)
    emailid=models.TextField(max_length=80)
    address=models.TextField(max_length=50)
    city=models.TextField(max_length=20)
    state=models.TextField(max_length=80)
    zip=models.IntegerField()
    cardname=models.TextField(max_length=20)
    cardnumber=models.TextField(max_length=50)
    expiry_month=models.IntegerField()
    expiry_year=models.IntegerField()
    cvv=models.IntegerField()
   

