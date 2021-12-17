package com.monaco.supplier.functions;

import com.monaco.supplier.model.ServiceMonaco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuppliersTests {

    private final Suppliers suppliers = new Suppliers();

    @Test
    void testRabbitSupplier() {
        assertTrue(suppliers.rabbitSupplier().get() instanceof ServiceMonaco);
    }

}
