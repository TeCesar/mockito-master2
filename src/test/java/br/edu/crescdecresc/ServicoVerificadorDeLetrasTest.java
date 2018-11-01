package br.edu.crescdecresc;

import br.edu.verificadorLetras.ServicoVerificadorDeLetras;
import br.edu.verificadorLetras.VerificaLetras;
import br.edu.verificadorLetras.VerificaNumero;
import br.edu.verificadorLetras.impl.ServicoVerificadorDeLetrasImpl;
import br.edu.verificadorLetras.impl.VerificaConsoante;
import br.edu.verificadorLetras.impl.VerificaVogal;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class ServicoVerificadorDeLetrasTest {

    ServicoVerificadorDeLetras servicoVerificadorDeLetras;

    @Test
    public void verificarLetraInputNumerico() {
        VerificaNumero verificaSeNumero = Mockito.mock(VerificaNumero.class);
        Mockito.when(verificaSeNumero.verificaNumero(Mockito.anyString())).thenReturn(false);

        VerificaLetras verificaVogal = new VerificaVogal();
        VerificaLetras verificaConsoante = new VerificaConsoante();

        servicoVerificadorDeLetras = new ServicoVerificadorDeLetrasImpl(verificaVogal, verificaConsoante, verificaSeNumero);
        assertEquals("Nao e letra", servicoVerificadorDeLetras.verifica("e".toUpperCase()));
    }

    @Test
    public void verificarLetraInputLiteral_vogal() {
        VerificaNumero verificaSeNumero = Mockito.mock(VerificaNumero.class);
        Mockito.when(verificaSeNumero.verificaNumero(Mockito.anyString())).thenReturn(true);

        VerificaLetras verificaVogal = Mockito.mock(VerificaLetras.class);
        Mockito.when(verificaVogal.verificaLetra(Mockito.anyString())).thenReturn(true);

        VerificaLetras verificaConsoante = Mockito.mock(VerificaLetras.class);
        Mockito.when(verificaConsoante.verificaLetra(Mockito.anyString())).thenReturn(false);

        servicoVerificadorDeLetras = new ServicoVerificadorDeLetrasImpl(verificaVogal, verificaConsoante, verificaSeNumero);
        assertEquals("Vogal", servicoVerificadorDeLetras.verifica("e".toUpperCase()));
    }


    @Test
    public void verificarLetraInputLiteral_consoante() {
        VerificaNumero verificaSeNumero = Mockito.mock(VerificaNumero.class);
        Mockito.when(verificaSeNumero.verificaNumero(Mockito.anyString())).thenReturn(true);

        VerificaLetras verificaVogal = Mockito.mock(VerificaLetras.class);
        Mockito.when(verificaVogal.verificaLetra(Mockito.anyString())).thenReturn(false);

        VerificaLetras verificaConsoante = Mockito.mock(VerificaLetras.class);
        Mockito.when(verificaConsoante.verificaLetra(Mockito.anyString())).thenReturn(true);

        servicoVerificadorDeLetras = new ServicoVerificadorDeLetrasImpl(verificaVogal, verificaConsoante, verificaSeNumero);
        assertEquals("Consoante", servicoVerificadorDeLetras.verifica("e".toUpperCase()));
    }


}
