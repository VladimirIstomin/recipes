package recipes.services;

import org.springframework.stereotype.Service;
import recipes.model.Recipe;
import recipes.repositories.RecipeRepository;

import java.util.Map;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Optional<Recipe> getRecipe(long id) {
        return recipeRepository.findById(id);
    }

    public Map<String, Long> postRecipe(Recipe recipe) {
        Recipe saved = recipeRepository.save(recipe);
        return Map.of("id", saved.getId());
    }

    public boolean deleteRecipe(long id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
