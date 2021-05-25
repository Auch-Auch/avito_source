package org.spongycastle.asn1.bc;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class ObjectStore extends ASN1Object {
    public final ASN1Encodable a;
    public final ObjectStoreIntegrityCheck b;

    public ObjectStore(ObjectStoreData objectStoreData, ObjectStoreIntegrityCheck objectStoreIntegrityCheck) {
        this.a = objectStoreData;
        this.b = objectStoreIntegrityCheck;
    }

    public static ObjectStore getInstance(Object obj) {
        if (obj instanceof ObjectStore) {
            return (ObjectStore) obj;
        }
        if (obj != null) {
            return new ObjectStore(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ObjectStoreIntegrityCheck getIntegrityCheck() {
        return this.b;
    }

    public ASN1Encodable getStoreData() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        return new DERSequence(aSN1EncodableVector);
    }

    public ObjectStore(EncryptedObjectStoreData encryptedObjectStoreData, ObjectStoreIntegrityCheck objectStoreIntegrityCheck) {
        this.a = encryptedObjectStoreData;
        this.b = objectStoreIntegrityCheck;
    }

    public ObjectStore(ASN1Sequence aSN1Sequence) {
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(0);
        if (objectAt instanceof EncryptedObjectStoreData) {
            this.a = objectAt;
        } else if (objectAt instanceof ObjectStoreData) {
            this.a = objectAt;
        } else {
            ASN1Sequence instance = ASN1Sequence.getInstance(objectAt);
            if (instance.size() == 2) {
                this.a = EncryptedObjectStoreData.getInstance(instance);
            } else {
                this.a = ObjectStoreData.getInstance(instance);
            }
        }
        this.b = ObjectStoreIntegrityCheck.getInstance(aSN1Sequence.getObjectAt(1));
    }
}
