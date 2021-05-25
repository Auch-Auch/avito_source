package org.spongycastle.asn1;

import java.io.IOException;
import x6.e.a.i;
public class DLTaggedObject extends ASN1TaggedObject {
    public static final byte[] d = new byte[0];

    public DLTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int a() throws IOException {
        int a = this.c.toASN1Primitive().c().a();
        if (this.b) {
            return i.a(a) + i.b(this.a) + a;
        }
        return i.b(this.a) + (a - 1);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        ASN1Primitive c = this.c.toASN1Primitive().c();
        int i = 160;
        if (this.b) {
            aSN1OutputStream.h(160, this.a);
            aSN1OutputStream.g(c.a());
            aSN1OutputStream.writeObject(c);
            return;
        }
        if (!c.isConstructed()) {
            i = 128;
        }
        aSN1OutputStream.h(i, this.a);
        aSN1OutputStream.f(c);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        if (this.b) {
            return true;
        }
        return this.c.toASN1Primitive().c().isConstructed();
    }
}
