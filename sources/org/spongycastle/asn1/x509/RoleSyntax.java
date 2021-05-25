package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
public class RoleSyntax extends ASN1Object {
    public GeneralNames a;
    public GeneralName b;

    public RoleSyntax(GeneralNames generalNames, GeneralName generalName) {
        if (generalName == null || generalName.getTagNo() != 6 || ((ASN1String) generalName.getName()).getString().equals("")) {
            throw new IllegalArgumentException("the role name MUST be non empty and MUST use the URI option of GeneralName");
        }
        this.a = generalNames;
        this.b = generalName;
    }

    public static RoleSyntax getInstance(Object obj) {
        if (obj instanceof RoleSyntax) {
            return (RoleSyntax) obj;
        }
        if (obj != null) {
            return new RoleSyntax(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralNames getRoleAuthority() {
        return this.a;
    }

    public String[] getRoleAuthorityAsString() {
        GeneralNames generalNames = this.a;
        if (generalNames == null) {
            return new String[0];
        }
        GeneralName[] names = generalNames.getNames();
        String[] strArr = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            ASN1Encodable name = names[i].getName();
            if (name instanceof ASN1String) {
                strArr[i] = ((ASN1String) name).getString();
            } else {
                strArr[i] = name.toString();
            }
        }
        return strArr;
    }

    public GeneralName getRoleName() {
        return this.b;
    }

    public String getRoleNameAsString() {
        return ((ASN1String) this.b.getName()).getString();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        GeneralNames generalNames = this.a;
        if (generalNames != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, generalNames));
        }
        aSN1EncodableVector.add(new DERTaggedObject(true, 1, this.b));
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder L = a.L("Name: ");
        L.append(getRoleNameAsString());
        L.append(" - Auth: ");
        StringBuffer stringBuffer = new StringBuffer(L.toString());
        GeneralNames generalNames = this.a;
        if (generalNames == null || generalNames.getNames().length == 0) {
            stringBuffer.append(UploadServiceLogger.NA);
        } else {
            String[] roleAuthorityAsString = getRoleAuthorityAsString();
            stringBuffer.append('[');
            stringBuffer.append(roleAuthorityAsString[0]);
            for (int i = 1; i < roleAuthorityAsString.length; i++) {
                stringBuffer.append(", ");
                stringBuffer.append(roleAuthorityAsString[i]);
            }
            stringBuffer.append(']');
        }
        return stringBuffer.toString();
    }

    public RoleSyntax(GeneralName generalName) {
        this(null, generalName);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RoleSyntax(String str) {
        this(new GeneralName(6, str == null ? "" : str));
    }

    public RoleSyntax(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
        }
        for (int i = 0; i != aSN1Sequence.size(); i++) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                this.a = GeneralNames.getInstance(instance, false);
            } else if (tagNo == 1) {
                this.b = GeneralName.getInstance(instance, true);
            } else {
                throw new IllegalArgumentException("Unknown tag in RoleSyntax");
            }
        }
    }
}
