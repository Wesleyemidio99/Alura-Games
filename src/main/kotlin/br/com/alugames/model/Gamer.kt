package br.com.alugames.model

data class Gamer(val nome:String, val email:String){
    var dataNascimento:String? = null
    var usuario:String? = null
    val idInterno:Int? = null

    constructor(nome: String, email:String,dataNascimento:String, usuario:String):this(nome,email){
        this.dataNascimento = dataNascimento
        this.usuario = usuario
    }
    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

}
