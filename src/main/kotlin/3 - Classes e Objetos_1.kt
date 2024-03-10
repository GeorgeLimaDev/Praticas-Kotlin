import java.util.*

// Questão 1
class Produto(var nome: String, var preco: Double) {

    constructor() : this("Produto", 0.0)

    constructor(nome: String) : this(nome, 0.0)

    override fun toString(): String {
        return "Produto(nome='$nome', preco=$preco)"
    }
}

// Questão 2
class Cliente(val nome: String, private val idade: Int) {


    // Utilize os modificadores de visibilidade para definir os atributos nome e idade conforme especificado na questão


    // Crie um método público na classe Cliente chamado mostrarIdade() conforme especificado na questão
    fun mostrarIdade(): Int {
        return this.idade
    }

    override fun toString(): String {
        return "Cliente(nome='$nome', idade=$idade)"
    }
}

// Questão 3
abstract class Personagem(var nome: String) {
    // Crie um método abstrato atacar() conforme especificado na questão
    abstract fun atacar(): String
    override fun toString(): String {
        return "Personagem(nome='$nome')"
    }
}

class Guerreiro(nome: String) : Personagem(nome) {
    override fun atacar(): String {
        // Implemente o método atacar() de acordo com as características do Guerreiro
        return "Personagem $nome ataca com sua Espada!"
    }
}

class Mago(nome: String) : Personagem(nome) {
    override fun atacar(): String {
        // Implemente o método atacar() de acordo com as características do Mago
        return "Personagem $nome ataca com seu feitiço!"
    }
}

// Questão 4
interface FormaGeometrica {
    // Declare um método abstrato calcularArea() conforme especificado na questão
    abstract fun calcularArea(): Double
}

class Retangulo(val altura: Double, val largura: Double) : FormaGeometrica {
    override fun calcularArea(): Double {
        // Implemente o método calcularArea() para o Retangulo conforme especificado na questão
        return altura * largura
    }

    override fun toString(): String {
        return "Retangulo(altura=$altura, largura=$largura)"
    }
}

class Circulo(val raio: Double) : FormaGeometrica {
    override fun calcularArea(): Double {
        // Implemente o método calcularArea() para o Circulo conforme especificado na questão
        return 2 * raio * 3.14
    }

    override fun toString(): String {
        return "Circulo(raio=$raio)"
    }
}

// Questão 5
class ContaBancaria(var numeroConta: String, private var _nomeTitular: String, saldo: Double) {
    var saldo: Double = saldo
        set(value) {
            if (value >= 0) {
                field = value
            } else {
                field = 0.0
            }
        }

    var nomeTitular: String
        get() = _nomeTitular.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        set(value) {
            _nomeTitular = value
        }

    override fun toString(): String {
        return "ContaBancaria(numeroConta='$numeroConta', _nomeTitular='$_nomeTitular', saldo=$saldo, nomeTitular='$nomeTitular')"
    }
}

fun main() {
    // Crie instâncias das diferentes classes Produto utilizando os seus construtores e imprima os detalhes de cada produto.
    val produto1: Produto = Produto()
    val produto2: Produto = Produto("Sabonete")
    val produto3: Produto = Produto("Frigideira",15.0)
    println(produto1.toString())
    println(produto2.toString())
    println(produto3.toString())

    // Crie uma instância de Cliente e chame o método mostrarIdade() para verificar seu funcionamento.
    val cliente1: Cliente = Cliente("Jorgin", 30)
    println(cliente1.mostrarIdade())

    // Crie instâncias de Guerreiro e Mago e chame o método atacar() de cada um para verificar se estão realizando os ataques corretamente de acordo com suas respectivas classes.
    var personagem1: Guerreiro = Guerreiro("Bob")
    var personagem2: Mago = Mago("Presto")
    println(personagem1.atacar())
    println(personagem2.atacar())

    // Crie instâncias dessas duas classes e chame o método calcularArea() em cada uma delas para verificar o resultado.
    val forma1: Retangulo = Retangulo(3.0,3.0)
    val forma2: Circulo = Circulo(5.0)
    println(forma1.calcularArea())
    println(forma2.calcularArea())

    // Crie uma instância de ContaBancaria. Altere o nome do titular para uma string que inicie com letra minúscula e mude o saldo para um valor negativo. Imprima os valores para verificar se as regras dos getters e setters estão sendo aplicadas corretamente.
    val conta = ContaBancaria("123456", "João", 100.0)
    conta.nomeTitular = "joao"
    conta.saldo = -50.0
    println("Número da Conta: ${conta.numeroConta}")
    println("Nome do Titular: ${conta.nomeTitular}")
    println("Saldo: ${conta.saldo}")
}
