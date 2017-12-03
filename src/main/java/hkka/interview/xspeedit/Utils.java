package hkka.interview.xspeedit;

import hkka.interview.xspeedit.model.Packaging;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    final public static String BAD_ARTCILE_LIST_ARG_ERROR = "Liste des articles est null ou vide !!!";

    public static void printPackaging(final List<Packaging> packagingList) {
        System.out.println("--- Nombre de cartons utilisés : " + packagingList.size());
        System.out.println("--- " + packagingListToString(packagingList));
    }

    /**
     * Map list of @{@link Packaging} to a String of packages separated by '/'
     *
     * @param packagingList
     * @return String representing packages separated by '/'
     */
    public static String packagingListToString(final List<Packaging> packagingList) {
        return packagingList.stream().map(article -> String.valueOf(article)).collect(Collectors.joining("/"));
    }

    /**
     * Validates the articles list :
     * * If the articlesList is null or empty, then it throws an @{@link IllegalArgumentException}
     *
     * @param articlesList
     */
    public static void validateArticlesList(List<Integer> articlesList) {
        if (articlesList == null || articlesList.isEmpty()) {
            System.err.println(BAD_ARTCILE_LIST_ARG_ERROR);
            throw new IllegalArgumentException(BAD_ARTCILE_LIST_ARG_ERROR);
        }
    }
}
