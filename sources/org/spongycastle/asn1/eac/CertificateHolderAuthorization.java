package org.spongycastle.asn1.eac;

import a2.b.a.a.a;
import java.io.IOException;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERApplicationSpecific;
import org.spongycastle.util.Integers;
public class CertificateHolderAuthorization extends ASN1Object {
    public static final int CVCA = 192;
    public static final int DV_DOMESTIC = 128;
    public static final int DV_FOREIGN = 64;
    public static final int IS = 0;
    public static final int RADG3 = 1;
    public static final int RADG4 = 2;
    public static Hashtable c = new Hashtable();
    public static BidirectionalMap d = new BidirectionalMap();
    public static final ASN1ObjectIdentifier id_role_EAC = EACObjectIdentifiers.bsi_de.branch("3.1.2.1");
    public ASN1ObjectIdentifier a;
    public DERApplicationSpecific b;

    static {
        new Hashtable();
        c.put(Integers.valueOf(2), "RADG4");
        c.put(Integers.valueOf(1), "RADG3");
        d.put(Integers.valueOf(192), "CVCA");
        d.put(Integers.valueOf(128), "DV_DOMESTIC");
        d.put(Integers.valueOf(64), "DV_FOREIGN");
        d.put(Integers.valueOf(0), "IS");
    }

    public CertificateHolderAuthorization(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i) throws IOException {
        this.a = aSN1ObjectIdentifier;
        this.b = new DERApplicationSpecific(19, new byte[]{(byte) i});
    }

    public static int getFlag(String str) {
        Integer num = (Integer) d.getReverse(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException(a.c3("Unknown value ", str));
    }

    public static String getRoleDescription(int i) {
        return (String) d.get(Integers.valueOf(i));
    }

    public int getAccessRights() {
        return this.b.getContents()[0] & 255;
    }

    public ASN1ObjectIdentifier getOid() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        return new DERApplicationSpecific(76, aSN1EncodableVector);
    }

    public CertificateHolderAuthorization(DERApplicationSpecific dERApplicationSpecific) throws IOException {
        if (dERApplicationSpecific.getApplicationTag() == 76) {
            ASN1InputStream aSN1InputStream = new ASN1InputStream(dERApplicationSpecific.getContents());
            ASN1Primitive readObject = aSN1InputStream.readObject();
            if (readObject instanceof ASN1ObjectIdentifier) {
                this.a = (ASN1ObjectIdentifier) readObject;
                ASN1Primitive readObject2 = aSN1InputStream.readObject();
                if (readObject2 instanceof DERApplicationSpecific) {
                    this.b = (DERApplicationSpecific) readObject2;
                    return;
                }
                throw new IllegalArgumentException("No access rights in CerticateHolderAuthorization");
            }
            throw new IllegalArgumentException("no Oid in CerticateHolderAuthorization");
        }
    }
}
