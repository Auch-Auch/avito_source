package org.spongycastle.asn1.x500;

import java.util.Enumeration;
import java.util.Objects;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.style.BCStyle;
public class X500Name extends ASN1Object implements ASN1Choice {
    public static X500NameStyle e = BCStyle.INSTANCE;
    public boolean a;
    public int b;
    public X500NameStyle c;
    public RDN[] d;

    public X500Name(X500NameStyle x500NameStyle, X500Name x500Name) {
        this.d = x500Name.d;
        this.c = x500NameStyle;
    }

    public static X500NameStyle getDefaultStyle() {
        return e;
    }

    public static X500Name getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, true));
    }

    public static void setDefaultStyle(X500NameStyle x500NameStyle) {
        Objects.requireNonNull(x500NameStyle, "cannot set style to null");
        e = x500NameStyle;
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X500Name) && !(obj instanceof ASN1Sequence)) {
            return false;
        }
        if (toASN1Primitive().equals(((ASN1Encodable) obj).toASN1Primitive())) {
            return true;
        }
        try {
            return this.c.areEqual(this, new X500Name(e, ASN1Sequence.getInstance(((ASN1Encodable) obj).toASN1Primitive())));
        } catch (Exception unused) {
            return false;
        }
    }

    public ASN1ObjectIdentifier[] getAttributeTypes() {
        int i = 0;
        int i2 = 0;
        while (true) {
            RDN[] rdnArr = this.d;
            if (i == rdnArr.length) {
                break;
            }
            i2 += rdnArr[i].size();
            i++;
        }
        ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = new ASN1ObjectIdentifier[i2];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            RDN[] rdnArr2 = this.d;
            if (i3 == rdnArr2.length) {
                return aSN1ObjectIdentifierArr;
            }
            RDN rdn = rdnArr2[i3];
            if (rdn.isMultiValued()) {
                AttributeTypeAndValue[] typesAndValues = rdn.getTypesAndValues();
                int i5 = 0;
                while (i5 != typesAndValues.length) {
                    aSN1ObjectIdentifierArr[i4] = typesAndValues[i5].getType();
                    i5++;
                    i4++;
                }
            } else if (rdn.size() != 0) {
                aSN1ObjectIdentifierArr[i4] = rdn.getFirst().getType();
                i4++;
            }
            i3++;
        }
    }

    public RDN[] getRDNs() {
        RDN[] rdnArr = this.d;
        int length = rdnArr.length;
        RDN[] rdnArr2 = new RDN[length];
        System.arraycopy(rdnArr, 0, rdnArr2, 0, length);
        return rdnArr2;
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        if (this.a) {
            return this.b;
        }
        this.a = true;
        int calculateHashCode = this.c.calculateHashCode(this);
        this.b = calculateHashCode;
        return calculateHashCode;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.d);
    }

    public String toString() {
        return this.c.toString(this);
    }

    public static X500Name getInstance(Object obj) {
        if (obj instanceof X500Name) {
            return (X500Name) obj;
        }
        if (obj == null) {
            return null;
        }
        return new X500Name(e, ASN1Sequence.getInstance(obj));
    }

    public RDN[] getRDNs(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        int i;
        RDN[] rdnArr = new RDN[this.d.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            RDN[] rdnArr2 = this.d;
            if (i2 != rdnArr2.length) {
                RDN rdn = rdnArr2[i2];
                if (rdn.isMultiValued()) {
                    AttributeTypeAndValue[] typesAndValues = rdn.getTypesAndValues();
                    int i4 = 0;
                    while (true) {
                        if (i4 == typesAndValues.length) {
                            break;
                        } else if (typesAndValues[i4].getType().equals(aSN1ObjectIdentifier)) {
                            i = i3 + 1;
                            rdnArr[i3] = rdn;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    i2++;
                } else if (rdn.getFirst().getType().equals(aSN1ObjectIdentifier)) {
                    i = i3 + 1;
                    rdnArr[i3] = rdn;
                } else {
                    i2++;
                }
                i3 = i;
                i2++;
            } else {
                RDN[] rdnArr3 = new RDN[i3];
                System.arraycopy(rdnArr, 0, rdnArr3, 0, i3);
                return rdnArr3;
            }
        }
    }

    public X500Name(X500NameStyle x500NameStyle, ASN1Sequence aSN1Sequence) {
        this.c = x500NameStyle;
        this.d = new RDN[aSN1Sequence.size()];
        Enumeration objects = aSN1Sequence.getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            this.d[i] = RDN.getInstance(objects.nextElement());
            i++;
        }
    }

    public static X500Name getInstance(X500NameStyle x500NameStyle, Object obj) {
        if (obj instanceof X500Name) {
            return new X500Name(x500NameStyle, (X500Name) obj);
        }
        if (obj != null) {
            return new X500Name(x500NameStyle, ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public X500Name(RDN[] rdnArr) {
        this(e, rdnArr);
    }

    public X500Name(X500NameStyle x500NameStyle, RDN[] rdnArr) {
        this.d = rdnArr;
        this.c = x500NameStyle;
    }

    public X500Name(String str) {
        this(e, str);
    }

    public X500Name(X500NameStyle x500NameStyle, String str) {
        this(x500NameStyle.fromString(str));
        this.c = x500NameStyle;
    }
}
