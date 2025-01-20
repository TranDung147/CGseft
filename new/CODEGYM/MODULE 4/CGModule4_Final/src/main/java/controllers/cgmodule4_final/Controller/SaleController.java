package controllers.cgmodule4_final.Controller;

import controllers.cgmodule4_final.Model.Sale;
import controllers.cgmodule4_final.Service.Interface.ISaleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class SaleController {
    @Autowired
    private ISaleService saleService;

    @GetMapping
    public String getAllSales(Model model) {

        List<Sale> sales = saleService.getAllSale();
        model.addAttribute("sales", sales);
        return "salePage";
    }

    @PostMapping("delete/{id}")
    public String deleteSale(@PathVariable("id") Integer saleId, RedirectAttributes redirectAttributes) {
        try {
            saleService.deleteSaleById(saleId);
            redirectAttributes.addFlashAttribute("message", "Xóa thành công khuyến mãi!");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", "Xóa thất bại. Có lỗi xảy ra: " + e.getMessage());
        }
        return "redirect:/";
    }
    @GetMapping("showAddSalePage")
    public String addSale(Model model) {
        model.addAttribute("sale", new Sale());
        return "addSale";
    }

    @PostMapping("sales/add")
    public String saveSale(@Valid @ModelAttribute("sale") Sale sale, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addSale";
        }
        saleService.saveSale(sale);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String editSaleForm(@PathVariable("id") Integer saleId, Model model) {
        Sale sale = saleService.getSaleById(saleId);
        if (sale == null) {
            throw new RuntimeException("Khuyến mãi với ID " + saleId + " không tồn tại.");
        }
        model.addAttribute("sale", sale);
        return "saleEditPage";
    }
    @PostMapping("edit")
    public String updatePromotion(@PathVariable("saleId") Integer saleId, @ModelAttribute Sale sale) {
        try {
            sale.setSaleId(saleId);
            saleService.updateSale(sale);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "redirect:/";
    }
}
