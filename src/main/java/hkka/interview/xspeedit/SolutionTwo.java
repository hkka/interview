package hkka.interview.xspeedit;

import hkka.interview.xspeedit.model.Packaging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SolutionTwo {

    final public static String BAD_ARTCILE_LIST_ARG_ERROR = "Liste des articles est null ou vide !!!";

    public static void main(String[] args) {
        List<Integer> articlesList = Arrays.asList(1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3);
        System.out.println("Emballage optimizé : ");
        Utils.printPackaging(optimizerEmballage(articlesList));
    }

    public static List<Packaging> optimizerEmballage(final List<Integer> articlesList) {
        Utils.validateArticlesList(articlesList);
        List<Packaging> packagingList = new ArrayList<>();
        HashMap<Integer, Integer> alreadyProcessed = new HashMap<>();
        for (int i = 0; i < articlesList.size(); i++) {
            int currentArticle = articlesList.get(i);
            if (!alreadyProcessed.containsKey(i)) {
                Packaging packaging = new Packaging();
                packaging.addArticle(currentArticle);
                int k;
                int sum = currentArticle;
                for (k = i + 1; k < articlesList.size(); k++) {
                    if (!alreadyProcessed.containsKey(k)) {
                        int kiemeArticle = articlesList.get(k);
                        if (kiemeArticle + currentArticle == 10) {
                            packaging.resetArticlesList();
                            packaging.addArticle(currentArticle);
                            packaging.addArticle(kiemeArticle);
                            alreadyProcessed.put(k, 0);
                            break;
                        }
                        sum = kiemeArticle + sum;
                        if (sum == 10) {
                            packaging.addArticle(kiemeArticle);
                            alreadyProcessed.put(k, 0);
                            break;
                        } else if (sum > 10) {
                            //alreadyProcessed.put(k, 0);
                        } else if (sum < 10) {
                            packaging.addArticle(kiemeArticle);
                            alreadyProcessed.put(k, kiemeArticle);
                        }
                    }
                }
                packagingList.add(packaging);
            }
            alreadyProcessed.put(i, currentArticle);
        }
        return packagingList;
    }
}