package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CalculatorService;

@Controller
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResponseEntity add() {
        calculatorService.add(6,5);
        return new ResponseEntity("Addition", HttpStatus.OK);
    }

    @RequestMapping(value = "/sub", method = RequestMethod.GET)
    public ResponseEntity sub() {
        calculatorService.sub(6,5);
        return new ResponseEntity("Subtraction", HttpStatus.OK);
    }

    @RequestMapping(value = "/mul", method = RequestMethod.GET)
    public ResponseEntity mul() {
        calculatorService.mul(9,3);
        return new ResponseEntity("Multiplication", HttpStatus.OK);
    }

    @RequestMapping(value = "/div", method = RequestMethod.GET)
    public ResponseEntity div() {
        calculatorService.div(7,0);
        return new ResponseEntity("division", HttpStatus.OK);
    }
}
