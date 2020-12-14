package unifor.com.B3TCH.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import unifor.com.B3TCH.Model.Scrip;
import unifor.com.B3TCH.Services.ScripService;
import unifor.com.B3TCH.Services.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/scrip")
public class ScripController {

    private final ScripService scripService;
    private final UserService userService;

    public ScripController(UserService userService, ScripService scripService) {
        this.userService = userService;
        this.scripService = scripService;
    }

    @PatchMapping("/{id}/ticker/{ticker}/quantity/{quant}")
    public Scrip updateScrip(@PathVariable(value = "id") int id,@PathVariable(value = "ticker") String ticker,@PathVariable(value = "quant") int quantity) throws JsonProcessingException {
        Scrip s = getScripAPI(ticker,quantity);
        return this.scripService.updateScrip(id,ticker,s.getPriceToday(),s.getPercentageToday(),s.getDateToday(),quantity);
    }

    @GetMapping("/{ticker}/{quant}")
    public Scrip getScripAPI(@PathVariable(value = "ticker") String ticker,@PathVariable(value = "quant") int quant) throws JsonProcessingException {

        final String url = "https://api.hgbrasil.com/finance/stock_price?key=34664454&symbol=" + ticker;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        //int quantity = Integer.parseInt(quant);
        Map<String, Map<String, Map<String,Object>>> r = new ObjectMapper().readValue(result, HashMap.class);
        String name = r.get("results").get(ticker.toUpperCase()).get("name").toString();
        String pri = r.get("results").get(ticker.toUpperCase()).get("price").toString();
        double price = Double.parseDouble(pri);
        String perc = r.get("results").get(ticker.toUpperCase()).get("change_percent").toString();
        double percent = Double.parseDouble(perc);
        String date = r.get("results").get(ticker.toUpperCase()).get("updated_at").toString();

        Scrip scrip = new Scrip(name,ticker,price,price,percent,percent,date,date,quant);
        return scrip;
    }


    @GetMapping("/{id}")
    public List<Scrip> scripList(@PathVariable(value = "id") int id) {
        return this.userService.scripList(id);
    }

    @GetMapping("/{id}/ticker/{ticker}")
    public Optional<Scrip> getScrip(@PathVariable(value = "ticker") String ticker,@PathVariable(value = "id") int id){
        return this.userService.getScrip(id,ticker);
    }

    @PostMapping("/{id}/add/{ticker}/quantity/{quant}")
    public List<Scrip> addScrip(@PathVariable(value = "id") int id,@PathVariable(value = "ticker") String ticker,@PathVariable(value = "quant") int quant) throws JsonProcessingException {
        Scrip s = getScripAPI(ticker,quant);
        return this.userService.addScrip(id,s);
    }

    @DeleteMapping(value = "/{id}/remove/{ticker}")
    public List<Scrip> removeScrip(@PathVariable(value = "id") int id,@PathVariable(value = "ticker") String ticker){
        return this.userService.removeScrip(id,ticker);
    }
}
