package hkka.interview.xspeedit.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PackagingTest {

    @Test
    public void shouldAddArticle() throws Exception {
        Packaging packaging = new Packaging();
        assertThat(packaging.getArticles()).isEmpty();
        packaging.addArticle(1);
        assertThat(packaging.getArticles()).contains(1);
    }

    @Test
    public void shouldReturnArticlesAsStringWhenToStringCalled() {
        String expectedPackagingToString = "123";
        Packaging packaging = new Packaging();
        packaging.addArticle(1);
        packaging.addArticle(2);
        packaging.addArticle(3);
        final String packagingToString = packaging.toString();
        System.out.printf(packagingToString);
        assertThat(packagingToString).isEqualToIgnoringCase(expectedPackagingToString);
    }

    @Test
    public void shouldResetArticlesList(){
        Packaging packaging = new Packaging();
        packaging.addArticle(1);
        packaging.addArticle(2);
        packaging.addArticle(3);
        packaging.resetArticlesList();
        assertThat(packaging.getArticles()).isEmpty();

    }

}