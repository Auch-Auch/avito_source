package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaFormatUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.firebase.messaging.Constants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    public final Context E0;
    public final AudioRendererEventListener.EventDispatcher F0;
    public final AudioSink G0;
    public int H0;
    public boolean I0;
    public boolean J0;
    @Nullable
    public Format K0;
    public long L0;
    public boolean M0;
    public boolean N0;
    public boolean O0;
    public boolean P0;
    @Nullable
    public Renderer.WakeupListener Q0;

    public final class b implements AudioSink.Listener {
        public b(a aVar) {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onAudioSessionId(int i) {
            MediaCodecAudioRenderer.this.F0.audioSessionId(i);
            MediaCodecAudioRenderer.this.onAudioSessionId(i);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onOffloadBufferEmptying() {
            Renderer.WakeupListener wakeupListener = MediaCodecAudioRenderer.this.Q0;
            if (wakeupListener != null) {
                wakeupListener.onWakeup();
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onOffloadBufferFull(long j) {
            Renderer.WakeupListener wakeupListener = MediaCodecAudioRenderer.this.Q0;
            if (wakeupListener != null) {
                wakeupListener.onSleep(j);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionAdvancing(long j) {
            MediaCodecAudioRenderer.this.F0.positionAdvancing(j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionDiscontinuity() {
            MediaCodecAudioRenderer.this.onPositionDiscontinuity();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onSkipSilenceEnabledChanged(boolean z) {
            MediaCodecAudioRenderer.this.F0.skipSilenceEnabledChanged(z);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onUnderrun(int i, long j, long j2) {
            MediaCodecAudioRenderer.this.F0.underrun(i, j, j2);
        }
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, null, null);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int canKeepCodec(MediaCodec mediaCodec, MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        if (s(mediaCodecInfo, format2) > this.H0) {
            return 0;
        }
        if (mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, true)) {
            return 3;
        }
        return canKeepCodecWithFlush(format, format2) ? 1 : 0;
    }

    public boolean canKeepCodecWithFlush(Format format, Format format2) {
        return Util.areEqual(format.sampleMimeType, format2.sampleMimeType) && format.channelCount == format2.channelCount && format.sampleRate == format2.sampleRate && format.pcmEncoding == format2.pcmEncoding && format.initializationDataEquals(format2) && !MimeTypes.AUDIO_OPUS.equals(format.sampleMimeType);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b5  */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void configureCodec(com.google.android.exoplayer2.mediacodec.MediaCodecInfo r7, com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r8, com.google.android.exoplayer2.Format r9, @androidx.annotation.Nullable android.media.MediaCrypto r10, float r11) {
        /*
            r6 = this;
            com.google.android.exoplayer2.Format[] r0 = r6.getStreamFormats()
            int r0 = r6.getCodecMaxInputSize(r7, r9, r0)
            r6.H0 = r0
            java.lang.String r0 = r7.name
            int r1 = com.google.android.exoplayer2.util.Util.SDK_INT
            r2 = 24
            java.lang.String r3 = "samsung"
            r4 = 1
            r5 = 0
            if (r1 >= r2) goto L_0x0042
            java.lang.String r2 = "OMX.SEC.aac.dec"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0042
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.MANUFACTURER
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0042
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.DEVICE
            java.lang.String r2 = "zeroflte"
            boolean r2 = r0.startsWith(r2)
            if (r2 != 0) goto L_0x0040
            java.lang.String r2 = "herolte"
            boolean r2 = r0.startsWith(r2)
            if (r2 != 0) goto L_0x0040
            java.lang.String r2 = "heroqlte"
            boolean r0 = r0.startsWith(r2)
            if (r0 == 0) goto L_0x0042
        L_0x0040:
            r0 = 1
            goto L_0x0043
        L_0x0042:
            r0 = 0
        L_0x0043:
            r6.I0 = r0
            java.lang.String r0 = r7.name
            r2 = 21
            if (r1 >= r2) goto L_0x008f
            java.lang.String r1 = "OMX.SEC.mp3.dec"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x008f
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.MANUFACTURER
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x008f
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.DEVICE
            java.lang.String r1 = "baffin"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x008d
            java.lang.String r1 = "grand"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x008d
            java.lang.String r1 = "fortuna"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x008d
            java.lang.String r1 = "gprimelte"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x008d
            java.lang.String r1 = "j2y18lte"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x008d
            java.lang.String r1 = "ms01"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L_0x008f
        L_0x008d:
            r0 = 1
            goto L_0x0090
        L_0x008f:
            r0 = 0
        L_0x0090:
            r6.J0 = r0
            java.lang.String r0 = r7.codecMimeType
            int r1 = r6.H0
            android.media.MediaFormat r11 = r6.getMediaFormat(r9, r0, r1, r11)
            r0 = 0
            r8.configure(r11, r0, r10, r5)
            java.lang.String r7 = r7.mimeType
            java.lang.String r8 = "audio/raw"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x00b1
            java.lang.String r7 = r9.sampleMimeType
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L_0x00b1
            goto L_0x00b2
        L_0x00b1:
            r4 = 0
        L_0x00b2:
            if (r4 == 0) goto L_0x00b5
            goto L_0x00b6
        L_0x00b5:
            r9 = r0
        L_0x00b6:
            r6.K0 = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.configureCodec(com.google.android.exoplayer2.mediacodec.MediaCodecInfo, com.google.android.exoplayer2.mediacodec.MediaCodecAdapter, com.google.android.exoplayer2.Format, android.media.MediaCrypto, float):void");
    }

    public void experimentalSetEnableKeepAudioTrackOnSeek(boolean z) {
        this.P0 = z;
    }

    public int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int s = s(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            return s;
        }
        for (Format format2 : formatArr) {
            if (mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, false)) {
                s = Math.max(s, s(mediaCodecInfo, format2));
            }
        }
        return s;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        int i = -1;
        for (Format format2 : formatArr) {
            int i2 = format2.sampleRate;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return f * ((float) i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        MediaCodecInfo decryptOnlyDecoderInfo;
        String str = format.sampleMimeType;
        if (str == null) {
            return Collections.emptyList();
        }
        if (this.G0.supportsFormat(format) && (decryptOnlyDecoderInfo = MediaCodecUtil.getDecryptOnlyDecoderInfo()) != null) {
            return Collections.singletonList(decryptOnlyDecoderInfo);
        }
        List<MediaCodecInfo> decoderInfosSortedByFormatSupport = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(mediaCodecSelector.getDecoderInfos(str, z, false), format);
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(str)) {
            ArrayList arrayList = new ArrayList(decoderInfosSortedByFormatSupport);
            arrayList.addAll(mediaCodecSelector.getDecoderInfos(MimeTypes.AUDIO_E_AC3, z, false));
            decoderInfosSortedByFormatSupport = arrayList;
        }
        return Collections.unmodifiableList(decoderInfosSortedByFormatSupport);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    @Nullable
    public MediaClock getMediaClock() {
        return this;
    }

    @SuppressLint({"InlinedApi"})
    public MediaFormat getMediaFormat(Format format, String str, int i, float f) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", format.channelCount);
        mediaFormat.setInteger("sample-rate", format.sampleRate);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", i);
        int i2 = Util.SDK_INT;
        if (i2 >= 23) {
            boolean z = false;
            mediaFormat.setInteger(Constants.FirelogAnalytics.PARAM_PRIORITY, 0);
            if (f != -1.0f) {
                if (i2 == 23) {
                    String str2 = Util.MODEL;
                    if ("ZTE B2017G".equals(str2) || "AXON 7 mini".equals(str2)) {
                        z = true;
                    }
                }
                if (!z) {
                    mediaFormat.setFloat("operating-rate", f);
                }
            }
        }
        if (i2 <= 28 && MimeTypes.AUDIO_AC4.equals(format.sampleMimeType)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i2 >= 24 && this.G0.getFormatSupport(Util.getPcmFormat(4, format.channelCount, format.sampleRate)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        return mediaFormat;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        return this.G0.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if (getState() == 2) {
            t();
        }
        return this.L0;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 2) {
            this.G0.setVolume(((Float) obj).floatValue());
        } else if (i == 3) {
            this.G0.setAudioAttributes((AudioAttributes) obj);
        } else if (i != 5) {
            switch (i) {
                case 101:
                    this.G0.setSkipSilenceEnabled(((Boolean) obj).booleanValue());
                    return;
                case 102:
                    this.G0.setAudioSessionId(((Integer) obj).intValue());
                    return;
                case 103:
                    this.Q0 = (Renderer.WakeupListener) obj;
                    return;
                default:
                    super.handleMessage(i, obj);
                    return;
            }
        } else {
            this.G0.setAuxEffectInfo((AuxEffectInfo) obj);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return super.isEnded() && this.G0.isEnded();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.G0.hasPendingData() || super.isReady();
    }

    public void onAudioSessionId(int i) {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(String str, long j, long j2) {
        this.F0.decoderInitialized(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.O0 = true;
        try {
            this.G0.flush();
            try {
                super.onDisabled();
            } finally {
                this.F0.disabled(this.decoderCounters);
            }
        } catch (Throwable th) {
            super.onDisabled();
            throw th;
        } finally {
            this.F0.disabled(this.decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        super.onEnabled(z, z2);
        this.F0.enabled(this.decoderCounters);
        int i = getConfiguration().tunnelingAudioSessionId;
        if (i != 0) {
            this.G0.enableTunnelingV21(i);
        } else {
            this.G0.disableTunneling();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        super.onInputFormatChanged(formatHolder);
        this.F0.inputFormatChanged(formatHolder.format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(Format format, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
        int i;
        int i2;
        Format format2 = this.K0;
        int[] iArr = null;
        if (format2 == null) {
            if (getCodec() == null) {
                format2 = format;
            } else {
                if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
                    i = format.pcmEncoding;
                } else if (Util.SDK_INT >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                    i = mediaFormat.getInteger("pcm-encoding");
                } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                    i = Util.getPcmEncoding(mediaFormat.getInteger("v-bits-per-sample"));
                } else {
                    i = MimeTypes.AUDIO_RAW.equals(format.sampleMimeType) ? format.pcmEncoding : 2;
                }
                format2 = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_RAW).setPcmEncoding(i).setEncoderDelay(format.encoderDelay).setEncoderPadding(format.encoderPadding).setChannelCount(mediaFormat.getInteger("channel-count")).setSampleRate(mediaFormat.getInteger("sample-rate")).build();
                if (this.I0 && format2.channelCount == 6 && (i2 = format.channelCount) < 6) {
                    iArr = new int[i2];
                    for (int i3 = 0; i3 < format.channelCount; i3++) {
                        iArr[i3] = i3;
                    }
                }
            }
        }
        try {
            this.G0.configure(format2, 0, iArr);
        } catch (AudioSink.ConfigurationException e) {
            throw createRendererException(e, format);
        }
    }

    @CallSuper
    public void onPositionDiscontinuity() {
        this.N0 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        if (this.P0) {
            this.G0.experimentalFlushWithoutAudioTrackRelease();
        } else {
            this.G0.flush();
        }
        this.L0 = j;
        this.M0 = true;
        this.N0 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        this.G0.handleDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (this.M0 && !decoderInputBuffer.isDecodeOnly()) {
            if (Math.abs(decoderInputBuffer.timeUs - this.L0) > 500000) {
                this.L0 = decoderInputBuffer.timeUs;
            }
            this.M0 = false;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onReset() {
        boolean z = false;
        try {
            super.onReset();
        } finally {
            if (this.O0) {
                this.O0 = z;
                this.G0.reset();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        super.onStarted();
        this.G0.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        t();
        this.G0.pause();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean processOutputBuffer(long j, long j2, @Nullable MediaCodec mediaCodec, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException {
        Assertions.checkNotNull(byteBuffer);
        if (!(mediaCodec == null || !this.J0 || j3 != 0 || (i2 & 4) == 0 || getLargestQueuedPresentationTimeUs() == C.TIME_UNSET)) {
            j3 = getLargestQueuedPresentationTimeUs();
        }
        if (this.K0 != null && (i2 & 2) != 0) {
            ((MediaCodec) Assertions.checkNotNull(mediaCodec)).releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            if (mediaCodec != null) {
                mediaCodec.releaseOutputBuffer(i, false);
            }
            this.decoderCounters.skippedOutputBufferCount += i3;
            this.G0.handleDiscontinuity();
            return true;
        } else {
            try {
                if (!this.G0.handleBuffer(byteBuffer, j3, i3)) {
                    return false;
                }
                if (mediaCodec != null) {
                    mediaCodec.releaseOutputBuffer(i, false);
                }
                this.decoderCounters.renderedOutputBufferCount += i3;
                return true;
            } catch (AudioSink.InitializationException | AudioSink.WriteException e) {
                throw createRendererException(e, format);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void renderToEndOfStream() throws ExoPlaybackException {
        try {
            this.G0.playToEndOfStream();
        } catch (AudioSink.WriteException e) {
            Format outputFormat = getOutputFormat();
            if (outputFormat == null) {
                outputFormat = getInputFormat();
            }
            throw createRendererException(e, outputFormat);
        }
    }

    public final int s(MediaCodecInfo mediaCodecInfo, Format format) {
        int i;
        if (!"OMX.google.raw.decoder".equals(mediaCodecInfo.name) || (i = Util.SDK_INT) >= 24 || (i == 23 && Util.isTv(this.E0))) {
            return format.maxInputSize;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.G0.setPlaybackParameters(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean shouldUseBypass(Format format) {
        return this.G0.supportsFormat(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        if (!MimeTypes.isAudio(format.sampleMimeType)) {
            return 0;
        }
        int i = Util.SDK_INT >= 21 ? 32 : 0;
        boolean z = format.exoMediaCryptoType != null;
        boolean supportsFormatDrm = MediaCodecRenderer.supportsFormatDrm(format);
        if (supportsFormatDrm && this.G0.supportsFormat(format) && (!z || MediaCodecUtil.getDecryptOnlyDecoderInfo() != null)) {
            return 12 | i;
        }
        if ((MimeTypes.AUDIO_RAW.equals(format.sampleMimeType) && !this.G0.supportsFormat(format)) || !this.G0.supportsFormat(Util.getPcmFormat(2, format.channelCount, format.sampleRate))) {
            return 1;
        }
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(mediaCodecSelector, format, false);
        if (decoderInfos.isEmpty()) {
            return 1;
        }
        if (!supportsFormatDrm) {
            return 2;
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean isFormatSupported = mediaCodecInfo.isFormatSupported(format);
        return ((!isFormatSupported || !mediaCodecInfo.isSeamlessAdaptationSupported(format)) ? 8 : 16) | (isFormatSupported ? 4 : 3) | i;
    }

    public final void t() {
        long currentPositionUs = this.G0.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.N0) {
                currentPositionUs = Math.max(this.L0, currentPositionUs);
            }
            this.L0 = currentPositionUs;
            this.N0 = false;
        }
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener) {
        this(context, mediaCodecSelector, handler, audioRendererEventListener, (AudioCapabilities) null, new AudioProcessor[0]);
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, @Nullable AudioCapabilities audioCapabilities, AudioProcessor... audioProcessorArr) {
        this(context, mediaCodecSelector, handler, audioRendererEventListener, new DefaultAudioSink(audioCapabilities, audioProcessorArr));
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        this(context, mediaCodecSelector, false, handler, audioRendererEventListener, audioSink);
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, boolean z, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(1, mediaCodecSelector, z, 44100.0f);
        this.E0 = context.getApplicationContext();
        this.G0 = audioSink;
        this.F0 = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        audioSink.setListener(new b(null));
    }
}
