package ru.repp.den;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.repp.den.constants.ConstantsProvider;
import ru.repp.den.service.FizzBuzzService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TekLabsApplication.class)
@WebAppConfiguration
public class TestClass {

    @Autowired
    FizzBuzzService fizzBuzzService;

    @Test
    public void testFizz() {
        ConstantsProvider cp = fizzBuzzService.getConstantsProvider();
        String result = fizzBuzzService.play(cp.getFirstDivider());

        Assert.assertEquals(result, cp.getFizzWord());
    }

    @Test
    public void testBuzz() {
        ConstantsProvider cp = fizzBuzzService.getConstantsProvider();
        String result = fizzBuzzService.play(cp.getSecondDivider());

        Assert.assertEquals(result, cp.getBuzzWord());
    }

    @Test
    public void testFizzBuzz() {
        ConstantsProvider cp = fizzBuzzService.getConstantsProvider();
        String result = fizzBuzzService.play(cp.getSecondDivider() * cp.getSecondDivider());

        Assert.assertEquals(result, cp.getFizzBuzzWord());
    }

//	@Test
//	public void contextLoads() {
//	}

}

