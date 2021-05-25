package com.google.zxing.common.reedsolomon;

import a2.j.k.c.a.a;
import java.util.ArrayList;
import java.util.List;
public final class ReedSolomonEncoder {
    public final GenericGF a;
    public final List<a> b;

    public ReedSolomonEncoder(GenericGF genericGF) {
        this.a = genericGF;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new a(genericGF, new int[]{1}));
    }

    public void encode(int[] iArr, int i) {
        if (i != 0) {
            int length = iArr.length - i;
            if (length > 0) {
                if (i >= this.b.size()) {
                    a aVar = (a) a2.b.a.a.a.j2(this.b, 1);
                    for (int size = this.b.size(); size <= i; size++) {
                        GenericGF genericGF = this.a;
                        aVar = aVar.g(new a(genericGF, new int[]{1, genericGF.a[genericGF.getGeneratorBase() + (size - 1)]}));
                        this.b.add(aVar);
                    }
                }
                a aVar2 = this.b.get(i);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                a h = new a(this.a, iArr2).h(i, 1);
                if (!h.a.equals(aVar2.a)) {
                    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
                } else if (!aVar2.e()) {
                    a aVar3 = h.a.c;
                    int b2 = h.a.b(aVar2.c(aVar2.d()));
                    a aVar4 = h;
                    while (aVar4.d() >= aVar2.d() && !aVar4.e()) {
                        int d = aVar4.d() - aVar2.d();
                        int c = h.a.c(aVar4.c(aVar4.d()), b2);
                        a h2 = aVar2.h(d, c);
                        aVar3 = aVar3.a(h.a.a(d, c));
                        aVar4 = aVar4.a(h2);
                    }
                    int[] iArr3 = new a[]{aVar3, aVar4}[1].b;
                    int length2 = i - iArr3.length;
                    for (int i2 = 0; i2 < length2; i2++) {
                        iArr[length + i2] = 0;
                    }
                    System.arraycopy(iArr3, 0, iArr, length + length2, iArr3.length);
                } else {
                    throw new IllegalArgumentException("Divide by 0");
                }
            } else {
                throw new IllegalArgumentException("No data bytes provided");
            }
        } else {
            throw new IllegalArgumentException("No error correction bytes");
        }
    }
}
