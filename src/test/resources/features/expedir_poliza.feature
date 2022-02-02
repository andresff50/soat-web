#language:es
Característica: Expedir poliza SOAT web

  Esquema del escenario: Expedir poliza SOAT web
    Dado que yo quiero iniciar sesion en SOAT web para expedir una poliza con usuario "PRUAUTOMAT" y password "Sqaauto*2022"
    Cuando yo completo el formulario con la informacion de la hoja <hoja> y columna <columna>
    Entonces yo deberia ver el mensaje que la poliza se creo correctamente

    Ejemplos:
      | hoja | columna |
      | 0    | 2       |
      | 0    | 3       |
      | 0    | 4       |