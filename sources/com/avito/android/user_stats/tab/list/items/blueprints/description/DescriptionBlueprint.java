package com.avito.android.user_stats.tab.list.items.blueprints.description;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_stats.R;
import com.avito.android.user_stats.tab.list.items.DescriptionItem;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemView;", "Lcom/avito/android/user_stats/tab/list/items/DescriptionItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/util/text/AttributedTextFormatter;", "c", "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenter;", "getPresenter", "()Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenter;", "presenter", "<init>", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenter;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class DescriptionBlueprint implements ItemBlueprint<DescriptionItemView, DescriptionItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<DescriptionItemViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.user_stats_item_description, new a(this));
    @NotNull
    public final DescriptionItemPresenter b;
    public final AttributedTextFormatter c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, DescriptionItemViewHolder> {
        public final /* synthetic */ DescriptionBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DescriptionBlueprint descriptionBlueprint) {
            super(2);
            this.a = descriptionBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public DescriptionItemViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new DescriptionItemViewHolder(view2, this.a.c);
        }
    }

    @Inject
    public DescriptionBlueprint(@NotNull DescriptionItemPresenter descriptionItemPresenter, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(descriptionItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "textFormatter");
        this.b = descriptionItemPresenter;
        this.c = attributedTextFormatter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<DescriptionItemViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof DescriptionItem;
    }

    /* Return type fixed from 'com.avito.android.user_stats.tab.list.items.blueprints.description.DescriptionItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<DescriptionItemView, DescriptionItem> getPresenter() {
        return this.b;
    }
}
