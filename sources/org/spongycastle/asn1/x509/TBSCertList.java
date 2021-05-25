package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.ASN1UTCTime;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;
public class TBSCertList extends ASN1Object {
    public ASN1Integer a;
    public AlgorithmIdentifier b;
    public X500Name c;
    public Time d;
    public Time e;
    public ASN1Sequence f;
    public Extensions g;

    public static class CRLEntry extends ASN1Object {
        public ASN1Sequence a;
        public Extensions b;

        public CRLEntry(ASN1Sequence aSN1Sequence) {
            if (aSN1Sequence.size() < 2 || aSN1Sequence.size() > 3) {
                throw new IllegalArgumentException(a2.b.a.a.a.C(aSN1Sequence, a2.b.a.a.a.L("Bad sequence size: ")));
            }
            this.a = aSN1Sequence;
        }

        public static CRLEntry getInstance(Object obj) {
            if (obj instanceof CRLEntry) {
                return (CRLEntry) obj;
            }
            if (obj != null) {
                return new CRLEntry(ASN1Sequence.getInstance(obj));
            }
            return null;
        }

        public Extensions getExtensions() {
            if (this.b == null && this.a.size() == 3) {
                this.b = Extensions.getInstance(this.a.getObjectAt(2));
            }
            return this.b;
        }

        public Time getRevocationDate() {
            return Time.getInstance(this.a.getObjectAt(1));
        }

        public ASN1Integer getUserCertificate() {
            return ASN1Integer.getInstance(this.a.getObjectAt(0));
        }

        public boolean hasExtensions() {
            return this.a.size() == 3;
        }

        @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
        public ASN1Primitive toASN1Primitive() {
            return this.a;
        }
    }

    public class b implements Enumeration {
        public b(TBSCertList tBSCertList, a aVar) {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            throw new NoSuchElementException("Empty Enumeration");
        }
    }

    public class c implements Enumeration {
        public final Enumeration a;

        public c(TBSCertList tBSCertList, Enumeration enumeration) {
            this.a = enumeration;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.a.hasMoreElements();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return CRLEntry.getInstance(this.a.nextElement());
        }
    }

    public TBSCertList(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 3 || aSN1Sequence.size() > 7) {
            throw new IllegalArgumentException(a2.b.a.a.a.C(aSN1Sequence, a2.b.a.a.a.L("Bad sequence size: ")));
        }
        int i = 0;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
            this.a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
            i = 1;
        } else {
            this.a = null;
        }
        int i2 = i + 1;
        this.b = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i));
        int i3 = i2 + 1;
        this.c = X500Name.getInstance(aSN1Sequence.getObjectAt(i2));
        int i4 = i3 + 1;
        this.d = Time.getInstance(aSN1Sequence.getObjectAt(i3));
        if (i4 < aSN1Sequence.size() && ((aSN1Sequence.getObjectAt(i4) instanceof ASN1UTCTime) || (aSN1Sequence.getObjectAt(i4) instanceof ASN1GeneralizedTime) || (aSN1Sequence.getObjectAt(i4) instanceof Time))) {
            this.e = Time.getInstance(aSN1Sequence.getObjectAt(i4));
            i4++;
        }
        if (i4 < aSN1Sequence.size() && !(aSN1Sequence.getObjectAt(i4) instanceof ASN1TaggedObject)) {
            this.f = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i4));
            i4++;
        }
        if (i4 < aSN1Sequence.size() && (aSN1Sequence.getObjectAt(i4) instanceof ASN1TaggedObject)) {
            this.g = Extensions.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i4), true));
        }
    }

    public static TBSCertList getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public Extensions getExtensions() {
        return this.g;
    }

    public X500Name getIssuer() {
        return this.c;
    }

    public Time getNextUpdate() {
        return this.e;
    }

    public Enumeration getRevokedCertificateEnumeration() {
        ASN1Sequence aSN1Sequence = this.f;
        if (aSN1Sequence == null) {
            return new b(this, null);
        }
        return new c(this, aSN1Sequence.getObjects());
    }

    public CRLEntry[] getRevokedCertificates() {
        ASN1Sequence aSN1Sequence = this.f;
        if (aSN1Sequence == null) {
            return new CRLEntry[0];
        }
        int size = aSN1Sequence.size();
        CRLEntry[] cRLEntryArr = new CRLEntry[size];
        for (int i = 0; i < size; i++) {
            cRLEntryArr[i] = CRLEntry.getInstance(this.f.getObjectAt(i));
        }
        return cRLEntryArr;
    }

    public AlgorithmIdentifier getSignature() {
        return this.b;
    }

    public Time getThisUpdate() {
        return this.d;
    }

    public ASN1Integer getVersion() {
        return this.a;
    }

    public int getVersionNumber() {
        ASN1Integer aSN1Integer = this.a;
        if (aSN1Integer == null) {
            return 1;
        }
        return aSN1Integer.getValue().intValue() + 1;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Integer aSN1Integer = this.a;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(this.d);
        Time time = this.e;
        if (time != null) {
            aSN1EncodableVector.add(time);
        }
        ASN1Sequence aSN1Sequence = this.f;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(aSN1Sequence);
        }
        Extensions extensions = this.g;
        if (extensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(0, extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static TBSCertList getInstance(Object obj) {
        if (obj instanceof TBSCertList) {
            return (TBSCertList) obj;
        }
        if (obj != null) {
            return new TBSCertList(ASN1Sequence.getInstance(obj));
        }
        return null;
    }
}
