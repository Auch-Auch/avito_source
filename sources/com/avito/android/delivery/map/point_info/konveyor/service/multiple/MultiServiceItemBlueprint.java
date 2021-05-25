package com.avito.android.delivery.map.point_info.konveyor.service.multiple;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.delivery.R;
import com.avito.android.delivery.utils.DrawableFactory;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.text.AttributedTextFormatter;
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
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemView;", "Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/util/text/AttributedTextFormatter;", "d", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/delivery/utils/DrawableFactory;", "c", "Lcom/avito/android/delivery/utils/DrawableFactory;", "drawableFactory", "Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemPresenter;", "getPresenter", "()Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemPresenter;Lcom/avito/android/delivery/utils/DrawableFactory;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class MultiServiceItemBlueprint implements ItemBlueprint<MultiServiceItemView, MultiServiceItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<MultiServiceItemViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.rds_delivery_service_multiple_item, new a(this));
    @NotNull
    public final MultiServiceItemPresenter b;
    public final DrawableFactory c;
    public final AttributedTextFormatter d;

    public static final class a extends Lambda implements Function2<ViewGroup, View, MultiServiceItemViewHolder> {
        public final /* synthetic */ MultiServiceItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MultiServiceItemBlueprint multiServiceItemBlueprint) {
            super(2);
            this.a = multiServiceItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public MultiServiceItemViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new MultiServiceItemViewHolder(view2, this.a.c, this.a.d);
        }
    }

    @Inject
    public MultiServiceItemBlueprint(@NotNull MultiServiceItemPresenter multiServiceItemPresenter, @NotNull DrawableFactory drawableFactory, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(multiServiceItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(drawableFactory, "drawableFactory");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.b = multiServiceItemPresenter;
        this.c = drawableFactory;
        this.d = attributedTextFormatter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<MultiServiceItemViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof MultiServiceItem;
    }

    /* Return type fixed from 'com.avito.android.delivery.map.point_info.konveyor.service.multiple.MultiServiceItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<MultiServiceItemView, MultiServiceItem> getPresenter() {
        return this.b;
    }
}
