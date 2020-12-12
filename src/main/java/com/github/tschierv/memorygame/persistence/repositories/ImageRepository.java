package com.github.tschierv.memorygame.persistence.repositories;
import com.github.tschierv.memorygame.domain.card.IImageRepositoryService;
import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerRepositoryService;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ImageRepository implements IImageRepositoryService {
    Map<UUID, URL> images = new HashMap<>();

    public ImageRepository(String ImageDirPath)  {
        final Path ImageDirectoryPath = Paths.get(ImageDirPath);
        ArrayList<Path> ImageFiles = null;
        try {
            ImageFiles = Files.list(ImageDirectoryPath).collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("image dir path: "+ ImageDirectoryPath);
        for (Path file : ImageFiles){
            try {
                this.images.put(UUID.randomUUID(), file.toUri().toURL());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
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
