package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.UnpackingSoSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public final class ExoSoSource extends UnpackingSoSource {

    public final class b extends UnpackingSoSource.Unpacker {
        public final c[] a;

        public final class a extends UnpackingSoSource.InputDsoIterator {
            public int a;

            public a(a aVar) {
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public boolean hasNext() {
                return this.a < b.this.a.length;
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public UnpackingSoSource.InputDso next() throws IOException {
                c[] cVarArr = b.this.a;
                int i = this.a;
                this.a = i + 1;
                c cVar = cVarArr[i];
                FileInputStream fileInputStream = new FileInputStream(cVar.a);
                try {
                    return new UnpackingSoSource.InputDso(cVar, fileInputStream);
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e6, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r7.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ec, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ed, code lost:
            r0.addSuppressed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f1, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f5, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            r9.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00fb, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fc, code lost:
            r0.addSuppressed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0100, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public b(com.facebook.soloader.ExoSoSource r17, com.facebook.soloader.UnpackingSoSource r18) throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 291
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.ExoSoSource.b.<init>(com.facebook.soloader.ExoSoSource, com.facebook.soloader.UnpackingSoSource):void");
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public UnpackingSoSource.DsoManifest getDsoManifest() throws IOException {
            return new UnpackingSoSource.DsoManifest(this.a);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public UnpackingSoSource.InputDsoIterator openDsoIterator() throws IOException {
            return new a(null);
        }
    }

    public static final class c extends UnpackingSoSource.Dso {
        public final File a;

        public c(String str, String str2, File file) {
            super(str, str2);
            this.a = file;
        }
    }

    public ExoSoSource(Context context, String str) {
        super(context, str);
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public UnpackingSoSource.Unpacker makeUnpacker() throws IOException {
        return new b(this, this);
    }
}
