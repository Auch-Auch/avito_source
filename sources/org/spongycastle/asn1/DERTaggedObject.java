package org.spongycastle.asn1;

import java.io.IOException;
import x6.e.a.i;
public class DERTaggedObject extends ASN1TaggedObject {
    public static final byte[] d = new byte[0];

    public DERTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int a() throws IOException {
        int a = this.c.toASN1Primitive().b().a();
        if (this.b) {
            return i.a(a) + i.b(this.a) + a;
        }
        return i.b(this.a) + (a - 1);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        ASN1Primitive b = this.c.toASN1Primitive().b();
        int i = 160;
        if (this.b) {
            aSN1OutputStream.h(160, this.a);
            aSN1OutputStream.g(b.a());
            aSN1OutputStream.writeObject(b);
            return;
        }
        if (!b.isConstructed()) {
            i = 128;
        }
        aSN1OutputStream.h(i, this.a);
        aSN1OutputStream.f(b);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        if (this.b) {
            return true;
        }
        return this.c.toASN1Primitive().b().isConstructed();
    }

    public DERTaggedObject(int i, ASN1Encodable aSN1Encodable) {
        super(true, i, aSN1Encodable);
    }
}
