package com.yandex.mapkit.glyphs;

import com.yandex.runtime.NativeObject;
public class DefaultGlyphUrlProvider implements GlyphUrlProvider {
    private final NativeObject nativeObject = createNative();

    private static native NativeObject createNative();

    @Override // com.yandex.mapkit.glyphs.GlyphUrlProvider
    public native String formatUrl(String str, GlyphIdRange glyphIdRange);

    public native void setUrlPattern(String str);
}
