package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.Log;
@RequiresApi(17)
public final class DummySurface extends Surface {
    public static int c;
    public static boolean d;
    public final b a;
    public boolean b;
    public final boolean secure;

    public static class b extends HandlerThread implements Handler.Callback {
        public EGLSurfaceTexture a;
        public Handler b;
        @Nullable
        public Error c;
        @Nullable
        public RuntimeException d;
        @Nullable
        public DummySurface e;

        public b() {
            super("ExoPlayer:DummySurface");
        }

        public final void a(int i) {
            Assertions.checkNotNull(this.a);
            this.a.init(i);
            this.e = new DummySurface(this, this.a.getSurfaceTexture(), i != 0, null);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                try {
                    a(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e2);
                    this.d = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e3) {
                    try {
                        Log.e("DummySurface", "Failed to initialize dummy surface", e3);
                        this.c = e3;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Throwable th) {
                        synchronized (this) {
                            notify();
                            throw th;
                        }
                    }
                }
                return true;
            } else if (i != 2) {
                return true;
            } else {
                try {
                    Assertions.checkNotNull(this.a);
                    this.a.release();
                } catch (Throwable th2) {
                    quit();
                    throw th2;
                }
                quit();
                return true;
            }
        }
    }

    public DummySurface(b bVar, SurfaceTexture surfaceTexture, boolean z, a aVar) {
        super(surfaceTexture);
        this.a = bVar;
        this.secure = z;
    }

    public static synchronized boolean isSecureSupported(Context context) {
        boolean z;
        synchronized (DummySurface.class) {
            z = false;
            if (!d) {
                c = GlUtil.isProtectedContentExtensionSupported(context) ? GlUtil.isSurfacelessContextExtensionSupported() ? 1 : 2 : 0;
                d = true;
            }
            if (c != 0) {
                z = true;
            }
        }
        return z;
    }

    public static DummySurface newInstanceV17(Context context, boolean z) {
        boolean z2 = false;
        Assertions.checkState(!z || isSecureSupported(context));
        b bVar = new b();
        int i = z ? c : 0;
        bVar.start();
        Handler handler = new Handler(bVar.getLooper(), bVar);
        bVar.b = handler;
        bVar.a = new EGLSurfaceTexture(handler);
        synchronized (bVar) {
            bVar.b.obtainMessage(1, i, 0).sendToTarget();
            while (bVar.e == null && bVar.d == null && bVar.c == null) {
                try {
                    bVar.wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = bVar.d;
        if (runtimeException == null) {
            Error error = bVar.c;
            if (error == null) {
                return (DummySurface) Assertions.checkNotNull(bVar.e);
            }
            throw error;
        }
        throw runtimeException;
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.a) {
            if (!this.b) {
                b bVar = this.a;
                Assertions.checkNotNull(bVar.b);
                bVar.b.sendEmptyMessage(2);
                this.b = true;
            }
        }
    }
}
