package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
public final class zzeie {
    public static String zza(zzehz zzehz, String str) {
        StringBuilder Q = a.Q("# ", str);
        zza(zzehz, Q, 0);
        return Q.toString();
    }

    private static final String zzhx(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01cd, code lost:
        if (((java.lang.Boolean) r6).booleanValue() == false) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01db, code lost:
        if (((java.lang.Integer) r6).intValue() == 0) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01ec, code lost:
        if (((java.lang.Float) r6).floatValue() == 0.0f) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01fe, code lost:
        if (((java.lang.Double) r6).doubleValue() == 0.0d) goto L_0x0232;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0238  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.ads.zzehz r13, java.lang.StringBuilder r14, int r15) {
        /*
        // Method dump skipped, instructions count: 641
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeie.zza(com.google.android.gms.internal.ads.zzehz, java.lang.StringBuilder, int):void");
    }

    public static final void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                zza(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                zza(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzejj.zzam(zzeff.zzhu((String) obj)));
                sb.append(Typography.quote);
            } else if (obj instanceof zzeff) {
                sb.append(": \"");
                sb.append(zzejj.zzam((zzeff) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof zzegp) {
                sb.append(" {");
                zza((zzegp) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i4 = i + 2;
                zza(sb, i4, "key", entry2.getKey());
                zza(sb, i4, "value", entry2.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }
}
