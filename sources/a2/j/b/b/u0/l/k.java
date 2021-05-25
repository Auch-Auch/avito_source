package a2.j.b.b.u0.l;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.CeaUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;
public final class k {
    public final List<Format> a;
    public final TrackOutput[] b;

    public k(List<Format> list) {
        this.a = list;
        this.b = new TrackOutput[list.size()];
    }

    public void a(long j, ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() >= 9) {
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            if (readInt == 434 && readInt2 == 1195456820 && readUnsignedByte == 3) {
                CeaUtil.consumeCcData(j, parsableByteArray, this.b);
            }
        }
    }

    public void b(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i = 0; i < this.b.length; i++) {
            trackIdGenerator.generateNewId();
            TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 3);
            Format format = this.a.get(i);
            String str = format.sampleMimeType;
            boolean z = MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str);
            Assertions.checkArgument(z, "Invalid closed caption mime type provided: " + str);
            track.format(new Format.Builder().setId(trackIdGenerator.getFormatId()).setSampleMimeType(str).setSelectionFlags(format.selectionFlags).setLanguage(format.language).setAccessibilityChannel(format.accessibilityChannel).setInitializationData(format.initializationData).build());
            this.b[i] = track;
        }
    }
}
