package com.github.tschierv.memorygame.domain.card;

import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

public interface IImageRepositoryService {
    ArrayList<URL> getAllImages();
    URL getImage(UUID image_id);
    URL getRandomImage();
}
