# practica01_grafos
Actividad Practica: Optimizacion de Rutas de Delivery en Cochabamba

========================================================

Integrantes:
Ona Alcoba Sebastian Alexandre
Perez Torrico Sebastian
Uribe Pessoa Eric

========================================================

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

========================================================

Recomendacioes:
Basado en los resultados obtenidos, se recomienda a FoodExpress Cochabamba fortalecer su red de rutas agregando una conexión directa entre El Prado (0) y Queru Queru (4), lo que reduciría significativamente los tiempos de entrega hacia el Aeropuerto (5) y mejoraría la eficiencia logística general. Asimismo, se sugiere ubicar el centro de distribución principal en El Prado (0) por su alta conectividad, y uno secundario en Recoleta (3) para atender eficientemente las zonas norte y universitaria. La implementación de los algoritmos BFS y DFS en una aplicación móvil para repartidores permitirá calcular rutas óptimas en tiempo real y planificar recorridos completos sin repetir zonas, optimizando así las operaciones diarias y reduciendo costos operativos. Finalmente, se propone añadir conexiones alternativas como Cala Cala (1) con Aeropuerto (5) y América Oeste (2) con Queru Queru (4) para descongestionar nodos críticos y garantizar la resiliencia de la red ante posibles contingencias.

Conclusiones:
La red actual de FoodExpress Cochabamba es funcional y conexa, pero con pequeñas mejoras en infraestructura de rutas y el uso de algoritmos de búsqueda, es posible reducir tiempos de entrega, optimizar recorridos y escalar operaciones de manera eficiente. La implementación de BFS y DFS ha demostrado ser efectiva para estos fines, y su integración en herramientas tecnológicas representaría un valor agregado significativo para la empresa.

