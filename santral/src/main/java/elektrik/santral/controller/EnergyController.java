package elektrik.santral.controller;


import elektrik.santral.entity.Titles;
import elektrik.santral.service.AppService;
import elektrik.santral.service.EnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
public class EnergyController {
    @Autowired
    private EnergyService energyService;
    @Autowired
    private AppService appService;

    @GetMapping("/import")
    public String importTitles(@RequestParam String date) {
        energyService.saveTitles(date);
        return "imported successfully!";
    }
    @GetMapping("/deneme")
    public List<Titles> getAllTitles (@RequestParam String date){
       return energyService.getAllTitles(date);

    }
    @GetMapping("/{santralId}/{saatAdi}")
    public Optional<Titles> getTitles(@PathVariable Long santralId, @PathVariable String saatAdi) {
        return energyService.getTitles(santralId, saatAdi);
    }

}



