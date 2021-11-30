package com.ifms.servicesImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ifms.models.User;
import com.ifms.repository.UserRepository;
@Service
public class UserDetailsServiceImpl  implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user = userRepository.findByPhone(phone)
        		
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + phone));
        System.out.print("loadUserByUsername is" +user);
        return UserDetailsImpl.build(user);
    }
}
