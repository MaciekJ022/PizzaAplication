package pl.maciek.pizzaaplication1.domain.service;


import pl.maciek.pizzaaplication1.domain.exeption.UnauthorizedExeption;

public class AuthorizationService {

    public static void checkToken(String token){
        if (token == null || !token.equals("xzv")){
            throw new UnauthorizedExeption("Błędny token")
        }
    }
}
