package com.avito.android.geo;

import a2.a.a.w0.b;
import android.content.Context;
import android.location.LocationManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.avito.android.geo.GeoProvider;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.WeakHandler;
public final class GeoProviderFactory {
    public static GeoProvider newInstance(@NonNull Context context, @Nullable GeoProvider.GeoListener geoListener) {
        return new b(geoListener, new WeakHandler(), TimeSource.DEFAULT, (LocationManager) context.getSystemService("location"));
    }
}
