package org.spongycastle.asn1.isismtt.x509;

import a2.b.a.a.a;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.isismtt.ISISMTTObjectIdentifiers;
import org.spongycastle.asn1.x500.DirectoryString;
public class NamingAuthority extends ASN1Object {
    public static final ASN1ObjectIdentifier id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern = new ASN1ObjectIdentifier(ISISMTTObjectIdentifiers.id_isismtt_at_namingAuthorities + ".1");
    public ASN1ObjectIdentifier a;
    public String b;
    public DirectoryString c;

    public NamingAuthority(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() <= 3) {
            Enumeration objects = aSN1Sequence.getObjects();
            if (objects.hasMoreElements()) {
                ASN1Encodable aSN1Encodable = (ASN1Encodable) objects.nextElement();
                if (aSN1Encodable instanceof ASN1ObjectIdentifier) {
                    this.a = (ASN1ObjectIdentifier) aSN1Encodable;
                } else if (aSN1Encodable instanceof DERIA5String) {
                    this.b = DERIA5String.getInstance(aSN1Encodable).getString();
                } else if (aSN1Encodable instanceof ASN1String) {
                    this.c = DirectoryString.getInstance(aSN1Encodable);
                } else {
                    StringBuilder L = a.L("Bad object encountered: ");
                    L.append(aSN1Encodable.getClass());
                    throw new IllegalArgumentException(L.toString());
                }
            }
            if (objects.hasMoreElements()) {
                ASN1Encodable aSN1Encodable2 = (ASN1Encodable) objects.nextElement();
                if (aSN1Encodable2 instanceof DERIA5String) {
                    this.b = DERIA5String.getInstance(aSN1Encodable2).getString();
                } else if (aSN1Encodable2 instanceof ASN1String) {
                    this.c = DirectoryString.getInstance(aSN1Encodable2);
                } else {
                    StringBuilder L2 = a.L("Bad object encountered: ");
                    L2.append(aSN1Encodable2.getClass());
                    throw new IllegalArgumentException(L2.toString());
                }
            }
            if (objects.hasMoreElements()) {
                ASN1Encodable aSN1Encodable3 = (ASN1Encodable) objects.nextElement();
                if (aSN1Encodable3 instanceof ASN1String) {
                    this.c = DirectoryString.getInstance(aSN1Encodable3);
                    return;
                }
                StringBuilder L3 = a.L("Bad object encountered: ");
                L3.append(aSN1Encodable3.getClass());
                throw new IllegalArgumentException(L3.toString());
            }
            return;
        }
        throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
    }

    public static NamingAuthority getInstance(Object obj) {
        if (obj == null || (obj instanceof NamingAuthority)) {
            return (NamingAuthority) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new NamingAuthority((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("illegal object in getInstance: ")));
    }

    public ASN1ObjectIdentifier getNamingAuthorityId() {
        return this.a;
    }

    public DirectoryString getNamingAuthorityText() {
        return this.c;
    }

    public String getNamingAuthorityUrl() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.a;
        if (aSN1ObjectIdentifier != null) {
            aSN1EncodableVector.add(aSN1ObjectIdentifier);
        }
        String str = this.b;
        if (str != null) {
            aSN1EncodableVector.add(new DERIA5String(str, true));
        }
        DirectoryString directoryString = this.c;
        if (directoryString != null) {
            aSN1EncodableVector.add(directoryString);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static NamingAuthority getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public NamingAuthority(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str, DirectoryString directoryString) {
        this.a = aSN1ObjectIdentifier;
        this.b = str;
        this.c = directoryString;
    }
}
