data class Jogo(val titulo:String, val capa:String) {

    val descricao = ""

    override fun toString(): String {
        return "Jogo:\n" +
                "titulo: $titulo\n" +
                "Capa: $capa\n" +
                "Descricao: $descricao"
    }

}