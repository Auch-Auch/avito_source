package org.spongycastle.asn1.cmc;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
public class BodyPartReference extends ASN1Object implements ASN1Choice {
    public final BodyPartID a;
    public final BodyPartPath b;

    public BodyPartReference(BodyPartID bodyPartID) {
        this.a = bodyPartID;
        this.b = null;
    }

    public static BodyPartReference getInstance(Object obj) {
        if (obj instanceof BodyPartReference) {
            return (BodyPartReference) obj;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1Integer) {
                return new BodyPartReference(BodyPartID.getInstance(aSN1Primitive));
            }
            if (aSN1Primitive instanceof ASN1Sequence) {
                return new BodyPartReference(BodyPartPath.getInstance(aSN1Primitive));
            }
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException unused) {
                throw new IllegalArgumentException("unknown encoding in getInstance()");
            }
        } else {
            throw new IllegalArgumentException(a.H2(obj, a.L("unknown object in getInstance(): ")));
        }
    }

    public BodyPartID getBodyPartID() {
        return this.a;
    }

    public BodyPartPath getBodyPartPath() {
        return this.b;
    }

    public boolean isBodyPartID() {
        return this.a != null;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        BodyPartID bodyPartID = this.a;
        if (bodyPartID != null) {
            return bodyPartID.toASN1Primitive();
        }
        return this.b.toASN1Primitive();
    }

    public BodyPartReference(BodyPartPath bodyPartPath) {
        this.a = null;
        this.b = bodyPartPath;
    }
}
