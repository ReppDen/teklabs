package ru.repp.den.service;

import ru.repp.den.constants.ConstantsProvider;
import ru.repp.den.exception.BadRequestException;

import java.util.stream.Stream;

public class FizzBuzzServiceImpl implements FizzBuzzService {


    private final ConstantsProvider constantsProvider;

    public FizzBuzzServiceImpl(ConstantsProvider constantsProvider) {
        this.constantsProvider = constantsProvider;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String play(Long number) {
        if (number == null) {
            throw new BadRequestException("Incorrect number passed, please pass a correct number");
        }
        boolean dividableByFirst = number % constantsProvider.getFirstDivider() == 0;
        boolean dividableBySecond = number % constantsProvider.getSecondDivider() == 0;

        if (dividableByFirst && dividableBySecond) {
            return constantsProvider.getFizzBuzzWord();
        } else if (dividableByFirst) {
            return constantsProvider.getFizzWord();
        }
        if (dividableBySecond) {
            return constantsProvider.getBuzzWord();
        } else {
            return number.toString();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String play(Long[] numbers) {
        if (numbers == null) {
            throw new BadRequestException("No numbers passed to the server");
        }
        StringBuilder resultBuilder = new StringBuilder();
        Stream.of(numbers).forEach((n) -> resultBuilder.append(play(n)).append(constantsProvider.getSeparator()));
        return resultBuilder.toString();
    }

    @Override
    public ConstantsProvider getConstantsProvider() {
        return constantsProvider;
    }
}
