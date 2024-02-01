// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val name: String, val id: Int, val password: String)

data class ConteudoEducacional(var nome: String, val duracaoHoras: Int = 1, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun getListMatricula() : MutableList<Usuario>{
            return inscritos
        }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)

        TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    }
}

fun main() {

    val bkKotlin = Formacao("Backend Kotlin", listOf(
        ConteudoEducacional("Fundamentos em Kotlin", 3, Nivel.BASICO),
        ConteudoEducacional("Funções em Kotlin", 3, Nivel.INTERMEDIARIO),
        ConteudoEducacional("Manipulação de Dados em Kotlin", 3, Nivel.DIFICIL)))
    ))

    println(bkKotlin.conteudos)

    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
