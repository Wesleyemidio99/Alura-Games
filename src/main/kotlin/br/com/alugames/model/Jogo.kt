package br.com.alugames.model

data class Jogo(val titulo:String, val capa:String) {

    var descricao:String? = null

    override fun toString(): String {
        return "br.com.alugames.model.Jogo:\n" +
                "titulo: $titulo\n" +
                "Capa: $capa\n" +
                "Descricao: $descricao"
    }

}