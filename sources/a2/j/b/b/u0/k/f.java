package a2.j.b.b.u0.k;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import java.io.IOException;
public interface f {
    @Nullable
    SeekMap a();

    void b(long j);

    long read(ExtractorInput extractorInput) throws IOException;
}
