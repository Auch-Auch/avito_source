package com.my.target.common.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ae;
import com.my.target.bt;
import java.util.List;
public final class VideoData extends bt<String> {
    public static final String M3U8 = ".m3u8";
    public int b;
    public final boolean c = (!this.url.endsWith(M3U8));

    public VideoData(@NonNull String str, int i, int i2) {
        super(str);
        this.width = i;
        this.height = i2;
    }

    @Nullable
    public static VideoData chooseBest(@NonNull List<VideoData> list, int i) {
        VideoData videoData = null;
        int i2 = 0;
        for (VideoData videoData2 : list) {
            int height = videoData2.getHeight();
            if (videoData == null || ((height <= i && i2 > i) || ((height <= i && height > i2) || (height > i && height < i2)))) {
                videoData = videoData2;
                i2 = height;
            }
        }
        ae.a("Accepted videoData quality = " + i2 + "p");
        return videoData;
    }

    @NonNull
    public static VideoData newVideoData(@NonNull String str, int i, int i2) {
        return new VideoData(str, i, i2);
    }

    public int getBitrate() {
        return this.b;
    }

    public boolean isCacheable() {
        return this.c;
    }

    public void setBitrate(int i) {
        this.b = i;
    }
}
