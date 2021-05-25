package a2.t.a.c.n0;

import android.os.Handler;
import android.os.Looper;
import com.voximplant.sdk.call.RenderScaleType;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.hardware.VoxCameraManager;
import java.util.Objects;
import org.webrtc.EglBase;
import org.webrtc.RendererCommon;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoSink;
import org.webrtc.VideoTrack;
public final /* synthetic */ class m1 implements Runnable {
    public final /* synthetic */ h2 a;
    public final /* synthetic */ VideoSink b;
    public final /* synthetic */ RendererCommon.RendererEvents c;
    public final /* synthetic */ RenderScaleType d;

    public /* synthetic */ m1(h2 h2Var, VideoSink videoSink, RendererCommon.RendererEvents rendererEvents, RenderScaleType renderScaleType) {
        this.a = h2Var;
        this.b = videoSink;
        this.c = rendererEvents;
        this.d = renderScaleType;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h2 h2Var = this.a;
        VideoSink videoSink = this.b;
        RendererCommon.RendererEvents rendererEvents = this.c;
        RenderScaleType renderScaleType = this.d;
        if (h2Var.b.contains(videoSink)) {
            Logger.e(h2Var.f() + "addVideoRenderer: viewRenderer = " + videoSink + "is already added");
            return;
        }
        try {
            if (videoSink instanceof SurfaceViewRenderer) {
                new Handler(Looper.getMainLooper()).post(new Runnable(videoSink, rendererEvents, renderScaleType) { // from class: a2.t.a.c.n0.o1
                    public final /* synthetic */ VideoSink b;
                    public final /* synthetic */ RendererCommon.RendererEvents c;
                    public final /* synthetic */ RenderScaleType d;

                    {
                        this.b = r2;
                        this.c = r3;
                        this.d = r4;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        StringBuilder sb;
                        SurfaceViewRenderer surfaceViewRenderer;
                        h2 h2Var2 = h2.this;
                        VideoSink videoSink2 = this.b;
                        RendererCommon.RendererEvents rendererEvents2 = this.c;
                        RenderScaleType renderScaleType2 = this.d;
                        Objects.requireNonNull(h2Var2);
                        try {
                            EglBase eglBase = h2Var2.c;
                            if (eglBase == null) {
                                Logger.w(h2Var2.f() + "addVideoRenderer: eglBase is invalid");
                                ((SurfaceViewRenderer) videoSink2).init(null, rendererEvents2);
                            } else {
                                ((SurfaceViewRenderer) videoSink2).init(eglBase.getEglBaseContext(), rendererEvents2);
                            }
                            surfaceViewRenderer = (SurfaceViewRenderer) videoSink2;
                            surfaceViewRenderer.setScalingType(h2Var2.c(renderScaleType2));
                            if (h2Var2.f && h2Var2.h && VoxCameraManager.getInstance(h2Var2.g).getCameraIndex() == 1) {
                                sb = new StringBuilder();
                                sb.append(h2Var2.f());
                                sb.append("addVideoRenderer: set mirror: true");
                                Logger.i(sb.toString());
                                surfaceViewRenderer.setMirror(true);
                            }
                        } catch (RuntimeException unused) {
                            try {
                                ((SurfaceViewRenderer) videoSink2).release();
                                EglBase eglBase2 = h2Var2.c;
                                if (eglBase2 == null) {
                                    Logger.w(h2Var2.f() + "addVideoRenderer: eglBase is invalid");
                                    ((SurfaceViewRenderer) videoSink2).init(null, rendererEvents2);
                                } else {
                                    ((SurfaceViewRenderer) videoSink2).init(eglBase2.getEglBaseContext(), rendererEvents2);
                                }
                            } catch (RuntimeException unused2) {
                                Logger.e(h2Var2.f() + "addVideoRenderer: failed to init SurfaceViewRenderer");
                            } catch (Throwable th) {
                                SurfaceViewRenderer surfaceViewRenderer2 = (SurfaceViewRenderer) videoSink2;
                                surfaceViewRenderer2.setScalingType(h2Var2.c(renderScaleType2));
                                if (h2Var2.f && h2Var2.h && VoxCameraManager.getInstance(h2Var2.g).getCameraIndex() == 1) {
                                    Logger.i(h2Var2.f() + "addVideoRenderer: set mirror: true");
                                    surfaceViewRenderer2.setMirror(true);
                                }
                                throw th;
                            }
                            surfaceViewRenderer = (SurfaceViewRenderer) videoSink2;
                            surfaceViewRenderer.setScalingType(h2Var2.c(renderScaleType2));
                            if (h2Var2.f && h2Var2.h && VoxCameraManager.getInstance(h2Var2.g).getCameraIndex() == 1) {
                                sb = new StringBuilder();
                            }
                        }
                    }
                });
            }
        } finally {
            h2Var.b.add(videoSink);
            VideoTrack videoTrack = h2Var.a;
            if (videoTrack != null) {
                videoTrack.addSink(videoSink);
            }
        }
    }
}
