package hkka.interview.xspeedit;

import hkka.interview.xspeedit.model.Packaging;

import java.util.*;

public class SolutionOne {


    public static void main(String[] args) {
        List<Integer> articlesList = Arrays.asList(1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3);
        System.out.println("Emballage optimizé : ");
        Utils.printPackaging(optimizerEmballage(articlesList));
    }

    public static List<Packaging> optimizerEmballage(final List<Integer> articlesList) {
        Utils.validateArticlesList(articlesList);
        Map<Integer, List<Integer>> indexesByArticle = listIndexesByArticle(articlesList);
        List<Packaging> packagingList = new ArrayList<>();
        for (Integer currentArticle : articlesList) {
            List<Integer> currentArticleIndexesList = indexesByArticle.get(currentArticle);
            if (currentArticleIndexesList != null && !currentArticleIndexesList.isEmpty()) {
                Packaging packaging = new Packaging();
                currentArticleIndexesList.remove(0);
                packaging.addArticle(currentArticle);
                int matcherElement = 10 - currentArticle;
                int totalSum = currentArticle;
                boolean isPackagingFull = false;
                do {
                    List<Integer> matcherElementExistingIndexes = indexesByArticle.get(matcherElement);
                    if (matcherElementExistingIndexes != null && !matcherElementExistingIndexes.isEmpty()) {
                        matcherElementExistingIndexes.remove(0);
                        packaging.addArticle(matcherElement);
                        totalSum += matcherElement;
                        matcherElement = 10 - totalSum;
                        if (totalSum == 10) {
                            isPackagingFull = true;
                        }
                    } else
                        matcherElement--;
                } while (matcherElement > 0 && !isPackagingFull);
                packagingList.add(packaging);
            }
        }
        return packagingList;
    }

    /**
     * Creates a new Map where :
     * * Key   : is an article
     * * value : list of relevant indices of the key article
     *
     * @param articlesList : list of articles to process
     * @return new Map of articles and its relevant list of indices in the articlesList
     */
    private static Map<Integer, List<Integer>> listIndexesByArticle(final List<Integer> articlesList) {
        Map<Integer, List<Integer>> indexesByArticle = new HashMap();
        for (int i = 0; i < articlesList.size(); i++) {
            List<Integer> list = indexesByArticle.get(articlesList.get(i));
            if (list == null) {
                list = new ArrayList();
                indexesByArticle.put(articlesList.get(i), list);
            }
            list.add(i);
        }
        return indexesByArticle;
    }
}