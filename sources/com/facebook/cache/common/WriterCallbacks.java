package com.facebook.cache.common;

import com.facebook.common.internal.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class WriterCallbacks {

    public static class a implements WriterCallback {
        public final /* synthetic */ InputStream a;

        public a(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // com.facebook.cache.common.WriterCallback
        public void write(OutputStream outputStream) throws IOException {
            ByteStreams.copy(this.a, outputStream);
        }
    }

    public static class b implements WriterCallback {
        public final /* synthetic */ byte[] a;

        public b(byte[] bArr) {
            this.a = bArr;
        }

        @Override // com.facebook.cache.common.WriterCallback
        public void write(OutputStream outputStream) throws IOException {
            outputStream.write(this.a);
        }
    }

    public static WriterCallback from(InputStream inputStream) {
        return new a(inputStream);
    }

    public static WriterCallback from(byte[] bArr) {
        return new b(bArr);
    }
}
