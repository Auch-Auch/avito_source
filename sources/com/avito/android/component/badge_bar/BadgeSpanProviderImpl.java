package com.avito.android.component.badge_bar;

import com.avito.android.component.badge_bar.badge.BadgeItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.DataSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/component/badge_bar/BadgeSpanProviderImpl;", "Lcom/avito/android/component/badge_bar/BadgeSpanProvider;", "", VKApiConst.POSITION, "columnCount", "getSpan", "(II)I", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/conveyor_item/Item;", "dataSource", "", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/data_source/DataSource;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeSpanProviderImpl implements BadgeSpanProvider {
    public DataSource<Item> a;

    @Override // com.avito.android.component.badge_bar.BadgeSpanProvider
    public int getSpan(int i, int i2) {
        DataSource<Item> dataSource = this.a;
        Item item = null;
        if (dataSource != null) {
            int count = dataSource.getCount();
            if (i >= 0 && count > i) {
                item = dataSource.getItem(i);
            }
        }
        if (item instanceof BadgeItem) {
            return 1;
        }
        return i2;
    }

    @Override // com.avito.android.component.badge_bar.BadgeSpanProvider
    public void onDataSourceChanged(@NotNull DataSource<Item> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.a = dataSource;
    }
}
