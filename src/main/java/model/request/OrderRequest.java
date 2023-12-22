package model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    public Long id;
    public Long petId;
    public Integer quantity;
    public String shipDate;
    public String status;
    public Boolean complete;
}
