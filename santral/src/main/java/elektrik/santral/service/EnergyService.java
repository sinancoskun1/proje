package elektrik.santral.service;

import elektrik.santral.entity.Titles;
import elektrik.santral.repository.EnergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EnergyService {

    @Autowired
    private EnergyRepository energyRepository;

    @Autowired
    private AppService appService;


    public void saveTitles(String date) {
        try {
            List<Titles> titles = appService.getTitlesData(date);
            if (!CollectionUtils.isEmpty(titles)) {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                titles.stream().forEach(t -> {
                    try {
                        t.setTarih(df.parse(date + " " + t.getSaatAdi() + ":00"));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            energyRepository.saveAll(titles); // Veriyi veritabanına kaydet
        } catch (IOException e) {
            e.printStackTrace(); // Hata işleme
        }
    }

    public List<Titles> getAllTitles(String date) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = AppService.appUrl+date;
        ResponseEntity<Titles[]> response = restTemplate.getForEntity(apiUrl, Titles[].class);
        Titles[] titles = response.getBody();
        return Arrays.asList(titles);
    }

    public Optional<Titles> getTitles(Long santralId, String saatAdi) {
        return energyRepository.findBySantralIdAndSaatAdi(santralId, saatAdi);
    }

}