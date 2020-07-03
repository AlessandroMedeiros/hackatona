package engenharia.software.hackatona.pucrs;

import engenharia.software.hackatona.observer.DeletarObserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

    public static void main(String[] args) {
        DeletarObserver.getInstance().start();
        SpringApplication.run(Application.class, args);
    }
}
