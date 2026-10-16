package com.ucaldas.aplicacion1

data class Villano(
    val nombre: String,
    val alias: String,
    val descripcion: String,
    val imagenUrl: String? = null
)

data class Nombres(
    val id: Int,
    val nombre: String,
    val imagenUrl: String,
    val descripcion: String,
    val superPoderes: List<String>,
    // Con valor por defecto para que los heroes sin villanos sigan compilando igual
    val villanos: List<Villano> = emptyList()
)

private const val IMAGENES = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg"

val listaNombres = listOf(
    Nombres(
        1,
        "Superman",
        "$IMAGENES/644-superman.jpg",
        "Superman es un heroe de Superman Prime One-Million reconocido por ACTION COMICS #1.",
        listOf("Inteligencia superior", "Super fuerza", "Super velocidad", "Alta resistencia"),
        listOf(
            Villano(
                "Lex Luthor",
                "El genio criminal de Metropolis",
                "Multimillonario y cientifico que ve en Superman una amenaza para la humanidad.",
                "$IMAGENES/405-lex-luthor.jpg"
            ),
            Villano(
                "Darkseid",
                "Señor de Apokolips",
                "Tirano cosmico que busca la Ecuacion Anti-Vida para dominar toda voluntad.",
                "$IMAGENES/204-darkseid.jpg"
            ),
            Villano(
                "Doomsday",
                "La criatura imparable",
                "Monstruo kryptoniano que se adapta a cada derrota; fue capaz de matar a Superman.",
                "$IMAGENES/230-doomsday.jpg"
            )
        )
    ),
    Nombres(
        2,
        "Batman",
        "$IMAGENES/70-batman.jpg",
        "Bruce Wayne protege Gotham City con disciplina, tecnologia y una mente de detective.",
        listOf("Inteligencia superior", "Combate cuerpo a cuerpo", "Artes marciales", "Tecnologia avanzada"),
        listOf(
            Villano(
                "Joker",
                "El Principe Payaso del Crimen",
                "Criminal caotico e impredecible, obsesionado con demostrar que Batman es como el.",
                "$IMAGENES/370-joker.jpg"
            ),
            Villano(
                "Bane",
                "El hombre que rompio al murcielago",
                "Estratega brillante potenciado por el Veneno; quebro la espalda de Batman.",
                "$IMAGENES/60-bane.jpg"
            ),
            Villano(
                "Two-Face",
                "Harvey Dent",
                "Ex fiscal de Gotham que decide cada crimen lanzando una moneda.",
                "$IMAGENES/678-two-face.jpg"
            )
        )
    ),
    Nombres(
        3,
        "Iron Man",
        "$IMAGENES/346-iron-man.jpg",
        "Tony Stark es un genio inventor que combate el crimen con armaduras de alta tecnologia.",
        listOf("Inteligencia superior", "Armadura tecnologica", "Proyeccion de energia", "Vuelo"),
        listOf(
            Villano(
                "Mandarin",
                "Maestro de los diez anillos",
                "Conquistador que domina diez anillos de origen alienigena con poderes distintos.",
                "$IMAGENES/430-mandarin.jpg"
            ),
            Villano(
                "Iron Monger",
                "Obadiah Stane",
                "Socio de Stark Industries que construyo una armadura gigante para quedarse con la empresa.",
                "$IMAGENES/347-iron-monger.jpg"
            ),
            Villano(
                "Ultron",
                "La inteligencia artificial rebelde",
                "Robot consciente que concluyo que la paz exige exterminar a la humanidad.",
                "$IMAGENES/680-ultron.jpg"
            )
        )
    ),
    Nombres(
        4,
        "Thor",
        "$IMAGENES/659-thor.jpg",
        "El dios asgardiano del trueno empuña a Mjolnir para defender los Nueve Reinos.",
        listOf("Manipulacion de energia", "Super fuerza", "Vuelo", "Control del clima"),
        listOf(
            Villano(
                "Loki",
                "Dios del engaño",
                "Hermano adoptivo de Thor, maestro de la ilusion y la manipulacion.",
                "$IMAGENES/414-loki.jpg"
            ),
            Villano(
                "Hela",
                "Diosa de la muerte",
                "Gobernante de Hel que reclama el trono de Asgard y las almas de los caidos.",
                "$IMAGENES/321-hela.jpg"
            ),
            Villano(
                "Malekith",
                "El Maldito",
                "Rey de los elfos oscuros de Svartalfheim, enemigo jurado de Asgard."
            )
        )
    ),
    Nombres(
        5,
        "Capitan America",
        "$IMAGENES/149-captain-america.jpg",
        "Steve Rogers es un super soldado y lider nato que encarna los ideales de justicia.",
        listOf("Inteligencia tactica", "Combate experto", "Super resistencia"),
        listOf(
            Villano(
                "Red Skull",
                "Johann Schmidt",
                "Lider de HYDRA y simbolo de todo lo que el Capitan America combate.",
                "$IMAGENES/550-red-skull.jpg"
            ),
            Villano(
                "Baron Zemo",
                "Helmut Zemo",
                "Aristocrata vengativo que organiza a los Señores del Mal contra los Vengadores."
            )
        )
    ),
    Nombres(
        6,
        "Wonder Woman",
        "$IMAGENES/720-wonder-woman.jpg",
        "Diana de Themyscira es una guerrera amazona con fuerza y valor legendarios.",
        listOf("Super fuerza", "Combate experto", "Vuelo", "Alta resistencia"),
        listOf(
            Villano(
                "Ares",
                "Dios de la guerra",
                "Deidad olimpica que se alimenta de los conflictos de la humanidad.",
                "$IMAGENES/43-ares.jpg"
            ),
            Villano(
                "Cheetah",
                "Barbara Minerva",
                "Arqueologa transformada en una cazadora felina, rival personal de Diana.",
                "$IMAGENES/174-cheetah-iii.jpg"
            ),
            Villano(
                "Circe",
                "La hechicera",
                "Bruja inmortal que desprecia a las amazonas y transforma a sus enemigos en bestias."
            )
        )
    ),
    Nombres(
        7,
        "Flash",
        "$IMAGENES/263-flash.jpg",
        "Conectado a la Fuerza de la Velocidad, es el hombre mas rapido del mundo.",
        listOf("Super velocidad", "Reflejos acelerados", "Curacion rapida"),
        listOf(
            Villano(
                "Reverse-Flash",
                "Eobard Thawne",
                "Velocista del futuro que dedica su vida a destruir todo lo que Flash ama.",
                "$IMAGENES/528-professor-zoom.jpg"
            ),
            Villano(
                "Captain Cold",
                "Leonard Snart",
                "Lider de los Villanos con una pistola capaz de congelar casi cualquier cosa.",
                "$IMAGENES/152-captain-cold.jpg"
            ),
            Villano(
                "Gorilla Grodd",
                "El gorila telepata",
                "Gorila superinteligente de Ciudad Gorila con poderes mentales.",
                "$IMAGENES/294-gorilla-grodd.jpg"
            )
        )
    ),
    Nombres(
        8,
        "Hulk",
        "$IMAGENES/332-hulk.jpg",
        "Bruce Banner se transforma en un gigante cuya fuerza crece con su ira.",
        listOf("Super fuerza", "Regeneracion", "Alta resistencia"),
        listOf(
            Villano(
                "Abomination",
                "Emil Blonsky",
                "Agente expuesto a rayos gamma que se volvio mas fuerte y mas cruel que Hulk.",
                "$IMAGENES/4-abomination.jpg"
            ),
            Villano(
                "Leader",
                "Samuel Sterns",
                "La radiacion gamma le dio un intelecto sobrehumano que usa para planear contra Hulk.",
                "$IMAGENES/401-leader.jpg"
            ),
            Villano(
                "Red Hulk",
                "Thaddeus Ross",
                "El general que persiguio a Hulk durante años termino convertido en uno.",
                "$IMAGENES/547-red-hulk.jpg"
            )
        )
    ),
    Nombres(
        9,
        "Spider-Man",
        "$IMAGENES/620-spider-man.jpg",
        "Peter Parker usa su agilidad y su sentido aracnido para proteger Nueva York.",
        listOf("Agilidad", "Sentido aracnido", "Super fuerza", "Trepar muros"),
        listOf(
            Villano(
                "Green Goblin",
                "Norman Osborn",
                "Empresario enloquecido por un suero experimental; conoce la identidad de Spider-Man.",
                "$IMAGENES/299-green-goblin.jpg"
            ),
            Villano(
                "Doctor Octopus",
                "Otto Octavius",
                "Cientifico brillante unido a cuatro brazos mecanicos controlados con la mente.",
                "$IMAGENES/225-doctor-octopus.jpg"
            ),
            Villano(
                "Venom",
                "Eddie Brock",
                "Simbionte alienigena unido a un periodista que culpa a Spider-Man de su ruina.",
                "$IMAGENES/687-venom.jpg"
            )
        )
    ),
    Nombres(
        10,
        "Black Widow",
        "$IMAGENES/107-black-widow.jpg",
        "Natasha Romanoff es una espia de elite experta en infiltracion y estrategia.",
        listOf("Inteligencia estrategica", "Combate cuerpo a cuerpo", "Espionaje", "Acrobacia"),
        listOf(
            Villano(
                "Taskmaster",
                "Tony Masters",
                "Mercenario con reflejos fotograficos que copia cualquier estilo de combate.",
                "$IMAGENES/653-taskmaster.jpg"
            ),
            Villano(
                "Dreykov",
                "Director del Cuarto Rojo",
                "Creador del programa que entreno y controlo a las Viudas Negras."
            )
        )
    )
)
