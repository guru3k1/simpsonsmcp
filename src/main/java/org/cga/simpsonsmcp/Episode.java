package org.cga.simpsonsmcp;

public record Episode(String title, String description, String release_date, int season, int episode, boolean good,
                      String disneyplus_id, String simpsonsworld_id, String disneyplus_url, String simpsonsworld_url,
                      String frinkiac_url){
}
