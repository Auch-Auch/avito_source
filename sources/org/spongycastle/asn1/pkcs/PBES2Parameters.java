package org.spongycastle.asn1.pkcs;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class PBES2Parameters extends ASN1Object implements PKCSObjectIdentifiers {
    public KeyDerivationFunc a;
    public EncryptionScheme b;

    public PBES2Parameters(KeyDerivationFunc keyDerivationFunc, EncryptionScheme encryptionScheme) {
        this.a = keyDerivationFunc;
        this.b = encryptionScheme;
    }

    public static PBES2Parameters getInstance(Object obj) {
        if (obj instanceof PBES2Parameters) {
            return (PBES2Parameters) obj;
        }
        if (obj != null) {
            return new PBES2Parameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EncryptionScheme getEncryptionScheme() {
        return this.b;
    }

    public KeyDerivationFunc getKeyDerivationFunc() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        return new DERSequence(aSN1EncodableVector);
    }

    public PBES2Parameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        ASN1Sequence instance = ASN1Sequence.getInstance(((ASN1Encodable) objects.nextElement()).toASN1Primitive());
        ASN1Encodable objectAt = instance.getObjectAt(0);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.id_PBKDF2;
        if (objectAt.equals(aSN1ObjectIdentifier)) {
            this.a = new KeyDerivationFunc(aSN1ObjectIdentifier, PBKDF2Params.getInstance(instance.getObjectAt(1)));
        } else {
            this.a = KeyDerivationFunc.getInstance(instance);
        }
        this.b = EncryptionScheme.getInstance(objects.nextElement());
    }
}
