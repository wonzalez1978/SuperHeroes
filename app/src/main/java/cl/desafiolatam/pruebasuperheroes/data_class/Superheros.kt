package cl.desafiolatam.pruebasuperheroes.data_class

data class Superheros(
    val appearance: Appearance,
    val biography: Biography,
    val connections: Connections,
    val id: Int,
    val images: Images,
    val name: String,
    val powerstats: Powerstats,
    val slug: String,
    val work: Work
)