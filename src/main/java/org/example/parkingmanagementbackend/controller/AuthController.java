// AuthController.java
package org.example.parkingmanagementbackend.controller;

import com.google.firebase.auth.FirebaseToken;
import org.example.parkingmanagementbackend.service.FirebaseAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final FirebaseAuthService firebaseAuthService;

    @Autowired
    public AuthController(FirebaseAuthService firebaseAuthService) {
        this.firebaseAuthService = firebaseAuthService;
    }

    @PostMapping("/secure-endpoint")
    public String secureEndpoint(@RequestHeader("Authorization") String idToken) throws Exception {
        FirebaseToken decodedToken = firebaseAuthService.verifyIdToken(idToken.replace("Bearer ", ""));
        // Your logic here
        return "Secure data";
    }
}
