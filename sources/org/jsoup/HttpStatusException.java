package org.jsoup;

import java.io.IOException;
public class HttpStatusException extends IOException {
    public int a;
    public String b;

    public HttpStatusException(String str, int i, String str2) {
        super(str);
        this.a = i;
        this.b = str2;
    }

    public int getStatusCode() {
        return this.a;
    }

    public String getUrl() {
        return this.b;
    }

    @Override // java.lang.Throwable, java.lang.Object
    public String toString() {
        return super.toString() + ". Status=" + this.a + ", URL=" + this.b;
    }
}
