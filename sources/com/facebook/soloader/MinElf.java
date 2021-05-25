package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import kotlin.UShort;
import okhttp3.internal.ws.WebSocketProtocol;
import org.spongycastle.asn1.cmc.BodyPartID;
public final class MinElf {
    public static final int DT_NEEDED = 1;
    public static final int DT_NULL = 0;
    public static final int DT_STRTAB = 5;
    public static final int ELF_MAGIC = 1179403647;
    public static final int PN_XNUM = 65535;
    public static final int PT_DYNAMIC = 2;
    public static final int PT_LOAD = 1;

    public enum ISA {
        NOT_SO("not_so"),
        X86("x86"),
        ARM("armeabi-v7a"),
        X86_64("x86_64"),
        AARCH64("arm64-v8a"),
        OTHERS("others");
        
        public final String a;

        /* access modifiers changed from: public */
        ISA(String str) {
            this.a = str;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this.a;
        }
    }

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static long a(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        b(fileChannel, byteBuffer, 4, j);
        return ((long) byteBuffer.getInt()) & BodyPartID.bodyIdMax;
    }

    public static void b(FileChannel fileChannel, ByteBuffer byteBuffer, int i, long j) throws IOException {
        int read;
        byteBuffer.position(0);
        byteBuffer.limit(i);
        while (byteBuffer.remaining() > 0 && (read = fileChannel.read(byteBuffer, j)) != -1) {
            j += (long) read;
        }
        if (byteBuffer.remaining() <= 0) {
            byteBuffer.position(0);
            return;
        }
        throw new a("ELF file truncated");
    }

    public static String[] extract_DT_NEEDED(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return extract_DT_NEEDED(fileInputStream.getChannel());
        } finally {
            fileInputStream.close();
        }
    }

    public static String[] extract_DT_NEEDED(FileChannel fileChannel) throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        int i = 8;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (a(fileChannel, allocate, 0) == 1179403647) {
            b(fileChannel, allocate, 1, 4);
            boolean z = ((short) (allocate.get() & 255)) == 1;
            b(fileChannel, allocate, 1, 5);
            if (((short) (allocate.get() & 255)) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            if (z) {
                j = a(fileChannel, allocate, 28);
            } else {
                b(fileChannel, allocate, 8, 32);
                j = allocate.getLong();
            }
            if (z) {
                b(fileChannel, allocate, 2, 44);
                j2 = (long) (allocate.getShort() & UShort.MAX_VALUE);
            } else {
                b(fileChannel, allocate, 2, 56);
                j2 = (long) (allocate.getShort() & UShort.MAX_VALUE);
            }
            if (z) {
                j3 = 42;
            } else {
                j3 = 54;
            }
            b(fileChannel, allocate, 2, j3);
            int i2 = allocate.getShort() & UShort.MAX_VALUE;
            if (j2 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                if (z) {
                    j17 = a(fileChannel, allocate, 32);
                } else {
                    b(fileChannel, allocate, 8, 40);
                    j17 = allocate.getLong();
                }
                if (z) {
                    j2 = a(fileChannel, allocate, j17 + 28);
                } else {
                    j2 = a(fileChannel, allocate, j17 + 44);
                }
            }
            long j18 = j;
            long j19 = 0;
            while (true) {
                if (j19 >= j2) {
                    j4 = 0;
                    break;
                }
                if (z) {
                    j16 = a(fileChannel, allocate, j18 + 0);
                } else {
                    j16 = a(fileChannel, allocate, j18 + 0);
                }
                if (j16 != 2) {
                    j18 += (long) i2;
                    j19++;
                } else if (z) {
                    j4 = a(fileChannel, allocate, j18 + 4);
                } else {
                    b(fileChannel, allocate, 8, j18 + 8);
                    j4 = allocate.getLong();
                }
            }
            long j20 = 0;
            if (j4 != 0) {
                long j21 = j4;
                long j22 = 0;
                int i3 = 0;
                while (true) {
                    long j23 = j21 + j20;
                    if (z) {
                        j5 = a(fileChannel, allocate, j23);
                    } else {
                        b(fileChannel, allocate, i, j23);
                        j5 = allocate.getLong();
                    }
                    if (j5 == 1) {
                        j6 = j4;
                        if (i3 != Integer.MAX_VALUE) {
                            i3++;
                        } else {
                            throw new a("malformed DT_NEEDED section");
                        }
                    } else {
                        j6 = j4;
                        if (j5 == 5) {
                            if (z) {
                                j15 = a(fileChannel, allocate, j21 + 4);
                            } else {
                                b(fileChannel, allocate, 8, j21 + 8);
                                j15 = allocate.getLong();
                            }
                            j22 = j15;
                        }
                    }
                    long j24 = 16;
                    j21 += z ? 8 : 16;
                    long j25 = 0;
                    if (j5 != 0) {
                        j20 = 0;
                        j4 = j6;
                        i = 8;
                    } else if (j22 != 0) {
                        int i4 = 0;
                        while (true) {
                            if (((long) i4) >= j2) {
                                j7 = 0;
                                break;
                            }
                            if (z) {
                                j10 = a(fileChannel, allocate, j + j25);
                            } else {
                                j10 = a(fileChannel, allocate, j + j25);
                            }
                            if (j10 == 1) {
                                if (z) {
                                    j12 = a(fileChannel, allocate, j + 8);
                                } else {
                                    b(fileChannel, allocate, 8, j + j24);
                                    j12 = allocate.getLong();
                                }
                                if (z) {
                                    j11 = j2;
                                    j13 = a(fileChannel, allocate, j + 20);
                                } else {
                                    j11 = j2;
                                    b(fileChannel, allocate, 8, j + 40);
                                    j13 = allocate.getLong();
                                }
                                if (j12 <= j22 && j22 < j13 + j12) {
                                    if (z) {
                                        j14 = a(fileChannel, allocate, j + 4);
                                    } else {
                                        b(fileChannel, allocate, 8, j + 8);
                                        j14 = allocate.getLong();
                                    }
                                    j7 = j14 + (j22 - j12);
                                }
                            } else {
                                j11 = j2;
                            }
                            j += (long) i2;
                            i4++;
                            j2 = j11;
                            j24 = 16;
                            j25 = 0;
                        }
                        long j26 = 0;
                        if (j7 != 0) {
                            String[] strArr = new String[i3];
                            int i5 = 0;
                            while (true) {
                                long j27 = j6 + j26;
                                if (z) {
                                    j8 = a(fileChannel, allocate, j27);
                                } else {
                                    b(fileChannel, allocate, 8, j27);
                                    j8 = allocate.getLong();
                                }
                                if (j8 == 1) {
                                    if (z) {
                                        j9 = a(fileChannel, allocate, j6 + 4);
                                    } else {
                                        b(fileChannel, allocate, 8, j6 + 8);
                                        j9 = allocate.getLong();
                                    }
                                    long j28 = j9 + j7;
                                    StringBuilder sb = new StringBuilder();
                                    while (true) {
                                        long j29 = j28 + 1;
                                        b(fileChannel, allocate, 1, j28);
                                        short s = (short) (allocate.get() & 255);
                                        if (s == 0) {
                                            break;
                                        }
                                        sb.append((char) s);
                                        j28 = j29;
                                    }
                                    strArr[i5] = sb.toString();
                                    if (i5 != Integer.MAX_VALUE) {
                                        i5++;
                                    } else {
                                        throw new a("malformed DT_NEEDED section");
                                    }
                                }
                                j6 += z ? 8 : 16;
                                if (j8 != 0) {
                                    j26 = 0;
                                } else if (i5 == i3) {
                                    return strArr;
                                } else {
                                    throw new a("malformed DT_NEEDED section");
                                }
                            }
                        } else {
                            throw new a("did not find file offset of DT_STRTAB table");
                        }
                    } else {
                        throw new a("Dynamic section string-table not found");
                    }
                }
            } else {
                throw new a("ELF file does not contain dynamic linking information");
            }
        } else {
            throw new a("file is not ELF");
        }
    }
}
