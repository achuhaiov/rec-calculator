package com.rec.controller;

import com.rec.dto.RecInfo;
import com.rec.service.RecService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RecController {

    private final RecService recService;

    public RecController(RecService recService) {
        this.recService = recService;
    }

    @GetMapping("/rec")
    public List<RecInfo> getRec(@RequestParam(required = false) String regionName,
                                @RequestParam(required = false) String countryName,
                                @RequestParam(required = false) String groupName,
                                @RequestParam(required = false) String branchType,
                                @RequestParam(required = false) String confirmationStatus) {
        return recService.getRECs(regionName, countryName, groupName, branchType, confirmationStatus);
    }

}
