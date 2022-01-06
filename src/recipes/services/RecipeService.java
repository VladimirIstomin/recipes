package recipes.services;

import recipes.model.Recipe;

import java.util.Map;
import java.util.Optional;

public interface RecipeService {
    Optional<Recipe> getRecipe(long id);

    Map<String, Long> postRecipe(Recipe recipe);

    boolean deleteRecipe(long id);
}
