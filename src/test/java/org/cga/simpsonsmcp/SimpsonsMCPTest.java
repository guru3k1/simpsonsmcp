package org.cga.simpsonsmcp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestConstructor;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SimpsonsMCPTest {

    private final ApplicationContext applicationContext;

    SimpsonsMCPTest(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Test
    void contextLoads() {
        assertThat(applicationContext).isNotNull();
        assertThat(applicationContext.getBean(SimpsonsService.class)).isNotNull();
        assertThat(applicationContext.getBean(Config.class)).isNotNull();
    }
}