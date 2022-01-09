package recipes.repositories;

import org.springframework.data.repository.CrudRepository;
import recipes.entities.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    Optional<List<Recipe>> findAllByNameContainsIgnoreCaseOrderByDateDesc(String name);

    Optional<List<Recipe>> findAllByCategoryIgnoreCaseOrderByDateDesc(String category);
}
