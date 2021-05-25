package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.UnpackingSoSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;
public class ExtractFromZipSoSource extends UnpackingSoSource {
    public final File mZipFileName;
    public final String mZipSearchPattern;

    public class ZipUnpacker extends UnpackingSoSource.Unpacker {
        @Nullable
        public b[] a;
        public final ZipFile b;
        public final UnpackingSoSource c;

        public final class a extends UnpackingSoSource.InputDsoIterator {
            public int a;

            public a(a aVar) {
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public boolean hasNext() {
                ZipUnpacker.this.a();
                return this.a < ZipUnpacker.this.a.length;
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public UnpackingSoSource.InputDso next() throws IOException {
                ZipUnpacker.this.a();
                ZipUnpacker zipUnpacker = ZipUnpacker.this;
                b[] bVarArr = zipUnpacker.a;
                int i = this.a;
                this.a = i + 1;
                b bVar = bVarArr[i];
                InputStream inputStream = zipUnpacker.b.getInputStream(bVar.a);
                try {
                    return new UnpackingSoSource.InputDso(bVar, inputStream);
                } catch (Throwable th) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            }
        }

        public ZipUnpacker(UnpackingSoSource unpackingSoSource) throws IOException {
            this.b = new ZipFile(ExtractFromZipSoSource.this.mZipFileName);
            this.c = unpackingSoSource;
        }

        public final b[] a() {
            if (this.a == null) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                HashMap hashMap = new HashMap();
                Pattern compile = Pattern.compile(ExtractFromZipSoSource.this.mZipSearchPattern);
                String[] supportedAbis = SysUtil.getSupportedAbis();
                Enumeration<? extends ZipEntry> entries = this.b.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    Matcher matcher = compile.matcher(zipEntry.getName());
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        int findAbiScore = SysUtil.findAbiScore(supportedAbis, group);
                        if (findAbiScore >= 0) {
                            linkedHashSet.add(group);
                            b bVar = (b) hashMap.get(group2);
                            if (bVar == null || findAbiScore < bVar.b) {
                                hashMap.put(group2, new b(group2, zipEntry, findAbiScore));
                            }
                        }
                    }
                }
                this.c.setSoSourceAbis((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
                b[] bVarArr = (b[]) hashMap.values().toArray(new b[hashMap.size()]);
                Arrays.sort(bVarArr);
                int i = 0;
                for (int i2 = 0; i2 < bVarArr.length; i2++) {
                    b bVar2 = bVarArr[i2];
                    if (shouldExtract(bVar2.a, bVar2.name)) {
                        i++;
                    } else {
                        bVarArr[i2] = null;
                    }
                }
                b[] bVarArr2 = new b[i];
                int i3 = 0;
                for (b bVar3 : bVarArr) {
                    if (bVar3 != null) {
                        bVarArr2[i3] = bVar3;
                        i3++;
                    }
                }
                this.a = bVarArr2;
            }
            return this.a;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.b.close();
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final UnpackingSoSource.DsoManifest getDsoManifest() throws IOException {
            return new UnpackingSoSource.DsoManifest(a());
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final UnpackingSoSource.InputDsoIterator openDsoIterator() throws IOException {
            return new a(null);
        }

        public boolean shouldExtract(ZipEntry zipEntry, String str) {
            return true;
        }
    }

    public static final class b extends UnpackingSoSource.Dso implements Comparable {
        public final ZipEntry a;
        public final int b;

        public b(String str, ZipEntry zipEntry, int i) {
            super(str, String.format("pseudo-zip-hash-1-%s-%s-%s-%s", zipEntry.getName(), Long.valueOf(zipEntry.getSize()), Long.valueOf(zipEntry.getCompressedSize()), Long.valueOf(zipEntry.getCrc())));
            this.a = zipEntry;
            this.b = i;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.name.compareTo(((b) obj).name);
        }
    }

    public ExtractFromZipSoSource(Context context, String str, File file, String str2) {
        super(context, str);
        this.mZipFileName = file;
        this.mZipSearchPattern = str2;
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public UnpackingSoSource.Unpacker makeUnpacker() throws IOException {
        return new ZipUnpacker(this);
    }
}
