package com.avito.android.advert.item.spare_parts;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.advert_details.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/item/spare_parts/SparePartsBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/spare_parts/SparePartsView;", "Lcom/avito/android/advert/item/spare_parts/SparePartsItem;", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/advert/item/spare_parts/SparePartsViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "()V", "Lcom/avito/android/advert/item/spare_parts/SparePartsCompatibilitiesBlueprint;", "Lcom/avito/android/advert/item/spare_parts/SparePartsReplacementsBlueprint;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public abstract class SparePartsBlueprint implements ItemBlueprint<SparePartsView, SparePartsItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<SparePartsViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.advert_details_spare_parts_block, a.a);

    public static final class a extends Lambda implements Function2<ViewGroup, View, SparePartsViewImpl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public SparePartsViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new SparePartsViewImpl(view2);
        }
    }

    public SparePartsBlueprint() {
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<SparePartsViewImpl> getViewHolderProvider() {
        return this.a;
    }

    public SparePartsBlueprint(j jVar) {
    }
}
