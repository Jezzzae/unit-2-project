//package com.bookstoreapp.service;
//
//import com.bookstoreapp.exception.InformationExistException;
//import com.bookstoreapp.model.Request.LoginRequest;
//import com.bookstoreapp.model.Response.LoginResponse;
//import com.bookstoreapp.model.User;
//import com.bookstoreapp.repository.UserRepository;
//import com.bookstoreapp.security.JWTUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class UserService {
//
//    private UserRepository userRepository;
//
//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private JWTUtils jwtUtils;
//
//    public User createUser(User userObject) {
//        System.out.println("service is calling createUser==>");
//        // if user not exists by the email
//        // then create the user in the db
//        if (!userRepository.existsByEmailAddress(userObject.getEmailAddress())) {
//            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
//            return userRepository.save(userObject);
//        } else {
//            throw new InformationExistException("user with the email address " +
//                    userObject.getEmailAddress() + " already exists");
//        }
//    }
//
//
//    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
//        System.out.println("service calling loginUser ==>");
//        authenticationManager.authenticate(new
//                UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
//        final String JWT = jwtUtils.generateToken(userDetails);
//        return ResponseEntity.ok(new LoginResponse(JWT));
//    }
//
//    public User findUserByEmailAddress(String email) {
//        return userRepository.findUserByEmailAddress(email);
//    }
//}
//


