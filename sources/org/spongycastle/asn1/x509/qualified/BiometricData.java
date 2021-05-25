package org.spongycastle.asn1.x509.qualified;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class BiometricData extends ASN1Object {
    public TypeOfBiometricData a;
    public AlgorithmIdentifier b;
    public ASN1OctetString c;
    public DERIA5String d;

    public BiometricData(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = TypeOfBiometricData.getInstance(objects.nextElement());
        this.b = AlgorithmIdentifier.getInstance(objects.nextElement());
        this.c = ASN1OctetString.getInstance(objects.nextElement());
        if (objects.hasMoreElements()) {
            this.d = DERIA5String.getInstance(objects.nextElement());
        }
    }

    public static BiometricData getInstance(Object obj) {
        if (obj instanceof BiometricData) {
            return (BiometricData) obj;
        }
        if (obj != null) {
            return new BiometricData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1OctetString getBiometricDataHash() {
        return this.c;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.b;
    }

    public DERIA5String getSourceDataUri() {
        return this.d;
    }

    public TypeOfBiometricData getTypeOfBiometricData() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        DERIA5String dERIA5String = this.d;
        if (dERIA5String != null) {
            aSN1EncodableVector.add(dERIA5String);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public BiometricData(TypeOfBiometricData typeOfBiometricData, AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString, DERIA5String dERIA5String) {
        this.a = typeOfBiometricData;
        this.b = algorithmIdentifier;
        this.c = aSN1OctetString;
        this.d = dERIA5String;
    }

    public BiometricData(TypeOfBiometricData typeOfBiometricData, AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString) {
        this.a = typeOfBiometricData;
        this.b = algorithmIdentifier;
        this.c = aSN1OctetString;
        this.d = null;
    }
}
