package recipes.services;

import recipes.entities.Recipe;
import recipes.entities.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RecipeService {
    Map<String, Long> postRecipe(Recipe recipe);

    Optional<Recipe> getRecipe(long id);

    Optional<List<Recipe>> getRecipesByName(String name);

    Optional<List<Recipe>> getRecipesByCategory(String category);

    void putRecipe(Recipe recipe, long id, User user);

    void deleteRecipe(long id);
}
