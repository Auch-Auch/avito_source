package com.avito.android.brandspace.interactor.events;

import com.avito.android.brandspace_entry_point.analytics.BrandspaceEntryPointViewEventKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/avito/android/brandspace/interactor/events/BrandspaceVisitEvent;", "Lcom/avito/android/brandspace/interactor/events/BrandspaceEvent;", "", "c", "Ljava/lang/String;", "source", "", "", "getParams", "()Ljava/util/Map;", "params", "brandSlug", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceVisitEvent extends BrandspaceEvent {
    public final String c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrandspaceVisitEvent(@Nullable String str, @NotNull String str2) {
        super(str2, 4826, 0);
        Intrinsics.checkNotNullParameter(str2, "brandSlug");
        this.c = str;
    }

    @Override // com.avito.android.brandspace.interactor.events.BrandspaceEvent, com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        Map<String, Object> params = super.getParams();
        String str = this.c;
        if (str == null) {
            str = BrandspaceEntryPointViewEventKt.BRANDSPACE_EMPTY_ENTRY_POINT;
        }
        params.put("bs_entry_point_type", str);
        return params;
    }
}
