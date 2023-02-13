package ex.proj.skyline.saitonproject.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Vladislav Domaniewski
 */

@RestController
@RequestMapping("/api/spares")
public class SparePartController {

    @GetMapping
    public String getListSpares() {
        return "index";
    }

    @PostMapping
    public void setSpares() {

    }

    @PatchMapping
    public void updateSparePart() {

    }

    @DeleteMapping
    public void deleteSparePartFromList() {

    }
}
