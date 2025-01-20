package controllers.cgmodule4_final.Repository;

import controllers.cgmodule4_final.Model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Integer> {
    @Query("SELECT s from Sale s")
    List<Sale> getAllBySaleId();
    @Query("SELECT s FROM Sale s WHERE s.saleId = :id")
    Sale getSaleById(@Param("id") Integer id);
}
