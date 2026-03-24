# practica01_grafos
Actividad Practica: Optimizacion de Rutas de Delivery en Cochabamba
Integrantes:
Ona Alcoba Sebastian Alexandre
Perez Torrico Sebastian
Uribe Pessoa Eric

=== RED DE DELIVERY FOODEXPRESS === 
6 zonas 6 enlaces
El Prado (B) : Cala cala (1), America Oeste (2),
Cala Cala (1) : El Prado (0), Recoleta (3),
Anérica Oeste (2) : El Prado (0), Recoleta (3),
Recoleta (3) : Cala Cala (1), America Oeste (2), Qeru Qeru (4),
Queru Queru (4) : Recoleta (3), Aeropuerto (5),
Aeropuerto (5) : Qeru Qeru (4),


EI Prado esta conectada a Cala Cala : true
EI Prado esta conectada a Aeropuerto : false
Vecinos de El Prado: Cala Cala (1), America Oeste (2)
Vecinos de Recoleta: Cala Cala (1), America Oeste (2), Qeru Qeru (4)
Vecinos de Aeropuerto: Qeru (4)
Ruta mas corta de El Prado a Aeropuerto: El Prado (0) -> Cala Cala (1) -> Recoleta (3) -> Qeru Qeru (4) -> Aeropuerto (5)
Ruta mas corta de El Prado a America Oeste: El Prado (0) Anérica Oeste (2)
    MEJOR RUTA DE REPARTO desde America Oeste:

Orden de visita de la zona:
1. América Oeste (2) ->
2. El Prado (O) ->
3. Cala Cala (1) ->
4. Recoleta (3) ->
5. Qeru Qeru (4) ->
6. Aeropuerto (5) ->

========================================================

ÉXITO: Se visitaron TODAS las 6 zonas sin repetir.
Total de paradas: 6