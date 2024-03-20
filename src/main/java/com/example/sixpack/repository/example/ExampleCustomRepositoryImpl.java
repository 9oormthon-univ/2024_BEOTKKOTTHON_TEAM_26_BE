package com.example.sixpack.repository.example;

import com.example.sixpack.domain.Example;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import static com.example.sixpack.domain.QExample.example;


@Repository
@AllArgsConstructor
public class ExampleCustomRepositoryImpl implements ExampleCustomRepository {

    private final JPAQueryFactory queryFactory;


    @Override
    public List<Example> findExamplesWithKeywordContains(String keyword) {
        List<Example> result =  queryFactory.selectFrom(example)
                .where(example.name.contains(keyword))
                .fetch();
        return result;
    }
}
