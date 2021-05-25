package org.spongycastle.asn1;

import a2.b.a.a.a;
import java.io.IOException;
import java.util.Enumeration;
import x6.e.a.i;
public class BERTaggedObject extends ASN1TaggedObject {
    public BERTaggedObject(int i, ASN1Encodable aSN1Encodable) {
        super(true, i, aSN1Encodable);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int a() throws IOException {
        int a = this.c.toASN1Primitive().a();
        if (this.b) {
            return i.a(a) + i.b(this.a) + a;
        }
        return i.b(this.a) + (a - 1);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        Enumeration enumeration;
        aSN1OutputStream.h(160, this.a);
        aSN1OutputStream.c(128);
        if (!this.b) {
            ASN1Encodable aSN1Encodable = this.c;
            if (aSN1Encodable instanceof ASN1OctetString) {
                if (aSN1Encodable instanceof BEROctetString) {
                    enumeration = ((BEROctetString) aSN1Encodable).getObjects();
                } else {
                    enumeration = new BEROctetString(((ASN1OctetString) aSN1Encodable).getOctets()).getObjects();
                }
            } else if (aSN1Encodable instanceof ASN1Sequence) {
                enumeration = ((ASN1Sequence) aSN1Encodable).getObjects();
            } else if (aSN1Encodable instanceof ASN1Set) {
                enumeration = ((ASN1Set) aSN1Encodable).getObjects();
            } else {
                StringBuilder L = a.L("not implemented: ");
                L.append(this.c.getClass().getName());
                throw new ASN1Exception(L.toString());
            }
            while (enumeration.hasMoreElements()) {
                aSN1OutputStream.writeObject((ASN1Encodable) enumeration.nextElement());
            }
        } else {
            aSN1OutputStream.writeObject(this.c);
        }
        aSN1OutputStream.c(0);
        aSN1OutputStream.c(0);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        if (this.b) {
            return true;
        }
        return this.c.toASN1Primitive().b().isConstructed();
    }

    public BERTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    public BERTaggedObject(int i) {
        super(false, i, new BERSequence());
    }
}
