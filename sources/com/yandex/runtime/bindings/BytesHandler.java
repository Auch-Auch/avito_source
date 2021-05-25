package com.yandex.runtime.bindings;
public class BytesHandler implements ArchivingHandler<byte[]> {
    private final boolean isOptional;

    public BytesHandler() {
        this(false);
    }

    public BytesHandler(boolean z) {
        this.isOptional = z;
    }

    public byte[] add(byte[] bArr, Archive archive) {
        return archive.add(bArr, this.isOptional);
    }
}
