package com.sample;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class Mockito01ApplicationTests {

    @Mock
    private UserDao mockDao;

    @InjectMocks
    private UserService service;

    @BeforeEach
    void init() {
        // No need to call MockitoAnnotations.openMocks(this) when using MockitoExtension
    }

    @Test
    void testGetNameByUserId() {
        when(mockDao.findNameById(101)).thenReturn("Nick");
        String name = service.getNameByUserId(101);
        assertEquals("Nick", name);
    }
}

