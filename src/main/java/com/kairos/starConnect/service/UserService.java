package com.kairos.starConnect.service;

import com.kairos.starConnect.entities.User;
import com.kairos.starConnect.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;
    private final String[] colors={"#000000", "#0000FF", "#008000", "#00FF00", "#008080", "#00FFFF", "#FF0000"};

    public User createOrGetUser(String username){
        var existingUser = usersRepository.findByUsername(username);
        if(existingUser.isPresent()){
            var user = existingUser.get();
            user.setOnline(true);
            user.setLastSeen(LocalDateTime.now());
            return usersRepository.save(user);
        }

        var randomColor = colors[new Random().nextInt(colors.length)];
        var newUser = new User(username, randomColor);
        newUser.setOnline(true);

        return usersRepository.save(newUser);
    }

    public User findByUsername(String username){
        return usersRepository.findByUsername(username).orElse(null);
    }

    public List<User> getOnlineUsers(){
        return usersRepository.findByIsOnlineTrue();
    }

    public void setUserOffline(User user){
        user.setOnline(false);
        usersRepository.save(user);
    }

    public boolean existByUsername(String username){
        return usersRepository.existByUsername(username);
    }
}
