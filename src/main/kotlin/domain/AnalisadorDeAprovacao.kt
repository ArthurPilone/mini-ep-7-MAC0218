package domain

import domain.criterios.CriterioDeAprovacao
import domain.Boletim
import domain.BoletimFechado

class AnalisadorDeAprovacao {

    private lateinit var meuCriterio: CriterioDeAprovacao

    fun defineCriterio(criterio: CriterioDeAprovacao) {
        meuCriterio = criterio
    }

    fun fechaBoletim(boletim: Boletim): BoletimFechado {
        if(::meuCriterio.isInitialized){
            return BoletimFechado(boletim.mediaEPs, boletim.mediaMiniEPs,
                                  meuCriterio.mediaFinal(boletim),
                                  meuCriterio.estaAprovado(boletim))
        }else{
            throw Exception("Tentativa de fechar boletim antes de definir critério")
        }
    }

}