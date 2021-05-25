package com.avito.android.blueprints;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DimenRes;
import com.avito.android.item_temporary.R;
import com.avito.android.items.InputItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/avito/android/blueprints/InputItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/blueprints/InputItemView;", "Lcom/avito/android/items/InputItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/blueprints/InputViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/blueprints/InputItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/blueprints/InputItemPresenter;", "getPresenter", "()Lcom/avito/android/blueprints/InputItemPresenter;", "presenter", "", "sidePaddingRes", "<init>", "(Lcom/avito/android/blueprints/InputItemPresenter;Ljava/lang/Integer;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class InputItemBlueprint implements ItemBlueprint<InputItemView, InputItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<InputViewHolder> a;
    @NotNull
    public final InputItemPresenter b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, InputViewHolder> {
        public final /* synthetic */ Integer a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Integer num) {
            super(2);
            this.a = num;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public InputViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new InputViewHolder(view2, this.a);
        }
    }

    public InputItemBlueprint(@NotNull InputItemPresenter inputItemPresenter, @DimenRes @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(inputItemPresenter, "presenter");
        this.b = inputItemPresenter;
        this.a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.primary_parameters_input_view, new a(num));
    }

    /* Return type fixed from 'com.avito.android.blueprints.InputItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<InputItemView, InputItem> getPresenter() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<InputViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof InputItem;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InputItemBlueprint(InputItemPresenter inputItemPresenter, Integer num, int i, j jVar) {
        this(inputItemPresenter, (i & 2) != 0 ? null : num);
    }
}
