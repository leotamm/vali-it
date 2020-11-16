package ee.bcs.valiiit;

import ee.bcs.valiiit.exception.ApplicationException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    List<Employees> employeesList = new ArrayList<>();  // klassist väljas, hoiab muutujaid

    @GetMapping("excption_test")
    public int exceptionTest(Integer i) {
        return fib(i);
    }

    private int fib(Integer i) {
        if (i < 1) {
            throw new ApplicationException("i peab olema suurem kui 0");
        }
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        return fib(i - 1) + fib(i - 2);
    }

    @PostMapping("/postEmployees")
    public List<Employees> getEmployees3(@RequestBody Employees employees) {
        employeesList.add(employees);
        Employees e = new Employees();
        return employeesList;
    }

    @GetMapping("/getEmployees")
    public List<Employees> getEmployees4() {
        return employeesList;
    }

    @GetMapping("/getEmployee/{id1}")
    public Employees getEmployees5(@PathVariable("id1") int index) {
        return employeesList.get(index);
    }

    @PutMapping("/putEmployee/{id2}/")
    public Employees getEmployees6(@PathVariable("id2") int index,
                                   @RequestBody Employees employees) {
        return employeesList.set(index, employees);
    }

    @DeleteMapping("/deleteEmployee/{id3}/")
    public List<Employees> getEmployees7(@PathVariable("id3") int index) {
        employeesList.remove(index);
        return employeesList;
    }


    ///////////////////////////////////
    @GetMapping("dto_test")
    public Employees getEmployees() {
        Employees e = new Employees();
        e.setName("Tubli Tootaja");
        e.setDepartment("Esimene osakond");
        return e;
    }

    @PostMapping("dto_test")                    // kui on nii get kui post päring,
    public List<Employees> getEmployees2(@RequestBody Employees employees) {          // siis  nimi peab olema teise nimega
        List<Employees> employeesList = new ArrayList<>();
        employeesList.add(employees);
        Employees e = new Employees();
        e.setName("Tubli Tootaja");
        e.setDepartment("Esimene osakond");
        employeesList.add(e);
        return employeesList;
    }

    @GetMapping(value = "/")
    public String test() {
        return "Hello world";
    }

    @GetMapping(value = "Hello")
    public String test2() {
        return "Hello yourself";

    }

    @GetMapping(value = "/fibonacci/{nr}/")
    public int test8(@PathVariable("nr") int nr) {
        return Lesson2.fibonacci(nr);
    }

    @GetMapping("/sum/{id1}/{id2}/")
    public int test9(@PathVariable("id1") int nr1,
                     @PathVariable("id2") int nr2) {
        return Lesson3.uusSumma(nr1, nr2);

    }

    @GetMapping(value = "/summa")           // http://localhost:8080//summa?x=5&y=10
    public int test3(@RequestParam("x") int x,
                     @RequestParam("y") int y) {
        return Lesson3.uusSumma(x, y);

    }

    @GetMapping(value = "/test")
    public int test7(@RequestParam("x") int x) {
        return 2;
    }

    // TODO /company/5/employee/8/contract/5
    @GetMapping(value = "/company/{nr1}/employee/{nr2}/contract/{nr3}")
    public String test4(@PathVariable("nr1") int someNum1,
                        @PathVariable("nr2") int someNum2,
                        @PathVariable("nr3") int someNum3) {
        String vastus = new String("It works!");
        return vastus;
    }

    // TODO /?employeeId=8&somethingElse=tere
    @GetMapping()
    public String test5(@RequestParam("employeeID") Long employeeID,
                        @RequestParam("somethingElse") String hello) {
        String vastus = new String("Töötab!");
        return vastus;
    }

    // TODO /company/6?company=5&a=a&b=b
    @GetMapping(value = "company/{nr}")
    public String test6(@PathVariable("nr") int x,
                        @RequestParam("company") String comp,
                        @RequestParam("a") String a,
                        @RequestParam("b") String b) {
        String vastus = new String("Korras!");
        return vastus;
    }

    // TODO http://localhost:8080/a/suvatekst/a/mingistring/456654/c?a=dasfa&b=32342
    @GetMapping("a/*/a/{a}/{b}/c")
    public String test1(@PathVariable("a") String sss,
                        @RequestParam("a") String zzz,
                        @RequestParam("b") Integer bbb,
                        @PathVariable("b") Integer ccc) {
        String vastus = new String("See sobib!");
        return vastus;
    }
}