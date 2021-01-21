package com.github.tschierv.memorygame.persistence.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class ImageRepositoryTest {
    ImageRepository testImageRepository;

    @BeforeEach
    void setUp() throws IOException {
        testImageRepository = new ImageRepository("com/github/tschierv/memorygame/presentation/picture/**");
    }

    @AfterEach
    void tearDown() {
        testImageRepository = null;
    }

    @Test
    void getAllImages() {
        assertTrue(testImageRepository.getAllImages().size() == 50);
    }

    @Test
    void getRandomImage() {
        URL testImageA = testImageRepository.getRandomImage();
        URL testImageB = testImageRepository.getRandomImage();
        URL testImageC = testImageRepository.getRandomImage();
        assertFalse(testImageA.equals(testImageB) || testImageA.equals(testImageC));
    }
}