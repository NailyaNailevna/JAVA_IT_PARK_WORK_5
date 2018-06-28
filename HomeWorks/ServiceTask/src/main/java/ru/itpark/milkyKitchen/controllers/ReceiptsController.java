package ru.itpark.milkyKitchen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.milkyKitchen.dto.*;
import ru.itpark.milkyKitchen.forms.BabyFoodReceiptForm;
import ru.itpark.milkyKitchen.services.IssueProductService;
import ru.itpark.milkyKitchen.services.ReceiptService;

import java.util.List;

/**
 * Created by nailya.shakirova on 20.06.2018.
 */

@Controller
public class ReceiptsController {

    @Autowired
    private ReceiptService service;

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//        sdf.setLenient(true);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
//    }

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
    @PostMapping("/addReceipt")
//    @RequestMapping(value = { "/addReceipt" }, method = RequestMethod.POST)
    public String addReceipt
     (@ModelAttribute("receiptForm") BabyFoodReceiptForm babyFoodReceiptForm) {
//    (BabyFoodReceiptForm babyFoodReceiptForm) {

        service.addReceipt(babyFoodReceiptForm);
        return "redirect:/receipts";
    }
/* 28.06.2018*/
    @PostMapping("/receipts/{receipt-id}")
    @ResponseBody
    public ResponseEntity<ReceiptDto> changeStatus(
            @PathVariable("receipt-id") Integer receiptId, @RequestParam("action") String action) {
        if (action.equals("delete")) {
            ReceiptDto receiptDto = service.delete(receiptId);
            return ResponseEntity.ok(receiptDto);
        } else return ResponseEntity.notFound().build();
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

    @Autowired
    private IssueProductService issuesService;

    @GetMapping("/receipts/{receipt-id}/issues")
    @ResponseBody
//    public String getProductsPage(ModelMap model) {
    public ResponseEntity<List<IssueProductDto>>
        getAllProducts(@PathVariable("receipt-id") Integer receiptId){
//        ReceiptsController productService;
        return ResponseEntity.ok(issuesService.getAllIssues());
    }
/*
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
