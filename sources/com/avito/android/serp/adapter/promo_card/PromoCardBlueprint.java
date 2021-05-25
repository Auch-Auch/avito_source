package com.avito.android.serp.adapter.promo_card;

import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp_core.R;
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
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BG\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\b\b\u0001\u0010\u0014\u001a\u00020\t\u0012\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\t\u0012\b\b\u0001\u0010\f\u001a\u00020\t¢\u0006\u0004\b#\u0010$B\u0011\b\u0017\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b#\u0010%J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0016¨\u0006&"}, d2 = {"Lcom/avito/android/serp/adapter/promo_card/PromoCardBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItemView;", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "", g.a, "I", "layoutId", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter;", "getPresenter", "()Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter;", "presenter", "c", "titleId", "e", "Ljava/lang/Integer;", "subtitleId", "d", "imageId", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "f", "buttonId", "<init>", "(Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;I)V", "(Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class PromoCardBlueprint implements ItemBlueprint<PromoCardItemView, PromoCardItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<PromoCardItemViewImpl> a;
    @NotNull
    public final PromoCardItemPresenter b;
    public final int c;
    public final Integer d;
    public final Integer e;
    public final Integer f;
    public final int g;

    public static final class a extends Lambda implements Function2<ViewGroup, View, PromoCardItemViewImpl> {
        public final /* synthetic */ PromoCardBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PromoCardBlueprint promoCardBlueprint) {
            super(2);
            this.a = promoCardBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public PromoCardItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new PromoCardItemViewImpl(view2, this.a.c, this.a.d, this.a.e, this.a.f);
        }
    }

    public PromoCardBlueprint(@NotNull PromoCardItemPresenter promoCardItemPresenter, @IdRes int i, @IdRes @Nullable Integer num, @IdRes @Nullable Integer num2, @IdRes @Nullable Integer num3, @LayoutRes int i2) {
        Intrinsics.checkNotNullParameter(promoCardItemPresenter, "presenter");
        this.b = promoCardItemPresenter;
        this.c = i;
        this.d = num;
        this.e = num2;
        this.f = num3;
        this.g = i2;
        this.a = new ViewHolderBuilder.ViewHolderProvider<>(i2, new a(this));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<PromoCardItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof PromoCardItem;
    }

    /* Return type fixed from 'com.avito.android.serp.adapter.promo_card.PromoCardItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<PromoCardItemView, PromoCardItem> getPresenter() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PromoCardBlueprint(PromoCardItemPresenter promoCardItemPresenter, int i, Integer num, Integer num2, Integer num3, int i2, int i3, j jVar) {
        this(promoCardItemPresenter, i, (i3 & 4) != 0 ? null : num, (i3 & 8) != 0 ? null : num2, (i3 & 16) != 0 ? null : num3, i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public PromoCardBlueprint(@NotNull PromoCardItemPresenter promoCardItemPresenter) {
        this(promoCardItemPresenter, R.id.report_banner_title, Integer.valueOf(R.id.report_banner_image), null, null, R.layout.report_banner, 24, null);
        Intrinsics.checkNotNullParameter(promoCardItemPresenter, "presenter");
    }
}
