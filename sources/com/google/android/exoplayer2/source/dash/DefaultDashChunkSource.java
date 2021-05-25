package com.google.android.exoplayer2.source.dash;

import a2.b.a.a.a;
import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class DefaultDashChunkSource implements DashChunkSource {
    public final LoaderErrorThrower a;
    public final int[] b;
    public final int c;
    public final DataSource d;
    public final long e;
    public final int f;
    @Nullable
    public final PlayerEmsgHandler.PlayerTrackEmsgHandler g;
    public TrackSelection h;
    public DashManifest i;
    public int j;
    public IOException k;
    public boolean l;
    public long m = C.TIME_UNSET;
    public final RepresentationHolder[] representationHolders;

    public static final class Factory implements DashChunkSource.Factory {
        public final DataSource.Factory a;
        public final int b;

        public Factory(DataSource.Factory factory) {
            this(factory, 1);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashChunkSource.Factory
        public DashChunkSource createDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i, int[] iArr, TrackSelection trackSelection, int i2, long j, boolean z, List<Format> list, @Nullable PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, @Nullable TransferListener transferListener) {
            DataSource createDataSource = this.a.createDataSource();
            if (transferListener != null) {
                createDataSource.addTransferListener(transferListener);
            }
            return new DefaultDashChunkSource(loaderErrorThrower, dashManifest, i, iArr, trackSelection, i2, createDataSource, j, this.b, z, list, playerTrackEmsgHandler);
        }

        public Factory(DataSource.Factory factory, int i) {
            this.a = factory;
            this.b = i;
        }
    }

    public static final class RepresentationSegmentIterator extends BaseMediaChunkIterator {
        public final RepresentationHolder d;

        public RepresentationSegmentIterator(RepresentationHolder representationHolder, long j, long j2) {
            super(j, j2);
            this.d = representationHolder;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            checkInBounds();
            return this.d.getSegmentEndTimeUs(getCurrentIndex());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.d.getSegmentStartTimeUs(getCurrentIndex());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public DataSpec getDataSpec() {
            checkInBounds();
            RepresentationHolder representationHolder = this.d;
            Representation representation = representationHolder.representation;
            RangedUri segmentUrl = representationHolder.getSegmentUrl(getCurrentIndex());
            return new DataSpec(segmentUrl.resolveUri(representation.baseUrl), segmentUrl.start, segmentUrl.length, representation.getCacheKey());
        }
    }

    public DefaultDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i2, int[] iArr, TrackSelection trackSelection, int i3, DataSource dataSource, long j2, int i4, boolean z, List<Format> list, @Nullable PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler) {
        this.a = loaderErrorThrower;
        this.i = dashManifest;
        this.b = iArr;
        this.h = trackSelection;
        this.c = i3;
        this.d = dataSource;
        this.j = i2;
        this.e = j2;
        this.f = i4;
        this.g = playerTrackEmsgHandler;
        long periodDurationUs = dashManifest.getPeriodDurationUs(i2);
        ArrayList<Representation> a3 = a();
        this.representationHolders = new RepresentationHolder[trackSelection.length()];
        for (int i5 = 0; i5 < this.representationHolders.length; i5++) {
            this.representationHolders[i5] = new RepresentationHolder(periodDurationUs, i3, a3.get(trackSelection.getIndexInTrackGroup(i5)), z, list, playerTrackEmsgHandler);
        }
    }

    public final ArrayList<Representation> a() {
        List<AdaptationSet> list = this.i.getPeriod(this.j).adaptationSets;
        ArrayList<Representation> arrayList = new ArrayList<>();
        for (int i2 : this.b) {
            arrayList.addAll(list.get(i2).representations);
        }
        return arrayList;
    }

    public final long b(RepresentationHolder representationHolder, @Nullable MediaChunk mediaChunk, long j2, long j3, long j4) {
        if (mediaChunk != null) {
            return mediaChunk.getNextChunkIndex();
        }
        return Util.constrainValue(representationHolder.getSegmentNum(j2), j3, j4);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public long getAdjustedSeekPositionUs(long j2, SeekParameters seekParameters) {
        RepresentationHolder[] representationHolderArr = this.representationHolders;
        for (RepresentationHolder representationHolder : representationHolderArr) {
            if (representationHolder.segmentIndex != null) {
                long segmentNum = representationHolder.getSegmentNum(j2);
                long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(segmentNum);
                return Util.resolveSeekPositionUs(j2, seekParameters, segmentStartTimeUs, (segmentStartTimeUs >= j2 || segmentNum >= ((long) (representationHolder.getSegmentCount() + -1))) ? segmentStartTimeUs : representationHolder.getSegmentStartTimeUs(segmentNum + 1));
            }
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void getNextChunk(long j2, long j3, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        long j4;
        long j5;
        int i2;
        int i3;
        MediaChunkIterator[] mediaChunkIteratorArr;
        if (this.k == null) {
            long j6 = j3 - j2;
            DashManifest dashManifest = this.i;
            boolean z = dashManifest.dynamic;
            long j7 = C.TIME_UNSET;
            long j8 = z && (this.m > C.TIME_UNSET ? 1 : (this.m == C.TIME_UNSET ? 0 : -1)) != 0 ? this.m - j2 : -9223372036854775807L;
            long msToUs = C.msToUs(this.i.getPeriod(this.j).startMs) + C.msToUs(dashManifest.availabilityStartTimeMs) + j3;
            PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.g;
            if (playerTrackEmsgHandler == null || !playerTrackEmsgHandler.maybeRefreshManifestBeforeLoadingNextChunk(msToUs)) {
                if (this.e != 0) {
                    j4 = SystemClock.elapsedRealtime() + this.e;
                } else {
                    j4 = System.currentTimeMillis();
                }
                long j9 = j4 * 1000;
                MediaChunk mediaChunk = list.isEmpty() ? null : (MediaChunk) a.j2(list, 1);
                int length = this.h.length();
                MediaChunkIterator[] mediaChunkIteratorArr2 = new MediaChunkIterator[length];
                int i4 = 0;
                while (i4 < length) {
                    RepresentationHolder representationHolder = this.representationHolders[i4];
                    if (representationHolder.segmentIndex == null) {
                        mediaChunkIteratorArr2[i4] = MediaChunkIterator.EMPTY;
                        mediaChunkIteratorArr = mediaChunkIteratorArr2;
                        i3 = i4;
                        i2 = length;
                        j5 = j9;
                    } else {
                        long firstAvailableSegmentNum = representationHolder.getFirstAvailableSegmentNum(this.i, this.j, j9);
                        long lastAvailableSegmentNum = representationHolder.getLastAvailableSegmentNum(this.i, this.j, j9);
                        mediaChunkIteratorArr = mediaChunkIteratorArr2;
                        i3 = i4;
                        i2 = length;
                        j5 = j9;
                        long b2 = b(representationHolder, mediaChunk, j3, firstAvailableSegmentNum, lastAvailableSegmentNum);
                        if (b2 < firstAvailableSegmentNum) {
                            mediaChunkIteratorArr[i3] = MediaChunkIterator.EMPTY;
                        } else {
                            mediaChunkIteratorArr[i3] = new RepresentationSegmentIterator(representationHolder, b2, lastAvailableSegmentNum);
                        }
                    }
                    i4 = i3 + 1;
                    mediaChunkIteratorArr2 = mediaChunkIteratorArr;
                    length = i2;
                    j9 = j5;
                }
                this.h.updateSelectedTrack(j2, j6, j8, list, mediaChunkIteratorArr2);
                RepresentationHolder representationHolder2 = this.representationHolders[this.h.getSelectedIndex()];
                ChunkExtractorWrapper chunkExtractorWrapper = representationHolder2.a;
                if (chunkExtractorWrapper != null) {
                    Representation representation = representationHolder2.representation;
                    RangedUri initializationUri = chunkExtractorWrapper.getSampleFormats() == null ? representation.getInitializationUri() : null;
                    RangedUri indexUri = representationHolder2.segmentIndex == null ? representation.getIndexUri() : null;
                    if (!(initializationUri == null && indexUri == null)) {
                        chunkHolder.chunk = newInitializationChunk(representationHolder2, this.d, this.h.getSelectedFormat(), this.h.getSelectionReason(), this.h.getSelectionData(), initializationUri, indexUri);
                        return;
                    }
                }
                long j10 = representationHolder2.b;
                int i5 = (j10 > C.TIME_UNSET ? 1 : (j10 == C.TIME_UNSET ? 0 : -1));
                boolean z2 = i5 != 0;
                if (representationHolder2.getSegmentCount() == 0) {
                    chunkHolder.endOfStream = z2;
                    return;
                }
                long firstAvailableSegmentNum2 = representationHolder2.getFirstAvailableSegmentNum(this.i, this.j, j9);
                long lastAvailableSegmentNum2 = representationHolder2.getLastAvailableSegmentNum(this.i, this.j, j9);
                if (this.i.dynamic) {
                    j7 = representationHolder2.getSegmentEndTimeUs(lastAvailableSegmentNum2);
                }
                this.m = j7;
                long b3 = b(representationHolder2, mediaChunk, j3, firstAvailableSegmentNum2, lastAvailableSegmentNum2);
                if (b3 < firstAvailableSegmentNum2) {
                    this.k = new BehindLiveWindowException();
                    return;
                }
                int i6 = (b3 > lastAvailableSegmentNum2 ? 1 : (b3 == lastAvailableSegmentNum2 ? 0 : -1));
                if (i6 > 0 || (this.l && i6 >= 0)) {
                    chunkHolder.endOfStream = z2;
                } else if (!z2 || representationHolder2.getSegmentStartTimeUs(b3) < j10) {
                    int min = (int) Math.min((long) this.f, (lastAvailableSegmentNum2 - b3) + 1);
                    if (i5 != 0) {
                        while (min > 1 && representationHolder2.getSegmentStartTimeUs((((long) min) + b3) - 1) >= j10) {
                            min--;
                        }
                    }
                    chunkHolder.chunk = newMediaChunk(representationHolder2, this.d, this.c, this.h.getSelectedFormat(), this.h.getSelectionReason(), this.h.getSelectionData(), b3, min, list.isEmpty() ? j3 : -9223372036854775807L);
                } else {
                    chunkHolder.endOfStream = true;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public int getPreferredQueueSize(long j2, List<? extends MediaChunk> list) {
        if (this.k != null || this.h.length() < 2) {
            return list.size();
        }
        return this.h.evaluateQueueSize(j2, list);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() throws IOException {
        IOException iOException = this.k;
        if (iOException == null) {
            this.a.maybeThrowError();
            return;
        }
        throw iOException;
    }

    public Chunk newInitializationChunk(RepresentationHolder representationHolder, DataSource dataSource, Format format, int i2, Object obj, RangedUri rangedUri, RangedUri rangedUri2) {
        String str = representationHolder.representation.baseUrl;
        if (rangedUri == null || (rangedUri2 = rangedUri.attemptMerge(rangedUri2, str)) != null) {
            rangedUri = rangedUri2;
        }
        return new InitializationChunk(dataSource, new DataSpec(rangedUri.resolveUri(str), rangedUri.start, rangedUri.length, representationHolder.representation.getCacheKey()), format, i2, obj, representationHolder.a);
    }

    public Chunk newMediaChunk(RepresentationHolder representationHolder, DataSource dataSource, int i2, Format format, int i3, Object obj, long j2, int i4, long j3) {
        Representation representation = representationHolder.representation;
        long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(j2);
        RangedUri segmentUrl = representationHolder.getSegmentUrl(j2);
        String str = representation.baseUrl;
        if (representationHolder.a == null) {
            return new SingleSampleMediaChunk(dataSource, new DataSpec(segmentUrl.resolveUri(str), segmentUrl.start, segmentUrl.length, representation.getCacheKey()), format, i3, obj, segmentStartTimeUs, representationHolder.getSegmentEndTimeUs(j2), j2, i2, format);
        }
        int i5 = 1;
        int i6 = 1;
        while (i5 < i4) {
            RangedUri attemptMerge = segmentUrl.attemptMerge(representationHolder.getSegmentUrl(((long) i5) + j2), str);
            if (attemptMerge == null) {
                break;
            }
            i6++;
            i5++;
            segmentUrl = attemptMerge;
        }
        long segmentEndTimeUs = representationHolder.getSegmentEndTimeUs((((long) i6) + j2) - 1);
        long j4 = representationHolder.b;
        return new ContainerMediaChunk(dataSource, new DataSpec(segmentUrl.resolveUri(str), segmentUrl.start, segmentUrl.length, representation.getCacheKey()), format, i3, obj, segmentStartTimeUs, segmentEndTimeUs, j3, (j4 == C.TIME_UNSET || j4 > segmentEndTimeUs) ? -9223372036854775807L : j4, j2, i6, -representation.presentationTimeOffsetUs, representationHolder.a);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(Chunk chunk) {
        SeekMap seekMap;
        if (chunk instanceof InitializationChunk) {
            int indexOf = this.h.indexOf(((InitializationChunk) chunk).trackFormat);
            RepresentationHolder representationHolder = this.representationHolders[indexOf];
            if (representationHolder.segmentIndex == null && (seekMap = representationHolder.a.getSeekMap()) != null) {
                this.representationHolders[indexOf] = new RepresentationHolder(representationHolder.b, representationHolder.representation, representationHolder.a, representationHolder.c, new DashWrappingSegmentIndex((ChunkIndex) seekMap, representationHolder.representation.presentationTimeOffsetUs));
            }
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.g;
        if (playerTrackEmsgHandler != null) {
            playerTrackEmsgHandler.onChunkLoadCompleted(chunk);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(Chunk chunk, boolean z, Exception exc, long j2) {
        RepresentationHolder representationHolder;
        int segmentCount;
        if (!z) {
            return false;
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.g;
        if (playerTrackEmsgHandler != null && playerTrackEmsgHandler.maybeRefreshManifestOnLoadingError(chunk)) {
            return true;
        }
        if (!this.i.dynamic && (chunk instanceof MediaChunk) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (segmentCount = (representationHolder = this.representationHolders[this.h.indexOf(chunk.trackFormat)]).getSegmentCount()) != -1 && segmentCount != 0) {
            if (((MediaChunk) chunk).getNextChunkIndex() > (representationHolder.getFirstSegmentNum() + ((long) segmentCount)) - 1) {
                this.l = true;
                return true;
            }
        }
        if (j2 == C.TIME_UNSET) {
            return false;
        }
        TrackSelection trackSelection = this.h;
        if (trackSelection.blacklist(trackSelection.indexOf(chunk.trackFormat), j2)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashChunkSource
    public void updateManifest(DashManifest dashManifest, int i2) {
        try {
            this.i = dashManifest;
            this.j = i2;
            long periodDurationUs = dashManifest.getPeriodDurationUs(i2);
            ArrayList<Representation> a3 = a();
            for (int i3 = 0; i3 < this.representationHolders.length; i3++) {
                RepresentationHolder[] representationHolderArr = this.representationHolders;
                representationHolderArr[i3] = representationHolderArr[i3].a(periodDurationUs, a3.get(this.h.getIndexInTrackGroup(i3)));
            }
        } catch (BehindLiveWindowException e2) {
            this.k = e2;
        }
    }

    @Override // com.google.android.exoplayer2.source.dash.DashChunkSource
    public void updateTrackSelection(TrackSelection trackSelection) {
        this.h = trackSelection;
    }

    public static final class RepresentationHolder {
        @Nullable
        public final ChunkExtractorWrapper a;
        public final long b;
        public final long c;
        public final Representation representation;
        @Nullable
        public final DashSegmentIndex segmentIndex;

        public RepresentationHolder(long j, int i, Representation representation2, boolean z, List<Format> list, @Nullable TrackOutput trackOutput) {
            ChunkExtractorWrapper b2 = b(i, representation2, z, list, trackOutput);
            DashSegmentIndex index = representation2.getIndex();
            this.b = j;
            this.representation = representation2;
            this.c = 0;
            this.a = b2;
            this.segmentIndex = index;
        }

        @Nullable
        public static ChunkExtractorWrapper b(int i, Representation representation2, boolean z, List<Format> list, @Nullable TrackOutput trackOutput) {
            Extractor extractor;
            String str = representation2.format.containerMimeType;
            if (MimeTypes.isText(str) || MimeTypes.APPLICATION_TTML.equals(str)) {
                return null;
            }
            if (MimeTypes.APPLICATION_RAWCC.equals(str)) {
                extractor = new RawCcExtractor(representation2.format);
            } else {
                if (str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM) || str.startsWith(MimeTypes.APPLICATION_WEBM)) {
                    extractor = new MatroskaExtractor(1);
                } else {
                    extractor = new FragmentedMp4Extractor(z ? 4 : 0, null, null, list, trackOutput);
                }
            }
            return new ChunkExtractorWrapper(extractor, i, representation2.format);
        }

        @CheckResult
        public RepresentationHolder a(long j, Representation representation2) throws BehindLiveWindowException {
            long j2;
            DashSegmentIndex index = this.representation.getIndex();
            DashSegmentIndex index2 = representation2.getIndex();
            if (index == null) {
                return new RepresentationHolder(j, representation2, this.a, this.c, index);
            }
            if (!index.isExplicit()) {
                return new RepresentationHolder(j, representation2, this.a, this.c, index2);
            }
            int segmentCount = index.getSegmentCount(j);
            if (segmentCount == 0) {
                return new RepresentationHolder(j, representation2, this.a, this.c, index2);
            }
            long firstSegmentNum = index.getFirstSegmentNum();
            long timeUs = index.getTimeUs(firstSegmentNum);
            long j3 = (((long) segmentCount) + firstSegmentNum) - 1;
            long durationUs = index.getDurationUs(j3, j) + index.getTimeUs(j3);
            long firstSegmentNum2 = index2.getFirstSegmentNum();
            long timeUs2 = index2.getTimeUs(firstSegmentNum2);
            long j4 = this.c;
            int i = (durationUs > timeUs2 ? 1 : (durationUs == timeUs2 ? 0 : -1));
            if (i == 0) {
                j2 = ((j3 + 1) - firstSegmentNum2) + j4;
            } else if (i < 0) {
                throw new BehindLiveWindowException();
            } else if (timeUs2 < timeUs) {
                j2 = j4 - (index2.getSegmentNum(timeUs, j) - firstSegmentNum);
            } else {
                j2 = (index.getSegmentNum(timeUs2, j) - firstSegmentNum2) + j4;
            }
            return new RepresentationHolder(j, representation2, this.a, j2, index2);
        }

        public long getFirstAvailableSegmentNum(DashManifest dashManifest, int i, long j) {
            if (getSegmentCount() != -1 || dashManifest.timeShiftBufferDepthMs == C.TIME_UNSET) {
                return getFirstSegmentNum();
            }
            return Math.max(getFirstSegmentNum(), getSegmentNum(((j - C.msToUs(dashManifest.availabilityStartTimeMs)) - C.msToUs(dashManifest.getPeriod(i).startMs)) - C.msToUs(dashManifest.timeShiftBufferDepthMs)));
        }

        public long getFirstSegmentNum() {
            return this.segmentIndex.getFirstSegmentNum() + this.c;
        }

        public long getLastAvailableSegmentNum(DashManifest dashManifest, int i, long j) {
            long firstSegmentNum;
            int segmentCount = getSegmentCount();
            if (segmentCount == -1) {
                firstSegmentNum = getSegmentNum((j - C.msToUs(dashManifest.availabilityStartTimeMs)) - C.msToUs(dashManifest.getPeriod(i).startMs));
            } else {
                firstSegmentNum = getFirstSegmentNum() + ((long) segmentCount);
            }
            return firstSegmentNum - 1;
        }

        public int getSegmentCount() {
            return this.segmentIndex.getSegmentCount(this.b);
        }

        public long getSegmentEndTimeUs(long j) {
            return this.segmentIndex.getDurationUs(j - this.c, this.b) + getSegmentStartTimeUs(j);
        }

        public long getSegmentNum(long j) {
            return this.segmentIndex.getSegmentNum(j, this.b) + this.c;
        }

        public long getSegmentStartTimeUs(long j) {
            return this.segmentIndex.getTimeUs(j - this.c);
        }

        public RangedUri getSegmentUrl(long j) {
            return this.segmentIndex.getSegmentUrl(j - this.c);
        }

        public RepresentationHolder(long j, Representation representation2, @Nullable ChunkExtractorWrapper chunkExtractorWrapper, long j2, @Nullable DashSegmentIndex dashSegmentIndex) {
            this.b = j;
            this.representation = representation2;
            this.c = j2;
            this.a = chunkExtractorWrapper;
            this.segmentIndex = dashSegmentIndex;
        }
    }
}
