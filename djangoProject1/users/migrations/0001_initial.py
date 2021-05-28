# Generated by Django 3.2.3 on 2021-05-23 17:44

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Customer',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('cust_fname', models.CharField(max_length=20)),
                ('cust_lname', models.CharField(max_length=20)),
                ('cust_uname', models.CharField(max_length=20)),
                ('cust_password', models.CharField(max_length=20)),
                ('cust_email', models.CharField(max_length=50)),
                ('cust_phone', models.IntegerField()),
            ],
        ),
        migrations.CreateModel(
            name='Shipping',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('ship_fname', models.CharField(max_length=20)),
                ('ship_lname', models.CharField(max_length=20)),
                ('ship_phone', models.CharField(max_length=10)),
                ('ship_address', models.CharField(max_length=200)),
            ],
        ),
    ]