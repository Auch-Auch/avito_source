package com.avito.android.safedeal.delivery_courier.summary.konveyor.extra;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.R;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemView;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemPresenter;", "getPresenter", "()Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemPresenter;", "presenter", "<init>", "(Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemPresenter;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class ExtraItemBlueprint implements ItemBlueprint<ExtraItemView, ExtraItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<ExtraItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.delivery_courier_extra_item, a.a);
    @NotNull
    public final ExtraItemPresenter b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, ExtraItemViewImpl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public ExtraItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new ExtraItemViewImpl((TextView) view2);
        }
    }

    @Inject
    public ExtraItemBlueprint(@NotNull ExtraItemPresenter extraItemPresenter) {
        Intrinsics.checkNotNullParameter(extraItemPresenter, "presenter");
        this.b = extraItemPresenter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<ExtraItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof ExtraItem;
    }

    /* Return type fixed from 'com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.ExtraItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<ExtraItemView, ExtraItem> getPresenter() {
        return this.b;
    }
}
