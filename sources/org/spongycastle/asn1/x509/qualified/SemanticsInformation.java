package org.spongycastle.asn1.x509.qualified;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.GeneralName;
public class SemanticsInformation extends ASN1Object {
    public ASN1ObjectIdentifier a;
    public GeneralName[] b;

    public SemanticsInformation(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        if (aSN1Sequence.size() >= 1) {
            Object nextElement = objects.nextElement();
            if (nextElement instanceof ASN1ObjectIdentifier) {
                this.a = ASN1ObjectIdentifier.getInstance(nextElement);
                nextElement = objects.hasMoreElements() ? objects.nextElement() : null;
            }
            if (nextElement != null) {
                ASN1Sequence instance = ASN1Sequence.getInstance(nextElement);
                this.b = new GeneralName[instance.size()];
                for (int i = 0; i < instance.size(); i++) {
                    this.b[i] = GeneralName.getInstance(instance.getObjectAt(i));
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("no objects in SemanticsInformation");
    }

    public static GeneralName[] a(GeneralName[] generalNameArr) {
        if (generalNameArr == null) {
            return null;
        }
        GeneralName[] generalNameArr2 = new GeneralName[generalNameArr.length];
        System.arraycopy(generalNameArr, 0, generalNameArr2, 0, generalNameArr.length);
        return generalNameArr2;
    }

    public static SemanticsInformation getInstance(Object obj) {
        if (obj instanceof SemanticsInformation) {
            return (SemanticsInformation) obj;
        }
        if (obj != null) {
            return new SemanticsInformation(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralName[] getNameRegistrationAuthorities() {
        return a(this.b);
    }

    public ASN1ObjectIdentifier getSemanticsIdentifier() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.a;
        if (aSN1ObjectIdentifier != null) {
            aSN1EncodableVector.add(aSN1ObjectIdentifier);
        }
        if (this.b != null) {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            int i = 0;
            while (true) {
                GeneralName[] generalNameArr = this.b;
                if (i >= generalNameArr.length) {
                    break;
                }
                aSN1EncodableVector2.add(generalNameArr[i]);
                i++;
            }
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public SemanticsInformation(ASN1ObjectIdentifier aSN1ObjectIdentifier, GeneralName[] generalNameArr) {
        this.a = aSN1ObjectIdentifier;
        this.b = a(generalNameArr);
    }

    public SemanticsInformation(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.a = aSN1ObjectIdentifier;
        this.b = null;
    }

    public SemanticsInformation(GeneralName[] generalNameArr) {
        this.a = null;
        this.b = a(generalNameArr);
    }
}
