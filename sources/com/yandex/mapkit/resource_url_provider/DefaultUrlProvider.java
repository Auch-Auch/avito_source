package com.yandex.mapkit.resource_url_provider;

import com.yandex.runtime.NativeObject;
public class DefaultUrlProvider implements ResourceUrlProvider {
    private final NativeObject nativeObject = createNative();

    private static native NativeObject createNative();

    @Override // com.yandex.mapkit.resource_url_provider.ResourceUrlProvider
    public native String formatUrl(String str);

    public native void setUrlBase(String str);
}
