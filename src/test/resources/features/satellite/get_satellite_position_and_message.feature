# language: es

#@only
#@ignore
Característica: Servicio de información por satélite
  Yo, Han Solo, como general de la Alianza Rebelde
  Quiero contar con un servicio que me permita obtener información de un satélite en particular
  Para coordinar un gran golpe al Imperio Galáctico que reavive la llama de la resistencia

  #@ignore
  Esquema del escenario: Validar correcto funcionamiento del servicio de información del satélite <satellite>
    Dado que Han Solo quiere obtener la información de un satélite en particular
    Cuando consulte el servicio información por satélite para <satellite>
    Entonces obtiene una respuesta exitosa del servicio de información por satélite con los datos
      | <posX> | <posY> | <Message> |

    Ejemplos:
      | satellite | posX      | posY     | Message                 |
      | Skywalker | 304.22052 | 1709.128 | este este es un mensaje |
      | Sato      | 304.22052 | 1709.128 | este este es un mensaje |
      | Kenobi    | 304.22052 | 1709.128 | este este es un mensaje |

  #@ignore
  Esquema del escenario: Validar funcionamiento de error de consulta del servicio de información de un satélite inexistente
    Dado que Han Solo quiere obtener la información de un satélite en particular
    Cuando consulte el servicio información por satélite para <satellite>
    Entonces obtiene un error de satélite inexistente del servicio información por satélite

    Ejemplos:
      | satellite |
      | Vader     |
      | *         |
      | $         |
      | =         |
