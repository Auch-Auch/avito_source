package a2.j.b.b.u0.g;

import a2.b.a.a.a;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.sumsub.sns.R2;
import java.util.Collections;
public final class b extends TagPayloadReader {
    public static final int[] e = {R2.styleable.Toolbar_android_minHeight, 11025, 22050, 44100};
    public boolean b;
    public boolean c;
    public int d;

    public b(TrackOutput trackOutput) {
        super(trackOutput);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        if (!this.b) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int i = (readUnsignedByte >> 4) & 15;
            this.d = i;
            if (i == 2) {
                this.a.format(new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_MPEG).setChannelCount(1).setSampleRate(e[(readUnsignedByte >> 2) & 3]).build());
                this.c = true;
            } else if (i == 7 || i == 8) {
                this.a.format(new Format.Builder().setSampleMimeType(i == 7 ? MimeTypes.AUDIO_ALAW : MimeTypes.AUDIO_MLAW).setChannelCount(1).setSampleRate(8000).build());
                this.c = true;
            } else if (i != 10) {
                StringBuilder L = a.L("Audio format not supported: ");
                L.append(this.d);
                throw new TagPayloadReader.UnsupportedFormatException(L.toString());
            }
            this.b = true;
        } else {
            parsableByteArray.skipBytes(1);
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(ParsableByteArray parsableByteArray, long j) throws ParserException {
        if (this.d == 2) {
            int bytesLeft = parsableByteArray.bytesLeft();
            this.a.sampleData(parsableByteArray, bytesLeft);
            this.a.sampleMetadata(j, 1, bytesLeft, 0, null);
            return true;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if (readUnsignedByte == 0 && !this.c) {
            int bytesLeft2 = parsableByteArray.bytesLeft();
            byte[] bArr = new byte[bytesLeft2];
            parsableByteArray.readBytes(bArr, 0, bytesLeft2);
            AacUtil.Config parseAudioSpecificConfig = AacUtil.parseAudioSpecificConfig(bArr);
            this.a.format(new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_AAC).setCodecs(parseAudioSpecificConfig.codecs).setChannelCount(parseAudioSpecificConfig.channelCount).setSampleRate(parseAudioSpecificConfig.sampleRateHz).setInitializationData(Collections.singletonList(bArr)).build());
            this.c = true;
            return false;
        } else if (this.d == 10 && readUnsignedByte != 1) {
            return false;
        } else {
            int bytesLeft3 = parsableByteArray.bytesLeft();
            this.a.sampleData(parsableByteArray, bytesLeft3);
            this.a.sampleMetadata(j, 1, bytesLeft3, 0, null);
            return true;
        }
    }
}
