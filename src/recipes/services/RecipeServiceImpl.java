package recipes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.entities.Recipe;
import recipes.entities.User;
import recipes.repositories.RecipeRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Map<String, Long> postRecipe(Recipe recipe) {
        Recipe saved = recipeRepository.save(recipe);
        return Map.of("id", saved.getId());
    }

    @Override
    public Optional<Recipe> getRecipe(long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public Optional<List<Recipe>> getRecipesByName(String name) {
        return recipeRepository.findAllByNameContainsIgnoreCaseOrderByDateDesc(name);
    }

    @Override
    public Optional<List<Recipe>> getRecipesByCategory(String category) {
        return recipeRepository.findAllByCategoryIgnoreCaseOrderByDateDesc(category);
    }

    @Override
    public void putRecipe(Recipe recipe, long id, User user) {
        if (recipeRepository.existsById(id)) {
            recipe.setId(id);
            recipe.setUser(user);
            recipeRepository.save(recipe);
        }
    }

    @Override
    public void deleteRecipe(long id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
        }
    }
}
