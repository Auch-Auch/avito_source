package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import x6.e.a.i;
public class DERSet extends ASN1Set {
    public int c = -1;

    public DERSet() {
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int a() throws IOException {
        int e = e();
        return i.a(e) + 1 + e;
    }

    public final int e() throws IOException {
        if (this.c < 0) {
            int i = 0;
            Enumeration objects = getObjects();
            while (objects.hasMoreElements()) {
                i += ((ASN1Encodable) objects.nextElement()).toASN1Primitive().b().a();
            }
            this.c = i;
        }
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        ASN1OutputStream a = aSN1OutputStream.a();
        int e = e();
        aSN1OutputStream.c(49);
        aSN1OutputStream.g(e);
        Enumeration objects = getObjects();
        while (objects.hasMoreElements()) {
            a.writeObject((ASN1Encodable) objects.nextElement());
        }
    }

    public DERSet(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public DERSet(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector, true);
    }

    public DERSet(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr, true);
    }

    public DERSet(ASN1EncodableVector aSN1EncodableVector, boolean z) {
        super(aSN1EncodableVector, z);
    }
}
