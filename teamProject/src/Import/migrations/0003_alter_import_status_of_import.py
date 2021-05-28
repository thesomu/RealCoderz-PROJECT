# Generated by Django 3.2.3 on 2021-05-23 07:54

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('Import', '0002_alter_import_status_of_import'),
    ]

    operations = [
        migrations.AlterField(
            model_name='import',
            name='status_of_import',
            field=models.CharField(choices=[('No', 'Pending'), ('Yes', 'Completed')], max_length=10),
        ),
    ]