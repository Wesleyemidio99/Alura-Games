import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner

fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar:")
    val busca = leitura.nextLine()
    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder().uri(URI.create(endereco)).build()
    val response = client.send(request, BodyHandlers.ofString())
    val json = response.body()
    println(json)

    val gson = Gson()

//    try {
//        val meuInfoJogo = gson.fromJson(json,InfoJogo::class.java)
//        val meuJogo = Jogo(meuInfoJogo.info.title,meuInfoJogo.info.thumb)
//        println(meuJogo)
//
//    }catch (ex: JsonSyntaxException){
//        println("Jogo inexistente, tente outro id.")
//    }


    var meuJogo:Jogo? = null

    // Caso o id seja encontrado, é guardado um secesso dentro da variavel
    val resultado = runCatching {
        val meuInfoJogo = gson.fromJson(json,InfoJogo::class.java)
        meuJogo = Jogo(meuInfoJogo.info.title,meuInfoJogo.info.thumb)
        println(meuJogo)
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
    }

}