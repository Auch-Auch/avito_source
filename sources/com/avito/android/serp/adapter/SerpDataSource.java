package com.avito.android.serp.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.konveyor.data_source.DataSource;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/serp/adapter/SerpDataSource;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "isEmpty", "()Z", "", VKApiConst.POSITION, "getItem", "(I)Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "toList", "()Ljava/util/List;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "list", "getCount", "()I", "count", "Lcom/avito/android/serp/adapter/SerpItemSaturator;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/SerpItemSaturator;", "saturator", "Lcom/avito/android/remote/model/SerpDisplayType;", "c", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "<init>", "(Ljava/util/List;Lcom/avito/android/serp/adapter/SerpItemSaturator;Lcom/avito/android/remote/model/SerpDisplayType;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpDataSource implements DataSource<ViewTypeSerpItem> {
    public final List<ViewTypeSerpItem> a;
    public final SerpItemSaturator b;
    public final SerpDisplayType c;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.serp.adapter.ViewTypeSerpItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public SerpDataSource(@NotNull List<? extends ViewTypeSerpItem> list, @NotNull SerpItemSaturator serpItemSaturator, @NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(serpItemSaturator, "saturator");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        this.a = list;
        this.b = serpItemSaturator;
        this.c = serpDisplayType;
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public int getCount() {
        return this.a.size();
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @NotNull
    public final List<ViewTypeSerpItem> toList() {
        return this.a;
    }

    @Override // com.avito.konveyor.data_source.DataSource
    @NotNull
    public ViewTypeSerpItem getItem(int i) {
        return this.b.saturate(this.a.get(i), this.c);
    }
}
