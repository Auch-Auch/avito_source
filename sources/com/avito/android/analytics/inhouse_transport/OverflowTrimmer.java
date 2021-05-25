package com.avito.android.analytics.inhouse_transport;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001J+\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/OverflowTrimmer;", "", "T", "", "events", "", "currentEventsCount", "trimToSave", "(Ljava/util/List;I)Ljava/util/List;", "trimToExtract", "(Ljava/util/List;)Ljava/util/List;", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
public interface OverflowTrimmer<T> {
    @NotNull
    List<T> trimToExtract(@NotNull List<? extends T> list);

    @NotNull
    List<T> trimToSave(@NotNull List<? extends T> list, int i);
}
