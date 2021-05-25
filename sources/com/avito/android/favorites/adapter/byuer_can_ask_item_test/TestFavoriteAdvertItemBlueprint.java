package com.avito.android.favorites.adapter.byuer_can_ask_item_test;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.favorites.R;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemView;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemPresenter;", "getPresenter", "()Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemPresenter;", "presenter", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "<init>", "(Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemPresenter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class TestFavoriteAdvertItemBlueprint implements ItemBlueprint<TestFavoriteAdvertItemView, FavoriteAdvertItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<TestFavoriteAdvertItemViewHolder> a;
    @NotNull
    public final TestFavoriteAdvertItemPresenter b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, TestFavoriteAdvertItemViewHolder> {
        public final /* synthetic */ TimeSource a;
        public final /* synthetic */ Locale b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TimeSource timeSource, Locale locale) {
            super(2);
            this.a = timeSource;
            this.b = locale;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public TestFavoriteAdvertItemViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new TestFavoriteAdvertItemViewHolder(view2, this.a, this.b);
        }
    }

    @Inject
    public TestFavoriteAdvertItemBlueprint(@NotNull TestFavoriteAdvertItemPresenter testFavoriteAdvertItemPresenter, @NotNull TimeSource timeSource, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(testFavoriteAdvertItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.b = testFavoriteAdvertItemPresenter;
        this.a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.favorite_advert_item_list, new a(timeSource, locale));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<TestFavoriteAdvertItemViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof FavoriteAdvertItem;
    }

    /* Return type fixed from 'com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<TestFavoriteAdvertItemView, FavoriteAdvertItem> getPresenter() {
        return this.b;
    }
}
