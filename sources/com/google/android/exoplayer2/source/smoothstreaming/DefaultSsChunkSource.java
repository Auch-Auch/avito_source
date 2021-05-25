package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.List;
public class DefaultSsChunkSource implements SsChunkSource {
    public final LoaderErrorThrower a;
    public final int b;
    public final ChunkExtractorWrapper[] c;
    public final DataSource d;
    public TrackSelection e;
    public SsManifest f;
    public int g;
    public IOException h;

    public static final class Factory implements SsChunkSource.Factory {
        public final DataSource.Factory a;

        public Factory(DataSource.Factory factory) {
            this.a = factory;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory
        public SsChunkSource createChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i, TrackSelection trackSelection, @Nullable TransferListener transferListener) {
            DataSource createDataSource = this.a.createDataSource();
            if (transferListener != null) {
                createDataSource.addTransferListener(transferListener);
            }
            return new DefaultSsChunkSource(loaderErrorThrower, ssManifest, i, trackSelection, createDataSource);
        }
    }

    public static final class a extends BaseMediaChunkIterator {
        public final SsManifest.StreamElement d;
        public final int e;

        public a(SsManifest.StreamElement streamElement, int i, int i2) {
            super((long) i2, (long) (streamElement.chunkCount - 1));
            this.d = streamElement;
            this.e = i;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            checkInBounds();
            return this.d.getChunkDurationUs((int) getCurrentIndex()) + this.d.getStartTimeUs((int) getCurrentIndex());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.d.getStartTimeUs((int) getCurrentIndex());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public DataSpec getDataSpec() {
            checkInBounds();
            return new DataSpec(this.d.buildRequestUri(this.e, (int) getCurrentIndex()));
        }
    }

    public DefaultSsChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i, TrackSelection trackSelection, DataSource dataSource) {
        this.a = loaderErrorThrower;
        this.f = ssManifest;
        this.b = i;
        this.e = trackSelection;
        this.d = dataSource;
        SsManifest.StreamElement streamElement = ssManifest.streamElements[i];
        this.c = new ChunkExtractorWrapper[trackSelection.length()];
        for (int i2 = 0; i2 < this.c.length; i2++) {
            int indexInTrackGroup = trackSelection.getIndexInTrackGroup(i2);
            Format format = streamElement.formats[indexInTrackGroup];
            TrackEncryptionBox[] trackEncryptionBoxArr = format.drmInitData != null ? ssManifest.protectionElement.trackEncryptionBoxes : null;
            int i3 = streamElement.type;
            this.c[i2] = new ChunkExtractorWrapper(new FragmentedMp4Extractor(3, null, new Track(indexInTrackGroup, i3, streamElement.timescale, C.TIME_UNSET, ssManifest.durationUs, format, 0, trackEncryptionBoxArr, i3 == 2 ? 4 : 0, null, null)), streamElement.type, format);
        }
    }

    public static MediaChunk a(Format format, DataSource dataSource, Uri uri, String str, int i, long j, long j2, long j3, int i2, Object obj, ChunkExtractorWrapper chunkExtractorWrapper) {
        return new ContainerMediaChunk(dataSource, new DataSpec(uri, 0, -1, null), format, i2, obj, j, j2, j3, (long) C.TIME_UNSET, (long) i, 1, j, chunkExtractorWrapper);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        SsManifest.StreamElement streamElement = this.f.streamElements[this.b];
        int chunkIndex = streamElement.getChunkIndex(j);
        long startTimeUs = streamElement.getStartTimeUs(chunkIndex);
        return Util.resolveSeekPositionUs(j, seekParameters, startTimeUs, (startTimeUs >= j || chunkIndex >= streamElement.chunkCount + -1) ? startTimeUs : streamElement.getStartTimeUs(chunkIndex + 1));
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public final void getNextChunk(long j, long j2, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        int i;
        long j3;
        if (this.h == null) {
            SsManifest ssManifest = this.f;
            SsManifest.StreamElement streamElement = ssManifest.streamElements[this.b];
            if (streamElement.chunkCount == 0) {
                chunkHolder.endOfStream = !ssManifest.isLive;
                return;
            }
            if (list.isEmpty()) {
                i = streamElement.getChunkIndex(j2);
            } else {
                i = (int) (((MediaChunk) list.get(list.size() - 1)).getNextChunkIndex() - ((long) this.g));
                if (i < 0) {
                    this.h = new BehindLiveWindowException();
                    return;
                }
            }
            if (i >= streamElement.chunkCount) {
                chunkHolder.endOfStream = !this.f.isLive;
                return;
            }
            long j4 = j2 - j;
            SsManifest ssManifest2 = this.f;
            if (!ssManifest2.isLive) {
                j3 = -9223372036854775807L;
            } else {
                SsManifest.StreamElement streamElement2 = ssManifest2.streamElements[this.b];
                int i2 = streamElement2.chunkCount - 1;
                j3 = (streamElement2.getChunkDurationUs(i2) + streamElement2.getStartTimeUs(i2)) - j;
            }
            int length = this.e.length();
            MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
            for (int i3 = 0; i3 < length; i3++) {
                mediaChunkIteratorArr[i3] = new a(streamElement, this.e.getIndexInTrackGroup(i3), i);
            }
            this.e.updateSelectedTrack(j, j4, j3, list, mediaChunkIteratorArr);
            long startTimeUs = streamElement.getStartTimeUs(i);
            long chunkDurationUs = streamElement.getChunkDurationUs(i) + startTimeUs;
            long j5 = list.isEmpty() ? j2 : -9223372036854775807L;
            int i4 = i + this.g;
            int selectedIndex = this.e.getSelectedIndex();
            chunkHolder.chunk = a(this.e.getSelectedFormat(), this.d, streamElement.buildRequestUri(this.e.getIndexInTrackGroup(selectedIndex), i), null, i4, startTimeUs, chunkDurationUs, j5, this.e.getSelectionReason(), this.e.getSelectionData(), this.c[selectedIndex]);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public int getPreferredQueueSize(long j, List<? extends MediaChunk> list) {
        if (this.h != null || this.e.length() < 2) {
            return list.size();
        }
        return this.e.evaluateQueueSize(j, list);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() throws IOException {
        IOException iOException = this.h;
        if (iOException == null) {
            this.a.maybeThrowError();
            return;
        }
        throw iOException;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(Chunk chunk) {
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(Chunk chunk, boolean z, Exception exc, long j) {
        if (z && j != C.TIME_UNSET) {
            TrackSelection trackSelection = this.e;
            if (trackSelection.blacklist(trackSelection.indexOf(chunk.trackFormat), j)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource
    public void updateManifest(SsManifest ssManifest) {
        SsManifest.StreamElement[] streamElementArr = this.f.streamElements;
        int i = this.b;
        SsManifest.StreamElement streamElement = streamElementArr[i];
        int i2 = streamElement.chunkCount;
        SsManifest.StreamElement streamElement2 = ssManifest.streamElements[i];
        if (i2 == 0 || streamElement2.chunkCount == 0) {
            this.g += i2;
        } else {
            int i3 = i2 - 1;
            long startTimeUs = streamElement.getStartTimeUs(i3);
            long startTimeUs2 = streamElement2.getStartTimeUs(0);
            if (streamElement.getChunkDurationUs(i3) + startTimeUs <= startTimeUs2) {
                this.g += i2;
            } else {
                this.g = streamElement.getChunkIndex(startTimeUs2) + this.g;
            }
        }
        this.f = ssManifest;
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource
    public void updateTrackSelection(TrackSelection trackSelection) {
        this.e = trackSelection;
    }
}
