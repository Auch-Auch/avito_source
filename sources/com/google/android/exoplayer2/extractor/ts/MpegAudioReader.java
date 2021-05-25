package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
public final class MpegAudioReader implements ElementaryStreamReader {
    public final ParsableByteArray a;
    public final MpegAudioUtil.Header b;
    @Nullable
    public final String c;
    public TrackOutput d;
    public String e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public int k;
    public long l;

    public MpegAudioReader() {
        this(null);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        Assertions.checkStateNotNull(this.d);
        while (parsableByteArray.bytesLeft() > 0) {
            int i2 = this.f;
            if (i2 == 0) {
                byte[] data = parsableByteArray.getData();
                int position = parsableByteArray.getPosition();
                int limit = parsableByteArray.limit();
                while (true) {
                    if (position >= limit) {
                        parsableByteArray.setPosition(limit);
                        break;
                    }
                    boolean z = (data[position] & 255) == 255;
                    boolean z2 = this.i && (data[position] & 224) == 224;
                    this.i = z;
                    if (z2) {
                        parsableByteArray.setPosition(position + 1);
                        this.i = false;
                        this.a.getData()[1] = data[position];
                        this.g = 2;
                        this.f = 1;
                        break;
                    }
                    position++;
                }
            } else if (i2 == 1) {
                int min = Math.min(parsableByteArray.bytesLeft(), 4 - this.g);
                parsableByteArray.readBytes(this.a.getData(), this.g, min);
                int i3 = this.g + min;
                this.g = i3;
                if (i3 >= 4) {
                    this.a.setPosition(0);
                    if (!this.b.setForHeaderData(this.a.readInt())) {
                        this.g = 0;
                        this.f = 1;
                    } else {
                        MpegAudioUtil.Header header = this.b;
                        this.k = header.frameSize;
                        if (!this.h) {
                            this.j = (((long) header.samplesPerFrame) * 1000000) / ((long) header.sampleRate);
                            this.d.format(new Format.Builder().setId(this.e).setSampleMimeType(this.b.mimeType).setMaxInputSize(4096).setChannelCount(this.b.channels).setSampleRate(this.b.sampleRate).setLanguage(this.c).build());
                            this.h = true;
                        }
                        this.a.setPosition(0);
                        this.d.sampleData(this.a, 4);
                        this.f = 2;
                    }
                }
            } else if (i2 == 2) {
                int min2 = Math.min(parsableByteArray.bytesLeft(), this.k - this.g);
                this.d.sampleData(parsableByteArray, min2);
                int i4 = this.g + min2;
                this.g = i4;
                int i5 = this.k;
                if (i4 >= i5) {
                    this.d.sampleMetadata(this.l, 1, i5, 0, null);
                    this.l += this.j;
                    this.g = 0;
                    this.f = 0;
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.e = trackIdGenerator.getFormatId();
        this.d = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j2, int i2) {
        this.l = j2;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.f = 0;
        this.g = 0;
        this.i = false;
    }

    public MpegAudioReader(@Nullable String str) {
        this.f = 0;
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        this.a = parsableByteArray;
        parsableByteArray.getData()[0] = -1;
        this.b = new MpegAudioUtil.Header();
        this.c = str;
    }
}
