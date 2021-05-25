package org.spongycastle.util;

import com.google.common.base.Ascii;
import org.spongycastle.crypto.digests.SHA512tDigest;
public class Fingerprint {
    public static char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public final byte[] a;

    public Fingerprint(byte[] bArr) {
        this.a = calculateFingerprint(bArr);
    }

    public static byte[] calculateFingerprint(byte[] bArr) {
        SHA512tDigest sHA512tDigest = new SHA512tDigest(160);
        sHA512tDigest.update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[sHA512tDigest.getDigestSize()];
        sHA512tDigest.doFinal(bArr2, 0);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Fingerprint) {
            return Arrays.areEqual(((Fingerprint) obj).a, this.a);
        }
        return false;
    }

    public byte[] getFingerprint() {
        return Arrays.clone(this.a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i != this.a.length; i++) {
            if (i > 0) {
                stringBuffer.append(":");
            }
            stringBuffer.append(b[(this.a[i] >>> 4) & 15]);
            stringBuffer.append(b[this.a[i] & Ascii.SI]);
        }
        return stringBuffer.toString();
    }
}
