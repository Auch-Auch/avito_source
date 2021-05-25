package org.spongycastle.crypto.modes.gcm;

import java.util.Vector;
import org.spongycastle.util.Arrays;
public class Tables1kGCMExponentiator implements GCMExponentiator {
    public Vector a;

    @Override // org.spongycastle.crypto.modes.gcm.GCMExponentiator
    public void exponentiateX(long j, byte[] bArr) {
        int[] oneAsInts = GCMUtil.oneAsInts();
        int i = 0;
        while (j > 0) {
            if ((1 & j) != 0) {
                int size = this.a.size();
                if (size <= i) {
                    int[] iArr = (int[]) this.a.elementAt(size - 1);
                    do {
                        iArr = Arrays.clone(iArr);
                        GCMUtil.multiply(iArr, iArr);
                        this.a.addElement(iArr);
                        size++;
                    } while (size <= i);
                }
                GCMUtil.multiply(oneAsInts, (int[]) this.a.elementAt(i));
            }
            i++;
            j >>>= 1;
        }
        GCMUtil.asBytes(oneAsInts, bArr);
    }

    @Override // org.spongycastle.crypto.modes.gcm.GCMExponentiator
    public void init(byte[] bArr) {
        int[] asInts = GCMUtil.asInts(bArr);
        Vector vector = this.a;
        if (vector == null || !Arrays.areEqual(asInts, (int[]) vector.elementAt(0))) {
            Vector vector2 = new Vector(8);
            this.a = vector2;
            vector2.addElement(asInts);
        }
    }
}
