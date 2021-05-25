package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1UTCTime;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;
public class V2TBSCertListGenerator {
    public static final ASN1Sequence[] h;
    public ASN1Integer a = new ASN1Integer(1);
    public AlgorithmIdentifier b;
    public X500Name c;
    public Time d;
    public Time e = null;
    public Extensions f = null;
    public ASN1EncodableVector g = new ASN1EncodableVector();

    static {
        ASN1Sequence[] aSN1SequenceArr = new ASN1Sequence[11];
        h = aSN1SequenceArr;
        aSN1SequenceArr[0] = b(0);
        aSN1SequenceArr[1] = b(1);
        aSN1SequenceArr[2] = b(2);
        aSN1SequenceArr[3] = b(3);
        aSN1SequenceArr[4] = b(4);
        aSN1SequenceArr[5] = b(5);
        aSN1SequenceArr[6] = b(6);
        aSN1SequenceArr[7] = b(7);
        aSN1SequenceArr[8] = b(8);
        aSN1SequenceArr[9] = b(9);
        aSN1SequenceArr[10] = b(10);
    }

    public static ASN1Sequence a(ASN1GeneralizedTime aSN1GeneralizedTime) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        try {
            aSN1EncodableVector.add(Extension.invalidityDate);
            aSN1EncodableVector.add(new DEROctetString(aSN1GeneralizedTime.getEncoded()));
            return new DERSequence(aSN1EncodableVector);
        } catch (IOException e2) {
            throw new IllegalArgumentException(a.Z2("error encoding reason: ", e2));
        }
    }

    public static ASN1Sequence b(int i) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        CRLReason lookup = CRLReason.lookup(i);
        try {
            aSN1EncodableVector.add(Extension.reasonCode);
            aSN1EncodableVector.add(new DEROctetString(lookup.getEncoded()));
            return new DERSequence(aSN1EncodableVector);
        } catch (IOException e2) {
            throw new IllegalArgumentException(a.Z2("error encoding reason: ", e2));
        }
    }

    public void addCRLEntry(ASN1Sequence aSN1Sequence) {
        this.g.add(aSN1Sequence);
    }

    public TBSCertList generateTBSCertList() {
        if (this.b == null || this.c == null || this.d == null) {
            throw new IllegalStateException("Not all mandatory fields set in V2 TBSCertList generator.");
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(this.d);
        Time time = this.e;
        if (time != null) {
            aSN1EncodableVector.add(time);
        }
        if (this.g.size() != 0) {
            aSN1EncodableVector.add(new DERSequence(this.g));
        }
        Extensions extensions = this.f;
        if (extensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(0, extensions));
        }
        return new TBSCertList(new DERSequence(aSN1EncodableVector));
    }

    public void setExtensions(X509Extensions x509Extensions) {
        setExtensions(Extensions.getInstance(x509Extensions));
    }

    public void setIssuer(X509Name x509Name) {
        this.c = X500Name.getInstance(x509Name.toASN1Primitive());
    }

    public void setNextUpdate(ASN1UTCTime aSN1UTCTime) {
        this.e = new Time(aSN1UTCTime);
    }

    public void setSignature(AlgorithmIdentifier algorithmIdentifier) {
        this.b = algorithmIdentifier;
    }

    public void setThisUpdate(ASN1UTCTime aSN1UTCTime) {
        this.d = new Time(aSN1UTCTime);
    }

    public void addCRLEntry(ASN1Integer aSN1Integer, ASN1UTCTime aSN1UTCTime, int i) {
        addCRLEntry(aSN1Integer, new Time(aSN1UTCTime), i);
    }

    public void setExtensions(Extensions extensions) {
        this.f = extensions;
    }

    public void setIssuer(X500Name x500Name) {
        this.c = x500Name;
    }

    public void setNextUpdate(Time time) {
        this.e = time;
    }

    public void setThisUpdate(Time time) {
        this.d = time;
    }

    public void addCRLEntry(ASN1Integer aSN1Integer, Time time, int i) {
        addCRLEntry(aSN1Integer, time, i, null);
    }

    public void addCRLEntry(ASN1Integer aSN1Integer, Time time, int i, ASN1GeneralizedTime aSN1GeneralizedTime) {
        if (i != 0) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            ASN1Sequence[] aSN1SequenceArr = h;
            if (i >= aSN1SequenceArr.length) {
                aSN1EncodableVector.add(b(i));
            } else if (i >= 0) {
                aSN1EncodableVector.add(aSN1SequenceArr[i]);
            } else {
                throw new IllegalArgumentException(a.M2("invalid reason value: ", i));
            }
            if (aSN1GeneralizedTime != null) {
                aSN1EncodableVector.add(a(aSN1GeneralizedTime));
            }
            DERSequence dERSequence = new DERSequence(aSN1EncodableVector);
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.add(aSN1Integer);
            aSN1EncodableVector2.add(time);
            aSN1EncodableVector2.add(dERSequence);
            addCRLEntry(new DERSequence(aSN1EncodableVector2));
        } else if (aSN1GeneralizedTime != null) {
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            aSN1EncodableVector3.add(a(aSN1GeneralizedTime));
            DERSequence dERSequence2 = new DERSequence(aSN1EncodableVector3);
            ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
            aSN1EncodableVector4.add(aSN1Integer);
            aSN1EncodableVector4.add(time);
            aSN1EncodableVector4.add(dERSequence2);
            addCRLEntry(new DERSequence(aSN1EncodableVector4));
        } else {
            addCRLEntry(aSN1Integer, time, (Extensions) null);
        }
    }

    public void addCRLEntry(ASN1Integer aSN1Integer, Time time, Extensions extensions) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(aSN1Integer);
        aSN1EncodableVector.add(time);
        if (extensions != null) {
            aSN1EncodableVector.add(extensions);
        }
        addCRLEntry(new DERSequence(aSN1EncodableVector));
    }
}
