package com.google.android.exoplayer2.util;

import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
public final class SntpClient {
    public static final String DEFAULT_NTP_HOST = "time.android.com";
    public static final Object a = new Object();
    public static final Object b = new Object();
    @GuardedBy("valueLock")
    public static boolean c = false;
    @GuardedBy("valueLock")
    public static long d = 0;
    @GuardedBy("valueLock")
    public static String e = "time.android.com";

    public interface InitializationCallback {
        void onInitializationFailed(IOException iOException);

        void onInitialized();
    }

    public static final class b implements Loader.Callback<Loader.Loadable> {
        @Nullable
        public final InitializationCallback a;

        public b(@Nullable InitializationCallback initializationCallback) {
            this.a = initializationCallback;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(Loader.Loadable loadable, long j, long j2, boolean z) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(Loader.Loadable loadable, long j, long j2) {
            if (this.a == null) {
                return;
            }
            if (!SntpClient.isInitialized()) {
                this.a.onInitializationFailed(new IOException(new ConcurrentModificationException()));
            } else {
                this.a.onInitialized();
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public Loader.LoadErrorAction onLoadError(Loader.Loadable loadable, long j, long j2, IOException iOException, int i) {
            InitializationCallback initializationCallback = this.a;
            if (initializationCallback != null) {
                initializationCallback.onInitializationFailed(iOException);
            }
            return Loader.DONT_RETRY;
        }
    }

    public static final class c implements Loader.Loadable {
        public c(a aVar) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws IOException {
            String str = SntpClient.DEFAULT_NTP_HOST;
            synchronized (SntpClient.a) {
                Object obj = SntpClient.b;
                synchronized (obj) {
                    if (!SntpClient.c) {
                        long a = SntpClient.a();
                        synchronized (obj) {
                            SntpClient.d = a;
                            SntpClient.c = true;
                        }
                    }
                }
            }
        }
    }

    public static long a() throws IOException {
        Throwable th;
        DatagramSocket datagramSocket;
        InetAddress byName = InetAddress.getByName(getNtpHost());
        DatagramSocket datagramSocket2 = new DatagramSocket();
        try {
            datagramSocket2.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = Ascii.ESC;
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (currentTimeMillis == 0) {
                Arrays.fill(bArr, 40, 48, (byte) 0);
                datagramSocket = datagramSocket2;
            } else {
                long j = currentTimeMillis / 1000;
                Long.signum(j);
                long j2 = currentTimeMillis - (j * 1000);
                long j3 = j + 2208988800L;
                bArr[40] = (byte) ((int) (j3 >> 24));
                datagramSocket = datagramSocket2;
                try {
                    bArr[41] = (byte) ((int) (j3 >> 16));
                    bArr[42] = (byte) ((int) (j3 >> 8));
                    bArr[43] = (byte) ((int) (j3 >> 0));
                    long j4 = (j2 * 4294967296L) / 1000;
                    bArr[44] = (byte) ((int) (j4 >> 24));
                    bArr[45] = (byte) ((int) (j4 >> 16));
                    bArr[46] = (byte) ((int) (j4 >> 8));
                    bArr[47] = (byte) ((int) (Math.random() * 255.0d));
                } catch (Throwable th2) {
                    th = th2;
                    datagramSocket2 = datagramSocket;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
            }
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            long j5 = (elapsedRealtime2 - elapsedRealtime) + currentTimeMillis;
            long d2 = d(bArr, 24);
            long d3 = d(bArr, 32);
            long d4 = d(bArr, 40);
            b((byte) ((bArr[0] >> 6) & 3), (byte) (bArr[0] & 7), bArr[1] & 255, d4);
            long j6 = (j5 + (((d4 - j5) + (d3 - d2)) / 2)) - elapsedRealtime2;
            datagramSocket.close();
            return j6;
        } catch (Throwable th4) {
            th = th4;
            throw th;
        }
        throw th;
    }

    public static void b(byte b2, byte b3, int i, long j) throws IOException {
        if (b2 == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        } else if (b3 != 4 && b3 != 5) {
            throw new IOException(a2.b.a.a.a.M2("SNTP: Untrusted mode: ", b3));
        } else if (i == 0 || i > 15) {
            throw new IOException(a2.b.a.a.a.M2("SNTP: Untrusted stratum: ", i));
        } else if (j == 0) {
            throw new IOException("SNTP: Zero transmitTime");
        }
    }

    public static long c(byte[] bArr, int i) {
        byte b2 = bArr[i];
        byte b3 = bArr[i + 1];
        byte b4 = bArr[i + 2];
        byte b5 = bArr[i + 3];
        int i2 = b2 & 128;
        byte b6 = b2;
        if (i2 == 128) {
            b6 = (b2 & Byte.MAX_VALUE) + 128;
        }
        int i3 = b3 & 128;
        byte b8 = b3;
        if (i3 == 128) {
            b8 = (b3 & Byte.MAX_VALUE) + 128;
        }
        int i4 = b4 & 128;
        byte b9 = b4;
        if (i4 == 128) {
            b9 = (b4 & Byte.MAX_VALUE) + 128;
        }
        int i5 = b5 & 128;
        byte b10 = b5;
        if (i5 == 128) {
            b10 = (b5 & Byte.MAX_VALUE) + 128;
        }
        return ((b6 == 1 ? 1 : 0) << 24) + ((b8 == 1 ? 1 : 0) << 16) + ((b9 == 1 ? 1 : 0) << 8) + (b10 == 1 ? 1 : 0);
    }

    public static long d(byte[] bArr, int i) {
        long c2 = c(bArr, i);
        long c3 = c(bArr, i + 4);
        if (c2 == 0 && c3 == 0) {
            return 0;
        }
        return ((c3 * 1000) / 4294967296L) + ((c2 - 2208988800L) * 1000);
    }

    public static long getElapsedRealtimeOffsetMs() {
        long j;
        synchronized (b) {
            j = c ? d : C.TIME_UNSET;
        }
        return j;
    }

    public static String getNtpHost() {
        String str;
        synchronized (b) {
            str = e;
        }
        return str;
    }

    public static void initialize(@Nullable Loader loader, @Nullable InitializationCallback initializationCallback) {
        if (!isInitialized()) {
            if (loader == null) {
                loader = new Loader("SntpClient");
            }
            loader.startLoading(new c(null), new b(initializationCallback), 1);
        } else if (initializationCallback != null) {
            initializationCallback.onInitialized();
        }
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (b) {
            z = c;
        }
        return z;
    }

    public static void setNtpHost(String str) {
        synchronized (b) {
            if (!e.equals(str)) {
                e = str;
                c = false;
            }
        }
    }
}
