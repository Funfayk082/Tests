package model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.request.CategoryRequest;
import model.request.TagRequest;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetResponse {
    public Long id;
    public CategoryRequest category;
    public String name;
    public ArrayList<String> photoUrls;
    public ArrayList<TagRequest> tags;
    public String status;
}
