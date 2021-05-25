package com.avito.android.section.complementary;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.section.SectionAdapterItem;
import com.avito.android.section.SectionItem;
import com.avito.android.section.SectionItemPresenter;
import com.avito.android.section.SectionItemView;
import com.avito.android.section.SectionItemViewHolder;
import com.avito.android.section.di.ComplementaryFavoriteAdvertsPresenter;
import com.avito.android.section.di.ComplementarySectionItemBinder;
import com.avito.android.section.di.ComplementarySectionItemPresenter;
import com.avito.android.section.di.ComplementaryViewedAdvertsPresenter;
import com.avito.android.serp_core.R;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BK\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u000e\b\u0001\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\t\u0012\u000e\b\u0001\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\t\u0012\u000e\b\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0001\u0010!\u001a\u00020\u001e¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\fR\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\f¨\u0006'"}, d2 = {"Lcom/avito/android/section/complementary/ComplementarySectionBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/section/SectionItemView;", "Lcom/avito/android/section/SectionItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Ljavax/inject/Provider;", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "e", "Ljavax/inject/Provider;", "viewedAdvertsPresenter", "Lcom/avito/android/section/SectionItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/section/SectionItemPresenter;", "getPresenter", "()Lcom/avito/android/section/SectionItemPresenter;", "presenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "c", "adapterPresenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/section/SectionItemViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/konveyor/ItemBinder;", "f", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "d", "favoriteAdvertsPresenter", "<init>", "(Lcom/avito/android/section/SectionItemPresenter;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Lcom/avito/konveyor/ItemBinder;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ComplementarySectionBlueprint implements ItemBlueprint<SectionItemView, SectionItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<SectionItemViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.complementary_section, new a(this));
    @NotNull
    public final SectionItemPresenter b;
    public final Provider<AdapterPresenter> c;
    public final Provider<FavoriteAdvertsPresenter> d;
    public final Provider<ViewedAdvertsPresenter> e;
    public final ItemBinder f;

    public static final class a extends Lambda implements Function2<ViewGroup, View, SectionItemViewHolder> {
        public final /* synthetic */ ComplementarySectionBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ComplementarySectionBlueprint complementarySectionBlueprint) {
            super(2);
            this.a = complementarySectionBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.avito.android.section.SectionItemPresenter] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // kotlin.jvm.functions.Function2
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.avito.android.section.SectionItemViewHolder invoke(android.view.ViewGroup r10, android.view.View r11) {
            /*
                r9 = this;
                android.view.ViewGroup r10 = (android.view.ViewGroup) r10
                r5 = r11
                android.view.View r5 = (android.view.View) r5
                java.lang.String r11 = "<anonymous parameter 0>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r11)
                java.lang.String r10 = "view"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r10)
                com.avito.android.section.SectionItemViewHolder r10 = new com.avito.android.section.SectionItemViewHolder
                com.avito.android.section.complementary.ComplementarySectionBlueprint r11 = r9.a
                com.avito.android.section.SectionItemPresenter r1 = r11.getPresenter()
                com.avito.android.section.complementary.ComplementarySectionBlueprint r11 = r9.a
                javax.inject.Provider r11 = com.avito.android.section.complementary.ComplementarySectionBlueprint.access$getAdapterPresenter$p(r11)
                java.lang.Object r11 = r11.get()
                java.lang.String r0 = "adapterPresenter.get()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
                r2 = r11
                com.avito.konveyor.adapter.AdapterPresenter r2 = (com.avito.konveyor.adapter.AdapterPresenter) r2
                com.avito.android.section.complementary.ComplementarySectionBlueprint r11 = r9.a
                javax.inject.Provider r11 = com.avito.android.section.complementary.ComplementarySectionBlueprint.access$getFavoriteAdvertsPresenter$p(r11)
                java.lang.Object r11 = r11.get()
                java.lang.String r0 = "favoriteAdvertsPresenter.get()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
                r3 = r11
                com.avito.android.favorite.FavoriteAdvertsPresenter r3 = (com.avito.android.favorite.FavoriteAdvertsPresenter) r3
                com.avito.android.section.complementary.ComplementarySectionBlueprint r11 = r9.a
                javax.inject.Provider r11 = com.avito.android.section.complementary.ComplementarySectionBlueprint.access$getViewedAdvertsPresenter$p(r11)
                java.lang.Object r11 = r11.get()
                java.lang.String r0 = "viewedAdvertsPresenter.get()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
                r4 = r11
                com.avito.android.advert.viewed.ViewedAdvertsPresenter r4 = (com.avito.android.advert.viewed.ViewedAdvertsPresenter) r4
                com.avito.android.section.title.SectionTitleViewHolder r6 = new com.avito.android.section.title.SectionTitleViewHolder
                r6.<init>(r5)
                com.avito.android.section.complementary.ComplementarySectionBlueprint r11 = r9.a
                com.avito.konveyor.ItemBinder r7 = com.avito.android.section.complementary.ComplementarySectionBlueprint.access$getItemBinder$p(r11)
                com.avito.android.section.complementary.ComplementaryHorizontalSectionItemDecoration r8 = new com.avito.android.section.complementary.ComplementaryHorizontalSectionItemDecoration
                android.content.res.Resources r11 = r5.getResources()
                java.lang.String r0 = "view.resources"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
                r8.<init>(r11)
                r0 = r10
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.section.complementary.ComplementarySectionBlueprint.a.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    @Inject
    public ComplementarySectionBlueprint(@NotNull SectionItemPresenter sectionItemPresenter, @ComplementarySectionItemPresenter @NotNull Provider<AdapterPresenter> provider, @ComplementaryFavoriteAdvertsPresenter @NotNull Provider<FavoriteAdvertsPresenter> provider2, @ComplementaryViewedAdvertsPresenter @NotNull Provider<ViewedAdvertsPresenter> provider3, @ComplementarySectionItemBinder @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(sectionItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(provider, "adapterPresenter");
        Intrinsics.checkNotNullParameter(provider2, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(provider3, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.b = sectionItemPresenter;
        this.c = provider;
        this.d = provider2;
        this.e = provider3;
        this.f = itemBinder;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<SectionItemViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof SectionAdapterItem;
    }

    /* Return type fixed from 'com.avito.android.section.SectionItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<SectionItemView, SectionItem> getPresenter() {
        return this.b;
    }
}
