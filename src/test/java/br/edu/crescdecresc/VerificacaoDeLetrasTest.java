package br.edu.crescdecresc;

import br.edu.verificadorLetras.ServicoVerificadorDeLetras;
import br.edu.verificadorLetras.VerificaLetras;
import br.edu.verificadorLetras.VerificaNumero;
import br.edu.verificadorLetras.impl.ServicoVerificadorDeLetrasImpl;
import br.edu.verificadorLetras.impl.VerificaConsoante;
import br.edu.verificadorLetras.impl.VerificaSeNumero;
import br.edu.verificadorLetras.impl.VerificaVogal;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VerificacaoDeLetrasTest {

    VerificaNumero verificaNumero;
    VerificaLetras verificaVogal;
    VerificaLetras verificaConsoante;
    ServicoVerificadorDeLetras servicoVerificadorDeLetras;

    @Before
    public void setUp(){
        verificaNumero = new VerificaSeNumero();
        verificaVogal = new VerificaVogal();
        verificaConsoante = new VerificaConsoante();
        servicoVerificadorDeLetras = new ServicoVerificadorDeLetrasImpl(verificaVogal, verificaConsoante, verificaNumero);
    }

    @Test
    public void verificaSeVogalTest(){
        assertTrue(verificaVogal.verificaLetra("e".toUpperCase()));
    }

    @Test
    public void verificaSeNaoVogalTest(){
        assertFalse(verificaVogal.verificaLetra("t".toUpperCase()));
    }

    @Test
    public void verificaSeConsoanteTest(){
        assertTrue(verificaConsoante.verificaLetra("t".toUpperCase()));
    }

    @Test
    public void verificaSeNaoConsoanteTest(){
        assertFalse(verificaConsoante.verificaLetra("e".toUpperCase()));
    }

    @Test
    public void verificaSeNumeroTest(){
        assertTrue(verificaNumero.verificaNumero("a".toUpperCase()));
    }

    @Test
    public void verificaSeNaoNumeroTest(){
        assertFalse(verificaNumero.verificaNumero("1".toUpperCase()));
    }

    @Test
    public void verificaSeVogalServicoTest(){
        assertEquals("Vogal", servicoVerificadorDeLetras.verifica("a".toUpperCase()));
    }

    @Test
    public void verificaSeConsoanteServicoTest(){
        assertEquals("Consoante", servicoVerificadorDeLetras.verifica("b".toUpperCase()));
    }

    @Test
    public void verificaSeNumeroServicoTest(){
        assertEquals("Nao e letra", servicoVerificadorDeLetras.verifica("1".toUpperCase()));
    }
}
