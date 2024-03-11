/** SISTEMA DE REGISTROS DE FUNCIONÁRIOS
 *
 * Desenvolva um sistema de registro de funcionários para uma empresa.
 * O sistema deverá permitir registrar diferentes tipos de funcionários e apresentar suas informações.
 *
 * Alguns passos abaixo:
 *
 * 1.Crie uma classe base chamada Funcionario com as seguintes propriedades:
 * - Nome (string): o nome do funcionário.
 * - Idade (int): a idade do funcionário.
 *
 * 2.Crie uma classe Gerente que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Setor (string): o setor em que o gerente trabalha.
 *
 * 3.Crie uma classe Desenvolvedor que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Linguagem (string): a linguagem de programação que o desenvolvedor utiliza.
 *
 * 4.Crie uma classe Analista que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Area (string): a área de especialização do analista.
 *
 * 5.Imprima uma mensagem informando que um novo funcionário foi registrado, juntamente com o nome e a idade do
 * funcionário. (Lembre-se do init)
 *
 * 6. Crie um método na classe Funcionario chamado Apresentar que imprima uma mensagem de apresentação do funcionário,
 * incluindo o nome e a idade.
 *
 * 7. Crie uma lista de funcionários e adicione diferentes tipos de funcionários (gerentes, desenvolvedores e analistas)
 * à lista.
 *
 * 8. Utilize o typecast (is e as) para verificar o tipo de cada funcionário na lista e chamar o método Apresentar
 * correspondente.
 */

open class Funcionario(var nome: String, var idade: Int) {
    init {
        println("Novo funcionário criado: $nome, $idade anos")
    }

    open fun apresentar(): String {
        return "$nome, $idade anos"
    }
    override fun toString(): String {
        return "Nome: $nome, Idade: $idade"
    }
}

class Gerente(var setor: String, nome: String, idade: Int): Funcionario(nome, idade) {
    override fun apresentar(): String {
        return "Apresentando o Gerente $this"
    }
}

class Desenvolvedor(var linguagem: String, nome: String, idade: Int): Funcionario(nome, idade) {
    override fun apresentar(): String {
        return "Apresentando o Dev $this"
    }
}

class Analista(var area: String, nome: String, idade: Int): Funcionario(nome, idade) {
    override fun apresentar(): String {
        return "Apresentando o Analista $this"
    }
}

fun main() {
    val func1: Funcionario = Funcionario("George", 30)
    val func2: Funcionario = Gerente("Comercial", "João", 40)
    val func3: Funcionario = Desenvolvedor("Kotlin", "José", 25)
    val func4: Funcionario = Analista("Recursos Humanos", "Kléber", 50)

    var listaFuncionarios = mutableListOf(func1, func2, func3, func4)

    for (funcionario in listaFuncionarios) {
        when(funcionario) {
            is Gerente -> println(funcionario.apresentar())
            is Desenvolvedor -> println(funcionario.apresentar())
            is Analista -> println(funcionario.apresentar())
            else -> println("Apresentando o faz tudo: ${funcionario.apresentar()}")
        }
    }
}
