package com.yandex.runtime.image;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.yandex.runtime.ByteBufferUtils;
import java.io.IOException;
import java.util.UUID;
public abstract class AnimatedImageProvider {

    public static abstract class AnimatedImageProviderImpl extends AnimatedImageProvider {
        private final String id;
        private Object image;

        public AnimatedImageProviderImpl(String str) {
            this.id = str;
        }

        @Override // com.yandex.runtime.image.AnimatedImageProvider
        public String getId() {
            return this.id;
        }

        @Override // com.yandex.runtime.image.AnimatedImageProvider
        public Object getImage() {
            if (this.image == null) {
                this.image = loadImage();
            }
            return this.image;
        }

        public abstract Object loadImage();
    }

    public static AnimatedImageProvider fromAnimatedImage(final AnimatedImage animatedImage) {
        StringBuilder L = a.L("animation/image:");
        L.append(UUID.randomUUID().toString());
        final String sb = L.toString();
        return new AnimatedImageProvider() { // from class: com.yandex.runtime.image.AnimatedImageProvider.5
            @Override // com.yandex.runtime.image.AnimatedImageProvider
            public String getId() {
                return sb;
            }

            @Override // com.yandex.runtime.image.AnimatedImageProvider
            public Object getImage() {
                return animatedImage;
            }
        };
    }

    public static AnimatedImageProvider fromAsset(Context context, final String str) {
        final AssetManager assets = context.getAssets();
        return new AnimatedImageProviderImpl(a.c3("animation/asset:", str)) { // from class: com.yandex.runtime.image.AnimatedImageProvider.3
            @Override // com.yandex.runtime.image.AnimatedImageProvider.AnimatedImageProviderImpl
            public Object loadImage() {
                try {
                    return ByteBufferUtils.fromAsset(assets, str);
                } catch (IOException unused) {
                    return null;
                }
            }
        };
    }

    public static AnimatedImageProvider fromByteArray(final byte[] bArr) {
        StringBuilder L = a.L("animation/bytes:");
        L.append(UUID.randomUUID().toString());
        final String sb = L.toString();
        return new AnimatedImageProvider() { // from class: com.yandex.runtime.image.AnimatedImageProvider.1
            @Override // com.yandex.runtime.image.AnimatedImageProvider
            public String getId() {
                return sb;
            }

            @Override // com.yandex.runtime.image.AnimatedImageProvider
            public Object getImage() {
                return ByteBufferUtils.fromByteArray(bArr);
            }
        };
    }

    public static AnimatedImageProvider fromFile(final String str) {
        return new AnimatedImageProviderImpl(a.c3("animation/file:", str)) { // from class: com.yandex.runtime.image.AnimatedImageProvider.4
            @Override // com.yandex.runtime.image.AnimatedImageProvider.AnimatedImageProviderImpl
            public Object loadImage() {
                try {
                    return ByteBufferUtils.fromFile(str);
                } catch (IOException unused) {
                    return null;
                }
            }
        };
    }

    public static AnimatedImageProvider fromResource(Context context, final int i) {
        final Resources resources = context.getResources();
        StringBuilder L = a.L("animation/resource:");
        L.append(String.valueOf(i));
        return new AnimatedImageProviderImpl(L.toString()) { // from class: com.yandex.runtime.image.AnimatedImageProvider.2
            @Override // com.yandex.runtime.image.AnimatedImageProvider.AnimatedImageProviderImpl
            public Object loadImage() {
                try {
                    return ByteBufferUtils.fromResource(resources, i);
                } catch (IOException unused) {
                    String.valueOf(i);
                    return null;
                }
            }
        };
    }

    public abstract String getId();

    public abstract Object getImage();
}
