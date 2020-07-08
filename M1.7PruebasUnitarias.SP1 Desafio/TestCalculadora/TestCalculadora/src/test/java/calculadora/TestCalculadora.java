package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import calculadora.Calculadora;

/**
 * Unit test for simple App.
 */
@DisplayName ("Test Suma")
public class TestCalculadora 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void sumarTest()
    {
        Calculadora calculadora = new Calculadora();
        assertEquals(4 ,calculadora.sumar(2, 2));
        
    }
    
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testRestar()
    {
        Calculadora calculadora = new Calculadora();
        assertEquals(0 ,calculadora.restar(2, 2));
    }
    
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testMultiplicar()
    {
        Calculadora calculadora = new Calculadora();
        assertEquals(4 ,calculadora.multiplicar(2, 2));
        assertEquals(0 ,calculadora.multiplicar(0, 2));
    }
    
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testDividir()
    {
        Calculadora calculadora = new Calculadora();
        assertEquals(1 ,calculadora.dividir(2, 2));
        assertEquals(null ,calculadora.dividir(2, 0));
    }
    

    
    
}
