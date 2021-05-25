package com.google.android.exoplayer2.extractor;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
public abstract class BinarySearchSeeker {
    public final int a;
    public final BinarySearchSeekMap seekMap;
    @Nullable
    public SeekOperationParams seekOperationParams;
    public final TimestampSeeker timestampSeeker;

    public static class BinarySearchSeekMap implements SeekMap {
        public final SeekTimestampConverter a;
        public final long b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;
        public final long g;

        public BinarySearchSeekMap(SeekTimestampConverter seekTimestampConverter, long j, long j2, long j3, long j4, long j5, long j6) {
            this.a = seekTimestampConverter;
            this.b = j;
            this.c = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.b;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekMap.SeekPoints getSeekPoints(long j) {
            return new SeekMap.SeekPoints(new SeekPoint(j, SeekOperationParams.calculateNextSearchBytePosition(this.a.timeUsToTargetTime(j), this.c, this.d, this.e, this.f, this.g)));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }

        public long timeUsToTargetTime(long j) {
            return this.a.timeUsToTargetTime(j);
        }
    }

    public static final class DefaultSeekTimestampConverter implements SeekTimestampConverter {
        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter
        public long timeUsToTargetTime(long j) {
            return j;
        }
    }

    public static class SeekOperationParams {
        public final long a;
        public final long b;
        public final long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;

        public SeekOperationParams(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.a = j;
            this.b = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
            this.c = j7;
            this.h = calculateNextSearchBytePosition(j2, j3, j4, j5, j6, j7);
        }

        public static long calculateNextSearchBytePosition(long j, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 >= j5 || j2 + 1 >= j3) {
                return j4;
            }
            long j7 = (long) (((float) (j - j2)) * (((float) (j5 - j4)) / ((float) (j3 - j2))));
            return Util.constrainValue(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
        }
    }

    public interface SeekTimestampConverter {
        long timeUsToTargetTime(long j);
    }

    public static final class TimestampSearchResult {
        public static final TimestampSearchResult NO_TIMESTAMP_IN_RANGE_RESULT = new TimestampSearchResult(-3, C.TIME_UNSET, -1);
        public static final int TYPE_NO_TIMESTAMP = -3;
        public static final int TYPE_POSITION_OVERESTIMATED = -1;
        public static final int TYPE_POSITION_UNDERESTIMATED = -2;
        public static final int TYPE_TARGET_TIMESTAMP_FOUND = 0;
        public final int a;
        public final long b;
        public final long c;

        public TimestampSearchResult(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }

        public static TimestampSearchResult overestimatedResult(long j, long j2) {
            return new TimestampSearchResult(-1, j, j2);
        }

        public static TimestampSearchResult targetFoundResult(long j) {
            return new TimestampSearchResult(0, C.TIME_UNSET, j);
        }

        public static TimestampSearchResult underestimatedResult(long j, long j2) {
            return new TimestampSearchResult(-2, j, j2);
        }
    }

    public interface TimestampSeeker {
        void onSeekFinished();

        TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j) throws IOException;
    }

    public BinarySearchSeeker(SeekTimestampConverter seekTimestampConverter, TimestampSeeker timestampSeeker2, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.timestampSeeker = timestampSeeker2;
        this.a = i;
        this.seekMap = new BinarySearchSeekMap(seekTimestampConverter, j, j2, j3, j4, j5, j6);
    }

    public SeekOperationParams createSeekParamsForTargetTimeUs(long j) {
        long timeUsToTargetTime = this.seekMap.timeUsToTargetTime(j);
        BinarySearchSeekMap binarySearchSeekMap = this.seekMap;
        return new SeekOperationParams(j, timeUsToTargetTime, binarySearchSeekMap.c, binarySearchSeekMap.d, binarySearchSeekMap.e, binarySearchSeekMap.f, binarySearchSeekMap.g);
    }

    public final SeekMap getSeekMap() {
        return this.seekMap;
    }

    public int handlePendingSeek(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            SeekOperationParams seekOperationParams2 = (SeekOperationParams) Assertions.checkStateNotNull(this.seekOperationParams);
            long j = seekOperationParams2.f;
            long j2 = seekOperationParams2.g;
            long j3 = seekOperationParams2.h;
            if (j2 - j <= ((long) this.a)) {
                markSeekOperationFinished(false, j);
                return seekToPosition(extractorInput, j, positionHolder);
            } else if (!skipInputUntilPosition(extractorInput, j3)) {
                return seekToPosition(extractorInput, j3, positionHolder);
            } else {
                extractorInput.resetPeekPosition();
                TimestampSearchResult searchForTimestamp = this.timestampSeeker.searchForTimestamp(extractorInput, seekOperationParams2.b);
                int i = searchForTimestamp.a;
                if (i == -3) {
                    markSeekOperationFinished(false, j3);
                    return seekToPosition(extractorInput, j3, positionHolder);
                } else if (i == -2) {
                    long j4 = searchForTimestamp.b;
                    long j5 = searchForTimestamp.c;
                    seekOperationParams2.d = j4;
                    seekOperationParams2.f = j5;
                    seekOperationParams2.h = SeekOperationParams.calculateNextSearchBytePosition(seekOperationParams2.b, j4, seekOperationParams2.e, j5, seekOperationParams2.g, seekOperationParams2.c);
                } else if (i == -1) {
                    long j6 = searchForTimestamp.b;
                    long j7 = searchForTimestamp.c;
                    seekOperationParams2.e = j6;
                    seekOperationParams2.g = j7;
                    seekOperationParams2.h = SeekOperationParams.calculateNextSearchBytePosition(seekOperationParams2.b, seekOperationParams2.d, j6, seekOperationParams2.f, j7, seekOperationParams2.c);
                } else if (i == 0) {
                    skipInputUntilPosition(extractorInput, searchForTimestamp.c);
                    markSeekOperationFinished(true, searchForTimestamp.c);
                    return seekToPosition(extractorInput, searchForTimestamp.c, positionHolder);
                } else {
                    throw new IllegalStateException("Invalid case");
                }
            }
        }
    }

    public final boolean isSeeking() {
        return this.seekOperationParams != null;
    }

    public final void markSeekOperationFinished(boolean z, long j) {
        this.seekOperationParams = null;
        this.timestampSeeker.onSeekFinished();
        onSeekOperationFinished(z, j);
    }

    public void onSeekOperationFinished(boolean z, long j) {
    }

    public final int seekToPosition(ExtractorInput extractorInput, long j, PositionHolder positionHolder) {
        if (j == extractorInput.getPosition()) {
            return 0;
        }
        positionHolder.position = j;
        return 1;
    }

    public final void setSeekTargetUs(long j) {
        SeekOperationParams seekOperationParams2 = this.seekOperationParams;
        if (seekOperationParams2 == null || seekOperationParams2.a != j) {
            this.seekOperationParams = createSeekParamsForTargetTimeUs(j);
        }
    }

    public final boolean skipInputUntilPosition(ExtractorInput extractorInput, long j) throws IOException {
        long position = j - extractorInput.getPosition();
        if (position < 0 || position > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        extractorInput.skipFully((int) position);
        return true;
    }
}
