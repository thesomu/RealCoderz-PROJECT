# Generated by Django 3.2.3 on 2021-06-02 10:32

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='dailyAttendence',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('empId', models.IntegerField()),
                ('inTime', models.CharField(max_length=20)),
                ('outTime', models.CharField(max_length=20)),
            ],
        ),
        migrations.CreateModel(
            name='empAttendence',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('empId', models.IntegerField()),
                ('dayOne', models.IntegerField()),
                ('dayTwo', models.IntegerField()),
                ('dayThree', models.IntegerField()),
            ],
        ),
        migrations.CreateModel(
            name='totalAttendence',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('empId', models.IntegerField()),
                ('May', models.IntegerField()),
                ('June', models.IntegerField()),
                ('July', models.IntegerField()),
            ],
        ),
    ]
