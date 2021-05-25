package org.spongycastle.asn1.eac;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.util.Arrays;
public class ECDSAPublicKey extends PublicKeyDataObject {
    public ASN1ObjectIdentifier a;
    public BigInteger b;
    public BigInteger c;
    public BigInteger d;
    public byte[] e;
    public BigInteger f;
    public byte[] g;
    public BigInteger h;
    public int i;

    public ECDSAPublicKey(ASN1Sequence aSN1Sequence) throws IllegalArgumentException {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = ASN1ObjectIdentifier.getInstance(objects.nextElement());
        this.i = 0;
        while (objects.hasMoreElements()) {
            Object nextElement = objects.nextElement();
            if (nextElement instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) nextElement;
                switch (aSN1TaggedObject.getTagNo()) {
                    case 1:
                        e(UnsignedInteger.getInstance(aSN1TaggedObject).getValue());
                        break;
                    case 2:
                        c(UnsignedInteger.getInstance(aSN1TaggedObject).getValue());
                        break;
                    case 3:
                        g(UnsignedInteger.getInstance(aSN1TaggedObject).getValue());
                        break;
                    case 4:
                        a(ASN1OctetString.getInstance(aSN1TaggedObject, false));
                        break;
                    case 5:
                        d(UnsignedInteger.getInstance(aSN1TaggedObject).getValue());
                        break;
                    case 6:
                        f(ASN1OctetString.getInstance(aSN1TaggedObject, false));
                        break;
                    case 7:
                        b(UnsignedInteger.getInstance(aSN1TaggedObject).getValue());
                        break;
                    default:
                        this.i = 0;
                        throw new IllegalArgumentException("Unknown Object Identifier!");
                }
            } else {
                throw new IllegalArgumentException("Unknown Object Identifier!");
            }
        }
        int i2 = this.i;
        if (i2 != 32 && i2 != 127) {
            throw new IllegalArgumentException("All options must be either present or absent!");
        }
    }

    public final void a(ASN1OctetString aSN1OctetString) throws IllegalArgumentException {
        int i2 = this.i;
        if ((i2 & 8) == 0) {
            this.i = i2 | 8;
            this.e = aSN1OctetString.getOctets();
            return;
        }
        throw new IllegalArgumentException("Base Point G already set");
    }

    public final void b(BigInteger bigInteger) throws IllegalArgumentException {
        int i2 = this.i;
        if ((i2 & 64) == 0) {
            this.i = i2 | 64;
            this.h = bigInteger;
            return;
        }
        throw new IllegalArgumentException("Cofactor F already set");
    }

    public final void c(BigInteger bigInteger) throws IllegalArgumentException {
        int i2 = this.i;
        if ((i2 & 2) == 0) {
            this.i = i2 | 2;
            this.c = bigInteger;
            return;
        }
        throw new IllegalArgumentException("First Coef A already set");
    }

    public final void d(BigInteger bigInteger) throws IllegalArgumentException {
        int i2 = this.i;
        if ((i2 & 16) == 0) {
            this.i = i2 | 16;
            this.f = bigInteger;
            return;
        }
        throw new IllegalArgumentException("Order of base point R already set");
    }

    public final void e(BigInteger bigInteger) {
        int i2 = this.i;
        if ((i2 & 1) == 0) {
            this.i = i2 | 1;
            this.b = bigInteger;
            return;
        }
        throw new IllegalArgumentException("Prime Modulus P already set");
    }

    public final void f(ASN1OctetString aSN1OctetString) throws IllegalArgumentException {
        int i2 = this.i;
        if ((i2 & 32) == 0) {
            this.i = i2 | 32;
            this.g = aSN1OctetString.getOctets();
            return;
        }
        throw new IllegalArgumentException("Public Point Y already set");
    }

    public final void g(BigInteger bigInteger) throws IllegalArgumentException {
        int i2 = this.i;
        if ((i2 & 4) == 0) {
            this.i = i2 | 4;
            this.d = bigInteger;
            return;
        }
        throw new IllegalArgumentException("Second Coef B already set");
    }

    public ASN1EncodableVector getASN1EncodableVector(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(aSN1ObjectIdentifier);
        if (!z) {
            aSN1EncodableVector.add(new UnsignedInteger(1, getPrimeModulusP()));
            aSN1EncodableVector.add(new UnsignedInteger(2, getFirstCoefA()));
            aSN1EncodableVector.add(new UnsignedInteger(3, getSecondCoefB()));
            aSN1EncodableVector.add(new DERTaggedObject(false, 4, new DEROctetString(getBasePointG())));
            aSN1EncodableVector.add(new UnsignedInteger(5, getOrderOfBasePointR()));
        }
        aSN1EncodableVector.add(new DERTaggedObject(false, 6, new DEROctetString(getPublicPointY())));
        if (!z) {
            aSN1EncodableVector.add(new UnsignedInteger(7, getCofactorF()));
        }
        return aSN1EncodableVector;
    }

    public byte[] getBasePointG() {
        if ((this.i & 8) != 0) {
            return Arrays.clone(this.e);
        }
        return null;
    }

    public BigInteger getCofactorF() {
        if ((this.i & 64) != 0) {
            return this.h;
        }
        return null;
    }

    public BigInteger getFirstCoefA() {
        if ((this.i & 2) != 0) {
            return this.c;
        }
        return null;
    }

    public BigInteger getOrderOfBasePointR() {
        if ((this.i & 16) != 0) {
            return this.f;
        }
        return null;
    }

    public BigInteger getPrimeModulusP() {
        if ((this.i & 1) != 0) {
            return this.b;
        }
        return null;
    }

    public byte[] getPublicPointY() {
        if ((this.i & 32) != 0) {
            return Arrays.clone(this.g);
        }
        return null;
    }

    public BigInteger getSecondCoefB() {
        if ((this.i & 4) != 0) {
            return this.d;
        }
        return null;
    }

    @Override // org.spongycastle.asn1.eac.PublicKeyDataObject
    public ASN1ObjectIdentifier getUsage() {
        return this.a;
    }

    public boolean hasParameters() {
        return this.b != null;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(getASN1EncodableVector(this.a, !hasParameters()));
    }

    public ECDSAPublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr) throws IllegalArgumentException {
        this.a = aSN1ObjectIdentifier;
        f(new DEROctetString(bArr));
    }

    public ECDSAPublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte[] bArr, BigInteger bigInteger4, byte[] bArr2, int i2) {
        this.a = aSN1ObjectIdentifier;
        e(bigInteger);
        c(bigInteger2);
        g(bigInteger3);
        a(new DEROctetString(bArr));
        d(bigInteger4);
        f(new DEROctetString(bArr2));
        b(BigInteger.valueOf((long) i2));
    }
}
