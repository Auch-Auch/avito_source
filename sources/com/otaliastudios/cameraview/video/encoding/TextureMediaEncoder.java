package com.otaliastudios.cameraview.video.encoding;

import a2.m.a.d.a.k;
import android.opengl.Matrix;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.internal.GlTextureDrawer;
import com.otaliastudios.cameraview.internal.Pool;
import com.otaliastudios.cameraview.overlay.OverlayDrawer;
import com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine;
import com.otaliastudios.opengl.core.EglCore;
import com.otaliastudios.opengl.surface.EglWindowSurface;
@RequiresApi(api = 18)
public class TextureMediaEncoder extends k<TextureConfig> {
    public static final String FILTER_EVENT = "filter";
    public static final String FRAME_EVENT = "frame";
    public static final CameraLogger x = CameraLogger.create(TextureMediaEncoder.class.getSimpleName());
    public int r;
    public EglCore s;
    public EglWindowSurface t;
    public GlTextureDrawer u;
    public Pool<Frame> v = new Pool<>(Integer.MAX_VALUE, new a(this));
    public long w = Long.MIN_VALUE;

    public class a implements Pool.Factory<Frame> {
        public a(TextureMediaEncoder textureMediaEncoder) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.otaliastudios.cameraview.internal.Pool.Factory
        public Frame create() {
            return new Frame(null);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextureMediaEncoder(@androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.TextureConfig r3) {
        /*
            r2 = this;
            java.util.Objects.requireNonNull(r3)
            com.otaliastudios.cameraview.video.encoding.TextureConfig r0 = new com.otaliastudios.cameraview.video.encoding.TextureConfig
            r0.<init>()
            r3.copy(r0)
            int r1 = r3.textureId
            r0.textureId = r1
            com.otaliastudios.cameraview.overlay.OverlayDrawer r1 = r3.overlayDrawer
            r0.overlayDrawer = r1
            com.otaliastudios.cameraview.overlay.Overlay$Target r1 = r3.overlayTarget
            r0.overlayTarget = r1
            int r1 = r3.overlayRotation
            r0.overlayRotation = r1
            float r1 = r3.scaleX
            r0.scaleX = r1
            float r1 = r3.scaleY
            r0.scaleY = r1
            android.opengl.EGLContext r3 = r3.eglContext
            r0.eglContext = r3
            r2.<init>(r0)
            com.otaliastudios.cameraview.internal.Pool r3 = new com.otaliastudios.cameraview.internal.Pool
            r0 = 2147483647(0x7fffffff, float:NaN)
            com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder$a r1 = new com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder$a
            r1.<init>(r2)
            r3.<init>(r0, r1)
            r2.v = r3
            r0 = -9223372036854775808
            r2.w = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.<init>(com.otaliastudios.cameraview.video.encoding.TextureConfig):void");
    }

    @NonNull
    public Frame acquireFrame() {
        if (!this.v.isEmpty()) {
            return this.v.get();
        }
        throw new RuntimeException("Need more frames than this! Please increase the pool size.");
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    @EncoderThread
    public void onEvent(@NonNull String str, @Nullable Object obj) {
        str.hashCode();
        if (str.equals("filter")) {
            this.u.setFilter((Filter) obj);
        } else if (str.equals(FRAME_EVENT)) {
            Frame frame = (Frame) obj;
            if (!shouldRenderFrame(frame.timestampNanos / 1000)) {
                this.v.recycle(frame);
                return;
            }
            if (this.mFrameNumber == 1) {
                notifyFirstFrameMillis(frame.timestampMillis);
            }
            if (this.w == Long.MIN_VALUE) {
                this.w = frame.timestampNanos / 1000;
            }
            if (!hasReachedMaxLength()) {
                if ((frame.timestampNanos / 1000) - this.w > getMaxLengthUs()) {
                    x.w("onEvent -", "frameNumber:", Integer.valueOf(this.mFrameNumber), "timestampUs:", Long.valueOf(frame.timestampNanos / 1000), "firstTimeUs:", Long.valueOf(this.w), "- reached max length! deltaUs:", Long.valueOf((frame.timestampNanos / 1000) - this.w));
                    notifyMaxLengthReached();
                }
            }
            CameraLogger cameraLogger = x;
            cameraLogger.i("onEvent -", "frameNumber:", Integer.valueOf(this.mFrameNumber), "timestampUs:", Long.valueOf(frame.timestampNanos / 1000), "hasReachedMaxLength:", Boolean.valueOf(hasReachedMaxLength()), "thread:", Thread.currentThread(), "- draining.");
            drainOutput(false);
            cameraLogger.i("onEvent -", "frameNumber:", Integer.valueOf(this.mFrameNumber), "timestampUs:", Long.valueOf(frame.timestampNanos / 1000), "hasReachedMaxLength:", Boolean.valueOf(hasReachedMaxLength()), "thread:", Thread.currentThread(), "- drawing.");
            float[] fArr = frame.transform;
            TextureConfig textureConfig = (TextureConfig) this.mConfig;
            float f = textureConfig.scaleX;
            float f2 = textureConfig.scaleY;
            Matrix.translateM(fArr, 0, (1.0f - f) / 2.0f, (1.0f - f2) / 2.0f, 0.0f);
            Matrix.scaleM(fArr, 0, f, f2, 1.0f);
            Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
            Matrix.rotateM(fArr, 0, (float) this.r, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
            TextureConfig textureConfig2 = (TextureConfig) this.mConfig;
            OverlayDrawer overlayDrawer = textureConfig2.overlayDrawer;
            if (overlayDrawer != null) {
                overlayDrawer.draw(textureConfig2.overlayTarget);
                Matrix.translateM(((TextureConfig) this.mConfig).overlayDrawer.getTransform(), 0, 0.5f, 0.5f, 0.0f);
                Matrix.rotateM(((TextureConfig) this.mConfig).overlayDrawer.getTransform(), 0, (float) ((TextureConfig) this.mConfig).overlayRotation, 0.0f, 0.0f, 1.0f);
                Matrix.translateM(((TextureConfig) this.mConfig).overlayDrawer.getTransform(), 0, -0.5f, -0.5f, 0.0f);
            }
            cameraLogger.i("onEvent -", "frameNumber:", Integer.valueOf(this.mFrameNumber), "timestampUs:", Long.valueOf(frame.timestampNanos / 1000), "hasReachedMaxLength:", Boolean.valueOf(hasReachedMaxLength()), "thread:", Thread.currentThread(), "- gl rendering.");
            this.u.setTextureTransform(fArr);
            this.u.draw(frame.timestampNanos / 1000);
            OverlayDrawer overlayDrawer2 = ((TextureConfig) this.mConfig).overlayDrawer;
            if (overlayDrawer2 != null) {
                overlayDrawer2.render(frame.timestampNanos / 1000);
            }
            this.t.setPresentationTime(frame.timestampNanos);
            this.t.swapBuffers();
            this.v.recycle(frame);
            cameraLogger.i("onEvent -", "frameNumber:", Integer.valueOf(this.mFrameNumber), "timestampUs:", Long.valueOf(frame.timestampNanos / 1000), "hasReachedMaxLength:", Boolean.valueOf(hasReachedMaxLength()), "thread:", Thread.currentThread(), "- gl rendered.");
        }
    }

    @Override // a2.m.a.d.a.k, com.otaliastudios.cameraview.video.encoding.MediaEncoder
    @EncoderThread
    public void onPrepare(@NonNull MediaEncoderEngine.Controller controller, long j) {
        C c = this.mConfig;
        this.r = ((TextureConfig) c).rotation;
        ((TextureConfig) c).rotation = 0;
        super.onPrepare(controller, j);
        this.s = new EglCore(((TextureConfig) this.mConfig).eglContext, 1);
        EglWindowSurface eglWindowSurface = new EglWindowSurface(this.s, this.mSurface, true);
        this.t = eglWindowSurface;
        eglWindowSurface.makeCurrent();
        this.u = new GlTextureDrawer(((TextureConfig) this.mConfig).textureId);
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    public void onStopped() {
        super.onStopped();
        this.v.clear();
        EglWindowSurface eglWindowSurface = this.t;
        if (eglWindowSurface != null) {
            eglWindowSurface.release();
            this.t = null;
        }
        GlTextureDrawer glTextureDrawer = this.u;
        if (glTextureDrawer != null) {
            glTextureDrawer.release();
            this.u = null;
        }
        EglCore eglCore = this.s;
        if (eglCore != null) {
            eglCore.release$egloo_metadata_release();
            this.s = null;
        }
    }

    @Override // a2.m.a.d.a.k
    public boolean shouldRenderFrame(long j) {
        if (!super.shouldRenderFrame(j)) {
            x.i("shouldRenderFrame - Dropping frame because of super()");
            return false;
        } else if (this.mFrameNumber <= 10 || getPendingEvents(FRAME_EVENT) <= 2) {
            return true;
        } else {
            x.i("shouldRenderFrame - Dropping, we already have too many pending events:", Integer.valueOf(getPendingEvents(FRAME_EVENT)));
            return false;
        }
    }

    public static class Frame {
        public long timestampMillis;
        public long timestampNanos;
        public float[] transform;

        public Frame() {
            this.transform = new float[16];
        }

        public Frame(a aVar) {
            this.transform = new float[16];
        }
    }
}
