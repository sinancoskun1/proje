package elektrik.santral.service;

import elektrik.santral.entity.Titles;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

@Service
public class AppService {
    public static String appUrl = "http://10.199.70.16/getGunlukSantralElektrikUretimleri?gecerlilikTrh=";
    public List<Titles> getTitlesData(String date) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl =appUrl + date;
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonResponse, new TypeReference<List<Titles>>() {});
    }
}
