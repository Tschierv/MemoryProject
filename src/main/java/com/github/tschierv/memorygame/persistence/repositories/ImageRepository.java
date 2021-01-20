package com.github.tschierv.memorygame.persistence.repositories;
import com.github.tschierv.memorygame.domain.card.IImageRepositoryService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Class implements the IImageRepsoitory Interface
 * Allows for loading images either located in a resource folder or in a jar file.
 *
 * Storing new Images is not supported by this class
 */
public class ImageRepository implements IImageRepositoryService {
    Map<UUID, URL> images = new HashMap<>();

    /**
     * Constructor method loads all file URLs of the found image files in the ImageDirPath into a ArrayList
     *
     * @param ImageDirPath String representation of the image directory path use full path.
     *                     example: com/github/tschierv/memorygame/presenation/picture
     */
    public ImageRepository(String ImageDirPath) {
        List<URL> ImageFiles = new ArrayList<>();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources = resolver.getResources(ImageDirPath);
            for (Resource resource : resources) {
                ImageFiles.add(resource.getURL());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (URL filei : ImageFiles){
            this.images.put(UUID.randomUUID(), filei);
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
