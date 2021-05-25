package com.avito.android.blueprints.range.cre_range;

import android.view.View;
import com.avito.android.blueprints.input.MultiStateInputItemView;
import com.avito.android.blueprints.range.RangeInputViewImpl;
import com.avito.android.blueprints.range.RangeItemView;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemView;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemViewImpl;
import com.avito.android.item_temporary.R;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.design.list_item.SwitcherListItem;
import com.avito.android.util.Views;
import com.avito.android.util.preferences.db_preferences.Types;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000eR\u0016\u0010\u001e\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0016\u0010 \u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0018¨\u0006%"}, d2 = {"Lcom/avito/android/blueprints/range/cre_range/CreRangeItemViewHolder;", "Lcom/avito/android/blueprints/range/RangeItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "showKeyboard", "()V", "", Types.BOOLEAN, "showFromField", "(Z)V", "Lcom/avito/android/blueprints/input/MultiStateInputItemView;", "w", "Lcom/avito/android/blueprints/input/MultiStateInputItemView;", "getToInputView", "()Lcom/avito/android/blueprints/input/MultiStateInputItemView;", "toInputView", "Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemView;", "x", "Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemView;", "getSwitcherView", "()Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemView;", "switcherView", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "u", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "switcherContainer", VKApiConst.VERSION, "getFromInputView", "fromInputView", "t", "toContainer", "s", "fromContainer", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class CreRangeItemViewHolder extends BaseViewHolder implements RangeItemView {
    public final ComponentContainer s;
    public final ComponentContainer t;
    public final ComponentContainer u;
    @NotNull
    public final MultiStateInputItemView v;
    @NotNull
    public final MultiStateInputItemView w;
    @NotNull
    public final MultiStateSwitcherItemView x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreRangeItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.range_from);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.component_container.ComponentContainer");
        ComponentContainer componentContainer = (ComponentContainer) findViewById;
        this.s = componentContainer;
        View findViewById2 = view.findViewById(R.id.range_to);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.component_container.ComponentContainer");
        ComponentContainer componentContainer2 = (ComponentContainer) findViewById2;
        this.t = componentContainer2;
        View findViewById3 = view.findViewById(R.id.range_switcher);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.component_container.ComponentContainer");
        ComponentContainer componentContainer3 = (ComponentContainer) findViewById3;
        this.u = componentContainer3;
        int i = R.id.input;
        View findViewById4 = componentContainer.findViewById(i);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        this.v = new RangeInputViewImpl(componentContainer, (Input) findViewById4);
        View findViewById5 = componentContainer2.findViewById(i);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        this.w = new RangeInputViewImpl(componentContainer2, (Input) findViewById5);
        View findViewById6 = componentContainer3.findViewById(R.id.switcher);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "switcherContainer.findViewById(R.id.switcher)");
        this.x = new MultiStateSwitcherItemViewImpl(componentContainer3, (SwitcherListItem) findViewById6);
    }

    @Override // com.avito.android.blueprints.range.RangeItemView
    @NotNull
    public MultiStateInputItemView getFromInputView() {
        return this.v;
    }

    @Override // com.avito.android.blueprints.range.RangeItemView
    @NotNull
    public MultiStateSwitcherItemView getSwitcherView() {
        return this.x;
    }

    @Override // com.avito.android.blueprints.range.RangeItemView
    @NotNull
    public MultiStateInputItemView getToInputView() {
        return this.w;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        RangeItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.blueprints.range.RangeItemView
    public void showFromField(boolean z) {
        Views.setVisible(this.s, z);
    }

    @Override // com.avito.android.blueprints.range.RangeItemView
    public void showKeyboard() {
        if (this.s.getVisibility() == 0) {
            getFromInputView().showKeyboard();
        } else {
            getToInputView().showKeyboard();
        }
    }
}
