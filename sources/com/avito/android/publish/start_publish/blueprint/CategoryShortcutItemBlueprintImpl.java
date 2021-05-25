package com.avito.android.publish.start_publish.blueprint;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.publish.R;
import com.avito.android.publish.start_publish.StartPublishSheet;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemBlueprintImpl;", "Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemBlueprint;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemViewViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemPresenter;", "getPresenter", "()Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemPresenter;", "presenter", "<init>", "(Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemPresenter;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryShortcutItemBlueprintImpl implements CategoryShortcutItemBlueprint {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<CategoryShortcutItemViewViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.item_category_shortcut, a.a);
    @NotNull
    public final CategoryShortcutItemPresenter b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, CategoryShortcutItemViewViewHolder> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public CategoryShortcutItemViewViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new CategoryShortcutItemViewViewHolder(view2);
        }
    }

    @Inject
    public CategoryShortcutItemBlueprintImpl(@NotNull CategoryShortcutItemPresenter categoryShortcutItemPresenter) {
        Intrinsics.checkNotNullParameter(categoryShortcutItemPresenter, "presenter");
        this.b = categoryShortcutItemPresenter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<CategoryShortcutItemViewViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof StartPublishSheet.SheetData.CategoryShortcutItem;
    }

    /* Return type fixed from 'com.avito.android.publish.start_publish.blueprint.CategoryShortcutItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<CategoryShortcutItemView, StartPublishSheet.SheetData.CategoryShortcutItem> getPresenter() {
        return this.b;
    }
}
