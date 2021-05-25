package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Iterable;
public abstract class ASN1Set extends ASN1Primitive implements Iterable<ASN1Encodable> {
    public Vector a;
    public boolean b;

    public class a implements ASN1SetParser {
        public final int a;
        public int b;
        public final /* synthetic */ ASN1Set c;

        public a(ASN1Set aSN1Set) {
            this.c = aSN1Set;
            this.a = ASN1Set.this.size();
        }

        @Override // org.spongycastle.asn1.InMemoryRepresentable
        public ASN1Primitive getLoadedObject() {
            return this.c;
        }

        @Override // org.spongycastle.asn1.ASN1SetParser
        public ASN1Encodable readObject() throws IOException {
            int i = this.b;
            if (i == this.a) {
                return null;
            }
            ASN1Set aSN1Set = ASN1Set.this;
            this.b = i + 1;
            ASN1Encodable objectAt = aSN1Set.getObjectAt(i);
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

    public ASN1Set() {
        this.a = new Vector();
        this.b = false;
    }

    public static ASN1Set getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Set)) {
            return (ASN1Set) obj;
        }
        if (obj instanceof ASN1SetParser) {
            return getInstance(((ASN1SetParser) obj).toASN1Primitive());
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException(a2.b.a.a.a.A2(e, a2.b.a.a.a.L("failed to construct set from byte[]: ")));
            }
        } else {
            if (obj instanceof ASN1Encodable) {
                ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
                if (aSN1Primitive instanceof ASN1Set) {
                    return (ASN1Set) aSN1Primitive;
                }
            }
            throw new IllegalArgumentException(a2.b.a.a.a.H2(obj, a2.b.a.a.a.L("unknown object in getInstance: ")));
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Set)) {
            return false;
        }
        ASN1Set aSN1Set = (ASN1Set) aSN1Primitive;
        if (size() != aSN1Set.size()) {
            return false;
        }
        Enumeration objects = getObjects();
        Enumeration objects2 = aSN1Set.getObjects();
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
        if (this.b) {
            DERSet dERSet = new DERSet();
            dERSet.a = this.a;
            return dERSet;
        }
        Vector vector = new Vector();
        for (int i = 0; i != this.a.size(); i++) {
            vector.addElement(this.a.elementAt(i));
        }
        DERSet dERSet2 = new DERSet();
        dERSet2.a = vector;
        dERSet2.sort();
        return dERSet2;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive c() {
        DLSet dLSet = new DLSet();
        dLSet.a = this.a;
        return dLSet;
    }

    public final ASN1Encodable d(Enumeration enumeration) {
        ASN1Encodable aSN1Encodable = (ASN1Encodable) enumeration.nextElement();
        return aSN1Encodable == null ? DERNull.INSTANCE : aSN1Encodable;
    }

    public ASN1Encodable getObjectAt(int i) {
        return (ASN1Encodable) this.a.elementAt(i);
    }

    public Enumeration getObjects() {
        return this.a.elements();
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

    public ASN1SetParser parser() {
        return new a(this);
    }

    public int size() {
        return this.a.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        if ((r7[r12] & 255) < (r9[r12] & 255)) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0064, code lost:
        if (r11 == r7.length) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0068, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0069, code lost:
        if (r11 == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
        r7 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006d, code lost:
        r4 = r15.a.elementAt(r8);
        r6 = r15.a;
        r6.setElementAt(r6.elementAt(r10), r8);
        r15.a.setElementAt(r4, r10);
        r4 = r8;
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0083, code lost:
        r8 = r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sort() {
        /*
            r15 = this;
            java.lang.String r0 = "cannot encode object added to SET"
            java.lang.String r1 = "DER"
            boolean r2 = r15.b
            if (r2 != 0) goto L_0x0094
            r2 = 1
            r15.b = r2
            java.util.Vector r3 = r15.a
            int r3 = r3.size()
            if (r3 <= r2) goto L_0x0094
            java.util.Vector r3 = r15.a
            int r3 = r3.size()
            int r3 = r3 - r2
            r4 = 1
        L_0x001b:
            if (r4 == 0) goto L_0x0094
            java.util.Vector r4 = r15.a
            r5 = 0
            java.lang.Object r4 = r4.elementAt(r5)
            org.spongycastle.asn1.ASN1Encodable r4 = (org.spongycastle.asn1.ASN1Encodable) r4
            org.spongycastle.asn1.ASN1Primitive r4 = r4.toASN1Primitive()     // Catch:{ IOException -> 0x008e }
            byte[] r4 = r4.getEncoded(r1)     // Catch:{ IOException -> 0x008e }
            r7 = r4
            r4 = 0
            r6 = 0
            r8 = 0
        L_0x0032:
            if (r8 == r3) goto L_0x008b
            java.util.Vector r9 = r15.a
            int r10 = r8 + 1
            java.lang.Object r9 = r9.elementAt(r10)
            org.spongycastle.asn1.ASN1Encodable r9 = (org.spongycastle.asn1.ASN1Encodable) r9
            org.spongycastle.asn1.ASN1Primitive r9 = r9.toASN1Primitive()     // Catch:{ IOException -> 0x0085 }
            byte[] r9 = r9.getEncoded(r1)     // Catch:{ IOException -> 0x0085 }
            int r11 = r7.length
            int r12 = r9.length
            int r11 = java.lang.Math.min(r11, r12)
            r12 = 0
        L_0x004d:
            if (r12 == r11) goto L_0x0063
            byte r13 = r7[r12]
            byte r14 = r9[r12]
            if (r13 == r14) goto L_0x0060
            byte r11 = r7[r12]
            r11 = r11 & 255(0xff, float:3.57E-43)
            byte r12 = r9[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            if (r11 >= r12) goto L_0x0068
            goto L_0x0066
        L_0x0060:
            int r12 = r12 + 1
            goto L_0x004d
        L_0x0063:
            int r12 = r7.length
            if (r11 != r12) goto L_0x0068
        L_0x0066:
            r11 = 1
            goto L_0x0069
        L_0x0068:
            r11 = 0
        L_0x0069:
            if (r11 == 0) goto L_0x006d
            r7 = r9
            goto L_0x0083
        L_0x006d:
            java.util.Vector r4 = r15.a
            java.lang.Object r4 = r4.elementAt(r8)
            java.util.Vector r6 = r15.a
            java.lang.Object r9 = r6.elementAt(r10)
            r6.setElementAt(r9, r8)
            java.util.Vector r6 = r15.a
            r6.setElementAt(r4, r10)
            r4 = r8
            r6 = 1
        L_0x0083:
            r8 = r10
            goto L_0x0032
        L_0x0085:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L_0x008b:
            r3 = r4
            r4 = r6
            goto L_0x001b
        L_0x008e:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.ASN1Set.sort():void");
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
        return this.a.toString();
    }

    public ASN1Set(ASN1Encodable aSN1Encodable) {
        Vector vector = new Vector();
        this.a = vector;
        this.b = false;
        vector.addElement(aSN1Encodable);
    }

    public ASN1Set(ASN1EncodableVector aSN1EncodableVector, boolean z) {
        this.a = new Vector();
        this.b = false;
        for (int i = 0; i != aSN1EncodableVector.size(); i++) {
            this.a.addElement(aSN1EncodableVector.get(i));
        }
        if (z) {
            sort();
        }
    }

    public static ASN1Set getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            if (aSN1TaggedObject.isExplicit()) {
                return (ASN1Set) aSN1TaggedObject.getObject();
            }
            throw new IllegalArgumentException("object implicit - explicit expected.");
        } else if (aSN1TaggedObject.isExplicit()) {
            if (aSN1TaggedObject instanceof BERTaggedObject) {
                return new BERSet(aSN1TaggedObject.getObject());
            }
            return new DLSet(aSN1TaggedObject.getObject());
        } else if (aSN1TaggedObject.getObject() instanceof ASN1Set) {
            return (ASN1Set) aSN1TaggedObject.getObject();
        } else {
            if (aSN1TaggedObject.getObject() instanceof ASN1Sequence) {
                ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1TaggedObject.getObject();
                if (aSN1TaggedObject instanceof BERTaggedObject) {
                    return new BERSet(aSN1Sequence.toArray());
                }
                return new DLSet(aSN1Sequence.toArray());
            }
            StringBuilder L = a2.b.a.a.a.L("unknown object in getInstance: ");
            L.append(aSN1TaggedObject.getClass().getName());
            throw new IllegalArgumentException(L.toString());
        }
    }

    public ASN1Set(ASN1Encodable[] aSN1EncodableArr, boolean z) {
        this.a = new Vector();
        this.b = false;
        for (int i = 0; i != aSN1EncodableArr.length; i++) {
            this.a.addElement(aSN1EncodableArr[i]);
        }
        if (z) {
            sort();
        }
    }
}
