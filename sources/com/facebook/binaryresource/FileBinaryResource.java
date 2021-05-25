package com.facebook.binaryresource;

import com.facebook.common.internal.Files;
import com.facebook.common.internal.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
public class FileBinaryResource implements BinaryResource {
    public final File a;

    public FileBinaryResource(File file) {
        this.a = (File) Preconditions.checkNotNull(file);
    }

    @Nullable
    public static FileBinaryResource createOrNull(File file) {
        if (file != null) {
            return new FileBinaryResource(file);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FileBinaryResource)) {
            return false;
        }
        return this.a.equals(((FileBinaryResource) obj).a);
    }

    public File getFile() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public InputStream openStream() throws IOException {
        return new FileInputStream(this.a);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public byte[] read() throws IOException {
        return Files.toByteArray(this.a);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public long size() {
        return this.a.length();
    }
}
