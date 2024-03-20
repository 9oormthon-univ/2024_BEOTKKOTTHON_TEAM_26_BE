package com.example.sixpack.service.example;


import com.example.sixpack.domain.Example;
import com.example.sixpack.dto.example.ExampleRequestDto;
import com.example.sixpack.dto.example.ExampleResponseDto;
import com.example.sixpack.repository.example.ExampleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ExampleServiceImpl implements ExampleService {

    private final ExampleRepository exampleRepository;
    private final ModelMapper modelMapper;


    @Transactional
    public Long addExample(ExampleRequestDto input){
        Example exist = exampleRepository.findExampleByName(input.getName());
        if(exist != null){
            // TODO : Exeption Hanlder 완성 시 예외를 throw하는 코드를 추가할 예정
        }

        Example example = modelMapper.map(input, Example.class);
        example = exampleRepository.save(example);
        return example.getExamId();
    }

    public List<ExampleResponseDto> searchExampleByKeyword(String keyword) {
        List<Example> example = exampleRepository.findExamplesWithKeywordContains(keyword);
        List<ExampleResponseDto> response = example.stream()
                .map(e -> modelMapper.map(e, ExampleResponseDto.class))
                .toList();
        return response;
    }
}
