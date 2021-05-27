from django.db import models
from django.db.models.deletion import DO_NOTHING

# Create your models here.
class Export(models.Model):
    """
    Export model class which describes the fields needed for
    export table.Contains all the details that are required at the time
    of product export.
    """
    exportProduct_id = models.IntegerField()
    product_name = models.CharField(max_length=20)
    price_per_piece = models.FloatField()
    date_of_export = models.DateField()
    status = models.CharField(max_length=10)


class Client_Demand(models.Model):
    """
    """
    client_id = models.IntegerField()
    product_name = models.ForeignKey(Export, max_length=20, on_delete=DO_NOTHING)
    client_name = models.CharField(max_length=20)
    client_country = models.CharField(max_length = 20)
    quantity_demanded = models.IntegerField()
    