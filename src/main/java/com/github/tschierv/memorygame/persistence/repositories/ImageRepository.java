package com.github.tschierv.memorygame.persistence.repositories;
import com.github.tschierv.memorygame.Main;
import com.github.tschierv.memorygame.domain.card.IImageRepositoryService;
import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerRepositoryService;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ImageRepository implements IImageRepositoryService {
    Map<UUID, URL> images = new HashMap<>();

    public ImageRepository(String ImageDirPath)  {
        List<URL> ImageFiles = new ArrayList<URL>();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(ImageDirPath)) {
            List<String> result = IOUtils.readLines(inputStream, StandardCharsets.UTF_8);
            for (String file : result) {
                URL imageFileUrl = getClass().getClassLoader().getResource(ImageDirPath + "/" + file.toString());
                ImageFiles.add(imageFileUrl);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (URL file : ImageFiles){
            this.images.put(UUID.randomUUID(), file);
        }
        }
    @Override
    public ArrayList<URL> getAllImages() {
        Collection<URL> imagePaths = this.images.values();
        return new ArrayList<URL>(imagePaths);
    }

    @Override
    public URL getImage(UUID image_id) {
        return this.images.get(image_id);
    }

    @Override
    public URL getRandomImage() {
        Random rand = new Random();
        List<UUID> image_keys = new ArrayList<>(this.images.keySet());
        int randomIndex = rand.nextInt(image_keys.size());
        return this.images.get(image_keys.get(randomIndex));
    }
}
