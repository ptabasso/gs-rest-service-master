package hello;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;

@RestController
public class GreetingController {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    private HttpServletRequest request;

//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping("/greeting")
    @RequestMapping("*")
    /*
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }*/

    public Quote greeting(@RequestParam(value="name", defaultValue="World") String name, HttpServletRequest request) {


        Enumeration headerNames = request.getHeaderNames();

        Quote qt = new Quote("Success");

        while (headerNames.hasMoreElements()){
            String key = (String)headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println(key+":"+value);
        }


        log.info(qt.toString());
        System.out.println(qt.toString());
//        return new Quote("Succès");
        return qt;
    }

    @RequestMapping(value="/value",method=RequestMethod.POST)
    public ResponseEntity<Value> createValue(@RequestBody Value value, HttpServletRequest request)
    {
        Enumeration headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()){
            String key = (String)headerNames.nextElement();
            String val = request.getHeader(key);
            System.out.println(key+":"+val);
        }

        log.info(value.toString());
        System.out.println(value);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
