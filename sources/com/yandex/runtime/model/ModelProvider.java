package com.yandex.runtime.model;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.yandex.runtime.ByteBufferUtils;
import com.yandex.runtime.image.ImageProvider;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;
public abstract class ModelProvider {
    public static ModelProvider fromAsset(Context context, final String str, final ImageProvider imageProvider) {
        final AssetManager assets = context.getAssets();
        final String c3 = a.c3("model/asset:", str);
        return new ModelProvider() { // from class: com.yandex.runtime.model.ModelProvider.3
            @Override // com.yandex.runtime.model.ModelProvider
            public String getId() {
                return c3;
            }

            @Override // com.yandex.runtime.model.ModelProvider
            public ByteBuffer getModel() {
                try {
                    return ByteBufferUtils.fromAsset(assets, str);
                } catch (IOException unused) {
                    return null;
                }
            }

            @Override // com.yandex.runtime.model.ModelProvider
            public ImageProvider getTexture() {
                return imageProvider;
            }
        };
    }

    public static ModelProvider fromByteArray(final byte[] bArr, final ImageProvider imageProvider) {
        StringBuilder L = a.L("model/bytes:");
        L.append(UUID.randomUUID().toString());
        final String sb = L.toString();
        return new ModelProvider() { // from class: com.yandex.runtime.model.ModelProvider.1
            @Override // com.yandex.runtime.model.ModelProvider
            public String getId() {
                return sb;
            }

            @Override // com.yandex.runtime.model.ModelProvider
            public ByteBuffer getModel() {
                return ByteBufferUtils.fromByteArray(bArr);
            }

            @Override // com.yandex.runtime.model.ModelProvider
            public ImageProvider getTexture() {
                return imageProvider;
            }
        };
    }

    public static ModelProvider fromFile(final String str, final ImageProvider imageProvider) {
        final String c3 = a.c3("model/file:", str);
        return new ModelProvider() { // from class: com.yandex.runtime.model.ModelProvider.4
            @Override // com.yandex.runtime.model.ModelProvider
            public String getId() {
                return c3;
            }

            @Override // com.yandex.runtime.model.ModelProvider
            public ByteBuffer getModel() {
                try {
                    return ByteBufferUtils.fromFile(str);
                } catch (IOException unused) {
                    return null;
                }
            }

            @Override // com.yandex.runtime.model.ModelProvider
            public ImageProvider getTexture() {
                return imageProvider;
            }
        };
    }

    public static ModelProvider fromResource(Context context, final int i, final ImageProvider imageProvider) {
        final Resources resources = context.getResources();
        StringBuilder L = a.L("model/resource:");
        L.append(String.valueOf(i));
        final String sb = L.toString();
        return new ModelProvider() { // from class: com.yandex.runtime.model.ModelProvider.2
            @Override // com.yandex.runtime.model.ModelProvider
            public String getId() {
                return sb;
            }

            @Override // com.yandex.runtime.model.ModelProvider
            public ByteBuffer getModel() {
                try {
                    return ByteBufferUtils.fromResource(resources, i);
                } catch (IOException unused) {
                    String.valueOf(i);
                    return null;
                }
            }

            @Override // com.yandex.runtime.model.ModelProvider
            public ImageProvider getTexture() {
                return imageProvider;
            }
        };
    }

    public abstract String getId();

    public abstract ByteBuffer getModel();

    public abstract ImageProvider getTexture();
}
