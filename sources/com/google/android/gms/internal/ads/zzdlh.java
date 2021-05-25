package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.json.JSONException;
public final class zzdlh {
    public final List<zzdkx> zzhbm;
    public final zzdkz zzhbn;
    public final List<zzdlg> zzhbo;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x0011 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:0x0029 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0011 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x0029 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<com.google.android.gms.internal.ads.zzdkx>] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzdlh(android.util.JsonReader r9) throws java.lang.IllegalStateException, java.io.IOException, org.json.JSONException, java.lang.NumberFormatException, java.lang.AssertionError {
        /*
            r8 = this;
            r8.<init>()
            java.util.List r0 = java.util.Collections.emptyList()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r9.beginObject()
            r2 = 0
            r3 = r2
        L_0x0011:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L_0x00c0
            java.lang.String r4 = r9.nextName()
            java.lang.String r5 = "responses"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x006f
            r9.beginArray()
            r9.beginObject()
        L_0x0029:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L_0x0068
            java.lang.String r4 = r9.nextName()
            java.lang.String r5 = "ad_configs"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x0056
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r9.beginArray()
        L_0x0043:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L_0x0052
            com.google.android.gms.internal.ads.zzdkx r4 = new com.google.android.gms.internal.ads.zzdkx
            r4.<init>(r9)
            r0.add(r4)
            goto L_0x0043
        L_0x0052:
            r9.endArray()
            goto L_0x0029
        L_0x0056:
            java.lang.String r5 = "common"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0064
            com.google.android.gms.internal.ads.zzdkz r3 = new com.google.android.gms.internal.ads.zzdkz
            r3.<init>(r9)
            goto L_0x0029
        L_0x0064:
            r9.skipValue()
            goto L_0x0029
        L_0x0068:
            r9.endObject()
            r9.endArray()
            goto L_0x0011
        L_0x006f:
            java.lang.String r5 = "actions"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0011
            r9.beginArray()
        L_0x007a:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L_0x00bb
            r9.beginObject()
            r4 = r2
            r5 = r4
        L_0x0085:
            boolean r6 = r9.hasNext()
            if (r6 == 0) goto L_0x00ad
            java.lang.String r6 = r9.nextName()
            java.lang.String r7 = "name"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x009c
            java.lang.String r4 = r9.nextString()
            goto L_0x0085
        L_0x009c:
            java.lang.String r7 = "info"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x00a9
            java.util.Map r5 = com.google.android.gms.internal.ads.zzbab.zzb(r9)
            goto L_0x0085
        L_0x00a9:
            r9.skipValue()
            goto L_0x0085
        L_0x00ad:
            if (r4 == 0) goto L_0x00b7
            com.google.android.gms.internal.ads.zzdlg r6 = new com.google.android.gms.internal.ads.zzdlg
            r6.<init>(r4, r5)
            r1.add(r6)
        L_0x00b7:
            r9.endObject()
            goto L_0x007a
        L_0x00bb:
            r9.endArray()
            goto L_0x0011
        L_0x00c0:
            r8.zzhbo = r1
            r8.zzhbm = r0
            if (r3 == 0) goto L_0x00c7
            goto L_0x00d8
        L_0x00c7:
            com.google.android.gms.internal.ads.zzdkz r3 = new com.google.android.gms.internal.ads.zzdkz
            android.util.JsonReader r9 = new android.util.JsonReader
            java.io.StringReader r0 = new java.io.StringReader
            java.lang.String r1 = "{}"
            r0.<init>(r1)
            r9.<init>(r0)
            r3.<init>(r9)
        L_0x00d8:
            r8.zzhbn = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlh.<init>(android.util.JsonReader):void");
    }

    public static zzdlh zza(Reader reader) throws zzdky {
        try {
            zzdlh zzdlh = new zzdlh(new JsonReader(reader));
            IOUtils.closeQuietly(reader);
            return zzdlh;
        } catch (IOException | AssertionError | IllegalStateException | NumberFormatException | JSONException e) {
            throw new zzdky("unable to parse ServerResponse", e);
        } catch (Throwable th) {
            IOUtils.closeQuietly(reader);
            throw th;
        }
    }
}
