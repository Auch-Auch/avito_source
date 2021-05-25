package com.google.android.exoplayer2.extractor;

import a2.j.b.b.u0.a;
import android.net.Uri;
import java.util.List;
import java.util.Map;
public interface ExtractorsFactory {
    public static final ExtractorsFactory EMPTY = a.a;

    Extractor[] createExtractors();

    Extractor[] createExtractors(Uri uri, Map<String, List<String>> map);
}
