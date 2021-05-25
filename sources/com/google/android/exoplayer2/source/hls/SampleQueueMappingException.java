package com.google.android.exoplayer2.source.hls;

import a2.b.a.a.a;
import androidx.annotation.Nullable;
import java.io.IOException;
public final class SampleQueueMappingException extends IOException {
    public SampleQueueMappingException(@Nullable String str) {
        super(a.s2(a.q0(str, 60), "Unable to bind a sample queue to TrackGroup with mime type ", str, "."));
    }
}
