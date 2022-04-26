package pl.maciek.pizzaaplication1.domain.exeption;




public class ResourseNotFoundExeption extends RuntimeException {

    public ResourseNotFoundExeption(String message){
        super(message);
    }
}
