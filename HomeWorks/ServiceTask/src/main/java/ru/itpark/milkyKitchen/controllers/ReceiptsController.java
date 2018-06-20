package ru.itpark.milkyKitchen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itpark.milkyKitchen.dto.BabyFoodReceiptDto;
import ru.itpark.milkyKitchen.services.ReceiptService;

import java.util.List;

/**
 * Created by nailya.shakirova on 20.06.2018.
 */

@Controller
public class ReceiptsController {

    @Autowired
    private ReceiptService service;

    @GetMapping("/receipts")
    public String getReceitsPage(ModelMap model) {
        List<BabyFoodReceiptDto> receipts = service.getAllReceipts();
        model.addAttribute("receipts",receipts);
        return "Receipts_page";
    }
}
