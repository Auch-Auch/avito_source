package org.jsoup;

import java.io.IOException;
public class UnsupportedMimeTypeException extends IOException {
    public String a;
    public String b;

    public UnsupportedMimeTypeException(String str, String str2, String str3) {
        super(str);
        this.a = str2;
        this.b = str3;
    }

    public String getMimeType() {
        return this.a;
    }

    public String getUrl() {
        return this.b;
    }

    @Override // java.lang.Throwable, java.lang.Object
    public String toString() {
        return super.toString() + ". Mimetype=" + this.a + ", URL=" + this.b;
    }
}
