package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.support.annotation.NonNull;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;
public abstract class xd {
    @NonNull
    public xg a;
    @NonNull
    public Uri b;
    @NonNull
    private Socket c;

    public xd(@NonNull Socket socket, @NonNull Uri uri, @NonNull xg xgVar) {
        this.c = socket;
        this.b = uri;
        this.a = xgVar;
    }

    public abstract void a();

    public void a(@NonNull String str, @NonNull Map<String, String> map, @NonNull byte[] bArr) {
        Throwable th;
        IOException e;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(this.c.getOutputStream());
            try {
                bufferedOutputStream2.write(str.getBytes());
                a(bufferedOutputStream2);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    a(bufferedOutputStream2, entry.getKey(), entry.getValue());
                }
                a(bufferedOutputStream2);
                bufferedOutputStream2.write(bArr);
                bufferedOutputStream2.flush();
                this.a.a(this.c.getLocalPort());
                dl.a((Closeable) bufferedOutputStream2);
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    this.a.a("io_exception_during_sync", e);
                    dl.a((Closeable) bufferedOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    dl.a((Closeable) bufferedOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = bufferedOutputStream2;
                dl.a((Closeable) bufferedOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            this.a.a("io_exception_during_sync", e);
            dl.a((Closeable) bufferedOutputStream);
        }
    }

    private void a(@NonNull OutputStream outputStream, @NonNull String str, @NonNull String str2) throws IOException {
        outputStream.write((str + ": " + str2).getBytes());
        a(outputStream);
    }

    private void a(@NonNull OutputStream outputStream) throws IOException {
        outputStream.write("\r\n".getBytes());
    }
}
