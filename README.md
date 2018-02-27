# callcenter-kbaez

Como decia la consigna se creo la clase Dispacher para que controle las llamadas que recibe la app y se las asigne a los empleados disponibles. El empleado al terminar la llamada, se lo vuelve a cargar a la cola de empleadosDisponibles.

Tanto para las llamadas como para los empleados se utilizan colas de la interfaz BlockingQueue ya que tienen la garantía adicional de que cuando se recupera un elemento de una cola vacía bloqueará el hilo de llamada hasta que el elemento esté listo para ser recuperado. De igual forma, cualquier intento de insertar un elemento dentro de una cola que esté llena bloqueará la hilo de llamada hasta que haya espacio disponible en el almacenamiento de la cola. Esto último ayudaría a manejar las llamadas cuando supere el número permitido.

El uml de clases fue hecho con ObjectAid UML Explorer y esta dentro del proyecto.
