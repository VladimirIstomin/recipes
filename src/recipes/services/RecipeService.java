package recipes.services;

import recipes.model.Recipe;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RecipeService {
    Map<String, Long> postRecipe(Recipe recipe);

    Optional<Recipe> getRecipe(long id);

    Optional<List<Recipe>> getRecipesByName(String name);

    Optional<List<Recipe>> getRecipesByCategory(String category);

    boolean putRecipe(Recipe recipe, long id);

    boolean deleteRecipe(long id);
}
