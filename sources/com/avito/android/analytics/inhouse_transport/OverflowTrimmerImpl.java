package com.avito.android.analytics.inhouse_transport;

import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/OverflowTrimmerImpl;", "", "T", "Lcom/avito/android/analytics/inhouse_transport/OverflowTrimmer;", "", "events", "", "currentEventsCount", "trimToSave", "(Ljava/util/List;I)Ljava/util/List;", "trimToExtract", "(Ljava/util/List;)Ljava/util/List;", AuthSource.SEND_ABUSE, "I", "cropSize", "<init>", "(I)V", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
public final class OverflowTrimmerImpl<T> implements OverflowTrimmer<T> {
    public final int a;

    public OverflowTrimmerImpl(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.analytics.inhouse_transport.OverflowTrimmer
    @NotNull
    public List<T> trimToExtract(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "events");
        int size = list.size();
        int i = this.a;
        return size > i ? list.subList(0, i) : list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.analytics.inhouse_transport.OverflowTrimmer
    @NotNull
    public List<T> trimToSave(@NotNull List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "events");
        int i2 = this.a - i;
        if (i2 <= 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i2 < list.size()) {
            return list.subList(0, i2);
        }
        return list;
    }
}
