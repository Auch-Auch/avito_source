package com.avito.android.delivery.map.point_info.konveyor.service.single;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItemView;", "Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItemPresenter;", "getPresenter", "()Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItemPresenter;", "presenter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "d", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItemViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/delivery/utils/DrawableFactory;", "c", "Lcom/avito/android/delivery/utils/DrawableFactory;", "drawableFactory", "<init>", "(Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItemPresenter;Lcom/avito/android/delivery/utils/DrawableFactory;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceItemBlueprint implements ItemBlueprint<ServiceItemView, ServiceItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<ServiceItemViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.rds_delivery_service_item, new a(this));
    @NotNull
    public final ServiceItemPresenter b;
    public final DrawableFactory c;
    public final AttributedTextFormatter d;

    public static final class a extends Lambda implements Function2<ViewGroup, View, ServiceItemViewHolder> {
        public final /* synthetic */ ServiceItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ServiceItemBlueprint serviceItemBlueprint) {
            super(2);
            this.a = serviceItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public ServiceItemViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new ServiceItemViewHolder(view2, this.a.c, this.a.d);
        }
    }

    @Inject
    public ServiceItemBlueprint(@NotNull ServiceItemPresenter serviceItemPresenter, @NotNull DrawableFactory drawableFactory, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(serviceItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(drawableFactory, "drawableFactory");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.b = serviceItemPresenter;
        this.c = drawableFactory;
        this.d = attributedTextFormatter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<ServiceItemViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof ServiceItem;
    }

    /* Return type fixed from 'com.avito.android.delivery.map.point_info.konveyor.service.single.ServiceItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<ServiceItemView, ServiceItem> getPresenter() {
        return this.b;
    }
}
