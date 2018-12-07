package com.example.service.integration;

import com.example.demo.DemoApplication;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.model.Manga;
import com.example.service.MangaService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class MangaServiceIntegrationTest {
    @Autowired
    private MangaService mangaService;
    @Test
    public void testGetMangasByTitle() {
           List<Manga> mangasByTitle = mangaService.getMangasByTitle("ken");
           assertThat(mangasByTitle).isNotNull().isNotEmpty();
    }
}
