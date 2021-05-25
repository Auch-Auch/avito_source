package ru.avito.component.shortcut_navigation_bar.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR(\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/RubricatorCategoryItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lru/avito/component/shortcut_navigation_bar/adapter/RubricatorItemView;", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", AuthSource.BOOKING_ORDER, "Z", "withBigIcon", "Lcom/avito/konveyor/blueprint/ItemPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ItemPresenter;", "getPresenter", "()Lcom/avito/konveyor/blueprint/ItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/konveyor/blueprint/ItemPresenter;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class RubricatorCategoryItemBlueprint implements ItemBlueprint<RubricatorItemView, ShortcutNavigationItem> {
    @NotNull
    public final ItemPresenter<RubricatorItemView, ShortcutNavigationItem> a;
    public final boolean b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, RubricatorItemViewImpl> {
        public final /* synthetic */ RubricatorCategoryItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RubricatorCategoryItemBlueprint rubricatorCategoryItemBlueprint) {
            super(2);
            this.a = rubricatorCategoryItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public RubricatorItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new RubricatorItemViewImpl(view2, this.a.b);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.konveyor.blueprint.ItemPresenter<? super ru.avito.component.shortcut_navigation_bar.adapter.RubricatorItemView, ? super ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public RubricatorCategoryItemBlueprint(@NotNull ItemPresenter<? super RubricatorItemView, ? super ShortcutNavigationItem> itemPresenter, boolean z) {
        Intrinsics.checkNotNullParameter(itemPresenter, "presenter");
        this.a = itemPresenter;
        this.b = z;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<RubricatorItemView, ShortcutNavigationItem> getPresenter() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> getViewHolderProvider() {
        int i;
        if (this.b) {
            i = R.layout.home_rubricator_big_icon_item;
        } else {
            i = R.layout.home_rubricator_item;
        }
        return new ViewHolderBuilder.ViewHolderProvider<>(i, new a(this));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof ShortcutNavigationItemImpl;
    }
}
