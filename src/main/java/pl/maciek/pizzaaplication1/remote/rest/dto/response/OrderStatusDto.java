package pl.maciek.pizzaaplication1.remote.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.maciek.pizzaaplication1.domain.model.OrderStatusType;

import java.util.Date;

public class OrderStatusDto {
    private OrderStatusType status;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updatedAt;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date expectedAt;

    public OrderStatusDto(Date createdAt, Date updatedAt, Date expectedAt){
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.expectedAt = expectedAt;
    }

    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getExpectedAt() {
        return expectedAt;
    }

    public void setExpectedAt(Date expectedAt) {
        this.expectedAt = expectedAt;
    }
}
