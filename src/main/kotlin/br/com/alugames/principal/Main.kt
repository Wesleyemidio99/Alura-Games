package br.com.alugames.principal

import br.com.alugames.model.Jogo
import br.com.alugames.service.ConsumoApi
import java.util.*

fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar:")
    val idJogo = leitura.nextLine()

    val buscaJogo = ConsumoApi().buscaJogoPorId(idJogo)

    var meuJogo:Jogo? = null

    // Caso o id seja encontrado, é guardado um secesso dentro da variavel
    val resultado = runCatching {
        meuJogo = Jogo(buscaJogo.info.title,buscaJogo.info.thumb)
    }

    //Verifica se houve falha dentro de resultado
    resultado.onFailure {
        println("Jogo inexistente, tente outro id.")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição ao jogo? S/N")
        val opcao = leitura.nextLine()
        if (opcao.equals("s",true)) {
            println("Digite a descricao do jogo: ")
            val descricaoPersonalizado = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizado

        }else{
            meuJogo?.descricao = meuJogo?.titulo
        }
        println(meuJogo)
    }

    resultado.onSuccess { println("Busca realizada com sucesso!") }

    leitura.close()
}