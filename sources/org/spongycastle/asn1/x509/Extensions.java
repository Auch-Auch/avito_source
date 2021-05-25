package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
public class Extensions extends ASN1Object {
    public Hashtable a;
    public Vector b;

    public Extensions(ASN1Sequence aSN1Sequence) {
        this.a = new Hashtable();
        this.b = new Vector();
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            Extension instance = Extension.getInstance(objects.nextElement());
            if (!this.a.containsKey(instance.getExtnId())) {
                this.a.put(instance.getExtnId(), instance);
                this.b.addElement(instance.getExtnId());
            } else {
                StringBuilder L = a.L("repeated extension found: ");
                L.append(instance.getExtnId());
                throw new IllegalArgumentException(L.toString());
            }
        }
    }

    public static Extensions getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public final ASN1ObjectIdentifier[] a(boolean z) {
        Vector vector = new Vector();
        for (int i = 0; i != this.b.size(); i++) {
            Object elementAt = this.b.elementAt(i);
            if (((Extension) this.a.get(elementAt)).isCritical() == z) {
                vector.addElement(elementAt);
            }
        }
        return b(vector);
    }

    public final ASN1ObjectIdentifier[] b(Vector vector) {
        int size = vector.size();
        ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = new ASN1ObjectIdentifier[size];
        for (int i = 0; i != size; i++) {
            aSN1ObjectIdentifierArr[i] = (ASN1ObjectIdentifier) vector.elementAt(i);
        }
        return aSN1ObjectIdentifierArr;
    }

    public boolean equivalent(Extensions extensions) {
        if (this.a.size() != extensions.a.size()) {
            return false;
        }
        Enumeration keys = this.a.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            if (!this.a.get(nextElement).equals(extensions.a.get(nextElement))) {
                return false;
            }
        }
        return true;
    }

    public ASN1ObjectIdentifier[] getCriticalExtensionOIDs() {
        return a(true);
    }

    public Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (Extension) this.a.get(aSN1ObjectIdentifier);
    }

    public ASN1ObjectIdentifier[] getExtensionOIDs() {
        return b(this.b);
    }

    public ASN1Encodable getExtensionParsedValue(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Extension extension = getExtension(aSN1ObjectIdentifier);
        if (extension != null) {
            return extension.getParsedValue();
        }
        return null;
    }

    public ASN1ObjectIdentifier[] getNonCriticalExtensionOIDs() {
        return a(false);
    }

    public Enumeration oids() {
        return this.b.elements();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration elements = this.b.elements();
        while (elements.hasMoreElements()) {
            aSN1EncodableVector.add((Extension) this.a.get((ASN1ObjectIdentifier) elements.nextElement()));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static Extensions getInstance(Object obj) {
        if (obj instanceof Extensions) {
            return (Extensions) obj;
        }
        if (obj != null) {
            return new Extensions(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Extensions(Extension extension) {
        this.a = new Hashtable();
        Vector vector = new Vector();
        this.b = vector;
        vector.addElement(extension.getExtnId());
        this.a.put(extension.getExtnId(), extension);
    }

    public Extensions(Extension[] extensionArr) {
        this.a = new Hashtable();
        this.b = new Vector();
        for (int i = 0; i != extensionArr.length; i++) {
            Extension extension = extensionArr[i];
            this.b.addElement(extension.getExtnId());
            this.a.put(extension.getExtnId(), extension);
        }
    }
}
