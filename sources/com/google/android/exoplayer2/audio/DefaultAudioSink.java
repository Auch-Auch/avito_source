package com.google.android.exoplayer2.audio;

import a2.j.b.b.r0.m;
import a2.j.b.b.r0.n;
import a2.j.b.b.r0.o;
import a2.j.b.b.r0.p;
import a2.j.b.b.r0.q;
import a2.j.b.b.r0.s;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.AudioTrackPositionTracker;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
public final class DefaultAudioSink implements AudioSink {
    public static final float DEFAULT_PLAYBACK_SPEED = 1.0f;
    public static final float MAX_PITCH = 8.0f;
    public static final float MAX_PLAYBACK_SPEED = 8.0f;
    public static final float MIN_PITCH = 0.1f;
    public static final float MIN_PLAYBACK_SPEED = 0.1f;
    public static boolean enablePreV21AudioSessionWorkaround = false;
    public static boolean failOnSpuriousAudioTimestamp = false;
    public long A;
    public long B;
    public int C;
    public boolean D;
    public boolean E;
    public long F;
    public float G;
    public AudioProcessor[] H;
    public ByteBuffer[] I;
    @Nullable
    public ByteBuffer J;
    public int K;
    @Nullable
    public ByteBuffer L;
    public byte[] M;
    public int N;
    public int O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public int S;
    public AuxEffectInfo T;
    public boolean U;
    public long V;
    public boolean W;
    public boolean X;
    @Nullable
    public final AudioCapabilities a;
    public final AudioProcessorChain b;
    public final boolean c;
    public final n d;
    public final s e;
    public final AudioProcessor[] f;
    public final AudioProcessor[] g;
    public final ConditionVariable h;
    public final AudioTrackPositionTracker i;
    public final ArrayDeque<c> j;
    public final boolean k;
    public final boolean l;
    public e m;
    @Nullable
    public AudioSink.Listener n;
    @Nullable
    public AudioTrack o;
    @Nullable
    public b p;
    public b q;
    @Nullable
    public AudioTrack r;
    public AudioAttributes s;
    @Nullable
    public c t;
    public c u;
    public PlaybackParameters v;
    @Nullable
    public ByteBuffer w;
    public int x;
    public long y;
    public long z;

    public interface AudioProcessorChain {
        PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters);

        boolean applySkipSilenceEnabled(boolean z);

        AudioProcessor[] getAudioProcessors();

        long getMediaDuration(long j);

        long getSkippedOutputFrameCount();
    }

    public static class DefaultAudioProcessorChain implements AudioProcessorChain {
        public final AudioProcessor[] a;
        public final SilenceSkippingAudioProcessor b;
        public final SonicAudioProcessor c;

        public DefaultAudioProcessorChain(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new SilenceSkippingAudioProcessor(), new SonicAudioProcessor());
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters) {
            this.c.setSpeed(playbackParameters.speed);
            this.c.setPitch(playbackParameters.pitch);
            return playbackParameters;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public boolean applySkipSilenceEnabled(boolean z) {
            this.b.setEnabled(z);
            return z;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public AudioProcessor[] getAudioProcessors() {
            return this.a;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public long getMediaDuration(long j) {
            return this.c.getMediaDuration(j);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public long getSkippedOutputFrameCount() {
            return this.b.getSkippedFrames();
        }

        public DefaultAudioProcessorChain(AudioProcessor[] audioProcessorArr, SilenceSkippingAudioProcessor silenceSkippingAudioProcessor, SonicAudioProcessor sonicAudioProcessor) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[(audioProcessorArr.length + 2)];
            this.a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.b = silenceSkippingAudioProcessor;
            this.c = sonicAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length] = silenceSkippingAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length + 1] = sonicAudioProcessor;
        }
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public InvalidAudioTrackTimestampException(String str, a aVar) {
            super(str);
        }
    }

    public class a extends Thread {
        public final /* synthetic */ AudioTrack a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, AudioTrack audioTrack) {
            super(str);
            this.a = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.a.flush();
                this.a.release();
            } finally {
                DefaultAudioSink.this.h.open();
            }
        }
    }

    public static final class b {
        public final Format a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final boolean i;
        public final AudioProcessor[] j;

        public b(Format format, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, boolean z2, AudioProcessor[] audioProcessorArr) {
            this.a = format;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.i = z2;
            this.j = audioProcessorArr;
            if (i8 == 0) {
                boolean z3 = true;
                if (i3 == 0) {
                    float f2 = z ? 8.0f : 1.0f;
                    int minBufferSize = AudioTrack.getMinBufferSize(i5, i6, i7);
                    Assertions.checkState(minBufferSize == -2 ? false : z3);
                    long j2 = (long) i5;
                    int constrainValue = Util.constrainValue(minBufferSize * 4, ((int) ((250000 * j2) / 1000000)) * i4, Math.max(minBufferSize, ((int) ((j2 * 750000) / 1000000)) * i4));
                    i8 = f2 != 1.0f ? Math.round(((float) constrainValue) * f2) : constrainValue;
                } else if (i3 == 1) {
                    i8 = e(50000000);
                } else if (i3 == 2) {
                    i8 = e(250000);
                } else {
                    throw new IllegalStateException();
                }
            }
            this.h = i8;
        }

        @RequiresApi(21)
        public static AudioAttributes d(AudioAttributes audioAttributes, boolean z) {
            if (z) {
                return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
            }
            return audioAttributes.getAudioAttributesV21();
        }

        public AudioTrack a(boolean z, AudioAttributes audioAttributes, int i2) throws AudioSink.InitializationException {
            try {
                AudioTrack b2 = b(z, audioAttributes, i2);
                int state = b2.getState();
                if (state == 1) {
                    return b2;
                }
                try {
                    b2.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.e, this.f, this.h);
            } catch (UnsupportedOperationException unused2) {
                throw new AudioSink.InitializationException(0, this.e, this.f, this.h);
            }
        }

        public final AudioTrack b(boolean z, AudioAttributes audioAttributes, int i2) {
            int i3 = Util.SDK_INT;
            if (i3 >= 29) {
                AudioFormat d2 = DefaultAudioSink.d(this.e, this.f, this.g);
                AudioAttributes d3 = d(audioAttributes, z);
                boolean z2 = true;
                AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(d3).setAudioFormat(d2).setTransferMode(1).setBufferSizeInBytes(this.h).setSessionId(i2);
                if (this.c != 1) {
                    z2 = false;
                }
                return sessionId.setOffloadedPlayback(z2).build();
            } else if (i3 >= 21) {
                return new AudioTrack(d(audioAttributes, z), DefaultAudioSink.d(this.e, this.f, this.g), this.h, 1, i2);
            } else {
                int streamTypeForAudioUsage = Util.getStreamTypeForAudioUsage(audioAttributes.usage);
                if (i2 == 0) {
                    return new AudioTrack(streamTypeForAudioUsage, this.e, this.f, this.g, this.h, 1);
                }
                return new AudioTrack(streamTypeForAudioUsage, this.e, this.f, this.g, this.h, 1, i2);
            }
        }

        public long c(long j2) {
            return (j2 * 1000000) / ((long) this.e);
        }

        public final int e(long j2) {
            int i2;
            int i3 = this.g;
            switch (i3) {
                case 5:
                    i2 = Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND;
                    break;
                case 6:
                case 18:
                    i2 = Ac3Util.E_AC3_MAX_RATE_BYTES_PER_SECOND;
                    break;
                case 7:
                    i2 = DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND;
                    break;
                case 8:
                    i2 = DtsUtil.DTS_HD_MAX_RATE_BYTES_PER_SECOND;
                    break;
                case 9:
                    i2 = MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
                    break;
                case 10:
                    i2 = AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND;
                    break;
                case 11:
                    i2 = AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND;
                    break;
                case 12:
                    i2 = AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND;
                    break;
                case 13:
                default:
                    throw new IllegalArgumentException();
                case 14:
                    i2 = Ac3Util.TRUEHD_MAX_RATE_BYTES_PER_SECOND;
                    break;
                case 15:
                    i2 = 8000;
                    break;
                case 16:
                    i2 = AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND;
                    break;
                case 17:
                    i2 = Ac4Util.MAX_RATE_BYTES_PER_SECOND;
                    break;
            }
            if (i3 == 5) {
                i2 *= 2;
            }
            return (int) ((j2 * ((long) i2)) / 1000000);
        }
    }

    public static final class c {
        public final PlaybackParameters a;
        public final boolean b;
        public final long c;
        public final long d;

        public c(PlaybackParameters playbackParameters, boolean z, long j, long j2, a aVar) {
            this.a = playbackParameters;
            this.b = z;
            this.c = j;
            this.d = j2;
        }
    }

    public final class d implements AudioTrackPositionTracker.Listener {
        public d(a aVar) {
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onInvalidLatency(long j) {
            Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onPositionAdvancing(long j) {
            AudioSink.Listener listener = DefaultAudioSink.this.n;
            if (listener != null) {
                listener.onPositionAdvancing(j);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onPositionFramesMismatch(long j, long j2, long j3, long j4) {
            long j5;
            StringBuilder O = a2.b.a.a.a.O("Spurious audio timestamp (frame position mismatch): ", j, ", ");
            O.append(j2);
            a2.b.a.a.a.l1(O, ", ", j3, ", ");
            O.append(j4);
            O.append(", ");
            DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
            b bVar = defaultAudioSink.q;
            if (bVar.c == 0) {
                j5 = defaultAudioSink.y / ((long) bVar.b);
            } else {
                j5 = defaultAudioSink.z;
            }
            O.append(j5);
            O.append(", ");
            O.append(DefaultAudioSink.this.h());
            String sb = O.toString();
            if (!DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                Log.w("AudioTrack", sb);
                return;
            }
            throw new InvalidAudioTrackTimestampException(sb, null);
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onSystemTimeUsMismatch(long j, long j2, long j3, long j4) {
            long j5;
            StringBuilder O = a2.b.a.a.a.O("Spurious audio timestamp (system clock mismatch): ", j, ", ");
            O.append(j2);
            a2.b.a.a.a.l1(O, ", ", j3, ", ");
            O.append(j4);
            O.append(", ");
            DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
            b bVar = defaultAudioSink.q;
            if (bVar.c == 0) {
                j5 = defaultAudioSink.y / ((long) bVar.b);
            } else {
                j5 = defaultAudioSink.z;
            }
            O.append(j5);
            O.append(", ");
            O.append(DefaultAudioSink.this.h());
            String sb = O.toString();
            if (!DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                Log.w("AudioTrack", sb);
                return;
            }
            throw new InvalidAudioTrackTimestampException(sb, null);
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onUnderrun(int i, long j) {
            if (DefaultAudioSink.this.n != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
                defaultAudioSink.n.onUnderrun(i, j, elapsedRealtime - defaultAudioSink.V);
            }
        }
    }

    @RequiresApi(29)
    public final class e {
        public final Handler a = new Handler();
        public final AudioTrack.StreamEventCallback b;

        public class a extends AudioTrack.StreamEventCallback {
            public a(DefaultAudioSink defaultAudioSink) {
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onDataRequest(AudioTrack audioTrack, int i) {
                Assertions.checkState(audioTrack == DefaultAudioSink.this.r);
                AudioSink.Listener listener = DefaultAudioSink.this.n;
                if (listener != null) {
                    listener.onOffloadBufferEmptying();
                }
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onTearDown(@NonNull AudioTrack audioTrack) {
                DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
                AudioSink.Listener listener = defaultAudioSink.n;
                if (listener != null && defaultAudioSink.R) {
                    listener.onOffloadBufferEmptying();
                }
            }
        }

        public e() {
            this.b = new a(DefaultAudioSink.this);
        }
    }

    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities, AudioProcessor[] audioProcessorArr) {
        this(audioCapabilities, audioProcessorArr, false);
    }

    @RequiresApi(21)
    public static AudioFormat d(int i2, int i3, int i4) {
        return new AudioFormat.Builder().setSampleRate(i2).setChannelMask(i3).setEncoding(i4).build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006c  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> f(com.google.android.exoplayer2.Format r10, @androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioCapabilities r11) {
        /*
            r0 = 0
            if (r11 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = r10.sampleMimeType
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = r10.codecs
            int r1 = com.google.android.exoplayer2.util.MimeTypes.getEncoding(r1, r2)
            r2 = 8
            r3 = 7
            r4 = 1
            r5 = 5
            r6 = 18
            r7 = 6
            if (r1 == r5) goto L_0x002f
            if (r1 == r7) goto L_0x002f
            if (r1 == r6) goto L_0x002f
            r8 = 17
            if (r1 == r8) goto L_0x002f
            if (r1 == r3) goto L_0x002f
            if (r1 == r2) goto L_0x002f
            r8 = 14
            if (r1 != r8) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r8 = 0
            goto L_0x0030
        L_0x002f:
            r8 = 1
        L_0x0030:
            if (r8 != 0) goto L_0x0033
            return r0
        L_0x0033:
            if (r1 != r6) goto L_0x0037
            r10 = 6
            goto L_0x0039
        L_0x0037:
            int r10 = r10.channelCount
        L_0x0039:
            int r8 = r11.getMaxChannelCount()
            if (r10 <= r8) goto L_0x0040
            return r0
        L_0x0040:
            int r8 = com.google.android.exoplayer2.util.Util.SDK_INT
            r9 = 28
            if (r8 > r9) goto L_0x0053
            if (r10 != r3) goto L_0x0049
            goto L_0x0054
        L_0x0049:
            r2 = 3
            if (r10 == r2) goto L_0x0051
            r2 = 4
            if (r10 == r2) goto L_0x0051
            if (r10 != r5) goto L_0x0053
        L_0x0051:
            r2 = 6
            goto L_0x0054
        L_0x0053:
            r2 = r10
        L_0x0054:
            r10 = 26
            if (r8 > r10) goto L_0x0065
            java.lang.String r10 = com.google.android.exoplayer2.util.Util.DEVICE
            java.lang.String r3 = "fugu"
            boolean r10 = r3.equals(r10)
            if (r10 == 0) goto L_0x0065
            if (r2 != r4) goto L_0x0065
            r2 = 2
        L_0x0065:
            int r10 = com.google.android.exoplayer2.util.Util.getAudioTrackChannelConfig(r2)
            if (r10 != 0) goto L_0x006c
            return r0
        L_0x006c:
            boolean r2 = r11.supportsEncoding(r1)
            if (r2 == 0) goto L_0x007f
            java.lang.Integer r11 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            android.util.Pair r10 = android.util.Pair.create(r11, r10)
            return r10
        L_0x007f:
            if (r1 != r6) goto L_0x0094
            boolean r11 = r11.supportsEncoding(r7)
            if (r11 == 0) goto L_0x0094
            java.lang.Integer r11 = java.lang.Integer.valueOf(r7)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            android.util.Pair r10 = android.util.Pair.create(r11, r10)
            return r10
        L_0x0094:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.f(com.google.android.exoplayer2.Format, com.google.android.exoplayer2.audio.AudioCapabilities):android.util.Pair");
    }

    public static boolean j(AudioTrack audioTrack) {
        return Util.SDK_INT >= 29 && audioTrack.isOffloadedPlayback();
    }

    public static boolean k(Format format, AudioAttributes audioAttributes) {
        int encoding;
        int audioTrackChannelConfig;
        int i2 = Util.SDK_INT;
        if (i2 < 29 || (encoding = MimeTypes.getEncoding((String) Assertions.checkNotNull(format.sampleMimeType), format.codecs)) == 0 || (audioTrackChannelConfig = Util.getAudioTrackChannelConfig(format.channelCount)) == 0 || !AudioManager.isOffloadedPlaybackSupported(d(format.sampleRate, audioTrackChannelConfig, encoding), audioAttributes.getAudioAttributesV21())) {
            return false;
        }
        if (!(format.encoderDelay == 0 && format.encoderPadding == 0)) {
            if (!(i2 >= 30 && Util.MODEL.startsWith("Pixel"))) {
                return false;
            }
        }
        return true;
    }

    public final void a(long j2) {
        PlaybackParameters playbackParameters;
        if (this.q.i) {
            playbackParameters = this.b.applyPlaybackParameters(e());
        } else {
            playbackParameters = PlaybackParameters.DEFAULT;
        }
        boolean applySkipSilenceEnabled = this.q.i ? this.b.applySkipSilenceEnabled(getSkipSilenceEnabled()) : false;
        this.j.add(new c(playbackParameters, applySkipSilenceEnabled, Math.max(0L, j2), this.q.c(h()), null));
        AudioProcessor[] audioProcessorArr = this.q.j;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.H = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.I = new ByteBuffer[size];
        c();
        AudioSink.Listener listener = this.n;
        if (listener != null) {
            listener.onSkipSilenceEnabledChanged(applySkipSilenceEnabled);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b() throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        /*
            r9 = this;
            int r0 = r9.O
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x000b
            r9.O = r3
        L_0x0009:
            r0 = 1
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            int r4 = r9.O
            com.google.android.exoplayer2.audio.AudioProcessor[] r5 = r9.H
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x002f
            r4 = r5[r4]
            if (r0 == 0) goto L_0x001f
            r4.queueEndOfStream()
        L_0x001f:
            r9.n(r7)
            boolean r0 = r4.isEnded()
            if (r0 != 0) goto L_0x0029
            return r3
        L_0x0029:
            int r0 = r9.O
            int r0 = r0 + r2
            r9.O = r0
            goto L_0x0009
        L_0x002f:
            java.nio.ByteBuffer r0 = r9.L
            if (r0 == 0) goto L_0x003b
            r9.s(r0, r7)
            java.nio.ByteBuffer r0 = r9.L
            if (r0 == 0) goto L_0x003b
            return r3
        L_0x003b:
            r9.O = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.b():boolean");
    }

    public final void c() {
        int i2 = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.H;
            if (i2 < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i2];
                audioProcessor.flush();
                this.I[i2] = audioProcessor.getOutput();
                i2++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void configure(Format format, int i2, @Nullable int[] iArr) throws AudioSink.ConfigurationException {
        AudioProcessor[] audioProcessorArr;
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int[] iArr2;
        if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
            Assertions.checkArgument(Util.isEncodingLinearPcm(format.pcmEncoding));
            int pcmFrameSize = Util.getPcmFrameSize(format.pcmEncoding, format.channelCount);
            boolean z3 = this.c && Util.isEncodingHighResolutionPcm(format.pcmEncoding);
            AudioProcessor[] audioProcessorArr2 = z3 ? this.g : this.f;
            boolean z4 = !z3;
            s sVar = this.e;
            int i9 = format.encoderDelay;
            int i10 = format.encoderPadding;
            sVar.f = i9;
            sVar.g = i10;
            if (Util.SDK_INT < 21 && format.channelCount == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i11 = 0; i11 < 6; i11++) {
                    iArr2[i11] = i11;
                }
            } else {
                iArr2 = iArr;
            }
            this.d.f = iArr2;
            AudioProcessor.AudioFormat audioFormat = new AudioProcessor.AudioFormat(format.sampleRate, format.channelCount, format.pcmEncoding);
            for (AudioProcessor audioProcessor : audioProcessorArr2) {
                try {
                    AudioProcessor.AudioFormat configure = audioProcessor.configure(audioFormat);
                    if (audioProcessor.isActive()) {
                        audioFormat = configure;
                    }
                } catch (AudioProcessor.UnhandledAudioFormatException e2) {
                    throw new AudioSink.ConfigurationException(e2);
                }
            }
            int i12 = audioFormat.encoding;
            i5 = audioFormat.sampleRate;
            i4 = Util.getAudioTrackChannelConfig(audioFormat.channelCount);
            z2 = z4;
            audioProcessorArr = audioProcessorArr2;
            i3 = i12;
            i7 = 0;
            i6 = Util.getPcmFrameSize(i12, audioFormat.channelCount);
            i8 = pcmFrameSize;
        } else {
            AudioProcessor[] audioProcessorArr3 = new AudioProcessor[0];
            int i13 = format.sampleRate;
            if (!this.l || !k(format, this.s)) {
                Pair<Integer, Integer> f2 = f(format, this.a);
                if (f2 != null) {
                    int intValue = ((Integer) f2.first).intValue();
                    audioProcessorArr = audioProcessorArr3;
                    i4 = ((Integer) f2.second).intValue();
                    i3 = intValue;
                    i8 = -1;
                    i6 = -1;
                    z2 = false;
                    i5 = i13;
                    i7 = 2;
                } else {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + format);
                }
            } else {
                audioProcessorArr = audioProcessorArr3;
                i3 = MimeTypes.getEncoding((String) Assertions.checkNotNull(format.sampleMimeType), format.codecs);
                i4 = Util.getAudioTrackChannelConfig(format.channelCount);
                i8 = -1;
                i6 = -1;
                z2 = false;
                i5 = i13;
                i7 = 1;
            }
        }
        if (i3 == 0) {
            throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i7 + ") for: " + format);
        } else if (i4 != 0) {
            this.W = false;
            b bVar = new b(format, i8, i7, i6, i5, i4, i3, i2, this.k, z2, audioProcessorArr);
            if (i()) {
                this.p = bVar;
            } else {
                this.q = bVar;
            }
        } else {
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i7 + ") for: " + format);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() {
        if (this.U) {
            this.U = false;
            this.S = 0;
            flush();
        }
    }

    public final PlaybackParameters e() {
        return g().a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void enableTunnelingV21(int i2) {
        Assertions.checkState(Util.SDK_INT >= 21);
        if (!this.U || this.S != i2) {
            this.U = true;
            this.S = i2;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void experimentalFlushWithoutAudioTrackRelease() {
        if (Util.SDK_INT < 25) {
            flush();
        } else if (i()) {
            o();
            if (this.i.d()) {
                this.r.pause();
            }
            this.r.flush();
            this.i.e();
            AudioTrackPositionTracker audioTrackPositionTracker = this.i;
            AudioTrack audioTrack = this.r;
            b bVar = this.q;
            audioTrackPositionTracker.f(audioTrack, bVar.c == 2, bVar.g, bVar.d, bVar.h);
            this.E = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        if (i()) {
            o();
            if (this.i.d()) {
                this.r.pause();
            }
            if (j(this.r)) {
                e eVar = (e) Assertions.checkNotNull(this.m);
                this.r.unregisterStreamEventCallback(eVar.b);
                eVar.a.removeCallbacksAndMessages(null);
            }
            AudioTrack audioTrack = this.r;
            this.r = null;
            b bVar = this.p;
            if (bVar != null) {
                this.q = bVar;
                this.p = null;
            }
            this.i.e();
            this.h.close();
            new a("ExoPlayer:AudioTrackReleaseThread", audioTrack).start();
        }
    }

    public final c g() {
        c cVar = this.t;
        if (cVar != null) {
            return cVar;
        }
        if (!this.j.isEmpty()) {
            return this.j.getLast();
        }
        return this.u;
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01b6 A[Catch:{ Exception -> 0x01c0 }] */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getCurrentPositionUs(boolean r27) {
        /*
        // Method dump skipped, instructions count: 766
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.getCurrentPositionUs(boolean):long");
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int getFormatSupport(Format format) {
        boolean z2 = true;
        if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
            if (!Util.isEncodingLinearPcm(format.pcmEncoding)) {
                StringBuilder L2 = a2.b.a.a.a.L("Invalid PCM encoding: ");
                L2.append(format.pcmEncoding);
                Log.w("AudioTrack", L2.toString());
                return 0;
            }
            int i2 = format.pcmEncoding;
            return (i2 == 2 || (this.c && i2 == 4)) ? 2 : 1;
        } else if (this.l && !this.W && k(format, this.s)) {
            return 2;
        } else {
            if (f(format, this.a) == null) {
                z2 = false;
            }
            return z2 ? 2 : 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public PlaybackParameters getPlaybackParameters() {
        if (this.k) {
            return this.v;
        }
        return e();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean getSkipSilenceEnabled() {
        return g().b;
    }

    public final long h() {
        b bVar = this.q;
        if (bVar.c == 0) {
            return this.A / ((long) bVar.d);
        }
        return this.B;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01a0, code lost:
        if (r5.b() == 0) goto L_0x01a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01c2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01c3  */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleBuffer(java.nio.ByteBuffer r19, long r20, int r22) throws com.google.android.exoplayer2.audio.AudioSink.InitializationException, com.google.android.exoplayer2.audio.AudioSink.WriteException {
        /*
        // Method dump skipped, instructions count: 830
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.handleBuffer(java.nio.ByteBuffer, long, int):boolean");
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        this.D = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        return i() && this.i.c(h());
    }

    public final boolean i() {
        return this.r != null;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        return !i() || (this.P && !hasPendingData());
    }

    public final void l() {
        if (this.q.c == 1) {
            this.W = true;
        }
    }

    public final void m() {
        if (!this.Q) {
            this.Q = true;
            AudioTrackPositionTracker audioTrackPositionTracker = this.i;
            long h2 = h();
            audioTrackPositionTracker.z = audioTrackPositionTracker.b();
            audioTrackPositionTracker.x = SystemClock.elapsedRealtime() * 1000;
            audioTrackPositionTracker.A = h2;
            this.r.stop();
            this.x = 0;
        }
    }

    public final void n(long j2) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.H.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                byteBuffer = this.I[i2 - 1];
            } else {
                byteBuffer = this.J;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.EMPTY_BUFFER;
                }
            }
            if (i2 == length) {
                s(byteBuffer, j2);
            } else {
                AudioProcessor audioProcessor = this.H[i2];
                audioProcessor.queueInput(byteBuffer);
                ByteBuffer output = audioProcessor.getOutput();
                this.I[i2] = output;
                if (output.hasRemaining()) {
                    i2++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i2--;
            } else {
                return;
            }
        }
    }

    public final void o() {
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.X = false;
        this.C = 0;
        this.u = new c(e(), getSkipSilenceEnabled(), 0, 0, null);
        this.F = 0;
        this.t = null;
        this.j.clear();
        this.J = null;
        this.K = 0;
        this.L = null;
        this.Q = false;
        this.P = false;
        this.O = -1;
        this.w = null;
        this.x = 0;
        this.e.l = 0;
        c();
    }

    public final void p(PlaybackParameters playbackParameters, boolean z2) {
        c g2 = g();
        if (!playbackParameters.equals(g2.a) || z2 != g2.b) {
            c cVar = new c(playbackParameters, z2, C.TIME_UNSET, C.TIME_UNSET, null);
            if (i()) {
                this.t = cVar;
            } else {
                this.u = cVar;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        boolean z2 = false;
        this.R = false;
        if (i()) {
            AudioTrackPositionTracker audioTrackPositionTracker = this.i;
            audioTrackPositionTracker.l = 0;
            audioTrackPositionTracker.w = 0;
            audioTrackPositionTracker.v = 0;
            audioTrackPositionTracker.m = 0;
            audioTrackPositionTracker.C = 0;
            audioTrackPositionTracker.F = 0;
            audioTrackPositionTracker.k = false;
            if (audioTrackPositionTracker.x == C.TIME_UNSET) {
                ((m) Assertions.checkNotNull(audioTrackPositionTracker.f)).a();
                z2 = true;
            }
            if (z2) {
                this.r.pause();
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.R = true;
        if (i()) {
            ((m) Assertions.checkNotNull(this.i.f)).a();
            this.r.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() throws AudioSink.WriteException {
        if (!this.P && i() && b()) {
            m();
            this.P = true;
        }
    }

    @RequiresApi(23)
    public final void q(PlaybackParameters playbackParameters) {
        if (i()) {
            try {
                this.r.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(playbackParameters.speed).setPitch(playbackParameters.pitch).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e2) {
                Log.w("AudioTrack", "Failed to set playback params", e2);
            }
            playbackParameters = new PlaybackParameters(this.r.getPlaybackParams().getSpeed(), this.r.getPlaybackParams().getPitch());
            AudioTrackPositionTracker audioTrackPositionTracker = this.i;
            audioTrackPositionTracker.j = playbackParameters.speed;
            m mVar = audioTrackPositionTracker.f;
            if (mVar != null) {
                mVar.a();
            }
        }
        this.v = playbackParameters;
    }

    public final void r() {
        if (i()) {
            if (Util.SDK_INT >= 21) {
                this.r.setVolume(this.G);
                return;
            }
            AudioTrack audioTrack = this.r;
            float f2 = this.G;
            audioTrack.setStereoVolume(f2, f2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        flush();
        AudioTrack audioTrack = this.o;
        if (audioTrack != null) {
            this.o = null;
            new o(this, audioTrack).start();
        }
        for (AudioProcessor audioProcessor : this.f) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor2 : this.g) {
            audioProcessor2.reset();
        }
        this.S = 0;
        this.R = false;
        this.W = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e2, code lost:
        if (r15 < r14) goto L_0x00e4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s(java.nio.ByteBuffer r13, long r14) throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        /*
        // Method dump skipped, instructions count: 372
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.s(java.nio.ByteBuffer, long):void");
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioAttributes(AudioAttributes audioAttributes) {
        if (!this.s.equals(audioAttributes)) {
            this.s = audioAttributes;
            if (!this.U) {
                flush();
                this.S = 0;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int i2) {
        if (this.S != i2) {
            this.S = i2;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        if (!this.T.equals(auxEffectInfo)) {
            int i2 = auxEffectInfo.effectId;
            float f2 = auxEffectInfo.sendLevel;
            AudioTrack audioTrack = this.r;
            if (audioTrack != null) {
                if (this.T.effectId != i2) {
                    audioTrack.attachAuxEffect(i2);
                }
                if (i2 != 0) {
                    this.r.setAuxEffectSendLevel(f2);
                }
            }
            this.T = auxEffectInfo;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setListener(AudioSink.Listener listener) {
        this.n = listener;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        PlaybackParameters playbackParameters2 = new PlaybackParameters(Util.constrainValue(playbackParameters.speed, 0.1f, 8.0f), Util.constrainValue(playbackParameters.pitch, 0.1f, 8.0f));
        if (!this.k || Util.SDK_INT < 23) {
            p(playbackParameters2, getSkipSilenceEnabled());
        } else {
            q(playbackParameters2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setSkipSilenceEnabled(boolean z2) {
        p(e(), z2);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f2) {
        if (this.G != f2) {
            this.G = f2;
            r();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean supportsFormat(Format format) {
        return getFormatSupport(format) != 0;
    }

    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities, AudioProcessor[] audioProcessorArr, boolean z2) {
        this(audioCapabilities, new DefaultAudioProcessorChain(audioProcessorArr), z2, false, false);
    }

    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities, AudioProcessorChain audioProcessorChain, boolean z2, boolean z3, boolean z4) {
        this.a = audioCapabilities;
        this.b = (AudioProcessorChain) Assertions.checkNotNull(audioProcessorChain);
        int i2 = Util.SDK_INT;
        this.c = i2 >= 21 && z2;
        this.k = i2 >= 23 && z3;
        this.l = i2 >= 29 && z4;
        this.h = new ConditionVariable(true);
        this.i = new AudioTrackPositionTracker(new d(null));
        n nVar = new n();
        this.d = nVar;
        s sVar = new s();
        this.e = sVar;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new q(), nVar, sVar);
        Collections.addAll(arrayList, audioProcessorChain.getAudioProcessors());
        this.f = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.g = new AudioProcessor[]{new p()};
        this.G = 1.0f;
        this.s = AudioAttributes.DEFAULT;
        this.S = 0;
        this.T = new AuxEffectInfo(0, 0.0f);
        PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
        this.u = new c(playbackParameters, false, 0, 0, null);
        this.v = playbackParameters;
        this.O = -1;
        this.H = new AudioProcessor[0];
        this.I = new ByteBuffer[0];
        this.j = new ArrayDeque<>();
    }
}
