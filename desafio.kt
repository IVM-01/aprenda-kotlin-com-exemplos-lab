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

    /*
    Nesse exemplo crio dois cursos onde o João se candidata em dois,
    A Maria e o Pedro em um,
    Porém o Pedro erra no cadastro e deixa a senha em branco.
    * */

    val bkKotlin = Formacao("Backend Kotlin", listOf(
        ConteudoEducacional("Fundamentos em Kotlin", 3, Nivel.BASICO),
        ConteudoEducacional("Funções em Kotlin", 2, Nivel.INTERMEDIARIO),
        ConteudoEducacional("Manipulação de Dados em Kotlin", 4, Nivel.DIFICIL)
    ))

    val bkJava = Formacao("Backend Java", listOf(
        ConteudoEducacional("Fundamentos em Java", 3, Nivel.BASICO),
        ConteudoEducacional("Funções em Java", 3, Nivel.INTERMEDIARIO),
        ConteudoEducacional("Manipulação de Dados em Java", 5, Nivel.DIFICIL)
    ))

    val joao = try{ Usuario("joaoPlay", Identifier.add(1), "12345")} catch (e : Exception){ throw NullPointerException("Nome ou senha de usuário vazio") }
    val maria = try{ Usuario("mariaBonita", Identifier.add(2), "04052001")} catch (e : Exception){ throw NullPointerException("Nome ou senha de usuário vazio") }
    //val pedro = try{ Usuario("pedroBr", Identifier.add(3), null)} catch (e : Throwable){ throw NullPointerException("Nome ou senha de usuário vazio") }

    joao.matricular(bkKotlin)
    maria.matricular(bkKotlin)
    //pedro.matricular(bkKotlin)

    joao.matricular(bkJava)

    println(bkKotlin.getListMatricula())
    println(bkJava.getListMatricula())
    println(joao)
    println(maria)
    //println(pedro)
}
