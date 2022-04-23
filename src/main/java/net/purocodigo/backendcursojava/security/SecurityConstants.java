package net.purocodigo.backendcursojava.security;

import net.purocodigo.backendcursojava.SpringApplicationContext;

public class SecurityConstants {
    //sirven para security tokens - autenticacion
    public static final long EXPIRATION_DATE = 864000000; //tiempo en que el token es valido - 10 dias
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users";
    
    //https://randomkeygen.com/

    public static String getTokenSecret(){
        AppProperties appProperties = (AppProperties)SpringApplicationContext.getBean("AppProperties");

        return appProperties.getTokenSecret();
    }
    
}
