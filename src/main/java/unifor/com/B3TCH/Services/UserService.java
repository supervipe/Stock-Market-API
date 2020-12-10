package unifor.com.B3TCH.Services;

import org.springframework.stereotype.Service;
import unifor.com.B3TCH.Model.Scrip;
import unifor.com.B3TCH.Model.User;
import unifor.com.B3TCH.Model.Yield;
import unifor.com.B3TCH.Repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUser(int id) {
        return this.userRepository.findById(id);
    }

    public User singUp(User user) {
        this.userRepository.save(user);
        return user;
    }

    public User updateUser(int id,String email, String password) {
        Optional<User> userOpt = getUser(id);
        if(userOpt.isEmpty()){
            return null;
        }
        User userFinal = userOpt.get();
        userFinal.setEmail(email);
        userFinal.setPassword(password);
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
        userFinal.removeScrip(ticker);
        this.userRepository.save(userFinal);
        return userFinal.getScrips();
    }

    public Yield updateTotalProfit(int id){
        Optional<User> userOpt = getUser(id);
        if(userOpt.isEmpty()){
            return null;
        }
        User userFinal = userOpt.get();
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
