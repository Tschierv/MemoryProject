package com.github.tschierv.memorygame.persistence.repositories;

import com.github.tschierv.memorygame.domain.card.CardController;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;

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