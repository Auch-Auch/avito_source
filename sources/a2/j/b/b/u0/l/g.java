package a2.j.b.b.u0.l;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
public final class g extends BinarySearchSeeker {

    public static final class b implements BinarySearchSeeker.TimestampSeeker {
        public final TimestampAdjuster a;
        public final ParsableByteArray b = new ParsableByteArray();

        public b(TimestampAdjuster timestampAdjuster, a aVar) {
            this.a = timestampAdjuster;
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public void onSeekFinished() {
            this.b.reset(Util.EMPTY_BYTE_ARRAY);
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public BinarySearchSeeker.TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j) throws IOException {
            int a3;
            long position = extractorInput.getPosition();
            int min = (int) Math.min((long) SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, extractorInput.getLength() - position);
            this.b.reset(min);
            extractorInput.peekFully(this.b.getData(), 0, min);
            ParsableByteArray parsableByteArray = this.b;
            int i = -1;
            long j2 = -9223372036854775807L;
            int i2 = -1;
            while (parsableByteArray.bytesLeft() >= 4) {
                if (g.a(parsableByteArray.getData(), parsableByteArray.getPosition()) != 442) {
                    parsableByteArray.skipBytes(1);
                } else {
                    parsableByteArray.skipBytes(4);
                    long c = h.c(parsableByteArray);
                    if (c != C.TIME_UNSET) {
                        long adjustTsTimestamp = this.a.adjustTsTimestamp(c);
                        if (adjustTsTimestamp > j) {
                            if (j2 == C.TIME_UNSET) {
                                return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(adjustTsTimestamp, position);
                            }
                            return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(position + ((long) i2));
                        } else if (100000 + adjustTsTimestamp > j) {
                            return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(position + ((long) parsableByteArray.getPosition()));
                        } else {
                            i2 = parsableByteArray.getPosition();
                            j2 = adjustTsTimestamp;
                        }
                    }
                    int limit = parsableByteArray.limit();
                    if (parsableByteArray.bytesLeft() >= 10) {
                        parsableByteArray.skipBytes(9);
                        int readUnsignedByte = parsableByteArray.readUnsignedByte() & 7;
                        if (parsableByteArray.bytesLeft() >= readUnsignedByte) {
                            parsableByteArray.skipBytes(readUnsignedByte);
                            if (parsableByteArray.bytesLeft() >= 4) {
                                if (g.a(parsableByteArray.getData(), parsableByteArray.getPosition()) == 443) {
                                    parsableByteArray.skipBytes(4);
                                    int readUnsignedShort = parsableByteArray.readUnsignedShort();
                                    if (parsableByteArray.bytesLeft() < readUnsignedShort) {
                                        parsableByteArray.setPosition(limit);
                                    } else {
                                        parsableByteArray.skipBytes(readUnsignedShort);
                                    }
                                }
                                while (true) {
                                    if (parsableByteArray.bytesLeft() < 4 || (a3 = g.a(parsableByteArray.getData(), parsableByteArray.getPosition())) == 442 || a3 == 441 || (a3 >>> 8) != 1) {
                                        break;
                                    }
                                    parsableByteArray.skipBytes(4);
                                    if (parsableByteArray.bytesLeft() < 2) {
                                        parsableByteArray.setPosition(limit);
                                        break;
                                    }
                                    parsableByteArray.setPosition(Math.min(parsableByteArray.limit(), parsableByteArray.getPosition() + parsableByteArray.readUnsignedShort()));
                                }
                            } else {
                                parsableByteArray.setPosition(limit);
                            }
                        } else {
                            parsableByteArray.setPosition(limit);
                        }
                    } else {
                        parsableByteArray.setPosition(limit);
                    }
                    i = parsableByteArray.getPosition();
                }
            }
            if (j2 != C.TIME_UNSET) {
                return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(j2, position + ((long) i));
            }
            return BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
        }
    }

    public g(TimestampAdjuster timestampAdjuster, long j, long j2) {
        super(new BinarySearchSeeker.DefaultSeekTimestampConverter(), new b(timestampAdjuster, null), j, 0, j + 1, 0, j2, 188, 1000);
    }

    public static int a(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
