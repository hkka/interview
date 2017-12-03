package hkka.interview.xspeedit;

import hkka.interview.xspeedit.model.Packaging;
import java.util.*;

import static hkka.interview.xspeedit.SolutionOne.printPackaging;

public class SolutionTwo {

    final public static String BAD_ARTCILE_LIST_ARG_ERROR = "Liste des articles est null ou vide !!!";

    public static void main(String[] args) {
        List<Integer> articlesList = Arrays.asList(1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3);
        System.out.println("Emballage optimizé : ");
        printPackaging(optimizerEmballage(articlesList));
    }

    public static List<Packaging> optimizerEmballage(final List<Integer> articlesList) {
        Map<Integer, Integer> alreadyProcessed = new HashMap<>();
        List<Packaging> packagingList = new ArrayList<>();
        for(int i = 0; i<articlesList.size(); i++){
            System.out.println("***************************************************************");
            System.out.println("i : " + i);
            if(!alreadyProcessed.containsKey(i)) {
//                System.out.println("Not already processed  : " + i);
                int currentArticle = articlesList.get(i);
//                System.out.println("currentArticle : " + currentArticle);
                Packaging packaging = new Packaging();
                packaging.addArticle(currentArticle);
//                System.out.println("packaging : " + packaging);
                int k;
                int sum = currentArticle;
//                System.out.println("sum : " + sum);
                for (k = i + 1; k < articlesList.size(); k++) {
//                    System.out.println("\t\t\t-----------------------------------------------------");
//                    System.out.println("k : " + k);
                    if(!alreadyProcessed.containsKey(k)) {
//                        System.out.println("Not already processed  : " + k);
                        int kiemeArticle = articlesList.get(k);
//                        System.out.println("\t\t\tkiemeArticle : " + kiemeArticle);
                        // direct match
                        if(kiemeArticle + currentArticle == 10){
//                            System.out.println("\t\t\tdirectMatch : " + kiemeArticle + " -- " + currentArticle);
                            packaging.resetArticlesList();
                            packaging.addArticle(currentArticle);
                            packaging.addArticle(kiemeArticle);
//                            System.out.println("\t\t\tpackaging : " + packaging);
                            alreadyProcessed.put(k, 0);
                            break;
                        }
                        sum = kiemeArticle + sum;
//                        System.out.println("\t\t\tkiemeArticle + sum : " + sum);
                        if (sum == 10) {
//                            System.out.println("\t\t\tsum == 10 / kiemeArticle : " + kiemeArticle);
                            packaging.addArticle(kiemeArticle);
//                            System.out.println("\t\t\tsum == 10 / packaging : " + packaging);
                            alreadyProcessed.put(k, 0);
                            break;
                        } else if (sum > 10) {
                            //alreadyProcessed.put(k, 0);
                        } else if (sum < 10){
//                            System.out.println("\t\t\tsum == 10 / kiemeArticle : " + kiemeArticle);
                            packaging.addArticle(kiemeArticle);
//                            System.out.println("\t\t\tsum == 10 / packaging : " + packaging);
                            alreadyProcessed.put(k, 0);
                        }

                    }
//                    System.out.println("\t\t\t-----------------------------------------------------");
                }
                packagingList.add(packaging);
            }
            alreadyProcessed.put(i, 0);
//            System.out.println("***************************************************************");
        }
        return packagingList;
    }
}