package com.yandex.mapkit.glyphs;

import androidx.annotation.NonNull;
public interface GlyphUrlProvider {
    @NonNull
    String formatUrl(@NonNull String str, @NonNull GlyphIdRange glyphIdRange);
}
