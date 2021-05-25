package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionRenderer;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
public class DefaultRenderersFactory implements RenderersFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    public static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    public final Context a;
    public int b;
    public long c;
    public boolean d;
    public MediaCodecSelector e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    public DefaultRenderersFactory(Context context) {
        this.a = context;
        this.b = 0;
        this.c = 5000;
        this.e = MediaCodecSelector.DEFAULT;
        this.f = 0;
        this.g = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0061, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0069, code lost:
        throw new java.lang.RuntimeException("Error instantiating Opus extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a2, code lost:
        throw new java.lang.RuntimeException("Error instantiating FLAC extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0061 A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009a A[ExcHandler: Exception (r0v6 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:20:0x006d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildAudioRenderers(android.content.Context r14, int r15, com.google.android.exoplayer2.mediacodec.MediaCodecSelector r16, boolean r17, com.google.android.exoplayer2.audio.AudioSink r18, android.os.Handler r19, com.google.android.exoplayer2.audio.AudioRendererEventListener r20, java.util.ArrayList<com.google.android.exoplayer2.Renderer> r21) {
        /*
        // Method dump skipped, instructions count: 217
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.DefaultRenderersFactory.buildAudioRenderers(android.content.Context, int, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, boolean, com.google.android.exoplayer2.audio.AudioSink, android.os.Handler, com.google.android.exoplayer2.audio.AudioRendererEventListener, java.util.ArrayList):void");
    }

    @Nullable
    public AudioSink buildAudioSink(Context context, boolean z, boolean z2, boolean z3) {
        return new DefaultAudioSink(AudioCapabilities.getCapabilities(context), new DefaultAudioSink.DefaultAudioProcessorChain(new AudioProcessor[0]), z, z2, z3);
    }

    public void buildCameraMotionRenderers(Context context, int i2, ArrayList<Renderer> arrayList) {
        arrayList.add(new CameraMotionRenderer());
    }

    public void buildMetadataRenderers(Context context, MetadataOutput metadataOutput, Looper looper, int i2, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
    }

    public void buildMiscellaneousRenderers(Context context, Handler handler, int i2, ArrayList<Renderer> arrayList) {
    }

    public void buildTextRenderers(Context context, TextOutput textOutput, Looper looper, int i2, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0075, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007d, code lost:
        throw new java.lang.RuntimeException("Error instantiating VP9 extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0075 A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0038] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildVideoRenderers(android.content.Context r15, int r16, com.google.android.exoplayer2.mediacodec.MediaCodecSelector r17, boolean r18, android.os.Handler r19, com.google.android.exoplayer2.video.VideoRendererEventListener r20, long r21, java.util.ArrayList<com.google.android.exoplayer2.Renderer> r23) {
        /*
            r14 = this;
            r0 = r16
            r10 = r23
            java.lang.String r11 = "DefaultRenderersFactory"
            java.lang.Class<com.google.android.exoplayer2.video.VideoRendererEventListener> r12 = com.google.android.exoplayer2.video.VideoRendererEventListener.class
            com.google.android.exoplayer2.video.MediaCodecVideoRenderer r13 = new com.google.android.exoplayer2.video.MediaCodecVideoRenderer
            r9 = 50
            r1 = r13
            r2 = r15
            r3 = r17
            r4 = r21
            r6 = r18
            r7 = r19
            r8 = r20
            r1.<init>(r2, r3, r4, r6, r7, r8, r9)
            r1 = r14
            int r2 = r1.g
            r13.experimentalSetMediaCodecOperationMode(r2)
            r10.add(r13)
            if (r0 != 0) goto L_0x0027
            return
        L_0x0027:
            int r2 = r23.size()
            r3 = 2
            if (r0 != r3) goto L_0x0030
            int r2 = r2 + -1
        L_0x0030:
            r0 = 50
            r4 = 3
            r5 = 0
            r6 = 4
            r7 = 1
            java.lang.String r8 = "com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            java.lang.Class[] r9 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            r9[r5] = r13     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            java.lang.Class<android.os.Handler> r13 = android.os.Handler.class
            r9[r7] = r13     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            r9[r3] = r12     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            java.lang.Class r13 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            r9[r4] = r13     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            java.lang.reflect.Constructor r8 = r8.getConstructor(r9)     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            java.lang.Long r13 = java.lang.Long.valueOf(r21)     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            r9[r5] = r13     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            r9[r7] = r19     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            r9[r3] = r20     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            r9[r4] = r13     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            java.lang.Object r8 = r8.newInstance(r9)     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            com.google.android.exoplayer2.Renderer r8 = (com.google.android.exoplayer2.Renderer) r8     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0075 }
            int r9 = r2 + 1
            r10.add(r2, r8)     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x0075 }
            java.lang.String r2 = "Loaded LibvpxVideoRenderer."
            com.google.android.exoplayer2.util.Log.i(r11, r2)     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x0075 }
            goto L_0x007f
        L_0x0073:
            r2 = r9
            goto L_0x007e
        L_0x0075:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating VP9 extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x007e:
            r9 = r2
        L_0x007f:
            java.lang.String r2 = "com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Class[] r8 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            r8[r5] = r13     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Class<android.os.Handler> r13 = android.os.Handler.class
            r8[r7] = r13     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            r8[r3] = r12     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Class r12 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            r8[r4] = r12     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r8)     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Long r8 = java.lang.Long.valueOf(r21)     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            r6[r5] = r8     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            r6[r7] = r19     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            r6[r3] = r20     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            r6[r4] = r0     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Object r0 = r2.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            com.google.android.exoplayer2.Renderer r0 = (com.google.android.exoplayer2.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            r10.add(r9, r0)     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.String r0 = "Loaded Libgav1VideoRenderer."
            com.google.android.exoplayer2.util.Log.i(r11, r0)     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            goto L_0x00c3
        L_0x00ba:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating AV1 extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.DefaultRenderersFactory.buildVideoRenderers(android.content.Context, int, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, boolean, android.os.Handler, com.google.android.exoplayer2.video.VideoRendererEventListener, long, java.util.ArrayList):void");
    }

    @Override // com.google.android.exoplayer2.RenderersFactory
    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        ArrayList<Renderer> arrayList = new ArrayList<>();
        buildVideoRenderers(this.a, this.b, this.e, this.d, handler, videoRendererEventListener, this.c, arrayList);
        AudioSink buildAudioSink = buildAudioSink(this.a, this.h, this.i, this.j);
        if (buildAudioSink != null) {
            buildAudioRenderers(this.a, this.b, this.e, this.d, buildAudioSink, handler, audioRendererEventListener, arrayList);
        }
        buildTextRenderers(this.a, textOutput, handler.getLooper(), this.b, arrayList);
        buildMetadataRenderers(this.a, metadataOutput, handler.getLooper(), this.b, arrayList);
        buildCameraMotionRenderers(this.a, this.b, arrayList);
        buildMiscellaneousRenderers(this.a, handler, this.b, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    public DefaultRenderersFactory experimentalSetAudioMediaCodecOperationMode(int i2) {
        this.f = i2;
        return this;
    }

    public DefaultRenderersFactory experimentalSetMediaCodecOperationMode(int i2) {
        experimentalSetAudioMediaCodecOperationMode(i2);
        experimentalSetVideoMediaCodecOperationMode(i2);
        return this;
    }

    public DefaultRenderersFactory experimentalSetVideoMediaCodecOperationMode(int i2) {
        this.g = i2;
        return this;
    }

    public DefaultRenderersFactory setAllowedVideoJoiningTimeMs(long j2) {
        this.c = j2;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioFloatOutput(boolean z) {
        this.h = z;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioOffload(boolean z) {
        this.j = z;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioTrackPlaybackParams(boolean z) {
        this.i = z;
        return this;
    }

    public DefaultRenderersFactory setEnableDecoderFallback(boolean z) {
        this.d = z;
        return this;
    }

    public DefaultRenderersFactory setExtensionRendererMode(int i2) {
        this.b = i2;
        return this;
    }

    public DefaultRenderersFactory setMediaCodecSelector(MediaCodecSelector mediaCodecSelector) {
        this.e = mediaCodecSelector;
        return this;
    }

    @Deprecated
    public DefaultRenderersFactory(Context context, int i2) {
        this(context, i2, 5000);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context, int i2, long j2) {
        this.a = context;
        this.b = i2;
        this.c = j2;
        this.e = MediaCodecSelector.DEFAULT;
    }
}
