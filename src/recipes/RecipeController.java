package recipes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RecipeController {
    private Recipe recipe = new Recipe(
            "Fresh Mint Tea",
            "Light, aromatic and refreshing beverage",
            "boiled water, honey, fresh mint leaves",
            "1) Boil water. 2) Pour boiling hot water into a mug. "
                    + "3) Add fresh mint leaves. 4) Mix and let the mint leaves seep for 3-5 minutes. "
                    + "5) Add honey and mix again."
    );

    @GetMapping("/api/recipe")
    public Recipe getRecipe() {
        return recipe;
    }

    @PostMapping("/api/recipe")
    public ResponseEntity<String> postRecipe(@Valid @RequestBody Recipe recipe) {
        this.recipe = recipe;
        return ResponseEntity.ok("Recipe added");
    }
}
