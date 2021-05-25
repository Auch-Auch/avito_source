package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Iterable;
public abstract class ASN1Sequence extends ASN1Primitive implements Iterable<ASN1Encodable> {
    public Vector seq;

    public class a implements ASN1SequenceParser {
        public final int a;
        public int b;
        public final /* synthetic */ ASN1Sequence c;

        public a(ASN1Sequence aSN1Sequence) {
            this.c = aSN1Sequence;
            this.a = ASN1Sequence.this.size();
        }

        @Override // org.spongycastle.asn1.InMemoryRepresentable
        public ASN1Primitive getLoadedObject() {
            return this.c;
        }

        @Override // org.spongycastle.asn1.ASN1SequenceParser
        public ASN1Encodable readObject() throws IOException {
            int i = this.b;
            if (i == this.a) {
                return null;
            }
            ASN1Sequence aSN1Sequence = ASN1Sequence.this;
            this.b = i + 1;
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(i);
            if (objectAt instanceof ASN1Sequence) {
                return ((ASN1Sequence) objectAt).parser();
            }
            return objectAt instanceof ASN1Set ? ((ASN1Set) objectAt).parser() : objectAt;
        }

        @Override // org.spongycastle.asn1.ASN1Encodable
        public ASN1Primitive toASN1Primitive() {
            return this.c;
        }
    }

    public ASN1Sequence() {
        this.seq = new Vector();
    }

    public static ASN1Sequence getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Sequence)) {
            return (ASN1Sequence) obj;
        }
        if (obj instanceof ASN1SequenceParser) {
            return getInstance(((ASN1SequenceParser) obj).toASN1Primitive());
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException(a2.b.a.a.a.A2(e, a2.b.a.a.a.L("failed to construct sequence from byte[]: ")));
            }
        } else {
            if (obj instanceof ASN1Encodable) {
                ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
                if (aSN1Primitive instanceof ASN1Sequence) {
                    return (ASN1Sequence) aSN1Primitive;
                }
            }
            throw new IllegalArgumentException(a2.b.a.a.a.H2(obj, a2.b.a.a.a.L("unknown object in getInstance: ")));
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Sequence)) {
            return false;
        }
        ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1Primitive;
        if (size() != aSN1Sequence.size()) {
            return false;
        }
        Enumeration objects = getObjects();
        Enumeration objects2 = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1Encodable d = d(objects);
            ASN1Encodable d2 = d(objects2);
            ASN1Primitive aSN1Primitive2 = d.toASN1Primitive();
            ASN1Primitive aSN1Primitive3 = d2.toASN1Primitive();
            if (aSN1Primitive2 != aSN1Primitive3 && !aSN1Primitive2.equals(aSN1Primitive3)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive b() {
        DERSequence dERSequence = new DERSequence();
        dERSequence.seq = this.seq;
        return dERSequence;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive c() {
        DLSequence dLSequence = new DLSequence();
        dLSequence.seq = this.seq;
        return dLSequence;
    }

    public final ASN1Encodable d(Enumeration enumeration) {
        return (ASN1Encodable) enumeration.nextElement();
    }

    public ASN1Encodable getObjectAt(int i) {
        return (ASN1Encodable) this.seq.elementAt(i);
    }

    public Enumeration getObjects() {
        return this.seq.elements();
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        Enumeration objects = getObjects();
        int size = size();
        while (objects.hasMoreElements()) {
            size = (size * 17) ^ d(objects).hashCode();
        }
        return size;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return true;
    }

    @Override // org.spongycastle.util.Iterable, java.lang.Iterable
    public Iterator<ASN1Encodable> iterator() {
        return new Arrays.Iterator(toArray());
    }

    public ASN1SequenceParser parser() {
        return new a(this);
    }

    public int size() {
        return this.seq.size();
    }

    public ASN1Encodable[] toArray() {
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[size()];
        for (int i = 0; i != size(); i++) {
            aSN1EncodableArr[i] = getObjectAt(i);
        }
        return aSN1EncodableArr;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.seq.toString();
    }

    public ASN1Sequence(ASN1Encodable aSN1Encodable) {
        Vector vector = new Vector();
        this.seq = vector;
        vector.addElement(aSN1Encodable);
    }

    public ASN1Sequence(ASN1EncodableVector aSN1EncodableVector) {
        this.seq = new Vector();
        for (int i = 0; i != aSN1EncodableVector.size(); i++) {
            this.seq.addElement(aSN1EncodableVector.get(i));
        }
    }

    public ASN1Sequence(ASN1Encodable[] aSN1EncodableArr) {
        this.seq = new Vector();
        for (int i = 0; i != aSN1EncodableArr.length; i++) {
            this.seq.addElement(aSN1EncodableArr[i]);
        }
    }

    public static ASN1Sequence getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            if (aSN1TaggedObject.isExplicit()) {
                return getInstance(aSN1TaggedObject.getObject().toASN1Primitive());
            }
            throw new IllegalArgumentException("object implicit - explicit expected.");
        } else if (aSN1TaggedObject.isExplicit()) {
            if (aSN1TaggedObject instanceof BERTaggedObject) {
                return new BERSequence(aSN1TaggedObject.getObject());
            }
            return new DLSequence(aSN1TaggedObject.getObject());
        } else if (aSN1TaggedObject.getObject() instanceof ASN1Sequence) {
            return (ASN1Sequence) aSN1TaggedObject.getObject();
        } else {
            StringBuilder L = a2.b.a.a.a.L("unknown object in getInstance: ");
            L.append(aSN1TaggedObject.getClass().getName());
            throw new IllegalArgumentException(L.toString());
        }
    }
}
