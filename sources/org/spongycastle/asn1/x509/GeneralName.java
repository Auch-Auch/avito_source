package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import java.io.IOException;
import java.util.StringTokenizer;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.util.IPAddress;
public class GeneralName extends ASN1Object implements ASN1Choice {
    public static final int dNSName = 2;
    public static final int directoryName = 4;
    public static final int ediPartyName = 5;
    public static final int iPAddress = 7;
    public static final int otherName = 0;
    public static final int registeredID = 8;
    public static final int rfc822Name = 1;
    public static final int uniformResourceIdentifier = 6;
    public static final int x400Address = 3;
    public ASN1Encodable a;
    public int b;

    public GeneralName(X509Name x509Name) {
        this.a = X500Name.getInstance(x509Name);
        this.b = 4;
    }

    public static GeneralName getInstance(Object obj) {
        if (obj == null || (obj instanceof GeneralName)) {
            return (GeneralName) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) obj;
            int tagNo = aSN1TaggedObject.getTagNo();
            switch (tagNo) {
                case 0:
                    return new GeneralName(tagNo, ASN1Sequence.getInstance(aSN1TaggedObject, false));
                case 1:
                    return new GeneralName(tagNo, DERIA5String.getInstance(aSN1TaggedObject, false));
                case 2:
                    return new GeneralName(tagNo, DERIA5String.getInstance(aSN1TaggedObject, false));
                case 3:
                    throw new IllegalArgumentException(a.M2("unknown tag: ", tagNo));
                case 4:
                    return new GeneralName(tagNo, X500Name.getInstance(aSN1TaggedObject, true));
                case 5:
                    return new GeneralName(tagNo, ASN1Sequence.getInstance(aSN1TaggedObject, false));
                case 6:
                    return new GeneralName(tagNo, DERIA5String.getInstance(aSN1TaggedObject, false));
                case 7:
                    return new GeneralName(tagNo, ASN1OctetString.getInstance(aSN1TaggedObject, false));
                case 8:
                    return new GeneralName(tagNo, ASN1ObjectIdentifier.getInstance(aSN1TaggedObject, false));
            }
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException unused) {
                throw new IllegalArgumentException("unable to parse encoded general name");
            }
        } else {
            throw new IllegalArgumentException(a.H2(obj, a.L("unknown object in getInstance: ")));
        }
    }

    public final void a(int[] iArr, byte[] bArr, int i) {
        for (int i2 = 0; i2 != iArr.length; i2++) {
            int i3 = i2 * 2;
            bArr[i3 + i] = (byte) (iArr[i2] >> 8);
            bArr[i3 + 1 + i] = (byte) iArr[i2];
        }
    }

    public final void b(String str, byte[] bArr, int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "./");
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            bArr[i2 + i] = (byte) Integer.parseInt(stringTokenizer.nextToken());
            i2++;
        }
    }

    public final int[] c(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ":", true);
        int[] iArr = new int[8];
        if (str.charAt(0) == ':' && str.charAt(1) == ':') {
            stringTokenizer.nextToken();
        }
        int i = -1;
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.equals(":")) {
                iArr[i2] = 0;
                i2++;
                i = i2;
            } else if (nextToken.indexOf(46) < 0) {
                int i3 = i2 + 1;
                iArr[i2] = Integer.parseInt(nextToken, 16);
                if (stringTokenizer.hasMoreTokens()) {
                    stringTokenizer.nextToken();
                }
                i2 = i3;
            } else {
                StringTokenizer stringTokenizer2 = new StringTokenizer(nextToken, ".");
                int i4 = i2 + 1;
                iArr[i2] = (Integer.parseInt(stringTokenizer2.nextToken()) << 8) | Integer.parseInt(stringTokenizer2.nextToken());
                i2 = i4 + 1;
                iArr[i4] = Integer.parseInt(stringTokenizer2.nextToken()) | (Integer.parseInt(stringTokenizer2.nextToken()) << 8);
            }
        }
        if (i2 != 8) {
            int i5 = i2 - i;
            int i6 = 8 - i5;
            System.arraycopy(iArr, i, iArr, i6, i5);
            while (i != i6) {
                iArr[i] = 0;
                i++;
            }
        }
        return iArr;
    }

    public ASN1Encodable getName() {
        return this.a;
    }

    public int getTagNo() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        int i = this.b;
        if (i == 4) {
            return new DERTaggedObject(true, i, this.a);
        }
        return new DERTaggedObject(false, i, this.a);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append(": ");
        int i = this.b;
        if (!(i == 1 || i == 2)) {
            if (i == 4) {
                stringBuffer.append(X500Name.getInstance(this.a).toString());
            } else if (i != 6) {
                stringBuffer.append(this.a.toString());
            }
            return stringBuffer.toString();
        }
        stringBuffer.append(DERIA5String.getInstance(this.a).getString());
        return stringBuffer.toString();
    }

    public GeneralName(X500Name x500Name) {
        this.a = x500Name;
        this.b = 4;
    }

    public GeneralName(int i, ASN1Encodable aSN1Encodable) {
        this.a = aSN1Encodable;
        this.b = i;
    }

    public GeneralName(int i, String str) {
        byte[] bArr;
        int[] iArr;
        this.b = i;
        if (i == 1 || i == 2 || i == 6) {
            this.a = new DERIA5String(str);
        } else if (i == 8) {
            this.a = new ASN1ObjectIdentifier(str);
        } else if (i == 4) {
            this.a = new X500Name(str);
        } else if (i == 7) {
            int i2 = 0;
            if (IPAddress.isValidIPv6WithNetmask(str) || IPAddress.isValidIPv6(str)) {
                int indexOf = str.indexOf(47);
                if (indexOf < 0) {
                    bArr = new byte[16];
                    a(c(str), bArr, 0);
                } else {
                    byte[] bArr2 = new byte[32];
                    a(c(str.substring(0, indexOf)), bArr2, 0);
                    String substring = str.substring(indexOf + 1);
                    if (substring.indexOf(58) > 0) {
                        iArr = c(substring);
                    } else {
                        int[] iArr2 = new int[8];
                        int parseInt = Integer.parseInt(substring);
                        while (i2 != parseInt) {
                            int i3 = i2 / 16;
                            iArr2[i3] = iArr2[i3] | (1 << (15 - (i2 % 16)));
                            i2++;
                        }
                        iArr = iArr2;
                    }
                    a(iArr, bArr2, 16);
                    bArr = bArr2;
                }
            } else if (IPAddress.isValidIPv4WithNetmask(str) || IPAddress.isValidIPv4(str)) {
                int indexOf2 = str.indexOf(47);
                if (indexOf2 < 0) {
                    bArr = new byte[4];
                    b(str, bArr, 0);
                } else {
                    byte[] bArr3 = new byte[8];
                    b(str.substring(0, indexOf2), bArr3, 0);
                    String substring2 = str.substring(indexOf2 + 1);
                    if (substring2.indexOf(46) > 0) {
                        b(substring2, bArr3, 4);
                    } else {
                        int parseInt2 = Integer.parseInt(substring2);
                        while (i2 != parseInt2) {
                            int i4 = (i2 / 8) + 4;
                            bArr3[i4] = (byte) (bArr3[i4] | (1 << (7 - (i2 % 8))));
                            i2++;
                        }
                    }
                    bArr = bArr3;
                }
            } else {
                bArr = null;
            }
            if (bArr != null) {
                this.a = new DEROctetString(bArr);
                return;
            }
            throw new IllegalArgumentException("IP Address is invalid");
        } else {
            throw new IllegalArgumentException(a.M2("can't process String for tag: ", i));
        }
    }

    public static GeneralName getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1TaggedObject.getInstance(aSN1TaggedObject, true));
    }
}
