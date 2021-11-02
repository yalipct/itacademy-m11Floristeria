## Cambios

NOTES:
Proposición de últimos cambios para la entrega del proyecto.

#### FloristeriaController/FloristeriaRepository/Floristeria
* eliminado el `throws CammpoVacio` en las 3 clases.

#### FloristeriaRepository
```java
//cambios en el método.
removeProduct 
```
* La comprobación de que producto eliminar al final se hizo en la vista.

#### Ticket
* eliminado método `imprimirTicket`
```java
/*cambiado el foreach del método por un for normal 
porque necesitas la i y la p del foreach nunca se usa.*/
ordenarTicket
```

#### FliristeriaApp
* quite los `imports` que no se usaban
* eliminado del main `throws CampoVacio`


#### FloristeriaSwing:
```java
//eliminar las advertencias de no se usa ej: en LaminaGeneral
BorderLayout borderLayout = new BorderLayout() //se puede eliminar porque,
```
```java
//accedes más abajo de manera estática
add(laminaImagen, BorderLayout.CENTER);
```

##### LaminaBotones:
```java
//JComboBox debe parametrizarse:
JComboBox material = new JComboBox();
```
```java
//cambiado por:
JComboBox<String> material = new JComboBox<String>();
```


##### LaminaProductos:
> poniendolo aquí se aplica para todos los textfield del nombre de los productos.
* añadido `keyListener` al textfield text1 (el del nombre de los productos) para que solo acepte letras.

##### LaminaArbol:
```java
texto2.setText("Altura (cm)"); //añadido el (cm)
```

##### LaminaFlor :
* añadido también `keyListener` para el textfield del color. Sólo acepta letras.

##### LaminaDecoracion: 
```java
//En el if del actionDone
material1 = material1.MADERA;
```
```java
//cambiado por
material1 = Material.MADERA;  -> igual con el PLASTICO
```
> Porque para acceder al enum tiene que ser de manera estática(lo marca como advertencia)

##### LaminaEliminar:
* ya no hace falta pasarle el `elim` en: actionDone(producto, ~~elim~~);
* eliminada captura de `CampoVacio`
> Ha cambiado todo el private void actionDone() pq hice las comprobaciones para eliminar los productos aquí.


#### FloristeriaTicketsView:
* Quitar imports que no se usen.

##### laminaCrear:
```java
//añadido el tipo a al ModelList, JList y los List:
List<Producto> array ...
ListModel<Producto>...
JList<Producto> productsList...
```