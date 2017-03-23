package com.neppo.estagio.log;


public final class Logger {

    private Logger(){}


    public static void log(String message){
        System.out.println(message);
    }

    public static void error(String message){
        System.err.println(message);
    }

}
