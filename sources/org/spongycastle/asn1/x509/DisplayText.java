package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBMPString;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.DERVisibleString;
public class DisplayText extends ASN1Object implements ASN1Choice {
    public static final int CONTENT_TYPE_BMPSTRING = 1;
    public static final int CONTENT_TYPE_IA5STRING = 0;
    public static final int CONTENT_TYPE_UTF8STRING = 2;
    public static final int CONTENT_TYPE_VISIBLESTRING = 3;
    public static final int DISPLAY_TEXT_MAXIMUM_SIZE = 200;
    public ASN1String a;

    public DisplayText(int i, String str) {
        str = str.length() > 200 ? str.substring(0, 200) : str;
        if (i == 0) {
            this.a = new DERIA5String(str);
        } else if (i == 1) {
            this.a = new DERBMPString(str);
        } else if (i == 2) {
            this.a = new DERUTF8String(str);
        } else if (i != 3) {
            this.a = new DERUTF8String(str);
        } else {
            this.a = new DERVisibleString(str);
        }
    }

    public static DisplayText getInstance(Object obj) {
        if (obj instanceof ASN1String) {
            return new DisplayText((ASN1String) obj);
        }
        if (obj == null || (obj instanceof DisplayText)) {
            return (DisplayText) obj;
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("illegal object in getInstance: ")));
    }

    public String getString() {
        return this.a.getString();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return (ASN1Primitive) this.a;
    }

    public static DisplayText getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public DisplayText(String str) {
        this.a = new DERUTF8String(str.length() > 200 ? str.substring(0, 200) : str);
    }

    public DisplayText(ASN1String aSN1String) {
        this.a = aSN1String;
        if (!(aSN1String instanceof DERUTF8String) && !(aSN1String instanceof DERBMPString) && !(aSN1String instanceof DERIA5String) && !(aSN1String instanceof DERVisibleString)) {
            throw new IllegalArgumentException("unknown STRING type in DisplayText");
        }
    }
}
