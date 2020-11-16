package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.SearchService;

@Controller
public class SearchController {

    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/binary", method = RequestMethod.GET)
    public ResponseEntity binary() {
        searchService.binarySearch(700000);
        return new ResponseEntity("Run Binary Search!", HttpStatus.OK);
    }

    @RequestMapping(value = "/linear", method = RequestMethod.GET)
    public ResponseEntity linear() {
        searchService.linearSearch(700000);
        return new ResponseEntity("Run Linear Search!", HttpStatus.OK);
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ResponseEntity error() {
        searchService.NullPointer();
        return new ResponseEntity("run", HttpStatus.OK);
    }
}
