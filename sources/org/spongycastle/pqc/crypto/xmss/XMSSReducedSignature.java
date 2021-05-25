package org.spongycastle.pqc.crypto.xmss;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import x6.e.f.a.d.e;
import x6.e.f.a.d.g;
public class XMSSReducedSignature implements XMSSStoreableObjectInterface {
    public final XMSSParameters a;
    public final g b;
    public final List<XMSSNode> c;

    public static class Builder {
        public final XMSSParameters a;
        public g b = null;
        public List<XMSSNode> c = null;
        public byte[] d = null;

        public Builder(XMSSParameters xMSSParameters) {
            this.a = xMSSParameters;
        }

        public XMSSReducedSignature build() {
            return new XMSSReducedSignature(this);
        }

        public Builder withAuthPath(List<XMSSNode> list) {
            this.c = list;
            return this;
        }

        public Builder withReducedSignature(byte[] bArr) {
            this.d = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withWOTSPlusSignature(g gVar) {
            this.b = gVar;
            return this;
        }
    }

    public XMSSReducedSignature(Builder builder) {
        XMSSParameters xMSSParameters = builder.a;
        this.a = xMSSParameters;
        Objects.requireNonNull(xMSSParameters, "params == null");
        int digestSize = xMSSParameters.getDigestSize();
        int i = xMSSParameters.a.a.e;
        int height = xMSSParameters.getHeight();
        byte[] bArr = builder.d;
        if (bArr != null) {
            if (bArr.length == (height * digestSize) + (i * digestSize)) {
                byte[][] bArr2 = new byte[i][];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    bArr2[i3] = XMSSUtil.extractBytesAtOffset(bArr, i2, digestSize);
                    i2 += digestSize;
                }
                this.b = new g(this.a.a.a, bArr2);
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < height; i4++) {
                    arrayList.add(new XMSSNode(i4, XMSSUtil.extractBytesAtOffset(bArr, i2, digestSize)));
                    i2 += digestSize;
                }
                this.c = arrayList;
                return;
            }
            throw new IllegalArgumentException("signature has wrong size");
        }
        g gVar = builder.b;
        if (gVar != null) {
            this.b = gVar;
        } else {
            e eVar = xMSSParameters.a.a;
            int[] iArr = new int[2];
            iArr[1] = digestSize;
            iArr[0] = i;
            this.b = new g(eVar, (byte[][]) Array.newInstance(byte.class, iArr));
        }
        List<XMSSNode> list = builder.c;
        if (list == null) {
            this.c = new ArrayList();
        } else if (list.size() == height) {
            this.c = list;
        } else {
            throw new IllegalArgumentException("size of authPath needs to be equal to height of tree");
        }
    }

    public List<XMSSNode> getAuthPath() {
        return this.c;
    }

    public XMSSParameters getParams() {
        return this.a;
    }

    public g getWOTSPlusSignature() {
        return this.b;
    }

    @Override // org.spongycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface
    public byte[] toByteArray() {
        byte[][] a3;
        int digestSize = this.a.getDigestSize();
        XMSSParameters xMSSParameters = this.a;
        byte[] bArr = new byte[((xMSSParameters.getHeight() * digestSize) + (xMSSParameters.a.a.e * digestSize))];
        int i = 0;
        for (byte[] bArr2 : this.b.a()) {
            XMSSUtil.copyBytesAtOffset(bArr, bArr2, i);
            i += digestSize;
        }
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            XMSSUtil.copyBytesAtOffset(bArr, this.c.get(i2).getValue(), i);
            i += digestSize;
        }
        return bArr;
    }
}
