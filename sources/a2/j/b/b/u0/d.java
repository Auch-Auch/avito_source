package a2.j.b.b.u0;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
/* compiled from: TrackOutput */
public final /* synthetic */ class d {
    public static int $default$sampleData(TrackOutput _this, DataReader dataReader, int i, boolean z) throws IOException {
        return _this.sampleData(dataReader, i, z, 0);
    }

    public static void $default$sampleData(TrackOutput _this, ParsableByteArray parsableByteArray, int i) {
        _this.sampleData(parsableByteArray, i, 0);
    }
}
