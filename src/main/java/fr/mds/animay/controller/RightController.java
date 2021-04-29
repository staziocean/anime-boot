package fr.mds.animay.controller;

import fr.mds.animay.model.Right;
import fr.mds.animay.service.RightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rights")
public class RightController {

    private final RightService rightService;

    @Autowired
    public RightController(RightService rightService) {
        this.rightService = rightService;
    }

    @GetMapping
    public List<Right> findAll() {
        return rightService.findAll();
    }

    @PostMapping
    public Right create(@RequestBody Right right) {
        return rightService.create(right);
    }
}
