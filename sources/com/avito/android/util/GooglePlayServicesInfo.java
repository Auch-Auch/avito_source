package com.avito.android.util;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/util/GooglePlayServicesInfo;", "", "", "isGooglePlayServicesAvailable", "()Z", "", "getLibraryVersionCode", "()I", "libraryVersionCode", "getVersionCode", "()Ljava/lang/Integer;", "versionCode", "", "getVersionName", "()Ljava/lang/String;", "versionName", "application_release"}, k = 1, mv = {1, 4, 2})
public interface GooglePlayServicesInfo {
    int getLibraryVersionCode();

    @Nullable
    Integer getVersionCode();

    @Nullable
    String getVersionName();

    boolean isGooglePlayServicesAvailable();
}
