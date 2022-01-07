package recipes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.model.Recipe;
import recipes.services.RecipeService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/new")
    public ResponseEntity<Map<String, Long>> postRecipe(@Valid @RequestBody Recipe recipe) {
        return new ResponseEntity<>(recipeService.postRecipe(recipe), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id) {
        Optional<Recipe> recipe = recipeService.getRecipe(id);
        return recipe
            .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Recipe>> getRecipesByParam(@RequestParam Map<String, String> params) {
        Optional<List<Recipe>> recipes = Optional.empty();

        // there could be only two params: name and category, which are mutually exclusive
        if (params.size() != 1 || !List.of("name", "category").containsAll(params.keySet())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (params.containsKey("name")) {
            recipes = recipeService.getRecipesByName(params.get("name"));
        } else if (params.containsKey("category")) {
            recipes = recipeService.getRecipesByCategory(params.get("category"));
        }

        return new ResponseEntity<>(recipes.orElse(Collections.emptyList()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putRecipe(@Valid @RequestBody Recipe recipe, @PathVariable long id) {
        return new ResponseEntity<>(recipeService.putRecipe(recipe, id) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable long id) {
        return new ResponseEntity<>(recipeService.deleteRecipe(id) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }
}
