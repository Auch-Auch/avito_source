package com.avito.android.analytics;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/analytics/ErrorEvent;", "Lcom/avito/android/analytics/Event;", "Lcom/avito/android/analytics/ErrorSummary;", "getSummary", "()Lcom/avito/android/analytics/ErrorSummary;", ErrorBundle.SUMMARY_ENTRY, "analytics-core_release"}, k = 1, mv = {1, 4, 2})
public interface ErrorEvent extends Event {
    @NotNull
    ErrorSummary getSummary();
}
