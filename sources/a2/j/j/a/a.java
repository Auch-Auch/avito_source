package a2.j.j.a;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
@GwtCompatible
public final class a {
    public static final Joiner a = Joiner.on("");

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008a A[EDGE_INSN: B:49:0x008a->B:37:0x008a ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.util.List<java.lang.CharSequence> r11, java.lang.CharSequence r12, int r13, com.google.common.collect.ImmutableMap.Builder<java.lang.String, com.google.thirdparty.publicsuffix.PublicSuffixType> r14) {
        /*
            int r0 = r12.length()
            r1 = 0
            r2 = 0
            r3 = r13
        L_0x0007:
            r4 = 58
            r5 = 33
            r6 = 44
            r7 = 63
            if (r3 >= r0) goto L_0x0025
            char r2 = r12.charAt(r3)
            r8 = 38
            if (r2 == r8) goto L_0x0025
            if (r2 == r7) goto L_0x0025
            if (r2 == r5) goto L_0x0025
            if (r2 == r4) goto L_0x0025
            if (r2 != r6) goto L_0x0022
            goto L_0x0025
        L_0x0022:
            int r3 = r3 + 1
            goto L_0x0007
        L_0x0025:
            java.lang.CharSequence r8 = r12.subSequence(r13, r3)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r8)
            java.lang.StringBuilder r8 = r9.reverse()
            r11.add(r1, r8)
            if (r2 == r5) goto L_0x003d
            if (r2 == r7) goto L_0x003d
            if (r2 == r4) goto L_0x003d
            if (r2 != r6) goto L_0x006f
        L_0x003d:
            com.google.common.base.Joiner r4 = a2.j.j.a.a.a
            java.lang.String r4 = r4.join(r11)
            int r5 = r4.length()
            if (r5 <= 0) goto L_0x006f
            com.google.thirdparty.publicsuffix.PublicSuffixType[] r5 = com.google.thirdparty.publicsuffix.PublicSuffixType.values()
            r8 = 0
        L_0x004e:
            r9 = 2
            if (r8 >= r9) goto L_0x0063
            r9 = r5[r8]
            char r10 = r9.a
            if (r10 == r2) goto L_0x005f
            char r10 = r9.b
            if (r10 != r2) goto L_0x005c
            goto L_0x005f
        L_0x005c:
            int r8 = r8 + 1
            goto L_0x004e
        L_0x005f:
            r14.put(r4, r9)
            goto L_0x006f
        L_0x0063:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "No enum corresponding to given code: "
            java.lang.String r12 = a2.b.a.a.a.K2(r12, r2)
            r11.<init>(r12)
            throw r11
        L_0x006f:
            int r3 = r3 + 1
            if (r2 == r7) goto L_0x008a
            if (r2 == r6) goto L_0x008a
        L_0x0075:
            if (r3 >= r0) goto L_0x008a
            int r2 = a(r11, r12, r3, r14)
            int r3 = r3 + r2
            char r2 = r12.charAt(r3)
            if (r2 == r7) goto L_0x0088
            char r2 = r12.charAt(r3)
            if (r2 != r6) goto L_0x0075
        L_0x0088:
            int r3 = r3 + 1
        L_0x008a:
            r11.remove(r1)
            int r3 = r3 - r13
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.j.a.a.a(java.util.List, java.lang.CharSequence, int, com.google.common.collect.ImmutableMap$Builder):int");
    }

    public static ImmutableMap<String, PublicSuffixType> b(CharSequence charSequence) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            i += a(Lists.newLinkedList(), charSequence, i, builder);
        }
        return builder.build();
    }
}
