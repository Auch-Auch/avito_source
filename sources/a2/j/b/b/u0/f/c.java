package a2.j.b.b.u0.f;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import java.io.IOException;
import java.util.Objects;
public final class c extends BinarySearchSeeker {

    public static final class b implements BinarySearchSeeker.TimestampSeeker {
        public final FlacStreamMetadata a;
        public final int b;
        public final FlacFrameReader.SampleNumberHolder c = new FlacFrameReader.SampleNumberHolder();

        public b(FlacStreamMetadata flacStreamMetadata, int i, a aVar) {
            this.a = flacStreamMetadata;
            this.b = i;
        }

        public final long a(ExtractorInput extractorInput) throws IOException {
            while (extractorInput.getPeekPosition() < extractorInput.getLength() - 6 && !FlacFrameReader.checkFrameHeaderFromPeek(extractorInput, this.a, this.b, this.c)) {
                extractorInput.advancePeekPosition(1);
            }
            if (extractorInput.getPeekPosition() < extractorInput.getLength() - 6) {
                return this.c.sampleNumber;
            }
            extractorInput.advancePeekPosition((int) (extractorInput.getLength() - extractorInput.getPeekPosition()));
            return this.a.totalSamples;
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public /* synthetic */ void onSeekFinished() {
            a2.j.b.b.u0.b.$default$onSeekFinished(this);
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public BinarySearchSeeker.TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j) throws IOException {
            long position = extractorInput.getPosition();
            long a3 = a(extractorInput);
            long peekPosition = extractorInput.getPeekPosition();
            extractorInput.advancePeekPosition(Math.max(6, this.a.minFrameSize));
            long a4 = a(extractorInput);
            long peekPosition2 = extractorInput.getPeekPosition();
            if (a3 <= j && a4 > j) {
                return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(peekPosition);
            }
            if (a4 <= j) {
                return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(a4, peekPosition2);
            }
            return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(a3, position);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(FlacStreamMetadata flacStreamMetadata, int i, long j, long j2) {
        super(new BinarySearchSeeker.SeekTimestampConverter() { // from class: a2.j.b.b.u0.f.b
            @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter
            public final long timeUsToTargetTime(long j3) {
                return FlacStreamMetadata.this.getSampleNumber(j3);
            }
        }, new b(flacStreamMetadata, i, null), flacStreamMetadata.getDurationUs(), 0, flacStreamMetadata.totalSamples, j, j2, flacStreamMetadata.getApproxBytesPerFrame(), Math.max(6, flacStreamMetadata.minFrameSize));
        Objects.requireNonNull(flacStreamMetadata);
    }
}
