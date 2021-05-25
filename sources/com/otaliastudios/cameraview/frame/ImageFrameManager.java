package com.otaliastudios.cameraview.frame;

import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
@RequiresApi(19)
public class ImageFrameManager extends FrameManager<Image> {
    public ImageFrameManager(int i) {
        super(i, Image.class);
    }

    @NonNull
    public Image onCloneFrameData(@NonNull Image image) {
        throw new RuntimeException("Cannot freeze() an Image Frame. Please consider using the frame synchronously in your process() method, which also gives better performance.");
    }

    public void onFrameDataReleased(@NonNull Image image, boolean z) {
        try {
            image.close();
        } catch (Exception unused) {
        }
    }
}
