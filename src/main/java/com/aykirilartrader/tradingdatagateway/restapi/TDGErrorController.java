package com.aykirilartrader.tradingdatagateway.restapi;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

public class TDGErrorController implements ErrorController {
    private static final String PATH = "/error";

    @RequestMapping(value = PATH )
    public ResponseEntity<Object> myError() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
