package com.avito.android.serp.adapter.closable;

import com.avito.android.remote.auth.AuthSource;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/serp/adapter/closable/ClosedItemInteractorImpl;", "Lcom/avito/android/serp/adapter/closable/ClosedItemInteractor;", "", "id", "", "markAsClosed", "(Ljava/lang/String;)V", "", "isClosed", "(Ljava/lang/String;)Z", "Lcom/avito/android/serp/adapter/closable/ClosedItemEventInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/closable/ClosedItemEventInteractor;", "closedItemEventInteractor", "", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "closedItems", "<init>", "(Lcom/avito/android/serp/adapter/closable/ClosedItemEventInteractor;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ClosedItemInteractorImpl implements ClosedItemInteractor {
    public final Set<String> a = new LinkedHashSet();
    public final ClosedItemEventInteractor b;

    public ClosedItemInteractorImpl(@NotNull ClosedItemEventInteractor closedItemEventInteractor) {
        Intrinsics.checkNotNullParameter(closedItemEventInteractor, "closedItemEventInteractor");
        this.b = closedItemEventInteractor;
    }

    @Override // com.avito.android.serp.adapter.closable.ClosedItemInteractor
    public boolean isClosed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return this.a.contains(str);
    }

    @Override // com.avito.android.serp.adapter.closable.ClosedItemInteractor
    public void markAsClosed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.a.add(str);
        this.b.itemClosed(str);
    }
}
