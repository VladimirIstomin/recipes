package recipes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String ingredients;
    @NotNull
    private String directions;
}
