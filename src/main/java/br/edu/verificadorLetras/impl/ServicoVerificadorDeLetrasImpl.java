package br.edu.verificadorLetras.impl;

import br.edu.verificadorLetras.ServicoVerificadorDeLetras;
import br.edu.verificadorLetras.VerificaLetras;
import br.edu.verificadorLetras.VerificaNumero;

public class ServicoVerificadorDeLetrasImpl implements ServicoVerificadorDeLetras {
    VerificaLetras verificaVogal;
    VerificaLetras verificaConsoante;
    VerificaNumero verificaSeNumero;


    public ServicoVerificadorDeLetrasImpl(VerificaLetras verificaVogal, VerificaLetras verificaConsoante, VerificaNumero verificaSeNumero) {
        this.verificaVogal = verificaVogal;
        this.verificaConsoante = verificaConsoante;
        this.verificaSeNumero = verificaSeNumero;
    }

    public String verifica(String palavra) {
        if (verificaSeNumero.verificaNumero(palavra)) {
            String retorno = "";
            if (verificaVogal.verificaLetra(palavra)){
                retorno = "Vogal";
            }
            if (verificaConsoante.verificaLetra(palavra)){
                retorno = "Consoante";
            }

            return retorno;
        }
        return "Nao e letra";
    }

}
