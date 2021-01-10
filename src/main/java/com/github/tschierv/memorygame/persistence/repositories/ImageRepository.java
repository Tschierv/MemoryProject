package com.github.tschierv.memorygame.persistence.repositories;
import com.github.tschierv.memorygame.domain.card.IImageRepositoryService;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
    public ImageRepository(String ImageDirPath)  {
        List<URL> ImageFiles = new ArrayList<>();
        // getResource API doesn't support Directory listing, therefore using getResourceAsStream
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
