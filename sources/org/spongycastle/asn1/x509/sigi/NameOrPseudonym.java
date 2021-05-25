package org.spongycastle.asn1.x509.sigi;

import a2.b.a.a.a;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.DirectoryString;
public class NameOrPseudonym extends ASN1Object implements ASN1Choice {
    public DirectoryString a;
    public DirectoryString b;
    public ASN1Sequence c;

    public NameOrPseudonym(DirectoryString directoryString) {
        this.a = directoryString;
    }

    public static NameOrPseudonym getInstance(Object obj) {
        if (obj == null || (obj instanceof NameOrPseudonym)) {
            return (NameOrPseudonym) obj;
        }
        if (obj instanceof ASN1String) {
            return new NameOrPseudonym(DirectoryString.getInstance(obj));
        }
        if (obj instanceof ASN1Sequence) {
            return new NameOrPseudonym((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("illegal object in getInstance: ")));
    }

    public DirectoryString[] getGivenName() {
        DirectoryString[] directoryStringArr = new DirectoryString[this.c.size()];
        Enumeration objects = this.c.getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            directoryStringArr[i] = DirectoryString.getInstance(objects.nextElement());
            i++;
        }
        return directoryStringArr;
    }

    public DirectoryString getPseudonym() {
        return this.a;
    }

    public DirectoryString getSurname() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        DirectoryString directoryString = this.a;
        if (directoryString != null) {
            return directoryString.toASN1Primitive();
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        return new DERSequence(aSN1EncodableVector);
    }

    public NameOrPseudonym(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() != 2) {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
        } else if (aSN1Sequence.getObjectAt(0) instanceof ASN1String) {
            this.b = DirectoryString.getInstance(aSN1Sequence.getObjectAt(0));
            this.c = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
        } else {
            StringBuilder L = a.L("Bad object encountered: ");
            L.append(aSN1Sequence.getObjectAt(0).getClass());
            throw new IllegalArgumentException(L.toString());
        }
    }

    public NameOrPseudonym(String str) {
        this(new DirectoryString(str));
    }

    public NameOrPseudonym(DirectoryString directoryString, ASN1Sequence aSN1Sequence) {
        this.b = directoryString;
        this.c = aSN1Sequence;
    }
}
