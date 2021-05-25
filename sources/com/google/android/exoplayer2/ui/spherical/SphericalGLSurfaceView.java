package com.google.android.exoplayer2.ui.spherical;

import a2.j.b.b.c1.m0.c;
import a2.j.b.b.c1.m0.d;
import a2.j.b.b.c1.m0.e;
import a2.j.b.b.c1.m0.f;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.AnyThread;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.spherical.OrientationListener;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.spherical.Projection;
import com.sumsub.sns.R2;
import java.nio.Buffer;
import java.util.Objects;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
public final class SphericalGLSurfaceView extends GLSurfaceView {
    public final SensorManager a;
    @Nullable
    public final Sensor b;
    public final OrientationListener c;
    public final Handler d;
    public final f e;
    public final e f;
    @Nullable
    public SurfaceTexture g;
    @Nullable
    public Surface h;
    @Nullable
    public Player.VideoComponent i;
    public boolean j;
    public boolean k;
    public boolean l;

    @VisibleForTesting
    public class a implements GLSurfaceView.Renderer, f.a, OrientationListener.Listener {
        public final e a;
        public final float[] b = new float[16];
        public final float[] c = new float[16];
        public final float[] d;
        public final float[] e;
        public final float[] f;
        public float g;
        public float h;
        public final float[] i;
        public final float[] j;

        public a(e eVar) {
            float[] fArr = new float[16];
            this.d = fArr;
            float[] fArr2 = new float[16];
            this.e = fArr2;
            float[] fArr3 = new float[16];
            this.f = fArr3;
            this.i = new float[16];
            this.j = new float[16];
            this.a = eVar;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.h = 3.1415927f;
        }

        @AnyThread
        public final void a() {
            Matrix.setRotateM(this.e, 0, -this.g, (float) Math.cos((double) this.h), (float) Math.sin((double) this.h), 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            float[] fArr;
            synchronized (this) {
                Matrix.multiplyMM(this.j, 0, this.d, 0, this.f, 0);
                Matrix.multiplyMM(this.i, 0, this.e, 0, this.j, 0);
            }
            Matrix.multiplyMM(this.c, 0, this.b, 0, this.i, 0);
            e eVar = this.a;
            float[] fArr2 = this.c;
            Objects.requireNonNull(eVar);
            GLES20.glClear(16384);
            GlUtil.checkGlError();
            if (eVar.a.compareAndSet(true, false)) {
                ((SurfaceTexture) Assertions.checkNotNull(eVar.j)).updateTexImage();
                GlUtil.checkGlError();
                if (eVar.b.compareAndSet(true, false)) {
                    Matrix.setIdentityM(eVar.g, 0);
                }
                long timestamp = eVar.j.getTimestamp();
                Long poll = eVar.e.poll(timestamp);
                if (poll != null) {
                    eVar.d.pollRotationMatrix(eVar.g, poll.longValue());
                }
                Projection pollFloor = eVar.f.pollFloor(timestamp);
                if (pollFloor != null) {
                    d dVar = eVar.c;
                    Objects.requireNonNull(dVar);
                    if (d.a(pollFloor)) {
                        dVar.a = pollFloor.stereoMode;
                        d.a aVar = new d.a(pollFloor.leftMesh.getSubMesh(0));
                        dVar.b = aVar;
                        if (!pollFloor.singleMesh) {
                            aVar = new d.a(pollFloor.rightMesh.getSubMesh(0));
                        }
                        dVar.c = aVar;
                    }
                }
            }
            Matrix.multiplyMM(eVar.h, 0, fArr2, 0, eVar.g, 0);
            d dVar2 = eVar.c;
            int i2 = eVar.i;
            float[] fArr3 = eVar.h;
            d.a aVar2 = dVar2.b;
            if (aVar2 != null) {
                GLES20.glUseProgram(dVar2.d);
                GlUtil.checkGlError();
                GLES20.glEnableVertexAttribArray(dVar2.g);
                GLES20.glEnableVertexAttribArray(dVar2.h);
                GlUtil.checkGlError();
                int i3 = dVar2.a;
                if (i3 == 1) {
                    fArr = d.m;
                } else if (i3 == 2) {
                    fArr = d.o;
                } else {
                    fArr = d.l;
                }
                GLES20.glUniformMatrix3fv(dVar2.f, 1, false, fArr, 0);
                GLES20.glUniformMatrix4fv(dVar2.e, 1, false, fArr3, 0);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(36197, i2);
                GLES20.glUniform1i(dVar2.i, 0);
                GlUtil.checkGlError();
                GLES20.glVertexAttribPointer(dVar2.g, 3, (int) R2.styleable.Motion_motionPathRotate, false, 12, (Buffer) aVar2.b);
                GlUtil.checkGlError();
                GLES20.glVertexAttribPointer(dVar2.h, 2, (int) R2.styleable.Motion_motionPathRotate, false, 8, (Buffer) aVar2.c);
                GlUtil.checkGlError();
                GLES20.glDrawArrays(aVar2.d, 0, aVar2.a);
                GlUtil.checkGlError();
                GLES20.glDisableVertexAttribArray(dVar2.g);
                GLES20.glDisableVertexAttribArray(dVar2.h);
            }
        }

        @Override // com.google.android.exoplayer2.ui.spherical.OrientationListener.Listener
        @BinderThread
        public synchronized void onOrientationChange(float[] fArr, float f2) {
            float[] fArr2 = this.d;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.h = -f2;
            a();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            boolean z = false;
            GLES20.glViewport(0, 0, i2, i3);
            float f2 = ((float) i2) / ((float) i3);
            if (f2 > 1.0f) {
                z = true;
            }
            Matrix.perspectiveM(this.b, 0, z ? (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f2))) * 2.0d) : 90.0f, f2, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalGLSurfaceView sphericalGLSurfaceView = SphericalGLSurfaceView.this;
            sphericalGLSurfaceView.d.post(new c(sphericalGLSurfaceView, this.a.a()));
        }
    }

    public SphericalGLSurfaceView(Context context) {
        this(context, null);
    }

    public final void a() {
        boolean z = this.j && this.k;
        Sensor sensor = this.b;
        if (sensor != null && z != this.l) {
            if (z) {
                this.a.registerListener(this.c, sensor, 0);
            } else {
                this.a.unregisterListener(this.c);
            }
            this.l = z;
        }
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d.post(new Runnable() { // from class: a2.j.b.b.c1.m0.b
            @Override // java.lang.Runnable
            public final void run() {
                SphericalGLSurfaceView sphericalGLSurfaceView = SphericalGLSurfaceView.this;
                Surface surface = sphericalGLSurfaceView.h;
                if (surface != null) {
                    Player.VideoComponent videoComponent = sphericalGLSurfaceView.i;
                    if (videoComponent != null) {
                        videoComponent.clearVideoSurface(surface);
                    }
                    SurfaceTexture surfaceTexture = sphericalGLSurfaceView.g;
                    Surface surface2 = sphericalGLSurfaceView.h;
                    if (surfaceTexture != null) {
                        surfaceTexture.release();
                    }
                    if (surface2 != null) {
                        surface2.release();
                    }
                    sphericalGLSurfaceView.g = null;
                    sphericalGLSurfaceView.h = null;
                }
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.k = false;
        a();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.k = true;
        a();
    }

    public void setDefaultStereoMode(int i2) {
        this.f.k = i2;
    }

    public void setSingleTapListener(@Nullable SingleTapListener singleTapListener) {
        this.e.g = singleTapListener;
    }

    public void setUseSensorRotation(boolean z) {
        this.j = z;
        a();
    }

    public void setVideoComponent(@Nullable Player.VideoComponent videoComponent) {
        Player.VideoComponent videoComponent2 = this.i;
        if (videoComponent != videoComponent2) {
            if (videoComponent2 != null) {
                Surface surface = this.h;
                if (surface != null) {
                    videoComponent2.clearVideoSurface(surface);
                }
                this.i.clearVideoFrameMetadataListener(this.f);
                this.i.clearCameraMotionListener(this.f);
            }
            this.i = videoComponent;
            if (videoComponent != null) {
                videoComponent.setVideoFrameMetadataListener(this.f);
                this.i.setCameraMotionListener(this.f);
                this.i.setVideoSurface(this.h);
            }
        }
    }

    public SphericalGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) Assertions.checkNotNull(context.getSystemService("sensor"));
        this.a = sensorManager;
        Sensor defaultSensor = Util.SDK_INT >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.b = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        e eVar = new e();
        this.f = eVar;
        a aVar = new a(eVar);
        f fVar = new f(context, aVar, 25.0f);
        this.e = fVar;
        this.c = new OrientationListener(((WindowManager) Assertions.checkNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), fVar, aVar);
        this.j = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(fVar);
    }
}
