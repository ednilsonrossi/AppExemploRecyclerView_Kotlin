package br.edu.ifsp.appexemplorecyclerview.model

class AlgoImportante {
    companion object {
        private var sequencia: Int = 1;
    }

    //Atributos
    var id: Int = 0
        private set

    init {
        id = sequencia
        sequencia++;
    }
}