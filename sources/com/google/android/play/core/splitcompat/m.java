package com.google.android.play.core.splitcompat;

import a2.j.b.e.a.h.f;
import a2.j.b.e.a.h.i;
import a2.j.b.e.a.h.n;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
public final class m {
    public static final /* synthetic */ int a = 0;
    public static final Pattern c = Pattern.compile("lib/([^/]+)/(.*\\.so)$");
    public final e b;

    public m(e eVar) throws IOException {
        this.b = eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e1 A[SYNTHETIC, Splitter:B:31:0x00e1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(a2.j.b.e.a.h.n r12, a2.j.b.e.a.h.h r13) throws java.io.IOException {
        /*
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x00dd }
            java.io.File r1 = r12.a()     // Catch:{ IOException -> 0x00dd }
            r0.<init>(r1)     // Catch:{ IOException -> 0x00dd }
            java.lang.String r12 = r12.b()     // Catch:{ IOException -> 0x00db }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ IOException -> 0x00db }
            r1.<init>()     // Catch:{ IOException -> 0x00db }
            java.util.Enumeration r2 = r0.entries()     // Catch:{ IOException -> 0x00db }
        L_0x0016:
            boolean r3 = r2.hasMoreElements()     // Catch:{ IOException -> 0x00db }
            r4 = 2
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L_0x0064
            java.lang.Object r3 = r2.nextElement()     // Catch:{ IOException -> 0x00db }
            java.util.zip.ZipEntry r3 = (java.util.zip.ZipEntry) r3     // Catch:{ IOException -> 0x00db }
            java.lang.String r7 = r3.getName()     // Catch:{ IOException -> 0x00db }
            java.util.regex.Pattern r8 = com.google.android.play.core.splitcompat.m.c     // Catch:{ IOException -> 0x00db }
            java.util.regex.Matcher r7 = r8.matcher(r7)     // Catch:{ IOException -> 0x00db }
            boolean r8 = r7.matches()     // Catch:{ IOException -> 0x00db }
            if (r8 == 0) goto L_0x0016
            java.lang.String r8 = r7.group(r5)     // Catch:{ IOException -> 0x00db }
            java.lang.String r7 = r7.group(r4)     // Catch:{ IOException -> 0x00db }
            r9 = 3
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x00db }
            r9[r6] = r12     // Catch:{ IOException -> 0x00db }
            r9[r5] = r7     // Catch:{ IOException -> 0x00db }
            r9[r4] = r8     // Catch:{ IOException -> 0x00db }
            java.lang.String r4 = "NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'"
            java.lang.String.format(r4, r9)     // Catch:{ IOException -> 0x00db }
            java.lang.Object r4 = r1.get(r8)     // Catch:{ IOException -> 0x00db }
            java.util.Set r4 = (java.util.Set) r4     // Catch:{ IOException -> 0x00db }
            if (r4 != 0) goto L_0x005b
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ IOException -> 0x00db }
            r4.<init>()     // Catch:{ IOException -> 0x00db }
            r1.put(r8, r4)     // Catch:{ IOException -> 0x00db }
        L_0x005b:
            com.google.android.play.core.splitcompat.l r5 = new com.google.android.play.core.splitcompat.l     // Catch:{ IOException -> 0x00db }
            r5.<init>(r3, r7)     // Catch:{ IOException -> 0x00db }
            r4.add(r5)     // Catch:{ IOException -> 0x00db }
            goto L_0x0016
        L_0x0064:
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ IOException -> 0x00db }
            r12.<init>()     // Catch:{ IOException -> 0x00db }
            java.lang.String[] r2 = android.os.Build.SUPPORTED_ABIS     // Catch:{ IOException -> 0x00db }
            int r3 = r2.length     // Catch:{ IOException -> 0x00db }
            r7 = 0
        L_0x006d:
            if (r7 < r3) goto L_0x007f
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ IOException -> 0x00db }
            java.util.Collection r12 = r12.values()     // Catch:{ IOException -> 0x00db }
            r1.<init>(r12)     // Catch:{ IOException -> 0x00db }
            r13.a(r0, r1)     // Catch:{ IOException -> 0x00db }
            r0.close()     // Catch:{ IOException -> 0x00db }
            return
        L_0x007f:
            r8 = r2[r7]     // Catch:{ IOException -> 0x00db }
            boolean r9 = r1.containsKey(r8)     // Catch:{ IOException -> 0x00db }
            if (r9 == 0) goto L_0x00cf
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x00db }
            r9[r6] = r8     // Catch:{ IOException -> 0x00db }
            java.lang.String r10 = "NativeLibraryExtractor: there are native libraries for supported ABI %s; will use this ABI"
            java.lang.String.format(r10, r9)     // Catch:{ IOException -> 0x00db }
            java.lang.Object r9 = r1.get(r8)     // Catch:{ IOException -> 0x00db }
            java.util.Set r9 = (java.util.Set) r9     // Catch:{ IOException -> 0x00db }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ IOException -> 0x00db }
        L_0x009a:
            boolean r10 = r9.hasNext()     // Catch:{ IOException -> 0x00db }
            if (r10 == 0) goto L_0x00d8
            java.lang.Object r10 = r9.next()     // Catch:{ IOException -> 0x00db }
            com.google.android.play.core.splitcompat.l r10 = (com.google.android.play.core.splitcompat.l) r10     // Catch:{ IOException -> 0x00db }
            java.lang.String r11 = r10.a     // Catch:{ IOException -> 0x00db }
            boolean r11 = r12.containsKey(r11)     // Catch:{ IOException -> 0x00db }
            if (r11 != 0) goto L_0x00c1
            java.lang.String r11 = r10.a     // Catch:{ IOException -> 0x00db }
            r12.put(r11, r10)     // Catch:{ IOException -> 0x00db }
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x00db }
            java.lang.String r10 = r10.a     // Catch:{ IOException -> 0x00db }
            r11[r6] = r10     // Catch:{ IOException -> 0x00db }
            r11[r5] = r8     // Catch:{ IOException -> 0x00db }
            java.lang.String r10 = "NativeLibraryExtractor: using library %s for ABI %s"
            java.lang.String.format(r10, r11)     // Catch:{ IOException -> 0x00db }
            goto L_0x009a
        L_0x00c1:
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x00db }
            java.lang.String r10 = r10.a     // Catch:{ IOException -> 0x00db }
            r11[r6] = r10     // Catch:{ IOException -> 0x00db }
            r11[r5] = r8     // Catch:{ IOException -> 0x00db }
            java.lang.String r10 = "NativeLibraryExtractor: skipping library %s for ABI %s; already present for a better ABI"
            java.lang.String.format(r10, r11)     // Catch:{ IOException -> 0x00db }
            goto L_0x009a
        L_0x00cf:
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x00db }
            r9[r6] = r8     // Catch:{ IOException -> 0x00db }
            java.lang.String r8 = "NativeLibraryExtractor: there are no native libraries for supported ABI %s"
            java.lang.String.format(r8, r9)     // Catch:{ IOException -> 0x00db }
        L_0x00d8:
            int r7 = r7 + 1
            goto L_0x006d
        L_0x00db:
            r12 = move-exception
            goto L_0x00df
        L_0x00dd:
            r12 = move-exception
            r0 = 0
        L_0x00df:
            if (r0 == 0) goto L_0x00e9
            r0.close()     // Catch:{ IOException -> 0x00e5 }
            goto L_0x00e9
        L_0x00e5:
            r13 = move-exception
            com.google.android.play.core.internal.cd.a(r12, r13)
        L_0x00e9:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.m.b(a2.j.b.e.a.h.n, a2.j.b.e.a.h.h):void");
    }

    public final Set<File> a() throws IOException {
        Set<n> d = this.b.d();
        e eVar = this.b;
        Objects.requireNonNull(eVar);
        ArrayList arrayList = new ArrayList();
        File[] listFiles = eVar.i().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    arrayList.add(file.getName());
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Iterator it2 = ((HashSet) d).iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((n) it2.next()).b().equals(str)) {
                        break;
                    }
                } else {
                    String.format("NativeLibraryExtractor: extracted split '%s' has no corresponding split; deleting", str);
                    File b2 = e.b(this.b.i(), str);
                    e.e(b2);
                    e.c(b2);
                    break;
                }
            }
        }
        HashSet hashSet = new HashSet();
        Iterator it3 = ((HashSet) d).iterator();
        while (it3.hasNext()) {
            n nVar = (n) it3.next();
            HashSet hashSet2 = new HashSet();
            b(nVar, new f(this, hashSet2, nVar));
            e eVar2 = this.b;
            String b3 = nVar.b();
            Objects.requireNonNull(eVar2);
            HashSet hashSet3 = new HashSet();
            File b4 = e.b(eVar2.i(), b3);
            e.e(b4);
            File[] listFiles2 = b4.listFiles();
            if (listFiles2 != null) {
                for (File file2 : listFiles2) {
                    if (file2.isFile()) {
                        hashSet3.add(file2);
                    }
                }
            }
            Iterator it4 = hashSet3.iterator();
            while (it4.hasNext()) {
                File file3 = (File) it4.next();
                if (!hashSet2.contains(file3)) {
                    String.format("NativeLibraryExtractor: file '%s' found in split '%s' that is not in the split file '%s'; removing", file3.getAbsolutePath(), nVar.b(), nVar.a().getAbsolutePath());
                    e eVar3 = this.b;
                    Objects.requireNonNull(eVar3);
                    d.a(file3.getParentFile().getParentFile().equals(eVar3.i()), "File to remove is not a native library");
                    e.c(file3);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }

    public final void c(n nVar, Set<l> set, i iVar) throws IOException {
        for (l lVar : set) {
            File a3 = this.b.a(nVar.b(), lVar.a);
            boolean z = false;
            if (a3.exists() && a3.length() == lVar.b.getSize()) {
                z = true;
            }
            iVar.a(lVar, a3, z);
        }
    }
}
