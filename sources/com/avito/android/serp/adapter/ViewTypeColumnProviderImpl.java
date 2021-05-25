package com.avito.android.serp.adapter;

import com.avito.android.remote.auth.AuthSource;
import java.util.EnumMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/serp/adapter/ViewTypeColumnProviderImpl;", "Lcom/avito/android/serp/adapter/ViewTypeColumnProvider;", "Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "", "getViewTypeColumn", "(Lcom/avito/android/serp/adapter/SerpViewType;)I", "columnCount", "", "setColumnCount", "(I)V", "Lcom/avito/android/serp/adapter/LayoutTypeProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/LayoutTypeProvider;", "layoutTypeProvider", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "viewTypeSizeMap", "<init>", "(Lcom/avito/android/serp/adapter/LayoutTypeProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ViewTypeColumnProviderImpl implements ViewTypeColumnProvider {
    public final Map<SerpViewType, Integer> a = new EnumMap(SerpViewType.class);
    public final LayoutTypeProvider b;

    public ViewTypeColumnProviderImpl(@NotNull LayoutTypeProvider layoutTypeProvider) {
        Intrinsics.checkNotNullParameter(layoutTypeProvider, "layoutTypeProvider");
        this.b = layoutTypeProvider;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeColumnProvider
    public int getViewTypeColumn(@NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        Integer num = this.a.get(serpViewType);
        if (num != null) {
            return num.intValue();
        }
        int columnCount = this.b.getLayoutType().getColumnCount(serpViewType);
        this.a.put(serpViewType, Integer.valueOf(columnCount));
        return columnCount;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeColumnProvider
    public void setColumnCount(int i) {
        if (i != 0) {
            this.a.clear();
        }
    }
}
