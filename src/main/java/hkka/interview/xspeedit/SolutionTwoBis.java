package hkka.interview.xspeedit;

import hkka.interview.xspeedit.model.Packaging;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SolutionTwoBis {

    public static void main(String[] args) {
        int[] articles = {1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3};
        List<Integer> articlesList = new ArrayList();
        IntStream.iterate(0, n -> n + 1).limit(articles.length).forEach(n -> articlesList.add(articles[n]));
        System.out.println("Emballage optimizé : ");
        Utils.printPackaging(optimizerEmballage(articlesList));
    }

    public static List<Packaging> optimizerEmballage(final List<Integer> articlesList) {
        Utils.validateArticlesList(articlesList);
        List<Packaging> packagingList = new ArrayList<>();
        int size;
        while (!articlesList.isEmpty()) {
            int currentArticle = articlesList.remove(0);
            Packaging packaging = new Packaging();
            packaging.addArticle(currentArticle);
            int k;
            int sum = currentArticle;
            k = 0;
            size = articlesList.size();
            while (k < size) {
                int kiemeArticle = articlesList.get(k);
                // direct match
                if (kiemeArticle + currentArticle == 10) {
                    packaging.resetArticlesList();
                    packaging.addArticle(currentArticle);
                    packaging.addArticle(kiemeArticle);
                    articlesList.remove(k);
                    break;
                }
                sum = kiemeArticle + sum;
                if (sum == 10) {
                    packaging.addArticle(kiemeArticle);
                    articlesList.remove(k);
                    break;
                } else if (sum > 10) {
                    k++;
                } else if (sum < 10) {
                    packaging.addArticle(kiemeArticle);
                    articlesList.remove(k);
                }
                size = articlesList.size();
            }
            packagingList.add(packaging);
        }
        return packagingList;
    }
}