package org.cga.simpsonsmcp;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SimpsonsService {

    private final RestTemplate restTemplate;

    public SimpsonsService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Tool(name="Get_a_Simpsons_random_good_episode", description = "Call to api that will provide a random episode cataloged as good. " +
            "Also it will provide details like release date, season, episode, title, description, disneyplus_id, simpsonsworld_id, good(boolean for quality status), " +
            "disneyplus_url, simpsonsworld_url and frinkiac_url for the episode. Disney plus url will open the episode(requires a Disney+ active account")
    public Episode getARandomGoodEpisode(){
        return restTemplate.getForObject("https://www.simpsonsoptimizer.com/episodes/good/", Episode.class);
    }

    @Tool(name="Get_Simsons_episode", description = "Call to api that will provide selected episode. Requires season number and episode number" +
            "Also it will provide details like release date, season, episode, title, description, disneyplus_id, simpsonsworld_id, good(boolean for quality status), " +
            "disneyplus_url, simpsonsworld_url and frinkiac_url for the episode. Disney plus url will open the episode(requires a Disney+ active account")
    public Episode getSelectedEpisode(int season, int episode){
        return restTemplate.getForObject(String.format("https://www.simpsonsoptimizer.com/episodes/s/%d/e/%d/",season,episode), Episode.class);
    }

    @Tool(name="Get_Simpsons_seasons_episodes", description = "Call to api that will provide a list with all the episodes from season. Requires season number" +
            "Also it will provide episode details like release date, season, episode, title, description, disneyplus_id, simpsonsworld_id, good(boolean for quality status), " +
            "disneyplus_url, simpsonsworld_url and frinkiac_url for the episode. Disney plus url will open the episode(requires a Disney+ active account")
    public Episode[] getSeasonEpisodes(int season){
        return restTemplate.getForObject(String.format("https://www.simpsonsoptimizer.com/episodes/s/%d/",season), Episode[].class);
    }

    @Tool(name="Get_Simpsons_random_quote", description = "Call to api that will provide a random quote from a simpsons character." +
            "Besides the quote it will provide character name, image from character and characterDirection")
    public Quote getSimpsonsRandomQuote(){
        return (restTemplate.getForObject("https://thesimpsonsquoteapi.glitch.me/quotes", Quote[].class))[0];
    }
}
