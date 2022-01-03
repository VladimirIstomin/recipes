package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class RecipeController {
    RecipesContainer recipesContainer;

    public RecipeController(@Autowired RecipesContainer recipesContainer) {
        this.recipesContainer = recipesContainer;
    }

    @GetMapping("/api/recipe/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id) {
        Recipe recipe = recipesContainer.getRecipe(id);

        if (recipe != null) {
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/api/recipe/new")
    public ResponseEntity<Map<String, Long>> postRecipe(@Valid @RequestBody Recipe recipe) {
        Map<String, Long> result = recipesContainer.addRecipe(recipe);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
