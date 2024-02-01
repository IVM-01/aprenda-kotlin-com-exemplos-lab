// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

//Gerador de Ids
object Identifier{

    val id : MutableSet<Int> = mutableSetOf()

    fun add(id : Int) : Int{
        return if(this.id.contains(id)) {throw ClassCastException("Id de usuário existente, atribua outro")}
        else{this.id.add(id)
            id
        }
    }
}

data class Usuario(val name: String, val id: Int, private val password: String, var formacao : MutableList<String> = mutableListOf())

data class ConteudoEducacional(var nome: String, val duracaoHoras: Int = 1, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Usuario>()

    fun getListMatricula(): MutableList<Usuario>{
        return inscritos
    }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}
//Função que engloba a matricula em Formacao e Usuario
fun Usuario.matricular(formacao: Formacao) {
    formacao.matricular(this)
    this.formacao.add(formacao.nome)
}

fun main() {

    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
