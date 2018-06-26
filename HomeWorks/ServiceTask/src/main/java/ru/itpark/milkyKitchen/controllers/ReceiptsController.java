package ru.itpark.milkyKitchen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itpark.milkyKitchen.dto.BabyFoodReceiptDto;
import ru.itpark.milkyKitchen.dto.DepartmentDto;
import ru.itpark.milkyKitchen.dto.DiagnosisDto;
import ru.itpark.milkyKitchen.dto.IndividualDto;
import ru.itpark.milkyKitchen.forms.BabyFoodReceiptForm;
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
        return "ReceiptJournal";
    }

    @RequestMapping(value = { "/addReceipt" }, method = RequestMethod.GET)
    public String addPersonForm(ModelMap model) {

        BabyFoodReceiptForm babyFoodReceiptForm = new BabyFoodReceiptForm();

        List<DepartmentDto> kitchens = service.getKitchens();
        model.addAttribute("kitchens",kitchens);

        List<DiagnosisDto> diagnosis = service.getDiagnosis();
        model.addAttribute("diagnosis",diagnosis);

        List<IndividualDto> patients = service.getIndividuals();
        model.addAttribute("patients",patients);

//        model.addAttribute("ReceiptForm", babyFoodReceiptForm);

        return "ReceiptForm";
    }

    //    @GetMapping("/addReceipt")
    @RequestMapping(value = { "/addReceipt" }, method = RequestMethod.POST)
    public String addReceipt
// (Model model, @ModelAttribute("receiptForm") BabyFoodReceiptForm babyFoodReceiptForm)
    (BabyFoodReceiptForm babyFoodReceiptForm)
    {

//        BabyFoodReceiptEntity newReceipt = new BabyFoodReceiptEntity(series, num, issueDt);
//        service.addReceipt(babyFoodReceiptForm);

        return "redirect:/receipts";

    }

/*
    @RequestMapping(value = { "/addProduct" }, method = RequestMethod.GET)
    public String addProductForm(ModelMap model) {

        BabyFoodReceiptForm babyFoodReceiptForm = new BabyFoodReceiptForm();
        List<DepartmentDto> kitchens = service.getKitchens();
        model.addAttribute("kitchens",kitchens);

        return "ReceiptForm";
    }
*/
/*
    @Autowired
    private IssueProductService issuesService;

    @GetMapping("/products/{receipt-id}")
    @ResponseBody
//    public String getProductsPage(ModelMap model) {
//    public ResponseEntity<List<IssueProductDto>>
//        getAllProducts(@PathVariable("receipt-id") Integer receiptId){
//        return ResponseEntity.ok(productService.getAllProducts(receiptId));
//    }

    public ResponseEntity<BabyFoodReceiptDto> addIssue(ModelMap model,
                                                       @PathVariable("receipt-id") Integer receiptId, @RequestParam("action") String action){
        if (action.equals("addIssue")) {
            List<IssueProductDto> issues = issuesService.getAllIssues(receiptId);
            model.addAttribute("issues", issues);
            return IssuesPage;
        }
    }
    )
*/
}
