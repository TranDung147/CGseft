package controllers.cgmodule4_final.Repository;

import controllers.cgmodule4_final.Model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Integer> {
    @Query("SELECT s from Sale s")
    List<Sale> getAllBySaleId();
    @Query("SELECT s FROM Sale s WHERE s.saleId = :id")
    Sale getSaleById(@Param("id") Integer id);
    @Query("SELECT s FROM Sale s WHERE " +
            "(:discount IS NULL OR s.discount >= :discount) AND " +
            "(:beginDate IS NULL OR s.beginDate >= :beginDate) AND " +
            "(:endDate IS NULL OR s.endDate <= :endDate)")
    List<Sale> findByConditions(@Param("discount") Long discount,
                                @Param("beginDate") LocalDate beginDate,
                                @Param("endDate") LocalDate endDate);
}
