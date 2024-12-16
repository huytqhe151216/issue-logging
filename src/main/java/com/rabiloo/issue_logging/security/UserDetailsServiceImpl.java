package com.rabiloo.issue_logging.security;

import com.rabiloo.issue_logging.domain.User;
import com.rabiloo.issue_logging.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Tìm người dùng trong cơ sở dữ liệu dựa trên email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // Trả về đối tượng UserDetails của Spring Security
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword()) // Password cần được mã hóa bằng BCrypt
                .roles(user.isAdmin() ? "ADMIN" : "USER") // Gán role dựa trên thuộc tính IsAdmin
                .build();
    }
}
