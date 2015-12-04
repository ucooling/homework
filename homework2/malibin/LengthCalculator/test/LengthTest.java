import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LengthTest {

    @Test
    public void should1MReturn1M() {
        Length OneM = new Length(1, LengthType.M);
        assertThat(OneM, is(new Length(1, LengthType.M)));
    }

    @Test
    public void should1MReturn100CM() {
        Length OneM = new Length(1, LengthType.M);
        Length OneHundredCM = new Length(100, LengthType.CM);
        assertThat(OneM, is(OneHundredCM));
    }

    @Test
    public void should1MReturn1000MM() {
        Length OneM = new Length(1, LengthType.M);
        Length OneHundredCM = new Length(1000, LengthType.MM);
        assertThat(OneM, is(OneHundredCM));
    }
}
