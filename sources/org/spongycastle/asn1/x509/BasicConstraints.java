package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
public class BasicConstraints extends ASN1Object {
    public ASN1Boolean a;
    public ASN1Integer b;

    public BasicConstraints(ASN1Sequence aSN1Sequence) {
        this.a = ASN1Boolean.getInstance(false);
        this.b = null;
        if (aSN1Sequence.size() == 0) {
            this.a = null;
            this.b = null;
            return;
        }
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Boolean) {
            this.a = ASN1Boolean.getInstance(aSN1Sequence.getObjectAt(0));
        } else {
            this.a = null;
            this.b = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        }
        if (aSN1Sequence.size() <= 1) {
            return;
        }
        if (this.a != null) {
            this.b = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException("wrong sequence in constructor");
    }

    public static BasicConstraints fromExtensions(Extensions extensions) {
        return getInstance(extensions.getExtensionParsedValue(Extension.basicConstraints));
    }

    public static BasicConstraints getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getPathLenConstraint() {
        ASN1Integer aSN1Integer = this.b;
        if (aSN1Integer != null) {
            return aSN1Integer.getValue();
        }
        return null;
    }

    public boolean isCA() {
        ASN1Boolean aSN1Boolean = this.a;
        return aSN1Boolean != null && aSN1Boolean.isTrue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Boolean aSN1Boolean = this.a;
        if (aSN1Boolean != null) {
            aSN1EncodableVector.add(aSN1Boolean);
        }
        ASN1Integer aSN1Integer = this.b;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        if (this.b != null) {
            StringBuilder L = a.L("BasicConstraints: isCa(");
            L.append(isCA());
            L.append("), pathLenConstraint = ");
            L.append(this.b.getValue());
            return L.toString();
        } else if (this.a == null) {
            return "BasicConstraints: isCa(false)";
        } else {
            StringBuilder L2 = a.L("BasicConstraints: isCa(");
            L2.append(isCA());
            L2.append(")");
            return L2.toString();
        }
    }

    public static BasicConstraints getInstance(Object obj) {
        if (obj instanceof BasicConstraints) {
            return (BasicConstraints) obj;
        }
        if (obj instanceof X509Extension) {
            return getInstance(X509Extension.convertValueToObject((X509Extension) obj));
        }
        if (obj != null) {
            return new BasicConstraints(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BasicConstraints(boolean z) {
        this.a = ASN1Boolean.getInstance(false);
        this.b = null;
        if (z) {
            this.a = ASN1Boolean.getInstance(true);
        } else {
            this.a = null;
        }
        this.b = null;
    }

    public BasicConstraints(int i) {
        this.a = ASN1Boolean.getInstance(false);
        this.b = null;
        this.a = ASN1Boolean.getInstance(true);
        this.b = new ASN1Integer((long) i);
    }
}
