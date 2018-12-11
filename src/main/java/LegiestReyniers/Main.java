package LegiestReyniers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Windows: -Djava.library.path=C:\Users\woute\Documents\R\win-library\3.5\rJava\jri\x64
//Mac:  -Djava.library.path="/usr/local/lib/R/3.3/site-library/rJava/jri/

// https://stackoverflow.com/questions/32170664/running-jar-built-using-maven-causes-java-lang-noclassdeffounderror-org-rosuda/39218785


@SpringBootApplication
@SuppressWarnings("Duplicates")
public class Main {

    public static void main(String[] args){
        SpringApplication.run(Main.class,args);
    }

}