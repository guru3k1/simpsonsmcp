package org.cga.simpsonsmcp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SimpsonsServiceTest {

    @Mock
    private RestTemplate restTemplate;

    private SimpsonsService simpsonsService;

    @BeforeEach
    void setUp() {
        simpsonsService = new SimpsonsService(restTemplate);
    }

    @Test
    void getARandomGoodEpisode_ShouldReturnEpisode() {
        // Arrange
        Episode expectedEpisode = new Episode(
            "Test Episode", "Description", "2024-01-01", 
            1, 1, true, "dp1", "sw1", 
            "http://disney.com", "http://simpsonsworld.com", "http://frinkiac.com"
        );
        when(restTemplate.getForObject(
            "https://www.simpsonsoptimizer.com/episodes/good/", 
            Episode.class
        )).thenReturn(expectedEpisode);

        // Act
        Episode result = simpsonsService.getARandomGoodEpisode();

        // Assert
        assertThat(result).isNotNull()
            .isEqualTo(expectedEpisode);
    }

    @Test
    void getSelectedEpisode_ShouldReturnSpecificEpisode() {
        // Arrange
        int season = 1;
        int episodeNum = 2;
        Episode expectedEpisode = new Episode(
            "Selected Episode", "Description", "2024-01-02", 
            season, episodeNum, true, "dp2", "sw2", 
            "http://disney.com/s1e2", "http://simpsonsworld.com/s1e2", "http://frinkiac.com/s1e2"
        );
        when(restTemplate.getForObject(
            String.format("https://www.simpsonsoptimizer.com/episodes/s/%d/e/%d/", season, episodeNum),
            Episode.class
        )).thenReturn(expectedEpisode);

        // Act
        Episode result = simpsonsService.getSelectedEpisode(season, episodeNum);

        // Assert
        assertThat(result).isNotNull()
            .isEqualTo(expectedEpisode);
    }

    @Test
    void getSeasonEpisodes_ShouldReturnArrayOfEpisodes() {
        // Arrange
        int season = 1;
        Episode[] expectedEpisodes = new Episode[]{
            new Episode("Episode 1", "Desc 1", "2024-01-01", 1, 1, true, "dp1", "sw1", 
                       "http://disney.com/1", "http://simpsonsworld.com/1", "http://frinkiac.com/1"),
            new Episode("Episode 2", "Desc 2", "2024-01-02", 1, 2, false, "dp2", "sw2", 
                       "http://disney.com/2", "http://simpsonsworld.com/2", "http://frinkiac.com/2")
        };
        when(restTemplate.getForObject(
            String.format("https://www.simpsonsoptimizer.com/episodes/s/%d/", season),
            Episode[].class
        )).thenReturn(expectedEpisodes);

        // Act
        Episode[] result = simpsonsService.getSeasonEpisodes(season);

        // Assert
        assertThat(result).isNotNull()
            .hasSize(2)
            .containsExactly(expectedEpisodes);
    }

    @Test
    void getSimpsonsRandomQuote_ShouldReturnQuote() {
        // Arrange
        Quote[] quotes = new Quote[]{
            new Quote("Test quote", "Homer Simpson", "http://image.com", "left")
        };
        when(restTemplate.getForObject(
            "https://thesimpsonsquoteapi.glitch.me/quotes",
            Quote[].class
        )).thenReturn(quotes);

        // Act
        Quote result = simpsonsService.getSimpsonsRandomQuote();

        // Assert
        assertThat(result).isNotNull()
            .isEqualTo(quotes[0]);
    }
}