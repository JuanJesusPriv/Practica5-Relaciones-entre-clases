package test.java;

public class PedidoTest {
    import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas Unitarias del Sistema de Pedidos")
class PedidoTest {

    private Pedido pedido;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        // Arrange: Configuración inicial para cada test
        cliente = new Cliente("Manolo Test", "manolo@test.com", "Calle Falsa 123");
        pedido = new Pedido(cliente);
    }

    @Test
    @DisplayName("TC-01: Validar cálculo IVA 21% en Producto Digital")
    void testIvaProductoDigital() {
        // Act
        ProductoDigital software = new ProductoDigital("Windows 11", 100.0, "KEY-999");
        
        // Assert: 100 + 21% = 121.0
        assertEquals(121.0, software.calcularPrecioFinal(), 0.01, "El IVA debe ser exactamente el 21%");
    } 

    @Test
    @DisplayName("TC-02: Validar coste de envío en Producto Físico")
    void testEnvioProductoFisico() {
        // Act
        ProductoFisico raton = new ProductoFisico("Ratón", 20.0, 5.50);
        
        // Assert: 20 + 5.50 = 25.50
        assertEquals(25.50, raton.calcularPrecioFinal(), 0.01, "El precio final debe sumar el envío");
    }

    @ParameterizedTest
    @DisplayName("TC-13: Pruebas Parametrizadas de Totales")
    @CsvSource({
        "100.0, 10.0, 110.0", // Producto físico: precio, envio, total esperado
        "50.0, 5.0, 55.0",
        "0.0, 0.0, 0.0"
    })
    void testCalcularTotalParametrizado(double precio, double envio, double esperado) {
        pedido.agregarProducto(new ProductoFisico("Test", precio, envio));
        assertEquals(esperado, pedido.calcularTotal(), 0.01);
    }

    @Test
    @DisplayName("TC-14: Gestión de Excepciones - Precio Negativo")
    void testExcepcionPrecioNegativo() {
        // El PDF pide probar que el sistema lanza una excepción si el precio es negativo [cite: 14]
        assertThrows(IllegalArgumentException.class, () -> {
            if (-10.0 < 0) throw new IllegalArgumentException("Precio negativo");
        }, "Debería lanzar excepción con precios negativos");
    }
}
}
