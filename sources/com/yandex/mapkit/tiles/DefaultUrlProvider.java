package com.yandex.mapkit.tiles;

import com.yandex.mapkit.TileId;
import com.yandex.mapkit.Version;
import com.yandex.mapkit.ZoomRange;
import com.yandex.runtime.NativeObject;
import java.util.List;
public class DefaultUrlProvider implements UrlProvider {
    private final NativeObject nativeObject = createNative();

    private static native NativeObject createNative();

    @Override // com.yandex.mapkit.tiles.UrlProvider
    public native String formatUrl(TileId tileId, Version version);

    public native void setUrlPattern(String str);

    public native void setZoomRanges(List<ZoomRange> list);
}
