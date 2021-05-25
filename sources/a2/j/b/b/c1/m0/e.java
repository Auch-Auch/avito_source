package a2.j.b.b.c1.m0;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.android.exoplayer2.video.spherical.FrameRotationQueue;
import com.google.android.exoplayer2.video.spherical.Projection;
import com.google.android.exoplayer2.video.spherical.ProjectionDecoder;
import com.otaliastudios.cameraview.filter.BaseFilter;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
public final class e implements VideoFrameMetadataListener, CameraMotionListener {
    public final AtomicBoolean a = new AtomicBoolean();
    public final AtomicBoolean b = new AtomicBoolean(true);
    public final d c = new d();
    public final FrameRotationQueue d = new FrameRotationQueue();
    public final TimedValueQueue<Long> e = new TimedValueQueue<>();
    public final TimedValueQueue<Projection> f = new TimedValueQueue<>();
    public final float[] g = new float[16];
    public final float[] h = new float[16];
    public int i;
    public SurfaceTexture j;
    public volatile int k = 0;
    public int l = -1;
    @Nullable
    public byte[] m;

    public SurfaceTexture a() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        GlUtil.checkGlError();
        d dVar = this.c;
        Objects.requireNonNull(dVar);
        int compileProgram = GlUtil.compileProgram(d.j, d.k);
        dVar.d = compileProgram;
        dVar.e = GLES20.glGetUniformLocation(compileProgram, "uMvpMatrix");
        dVar.f = GLES20.glGetUniformLocation(dVar.d, BaseFilter.DEFAULT_VERTEX_TRANSFORM_MATRIX_NAME);
        dVar.g = GLES20.glGetAttribLocation(dVar.d, BaseFilter.DEFAULT_VERTEX_POSITION_NAME);
        dVar.h = GLES20.glGetAttribLocation(dVar.d, "aTexCoords");
        dVar.i = GLES20.glGetUniformLocation(dVar.d, "uTexture");
        GlUtil.checkGlError();
        this.i = GlUtil.createExternalTexture();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.i);
        this.j = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: a2.j.b.b.c1.m0.a
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                e.this.a.set(true);
            }
        });
        return this.j;
    }

    @Override // com.google.android.exoplayer2.video.spherical.CameraMotionListener
    public void onCameraMotion(long j2, float[] fArr) {
        this.d.setRotation(j2, fArr);
    }

    @Override // com.google.android.exoplayer2.video.spherical.CameraMotionListener
    public void onCameraMotionReset() {
        this.e.clear();
        this.d.reset();
        this.b.set(true);
    }

    @Override // com.google.android.exoplayer2.video.VideoFrameMetadataListener
    public void onVideoFrameAboutToBeRendered(long j2, long j3, Format format, @Nullable MediaFormat mediaFormat) {
        this.e.add(j3, Long.valueOf(j2));
        byte[] bArr = format.projectionData;
        int i2 = format.stereoMode;
        byte[] bArr2 = this.m;
        int i3 = this.l;
        this.m = bArr;
        if (i2 == -1) {
            i2 = this.k;
        }
        this.l = i2;
        if (i3 != i2 || !Arrays.equals(bArr2, this.m)) {
            Projection projection = null;
            byte[] bArr3 = this.m;
            if (bArr3 != null) {
                projection = ProjectionDecoder.decode(bArr3, this.l);
            }
            if (projection == null || !d.a(projection)) {
                projection = Projection.createEquirectangular(this.l);
            }
            this.f.add(j3, projection);
        }
    }
}
