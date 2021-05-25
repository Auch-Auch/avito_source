package com.avito.android.analytics.inhouse_transport;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\f\u0010\rJ+\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/OverflowPassTrimmer;", "", "T", "Lcom/avito/android/analytics/inhouse_transport/OverflowTrimmer;", "", "events", "", "currentEventsCount", "trimToSave", "(Ljava/util/List;I)Ljava/util/List;", "trimToExtract", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
public final class OverflowPassTrimmer<T> implements OverflowTrimmer<T> {
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.analytics.inhouse_transport.OverflowTrimmer
    @NotNull
    public List<T> trimToExtract(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "events");
        return list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.analytics.inhouse_transport.OverflowTrimmer
    @NotNull
    public List<T> trimToSave(@NotNull List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "events");
        return list;
    }
}
