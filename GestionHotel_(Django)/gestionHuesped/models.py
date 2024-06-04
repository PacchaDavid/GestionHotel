from django.db import models


# Create your models here.
class Cliente(models.Model):
    nombre = models.CharField(max_length=50)
    apellido = models.CharField(max_length=50)
    correo = models.CharField(max_length=50)
    ciudad = models.CharField(max_length=50)
    pais = models.CharField(max_length=50)

    def __str__(self):
        return f"{self.nombre} {self.apellido}"


class ClienteRegistrado(models.Model):
    Id = models.CharField(max_length=50)
    contrasenia = models.CharField(max_length=50)
    estado = models.BooleanField(default=True)
    Cliente = models.ForeignKey(Cliente, on_delete=models.CASCADE)

    def __str__(self):
        return self.Id


class Recepcionista(models.Model):
    nombre = models.CharField(max_length=50)
    apellidos = models.CharField(max_length=50)
    idEmpleado = models.CharField(max_length=50)
    nroTelefono = models.CharField(max_length=10)
    ClienteRegistrado = models.ForeignKey(ClienteRegistrado, on_delete=models.CASCADE,
                                          related_name='UsuarioRegistradoList')

    def __str__(self):
        return self.nombre


class Reservacion(models.Model):
    nroHabitacion = models.IntegerField(default=0)
    tipoHabitacion = models.CharField(max_length=50)
    lugar = models.CharField(max_length=50)
    ClienteRegistrado = models.ForeignKey(ClienteRegistrado, on_delete=models.CASCADE)

    def __str__(self):
        return f"{self.nroHabitacion} {self.lugar}"


class CheckIN(models.Model):
    FechaChekIN = models.CharField(max_length=50)
    Reservacion = models.ForeignKey(Reservacion, on_delete=models.CASCADE)

    def __str__(self):
        return self.FechaChekIN


class CheckOUT(models.Model):
    FechaChekOUT = models.CharField(max_length=50)
    Reservacion = models.ForeignKey(Reservacion, on_delete=models.CASCADE)

    def __str__(self):
        return self.FechaChekOUT


class ambiente(models.Model):
    restaurante = models.BooleanField(default=False)
    bar = models.BooleanField(default=False)
    otros = models.CharField(max_length=50)
    userid = models.CharField(max_length=50)
    UsuarioRegistrado = models.ForeignKey(ClienteRegistrado, on_delete=models.CASCADE)

    def __str__(self):
        if self.bar:
            return "Bar"
        elif self.restaurante:
            return "Restaurante"
        elif self.otros:
            return self.otros
        else:
            return "Ninguno"


class Pago(models.Model):
    User: str = models.CharField(max_length=50)
    pagado = models.CharField(max_length=50)
    total = models.IntegerField()
    detalle = models.CharField(max_length=50)
    CheckOUT = models.ForeignKey(CheckOUT, on_delete=models.CASCADE)
    ambientes = models.ForeignKey(ambiente, on_delete=models.CASCADE)

    def __str__(self):
        return self.User


class almacenDato(models.Model):
    Cliente = models.ForeignKey(Cliente, on_delete=models.CASCADE)
    detalleAcceso = models.CharField(max_length=50)
    detalleHabitacion = models.CharField(max_length=50)
    correoID = models.CharField(max_length=50)
    ciudad = models.CharField(max_length=50)
    pagos = models.CharField(max_length=50)
    atributos = models.CharField(max_length=50)
    otrosDetalles = models.CharField(max_length=50)
    UsuarioID = models.CharField(max_length=50)
    UsuarioRegistrado = models.ForeignKey(ClienteRegistrado, on_delete=models.CASCADE)
    Recepcionista = models.ForeignKey(Recepcionista, on_delete=models.CASCADE)
    ambientes = models.ForeignKey(ambiente, on_delete=models.CASCADE)
    pago = models.ForeignKey(Pago, on_delete=models.CASCADE)
    checkOUT = models.ForeignKey(CheckOUT, on_delete=models.CASCADE)

    def __str__(self):
        return self.UsuarioID


class oferta(models.Model):
    CodigoOfertas = models.CharField(max_length=50)
    almacenDatos = models.ForeignKey(almacenDato, on_delete=models.CASCADE)

    def __str__(self):
        return self.CodigoOfertas
