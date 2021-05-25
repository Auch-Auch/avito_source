package com.google.android.exoplayer2;

import a2.j.b.b.m0;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;
public abstract class BaseRenderer implements Renderer, RendererCapabilities {
    public final int a;
    public final FormatHolder b = new FormatHolder();
    @Nullable
    public RendererConfiguration c;
    public int d;
    public int e;
    @Nullable
    public SampleStream f;
    @Nullable
    public Format[] g;
    public long h;
    public long i;
    public long j = Long.MIN_VALUE;
    public boolean k;
    public boolean l;

    public BaseRenderer(int i2) {
        this.a = i2;
    }

    public final ExoPlaybackException createRendererException(Exception exc, @Nullable Format format) {
        int i2;
        if (format != null && !this.l) {
            this.l = true;
            boolean z = false;
            try {
                i2 = supportsFormat(format) & 7;
            } catch (ExoPlaybackException unused) {
            } finally {
                this.l = z;
            }
            return ExoPlaybackException.createForRenderer(exc, getName(), getIndex(), format, i2);
        }
        i2 = 4;
        return ExoPlaybackException.createForRenderer(exc, getName(), getIndex(), format, i2);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void disable() {
        boolean z = true;
        if (this.e != 1) {
            z = false;
        }
        Assertions.checkState(z);
        this.b.clear();
        this.e = 0;
        this.f = null;
        this.g = null;
        this.k = false;
        onDisabled();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j2, boolean z, boolean z2, long j3, long j4) throws ExoPlaybackException {
        Assertions.checkState(this.e == 0);
        this.c = rendererConfiguration;
        this.e = 1;
        this.i = j2;
        onEnabled(z, z2);
        replaceStream(formatArr, sampleStream, j3, j4);
        onPositionReset(j2, z);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final RendererCapabilities getCapabilities() {
        return this;
    }

    public final RendererConfiguration getConfiguration() {
        return (RendererConfiguration) Assertions.checkNotNull(this.c);
    }

    public final FormatHolder getFormatHolder() {
        this.b.clear();
        return this.b;
    }

    public final int getIndex() {
        return this.d;
    }

    public final long getLastResetPositionUs() {
        return this.i;
    }

    @Override // com.google.android.exoplayer2.Renderer
    @Nullable
    public MediaClock getMediaClock() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final long getReadingPositionUs() {
        return this.j;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final int getState() {
        return this.e;
    }

    @Override // com.google.android.exoplayer2.Renderer
    @Nullable
    public final SampleStream getStream() {
        return this.f;
    }

    public final Format[] getStreamFormats() {
        return (Format[]) Assertions.checkNotNull(this.g);
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public final int getTrackType() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i2, @Nullable Object obj) throws ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean hasReadStreamToEnd() {
        return this.j == Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean isCurrentStreamFinal() {
        return this.k;
    }

    public final boolean isSourceReady() {
        return hasReadStreamToEnd() ? this.k : ((SampleStream) Assertions.checkNotNull(this.f)).isReady();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void maybeThrowStreamError() throws IOException {
        ((SampleStream) Assertions.checkNotNull(this.f)).maybeThrowError();
    }

    public void onDisabled() {
    }

    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
    }

    public void onPositionReset(long j2, boolean z) throws ExoPlaybackException {
    }

    public void onReset() {
    }

    public void onStarted() throws ExoPlaybackException {
    }

    public void onStopped() {
    }

    public void onStreamChanged(Format[] formatArr, long j2, long j3) throws ExoPlaybackException {
    }

    public final int readSource(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        int readData = ((SampleStream) Assertions.checkNotNull(this.f)).readData(formatHolder, decoderInputBuffer, z);
        if (readData == -4) {
            if (decoderInputBuffer.isEndOfStream()) {
                this.j = Long.MIN_VALUE;
                if (this.k) {
                    return -4;
                }
                return -3;
            }
            long j2 = decoderInputBuffer.timeUs + this.h;
            decoderInputBuffer.timeUs = j2;
            this.j = Math.max(this.j, j2);
        } else if (readData == -5) {
            Format format = (Format) Assertions.checkNotNull(formatHolder.format);
            if (format.subsampleOffsetUs != Long.MAX_VALUE) {
                formatHolder.format = format.buildUpon().setSubsampleOffsetUs(format.subsampleOffsetUs + this.h).build();
            }
        }
        return readData;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void replaceStream(Format[] formatArr, SampleStream sampleStream, long j2, long j3) throws ExoPlaybackException {
        Assertions.checkState(!this.k);
        this.f = sampleStream;
        this.j = j3;
        this.g = formatArr;
        this.h = j3;
        onStreamChanged(formatArr, j2, j3);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void reset() {
        Assertions.checkState(this.e == 0);
        this.b.clear();
        onReset();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void resetPosition(long j2) throws ExoPlaybackException {
        this.k = false;
        this.i = j2;
        this.j = j2;
        onPositionReset(j2, false);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setCurrentStreamFinal() {
        this.k = true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setIndex(int i2) {
        this.d = i2;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public /* synthetic */ void setOperatingRate(float f2) {
        m0.$default$setOperatingRate(this, f2);
    }

    public int skipSource(long j2) {
        return ((SampleStream) Assertions.checkNotNull(this.f)).skipData(j2 - this.h);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void start() throws ExoPlaybackException {
        boolean z = true;
        if (this.e != 1) {
            z = false;
        }
        Assertions.checkState(z);
        this.e = 2;
        onStarted();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void stop() {
        Assertions.checkState(this.e == 2);
        this.e = 1;
        onStopped();
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }
}
