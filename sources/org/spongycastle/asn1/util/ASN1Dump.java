package org.spongycastle.asn1.util;

import a2.b.a.a.a;
import java.io.IOException;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1ApplicationSpecific;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.ASN1UTCTime;
import org.spongycastle.asn1.BERApplicationSpecific;
import org.spongycastle.asn1.BEROctetString;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERSet;
import org.spongycastle.asn1.BERTaggedObject;
import org.spongycastle.asn1.DERApplicationSpecific;
import org.spongycastle.asn1.DERBMPString;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERExternal;
import org.spongycastle.asn1.DERGraphicString;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERT61String;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.DERVideotexString;
import org.spongycastle.asn1.DERVisibleString;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;
public class ASN1Dump {
    public static void a(String str, boolean z, ASN1Primitive aSN1Primitive, StringBuffer stringBuffer) {
        String lineSeparator = Strings.lineSeparator();
        if (aSN1Primitive instanceof ASN1Sequence) {
            Enumeration objects = ((ASN1Sequence) aSN1Primitive).getObjects();
            String str2 = str + "    ";
            stringBuffer.append(str);
            if (aSN1Primitive instanceof BERSequence) {
                stringBuffer.append("BER Sequence");
            } else if (aSN1Primitive instanceof DERSequence) {
                stringBuffer.append("DER Sequence");
            } else {
                stringBuffer.append("Sequence");
            }
            stringBuffer.append(lineSeparator);
            while (objects.hasMoreElements()) {
                Object nextElement = objects.nextElement();
                if (nextElement == null || nextElement.equals(DERNull.INSTANCE)) {
                    stringBuffer.append(str2);
                    stringBuffer.append("NULL");
                    stringBuffer.append(lineSeparator);
                } else if (nextElement instanceof ASN1Primitive) {
                    a(str2, z, (ASN1Primitive) nextElement, stringBuffer);
                } else {
                    a(str2, z, ((ASN1Encodable) nextElement).toASN1Primitive(), stringBuffer);
                }
            }
        } else if (aSN1Primitive instanceof ASN1TaggedObject) {
            String str3 = str + "    ";
            stringBuffer.append(str);
            if (aSN1Primitive instanceof BERTaggedObject) {
                stringBuffer.append("BER Tagged [");
            } else {
                stringBuffer.append("Tagged [");
            }
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
            stringBuffer.append(Integer.toString(aSN1TaggedObject.getTagNo()));
            stringBuffer.append(']');
            if (!aSN1TaggedObject.isExplicit()) {
                stringBuffer.append(" IMPLICIT ");
            }
            stringBuffer.append(lineSeparator);
            if (aSN1TaggedObject.isEmpty()) {
                stringBuffer.append(str3);
                stringBuffer.append("EMPTY");
                stringBuffer.append(lineSeparator);
                return;
            }
            a(str3, z, aSN1TaggedObject.getObject(), stringBuffer);
        } else if (aSN1Primitive instanceof ASN1Set) {
            Enumeration objects2 = ((ASN1Set) aSN1Primitive).getObjects();
            String str4 = str + "    ";
            stringBuffer.append(str);
            if (aSN1Primitive instanceof BERSet) {
                stringBuffer.append("BER Set");
            } else {
                stringBuffer.append("DER Set");
            }
            stringBuffer.append(lineSeparator);
            while (objects2.hasMoreElements()) {
                Object nextElement2 = objects2.nextElement();
                if (nextElement2 == null) {
                    stringBuffer.append(str4);
                    stringBuffer.append("NULL");
                    stringBuffer.append(lineSeparator);
                } else if (nextElement2 instanceof ASN1Primitive) {
                    a(str4, z, (ASN1Primitive) nextElement2, stringBuffer);
                } else {
                    a(str4, z, ((ASN1Encodable) nextElement2).toASN1Primitive(), stringBuffer);
                }
            }
        } else if (aSN1Primitive instanceof ASN1OctetString) {
            ASN1OctetString aSN1OctetString = (ASN1OctetString) aSN1Primitive;
            if (aSN1Primitive instanceof BEROctetString) {
                StringBuilder Q = a.Q(str, "BER Constructed Octet String[");
                Q.append(aSN1OctetString.getOctets().length);
                Q.append("] ");
                stringBuffer.append(Q.toString());
            } else {
                StringBuilder Q2 = a.Q(str, "DER Octet String[");
                Q2.append(aSN1OctetString.getOctets().length);
                Q2.append("] ");
                stringBuffer.append(Q2.toString());
            }
            if (z) {
                stringBuffer.append(c(str, aSN1OctetString.getOctets()));
            } else {
                stringBuffer.append(lineSeparator);
            }
        } else if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
            StringBuilder Q3 = a.Q(str, "ObjectIdentifier(");
            Q3.append(((ASN1ObjectIdentifier) aSN1Primitive).getId());
            Q3.append(")");
            Q3.append(lineSeparator);
            stringBuffer.append(Q3.toString());
        } else if (aSN1Primitive instanceof ASN1Boolean) {
            StringBuilder Q4 = a.Q(str, "Boolean(");
            Q4.append(((ASN1Boolean) aSN1Primitive).isTrue());
            Q4.append(")");
            Q4.append(lineSeparator);
            stringBuffer.append(Q4.toString());
        } else if (aSN1Primitive instanceof ASN1Integer) {
            StringBuilder Q5 = a.Q(str, "Integer(");
            Q5.append(((ASN1Integer) aSN1Primitive).getValue());
            Q5.append(")");
            Q5.append(lineSeparator);
            stringBuffer.append(Q5.toString());
        } else if (aSN1Primitive instanceof DERBitString) {
            DERBitString dERBitString = (DERBitString) aSN1Primitive;
            StringBuilder Q6 = a.Q(str, "DER Bit String[");
            Q6.append(dERBitString.getBytes().length);
            Q6.append(", ");
            Q6.append(dERBitString.getPadBits());
            Q6.append("] ");
            stringBuffer.append(Q6.toString());
            if (z) {
                stringBuffer.append(c(str, dERBitString.getBytes()));
            } else {
                stringBuffer.append(lineSeparator);
            }
        } else if (aSN1Primitive instanceof DERIA5String) {
            StringBuilder Q7 = a.Q(str, "IA5String(");
            Q7.append(((DERIA5String) aSN1Primitive).getString());
            Q7.append(") ");
            Q7.append(lineSeparator);
            stringBuffer.append(Q7.toString());
        } else if (aSN1Primitive instanceof DERUTF8String) {
            StringBuilder Q8 = a.Q(str, "UTF8String(");
            Q8.append(((DERUTF8String) aSN1Primitive).getString());
            Q8.append(") ");
            Q8.append(lineSeparator);
            stringBuffer.append(Q8.toString());
        } else if (aSN1Primitive instanceof DERPrintableString) {
            StringBuilder Q9 = a.Q(str, "PrintableString(");
            Q9.append(((DERPrintableString) aSN1Primitive).getString());
            Q9.append(") ");
            Q9.append(lineSeparator);
            stringBuffer.append(Q9.toString());
        } else if (aSN1Primitive instanceof DERVisibleString) {
            StringBuilder Q10 = a.Q(str, "VisibleString(");
            Q10.append(((DERVisibleString) aSN1Primitive).getString());
            Q10.append(") ");
            Q10.append(lineSeparator);
            stringBuffer.append(Q10.toString());
        } else if (aSN1Primitive instanceof DERBMPString) {
            StringBuilder Q11 = a.Q(str, "BMPString(");
            Q11.append(((DERBMPString) aSN1Primitive).getString());
            Q11.append(") ");
            Q11.append(lineSeparator);
            stringBuffer.append(Q11.toString());
        } else if (aSN1Primitive instanceof DERT61String) {
            StringBuilder Q12 = a.Q(str, "T61String(");
            Q12.append(((DERT61String) aSN1Primitive).getString());
            Q12.append(") ");
            Q12.append(lineSeparator);
            stringBuffer.append(Q12.toString());
        } else if (aSN1Primitive instanceof DERGraphicString) {
            StringBuilder Q13 = a.Q(str, "GraphicString(");
            Q13.append(((DERGraphicString) aSN1Primitive).getString());
            Q13.append(") ");
            Q13.append(lineSeparator);
            stringBuffer.append(Q13.toString());
        } else if (aSN1Primitive instanceof DERVideotexString) {
            StringBuilder Q14 = a.Q(str, "VideotexString(");
            Q14.append(((DERVideotexString) aSN1Primitive).getString());
            Q14.append(") ");
            Q14.append(lineSeparator);
            stringBuffer.append(Q14.toString());
        } else if (aSN1Primitive instanceof ASN1UTCTime) {
            StringBuilder Q15 = a.Q(str, "UTCTime(");
            Q15.append(((ASN1UTCTime) aSN1Primitive).getTime());
            Q15.append(") ");
            Q15.append(lineSeparator);
            stringBuffer.append(Q15.toString());
        } else if (aSN1Primitive instanceof ASN1GeneralizedTime) {
            StringBuilder Q16 = a.Q(str, "GeneralizedTime(");
            Q16.append(((ASN1GeneralizedTime) aSN1Primitive).getTime());
            Q16.append(") ");
            Q16.append(lineSeparator);
            stringBuffer.append(Q16.toString());
        } else if (aSN1Primitive instanceof BERApplicationSpecific) {
            stringBuffer.append(d(ASN1Encoding.BER, str, z, aSN1Primitive, lineSeparator));
        } else if (aSN1Primitive instanceof DERApplicationSpecific) {
            stringBuffer.append(d(ASN1Encoding.DER, str, z, aSN1Primitive, lineSeparator));
        } else if (aSN1Primitive instanceof ASN1Enumerated) {
            StringBuilder Q17 = a.Q(str, "DER Enumerated(");
            Q17.append(((ASN1Enumerated) aSN1Primitive).getValue());
            Q17.append(")");
            Q17.append(lineSeparator);
            stringBuffer.append(Q17.toString());
        } else if (aSN1Primitive instanceof DERExternal) {
            DERExternal dERExternal = (DERExternal) aSN1Primitive;
            stringBuffer.append(str + "External " + lineSeparator);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("    ");
            String sb2 = sb.toString();
            if (dERExternal.getDirectReference() != null) {
                StringBuilder Q18 = a.Q(sb2, "Direct Reference: ");
                Q18.append(dERExternal.getDirectReference().getId());
                Q18.append(lineSeparator);
                stringBuffer.append(Q18.toString());
            }
            if (dERExternal.getIndirectReference() != null) {
                StringBuilder Q19 = a.Q(sb2, "Indirect Reference: ");
                Q19.append(dERExternal.getIndirectReference().toString());
                Q19.append(lineSeparator);
                stringBuffer.append(Q19.toString());
            }
            if (dERExternal.getDataValueDescriptor() != null) {
                a(sb2, z, dERExternal.getDataValueDescriptor(), stringBuffer);
            }
            StringBuilder Q20 = a.Q(sb2, "Encoding: ");
            Q20.append(dERExternal.getEncoding());
            Q20.append(lineSeparator);
            stringBuffer.append(Q20.toString());
            a(sb2, z, dERExternal.getExternalContent(), stringBuffer);
        } else {
            StringBuilder L = a.L(str);
            L.append(aSN1Primitive.toString());
            L.append(lineSeparator);
            stringBuffer.append(L.toString());
        }
    }

    public static String b(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 != i + i2; i3++) {
            if (bArr[i3] >= 32 && bArr[i3] <= 126) {
                stringBuffer.append((char) bArr[i3]);
            }
        }
        return stringBuffer.toString();
    }

    public static String c(String str, byte[] bArr) {
        String lineSeparator = Strings.lineSeparator();
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = str + "    ";
        stringBuffer.append(lineSeparator);
        for (int i = 0; i < bArr.length; i += 32) {
            if (bArr.length - i > 32) {
                stringBuffer.append(str2);
                stringBuffer.append(Strings.fromByteArray(Hex.encode(bArr, i, 32)));
                stringBuffer.append("    ");
                stringBuffer.append(b(bArr, i, 32));
                stringBuffer.append(lineSeparator);
            } else {
                stringBuffer.append(str2);
                stringBuffer.append(Strings.fromByteArray(Hex.encode(bArr, i, bArr.length - i)));
                for (int length = bArr.length - i; length != 32; length++) {
                    stringBuffer.append("  ");
                }
                stringBuffer.append("    ");
                stringBuffer.append(b(bArr, i, bArr.length - i));
                stringBuffer.append(lineSeparator);
            }
        }
        return stringBuffer.toString();
    }

    public static String d(String str, String str2, boolean z, ASN1Primitive aSN1Primitive, String str3) {
        ASN1ApplicationSpecific instance = ASN1ApplicationSpecific.getInstance(aSN1Primitive);
        StringBuffer stringBuffer = new StringBuffer();
        if (instance.isConstructed()) {
            try {
                ASN1Sequence instance2 = ASN1Sequence.getInstance(instance.getObject(16));
                stringBuffer.append(str2 + str + " ApplicationSpecific[" + instance.getApplicationTag() + "]" + str3);
                Enumeration objects = instance2.getObjects();
                while (objects.hasMoreElements()) {
                    a(str2 + "    ", z, (ASN1Primitive) objects.nextElement(), stringBuffer);
                }
            } catch (IOException e) {
                stringBuffer.append(e);
            }
            return stringBuffer.toString();
        }
        StringBuilder R = a.R(str2, str, " ApplicationSpecific[");
        R.append(instance.getApplicationTag());
        R.append("] (");
        R.append(Strings.fromByteArray(Hex.encode(instance.getContents())));
        R.append(")");
        R.append(str3);
        return R.toString();
    }

    public static String dumpAsString(Object obj) {
        return dumpAsString(obj, false);
    }

    public static String dumpAsString(Object obj, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        if (obj instanceof ASN1Primitive) {
            a("", z, (ASN1Primitive) obj, stringBuffer);
        } else if (obj instanceof ASN1Encodable) {
            a("", z, ((ASN1Encodable) obj).toASN1Primitive(), stringBuffer);
        } else {
            StringBuilder L = a.L("unknown object type ");
            L.append(obj.toString());
            return L.toString();
        }
        return stringBuffer.toString();
    }
}
