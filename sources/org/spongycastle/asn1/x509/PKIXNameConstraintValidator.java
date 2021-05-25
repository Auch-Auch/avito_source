package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Strings;
public class PKIXNameConstraintValidator implements NameConstraintValidator {
    public Set a = new HashSet();
    public Set b = new HashSet();
    public Set c = new HashSet();
    public Set d = new HashSet();
    public Set e = new HashSet();
    public Set f;
    public Set g;
    public Set h;
    public Set i;
    public Set j;

    public static byte[] g(byte[] bArr, byte[] bArr2) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if ((bArr[i2] & 65535) > (65535 & bArr2[i2])) {
                return bArr;
            }
        }
        return bArr2;
    }

    public static byte[] h(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr3[i2] = (byte) (bArr[i2] | bArr2[i2]);
        }
        return bArr3;
    }

    public static boolean j(ASN1Sequence aSN1Sequence, ASN1Sequence aSN1Sequence2) {
        if (aSN1Sequence2.size() < 1 || aSN1Sequence2.size() > aSN1Sequence.size()) {
            return false;
        }
        for (int size = aSN1Sequence2.size() - 1; size >= 0; size--) {
            if (!aSN1Sequence2.getObjectAt(size).equals(aSN1Sequence.getObjectAt(size))) {
                return false;
            }
        }
        return true;
    }

    public final boolean a(Collection collection, Collection collection2) {
        boolean z;
        boolean z2;
        if (collection == collection2) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        for (Object obj : collection) {
            Iterator it = collection2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    continue;
                    break;
                }
                Object next = it.next();
                if (obj == next) {
                    z2 = true;
                    continue;
                } else if (obj == null || next == null) {
                    z2 = false;
                    continue;
                } else if (!(obj instanceof byte[]) || !(next instanceof byte[])) {
                    z2 = obj.equals(next);
                    continue;
                } else {
                    z2 = Arrays.areEqual((byte[]) obj, (byte[]) next);
                    continue;
                }
                if (z2) {
                    z = true;
                    continue;
                    break;
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    @Override // org.spongycastle.asn1.x509.NameConstraintValidator
    public void addExcludedSubtree(GeneralSubtree generalSubtree) {
        GeneralName base = generalSubtree.getBase();
        int tagNo = base.getTagNo();
        if (tagNo == 1) {
            Set<String> set = this.c;
            String c2 = c(base);
            if (!set.isEmpty()) {
                HashSet hashSet = new HashSet();
                for (String str : set) {
                    if (str.indexOf(64) != -1) {
                        String N2 = a.N2(str, 64, 1);
                        if (c2.indexOf(64) != -1) {
                            if (str.equalsIgnoreCase(c2)) {
                                hashSet.add(str);
                            } else {
                                hashSet.add(str);
                                hashSet.add(c2);
                            }
                        } else if (c2.startsWith(".")) {
                            if (k(N2, c2)) {
                                hashSet.add(c2);
                            } else {
                                hashSet.add(str);
                                hashSet.add(c2);
                            }
                        } else if (N2.equalsIgnoreCase(c2)) {
                            hashSet.add(c2);
                        } else {
                            hashSet.add(str);
                            hashSet.add(c2);
                        }
                    } else if (str.startsWith(".")) {
                        if (c2.indexOf(64) != -1) {
                            if (k(c2.substring(str.indexOf(64) + 1), str)) {
                                hashSet.add(str);
                            } else {
                                hashSet.add(str);
                                hashSet.add(c2);
                            }
                        } else if (c2.startsWith(".")) {
                            if (k(str, c2) || str.equalsIgnoreCase(c2)) {
                                hashSet.add(c2);
                            } else if (k(c2, str)) {
                                hashSet.add(str);
                            } else {
                                hashSet.add(str);
                                hashSet.add(c2);
                            }
                        } else if (k(c2, str)) {
                            hashSet.add(str);
                        } else {
                            hashSet.add(str);
                            hashSet.add(c2);
                        }
                    } else if (c2.indexOf(64) != -1) {
                        if (c2.substring(str.indexOf(64) + 1).equalsIgnoreCase(str)) {
                            hashSet.add(str);
                        } else {
                            hashSet.add(str);
                            hashSet.add(c2);
                        }
                    } else if (c2.startsWith(".")) {
                        if (k(str, c2)) {
                            hashSet.add(c2);
                        } else {
                            hashSet.add(str);
                            hashSet.add(c2);
                        }
                    } else if (str.equalsIgnoreCase(c2)) {
                        hashSet.add(str);
                    } else {
                        hashSet.add(str);
                        hashSet.add(c2);
                    }
                }
                set = hashSet;
            } else if (c2 != null) {
                set.add(c2);
            }
            this.c = set;
        } else if (tagNo == 2) {
            Set<String> set2 = this.b;
            String c3 = c(base);
            if (!set2.isEmpty()) {
                HashSet hashSet2 = new HashSet();
                for (String str2 : set2) {
                    if (k(str2, c3)) {
                        hashSet2.add(c3);
                    } else if (k(c3, str2)) {
                        hashSet2.add(str2);
                    } else {
                        hashSet2.add(str2);
                        hashSet2.add(c3);
                    }
                }
                set2 = hashSet2;
            } else if (c3 != null) {
                set2.add(c3);
            }
            this.b = set2;
        } else if (tagNo == 4) {
            Set<ASN1Sequence> set3 = this.a;
            ASN1Sequence aSN1Sequence = (ASN1Sequence) base.getName().toASN1Primitive();
            if (!set3.isEmpty()) {
                HashSet hashSet3 = new HashSet();
                for (ASN1Sequence aSN1Sequence2 : set3) {
                    if (j(aSN1Sequence, aSN1Sequence2)) {
                        hashSet3.add(aSN1Sequence2);
                    } else if (j(aSN1Sequence2, aSN1Sequence)) {
                        hashSet3.add(aSN1Sequence);
                    } else {
                        hashSet3.add(aSN1Sequence2);
                        hashSet3.add(aSN1Sequence);
                    }
                }
                set3 = hashSet3;
            } else if (aSN1Sequence != null) {
                set3.add(aSN1Sequence);
            }
            this.a = set3;
        } else if (tagNo == 6) {
            Set<String> set4 = this.d;
            String c4 = c(base);
            if (!set4.isEmpty()) {
                HashSet hashSet4 = new HashSet();
                for (String str3 : set4) {
                    if (str3.indexOf(64) != -1) {
                        String N22 = a.N2(str3, 64, 1);
                        if (c4.indexOf(64) != -1) {
                            if (str3.equalsIgnoreCase(c4)) {
                                hashSet4.add(str3);
                            } else {
                                hashSet4.add(str3);
                                hashSet4.add(c4);
                            }
                        } else if (c4.startsWith(".")) {
                            if (k(N22, c4)) {
                                hashSet4.add(c4);
                            } else {
                                hashSet4.add(str3);
                                hashSet4.add(c4);
                            }
                        } else if (N22.equalsIgnoreCase(c4)) {
                            hashSet4.add(c4);
                        } else {
                            hashSet4.add(str3);
                            hashSet4.add(c4);
                        }
                    } else if (str3.startsWith(".")) {
                        if (c4.indexOf(64) != -1) {
                            if (k(c4.substring(str3.indexOf(64) + 1), str3)) {
                                hashSet4.add(str3);
                            } else {
                                hashSet4.add(str3);
                                hashSet4.add(c4);
                            }
                        } else if (c4.startsWith(".")) {
                            if (k(str3, c4) || str3.equalsIgnoreCase(c4)) {
                                hashSet4.add(c4);
                            } else if (k(c4, str3)) {
                                hashSet4.add(str3);
                            } else {
                                hashSet4.add(str3);
                                hashSet4.add(c4);
                            }
                        } else if (k(c4, str3)) {
                            hashSet4.add(str3);
                        } else {
                            hashSet4.add(str3);
                            hashSet4.add(c4);
                        }
                    } else if (c4.indexOf(64) != -1) {
                        if (c4.substring(str3.indexOf(64) + 1).equalsIgnoreCase(str3)) {
                            hashSet4.add(str3);
                        } else {
                            hashSet4.add(str3);
                            hashSet4.add(c4);
                        }
                    } else if (c4.startsWith(".")) {
                        if (k(str3, c4)) {
                            hashSet4.add(c4);
                        } else {
                            hashSet4.add(str3);
                            hashSet4.add(c4);
                        }
                    } else if (str3.equalsIgnoreCase(c4)) {
                        hashSet4.add(str3);
                    } else {
                        hashSet4.add(str3);
                        hashSet4.add(c4);
                    }
                }
                set4 = hashSet4;
            } else if (c4 != null) {
                set4.add(c4);
            }
            this.d = set4;
        } else if (tagNo == 7) {
            Set<byte[]> set5 = this.e;
            byte[] octets = ASN1OctetString.getInstance(base.getName()).getOctets();
            if (!set5.isEmpty()) {
                HashSet hashSet5 = new HashSet();
                for (byte[] bArr : set5) {
                    HashSet hashSet6 = new HashSet();
                    if (Arrays.areEqual(bArr, octets)) {
                        hashSet6.add(bArr);
                    } else {
                        hashSet6.add(bArr);
                        hashSet6.add(octets);
                    }
                    hashSet5.addAll(hashSet6);
                }
                set5 = hashSet5;
            } else if (octets != null) {
                set5.add(octets);
            }
            this.e = set5;
        }
    }

    public final boolean b(String str, String str2) {
        String N2 = a.N2(str, 64, 1);
        if (str2.indexOf(64) != -1) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        } else if (str2.charAt(0) != '.') {
            if (N2.equalsIgnoreCase(str2)) {
                return true;
            }
        } else if (k(N2, str2)) {
            return true;
        }
        return false;
    }

    public final String c(GeneralName generalName) {
        return DERIA5String.getInstance(generalName.getName()).getString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d3  */
    @Override // org.spongycastle.asn1.x509.NameConstraintValidator
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkExcluded(org.spongycastle.asn1.x509.GeneralName r4) throws org.spongycastle.asn1.x509.NameConstraintValidatorException {
        /*
        // Method dump skipped, instructions count: 283
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x509.PKIXNameConstraintValidator.checkExcluded(org.spongycastle.asn1.x509.GeneralName):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f1  */
    @Override // org.spongycastle.asn1.x509.NameConstraintValidator
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkPermitted(org.spongycastle.asn1.x509.GeneralName r5) throws org.spongycastle.asn1.x509.NameConstraintValidatorException {
        /*
        // Method dump skipped, instructions count: 334
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x509.PKIXNameConstraintValidator.checkPermitted(org.spongycastle.asn1.x509.GeneralName):void");
    }

    public final int d(Collection collection) {
        int i2;
        int i3 = 0;
        if (collection == null) {
            return 0;
        }
        for (Object obj : collection) {
            if (obj instanceof byte[]) {
                i2 = Arrays.hashCode((byte[]) obj);
            } else {
                i2 = obj.hashCode();
            }
            i3 += i2;
        }
        return i3;
    }

    public final boolean e(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length != bArr2.length / 2) {
            return false;
        }
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr2, length, bArr3, 0, length);
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr4[i2] = (byte) (bArr2[i2] & bArr3[i2]);
            bArr5[i2] = (byte) (bArr[i2] & bArr3[i2]);
        }
        return Arrays.areEqual(bArr4, bArr5);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PKIXNameConstraintValidator)) {
            return false;
        }
        PKIXNameConstraintValidator pKIXNameConstraintValidator = (PKIXNameConstraintValidator) obj;
        if (!a(pKIXNameConstraintValidator.a, this.a) || !a(pKIXNameConstraintValidator.b, this.b) || !a(pKIXNameConstraintValidator.c, this.c) || !a(pKIXNameConstraintValidator.e, this.e) || !a(pKIXNameConstraintValidator.d, this.d) || !a(pKIXNameConstraintValidator.f, this.f) || !a(pKIXNameConstraintValidator.g, this.g) || !a(pKIXNameConstraintValidator.h, this.h) || !a(pKIXNameConstraintValidator.j, this.j) || !a(pKIXNameConstraintValidator.i, this.i)) {
            return false;
        }
        return true;
    }

    public final boolean f(String str, String str2) {
        String N2 = a.N2(str, 58, 1);
        if (N2.indexOf("//") != -1) {
            N2 = N2.substring(N2.indexOf("//") + 2);
        }
        if (N2.lastIndexOf(58) != -1) {
            N2 = N2.substring(0, N2.lastIndexOf(58));
        }
        String N22 = a.N2(a.N2(N2, 58, 1), 64, 1);
        if (N22.indexOf(47) != -1) {
            N22 = N22.substring(0, N22.indexOf(47));
        }
        if (!str2.startsWith(".")) {
            if (N22.equalsIgnoreCase(str2)) {
                return true;
            }
        } else if (k(N22, str2)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return d(this.i) + d(this.j) + d(this.h) + d(this.g) + d(this.f) + d(this.d) + d(this.e) + d(this.c) + d(this.b) + d(this.a);
    }

    public final String i(Set set) {
        Iterator it = set.iterator();
        String str = "[";
        while (it.hasNext()) {
            StringBuilder L = a.L(str);
            byte[] bArr = (byte[]) it.next();
            String str2 = "";
            for (int i2 = 0; i2 < bArr.length / 2; i2++) {
                StringBuilder L2 = a.L(str2);
                L2.append(Integer.toString(bArr[i2] & 255));
                L2.append(".");
                str2 = L2.toString();
            }
            String c3 = a.c3(a.O2(str2, -1, 0), "/");
            for (int length = bArr.length / 2; length < bArr.length; length++) {
                StringBuilder L3 = a.L(c3);
                L3.append(Integer.toString(bArr[length] & 255));
                L3.append(".");
                c3 = L3.toString();
            }
            L.append(c3.substring(0, c3.length() - 1));
            L.append(",");
            str = L.toString();
        }
        if (str.length() > 1) {
            str = str.substring(0, str.length() - 1);
        }
        return a.c3(str, "]");
    }

    @Override // org.spongycastle.asn1.x509.NameConstraintValidator
    public void intersectEmptyPermittedSubtree(int i2) {
        if (i2 == 1) {
            this.h = new HashSet();
        } else if (i2 == 2) {
            this.g = new HashSet();
        } else if (i2 == 4) {
            this.f = new HashSet();
        } else if (i2 == 6) {
            this.i = new HashSet();
        } else if (i2 == 7) {
            this.j = new HashSet();
        }
    }

    @Override // org.spongycastle.asn1.x509.NameConstraintValidator
    public void intersectPermittedSubtree(GeneralSubtree generalSubtree) {
        intersectPermittedSubtree(new GeneralSubtree[]{generalSubtree});
    }

    public final boolean k(String str, String str2) {
        if (str2.startsWith(".")) {
            str2 = str2.substring(1);
        }
        String[] split = Strings.split(str2, FormatterType.defaultDecimalSeparator);
        String[] split2 = Strings.split(str, FormatterType.defaultDecimalSeparator);
        if (split2.length <= split.length) {
            return false;
        }
        int length = split2.length - split.length;
        for (int i2 = -1; i2 < split.length; i2++) {
            if (i2 == -1) {
                if (split2[i2 + length].equals("")) {
                    return false;
                }
            } else if (!split[i2].equalsIgnoreCase(split2[i2 + length])) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String str = "permitted:\n";
        if (this.f != null) {
            StringBuilder L = a.L(a.c3(str, "DN:\n"));
            L.append(this.f.toString());
            L.append("\n");
            str = L.toString();
        }
        if (this.g != null) {
            StringBuilder L2 = a.L(a.c3(str, "DNS:\n"));
            L2.append(this.g.toString());
            L2.append("\n");
            str = L2.toString();
        }
        if (this.h != null) {
            StringBuilder L3 = a.L(a.c3(str, "Email:\n"));
            L3.append(this.h.toString());
            L3.append("\n");
            str = L3.toString();
        }
        if (this.i != null) {
            StringBuilder L4 = a.L(a.c3(str, "URI:\n"));
            L4.append(this.i.toString());
            L4.append("\n");
            str = L4.toString();
        }
        if (this.j != null) {
            StringBuilder L5 = a.L(a.c3(str, "IP:\n"));
            L5.append(i(this.j));
            L5.append("\n");
            str = L5.toString();
        }
        String c3 = a.c3(str, "excluded:\n");
        if (!this.a.isEmpty()) {
            StringBuilder L6 = a.L(a.c3(c3, "DN:\n"));
            L6.append(this.a.toString());
            L6.append("\n");
            c3 = L6.toString();
        }
        if (!this.b.isEmpty()) {
            StringBuilder L7 = a.L(a.c3(c3, "DNS:\n"));
            L7.append(this.b.toString());
            L7.append("\n");
            c3 = L7.toString();
        }
        if (!this.c.isEmpty()) {
            StringBuilder L8 = a.L(a.c3(c3, "Email:\n"));
            L8.append(this.c.toString());
            L8.append("\n");
            c3 = L8.toString();
        }
        if (!this.d.isEmpty()) {
            StringBuilder L9 = a.L(a.c3(c3, "URI:\n"));
            L9.append(this.d.toString());
            L9.append("\n");
            c3 = L9.toString();
        }
        if (this.e.isEmpty()) {
            return c3;
        }
        StringBuilder L10 = a.L(a.c3(c3, "IP:\n"));
        L10.append(i(this.e));
        L10.append("\n");
        return L10.toString();
    }

    @Override // org.spongycastle.asn1.x509.NameConstraintValidator
    public void intersectPermittedSubtree(GeneralSubtree[] generalSubtreeArr) {
        Iterator it;
        Iterator it2;
        Iterator it3;
        Set set;
        char c2;
        HashMap hashMap = new HashMap();
        int i2 = 0;
        for (int i3 = 0; i3 != generalSubtreeArr.length; i3++) {
            GeneralSubtree generalSubtree = generalSubtreeArr[i3];
            Integer valueOf = Integers.valueOf(generalSubtree.getBase().getTagNo());
            if (hashMap.get(valueOf) == null) {
                hashMap.put(valueOf, new HashSet());
            }
            ((Set) hashMap.get(valueOf)).add(generalSubtree);
        }
        Iterator it4 = hashMap.entrySet().iterator();
        while (it4.hasNext()) {
            Map.Entry entry = (Map.Entry) it4.next();
            int intValue = ((Integer) entry.getKey()).intValue();
            char c3 = 1;
            if (intValue != 1) {
                int i4 = 2;
                if (intValue != 2) {
                    int i5 = 4;
                    if (intValue == 4) {
                        it = it4;
                        Set<ASN1Sequence> set2 = this.f;
                        HashSet hashSet = new HashSet();
                        for (GeneralSubtree generalSubtree2 : (Set) entry.getValue()) {
                            ASN1Sequence instance = ASN1Sequence.getInstance(generalSubtree2.getBase().getName().toASN1Primitive());
                            if (set2 != null) {
                                for (ASN1Sequence aSN1Sequence : set2) {
                                    if (j(instance, aSN1Sequence)) {
                                        hashSet.add(instance);
                                    } else if (j(aSN1Sequence, instance)) {
                                        hashSet.add(aSN1Sequence);
                                    }
                                }
                            } else if (instance != null) {
                                hashSet.add(instance);
                            }
                        }
                        this.f = hashSet;
                    } else if (intValue == 6) {
                        it = it4;
                        Set<String> set3 = this.i;
                        HashSet hashSet2 = new HashSet();
                        for (GeneralSubtree generalSubtree3 : (Set) entry.getValue()) {
                            String c4 = c(generalSubtree3.getBase());
                            if (set3 != null) {
                                for (String str : set3) {
                                    if (str.indexOf(64) != -1) {
                                        String N2 = a.N2(str, 64, 1);
                                        if (c4.indexOf(64) != -1) {
                                            if (str.equalsIgnoreCase(c4)) {
                                                hashSet2.add(str);
                                            }
                                        } else if (c4.startsWith(".")) {
                                            if (k(N2, c4)) {
                                                hashSet2.add(str);
                                            }
                                        } else if (N2.equalsIgnoreCase(c4)) {
                                            hashSet2.add(str);
                                        }
                                    } else if (str.startsWith(".")) {
                                        if (c4.indexOf(64) != -1) {
                                            if (k(c4.substring(str.indexOf(64) + 1), str)) {
                                                hashSet2.add(c4);
                                            }
                                        } else if (c4.startsWith(".")) {
                                            if (k(str, c4) || str.equalsIgnoreCase(c4)) {
                                                hashSet2.add(str);
                                            } else if (k(c4, str)) {
                                                hashSet2.add(c4);
                                            }
                                        } else if (k(c4, str)) {
                                            hashSet2.add(c4);
                                        }
                                    } else if (c4.indexOf(64) != -1) {
                                        if (c4.substring(c4.indexOf(64) + 1).equalsIgnoreCase(str)) {
                                            hashSet2.add(c4);
                                        }
                                    } else if (c4.startsWith(".")) {
                                        if (k(str, c4)) {
                                            hashSet2.add(str);
                                        }
                                    } else if (str.equalsIgnoreCase(c4)) {
                                        hashSet2.add(str);
                                    }
                                }
                            } else if (c4 != null) {
                                hashSet2.add(c4);
                            }
                        }
                        this.i = hashSet2;
                    } else if (intValue != 7) {
                        it = it4;
                    } else {
                        Set<byte[]> set4 = this.j;
                        HashSet hashSet3 = new HashSet();
                        Iterator it5 = ((Set) entry.getValue()).iterator();
                        while (it5.hasNext()) {
                            byte[] octets = ASN1OctetString.getInstance(((GeneralSubtree) it5.next()).getBase().getName()).getOctets();
                            if (set4 != null) {
                                for (byte[] bArr : set4) {
                                    if (bArr.length != octets.length) {
                                        set = Collections.EMPTY_SET;
                                        it2 = it4;
                                        it3 = it5;
                                    } else {
                                        int length = bArr.length / i4;
                                        byte[] bArr2 = new byte[length];
                                        byte[] bArr3 = new byte[length];
                                        System.arraycopy(bArr, i2, bArr2, i2, length);
                                        System.arraycopy(bArr, length, bArr3, i2, length);
                                        byte[] bArr4 = new byte[length];
                                        byte[] bArr5 = new byte[length];
                                        System.arraycopy(octets, i2, bArr4, i2, length);
                                        System.arraycopy(octets, length, bArr5, i2, length);
                                        byte[][] bArr6 = new byte[i5][];
                                        bArr6[i2] = bArr2;
                                        bArr6[c3] = bArr3;
                                        bArr6[i4] = bArr4;
                                        bArr6[3] = bArr5;
                                        byte[] bArr7 = bArr6[i2];
                                        byte[] bArr8 = bArr6[c3];
                                        byte[] bArr9 = bArr6[i4];
                                        byte[] bArr10 = bArr6[3];
                                        int length2 = bArr7.length;
                                        byte[] bArr11 = new byte[length2];
                                        byte[] bArr12 = new byte[length2];
                                        byte[] bArr13 = new byte[length2];
                                        byte[] bArr14 = new byte[length2];
                                        it2 = it4;
                                        int i6 = 0;
                                        while (i6 < length2) {
                                            bArr11[i6] = (byte) (bArr7[i6] & bArr8[i6]);
                                            bArr12[i6] = (byte) ((bArr7[i6] & bArr8[i6]) | (~bArr8[i6]));
                                            bArr13[i6] = (byte) (bArr9[i6] & bArr10[i6]);
                                            bArr14[i6] = (byte) ((bArr9[i6] & bArr10[i6]) | (~bArr10[i6]));
                                            i6++;
                                            bArr7 = bArr7;
                                            it5 = it5;
                                        }
                                        it3 = it5;
                                        byte[][] bArr15 = {bArr11, bArr12, bArr13, bArr14};
                                        byte[] bArr16 = bArr15[1];
                                        byte[] bArr17 = bArr15[3];
                                        int i7 = 0;
                                        while (true) {
                                            if (i7 >= bArr16.length) {
                                                bArr16 = bArr17;
                                                break;
                                            } else if ((bArr16[i7] & 65535) < (65535 & bArr17[i7])) {
                                                break;
                                            } else {
                                                i7++;
                                            }
                                        }
                                        byte[] g2 = g(bArr15[0], bArr15[2]);
                                        if (Arrays.areEqual(g2, bArr16)) {
                                            c2 = 0;
                                        } else {
                                            c2 = Arrays.areEqual(g(g2, bArr16), g2) ? (char) 1 : 65535;
                                        }
                                        if (c2 == 1) {
                                            set = Collections.EMPTY_SET;
                                        } else {
                                            byte[] h2 = h(bArr15[0], bArr15[2]);
                                            byte[] h3 = h(bArr8, bArr10);
                                            int length3 = h2.length;
                                            byte[] bArr18 = new byte[(length3 * 2)];
                                            System.arraycopy(h2, 0, bArr18, 0, length3);
                                            System.arraycopy(h3, 0, bArr18, length3, length3);
                                            set = Collections.singleton(bArr18);
                                        }
                                        i2 = 0;
                                    }
                                    hashSet3.addAll(set);
                                    c3 = 1;
                                    i4 = 2;
                                    i5 = 4;
                                    it4 = it2;
                                    it5 = it3;
                                }
                            } else if (octets != null) {
                                hashSet3.add(octets);
                            }
                        }
                        it = it4;
                        this.j = hashSet3;
                    }
                } else {
                    it = it4;
                    Set<String> set5 = this.g;
                    HashSet hashSet4 = new HashSet();
                    for (GeneralSubtree generalSubtree4 : (Set) entry.getValue()) {
                        String c5 = c(generalSubtree4.getBase());
                        if (set5 != null) {
                            for (String str2 : set5) {
                                if (k(str2, c5)) {
                                    hashSet4.add(str2);
                                } else if (k(c5, str2)) {
                                    hashSet4.add(c5);
                                }
                            }
                        } else if (c5 != null) {
                            hashSet4.add(c5);
                        }
                    }
                    this.g = hashSet4;
                }
            } else {
                it = it4;
                Set<String> set6 = this.h;
                HashSet hashSet5 = new HashSet();
                for (GeneralSubtree generalSubtree5 : (Set) entry.getValue()) {
                    String c6 = c(generalSubtree5.getBase());
                    if (set6 != null) {
                        for (String str3 : set6) {
                            if (c6.indexOf(64) != -1) {
                                String N22 = a.N2(c6, 64, 1);
                                if (str3.indexOf(64) != -1) {
                                    if (c6.equalsIgnoreCase(str3)) {
                                        hashSet5.add(c6);
                                    }
                                } else if (str3.startsWith(".")) {
                                    if (k(N22, str3)) {
                                        hashSet5.add(c6);
                                    }
                                } else if (N22.equalsIgnoreCase(str3)) {
                                    hashSet5.add(c6);
                                }
                            } else if (c6.startsWith(".")) {
                                if (str3.indexOf(64) != -1) {
                                    if (k(str3.substring(c6.indexOf(64) + 1), c6)) {
                                        hashSet5.add(str3);
                                    }
                                } else if (str3.startsWith(".")) {
                                    if (k(c6, str3) || c6.equalsIgnoreCase(str3)) {
                                        hashSet5.add(c6);
                                    } else if (k(str3, c6)) {
                                        hashSet5.add(str3);
                                    }
                                } else if (k(str3, c6)) {
                                    hashSet5.add(str3);
                                }
                            } else if (str3.indexOf(64) != -1) {
                                if (str3.substring(str3.indexOf(64) + 1).equalsIgnoreCase(c6)) {
                                    hashSet5.add(str3);
                                }
                            } else if (str3.startsWith(".")) {
                                if (k(c6, str3)) {
                                    hashSet5.add(c6);
                                }
                            } else if (c6.equalsIgnoreCase(str3)) {
                                hashSet5.add(c6);
                            }
                        }
                    } else if (c6 != null) {
                        hashSet5.add(c6);
                    }
                }
                this.h = hashSet5;
            }
            it4 = it;
        }
    }
}
