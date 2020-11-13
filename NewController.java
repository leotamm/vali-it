package ee.bcs.valiiit;

import org.springframework.web.bind.annotation.*;

@RequestMapping("test")
@RestController

public class NewController {

    //http://localhost:8080/test/a/abc/a?a=a&?b=345
    @GetMapping("a/*/a/{a}/{b}/c")
    public void test7(@PathVariable("a") String a,
                      @RequestParam("a") String aa,
                      @RequestParam("b") Integer bb,
                      @PathVariable("b") Integer b) {
        System.out.println(("test"));
    }

}

