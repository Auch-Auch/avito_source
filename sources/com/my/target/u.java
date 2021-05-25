package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
import com.my.target.common.models.VideoData;
import java.util.ArrayList;
import java.util.List;
public class u extends d<cs> {
    @NonNull
    public static u j() {
        return new u();
    }

    @Nullable
    public cs a(@NonNull cs csVar, @NonNull a aVar, @NonNull Context context) {
        List<cg> ca = csVar.ca();
        if (ca.isEmpty()) {
            cl bQ = csVar.bQ();
            if (bQ == null || !bQ.bL()) {
                return null;
            }
            return csVar;
        }
        ArrayList arrayList = new ArrayList();
        int cachePolicy = aVar.getCachePolicy();
        boolean z = cachePolicy == 0 || cachePolicy == 1;
        for (cg cgVar : ca) {
            cf<VideoData> videoBanner = cgVar.getVideoBanner();
            if (videoBanner != null) {
                VideoData mediaData = videoBanner.getMediaData();
                boolean z2 = cachePolicy == 0 || cachePolicy == 2;
                if (mediaData != null && z2 && mediaData.isCacheable()) {
                    mediaData.setData((String) dg.cM().f(mediaData.getUrl(), context));
                }
            }
            ImageData image = cgVar.getImage();
            if (image != null) {
                image.useCache(true);
                if (z) {
                    arrayList.add(image);
                }
            }
            ImageData icon = cgVar.getIcon();
            if (icon != null) {
                icon.useCache(true);
                if (z) {
                    arrayList.add(icon);
                }
            }
            for (ch chVar : cgVar.getNativeAdCards()) {
                ImageData image2 = chVar.getImage();
                if (image2 != null) {
                    image2.useCache(true);
                    if (z) {
                        arrayList.add(image2);
                    }
                }
            }
            bo adChoices = cgVar.getAdChoices();
            if (adChoices != null) {
                ImageData icon2 = adChoices.getIcon();
                icon2.useCache(true);
                if (z) {
                    arrayList.add(icon2);
                }
            }
            ImageData ctcIcon = cgVar.getCtcIcon();
            if (ctcIcon != null) {
                arrayList.add(ctcIcon);
            }
        }
        if (arrayList.size() > 0) {
            ia.g(arrayList).ab(context);
        }
        return csVar;
    }
}
