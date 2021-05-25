package com.avito.android.serp.adapter;

import android.util.SparseIntArray;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.data_source.DataSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0003H&¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/serp/adapter/BaseGridPositionProvider;", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "dataSource", "", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", VKApiConst.POSITION, "getRowForPosition", "(I)I", "getRows", "()I", "item", "getSpanCount", "(Lcom/avito/android/serp/adapter/SpannedItem;)I", "Landroid/util/SparseIntArray;", AuthSource.BOOKING_ORDER, "Landroid/util/SparseIntArray;", "positionToRow", AuthSource.SEND_ABUSE, "I", "rows", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseGridPositionProvider implements SpannedGridPositionProvider {
    public int a;
    public SparseIntArray b;

    @Override // com.avito.android.ui.adapter.GridPositionProvider
    public int getRowForPosition(int i) {
        SparseIntArray sparseIntArray = this.b;
        if (sparseIntArray == null) {
            Intrinsics.throwUninitializedPropertyAccessException("positionToRow");
        }
        return sparseIntArray.get(i);
    }

    @Override // com.avito.android.ui.adapter.GridPositionProvider
    public int getRows() {
        return this.a;
    }

    public abstract int getSpanCount(@NotNull SpannedItem spannedItem);

    @Override // com.avito.android.serp.adapter.SpannedGridPositionProvider
    public void onDataSourceChanged(@NotNull DataSource<? extends SpannedItem> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        int count = dataSource.getCount();
        this.b = new SparseIntArray(count);
        this.a = 0;
        int i = 0;
        for (int i2 = 0; i2 < count; i2++) {
            int spanCount = getSpanCount((SpannedItem) dataSource.getItem(i2));
            if (i <= 0 || spanCount < getColumnsCount()) {
                i += spanCount;
                SparseIntArray sparseIntArray = this.b;
                if (sparseIntArray == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("positionToRow");
                }
                sparseIntArray.put(i2, this.a);
                if (i >= getColumnsCount() || i2 == count - 1) {
                    this.a++;
                }
            } else {
                this.a++;
                SparseIntArray sparseIntArray2 = this.b;
                if (sparseIntArray2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("positionToRow");
                }
                sparseIntArray2.put(i2, this.a);
                this.a++;
            }
            i = 0;
        }
    }
}
