package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.google.android.gms.common.util.VisibleForTesting;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
@TargetApi(14)
public final class zzbdc extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzbdd {
    private static final float[] zzegv = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private int height;
    private int width;
    private final float[] zzegs = new float[9];
    private final zzbdb zzegw;
    private final float[] zzegx = new float[9];
    private final float[] zzegy = new float[9];
    private final float[] zzegz = new float[9];
    private final float[] zzeha = new float[9];
    private final float[] zzehb = new float[9];
    private final float[] zzehc = new float[9];
    private float zzehd = Float.NaN;
    private float zzehe;
    private float zzehf;
    private SurfaceTexture zzehg;
    private SurfaceTexture zzehh;
    private int zzehi;
    private int zzehj;
    private int zzehk;
    private FloatBuffer zzehl;
    private final CountDownLatch zzehm;
    private final Object zzehn;
    private EGL10 zzeho;
    private EGLDisplay zzehp;
    private EGLContext zzehq;
    private EGLSurface zzehr;
    private volatile boolean zzehs;
    private volatile boolean zzeht;

    public zzbdc(Context context) {
        super("SphericalVideoProcessor");
        float[] fArr = zzegv;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzehl = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        zzbdb zzbdb = new zzbdb(context);
        this.zzegw = zzbdb;
        zzbdb.zza(this);
        this.zzehm = new CountDownLatch(1);
        this.zzehn = new Object();
    }

    private static int zzd(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        zzfi("createShader");
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        zzfi("shaderSource");
        GLES20.glCompileShader(glCreateShader);
        zzfi("compileShader");
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        zzfi("getShaderiv");
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        GLES20.glGetShaderInfoLog(glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        zzfi("deleteShader");
        return 0;
    }

    private static void zzfi(String str) {
        if (GLES20.glGetError() != 0) {
            String.valueOf(str).length();
        }
    }

    @VisibleForTesting
    private final boolean zzzm() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.zzehr;
        boolean z = false;
        if (!(eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE))) {
            z = this.zzeho.eglDestroySurface(this.zzehp, this.zzehr) | this.zzeho.eglMakeCurrent(this.zzehp, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT) | false;
            this.zzehr = null;
        }
        EGLContext eGLContext = this.zzehq;
        if (eGLContext != null) {
            z |= this.zzeho.eglDestroyContext(this.zzehp, eGLContext);
            this.zzehq = null;
        }
        EGLDisplay eGLDisplay = this.zzehp;
        if (eGLDisplay == null) {
            return z;
        }
        boolean eglTerminate = z | this.zzeho.eglTerminate(eGLDisplay);
        this.zzehp = null;
        return eglTerminate;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzehk++;
        synchronized (this.zzehn) {
            this.zzehn.notifyAll();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v19, resolved type: android.graphics.SurfaceTexture */
    /* JADX DEBUG: Multi-variable search result rejected for r1v14, resolved type: android.graphics.SurfaceTexture */
    /* JADX DEBUG: Multi-variable search result rejected for r0v23, resolved type: android.graphics.SurfaceTexture */
    /* JADX DEBUG: Multi-variable search result rejected for r0v26, resolved type: android.graphics.SurfaceTexture */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.graphics.SurfaceTexture, android.graphics.SurfaceTexture$OnFrameAvailableListener] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0391  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0396  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01c2 A[ADDED_TO_REGION] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 1008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdc.run():void");
    }

    public final void zza(SurfaceTexture surfaceTexture, int i, int i2) {
        this.width = i;
        this.height = i2;
        this.zzehh = surfaceTexture;
    }

    public final void zzb(float f, float f2) {
        float f3;
        float f4;
        float f5;
        int i = this.width;
        int i2 = this.height;
        if (i > i2) {
            f4 = (f * 1.7453293f) / ((float) i);
            f3 = f2 * 1.7453293f;
            f5 = (float) i;
        } else {
            f4 = (f * 1.7453293f) / ((float) i2);
            f3 = f2 * 1.7453293f;
            f5 = (float) i2;
        }
        this.zzehe -= f4;
        float f6 = this.zzehf - (f3 / f5);
        this.zzehf = f6;
        if (f6 < -1.5707964f) {
            this.zzehf = -1.5707964f;
        }
        if (this.zzehf > 1.5707964f) {
            this.zzehf = 1.5707964f;
        }
    }

    public final void zzm(int i, int i2) {
        synchronized (this.zzehn) {
            this.width = i;
            this.height = i2;
            this.zzehs = true;
            this.zzehn.notifyAll();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdd
    public final void zzuu() {
        synchronized (this.zzehn) {
            this.zzehn.notifyAll();
        }
    }

    public final void zzzk() {
        synchronized (this.zzehn) {
            this.zzeht = true;
            this.zzehh = null;
            this.zzehn.notifyAll();
        }
    }

    public final SurfaceTexture zzzl() {
        if (this.zzehh == null) {
            return null;
        }
        try {
            this.zzehm.await();
        } catch (InterruptedException unused) {
        }
        return this.zzehg;
    }

    private static void zza(float[] fArr, float[] fArr2, float[] fArr3) {
        float f = fArr2[1] * fArr3[3];
        fArr[0] = (fArr2[2] * fArr3[6]) + f + (fArr2[0] * fArr3[0]);
        fArr[1] = (fArr2[2] * fArr3[7]) + (fArr2[1] * fArr3[4]) + (fArr2[0] * fArr3[1]);
        fArr[2] = (fArr2[2] * fArr3[8]) + (fArr2[1] * fArr3[5]) + (fArr2[0] * fArr3[2]);
        fArr[3] = (fArr2[5] * fArr3[6]) + (fArr2[4] * fArr3[3]) + (fArr2[3] * fArr3[0]);
        fArr[4] = (fArr2[5] * fArr3[7]) + (fArr2[4] * fArr3[4]) + (fArr2[3] * fArr3[1]);
        fArr[5] = (fArr2[5] * fArr3[8]) + (fArr2[4] * fArr3[5]) + (fArr2[3] * fArr3[2]);
        fArr[6] = (fArr2[8] * fArr3[6]) + (fArr2[7] * fArr3[3]) + (fArr2[6] * fArr3[0]);
        fArr[7] = (fArr2[8] * fArr3[7]) + (fArr2[7] * fArr3[4]) + (fArr2[6] * fArr3[1]);
        float f2 = fArr2[6] * fArr3[2];
        fArr[8] = (fArr2[8] * fArr3[8]) + (fArr2[7] * fArr3[5]) + f2;
    }

    private static void zzb(float[] fArr, float f) {
        double d = (double) f;
        fArr[0] = (float) Math.cos(d);
        fArr[1] = (float) (-Math.sin(d));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d);
        fArr[4] = (float) Math.cos(d);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static void zza(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d = (double) f;
        fArr[4] = (float) Math.cos(d);
        fArr[5] = (float) (-Math.sin(d));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d);
        fArr[8] = (float) Math.cos(d);
    }
}
