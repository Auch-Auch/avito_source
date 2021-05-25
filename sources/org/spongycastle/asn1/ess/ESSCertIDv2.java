package org.spongycastle.asn1.ess;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.IssuerSerial;
import org.spongycastle.util.Arrays;
public class ESSCertIDv2 extends ASN1Object {
    public static final AlgorithmIdentifier d = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
    public AlgorithmIdentifier a;
    public byte[] b;
    public IssuerSerial c;

    public ESSCertIDv2(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() <= 3) {
            int i = 0;
            if (aSN1Sequence.getObjectAt(0) instanceof ASN1OctetString) {
                this.a = d;
            } else {
                this.a = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0).toASN1Primitive());
                i = 1;
            }
            int i2 = i + 1;
            this.b = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i).toASN1Primitive()).getOctets();
            if (aSN1Sequence.size() > i2) {
                this.c = IssuerSerial.getInstance(aSN1Sequence.getObjectAt(i2));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
    }

    public static ESSCertIDv2 getInstance(Object obj) {
        if (obj instanceof ESSCertIDv2) {
            return (ESSCertIDv2) obj;
        }
        if (obj != null) {
            return new ESSCertIDv2(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getCertHash() {
        return Arrays.clone(this.b);
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.a;
    }

    public IssuerSerial getIssuerSerial() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (!this.a.equals(d)) {
            aSN1EncodableVector.add(this.a);
        }
        aSN1EncodableVector.add(new DEROctetString(this.b).toASN1Primitive());
        IssuerSerial issuerSerial = this.c;
        if (issuerSerial != null) {
            aSN1EncodableVector.add(issuerSerial);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public ESSCertIDv2(byte[] bArr) {
        this(null, bArr, null);
    }

    public ESSCertIDv2(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this(algorithmIdentifier, bArr, null);
    }

    public ESSCertIDv2(byte[] bArr, IssuerSerial issuerSerial) {
        this(null, bArr, issuerSerial);
    }

    public ESSCertIDv2(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, IssuerSerial issuerSerial) {
        if (algorithmIdentifier == null) {
            this.a = d;
        } else {
            this.a = algorithmIdentifier;
        }
        this.b = Arrays.clone(bArr);
        this.c = issuerSerial;
    }
}
