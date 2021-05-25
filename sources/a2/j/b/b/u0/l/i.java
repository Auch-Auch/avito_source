package a2.j.b.b.u0.l;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ts.TsUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
public final class i extends BinarySearchSeeker {

    public static final class a implements BinarySearchSeeker.TimestampSeeker {
        public final TimestampAdjuster a;
        public final ParsableByteArray b = new ParsableByteArray();
        public final int c;
        public final int d;

        public a(int i, TimestampAdjuster timestampAdjuster, int i2) {
            this.c = i;
            this.a = timestampAdjuster;
            this.d = i2;
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public void onSeekFinished() {
            this.b.reset(Util.EMPTY_BYTE_ARRAY);
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public BinarySearchSeeker.TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j) throws IOException {
            int findSyncBytePosition;
            int findSyncBytePosition2;
            long position = extractorInput.getPosition();
            int min = (int) Math.min((long) this.d, extractorInput.getLength() - position);
            this.b.reset(min);
            extractorInput.peekFully(this.b.getData(), 0, min);
            ParsableByteArray parsableByteArray = this.b;
            int limit = parsableByteArray.limit();
            long j2 = -1;
            long j3 = -1;
            long j4 = -9223372036854775807L;
            while (parsableByteArray.bytesLeft() >= 188 && (findSyncBytePosition2 = (findSyncBytePosition = TsUtil.findSyncBytePosition(parsableByteArray.getData(), parsableByteArray.getPosition(), limit)) + 188) <= limit) {
                long readPcrFromPacket = TsUtil.readPcrFromPacket(parsableByteArray, findSyncBytePosition, this.c);
                if (readPcrFromPacket != C.TIME_UNSET) {
                    long adjustTsTimestamp = this.a.adjustTsTimestamp(readPcrFromPacket);
                    if (adjustTsTimestamp > j) {
                        if (j4 == C.TIME_UNSET) {
                            return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(adjustTsTimestamp, position);
                        }
                        return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(position + j3);
                    } else if (100000 + adjustTsTimestamp > j) {
                        return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(position + ((long) findSyncBytePosition));
                    } else {
                        j3 = (long) findSyncBytePosition;
                        j4 = adjustTsTimestamp;
                    }
                }
                parsableByteArray.setPosition(findSyncBytePosition2);
                j2 = (long) findSyncBytePosition2;
            }
            if (j4 != C.TIME_UNSET) {
                return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(j4, position + j2);
            }
            return BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
        }
    }

    public i(TimestampAdjuster timestampAdjuster, long j, long j2, int i, int i2) {
        super(new BinarySearchSeeker.DefaultSeekTimestampConverter(), new a(i, timestampAdjuster, i2), j, 0, j + 1, 0, j2, 188, 940);
    }
}
