package com.avito.android.ui.adapter;

import a2.g.r.g;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.model.Category;
import com.avito.android.remote.model.Entity;
import com.avito.android.ui_components.R;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.data_source.DataSource;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b \u0010!J+\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017¨\u0006\""}, d2 = {"Lcom/avito/android/ui/adapter/ShopCategoryAdapter;", "Lcom/avito/android/ui/adapter/NameIdAdapter;", "", VKApiConst.POSITION, "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", "parent", "getView", "(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;", "Lcom/avito/android/util/DeviceMetrics;", g.a, "Lcom/avito/android/util/DeviceMetrics;", "getDeviceMetrics", "()Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Landroid/content/Context;", "f", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "d", "I", "horizontalPaddingBig", "e", "verticalPadding", "c", "horizontalPadding", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/remote/model/Category;", ResidentialComplexModuleKt.VALUES, "<init>", "(Landroid/content/Context;Lcom/avito/konveyor/data_source/DataSource;Lcom/avito/android/util/DeviceMetrics;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopCategoryAdapter extends NameIdAdapter {
    public final int c;
    public final int d;
    public final int e;
    @NotNull
    public final Context f;
    @NotNull
    public final DeviceMetrics g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopCategoryAdapter(@NotNull Context context, @NotNull DataSource<Category> dataSource, @NotNull DeviceMetrics deviceMetrics) {
        super(dataSource);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataSource, ResidentialComplexModuleKt.VALUES);
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        this.f = context;
        this.g = deviceMetrics;
        this.c = context.getResources().getDimensionPixelSize(R.dimen.list_checked_item_horizontal_padding);
        this.d = context.getResources().getDimensionPixelSize(R.dimen.list_checked_item_horizontal_category_padding);
        this.e = context.getResources().getDimensionPixelSize(R.dimen.list_checked_item_vertical_padding);
    }

    @NotNull
    public final Context getContext() {
        return this.f;
    }

    @NotNull
    public final DeviceMetrics getDeviceMetrics() {
        return this.g;
    }

    @Override // com.avito.android.ui.adapter.NameIdAdapter, android.widget.Adapter
    @Nullable
    public View getView(int i, @Nullable View view, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (getLayoutInflater() == null) {
            setLayoutInflater(LayoutInflater.from(viewGroup.getContext()));
        }
        if (view == null) {
            LayoutInflater layoutInflater = getLayoutInflater();
            Intrinsics.checkNotNull(layoutInflater);
            view = layoutInflater.inflate(R.layout.dialog_list_item, viewGroup, false);
        }
        Entity<?> item = getItem(i);
        Objects.requireNonNull(item, "null cannot be cast to non-null type com.avito.android.remote.model.Category");
        Category category = (Category) item;
        Intrinsics.checkNotNull(view);
        int i2 = category.isRoot() ? this.c : this.d;
        int i3 = this.e;
        view.setPadding(i2, i3, this.c, i3);
        ((CheckedTextView) view).setText(category.getName());
        return view;
    }
}
