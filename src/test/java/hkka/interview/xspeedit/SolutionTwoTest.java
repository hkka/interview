package hkka.interview.xspeedit;

import hkka.interview.xspeedit.model.Packaging;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SolutionTwoTest {

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenArticlesListIsNull() throws Exception {
        List<Integer> articlesList = null;
        assertThatThrownBy(() -> SolutionOne.optimizerEmballage(articlesList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Utils.BAD_ARTCILE_LIST_ARG_ERROR)
                .hasNoCause();
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenArticlesListIsEmpty() throws Exception {
        List<Integer> articlesList = Arrays.asList();
        assertThatThrownBy(() -> SolutionTwo.optimizerEmballage(articlesList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Utils.BAD_ARTCILE_LIST_ARG_ERROR)
                .hasNoCause();
    }

    @Test
    public void shouldReturnListOf3Packaging() {
        final List<Integer> articlesList = Arrays.asList(8, 1, 1, 5, 2, 3, 9);
        final List<Packaging> packagingList = SolutionTwo.optimizerEmballage(articlesList);
        assertThat(packagingList.size()).isEqualTo(3);
    }

    @Test
    public void shouldReturnListOf8Packaging() {
        final List<Integer> articlesList = Arrays.asList(1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3);
        final List<Packaging> packagingList = SolutionTwo.optimizerEmballage(articlesList);
        assertThat(packagingList.size()).isEqualTo(8);
        System.out.println(Utils.packagingListToString(packagingList));
    }

    @Test
    public void shouldReturnListOf1Packaging() {
        final List<Integer> articlesList = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1);
        final List<Packaging> packagingList = SolutionTwo.optimizerEmballage(articlesList);
        assertThat(packagingList.size()).isEqualTo(1);
        System.out.println(Utils.packagingListToString(packagingList));
    }

}