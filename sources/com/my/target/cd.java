package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
import java.util.ArrayList;
import java.util.List;
public class cd extends ca {
    @NonNull
    public final List<ImageData> i = new ArrayList();
    @NonNull
    public final List<ImageData> j = new ArrayList();
    @Nullable
    public ImageData k;
    @Nullable
    public ImageData l;

    @NonNull
    public static cd fromCompanion(@NonNull bz bzVar) {
        cd newBanner = newBanner();
        newBanner.setId(bzVar.getId());
        String staticResource = bzVar.getStaticResource();
        if (staticResource != null) {
            newBanner.addPortraitImage(ImageData.newImageData(staticResource, bzVar.getWidth(), bzVar.getHeight()));
            newBanner.getStatHolder().a(bzVar.getStatHolder(), 0.0f);
            newBanner.trackingLink = bzVar.trackingLink;
        }
        return newBanner;
    }

    @NonNull
    public static cd newBanner() {
        return new cd();
    }

    public void addLandscapeImage(@NonNull ImageData imageData) {
        this.j.add(imageData);
    }

    public void addPortraitImage(@NonNull ImageData imageData) {
        this.i.add(imageData);
    }

    @NonNull
    public List<ImageData> getLandscapeImages() {
        return new ArrayList(this.j);
    }

    @Nullable
    public ImageData getOptimalLandscapeImage() {
        return this.l;
    }

    @Nullable
    public ImageData getOptimalPortraitImage() {
        return this.k;
    }

    @NonNull
    public List<ImageData> getPortraitImages() {
        return new ArrayList(this.i);
    }

    public void setOptimalLandscapeImage(@Nullable ImageData imageData) {
        this.l = imageData;
    }

    public void setOptimalPortraitImage(@Nullable ImageData imageData) {
        this.k = imageData;
    }
}
