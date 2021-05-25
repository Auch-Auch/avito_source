package org.webrtc;

import androidx.annotation.Nullable;
import org.webrtc.VideoFrame;
import org.webrtc.VideoProcessor;
import org.webrtc.VideoSource;
import x6.f.u0;
public class VideoSource extends MediaSource {
    private final CapturerObserver capturerObserver = new CapturerObserver() { // from class: org.webrtc.VideoSource.1
        @Override // org.webrtc.CapturerObserver
        public void onCapturerStarted(boolean z) {
            VideoSource.this.nativeAndroidVideoTrackSource.setState(z);
            synchronized (VideoSource.this.videoProcessorLock) {
                VideoSource.this.isCapturerRunning = z;
                if (VideoSource.this.videoProcessor != null) {
                    VideoSource.this.videoProcessor.onCapturerStarted(z);
                }
            }
        }

        @Override // org.webrtc.CapturerObserver
        public void onCapturerStopped() {
            VideoSource.this.nativeAndroidVideoTrackSource.setState(false);
            synchronized (VideoSource.this.videoProcessorLock) {
                VideoSource.this.isCapturerRunning = false;
                if (VideoSource.this.videoProcessor != null) {
                    VideoSource.this.videoProcessor.onCapturerStopped();
                }
            }
        }

        @Override // org.webrtc.CapturerObserver
        public void onFrameCaptured(VideoFrame videoFrame) {
            VideoProcessor.FrameAdaptationParameters adaptFrame = VideoSource.this.nativeAndroidVideoTrackSource.adaptFrame(videoFrame);
            synchronized (VideoSource.this.videoProcessorLock) {
                if (VideoSource.this.videoProcessor != null) {
                    VideoSource.this.videoProcessor.onFrameCaptured(videoFrame, adaptFrame);
                    return;
                }
            }
            VideoFrame a = u0.a(videoFrame, adaptFrame);
            if (a != null) {
                VideoSource.this.nativeAndroidVideoTrackSource.onFrameCaptured(a);
                a.release();
            }
        }
    };
    private boolean isCapturerRunning;
    private final NativeAndroidVideoTrackSource nativeAndroidVideoTrackSource;
    @Nullable
    private VideoProcessor videoProcessor;
    private final Object videoProcessorLock = new Object();

    public static class AspectRatio {
        public static final AspectRatio UNDEFINED = new AspectRatio(0, 0);
        public final int height;
        public final int width;

        public AspectRatio(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }

    public VideoSource(long j) {
        super(j);
        this.nativeAndroidVideoTrackSource = new NativeAndroidVideoTrackSource(j);
    }

    public /* synthetic */ void a(VideoFrame videoFrame) {
        this.nativeAndroidVideoTrackSource.onFrameCaptured(videoFrame);
    }

    public void adaptOutputFormat(int i, int i2, int i3) {
        int max = Math.max(i, i2);
        int min = Math.min(i, i2);
        adaptOutputFormat(max, min, min, max, i3);
    }

    @Override // org.webrtc.MediaSource
    public void dispose() {
        setVideoProcessor(null);
        super.dispose();
    }

    public CapturerObserver getCapturerObserver() {
        return this.capturerObserver;
    }

    public long getNativeVideoTrackSource() {
        return getNativeMediaSource();
    }

    public void setIsScreencast(boolean z) {
        this.nativeAndroidVideoTrackSource.setIsScreencast(z);
    }

    public void setVideoProcessor(@Nullable VideoProcessor videoProcessor2) {
        synchronized (this.videoProcessorLock) {
            VideoProcessor videoProcessor3 = this.videoProcessor;
            if (videoProcessor3 != null) {
                videoProcessor3.setSink(null);
                if (this.isCapturerRunning) {
                    this.videoProcessor.onCapturerStopped();
                }
            }
            this.videoProcessor = videoProcessor2;
            if (videoProcessor2 != null) {
                videoProcessor2.setSink(new VideoSink() { // from class: x6.f.h0
                    @Override // org.webrtc.VideoSink
                    public final void onFrame(VideoFrame videoFrame) {
                        VideoSource videoSource = VideoSource.this;
                        videoSource.runWithReference(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0007: INVOKE  
                              (r0v0 'videoSource' org.webrtc.VideoSource)
                              (wrap: x6.f.i0 : 0x0004: CONSTRUCTOR  (r1v0 x6.f.i0) = (r0v0 'videoSource' org.webrtc.VideoSource), (r3v0 'videoFrame' org.webrtc.VideoFrame) call: x6.f.i0.<init>(org.webrtc.VideoSource, org.webrtc.VideoFrame):void type: CONSTRUCTOR)
                             type: VIRTUAL call: org.webrtc.MediaSource.runWithReference(java.lang.Runnable):void in method: x6.f.h0.onFrame(org.webrtc.VideoFrame):void, file: classes9.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: CONSTRUCTOR  (r1v0 x6.f.i0) = (r0v0 'videoSource' org.webrtc.VideoSource), (r3v0 'videoFrame' org.webrtc.VideoFrame) call: x6.f.i0.<init>(org.webrtc.VideoSource, org.webrtc.VideoFrame):void type: CONSTRUCTOR in method: x6.f.h0.onFrame(org.webrtc.VideoFrame):void, file: classes9.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                            	... 15 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: x6.f.i0, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                            	... 21 more
                            */
                        /*
                            this = this;
                            org.webrtc.VideoSource r0 = org.webrtc.VideoSource.this
                            x6.f.i0 r1 = new x6.f.i0
                            r1.<init>(r0, r3)
                            r0.runWithReference(r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: x6.f.h0.onFrame(org.webrtc.VideoFrame):void");
                    }
                });
                if (this.isCapturerRunning) {
                    videoProcessor2.onCapturerStarted(true);
                }
            }
        }
    }

    public void adaptOutputFormat(int i, int i2, int i3, int i4, int i5) {
        adaptOutputFormat(new AspectRatio(i, i2), Integer.valueOf(i * i2), new AspectRatio(i3, i4), Integer.valueOf(i3 * i4), Integer.valueOf(i5));
    }

    public void adaptOutputFormat(AspectRatio aspectRatio, @Nullable Integer num, AspectRatio aspectRatio2, @Nullable Integer num2, @Nullable Integer num3) {
        this.nativeAndroidVideoTrackSource.adaptOutputFormat(aspectRatio, num, aspectRatio2, num2, num3);
    }
}
