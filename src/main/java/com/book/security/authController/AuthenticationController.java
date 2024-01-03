package com.book.security.authController;


import com.book.security.authModel.AuthRequest;
import com.book.security.authModel.AuthResponse;
import com.book.security.authModel.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("signup")
    public ResponseEntity<AuthResponse> SignUp(@RequestBody SignUp request){
        return ResponseEntity.ok(authenticationService.register(request));

    }

    @PostMapping("signin")
    public ResponseEntity<AuthResponse> Login(@RequestBody AuthRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));

    }

}
