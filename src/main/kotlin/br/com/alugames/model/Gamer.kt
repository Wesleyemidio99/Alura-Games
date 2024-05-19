package br.com.alugames.model

data class Gamer(val nome:String, val email:String){
    var dataNascimento:String? = null
    var usuario:String? = null
    var idInterno:String? = null

    constructor(nome: String, email:String,dataNascimento:String, usuario:String):this(nome,email){
        this.dataNascimento = dataNascimento
        this.usuario = usuario
    }
    override fun toString(): String {
        return "Usuario:\n" +
                "Nome: $nome\n" +
                "Email: $email\n" +
                "DataNascimento: $dataNascimento\n" +
                "Usuario: $usuario\n" +
                "IdInterno: $idInterno"
    }

}
