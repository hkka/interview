package hkka.interview.xspeedit;

import hkka.interview.xspeedit.model.Packaging;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SolutionTwoBisTest {

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenArticlesListIsNull() throws Exception {
        List<Integer> articlesList = null;
        assertThatThrownBy(() -> SolutionTwoBis.optimizerEmballage(articlesList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Utils.BAD_ARTCILE_LIST_ARG_ERROR)
                .hasNoCause();
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenArticlesListIsEmpty() throws Exception {
        List<Integer> articlesList = Arrays.asList();
        assertThatThrownBy(() -> SolutionTwoBis.optimizerEmballage(articlesList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Utils.BAD_ARTCILE_LIST_ARG_ERROR)
                .hasNoCause();
    }

    @Test
    public void shouldReturnListOf3Packaging() {
        int[] articles = {8, 1, 1, 5, 2, 3, 9};
        List<Integer> articlesList = new ArrayList();
        IntStream.iterate(0, n -> n + 1).limit(articles.length).forEach(n -> articlesList.add(articles[n]));
        final List<Packaging> packagingList = SolutionTwoBis.optimizerEmballage(articlesList);
        assertThat(packagingList.size()).isEqualTo(3);
    }

    @Test
    public void shouldReturnListOf8Packaging() {
        int[] articles = {1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3};
        List<Integer> articlesList = new ArrayList();
        IntStream.iterate(0, n -> n + 1).limit(articles.length).forEach(n -> articlesList.add(articles[n]));
        final List<Packaging> packagingList = SolutionTwoBis.optimizerEmballage(articlesList);
        assertThat(packagingList.size()).isEqualTo(8);
        System.out.println(Utils.packagingListToString(packagingList));
    }

    @Test
    public void shouldReturnListOf1Packaging() {
        int[] articles = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        List<Integer> articlesList = new ArrayList();
        IntStream.iterate(0, n -> n + 1).limit(articles.length).forEach(n -> articlesList.add(articles[n]));
        final List<Packaging> packagingList = SolutionTwoBis.optimizerEmballage(articlesList);
        assertThat(packagingList.size()).isEqualTo(1);
        System.out.println(Utils.packagingListToString(packagingList));
    }

}