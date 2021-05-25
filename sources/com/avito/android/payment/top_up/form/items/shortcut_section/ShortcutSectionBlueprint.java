package com.avito.android.payment.top_up.form.items.shortcut_section;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.payment.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionItemView;", "Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "c", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionPresenter;", "getPresenter", "()Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionPresenter;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutSectionBlueprint implements ItemBlueprint<ShortcutSectionItemView, ShortcutSectionItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<ShortcutSectionItemView> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.top_ups_shortcut_section_item, new a(this));
    @NotNull
    public final ShortcutSectionPresenter b;
    public final SimpleRecyclerAdapter c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, ShortcutSectionItemView> {
        public final /* synthetic */ ShortcutSectionBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ShortcutSectionBlueprint shortcutSectionBlueprint) {
            super(2);
            this.a = shortcutSectionBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public ShortcutSectionItemView invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new ShortcutSectionItemView(this.a.c, view2);
        }
    }

    public ShortcutSectionBlueprint(@NotNull ShortcutSectionPresenter shortcutSectionPresenter, @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(shortcutSectionPresenter, "presenter");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        this.b = shortcutSectionPresenter;
        this.c = simpleRecyclerAdapter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<ShortcutSectionItemView> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof ShortcutSectionItem;
    }

    /* Return type fixed from 'com.avito.android.payment.top_up.form.items.shortcut_section.ShortcutSectionPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<ShortcutSectionItemView, ShortcutSectionItem> getPresenter() {
        return this.b;
    }
}
