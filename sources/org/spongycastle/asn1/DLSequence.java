package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import x6.e.a.i;
public class DLSequence extends ASN1Sequence {
    public int a = -1;

    public DLSequence() {
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int a() throws IOException {
        int e = e();
        return i.a(e) + 1 + e;
    }

    public final int e() throws IOException {
        if (this.a < 0) {
            int i = 0;
            Enumeration objects = getObjects();
            while (objects.hasMoreElements()) {
                i += ((ASN1Encodable) objects.nextElement()).toASN1Primitive().c().a();
            }
            this.a = i;
        }
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        ASN1OutputStream b = aSN1OutputStream.b();
        int e = e();
        aSN1OutputStream.c(48);
        aSN1OutputStream.g(e);
        Enumeration objects = getObjects();
        while (objects.hasMoreElements()) {
            b.writeObject((ASN1Encodable) objects.nextElement());
        }
    }

    public DLSequence(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public DLSequence(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector);
    }

    public DLSequence(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr);
    }
}
