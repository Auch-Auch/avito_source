package a2.t.a.c.n0;

import a2.b.a.a.a;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.voximplant.sdk.call.IVideoStream;
import com.voximplant.sdk.call.RenderScaleType;
import com.voximplant.sdk.call.VideoStreamType;
import com.voximplant.sdk.hardware.ICameraEventsListener;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.hardware.CustomVideoSource;
import com.voximplant.sdk.internal.hardware.VoxCameraManager;
import com.voximplant.sdk.internal.hardware.VoxScreenCapturer;
import com.voximplant.sdk.internal.utils.VoxExecutor;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.webrtc.EglBase;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.RendererCommon;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoSink;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;
public class h2 implements IVideoStream, ICameraEventsListener {
    public VideoTrack a = null;
    public CopyOnWriteArrayList<VideoSink> b = new CopyOnWriteArrayList<>();
    public EglBase c;
    public VoxExecutor d = VoxExecutor.getInstance();
    public String e = null;
    public final boolean f;
    public Context g;
    public boolean h;
    public VideoStreamType i;
    public CustomVideoSource j;
    public boolean k;

    public h2(EglBase eglBase, Context context, boolean z, boolean z2) {
        this.c = eglBase;
        this.g = context;
        this.f = z;
        this.h = z2;
        this.i = VideoStreamType.VIDEO;
        this.k = true;
        if (z) {
            VoxCameraManager.getInstance(context).addCameraEventsListener(this);
        }
    }

    public final void a(VideoSink videoSink) {
        VideoTrack videoTrack = this.a;
        if (videoTrack != null) {
            videoTrack.addSink(videoSink);
        }
    }

    @Override // com.voximplant.sdk.call.IVideoStream
    public void addVideoRenderer(VideoSink videoSink, RenderScaleType renderScaleType) {
        Logger.i(f() + "addVideoRenderer: " + videoSink + ", scale type = " + renderScaleType);
        Logger.i(f() + "addVideoRenderer: " + videoSink + ", scale type = " + renderScaleType + ", renderEventsListener = " + ((Object) null));
        if (videoSink == null) {
            Logger.e(f() + "addVideoRenderer: viewRenderer is null");
            return;
        }
        this.d.smRun(new m1(this, videoSink, null, renderScaleType));
    }

    public void b() {
        Logger.i(f() + "close");
        this.k = false;
        if (this.f) {
            VideoTrack videoTrack = this.a;
            if (videoTrack != null) {
                videoTrack.setEnabled(false);
            }
            if (this.i == VideoStreamType.VIDEO) {
                VoxCameraManager.getInstance(this.g).removeCameraEventsListener(this);
                CustomVideoSource customVideoSource = this.j;
                if (customVideoSource != null) {
                    customVideoSource.close(true);
                } else {
                    VoxCameraManager.getInstance(this.g).releaseCameraVideoSource();
                }
            }
            if (this.i == VideoStreamType.SCREEN_SHARING) {
                VoxScreenCapturer.getInstance().stopCapture();
            }
        }
        if (!this.b.isEmpty()) {
            Iterator<VideoSink> it = this.b.iterator();
            while (it.hasNext()) {
                removeVideoRenderer(it.next());
            }
        }
        this.a = null;
        this.c = null;
    }

    public final RendererCommon.ScalingType c(RenderScaleType renderScaleType) {
        if (renderScaleType.ordinal() != 0) {
            return RendererCommon.ScalingType.SCALE_ASPECT_FIT;
        }
        return RendererCommon.ScalingType.SCALE_ASPECT_FILL;
    }

    public final void d(String str, boolean z, PeerConnectionFactory peerConnectionFactory) {
        if (str == null || str.isEmpty()) {
            str = UUID.randomUUID().toString();
        }
        if (z) {
            Logger.i("VideoStream: createVideoTrack: creating track for screen sharing");
            this.a = peerConnectionFactory.createVideoTrack(str, VoxScreenCapturer.getInstance().getScreenSharingVideoSource(peerConnectionFactory, this.c));
        } else if (this.j == null) {
            Logger.i("VideoStream: custom video source is not set, using camera");
            VideoSource cameraVideoSource = VoxCameraManager.getInstance(this.g).getCameraVideoSource(peerConnectionFactory, this.c);
            if (cameraVideoSource != null) {
                this.a = peerConnectionFactory.createVideoTrack(str, cameraVideoSource);
            } else {
                Logger.e("VideoStream: failed to create video track: camera video source in not available");
            }
        } else {
            StringBuilder L = a.L("VideoStream: custom video source: ");
            L.append(this.j);
            Logger.i(L.toString());
            this.a = peerConnectionFactory.createVideoTrack(str, this.j.getVideoSource(peerConnectionFactory, this.c, this.g));
        }
        VideoTrack videoTrack = this.a;
        if (videoTrack != null) {
            this.e = videoTrack.id();
        }
    }

    public boolean e() {
        return this.k;
    }

    public final String f() {
        StringBuilder L = a.L("VideoStream[");
        L.append(this.e);
        L.append(",");
        L.append(this.i);
        L.append(this.k ? ",ACTIVE]:" : ",INACTIVE]:");
        return L.toString();
    }

    @Override // com.voximplant.sdk.call.IVideoStream
    public String getVideoStreamId() {
        return this.e;
    }

    @Override // com.voximplant.sdk.call.IVideoStream
    public VideoStreamType getVideoStreamType() {
        return this.i;
    }

    @Override // com.voximplant.sdk.hardware.ICameraEventsListener
    public void onCameraDisconnected() {
    }

    @Override // com.voximplant.sdk.hardware.ICameraEventsListener
    public void onCameraError(String str) {
    }

    @Override // com.voximplant.sdk.hardware.ICameraEventsListener
    public void onCameraSwitchDone(boolean z) {
        if (this.f && this.h) {
            Iterator<VideoSink> it = this.b.iterator();
            while (it.hasNext()) {
                VideoSink next = it.next();
                if (next instanceof SurfaceViewRenderer) {
                    if (z) {
                        Logger.i(f() + "onCameraSwitchDone: set mirror: true");
                        ((SurfaceViewRenderer) next).setMirror(true);
                    } else {
                        Logger.i(f() + "onCameraSwitchDone: set mirror: false");
                        ((SurfaceViewRenderer) next).setMirror(false);
                    }
                }
            }
        }
    }

    @Override // com.voximplant.sdk.hardware.ICameraEventsListener
    public void onCameraSwitchError(String str) {
    }

    @Override // com.voximplant.sdk.call.IVideoStream
    public void removeVideoRenderer(VideoSink videoSink) {
        Logger.i(f() + "removeVideoRenderer: " + videoSink);
        if (videoSink == null) {
            Logger.e(f() + "removeViewRenderer: viewRenderer is null");
            return;
        }
        this.d.smRun(new Runnable(videoSink) { // from class: a2.t.a.c.n0.n1
            public final /* synthetic */ VideoSink b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                h2 h2Var = h2.this;
                VideoSink videoSink2 = this.b;
                if (h2Var.b.contains(videoSink2)) {
                    if (videoSink2 instanceof SurfaceViewRenderer) {
                        SurfaceViewRenderer surfaceViewRenderer = (SurfaceViewRenderer) videoSink2;
                        surfaceViewRenderer.clearImage();
                        new Handler(Looper.getMainLooper()).post(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0024: INVOKE  
                              (wrap: android.os.Handler : 0x001c: CONSTRUCTOR  (r3v0 android.os.Handler) = 
                              (wrap: android.os.Looper : 0x0018: INVOKE  (r4v0 android.os.Looper) =  type: STATIC call: android.os.Looper.getMainLooper():android.os.Looper)
                             call: android.os.Handler.<init>(android.os.Looper):void type: CONSTRUCTOR)
                              (wrap: a2.t.a.c.n0.q1 : 0x0021: CONSTRUCTOR  (r4v1 a2.t.a.c.n0.q1) = (r2v5 'surfaceViewRenderer' org.webrtc.SurfaceViewRenderer) call: a2.t.a.c.n0.q1.<init>(org.webrtc.SurfaceViewRenderer):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: a2.t.a.c.n0.n1.run():void, file: classes8.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0021: CONSTRUCTOR  (r4v1 a2.t.a.c.n0.q1) = (r2v5 'surfaceViewRenderer' org.webrtc.SurfaceViewRenderer) call: a2.t.a.c.n0.q1.<init>(org.webrtc.SurfaceViewRenderer):void type: CONSTRUCTOR in method: a2.t.a.c.n0.n1.run():void, file: classes8.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                            	... 29 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.n0.q1, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                            	... 35 more
                            */
                        /*
                            this = this;
                            a2.t.a.c.n0.h2 r0 = a2.t.a.c.n0.h2.this
                            org.webrtc.VideoSink r1 = r5.b
                            java.util.concurrent.CopyOnWriteArrayList<org.webrtc.VideoSink> r2 = r0.b
                            boolean r2 = r2.contains(r1)
                            if (r2 == 0) goto L_0x0036
                            boolean r2 = r1 instanceof org.webrtc.SurfaceViewRenderer
                            if (r2 == 0) goto L_0x0027
                            r2 = r1
                            org.webrtc.SurfaceViewRenderer r2 = (org.webrtc.SurfaceViewRenderer) r2
                            r2.clearImage()
                            android.os.Handler r3 = new android.os.Handler
                            android.os.Looper r4 = android.os.Looper.getMainLooper()
                            r3.<init>(r4)
                            a2.t.a.c.n0.q1 r4 = new a2.t.a.c.n0.q1
                            r4.<init>(r2)
                            r3.post(r4)
                        L_0x0027:
                            java.util.concurrent.CopyOnWriteArrayList<org.webrtc.VideoSink> r2 = r0.b
                            r2.remove(r1)
                            org.webrtc.VideoTrack r0 = r0.a
                            if (r0 == 0) goto L_0x004e
                            if (r1 == 0) goto L_0x004e
                            r0.removeSink(r1)
                            goto L_0x004e
                        L_0x0036:
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                            r1.<init>()
                            java.lang.String r0 = r0.f()
                            r1.append(r0)
                            java.lang.String r0 = "failed to remove video renderer"
                            r1.append(r0)
                            java.lang.String r0 = r1.toString()
                            com.voximplant.sdk.internal.Logger.e(r0)
                        L_0x004e:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.n0.n1.run():void");
                    }
                });
            }

            public String toString() {
                StringBuilder L = a.L("VideoStream: ");
                L.append(this.e);
                return L.toString();
            }

            @Override // com.voximplant.sdk.call.IVideoStream
            public void addVideoRenderer(VideoSink videoSink, RenderScaleType renderScaleType, RendererCommon.RendererEvents rendererEvents) {
                Logger.i(f() + "addVideoRenderer: " + videoSink + ", scale type = " + renderScaleType + ", renderEventsListener = " + rendererEvents);
                if (videoSink == null) {
                    Logger.e(f() + "addVideoRenderer: viewRenderer is null");
                    return;
                }
                this.d.smRun(new m1(this, videoSink, rendererEvents, renderScaleType));
            }

            public h2(PeerConnectionFactory peerConnectionFactory, CustomVideoSource customVideoSource, EglBase eglBase, Context context, boolean z, String str) {
                this.c = eglBase;
                this.g = context;
                this.f = true;
                this.h = z;
                this.i = VideoStreamType.VIDEO;
                this.j = customVideoSource;
                d(str, false, peerConnectionFactory);
                this.k = true;
                this.a.setEnabled(true);
                VoxCameraManager.getInstance(this.g).addCameraEventsListener(this);
            }

            public h2(PeerConnectionFactory peerConnectionFactory, String str, EglBase eglBase) {
                this.c = eglBase;
                this.f = true;
                this.i = VideoStreamType.SCREEN_SHARING;
                d(str, true, peerConnectionFactory);
                this.k = true;
                this.a.setEnabled(true);
            }
        }
