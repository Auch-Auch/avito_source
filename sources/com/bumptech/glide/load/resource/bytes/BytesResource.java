package com.bumptech.glide.load.resource.bytes;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
public class BytesResource implements Resource<byte[]> {
    public final byte[] a;

    public BytesResource(byte[] bArr) {
        this.a = (byte[]) Preconditions.checkNotNull(bArr);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<byte[]> getResourceClass() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.a.length;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public byte[] get() {
        return this.a;
    }
}
