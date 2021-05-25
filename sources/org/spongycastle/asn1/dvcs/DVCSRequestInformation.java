package org.spongycastle.asn1.dvcs;

import a2.b.a.a.a;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.PolicyInformation;
public class DVCSRequestInformation extends ASN1Object {
    public int a = 1;
    public ServiceType b;
    public BigInteger c;
    public DVCSTime d;
    public GeneralNames e;
    public PolicyInformation f;
    public GeneralNames g;
    public GeneralNames h;
    public Extensions i;

    public DVCSRequestInformation(ASN1Sequence aSN1Sequence) {
        int i2;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
            this.a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue().intValue();
            i2 = 1;
        } else {
            this.a = 1;
            i2 = 0;
        }
        this.b = ServiceType.getInstance(aSN1Sequence.getObjectAt(i2));
        for (int i3 = i2 + 1; i3 < aSN1Sequence.size(); i3++) {
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(i3);
            if (objectAt instanceof ASN1Integer) {
                this.c = ASN1Integer.getInstance(objectAt).getValue();
            } else if (objectAt instanceof ASN1GeneralizedTime) {
                this.d = DVCSTime.getInstance(objectAt);
            } else if (objectAt instanceof ASN1TaggedObject) {
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(objectAt);
                int tagNo = instance.getTagNo();
                if (tagNo == 0) {
                    this.e = GeneralNames.getInstance(instance, false);
                } else if (tagNo == 1) {
                    this.f = PolicyInformation.getInstance(ASN1Sequence.getInstance(instance, false));
                } else if (tagNo == 2) {
                    this.g = GeneralNames.getInstance(instance, false);
                } else if (tagNo == 3) {
                    this.h = GeneralNames.getInstance(instance, false);
                } else if (tagNo == 4) {
                    this.i = Extensions.getInstance(instance, false);
                } else {
                    throw new IllegalArgumentException(a.M2("unknown tag number encountered: ", tagNo));
                }
            } else {
                this.d = DVCSTime.getInstance(objectAt);
            }
        }
    }

    public static DVCSRequestInformation getInstance(Object obj) {
        if (obj instanceof DVCSRequestInformation) {
            return (DVCSRequestInformation) obj;
        }
        if (obj != null) {
            return new DVCSRequestInformation(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralNames getDVCS() {
        return this.g;
    }

    public GeneralNames getDataLocations() {
        return this.h;
    }

    public Extensions getExtensions() {
        return this.i;
    }

    public BigInteger getNonce() {
        return this.c;
    }

    public PolicyInformation getRequestPolicy() {
        return this.f;
    }

    public DVCSTime getRequestTime() {
        return this.d;
    }

    public GeneralNames getRequester() {
        return this.e;
    }

    public ServiceType getService() {
        return this.b;
    }

    public int getVersion() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        int i2 = this.a;
        if (i2 != 1) {
            aSN1EncodableVector.add(new ASN1Integer((long) i2));
        }
        aSN1EncodableVector.add(this.b);
        BigInteger bigInteger = this.c;
        if (bigInteger != null) {
            aSN1EncodableVector.add(new ASN1Integer(bigInteger));
        }
        DVCSTime dVCSTime = this.d;
        if (dVCSTime != null) {
            aSN1EncodableVector.add(dVCSTime);
        }
        int[] iArr = {0, 1, 2, 3, 4};
        ASN1Encodable[] aSN1EncodableArr = {this.e, this.f, this.g, this.h, this.i};
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            ASN1Encodable aSN1Encodable = aSN1EncodableArr[i3];
            if (aSN1Encodable != null) {
                aSN1EncodableVector.add(new DERTaggedObject(false, i4, aSN1Encodable));
            }
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DVCSRequestInformation {\n");
        if (this.a != 1) {
            StringBuilder L = a.L("version: ");
            L.append(this.a);
            L.append("\n");
            stringBuffer.append(L.toString());
        }
        StringBuilder L2 = a.L("service: ");
        L2.append(this.b);
        L2.append("\n");
        stringBuffer.append(L2.toString());
        if (this.c != null) {
            StringBuilder L3 = a.L("nonce: ");
            L3.append(this.c);
            L3.append("\n");
            stringBuffer.append(L3.toString());
        }
        if (this.d != null) {
            StringBuilder L4 = a.L("requestTime: ");
            L4.append(this.d);
            L4.append("\n");
            stringBuffer.append(L4.toString());
        }
        if (this.e != null) {
            StringBuilder L5 = a.L("requester: ");
            L5.append(this.e);
            L5.append("\n");
            stringBuffer.append(L5.toString());
        }
        if (this.f != null) {
            StringBuilder L6 = a.L("requestPolicy: ");
            L6.append(this.f);
            L6.append("\n");
            stringBuffer.append(L6.toString());
        }
        if (this.g != null) {
            StringBuilder L7 = a.L("dvcs: ");
            L7.append(this.g);
            L7.append("\n");
            stringBuffer.append(L7.toString());
        }
        if (this.h != null) {
            StringBuilder L8 = a.L("dataLocations: ");
            L8.append(this.h);
            L8.append("\n");
            stringBuffer.append(L8.toString());
        }
        if (this.i != null) {
            StringBuilder L9 = a.L("extensions: ");
            L9.append(this.i);
            L9.append("\n");
            stringBuffer.append(L9.toString());
        }
        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }

    public static DVCSRequestInformation getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
