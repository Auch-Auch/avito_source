package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.crypto.digests.SHA1Digest;
public class AuthorityKeyIdentifier extends ASN1Object {
    public ASN1OctetString a;
    public GeneralNames b;
    public ASN1Integer c;

    public AuthorityKeyIdentifier(ASN1Sequence aSN1Sequence) {
        this.a = null;
        this.b = null;
        this.c = null;
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(objects.nextElement());
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                this.a = ASN1OctetString.getInstance(instance, false);
            } else if (tagNo == 1) {
                this.b = GeneralNames.getInstance(instance, false);
            } else if (tagNo == 2) {
                this.c = ASN1Integer.getInstance(instance, false);
            } else {
                throw new IllegalArgumentException("illegal tag");
            }
        }
    }

    public static AuthorityKeyIdentifier fromExtensions(Extensions extensions) {
        return getInstance(extensions.getExtensionParsedValue(Extension.authorityKeyIdentifier));
    }

    public static AuthorityKeyIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public GeneralNames getAuthorityCertIssuer() {
        return this.b;
    }

    public BigInteger getAuthorityCertSerialNumber() {
        ASN1Integer aSN1Integer = this.c;
        if (aSN1Integer != null) {
            return aSN1Integer.getValue();
        }
        return null;
    }

    public byte[] getKeyIdentifier() {
        ASN1OctetString aSN1OctetString = this.a;
        if (aSN1OctetString != null) {
            return aSN1OctetString.getOctets();
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1OctetString aSN1OctetString = this.a;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1OctetString));
        }
        GeneralNames generalNames = this.b;
        if (generalNames != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, generalNames));
        }
        ASN1Integer aSN1Integer = this.c;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, aSN1Integer));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder L = a.L("AuthorityKeyIdentifier: KeyID(");
        L.append(this.a.getOctets());
        L.append(")");
        return L.toString();
    }

    public static AuthorityKeyIdentifier getInstance(Object obj) {
        if (obj instanceof AuthorityKeyIdentifier) {
            return (AuthorityKeyIdentifier) obj;
        }
        if (obj != null) {
            return new AuthorityKeyIdentifier(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AuthorityKeyIdentifier(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.a = null;
        this.b = null;
        this.c = null;
        SHA1Digest sHA1Digest = new SHA1Digest();
        byte[] bArr = new byte[sHA1Digest.getDigestSize()];
        byte[] bytes = subjectPublicKeyInfo.getPublicKeyData().getBytes();
        sHA1Digest.update(bytes, 0, bytes.length);
        sHA1Digest.doFinal(bArr, 0);
        this.a = new DEROctetString(bArr);
    }

    public AuthorityKeyIdentifier(SubjectPublicKeyInfo subjectPublicKeyInfo, GeneralNames generalNames, BigInteger bigInteger) {
        this.a = null;
        this.b = null;
        this.c = null;
        SHA1Digest sHA1Digest = new SHA1Digest();
        byte[] bArr = new byte[sHA1Digest.getDigestSize()];
        byte[] bytes = subjectPublicKeyInfo.getPublicKeyData().getBytes();
        sHA1Digest.update(bytes, 0, bytes.length);
        sHA1Digest.doFinal(bArr, 0);
        this.a = new DEROctetString(bArr);
        this.b = GeneralNames.getInstance(generalNames.toASN1Primitive());
        this.c = new ASN1Integer(bigInteger);
    }

    public AuthorityKeyIdentifier(GeneralNames generalNames, BigInteger bigInteger) {
        this((byte[]) null, generalNames, bigInteger);
    }

    public AuthorityKeyIdentifier(byte[] bArr) {
        this(bArr, (GeneralNames) null, (BigInteger) null);
    }

    public AuthorityKeyIdentifier(byte[] bArr, GeneralNames generalNames, BigInteger bigInteger) {
        ASN1Integer aSN1Integer = null;
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = bArr != null ? new DEROctetString(bArr) : null;
        this.b = generalNames;
        this.c = bigInteger != null ? new ASN1Integer(bigInteger) : aSN1Integer;
    }
}
