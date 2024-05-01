package com.example.user;


import com.example.user.dto.SignInDTO;
import com.example.user.dto.UserCreateDto;
import com.example.user.dto.UserResponseDto;
import com.example.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper = new ModelMapper();
    private final Random random = new Random();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username).get();
    }
//    long lowerBound = 1000000000000000L;
//    long upperBound = 9999999999999999L;
//    private static List<String> generateRandomNumbers(long 1000000000000000L, long upperBound) {
//        List<String> result = new ArrayList<>();
//        Random random = new Random();
//        for (int i = 0; i < 50; i++) {
//            long randomValue = lowerBound + (long) (random.nextDouble() * (upperBound - lowerBound + 1));
//            result.add(String.valueOf(randomValue));
//        }
//        return result;
//    }

        public void create(UserCreateDto userCreateDto) {
        User user = modelMapper.map(userCreateDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setBalance(random.nextInt(100000, 500000));

                Long a=random.nextLong(10000000,99999999);
                Long b=random.nextLong(10000000,99999999);
                String s=String.valueOf(a+b);
          user.setCardNumber(s);
        userRepository.save(user);
    }
    public void SignInCreate(SignInDTO signInDTO) {
        User user = modelMapper.map(signInDTO, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<UserResponseDto> getAll(){
        List<User> users=userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserResponseDto.class)).toList();
    }

}
