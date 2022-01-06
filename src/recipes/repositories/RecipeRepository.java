package recipes.repositories;

import org.springframework.data.repository.CrudRepository;
import recipes.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
