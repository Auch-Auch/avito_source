package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;
public final class DvbSubtitleReader implements ElementaryStreamReader {
    public final List<TsPayloadReader.DvbSubtitleInfo> a;
    public final TrackOutput[] b;
    public boolean c;
    public int d;
    public int e;
    public long f;

    public DvbSubtitleReader(List<TsPayloadReader.DvbSubtitleInfo> list) {
        this.a = list;
        this.b = new TrackOutput[list.size()];
    }

    public final boolean a(ParsableByteArray parsableByteArray, int i) {
        if (parsableByteArray.bytesLeft() == 0) {
            return false;
        }
        if (parsableByteArray.readUnsignedByte() != i) {
            this.c = false;
        }
        this.d--;
        return this.c;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        if (!this.c) {
            return;
        }
        if (this.d != 2 || a(parsableByteArray, 32)) {
            if (this.d != 1 || a(parsableByteArray, 0)) {
                int position = parsableByteArray.getPosition();
                int bytesLeft = parsableByteArray.bytesLeft();
                TrackOutput[] trackOutputArr = this.b;
                for (TrackOutput trackOutput : trackOutputArr) {
                    parsableByteArray.setPosition(position);
                    trackOutput.sampleData(parsableByteArray, bytesLeft);
                }
                this.e += bytesLeft;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i = 0; i < this.b.length; i++) {
            TsPayloadReader.DvbSubtitleInfo dvbSubtitleInfo = this.a.get(i);
            trackIdGenerator.generateNewId();
            TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 3);
            track.format(new Format.Builder().setId(trackIdGenerator.getFormatId()).setSampleMimeType(MimeTypes.APPLICATION_DVBSUBS).setInitializationData(Collections.singletonList(dvbSubtitleInfo.initializationData)).setLanguage(dvbSubtitleInfo.language).build());
            this.b[i] = track;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
        if (this.c) {
            for (TrackOutput trackOutput : this.b) {
                trackOutput.sampleMetadata(this.f, 1, this.e, 0, null);
            }
            this.c = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if ((i & 4) != 0) {
            this.c = true;
            this.f = j;
            this.e = 0;
            this.d = 2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.c = false;
    }
}
