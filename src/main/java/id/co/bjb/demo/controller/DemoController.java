package id.co.bjb.demo.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @PostMapping(value = "/find")
    public ResponseEntity<Object> findData(HttpServletRequest request) throws Exception{

        return ResponseEntity.ok().body("data");
    }
}
