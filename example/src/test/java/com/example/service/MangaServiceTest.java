package com.example.service;

import com.example.demo.DemoApplication;
import com.example.model.Manga;
import com.example.model.MangaResult;
import com.example.utils.JsonUtils;
import java.io.IOException;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class MangaServiceTest {
    
    @Autowired
    private MangaService mangaService;
    
    @MockBean
    private RestTemplate template;
    
    @Test
    public void testGetMangasByTitle() throws IOException {
        // Parsing mock file
        MangaResult mRs = JsonUtils.jsonFile2Object("ken.json", MangaResult.class);
        // Mocking remote service
        when(template.getForEntity(any(String.class), any(Class.class))).thenReturn(new ResponseEntity(mRs, HttpStatus.OK));
        // I search for goku but system will use mocked response containing only ken, so I can check that mock is used.
        List<Manga> mangasByTitle = mangaService.getMangasByTitle("goku");
        assertThat(mangasByTitle).isNotNull()
            .isNotEmpty()
            .allMatch(p -> p.getTitle()
                .toLowerCase()
                .contains("ken"));
    }
}
