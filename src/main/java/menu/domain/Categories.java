package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Categories {

    private final List<Category> categories;

    public Categories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return Collections.unmodifiableList(categories);
    }

    public List<Category> getRecommendedCategories() {
        List<Category> recommendedCategories = new ArrayList<>();
        while (recommendedCategories.size() != 5) {
            Category category = categories.get(Randoms.pickNumberInRange(0, 4));
            if (getCount(recommendedCategories, category) == 2) {
                continue;
            }
            recommendedCategories.add(category);
        }
        return recommendedCategories;
    }

    private int getCount(List<Category> recommendedCategories, Category category) {
        int count = 0;
        for (Category category_ : recommendedCategories) {
            if (Objects.equals(category_.getName(), category.getName())) {
                count++;
            }
        }
        return count;
    }
}