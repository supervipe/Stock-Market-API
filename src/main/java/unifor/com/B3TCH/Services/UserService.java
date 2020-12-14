package unifor.com.B3TCH.Services;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import unifor.com.B3TCH.Model.Data;
import unifor.com.B3TCH.Model.Scrip;
import unifor.com.B3TCH.Model.User;
import unifor.com.B3TCH.Model.Yield;
import unifor.com.B3TCH.Repository.ScripRepository;
import unifor.com.B3TCH.Repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private ScripRepository scripRepository;

    public UserService(UserRepository userRepository, ScripRepository scripRepository) {
        this.userRepository = userRepository;
        this.scripRepository = scripRepository;
    }

    public Optional<User> getUser(int id) {
        return this.userRepository.findById(id);
    }

    public User singUp(User user) {
        this.userRepository.save(user);
        return user;
    }

    public User updateUser(int id, Object up) {
        Optional<User> userOpt = getUser(id);
        if(userOpt.isEmpty()){
            return null;
        }
        User userFinal = userOpt.get();

        Gson gson = new Gson();
        Data update = gson.fromJson(up.toString(), Data.class);

        userFinal.setEmail(update.getEmail());
        userFinal.setPassword(update.getPassword());
        this.userRepository.save(userFinal);
        return userFinal;
    }

    public List<Scrip> scripList(int id) {
        Optional<User> userOpt = getUser(id);
        if(userOpt.isEmpty()){
            return null;
        }
        User userFinal = userOpt.get();
        return userFinal.getScrips();
    }

    public Optional<Scrip> getScrip(int id,String ticker){
        Optional<User> userOpt = getUser(id);
        if(userOpt.isEmpty()){
            return Optional.empty();
        }
        User userFinal = userOpt.get();
        return Optional.of(userFinal.getScrip(ticker));
    }

    public List<Scrip> addScrip(int id,Scrip scrip) {
        Optional<User> userOpt = getUser(id);
        if(userOpt.isEmpty()){
            return Collections.emptyList();
        }
        User userFinal = userOpt.get();
        userFinal.addScrip(scrip);
        this.userRepository.save(userFinal);
        return userFinal.getScrips();
    }

    public List<Scrip> removeScrip(int id,String ticker){
        Optional<User> userOpt = getUser(id);
        if(userOpt.isEmpty()){
            return null;
        }
        User userFinal = userOpt.get();
        Scrip s = userFinal.getScrip(ticker);
        userFinal.removeScrip(ticker);
        this.scripRepository.deleteById(s.getId());
        this.userRepository.save(userFinal);
        return userFinal.getScrips();
    }

    public Yield updateTotalProfit(int id){
        Optional<User> userOpt = getUser(id);
        if(userOpt.isEmpty()){
            return null;
        }
        User userFinal = userOpt.get();
        userFinal.setYield(new Yield());
        userFinal.updateProfitTotal();
        this.userRepository.save(userFinal);
        return userFinal.getYield();
    }

    public Yield updateScripProfit(int id, String ticker){
        Optional<User> userOpt = getUser(id);
        if(userOpt.isEmpty()){
            return null;
        }
        User userFinal = userOpt.get();
        userFinal.updateProfitScrip(ticker);
        this.userRepository.save(userFinal);
        return userFinal.getYield();
    }
}
