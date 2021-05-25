package com.facebook.binaryresource;

import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
public class ByteArrayBinaryResource implements BinaryResource {
    public final byte[] a;

    public ByteArrayBinaryResource(byte[] bArr) {
        this.a = (byte[]) Preconditions.checkNotNull(bArr);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public InputStream openStream() throws IOException {
        return new ByteArrayInputStream(this.a);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public byte[] read() {
        return this.a;
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public long size() {
        return (long) this.a.length;
    }
}
