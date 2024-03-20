package com.example.sixpack.repository.example;

import com.example.sixpack.domain.Example;

import java.util.List;

public interface ExampleCustomRepository {

    List<Example> findExamplesWithKeywordContains(String keyword);
}
