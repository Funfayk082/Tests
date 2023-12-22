package model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse{
    public Long id;
    public Long petId;
    public Integer quantity;
    public String shipDate;
    public String status;
    public Boolean complete;
}
