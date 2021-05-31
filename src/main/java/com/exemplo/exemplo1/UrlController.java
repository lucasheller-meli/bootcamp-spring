package com.exemplo.exemplo1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urls")
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService){
        this.urlService = urlService;
    }

    @PostMapping
    public ResponseEntity<LinkResponse> createLink(@RequestBody LinkRequest linkRequest){
        return ResponseEntity.ok(urlService.createLink(linkRequest));
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<String> redirect(@PathVariable Integer id){
        return ResponseEntity.ok(urlService.redirect(id));
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<Integer> countAccess(@PathVariable Integer id){
        return ResponseEntity.ok(urlService.countAccess(id));
    }

    @GetMapping("/invalidate/{id}")
    public ResponseEntity<Link> valid(@PathVariable Integer id){
        return ResponseEntity.ok(urlService.invalidate(id));
    }


}
