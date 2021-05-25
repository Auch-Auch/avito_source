package org.spongycastle.asn1.x500.style;

import a2.b.a.a.a;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1ParsingException;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.x500.AttributeTypeAndValue;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.X500NameStyle;
public abstract class AbstractX500NameStyle implements X500NameStyle {
    public static Hashtable copyHashTable(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            hashtable2.put(nextElement, hashtable.get(nextElement));
        }
        return hashtable2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074 A[LOOP:0: B:10:0x003b->B:35:0x0074, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0073 A[SYNTHETIC] */
    @Override // org.spongycastle.asn1.x500.X500NameStyle
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean areEqual(org.spongycastle.asn1.x500.X500Name r9, org.spongycastle.asn1.x500.X500Name r10) {
        /*
            r8 = this;
            org.spongycastle.asn1.x500.RDN[] r9 = r9.getRDNs()
            org.spongycastle.asn1.x500.RDN[] r10 = r10.getRDNs()
            int r0 = r9.length
            int r1 = r10.length
            r2 = 0
            if (r0 == r1) goto L_0x000e
            return r2
        L_0x000e:
            r0 = r9[r2]
            org.spongycastle.asn1.x500.AttributeTypeAndValue r0 = r0.getFirst()
            r1 = 1
            if (r0 == 0) goto L_0x0039
            r0 = r10[r2]
            org.spongycastle.asn1.x500.AttributeTypeAndValue r0 = r0.getFirst()
            if (r0 == 0) goto L_0x0039
            r0 = r9[r2]
            org.spongycastle.asn1.x500.AttributeTypeAndValue r0 = r0.getFirst()
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = r0.getType()
            r3 = r10[r2]
            org.spongycastle.asn1.x500.AttributeTypeAndValue r3 = r3.getFirst()
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r3.getType()
            boolean r0 = r0.equals(r3)
            r0 = r0 ^ r1
            goto L_0x003a
        L_0x0039:
            r0 = 0
        L_0x003a:
            r3 = 0
        L_0x003b:
            int r4 = r9.length
            if (r3 == r4) goto L_0x0077
            r4 = r9[r3]
            r5 = 0
            if (r0 == 0) goto L_0x0059
            int r6 = r10.length
            int r6 = r6 - r1
        L_0x0045:
            if (r6 < 0) goto L_0x0070
            r7 = r10[r6]
            if (r7 == 0) goto L_0x0056
            r7 = r10[r6]
            boolean r7 = r8.rdnAreEqual(r4, r7)
            if (r7 == 0) goto L_0x0056
            r10[r6] = r5
            goto L_0x006b
        L_0x0056:
            int r6 = r6 + -1
            goto L_0x0045
        L_0x0059:
            r6 = 0
        L_0x005a:
            int r7 = r10.length
            if (r6 == r7) goto L_0x0070
            r7 = r10[r6]
            if (r7 == 0) goto L_0x006d
            r7 = r10[r6]
            boolean r7 = r8.rdnAreEqual(r4, r7)
            if (r7 == 0) goto L_0x006d
            r10[r6] = r5
        L_0x006b:
            r4 = 1
            goto L_0x0071
        L_0x006d:
            int r6 = r6 + 1
            goto L_0x005a
        L_0x0070:
            r4 = 0
        L_0x0071:
            if (r4 != 0) goto L_0x0074
            return r2
        L_0x0074:
            int r3 = r3 + 1
            goto L_0x003b
        L_0x0077:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x500.style.AbstractX500NameStyle.areEqual(org.spongycastle.asn1.x500.X500Name, org.spongycastle.asn1.x500.X500Name):boolean");
    }

    @Override // org.spongycastle.asn1.x500.X500NameStyle
    public int calculateHashCode(X500Name x500Name) {
        RDN[] rDNs = x500Name.getRDNs();
        int i = 0;
        for (int i2 = 0; i2 != rDNs.length; i2++) {
            if (rDNs[i2].isMultiValued()) {
                AttributeTypeAndValue[] typesAndValues = rDNs[i2].getTypesAndValues();
                for (int i3 = 0; i3 != typesAndValues.length; i3++) {
                    i = (i ^ typesAndValues[i3].getType().hashCode()) ^ IETFUtils.canonicalize(IETFUtils.valueToString(typesAndValues[i3].getValue())).hashCode();
                }
            } else {
                i = (i ^ rDNs[i2].getFirst().getType().hashCode()) ^ IETFUtils.canonicalize(IETFUtils.valueToString(rDNs[i2].getFirst().getValue())).hashCode();
            }
        }
        return i;
    }

    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        return new DERUTF8String(str);
    }

    public boolean rdnAreEqual(RDN rdn, RDN rdn2) {
        return IETFUtils.rDNAreEqual(rdn, rdn2);
    }

    @Override // org.spongycastle.asn1.x500.X500NameStyle
    public ASN1Encodable stringToValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (str.length() == 0 || str.charAt(0) != '#') {
            if (str.length() != 0 && str.charAt(0) == '\\') {
                str = str.substring(1);
            }
            return encodeStringValue(aSN1ObjectIdentifier, str);
        }
        try {
            return IETFUtils.valueFromHexString(str, 1);
        } catch (IOException unused) {
            StringBuilder L = a.L("can't recode value for oid ");
            L.append(aSN1ObjectIdentifier.getId());
            throw new ASN1ParsingException(L.toString());
        }
    }
}
