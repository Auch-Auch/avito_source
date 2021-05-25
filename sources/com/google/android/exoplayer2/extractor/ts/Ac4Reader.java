package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
public final class Ac4Reader implements ElementaryStreamReader {
    public final ParsableBitArray a;
    public final ParsableByteArray b;
    @Nullable
    public final String c;
    public String d;
    public TrackOutput e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public Format k;
    public int l;
    public long m;

    public Ac4Reader() {
        this(null);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        int i2;
        boolean z;
        int readUnsignedByte;
        Assertions.checkStateNotNull(this.e);
        while (parsableByteArray.bytesLeft() > 0) {
            int i3 = this.f;
            boolean z2 = true;
            if (i3 == 0) {
                while (true) {
                    i2 = 65;
                    if (parsableByteArray.bytesLeft() <= 0) {
                        z = false;
                        break;
                    } else if (!this.h) {
                        this.h = parsableByteArray.readUnsignedByte() == 172;
                    } else {
                        readUnsignedByte = parsableByteArray.readUnsignedByte();
                        this.h = readUnsignedByte == 172;
                        if (readUnsignedByte == 64 || readUnsignedByte == 65) {
                            break;
                        }
                    }
                }
                this.i = readUnsignedByte == 65;
                z = true;
                if (z) {
                    this.f = 1;
                    this.b.getData()[0] = -84;
                    byte[] data = this.b.getData();
                    if (!this.i) {
                        i2 = 64;
                    }
                    data[1] = (byte) i2;
                    this.g = 2;
                }
            } else if (i3 == 1) {
                byte[] data2 = this.b.getData();
                int min = Math.min(parsableByteArray.bytesLeft(), 16 - this.g);
                parsableByteArray.readBytes(data2, this.g, min);
                int i4 = this.g + min;
                this.g = i4;
                if (i4 != 16) {
                    z2 = false;
                }
                if (z2) {
                    this.a.setPosition(0);
                    Ac4Util.SyncFrameInfo parseAc4SyncframeInfo = Ac4Util.parseAc4SyncframeInfo(this.a);
                    Format format = this.k;
                    if (format == null || parseAc4SyncframeInfo.channelCount != format.channelCount || parseAc4SyncframeInfo.sampleRate != format.sampleRate || !MimeTypes.AUDIO_AC4.equals(format.sampleMimeType)) {
                        Format build = new Format.Builder().setId(this.d).setSampleMimeType(MimeTypes.AUDIO_AC4).setChannelCount(parseAc4SyncframeInfo.channelCount).setSampleRate(parseAc4SyncframeInfo.sampleRate).setLanguage(this.c).build();
                        this.k = build;
                        this.e.format(build);
                    }
                    this.l = parseAc4SyncframeInfo.frameSize;
                    this.j = (((long) parseAc4SyncframeInfo.sampleCount) * 1000000) / ((long) this.k.sampleRate);
                    this.b.setPosition(0);
                    this.e.sampleData(this.b, 16);
                    this.f = 2;
                }
            } else if (i3 == 2) {
                int min2 = Math.min(parsableByteArray.bytesLeft(), this.l - this.g);
                this.e.sampleData(parsableByteArray, min2);
                int i5 = this.g + min2;
                this.g = i5;
                int i6 = this.l;
                if (i5 == i6) {
                    this.e.sampleMetadata(this.m, 1, i6, 0, null);
                    this.m += this.j;
                    this.f = 0;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.d = trackIdGenerator.getFormatId();
        this.e = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j2, int i2) {
        this.m = j2;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
    }

    public Ac4Reader(@Nullable String str) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[16]);
        this.a = parsableBitArray;
        this.b = new ParsableByteArray(parsableBitArray.data);
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.c = str;
    }
}
