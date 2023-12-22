package model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetRequest {
    public Long id;
    public CategoryRequest category;
    public String name;
    public ArrayList<String> photoUrls;
    public ArrayList<TagRequest> tags;
    public String status;

}
