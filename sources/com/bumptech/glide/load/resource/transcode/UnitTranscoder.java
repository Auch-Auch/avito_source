package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
public class UnitTranscoder<Z> implements ResourceTranscoder<Z, Z> {
    public static final UnitTranscoder<?> a = new UnitTranscoder<>();

    public static <Z> ResourceTranscoder<Z, Z> get() {
        return a;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    @Nullable
    public Resource<Z> transcode(@NonNull Resource<Z> resource, @NonNull Options options) {
        return resource;
    }
}
