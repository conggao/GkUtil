import org.junit.Before;
import org.junit.Test;

/**
 * Created by yons on 2017/4/3.
 */
public class MakeClassTest {
    MakeClass makeClass;

    @Before
    public void before(){
        makeClass = new MakeClass();

    }
    @Test
    public void makeFunction() {
        System.out.println(makeClass.makeFunction("userBaseInfo", "urd",true,true));


    }

    @Test
    public void firstCharUpper() {

    }

}