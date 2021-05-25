package com.avito.android;

import com.avito.android.toggle.Feature;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/avito/android/StatsdToggles;", "", "Lcom/avito/android/toggle/Feature;", "", "getStatsdApiUrl", "()Lcom/avito/android/toggle/Feature;", "statsdApiUrl", "", "getStatsdStrictMode", "statsdStrictMode", "getStatsdGzip", "statsdGzip", "features_release"}, k = 1, mv = {1, 4, 2})
public interface StatsdToggles {
    @NotNull
    Feature<String> getStatsdApiUrl();

    @NotNull
    Feature<Boolean> getStatsdGzip();

    @NotNull
    Feature<Boolean> getStatsdStrictMode();
}
