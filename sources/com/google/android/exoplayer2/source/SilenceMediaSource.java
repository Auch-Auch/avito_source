package com.google.android.exoplayer2.source;

import a2.j.b.b.z0.m;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
public final class SilenceMediaSource extends BaseMediaSource {
    public static final String MEDIA_ID = "SilenceMediaSource";
    public static final Format i;
    public static final MediaItem j;
    public static final byte[] k = new byte[(Util.getPcmFrameSize(2, 2) * 1024)];
    public final long g;
    public final MediaItem h;

    public static final class Factory {
        public long a;
        @Nullable
        public Object b;

        public SilenceMediaSource createMediaSource() {
            Assertions.checkState(this.a > 0);
            return new SilenceMediaSource(this.a, SilenceMediaSource.j.buildUpon().setTag(this.b).build());
        }

        public Factory setDurationUs(long j) {
            this.a = j;
            return this;
        }

        public Factory setTag(@Nullable Object obj) {
            this.b = obj;
            return this;
        }
    }

    public static final class a implements MediaPeriod {
        public static final TrackGroupArray c = new TrackGroupArray(new TrackGroup(SilenceMediaSource.i));
        public final long a;
        public final ArrayList<SampleStream> b = new ArrayList<>();

        public a(long j) {
            this.a = j;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean continueLoading(long j) {
            return false;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void discardBuffer(long j, boolean z) {
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
            return Util.constrainValue(j, 0, this.a);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getBufferedPositionUs() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getNextLoadPositionUs() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public /* synthetic */ List getStreamKeys(List list) {
            return m.$default$getStreamKeys(this, list);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public TrackGroupArray getTrackGroups() {
            return c;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void maybeThrowPrepareError() {
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void prepare(MediaPeriod.Callback callback, long j) {
            callback.onPrepared(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long readDiscontinuity() {
            return C.TIME_UNSET;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public void reevaluateBuffer(long j) {
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long seekToUs(long j) {
            long constrainValue = Util.constrainValue(j, 0, this.a);
            for (int i = 0; i < this.b.size(); i++) {
                ((b) this.b.get(i)).a(constrainValue);
            }
            return constrainValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.lang.Object[] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.lang.Object[] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.lang.Object[] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            long constrainValue = Util.constrainValue(j, 0, this.a);
            for (int i = 0; i < trackSelectionArr.length; i++) {
                if (sampleStreamArr[i] != null && (trackSelectionArr[i] == null || !zArr[i])) {
                    this.b.remove(sampleStreamArr[i]);
                    sampleStreamArr[i] = null;
                }
                if (sampleStreamArr[i] == null && trackSelectionArr[i] != null) {
                    b bVar = new b(this.a);
                    bVar.a(constrainValue);
                    this.b.add(bVar);
                    sampleStreamArr[i] = bVar;
                    zArr2[i] = true;
                }
            }
            return constrainValue;
        }
    }

    public static final class b implements SampleStream {
        public final long a;
        public boolean b;
        public long c;

        public b(long j) {
            String str = SilenceMediaSource.MEDIA_ID;
            this.a = ((long) Util.getPcmFrameSize(2, 2)) * ((j * 44100) / 1000000);
            a(0);
        }

        public void a(long j) {
            String str = SilenceMediaSource.MEDIA_ID;
            this.c = Util.constrainValue(((long) Util.getPcmFrameSize(2, 2)) * ((j * 44100) / 1000000), 0, this.a);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return true;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() {
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            if (!this.b || z) {
                formatHolder.format = SilenceMediaSource.i;
                this.b = true;
                return -5;
            }
            long j = this.a - this.c;
            if (j == 0) {
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            byte[] bArr = SilenceMediaSource.k;
            int min = (int) Math.min((long) bArr.length, j);
            decoderInputBuffer.ensureSpaceForWrite(min);
            decoderInputBuffer.data.put(bArr, 0, min);
            decoderInputBuffer.timeUs = ((this.c / ((long) Util.getPcmFrameSize(2, 2))) * 1000000) / 44100;
            decoderInputBuffer.addFlag(1);
            this.c += (long) min;
            return -4;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            long j2 = this.c;
            a(j);
            return (int) ((this.c - j2) / ((long) SilenceMediaSource.k.length));
        }
    }

    static {
        Format build = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_RAW).setChannelCount(2).setSampleRate(44100).setPcmEncoding(2).build();
        i = build;
        j = new MediaItem.Builder().setMediaId(MEDIA_ID).setUri(Uri.EMPTY).setMimeType(build.sampleMimeType).build();
    }

    public SilenceMediaSource(long j2) {
        this(j2, j);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        return new a(this.g);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.h;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @Nullable
    @Deprecated
    public Object getTag() {
        return ((MediaItem.PlaybackProperties) Assertions.checkNotNull(this.h.playbackProperties)).tag;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        refreshSourceInfo(new SinglePeriodTimeline(this.g, true, false, false, (Object) null, this.h));
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
    }

    public SilenceMediaSource(long j2, MediaItem mediaItem) {
        Assertions.checkArgument(j2 >= 0);
        this.g = j2;
        this.h = mediaItem;
    }
}
