package ru.repp.den.constants;

public class FizzBuzzConstansProvider implements ConstantsProvider {
    private static final long FIRST_DIVIDER = 3l;
    private static final long SECOND_DIVIDER = 5l;

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";
    private static final String SEPARATOR = " ";

    @Override
    public long getFirstDivider() {
        return FIRST_DIVIDER;
    }

    @Override
    public long getSecondDivider() {
        return SECOND_DIVIDER;
    }

    @Override
    public String getFizzWord() {
        return FIZZ;
    }

    @Override
    public String getBuzzWord() {
        return BUZZ;
    }

    @Override
    public String getFizzBuzzWord() {
        return FIZZBUZZ;
    }

    @Override
    public String getSeparator() {
        return SEPARATOR;
    }
}
