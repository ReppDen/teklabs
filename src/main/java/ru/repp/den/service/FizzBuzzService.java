package ru.repp.den.service;

import ru.repp.den.constants.ConstantsProvider;

public interface FizzBuzzService {

    /**
     * play a game FizzBuzz one time
     *
     * @param number number to check
     * @return game result
     */
    String play(Long number);

    /**
     * play a game FizzBuzz for each number from the array
     *
     * @param numbers array of  numbers to check
     * @return string with concatenated game result
     */
    String play(Long[] numbers);

    ConstantsProvider getConstantsProvider();
}
