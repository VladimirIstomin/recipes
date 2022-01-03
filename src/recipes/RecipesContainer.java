package recipes;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Component
public class RecipesContainer {
    private static long currentId = 0;

    private final Map<Long, Recipe> recipes;

    public RecipesContainer() {
        recipes = new ConcurrentHashMap<>();
    }

    public Map<String, Long> addRecipe(Recipe recipe) {
        currentId++;
        recipes.put(currentId, recipe);

        return Map.of("id", currentId);
    }

    public Recipe getRecipe(long id) {
        return recipes.get(id);
    }
}
