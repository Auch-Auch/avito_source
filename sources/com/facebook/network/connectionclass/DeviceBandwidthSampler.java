package com.facebook.network.connectionclass;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;
public class DeviceBandwidthSampler {
    public final ConnectionClassManager a;
    public AtomicInteger b = new AtomicInteger();
    public Handler c;
    public HandlerThread d;
    public long e;

    public static class b {
        public static final DeviceBandwidthSampler a = new DeviceBandwidthSampler(ConnectionClassManager.getInstance(), null);
    }

    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00ad A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a() {
            /*
                r11 = this;
                java.lang.ThreadLocal<byte[]> r0 = a2.g.t.a.d.a
                java.lang.Class<a2.g.t.a.d> r0 = a2.g.t.a.d.class
                monitor-enter(r0)
                a2.g.t.a.d r1 = a2.g.t.a.d.e     // Catch:{ all -> 0x00c9 }
                if (r1 != 0) goto L_0x0012
                a2.g.t.a.d r1 = new a2.g.t.a.d     // Catch:{ all -> 0x00c9 }
                java.lang.String r2 = "/proc/net/xt_qtaguid/stats"
                r1.<init>(r2)     // Catch:{ all -> 0x00c9 }
                a2.g.t.a.d.e = r1     // Catch:{ all -> 0x00c9 }
            L_0x0012:
                a2.g.t.a.d r1 = a2.g.t.a.d.e     // Catch:{ all -> 0x00c9 }
                monitor-exit(r0)
                int r0 = android.os.Process.myUid()
                java.util.Objects.requireNonNull(r1)
                android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()
                r2 = 0
                r4 = -1
                java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00a8, all -> 0x00a3 }
                java.lang.String r7 = "/proc/net/xt_qtaguid/stats"
                r6.<init>(r7)     // Catch:{ IOException -> 0x00a8, all -> 0x00a3 }
                a2.g.t.a.c r7 = a2.g.t.a.d.c     // Catch:{ IOException -> 0x00a8, all -> 0x00a3 }
                r7.b = r6     // Catch:{ IOException -> 0x00a8, all -> 0x00a3 }
                r8 = 0
                r7.d = r8     // Catch:{ IOException -> 0x00a8, all -> 0x00a3 }
                r7.c = r8     // Catch:{ IOException -> 0x00a8, all -> 0x00a3 }
                java.lang.ThreadLocal<byte[]> r7 = a2.g.t.a.d.a     // Catch:{ IOException -> 0x00a8, all -> 0x00a3 }
                java.lang.Object r7 = r7.get()     // Catch:{ IOException -> 0x00a8, all -> 0x00a3 }
                byte[] r7 = (byte[]) r7     // Catch:{ IOException -> 0x00a8, all -> 0x00a3 }
                a2.g.t.a.c r9 = a2.g.t.a.d.c     // Catch:{ all -> 0x009e }
                r9.b()     // Catch:{ all -> 0x009e }
            L_0x0041:
                a2.g.t.a.c r9 = a2.g.t.a.d.c     // Catch:{ all -> 0x009e }
                int r9 = r9.a(r7)     // Catch:{ all -> 0x009e }
                r10 = -1
                if (r9 == r10) goto L_0x008a
                a2.g.t.a.a r10 = a2.g.t.a.d.d     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                r10.a = r7     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                r10.b = r8     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                r10.c = r9     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                r10.e = r8     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                r9 = 32
                r10.f()     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                r10.d = r9     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                r9 = 1
                r10.e = r9     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                a2.g.t.a.a r9 = a2.g.t.a.d.d     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                r9.d()     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                a2.g.t.a.a r9 = a2.g.t.a.d.d     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                java.lang.String r10 = "lo"
                boolean r9 = r9.c(r10)     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                if (r9 == 0) goto L_0x006e
                goto L_0x0041
            L_0x006e:
                a2.g.t.a.a r9 = a2.g.t.a.d.d     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                r9.d()     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                a2.g.t.a.a r9 = a2.g.t.a.d.d     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                int r9 = r9.b()     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                if (r9 == r0) goto L_0x007c
                goto L_0x0041
            L_0x007c:
                a2.g.t.a.a r9 = a2.g.t.a.d.d     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                r9.d()     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                a2.g.t.a.a r9 = a2.g.t.a.d.d     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                int r9 = r9.b()     // Catch:{ NumberFormatException | NoSuchElementException -> 0x0041 }
                long r9 = (long) r9
                long r2 = r2 + r9
                goto L_0x0041
            L_0x008a:
                r6.close()
                long r6 = a2.g.t.a.d.b
                int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r0 != 0) goto L_0x0096
                a2.g.t.a.d.b = r2
                goto L_0x00a8
            L_0x0096:
                long r6 = r2 - r6
                a2.g.t.a.d.b = r2
                android.os.StrictMode.setThreadPolicy(r1)
                goto L_0x00ac
            L_0x009e:
                r0 = move-exception
                r6.close()
                throw r0
            L_0x00a3:
                r0 = move-exception
                android.os.StrictMode.setThreadPolicy(r1)
                throw r0
            L_0x00a8:
                android.os.StrictMode.setThreadPolicy(r1)
                r6 = r4
            L_0x00ac:
                monitor-enter(r11)
                long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00c6 }
                int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r2 == 0) goto L_0x00c0
                com.facebook.network.connectionclass.DeviceBandwidthSampler r2 = com.facebook.network.connectionclass.DeviceBandwidthSampler.this     // Catch:{ all -> 0x00c6 }
                com.facebook.network.connectionclass.ConnectionClassManager r3 = r2.a     // Catch:{ all -> 0x00c6 }
                long r4 = r2.e     // Catch:{ all -> 0x00c6 }
                long r4 = r0 - r4
                r3.addBandwidth(r6, r4)     // Catch:{ all -> 0x00c6 }
            L_0x00c0:
                com.facebook.network.connectionclass.DeviceBandwidthSampler r2 = com.facebook.network.connectionclass.DeviceBandwidthSampler.this     // Catch:{ all -> 0x00c6 }
                r2.e = r0     // Catch:{ all -> 0x00c6 }
                monitor-exit(r11)     // Catch:{ all -> 0x00c6 }
                return
            L_0x00c6:
                r0 = move-exception
                monitor-exit(r11)     // Catch:{ all -> 0x00c6 }
                throw r0
            L_0x00c9:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.network.connectionclass.DeviceBandwidthSampler.c.a():void");
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                a();
                sendEmptyMessageDelayed(1, 1000);
            } else if (i == 2) {
                a();
                removeMessages(1);
            } else {
                StringBuilder L = a2.b.a.a.a.L("Unknown what=");
                L.append(message.what);
                throw new IllegalArgumentException(L.toString());
            }
        }
    }

    public DeviceBandwidthSampler(ConnectionClassManager connectionClassManager, a aVar) {
        this.a = connectionClassManager;
        HandlerThread handlerThread = new HandlerThread("ParseThread");
        this.d = handlerThread;
        handlerThread.start();
        this.c = new c(this.d.getLooper());
    }

    @Nonnull
    public static DeviceBandwidthSampler getInstance() {
        return b.a;
    }

    public boolean isSampling() {
        return this.b.get() != 0;
    }

    public void startSampling() {
        if (this.b.getAndIncrement() == 0) {
            this.c.sendEmptyMessage(1);
            this.e = SystemClock.elapsedRealtime();
        }
    }

    public void stopSampling() {
        if (this.b.decrementAndGet() == 0) {
            this.c.sendEmptyMessage(2);
        }
    }
}
