package br.edu.verificadorLetras.impl;

import br.edu.verificadorLetras.VerificaNumero;

public class VerificaSeNumero implements VerificaNumero {

    public boolean verificaNumero(String palavra) {
        if (!Character.isDigit(palavra.charAt(0))) {
            return true;
        }
        return false;
    }
}
