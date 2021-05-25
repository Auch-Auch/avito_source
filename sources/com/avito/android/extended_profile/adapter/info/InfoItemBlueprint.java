package com.avito.android.extended_profile.adapter.info;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.extended_profile.R;
import com.avito.android.remote.auth.AuthSource;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/extended_profile/adapter/info/InfoItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/extended_profile/adapter/info/InfoItemView;", "Lcom/avito/android/extended_profile/adapter/info/InfoItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/extended_profile/adapter/info/InfoItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/extended_profile/adapter/info/InfoItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/extended_profile/adapter/info/InfoItemPresenter;", "getPresenter", "()Lcom/avito/android/extended_profile/adapter/info/InfoItemPresenter;", "presenter", "c", "Z", "isTablet", "<init>", "(Lcom/avito/android/extended_profile/adapter/info/InfoItemPresenter;Z)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class InfoItemBlueprint implements ItemBlueprint<InfoItemView, InfoItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<InfoItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.extended_profile_info_item, new a(this));
    @NotNull
    public final InfoItemPresenter b;
    public final boolean c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, InfoItemViewImpl> {
        public final /* synthetic */ InfoItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InfoItemBlueprint infoItemBlueprint) {
            super(2);
            this.a = infoItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public InfoItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new InfoItemViewImpl(view2, this.a.c);
        }
    }

    @Inject
    public InfoItemBlueprint(@NotNull InfoItemPresenter infoItemPresenter, boolean z) {
        Intrinsics.checkNotNullParameter(infoItemPresenter, "presenter");
        this.b = infoItemPresenter;
        this.c = z;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<InfoItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof InfoItem;
    }

    /* Return type fixed from 'com.avito.android.extended_profile.adapter.info.InfoItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<InfoItemView, InfoItem> getPresenter() {
        return this.b;
    }
}
