package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtIncompatible
public final class FileBackedOutputStream extends OutputStream {
    public final int a;
    public final boolean b;
    public final ByteSource c;
    public OutputStream d;
    public c e;
    @NullableDecl
    public File f;

    public class a extends ByteSource {
        public a() {
        }

        public void finalize() {
            try {
                FileBackedOutputStream.this.reset();
            } catch (Throwable th) {
                th.printStackTrace(System.err);
            }
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return FileBackedOutputStream.a(FileBackedOutputStream.this);
        }
    }

    public class b extends ByteSource {
        public b() {
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return FileBackedOutputStream.a(FileBackedOutputStream.this);
        }
    }

    public static class c extends ByteArrayOutputStream {
        public c(a aVar) {
        }

        public byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }

        public int getCount() {
            return ((ByteArrayOutputStream) this).count;
        }
    }

    public FileBackedOutputStream(int i) {
        this(i, false);
    }

    public static InputStream a(FileBackedOutputStream fileBackedOutputStream) throws IOException {
        InputStream inputStream;
        synchronized (fileBackedOutputStream) {
            if (fileBackedOutputStream.f != null) {
                inputStream = new FileInputStream(fileBackedOutputStream.f);
            } else {
                inputStream = new ByteArrayInputStream(fileBackedOutputStream.e.a(), 0, fileBackedOutputStream.e.getCount());
            }
        }
        return inputStream;
    }

    public ByteSource asByteSource() {
        return this.c;
    }

    public final void b(int i) throws IOException {
        if (this.f == null && this.e.getCount() + i > this.a) {
            File createTempFile = File.createTempFile("FileBackedOutputStream", null);
            if (this.b) {
                createTempFile.deleteOnExit();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(this.e.a(), 0, this.e.getCount());
            fileOutputStream.flush();
            this.d = fileOutputStream;
            this.f = createTempFile;
            this.e = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.d.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        this.d.flush();
    }

    public synchronized void reset() throws IOException {
        try {
            close();
            c cVar = this.e;
            if (cVar == null) {
                this.e = new c(null);
            } else {
                cVar.reset();
            }
            this.d = this.e;
            File file = this.f;
            if (file != null) {
                this.f = null;
                if (!file.delete()) {
                    throw new IOException("Could not delete: " + file);
                }
            }
        } catch (Throwable th) {
            if (this.e == null) {
                this.e = new c(null);
            } else {
                this.e.reset();
            }
            this.d = this.e;
            File file2 = this.f;
            if (file2 != null) {
                this.f = null;
                if (!file2.delete()) {
                    throw new IOException("Could not delete: " + file2);
                }
            }
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        b(1);
        this.d.write(i);
    }

    public FileBackedOutputStream(int i, boolean z) {
        this.a = i;
        this.b = z;
        c cVar = new c(null);
        this.e = cVar;
        this.d = cVar;
        if (z) {
            this.c = new a();
        } else {
            this.c = new b();
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        b(i2);
        this.d.write(bArr, i, i2);
    }
}
