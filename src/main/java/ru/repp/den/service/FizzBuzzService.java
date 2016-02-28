package ru.repp.den.service;

import ru.repp.den.constants.ConstantsProvider;

public interface FizzBuzzService {

    String play(Long number);

    ConstantsProvider getConstantsProvider();
}
