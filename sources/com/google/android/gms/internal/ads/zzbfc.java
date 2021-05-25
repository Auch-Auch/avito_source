package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
public final class zzbfc extends zzbev {
    private static final Set<String> zzeld = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzele = new DecimalFormat("#,###");
    private File zzcz;
    private boolean zzelf;

    public zzbfc(zzbde zzbde) {
        super(zzbde);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzbbd.zzfe("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(cacheDir, "admobVideoStreams");
        this.zzcz = file;
        if (!file.isDirectory() && !this.zzcz.mkdirs()) {
            String valueOf = String.valueOf(this.zzcz.getAbsolutePath());
            zzbbd.zzfe(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.zzcz = null;
        } else if (!this.zzcz.setReadable(true, false) || !this.zzcz.setExecutable(true, false)) {
            String valueOf2 = String.valueOf(this.zzcz.getAbsolutePath());
            zzbbd.zzfe(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.zzcz = null;
        }
    }

    private final File zzd(File file) {
        return new File(this.zzcz, String.valueOf(file.getName()).concat(".done"));
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void abort() {
        this.zzelf = true;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:273:0x03ee */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:197:0x04c1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:161:0x03ad */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4, types: [int] */
    /* JADX WARN: Type inference failed for: r24v9 */
    /* JADX WARN: Type inference failed for: r24v10 */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01e6, code lost:
        if (r1 < 400) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01e8, code lost:
        r15 = "badUrl";
        r2 = java.lang.String.valueOf(java.lang.Integer.toString(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01f8, code lost:
        if (r2.length() == 0) goto L_0x0200;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01fa, code lost:
        r2 = "HTTP request failed. Code: ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0200, code lost:
        r2 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 32);
        r4.append("HTTP status code ");
        r4.append(r1);
        r4.append(" at ");
        r4.append(r31);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x022d, code lost:
        throw new java.io.IOException(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x022e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0232, code lost:
        r7 = r5.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0236, code lost:
        if (r7 >= 0) goto L_0x0261;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0238, code lost:
        r1 = java.lang.String.valueOf(r31);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0242, code lost:
        if (r1.length() == 0) goto L_0x0249;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0244, code lost:
        r0 = "Stream cache aborted, missing content-length header at ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0249, code lost:
        r0 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x024f, code lost:
        com.google.android.gms.internal.ads.zzbbd.zzfe(r0);
        zza(r31, r12.getAbsolutePath(), "contentLengthMissing", null);
        com.google.android.gms.internal.ads.zzbfc.zzeld.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0260, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0261, code lost:
        r1 = com.google.android.gms.internal.ads.zzbfc.zzele.format((long) r7);
        r3 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzwe.zzpu().zzd(com.google.android.gms.internal.ads.zzaat.zzclx)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0278, code lost:
        if (r7 <= r3) goto L_0x02cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x027a, code lost:
        r2 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 33) + java.lang.String.valueOf(r31).length());
        r2.append("Content length ");
        r2.append(r1);
        r2.append(" exceeds limit at ");
        r2.append(r31);
        com.google.android.gms.internal.ads.zzbbd.zzfe(r2.toString());
        r1 = java.lang.String.valueOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02b3, code lost:
        if (r1.length() == 0) goto L_0x02ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02b5, code lost:
        r0 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02ba, code lost:
        r0 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02c0, code lost:
        zza(r31, r12.getAbsolutePath(), "sizeExceeded", r0);
        com.google.android.gms.internal.ads.zzbfc.zzeld.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02ce, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02cf, code lost:
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 20) + java.lang.String.valueOf(r31).length());
        r4.append("Caching ");
        r4.append(r1);
        r4.append(" bytes from ");
        r4.append(r31);
        com.google.android.gms.internal.ads.zzbbd.zzef(r4.toString());
        r5 = java.nio.channels.Channels.newChannel(r5.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:?, code lost:
        r2 = r4.getChannel();
        r1 = java.nio.ByteBuffer.allocate(1048576);
        r16 = com.google.android.gms.ads.internal.zzp.zzkw();
        r17 = r16.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0328, code lost:
        r10 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
        r6 = new com.google.android.gms.internal.ads.zzbaj(((java.lang.Long) com.google.android.gms.internal.ads.zzwe.zzpu().zzd(com.google.android.gms.internal.ads.zzaat.zzcma)).longValue());
        r13 = ((java.lang.Long) com.google.android.gms.internal.ads.zzwe.zzpu().zzd(com.google.android.gms.internal.ads.zzaat.zzclz)).longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0342, code lost:
        r20 = r5.read(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0346, code lost:
        if (r20 < 0) goto L_0x045e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0348, code lost:
        r11 = r11 + r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x034a, code lost:
        if (r11 <= r3) goto L_0x037f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x034c, code lost:
        r15 = "sizeExceeded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x035c, code lost:
        if (r1.length() == 0) goto L_0x0364;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x035e, code lost:
        r1 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0364, code lost:
        r1 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0370, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0371, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0374, code lost:
        r2 = r1;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0377, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x037a, code lost:
        r1 = r10;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x037c, code lost:
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:?, code lost:
        r1.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0386, code lost:
        if (r2.write(r1) > 0) goto L_0x0382;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0388, code lost:
        r1.clear();
        r24 = ((r16.currentTimeMillis() - r17) > (1000 * r13) ? 1 : ((r16.currentTimeMillis() - r17) == (1000 * r13) ? 0 : -1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0397, code lost:
        if (r24 > 0) goto L_0x0412;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x039d, code lost:
        if (r30.zzelf != false) goto L_0x0402;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03a3, code lost:
        if (r6.tryAcquire() == false) goto L_0x03dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03ab, code lost:
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03af, code lost:
        r24 = r10;
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:?, code lost:
        com.google.android.gms.internal.ads.zzbat.zzaah.post(new com.google.android.gms.internal.ads.zzbeu(r30, r31, r12.getAbsolutePath(), r11, r7, false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03d4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03d6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03d7, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03dc, code lost:
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03ee, code lost:
        r6 = r19;
        r1 = r1;
        r5 = r21;
        r15 = r22;
        r10 = r24;
        r2 = r25;
        r3 = r26;
        r4 = r27;
        r7 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0402, code lost:
        r27 = r4;
        r24 = r10;
        r15 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0411, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0412, code lost:
        r15 = "downloadTimeout";
        r0 = java.lang.Long.toString(r13);
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);
        r2.append("Timeout exceeded. Limit: ");
        r2.append(r0);
        r2.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0445, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0446, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0449, code lost:
        r2 = r2.toString();
        r1 = r10;
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0450, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0454, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0457, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x045e, code lost:
        r27 = r4;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:?, code lost:
        r27.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x046d, code lost:
        if (com.google.android.gms.internal.ads.zzbbd.isLoggable(3) == false) goto L_0x04ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x046f, code lost:
        r1 = com.google.android.gms.internal.ads.zzbfc.zzele.format((long) r11);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r31).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r31);
        com.google.android.gms.internal.ads.zzbbd.zzef(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x04a6, code lost:
        r0 = e;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x04a8, code lost:
        r0 = e;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x04a9, code lost:
        r15 = r22;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x04ab, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x04ae, code lost:
        r12.setReadable(true, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x04b7, code lost:
        if (r0.isFile() == false) goto L_0x04c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x04b9, code lost:
        r0.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:?, code lost:
        r0.createNewFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x04d8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x04db, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x04e0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x04e3, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x04e7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x04ea, code lost:
        r27 = r4;
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x051b, code lost:
        com.google.android.gms.ads.internal.zzp.zzkt().zza(r0, "VideoStreamFullFileCache.preload");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x052d, code lost:
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 26);
        r3.append("Preload aborted for URL \"");
        r3.append(r31);
        r3.append("\"");
        com.google.android.gms.internal.ads.zzbbd.zzfd(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x0551, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 25);
        r4.append("Preload failed for URL \"");
        r4.append(r31);
        r4.append("\"");
        com.google.android.gms.internal.ads.zzbbd.zzd(r4.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0590, code lost:
        r0 = "Could not delete partial cache file at ".concat(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0595, code lost:
        r0 = new java.lang.String("Could not delete partial cache file at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01e0, code lost:
        r1 = r5.getResponseCode();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x04a6 A[ExcHandler: RuntimeException (e java.lang.RuntimeException), PHI: r22 r24 r27 
      PHI: (r22v7 java.lang.String) = (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v15 java.lang.String), (r22v15 java.lang.String) binds: [B:197:0x04c1, B:198:?, B:161:0x03ad, B:164:0x03cd] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r24v3 ??) = (r24v0 ??), (r24v0 ??), (r24v4 ??), (r24v10 ??) binds: [B:197:0x04c1, B:198:?, B:161:0x03ad, B:164:0x03cd] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r27v9 java.io.FileOutputStream) = (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v13 java.io.FileOutputStream), (r27v17 java.io.FileOutputStream) binds: [B:197:0x04c1, B:198:?, B:161:0x03ad, B:164:0x03cd] A[DONT_GENERATE, DONT_INLINE], Splitter:B:164:0x03cd] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x051b  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x052d  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0551  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0590  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0595  */
    @Override // com.google.android.gms.internal.ads.zzbev
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzfn(java.lang.String r31) {
        /*
        // Method dump skipped, instructions count: 1455
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfc.zzfn(java.lang.String):boolean");
    }
}
