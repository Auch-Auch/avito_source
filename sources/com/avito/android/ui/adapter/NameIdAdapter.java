package com.avito.android.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Entity;
import com.avito.android.ui_components.R;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.util.DataSources;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u001d\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0006\u0018\u00010\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/ui/adapter/NameIdAdapter;", "Landroid/widget/BaseAdapter;", "", "getCount", "()I", VKApiConst.POSITION, "Lcom/avito/android/remote/model/Entity;", "getItem", "(I)Lcom/avito/android/remote/model/Entity;", "", "getItemId", "(I)J", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", "parent", "getView", "(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;", "Landroid/view/LayoutInflater;", AuthSource.BOOKING_ORDER, "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "setLayoutInflater", "(Landroid/view/LayoutInflater;)V", "layoutInflater", "Lcom/avito/konveyor/data_source/DataSource;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/data_source/DataSource;", ResidentialComplexModuleKt.VALUES, "<init>", "(Lcom/avito/konveyor/data_source/DataSource;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public class NameIdAdapter extends BaseAdapter {
    public final DataSource<? extends Entity<?>> a;
    @Nullable
    public LayoutInflater b;

    public NameIdAdapter(@Nullable DataSource<? extends Entity<?>> dataSource) {
        this.a = DataSources.orEmpty(dataSource);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.getCount();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return (long) i;
    }

    @Nullable
    public final LayoutInflater getLayoutInflater() {
        return this.b;
    }

    @Override // android.widget.Adapter
    @Nullable
    public View getView(int i, @Nullable View view, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (this.b == null) {
            this.b = LayoutInflater.from(viewGroup.getContext());
        }
        if (view == null) {
            LayoutInflater layoutInflater = this.b;
            Intrinsics.checkNotNull(layoutInflater);
            view = layoutInflater.inflate(R.layout.dialog_list_item, viewGroup, false);
        }
        Entity<?> item = getItem(i);
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.CheckedTextView");
        ((CheckedTextView) view).setText(item.getName());
        return view;
    }

    public final void setLayoutInflater(@Nullable LayoutInflater layoutInflater) {
        this.b = layoutInflater;
    }

    @Override // android.widget.Adapter
    @NotNull
    public Entity<?> getItem(int i) {
        return (Entity) this.a.getItem(i);
    }
}
