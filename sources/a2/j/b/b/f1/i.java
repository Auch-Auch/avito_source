package a2.j.b.b.f1;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import androidx.work.Data;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.video.VideoDecoderOutputBuffer;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.sumsub.sns.R2;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
public class i implements GLSurfaceView.Renderer, VideoDecoderOutputBufferRenderer {
    public static final float[] k = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
    public static final float[] l = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};
    public static final float[] m = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};
    public static final String[] n = {"y_tex", "u_tex", "v_tex"};
    public static final FloatBuffer o = GlUtil.createBuffer(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
    public final GLSurfaceView a;
    public final int[] b = new int[3];
    public final AtomicReference<VideoDecoderOutputBuffer> c;
    public FloatBuffer[] d;
    public int e;
    public int[] f;
    public int g;
    public int[] h;
    public int[] i;
    public VideoDecoderOutputBuffer j;

    public i(GLSurfaceView gLSurfaceView) {
        this.a = gLSurfaceView;
        this.c = new AtomicReference<>();
        this.d = new FloatBuffer[3];
        this.f = new int[3];
        this.h = new int[3];
        this.i = new int[3];
        for (int i2 = 0; i2 < 3; i2++) {
            int[] iArr = this.h;
            this.i[i2] = -1;
            iArr[i2] = -1;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        VideoDecoderOutputBuffer andSet = this.c.getAndSet(null);
        if (!(andSet == null && this.j == null)) {
            if (andSet != null) {
                VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.j;
                if (videoDecoderOutputBuffer != null) {
                    videoDecoderOutputBuffer.release();
                }
                this.j = andSet;
            }
            VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = (VideoDecoderOutputBuffer) Assertions.checkNotNull(this.j);
            float[] fArr = l;
            int i2 = videoDecoderOutputBuffer2.colorspace;
            if (i2 == 1) {
                fArr = k;
            } else if (i2 == 3) {
                fArr = m;
            }
            GLES20.glUniformMatrix3fv(this.g, 1, false, fArr, 0);
            int[] iArr = (int[]) Assertions.checkNotNull(videoDecoderOutputBuffer2.yuvStrides);
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) Assertions.checkNotNull(videoDecoderOutputBuffer2.yuvPlanes);
            int i3 = 0;
            while (i3 < 3) {
                int i4 = i3 == 0 ? videoDecoderOutputBuffer2.height : (videoDecoderOutputBuffer2.height + 1) / 2;
                GLES20.glActiveTexture(33984 + i3);
                GLES20.glBindTexture(3553, this.b[i3]);
                GLES20.glPixelStorei(3317, 1);
                GLES20.glTexImage2D(3553, 0, 6409, iArr[i3], i4, 0, 6409, R2.styleable.MockView_mock_labelColor, byteBufferArr[i3]);
                i3++;
            }
            int[] iArr2 = new int[3];
            iArr2[0] = videoDecoderOutputBuffer2.width;
            int i5 = (iArr2[0] + 1) / 2;
            iArr2[2] = i5;
            iArr2[1] = i5;
            for (int i6 = 0; i6 < 3; i6++) {
                if (this.h[i6] != iArr2[i6] || this.i[i6] != iArr[i6]) {
                    Assertions.checkState(iArr[i6] != 0);
                    float f2 = ((float) iArr2[i6]) / ((float) iArr[i6]);
                    this.d[i6] = GlUtil.createBuffer(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f2, 0.0f, f2, 1.0f});
                    GLES20.glVertexAttribPointer(this.f[i6], 2, (int) R2.styleable.Motion_motionPathRotate, false, 0, (Buffer) this.d[i6]);
                    this.h[i6] = iArr2[i6];
                    this.i[i6] = iArr[i6];
                }
            }
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, 0, 4);
            GlUtil.checkGlError();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        GLES20.glViewport(0, 0, i2, i3);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int compileProgram = GlUtil.compileProgram("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
        this.e = compileProgram;
        GLES20.glUseProgram(compileProgram);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.e, "in_pos");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, (int) R2.styleable.Motion_motionPathRotate, false, 0, (Buffer) o);
        this.f[0] = GLES20.glGetAttribLocation(this.e, "in_tc_y");
        GLES20.glEnableVertexAttribArray(this.f[0]);
        this.f[1] = GLES20.glGetAttribLocation(this.e, "in_tc_u");
        GLES20.glEnableVertexAttribArray(this.f[1]);
        this.f[2] = GLES20.glGetAttribLocation(this.e, "in_tc_v");
        GLES20.glEnableVertexAttribArray(this.f[2]);
        GlUtil.checkGlError();
        this.g = GLES20.glGetUniformLocation(this.e, "mColorConversion");
        GlUtil.checkGlError();
        GLES20.glGenTextures(3, this.b, 0);
        for (int i2 = 0; i2 < 3; i2++) {
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.e, n[i2]), i2);
            GLES20.glActiveTexture(33984 + i2);
            GLES20.glBindTexture(3553, this.b[i2]);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, Data.MAX_DATA_BYTES, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
        }
        GlUtil.checkGlError();
        GlUtil.checkGlError();
    }

    @Override // com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer
    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        VideoDecoderOutputBuffer andSet = this.c.getAndSet(videoDecoderOutputBuffer);
        if (andSet != null) {
            andSet.release();
        }
        this.a.requestRender();
    }
}
