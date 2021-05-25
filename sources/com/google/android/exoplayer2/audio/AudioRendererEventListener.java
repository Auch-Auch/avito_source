package com.google.android.exoplayer2.audio;

import a2.j.b.b.r0.a;
import a2.j.b.b.r0.b;
import a2.j.b.b.r0.c;
import a2.j.b.b.r0.d;
import a2.j.b.b.r0.e;
import a2.j.b.b.r0.f;
import a2.j.b.b.r0.g;
import a2.j.b.b.r0.h;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;
public interface AudioRendererEventListener {

    public static final class EventDispatcher {
        @Nullable
        public final Handler a;
        @Nullable
        public final AudioRendererEventListener b;

        public EventDispatcher(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener) {
            this.a = audioRendererEventListener != null ? (Handler) Assertions.checkNotNull(handler) : null;
            this.b = audioRendererEventListener;
        }

        public void audioSessionId(int i) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new d(this, i));
            }
        }

        public void decoderInitialized(String str, long j, long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new e(this, str, j, j2));
            }
        }

        public void disabled(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new c(this, decoderCounters));
            }
        }

        public void enabled(DecoderCounters decoderCounters) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new h(this, decoderCounters));
            }
        }

        public void inputFormatChanged(Format format) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new a(this, format));
            }
        }

        public void positionAdvancing(long j) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new f(this, j));
            }
        }

        public void skipSilenceEnabledChanged(boolean z) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new b(this, z));
            }
        }

        public void underrun(int i, long j, long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new g(this, i, j, j2));
            }
        }
    }

    void onAudioDecoderInitialized(String str, long j, long j2);

    void onAudioDisabled(DecoderCounters decoderCounters);

    void onAudioEnabled(DecoderCounters decoderCounters);

    void onAudioInputFormatChanged(Format format);

    void onAudioPositionAdvancing(long j);

    void onAudioSessionId(int i);

    void onAudioUnderrun(int i, long j, long j2);

    void onSkipSilenceEnabledChanged(boolean z);
}
