package com.google.android.datatransport.runtime;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Encoding;
import java.util.Arrays;
import java.util.Objects;
public final class EncodedPayload {
    public final Encoding a;
    public final byte[] b;

    public EncodedPayload(@NonNull Encoding encoding, @NonNull byte[] bArr) {
        Objects.requireNonNull(encoding, "encoding is null");
        Objects.requireNonNull(bArr, "bytes is null");
        this.a = encoding;
        this.b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (!this.a.equals(encodedPayload.a)) {
            return false;
        }
        return Arrays.equals(this.b, encodedPayload.b);
    }

    public byte[] getBytes() {
        return this.b;
    }

    public Encoding getEncoding() {
        return this.a;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public String toString() {
        StringBuilder L = a.L("EncodedPayload{encoding=");
        L.append(this.a);
        L.append(", bytes=[...]}");
        return L.toString();
    }
}
