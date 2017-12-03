package hkka.interview.xspeedit.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Packaging {
    private List<Integer> articles = new ArrayList<>();

    public void addArticle(Integer article){
        this.articles.add(article);
    }

    @Override
    public String toString(){
        return articles.stream().map(article -> String.valueOf(article)).collect(Collectors.joining(""));
    }
}
