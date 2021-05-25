package com.avito.android.user_advert.soa_with_price.blueprint;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_advert.R;
import com.avito.android.user_advert.soa_with_price.CloseReasonItem;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemBlueprintImpl;", "Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemBlueprint;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemPresenter;", "getPresenter", "()Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemPresenter;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class CloseReasonItemBlueprintImpl implements CloseReasonItemBlueprint {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<CloseReasonItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.close_reason_item, a.a);
    @NotNull
    public final CloseReasonItemPresenter b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, CloseReasonItemViewImpl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public CloseReasonItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new CloseReasonItemViewImpl(view2);
        }
    }

    @Inject
    public CloseReasonItemBlueprintImpl(@NotNull CloseReasonItemPresenter closeReasonItemPresenter) {
        Intrinsics.checkNotNullParameter(closeReasonItemPresenter, "presenter");
        this.b = closeReasonItemPresenter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<CloseReasonItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof CloseReasonItem;
    }

    /* Return type fixed from 'com.avito.android.user_advert.soa_with_price.blueprint.CloseReasonItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<CloseReasonItemView, CloseReasonItem> getPresenter() {
        return this.b;
    }
}
