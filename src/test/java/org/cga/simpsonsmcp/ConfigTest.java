package org.cga.simpsonsmcp;

import org.junit.jupiter.api.Test;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConfigTest {

    private final Config config = new Config();

    @Test
    void restTemplate_ShouldCreateRestTemplateBean() {
        RestTemplate restTemplate = config.restTemplate();
        assertThat(restTemplate).isNotNull();
    }

    @Test
    void simpsonsMCPTools_ShouldCreateToolCallbacksList() {
        SimpsonsService service = new SimpsonsService(new RestTemplate());
        List<ToolCallback> callbacks = config.simpsonsMCPTools(service);
        
        assertThat(callbacks)
            .isNotNull()
            .hasSize(4); // One callback for each @Tool method in SimpsonsService
    }
}