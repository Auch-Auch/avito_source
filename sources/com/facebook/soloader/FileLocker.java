package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import javax.annotation.Nullable;
public final class FileLocker implements Closeable {
    public final FileOutputStream a;
    @Nullable
    public final FileLock b;

    public FileLocker(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        this.a = fileOutputStream;
        try {
            FileLock lock = fileOutputStream.getChannel().lock();
            if (lock == null) {
                fileOutputStream.close();
            }
            this.b = lock;
        } catch (Throwable th) {
            this.a.close();
            throw th;
        }
    }

    public static FileLocker lock(File file) throws IOException {
        return new FileLocker(file);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            FileLock fileLock = this.b;
            if (fileLock != null) {
                fileLock.release();
            }
        } finally {
            this.a.close();
        }
    }
}
