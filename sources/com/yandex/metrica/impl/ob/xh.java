package com.yandex.metrica.impl.ob;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.facebook.share.internal.ShareConstants;
import com.yandex.metrica.MetricaService;
import com.yandex.metrica.impl.ob.ao;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
public class xh implements xg, Runnable {
    private final ServiceConnection a;
    private final Handler b;
    private HashMap<String, xe> c;
    private final Context d;
    private boolean e;
    private ServerSocket f;
    private final xc g;
    private xs h;
    private acx i;
    private long j;
    private long k;
    @NonNull
    private final abt l;
    @NonNull
    private final abr m;
    @NonNull
    private final ao.c n;

    public static class a {
        public xh a(@NonNull Context context) {
            return new xh(context);
        }
    }

    public xh(Context context) {
        this(context, as.a().h(), as.a().k().i(), new abs(), new abr());
    }

    private void g() {
        eh.a().a(this, es.class, el.a(new ek<es>() { // from class: com.yandex.metrica.impl.ob.xh.7
            public void a(es esVar) {
                xh.this.g.a(esVar.a);
            }
        }).a(new ei<es>() { // from class: com.yandex.metrica.impl.ob.xh.6
            public boolean a(es esVar) {
                return !xh.this.d.getPackageName().equals(esVar.b);
            }
        }).a());
        eh.a().a(this, eo.class, el.a(new ek<eo>() { // from class: com.yandex.metrica.impl.ob.xh.8
            public void a(eo eoVar) {
                xh.this.g.b(eoVar.a);
            }
        }).a());
        eh.a().a(this, em.class, el.a(new ek<em>() { // from class: com.yandex.metrica.impl.ob.xh.9
            public void a(em emVar) {
                xh.this.g.c(emVar.a);
            }
        }).a());
        eh.a().a(this, en.class, el.a(new ek<en>() { // from class: com.yandex.metrica.impl.ob.xh.10
            public void a(en enVar) {
                xh.this.g.d(enVar.a);
            }
        }).a());
        eh.a().a(this, eq.class, el.a(new ek<eq>() { // from class: com.yandex.metrica.impl.ob.xh.2
            public void a(eq eqVar) {
                xh.this.a(eqVar.a);
                xh.this.c();
            }
        }).a());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h() {
        d();
        acx a3 = as.a().k().a(this);
        this.i = a3;
        a3.start();
        this.j = this.l.a();
    }

    @VisibleForTesting
    public ServerSocket f() {
        Iterator<Integer> it = this.h.c.iterator();
        ServerSocket serverSocket = null;
        Integer num = null;
        while (serverSocket == null && it.hasNext()) {
            try {
                Integer next = it.next();
                if (next != null) {
                    try {
                        serverSocket = b(next.intValue());
                    } catch (SocketException unused) {
                        num = next;
                    } catch (IOException unused2) {
                    }
                }
                num = next;
            } catch (SocketException unused3) {
            } catch (IOException unused4) {
            }
        }
        return serverSocket;
        a("port_already_in_use", num.intValue());
    }

    @Override // java.lang.Runnable
    public void run() {
        ServerSocket serverSocket;
        this.f = f();
        if (dl.a(26)) {
            TrafficStats.setThreadStatsTag(40230);
        }
        if (this.f != null) {
            while (this.e) {
                synchronized (this) {
                    serverSocket = this.f;
                }
                if (serverSocket != null) {
                    Socket socket = null;
                    try {
                        socket = serverSocket.accept();
                        if (dl.a(26)) {
                            TrafficStats.tagSocket(socket);
                        }
                        a(socket);
                        if (socket == null) {
                        }
                    } catch (Throwable unused) {
                        if (0 == 0) {
                        }
                    }
                    try {
                        socket.close();
                    } catch (IOException unused2) {
                    }
                }
            }
        }
    }

    public void a() {
        if (this.e) {
            b();
            Handler handler = this.b;
            handler.sendMessageDelayed(handler.obtainMessage(100), TimeUnit.SECONDS.toMillis(this.h.a));
            this.k = this.l.a();
        }
    }

    public void b() {
        this.b.removeMessages(100);
        this.k = 0;
    }

    public synchronized void c() {
        xs xsVar;
        if (!(this.e || (xsVar = this.h) == null || !this.n.a(xsVar.e))) {
            this.e = true;
        }
    }

    @VisibleForTesting
    public void d() {
        Intent intent = new Intent(this.d, MetricaService.class);
        intent.setAction("com.yandex.metrica.ACTION_BIND_TO_LOCAL_SERVER");
        try {
            if (!this.d.bindService(intent, this.a, 1)) {
                xa.a().reportEvent("socket_bind_has_failed");
            }
        } catch (Throwable unused) {
            xa.a().reportEvent("socket_bind_has_thrown_exception");
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void e() {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 0
            r2.e = r0     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            com.yandex.metrica.impl.ob.acx r0 = r2.i     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            r1 = 0
            if (r0 == 0) goto L_0x000e
            r0.b()     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            r2.i = r1     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
        L_0x000e:
            java.net.ServerSocket r0 = r2.f     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            if (r0 == 0) goto L_0x001b
            r0.close()     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            r2.f = r1     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            goto L_0x001b
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x001b:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.xh.e():void");
    }

    @VisibleForTesting
    public xh(@NonNull Context context, @NonNull ao aoVar, @NonNull act act, @NonNull abt abt, @NonNull abr abr) {
        this.a = new ServiceConnection() { // from class: com.yandex.metrica.impl.ob.xh.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }
        };
        this.b = new Handler(Looper.getMainLooper()) { // from class: com.yandex.metrica.impl.ob.xh.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 100) {
                    xh.this.e();
                    try {
                        xh.this.d.unbindService(xh.this.a);
                    } catch (Throwable unused) {
                        xa.a().reportEvent("socket_unbind_has_thrown_exception");
                    }
                }
            }
        };
        this.c = new HashMap<String, xe>() { // from class: com.yandex.metrica.impl.ob.xh.4
            {
                put("p", new xe() { // from class: com.yandex.metrica.impl.ob.xh.4.1
                    @Override // com.yandex.metrica.impl.ob.xe
                    @NonNull
                    public xd a(@NonNull Socket socket, @NonNull Uri uri) {
                        xh xhVar = xh.this;
                        return new xb(socket, uri, xhVar, xhVar.h, xh.this.g);
                    }
                });
            }
        };
        this.g = new xc();
        this.d = context;
        this.l = abt;
        this.m = abr;
        this.n = aoVar.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.xh.5
            @Override // java.lang.Runnable
            public void run() {
                xh.this.h();
            }
        }, act);
        g();
    }

    public ServerSocket b(int i2) throws IOException {
        return new ServerSocket(i2);
    }

    private String b(@NonNull String str) {
        return a2.b.a.a.a.c3("socket_", str);
    }

    private Map<String, Object> c(int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("port", String.valueOf(i2));
        return hashMap;
    }

    private Map<String, Object> d(int i2) {
        Map<String, Object> c2 = c(i2);
        c2.put("idle_interval", Double.valueOf(a(this.j)));
        c2.put("background_interval", Double.valueOf(a(this.k)));
        return c2;
    }

    @VisibleForTesting
    public void a(xs xsVar) {
        this.h = xsVar;
        if (xsVar != null) {
            this.n.a(xsVar.d);
        }
    }

    private double a(long j2) {
        long j3 = 0;
        if (j2 != 0) {
            j3 = this.m.e(j2, TimeUnit.MILLISECONDS);
        }
        return (double) j3;
    }

    private void a(@NonNull Socket socket) {
        new xf(socket, this, this.c).a();
    }

    @Override // com.yandex.metrica.impl.ob.xg
    public void a(@NonNull String str, String str2) {
        HashMap k0 = a2.b.a.a.a.k0(ShareConstants.MEDIA_URI, str2);
        ay a3 = xa.a();
        a3.reportEvent("socket_" + str, k0);
    }

    @Override // com.yandex.metrica.impl.ob.xg
    public void a(@NonNull String str) {
        xa.a().reportEvent(b(str));
    }

    @Override // com.yandex.metrica.impl.ob.xg
    public void a(@NonNull String str, Throwable th) {
        xa.a().reportError(b(str), th);
    }

    public void a(@NonNull String str, int i2) {
        xa.a().reportEvent(b(str), c(i2));
    }

    @Override // com.yandex.metrica.impl.ob.xg
    public void a(int i2) {
        xa.a().reportEvent(b("sync_succeed"), d(i2));
    }
}
