package br.edu.verificadorLetras.impl;

import br.edu.verificadorLetras.VerificaLetras;

public class VerificaVogal implements VerificaLetras {

    public boolean verificaLetra(String palavra) {
        if (palavra.charAt(0) == 'A' || palavra.charAt(0) == 'E' || palavra.charAt(0) == 'I' || palavra.charAt(0) == 'O' || palavra.charAt(0) == 'U') {
            return true;
        }
        return false;
    }
}

