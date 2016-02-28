package ru.repp.den;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.repp.den.constants.ConstantsProvider;
import ru.repp.den.exception.BadRequestException;
import ru.repp.den.exception.ExceptionHandlingController;
import ru.repp.den.service.FizzBuzzService;

import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TekLabsApplication.class)
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class, ExceptionHandlingController.class})
@WebIntegrationTest
public class TekLabsTestApplication {

    @Autowired
    FizzBuzzService fizzBuzzService;


    @Test
    public void testNotFizz() {
        ConstantsProvider cp = fizzBuzzService.getConstantsProvider();
        Long number = cp.getFirstDivider()-1;
        String result = fizzBuzzService.play(number);

        Assert.assertNotEquals(result, cp.getFizzWord());
    }

    @Test
    public void testNotBuzz() {
        ConstantsProvider cp = fizzBuzzService.getConstantsProvider();
        Long number = cp.getSecondDivider()-1;
        String result = fizzBuzzService.play(number);

        Assert.assertNotEquals(result, cp.getBuzzWord());
    }

    @Test
    public void testNotFizzBuzz() {
        ConstantsProvider cp = fizzBuzzService.getConstantsProvider();
        Long number = cp.getFirstDivider() * cp.getSecondDivider()-1;
        String result = fizzBuzzService.play(number);

        Assert.assertNotEquals(result, cp.getFizzBuzzWord());
    }

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
        String result = fizzBuzzService.play(cp.getFirstDivider() * cp.getSecondDivider());

        Assert.assertEquals(result, cp.getFizzBuzzWord());
    }

    @Test
    public void testFizzAdv() {
        final ConstantsProvider cp = fizzBuzzService.getConstantsProvider();
        Long[] arr = new Long[] {1L,2L,cp.getFirstDivider(), 3L, cp.getSecondDivider(),5L, 6L,cp.getFirstDivider() * cp.getSecondDivider(), 15L };
        String result = fizzBuzzService.play(arr);

        String[] splitterRes = result.split(cp.getSeparator());
        long fizzCount = Stream.of(splitterRes).filter((e) -> e.equals(cp.getFizzWord())).count();
        long buzzCount = Stream.of(splitterRes).filter((e) -> e.equals(cp.getBuzzWord())).count();
        long fizzBuzzCount = Stream.of(splitterRes).filter((e) -> e.equals(cp.getFizzBuzzWord())).count();

        Assert.assertTrue(fizzCount >= 2);
        Assert.assertTrue(buzzCount >= 2);
        Assert.assertTrue(fizzBuzzCount >= 1);
    }

    @Test
    public void testNoGame() {
        try {
            fizzBuzzService.play((Long) null);
        }catch (Exception e) {
            Assert.assertTrue(e.getClass().equals(BadRequestException.class));
        }
    }

    @Test
    public void testNoGameAdv() {
        try {
            fizzBuzzService.play((Long[]) null);
        }catch (Exception e) {
            Assert.assertTrue(e.getClass().equals(BadRequestException.class));
        }
    }

}

