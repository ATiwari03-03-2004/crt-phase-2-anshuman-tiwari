package com.test.sectionD.q17;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository repo;          // (a) mocked dependency

    @InjectMocks
    private ProductService service;          // (a) mock injected into the service

    @Test
    void getById_returnsLaptop() {
        // (b) stub the repository to return a sample Product
        Product sample = new Product(1L, "Laptop");
        when(repo.findById(1L)).thenReturn(Optional.of(sample));

        Product result = service.getById(1L);

        // (c) assert the returned product's name equals "Laptop"
        assertEquals("Laptop", result.getName());
    }
}
