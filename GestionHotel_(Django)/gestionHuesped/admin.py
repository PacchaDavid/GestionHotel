from django.contrib import admin

from gestionHuesped.models import *

# Register your models here.
admin.site.register(Cliente)
admin.site.register(ClienteRegistrado)
admin.site.register(Recepcionista)
admin.site.register(Reservacion)
admin.site.register(CheckIN)
admin.site.register(CheckOUT)
admin.site.register(ambiente)
admin.site.register(Pago)
admin.site.register(almacenDato)
admin.site.register(oferta)