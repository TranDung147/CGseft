package controllers.cgmodule4_final.Service;

import controllers.cgmodule4_final.Model.Sale;
import controllers.cgmodule4_final.Repository.ISaleRepository;
import controllers.cgmodule4_final.Service.Interface.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class SaleService implements ISaleService {

    @Autowired
    private ISaleRepository saleRepository;

    @Override
    public List<Sale> getAllSale() {
        return saleRepository.getAllBySaleId();
    }

    @Override
    public void deleteSaleById(Integer id) {
        if (saleRepository.existsById(id)) {
            saleRepository.deleteById(id);
        } else {
            throw new RuntimeException("Khuyến mãi với ID " + id + " không tồn tại.");
        }
    }

    @Override
    public void saveSale(Sale sale) {
        saleRepository.save(sale);
    }

    @Override
    public Sale getSaleById(Integer id) {
        return saleRepository.getSaleById(id);
    }

    public void updateSale(Sale sale) {
        saleRepository.save(sale);
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public List<Sale> searchSalesByConditions(Long discount, String beginDate, String endDate) {
        LocalDate start = (beginDate != null && !beginDate.isEmpty()) ? LocalDate.parse(beginDate) : null;
        LocalDate end = (endDate != null && !endDate.isEmpty()) ? LocalDate.parse(endDate) : null;

        return saleRepository.findByConditions(discount, start, end);
    }

}
