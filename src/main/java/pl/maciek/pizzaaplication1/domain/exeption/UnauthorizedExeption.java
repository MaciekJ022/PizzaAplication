package pl.maciek.pizzaaplication1.domain.exeption;

public class UnauthorizedExeption extends RuntimeException{
    public UnauthorizedExeption(String message){super(message);}
}
