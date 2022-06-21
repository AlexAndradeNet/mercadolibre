# language: es

#@only
#@ignore
Característica: Servicio de seteo de información por satélite
  Yo, Han Solo, como general de la Alianza Rebelde
  Quiero contar con un servicio que me permita enviar información a un satélite en particular
  Para coordinar un gran golpe al Imperio Galáctico que reavive la llama de la resistencia

  #@ignore
  Esquema del escenario: Validar correcto funcionamiento del servicio de seteo del satélite <satellite>
    Dado que Han Solo quiere setear la información de un satélite en particular
    Cuando solicite guardar información del satélite con los datos
      | <satellite> | <distance> | <msg1> | <msg2> | <msg3> | <msg4> | <msg5> |
    Entonces obtiene una respuesta exitosa del servicio que dice "Información guardada correctamente para <satellite>"

    Ejemplos:
      | satellite | distance | msg1 | msg2 | msg3 | msg4 | msg5    |
      | skywalker | 142.5    |      | este | es   | un   | mensaje |
      | sato      | 142.5    | este |      | un   |      | mensaje |
      | kenobi    | 142.5    |      |      | es   |      | mensaje |

  #@ignore
  Esquema del escenario: Validar respuesta de error cuando se setea el inexistente satélite <satellite>
    Dado que Han Solo quiere setear la información de un satélite en particular
    Cuando solicite guardar información del satélite con los datos
      | <satellite> | <distance> | <msg1> | <msg2> | <msg3> | <msg4> | <msg5> |
    Entonces obtiene un error de satélite inexistente del servicio seteo de información por satélite

    Ejemplos:
      | satellite | distance | msg1 | msg2 | msg3 | msg4 | msg5    |
      | vader     | 142.5    |      | este | es   | un   | mensaje |
      | $         | 142.5    | este |      | un   |      | mensaje |
      | *         | 142.5    |      |      | es   |      | mensaje |

#@ignore
  Esquema del escenario: Validar respuesta consulta mal formada para seteo de info del satélite <satellite>
    Dado que Han Solo quiere setear la información de un satélite en particular
    Cuando solicite guardar información vacía del satélite <satellite>
    Entonces obtiene un error de satélite consulta mal formada del servicio seteo de información por satélite

    Ejemplos:
      | satellite |
      | skywalker |
      | sato      |
      | kenobi    |
