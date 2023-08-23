Feature: Pet Store

  @Prueba
  Scenario: Crear una Mascota
    Given que la api "CREAR_PET" esta disponible
    When envio un "POST" usando el body
    """
    {
    "id": 6,
    "category": {
      "id": 1,
      "name": "Pastor"
     },
    "name": "Bobi",
    "photoUrls": [
        "Blanco"
     ],
    "tags": [
      {
      "id": 0,
      "name": "bueno"
      }
     ],
    "status": "available"
    }
    """
    Then el codigo del response es 200
    And el response body debe tener el siguiente schema "expectedSchema.json"

  @Prueba
  Scenario: Actualizar una Mascota
    Given que la api "ACTUALIZAR_PET" esta disponible
    When envio un "PUT" usando el body
    """
    {
    "id": 3,
    "category": {
      "id": 1,
      "name": "Pastor"
     },
    "name": "Peque",
    "photoUrls": [
        "Blanco"
     ],
    "tags": [
      {
      "id": 0,
      "name": "bueno"
      }
     ],
    "status": "available"
    }
    """
    Then el codigo del response es 200
    And el response body debe tener el siguiente schema "expectedSchema.json"

  @Prueba
  Scenario: Consultar una Mascota
    Given que la api "CONSULTAR_PET" esta disponible
    When envio un "GET" con el id 3
    Then el codigo del response es 200