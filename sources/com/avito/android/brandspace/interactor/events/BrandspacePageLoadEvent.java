package com.avito.android.brandspace.interactor.events;

import com.avito.android.brandspace_entry_point.analytics.BrandspaceEntryPointViewEventKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/avito/android/brandspace/interactor/events/BrandspacePageLoadEvent;", "Lcom/avito/android/brandspace/interactor/events/BrandspaceEvent;", "", "", "", "getParams", "()Ljava/util/Map;", "params", "c", "Ljava/lang/String;", "source", "brandSlug", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspacePageLoadEvent extends BrandspaceEvent {
    public final String c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrandspacePageLoadEvent(@Nullable String str, @NotNull String str2) {
        super(str2, 4750, 1);
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
