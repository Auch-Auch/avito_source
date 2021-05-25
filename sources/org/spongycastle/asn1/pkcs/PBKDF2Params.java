package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.util.Arrays;
public class PBKDF2Params extends ASN1Object {
    public static final AlgorithmIdentifier e = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA1, DERNull.INSTANCE);
    public final ASN1OctetString a;
    public final ASN1Integer b;
    public final ASN1Integer c;
    public final AlgorithmIdentifier d;

    public PBKDF2Params(byte[] bArr, int i) {
        this(bArr, i, 0);
    }

    public static PBKDF2Params getInstance(Object obj) {
        if (obj instanceof PBKDF2Params) {
            return (PBKDF2Params) obj;
        }
        if (obj != null) {
            return new PBKDF2Params(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getIterationCount() {
        return this.b.getValue();
    }

    public BigInteger getKeyLength() {
        ASN1Integer aSN1Integer = this.c;
        if (aSN1Integer != null) {
            return aSN1Integer.getValue();
        }
        return null;
    }

    public AlgorithmIdentifier getPrf() {
        AlgorithmIdentifier algorithmIdentifier = this.d;
        if (algorithmIdentifier != null) {
            return algorithmIdentifier;
        }
        return e;
    }

    public byte[] getSalt() {
        return this.a.getOctets();
    }

    public boolean isDefaultPrf() {
        AlgorithmIdentifier algorithmIdentifier = this.d;
        return algorithmIdentifier == null || algorithmIdentifier.equals(e);
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        ASN1Integer aSN1Integer = this.c;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        AlgorithmIdentifier algorithmIdentifier = this.d;
        if (algorithmIdentifier != null && !algorithmIdentifier.equals(e)) {
            aSN1EncodableVector.add(this.d);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public PBKDF2Params(byte[] bArr, int i, int i2) {
        this(bArr, i, i2, null);
    }

    public PBKDF2Params(byte[] bArr, int i, int i2, AlgorithmIdentifier algorithmIdentifier) {
        this.a = new DEROctetString(Arrays.clone(bArr));
        this.b = new ASN1Integer((long) i);
        if (i2 > 0) {
            this.c = new ASN1Integer((long) i2);
        } else {
            this.c = null;
        }
        this.d = algorithmIdentifier;
    }

    public PBKDF2Params(byte[] bArr, int i, AlgorithmIdentifier algorithmIdentifier) {
        this(bArr, i, 0, algorithmIdentifier);
    }

    public PBKDF2Params(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = (ASN1OctetString) objects.nextElement();
        this.b = (ASN1Integer) objects.nextElement();
        if (objects.hasMoreElements()) {
            Object nextElement = objects.nextElement();
            if (nextElement instanceof ASN1Integer) {
                this.c = ASN1Integer.getInstance(nextElement);
                nextElement = objects.hasMoreElements() ? objects.nextElement() : null;
            } else {
                this.c = null;
            }
            if (nextElement != null) {
                this.d = AlgorithmIdentifier.getInstance(nextElement);
            } else {
                this.d = null;
            }
        } else {
            this.c = null;
            this.d = null;
        }
    }
}
