package controllers.cgmodule4_final.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Validator;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Sale{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer saleId;

    @NotNull
    @Size(min = 3, max = 100)
    private String titleName;

    @NotNull
    @Future
    private LocalDate beginDate;

    @NotNull
    @Future
    private LocalDate endDate;

    @NotNull
    @Min(10000)
    private Long discount;

    @NotNull
    @Size(min = 10)
    private String description;

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Integer id) {
        this.saleId = id;
    }

    public Integer getId() {
        return saleId;
    }
}
