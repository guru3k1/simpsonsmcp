package org.cga.simpsonsmcp;

import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class Config {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public List<ToolCallback> simpsonsMCPTools(SimpsonsService service){
        return List.of(ToolCallbacks.from(service));
    }
}
