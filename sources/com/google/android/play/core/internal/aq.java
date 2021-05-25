package com.google.android.play.core.internal;

import a2.b.a.a.a;
import a2.j.b.e.a.d.k;
import a2.j.b.e.a.d.l;
import a2.j.b.e.a.d.p;
import a2.j.b.e.a.d.q;
import a2.j.b.e.a.d.r;
import a2.j.b.e.a.d.u;
import a2.j.b.e.a.d.v;
import a2.j.b.e.a.d.x;
import android.os.Build;
import com.avito.android.brandspace.data.BrandspaceTabsRepositoryImplKt;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public final class aq {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static ap a() {
        switch (Build.VERSION.SDK_INT) {
            case 21:
                return new k();
            case 22:
                return new l();
            case 23:
                return new p();
            case 24:
                return new q();
            case 25:
                return new r();
            case 26:
                return new u();
            case 27:
                if (Build.VERSION.PREVIEW_SDK_INT == 0) {
                    return new v();
                }
                break;
        }
        return new x();
    }

    public static String a(File file) {
        if (file.getName().endsWith(".apk")) {
            return file.getName().replaceFirst("(_\\d+)?\\.apk", "").replace("base-", "config.").replace("-", ".config.").replace(".config.master", "").replace("config.master", "");
        }
        throw new IllegalArgumentException("Non-apk found in splits directory.");
    }

    public static void a(bv bvVar, InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[16384];
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream, 4096));
        int readInt = dataInputStream.readInt();
        if (readInt != -771763713) {
            String valueOf = String.valueOf(String.format(BrandspaceTabsRepositoryImplKt.HEX_STRING_FORMAT, Integer.valueOf(readInt)));
            throw new bu(valueOf.length() == 0 ? new String("Unexpected magic=") : "Unexpected magic=".concat(valueOf));
        }
        int read = dataInputStream.read();
        if (read == 4) {
            long j2 = 0;
            while (true) {
                long j3 = j - j2;
                try {
                    int read2 = dataInputStream.read();
                    if (read2 == -1) {
                        throw new IOException("Patch file overrun");
                    } else if (read2 != 0) {
                        switch (read2) {
                            case 247:
                                read2 = dataInputStream.readUnsignedShort();
                                c(bArr, dataInputStream, outputStream, read2, j3);
                                break;
                            case 248:
                                read2 = dataInputStream.readInt();
                                c(bArr, dataInputStream, outputStream, read2, j3);
                                break;
                            case 249:
                                long readUnsignedShort = (long) dataInputStream.readUnsignedShort();
                                read2 = dataInputStream.read();
                                if (read2 != -1) {
                                    b(bArr, bvVar, outputStream, readUnsignedShort, read2, j3);
                                    break;
                                } else {
                                    throw new IOException("Unexpected end of patch");
                                }
                            case 250:
                                read2 = dataInputStream.readUnsignedShort();
                                b(bArr, bvVar, outputStream, (long) dataInputStream.readUnsignedShort(), read2, j3);
                                break;
                            case 251:
                                read2 = dataInputStream.readInt();
                                b(bArr, bvVar, outputStream, (long) dataInputStream.readUnsignedShort(), read2, j3);
                                break;
                            case 252:
                                long readInt2 = (long) dataInputStream.readInt();
                                read2 = dataInputStream.read();
                                if (read2 != -1) {
                                    b(bArr, bvVar, outputStream, readInt2, read2, j3);
                                    break;
                                } else {
                                    throw new IOException("Unexpected end of patch");
                                }
                            case 253:
                                read2 = dataInputStream.readUnsignedShort();
                                b(bArr, bvVar, outputStream, (long) dataInputStream.readInt(), read2, j3);
                                break;
                            case 254:
                                read2 = dataInputStream.readInt();
                                b(bArr, bvVar, outputStream, (long) dataInputStream.readInt(), read2, j3);
                                break;
                            case 255:
                                long readLong = dataInputStream.readLong();
                                read2 = dataInputStream.readInt();
                                b(bArr, bvVar, outputStream, readLong, read2, j3);
                                break;
                            default:
                                c(bArr, dataInputStream, outputStream, read2, j3);
                                break;
                        }
                        j2 += (long) read2;
                    } else {
                        return;
                    }
                } finally {
                    outputStream.flush();
                }
            }
        } else {
            throw new bu(a.m2(30, "Unexpected version=", read));
        }
    }

    public static void b(byte[] bArr, bv bvVar, OutputStream outputStream, long j, int i, long j2) throws IOException {
        int i2 = i;
        if (i2 < 0) {
            throw new IOException("copyLength negative");
        } else if (j >= 0) {
            long j3 = (long) i2;
            if (j3 <= j2) {
                try {
                    InputStream b = new bw(bvVar, j, j3).b();
                    while (i2 > 0) {
                        try {
                            int min = Math.min(i2, 16384);
                            int i3 = 0;
                            while (i3 < min) {
                                int read = b.read(bArr, i3, min - i3);
                                if (read != -1) {
                                    i3 += read;
                                } else {
                                    throw new IOException("truncated input stream");
                                }
                            }
                            outputStream.write(bArr, 0, min);
                            i2 -= min;
                        } catch (Throwable th) {
                            cd.a(th, th);
                        }
                    }
                    if (b != null) {
                        b.close();
                        return;
                    }
                    return;
                } catch (EOFException e) {
                    throw new IOException("patch underrun", e);
                }
            } else {
                throw new IOException("Output length overrun");
            }
        } else {
            throw new IOException("inputOffset negative");
        }
        throw th;
    }

    public static void c(byte[] bArr, DataInputStream dataInputStream, OutputStream outputStream, int i, long j) throws IOException {
        if (i < 0) {
            throw new IOException("copyLength negative");
        } else if (((long) i) <= j) {
            while (i > 0) {
                try {
                    int min = Math.min(i, 16384);
                    dataInputStream.readFully(bArr, 0, min);
                    outputStream.write(bArr, 0, min);
                    i -= min;
                } catch (EOFException unused) {
                    throw new IOException("patch underrun");
                }
            }
        } else {
            throw new IOException("Output length overrun");
        }
    }
}
