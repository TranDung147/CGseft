package controllers.cgmodule4_final.Service.Interface;

import controllers.cgmodule4_final.Model.Sale;

import java.util.List;

public interface ISaleService {
    List<Sale> getAllSale();
    void deleteSaleById(Integer id);
    void saveSale(Sale sale);
    Sale getSaleById(Integer id);
    void updateSale(Sale sale);
    List<Sale> getAllSales();
    List<Sale> searchSalesByConditions(Long discount, String beginDate, String endDate);

}
