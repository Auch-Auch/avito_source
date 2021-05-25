package com.google.android.exoplayer2.video;

import a2.j.b.b.f1.a;
import a2.j.b.b.f1.b;
import a2.j.b.b.f1.c;
import a2.j.b.b.f1.d;
import a2.j.b.b.f1.e;
import a2.j.b.b.f1.f;
import a2.j.b.b.f1.g;
import a2.j.b.b.f1.h;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;
public interface VideoRendererEventListener {

    public static final class EventDispatcher {
        @Nullable
        public final Handler a;
        @Nullable
        public final VideoRendererEventListener b;

        public EventDispatcher(@Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener) {
            this.a = videoRendererEventListener != null ? (Handler) Assertions.checkNotNull(handler) : null;
            this.b = videoRendererEventListener;
        }

        public void decoderInitialized(String str, long j, long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new f(this, str, j, j2));
            }
        }

        public void disabled(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new e(this, decoderCounters));
            }
        }

        public void droppedFrames(int i, long j) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new d(this, i, j));
            }
        }

        public void enabled(DecoderCounters decoderCounters) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new b(this, decoderCounters));
            }
        }

        public void inputFormatChanged(Format format) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new a(this, format));
            }
        }

        public void renderedFirstFrame(@Nullable Surface surface) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new c(this, surface));
            }
        }

        public void reportVideoFrameProcessingOffset(long j, int i) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new h(this, j, i));
            }
        }

        public void videoSizeChanged(int i, int i2, int i3, float f) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new g(this, i, i2, i3, f));
            }
        }
    }

    void onDroppedFrames(int i, long j);

    void onRenderedFirstFrame(@Nullable Surface surface);

    void onVideoDecoderInitialized(String str, long j, long j2);

    void onVideoDisabled(DecoderCounters decoderCounters);

    void onVideoEnabled(DecoderCounters decoderCounters);

    void onVideoFrameProcessingOffset(long j, int i);

    void onVideoInputFormatChanged(Format format);

    void onVideoSizeChanged(int i, int i2, int i3, float f);
}
