package com.avito.android.analytics.event;

import com.facebook.applinks.AppLinkData;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\t\b&\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/analytics/event/ErrorWithExtras;", "Ljava/lang/Error;", "Lkotlin/Error;", "", "", "", "getExtras", "()Ljava/util/Map;", AppLinkData.ARGUMENTS_EXTRAS_KEY, "", "getCause", "()Ljava/lang/Throwable;", "cause", "getMessage", "()Ljava/lang/String;", "message", "<init>", "()V", "analytics-firebase-crashlytics_release"}, k = 1, mv = {1, 4, 2})
public abstract class ErrorWithExtras extends Error {
    @Override // java.lang.Throwable
    @Nullable
    public abstract Throwable getCause();

    @NotNull
    public abstract Map<String, Object> getExtras();

    @Override // java.lang.Throwable
    @NotNull
    public abstract String getMessage();
}
