package com.monaco.supplier.functions;

import com.monaco.supplier.model.ServiceMonaco;
import com.monaco.supplier.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Supplier;

@Configuration
@Slf4j
public class Suppliers {

    private static final String TAG = "tag";
    private static final String DISABLED = "DISABLED";
    private static final String ACTIVE = "ACTIVE";

    @Bean
    public Supplier<ServiceMonaco> rabbitSupplier() {
        return () -> {
            int tagNumber = Utils.getRandom(99);
            String tag = TAG + tagNumber;
            String action = DISABLED;
            if (tagNumber % 2 == 0) {
                action = ACTIVE;
            }
            ServiceMonaco service = new ServiceMonaco(tag,action);
            log.info("Supplier send: {}", service);
            return service;
        };
    }
}
