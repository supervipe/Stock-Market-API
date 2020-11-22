package unifor.com.B3TCH.Controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import unifor.com.B3TCH.Model.Scrip;
import unifor.com.B3TCH.Services.ScripService;

import java.util.Arrays;
import java.util.Date;

@RestController
@RequestMapping("/scrip/ticker")
public class ScripController {

    public ScripService scripService;
    RestTemplate restTemplate;

    public ScripController() {
    }

    @PutMapping
    public Scrip updateScrip(String ticker, double priceToday, double percentageToday, Date dateToday, int quantity) {
        return this.scripService.updateScrip(ticker,priceToday,percentageToday,dateToday,quantity);
    }

    @GetMapping("/{ticker}")
    public @ResponseBody String testclient(@PathVariable(value = "ticker") String ticker) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String url = "https://api.hgbrasil.com/finance/stock_price?key=34664454&symbol=" + ticker;
        System.out.println(url);
        String result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
        return (result);
    }
}
