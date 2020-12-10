package unifor.com.B3TCH.Services;

import org.springframework.stereotype.Service;
import unifor.com.B3TCH.Model.Scrip;
import unifor.com.B3TCH.Repository.ScripRepository;

import java.util.Optional;

@Service
public class ScripService {

    private ScripRepository scripRepository;
    private UserService userService;

    public ScripService(UserService userService,ScripRepository scripRepository){
        this.userService = userService;
        this.scripRepository = scripRepository;
    }

    public Scrip updateScrip(int id,String ticker,double priceToday, double percentageToday, String dateToday,int quantity){
        Optional<Scrip> scrip = this.userService.getScrip(id,ticker);
        Scrip s = scrip.get();
        s.setPriceToday(priceToday);
        s.setPercentageToday(percentageToday);
        s.setDateToday(dateToday);
        s.setQuantity(quantity);
        this.scripRepository.save(s);
        return s;
    }


}
