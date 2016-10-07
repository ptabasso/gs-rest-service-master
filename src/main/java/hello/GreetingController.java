package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")

    /*
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }*/

    public Quote greeting(@RequestParam(value="name", defaultValue="World") String name) {
        Quote qt = new Quote("Success");
        log.info(qt.toString());
        System.out.println(qt.toString());
//        return new Quote("Succès");
        return qt;
    }
}
