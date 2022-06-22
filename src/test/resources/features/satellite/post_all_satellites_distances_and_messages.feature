# language: es

@only
#@ignore
Característica: Servicio de seteo de información para varios satélites
  Yo, Han Solo, como general de la Alianza Rebelde
  Quiero contar con un servicio que me permita enviar información a varios satélites
  Para coordinar un gran golpe al Imperio Galáctico que reavive la llama de la resistencia

  #@ignore
  Escenario: Validar correcto funcionamiento del servicio de seteo de varios satélites
    Dado que Han Solo quiere setear la información de varios satélites
    Cuando solicita cambiar información en varios satélites con los datos
      #| satellite | distance | msg1 | msg2 | msg3 | msg4    | msg5    |
      | kenobi    | 100.0    | este |      |      | mensaje |         |
      | skywalker | 115.5    |      | es   |      |         | secreto |
      | sato      | 142.7    | este |      | un   |         |         |
    Entonces obtiene una respuesta exitosa de todos los satelites que dice "este es un mensaje secreto"


#@ignore
  Escenario: Validar respuesta de error cuando se setea información para satélites inexistentes
    Dado que Han Solo quiere setear la información de varios satélites
    Cuando solicita cambiar información en varios satélites con los datos
      #| satellite | distance | msg1 | msg2 | msg3 | msg4    | msg5    |
      | vader     | 100.0    | este |      |      | mensaje |         |
      | $         | 115.5    |      | es   |      |         | secreto |
      | *         | 142.7    | este |      | un   |         |         |
    Entonces obtiene un error de satélites inexistentes del servicio seteo de información para varios satélites


#@ignore
  Escenario: Validar respuesta consulta mal formada para seteo de info de varios satélites
    Dado que Han Solo quiere setear la información de varios satélites
    Cuando solicite guardar información vacía para varios satélites
    Entonces obtiene un error de satélite consulta mal formada del servicio seteo de información para varios satélites

