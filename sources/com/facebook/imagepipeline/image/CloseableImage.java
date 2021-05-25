package com.facebook.imagepipeline.image;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
public abstract class CloseableImage implements Closeable, ImageInfo, HasImageMetadata {
    public static final String[] b = {ProducerContext.ExtraKeys.ENCODED_SIZE, ProducerContext.ExtraKeys.ENCODED_WIDTH, ProducerContext.ExtraKeys.ENCODED_HEIGHT, ProducerContext.ExtraKeys.SOURCE_URI, "image_format", "bitmap_config"};
    public Map<String, Object> a = new HashMap();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    @Override // java.lang.Object
    public void finalize() throws Throwable {
        if (!isClosed()) {
            FLog.w("CloseableImage", "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    @Override // com.facebook.imagepipeline.image.HasImageMetadata
    @Nonnull
    public Map<String, Object> getExtras() {
        return this.a;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public QualityInfo getQualityInfo() {
        return ImmutableQualityInfo.FULL_QUALITY;
    }

    public abstract int getSizeInBytes();

    public abstract boolean isClosed();

    public boolean isStateful() {
        return false;
    }

    public void setImageExtras(Map<String, Object> map) {
        if (map != null) {
            String[] strArr = b;
            for (String str : strArr) {
                Object obj = map.get(str);
                if (obj != null) {
                    this.a.put(str, obj);
                }
            }
        }
    }
}
