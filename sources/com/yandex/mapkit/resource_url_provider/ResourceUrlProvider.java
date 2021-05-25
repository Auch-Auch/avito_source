package com.yandex.mapkit.resource_url_provider;

import androidx.annotation.NonNull;
public interface ResourceUrlProvider {
    @NonNull
    String formatUrl(@NonNull String str);
}
