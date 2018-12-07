package com.example.service;

import com.example.model.Manga;
import com.example.model.MangaResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MangaService {
    
    private static final String MANGA_SEARCH_URL="http://api.jikan.moe/search/manga/";
    
    @Autowired
    RestTemplate restTemplate;
    
    public List<Manga> getMangasByTitle(String title) {
        return restTemplate.getForEntity(MANGA_SEARCH_URL+title, MangaResult.class).getBody().getResult();
    }

}
