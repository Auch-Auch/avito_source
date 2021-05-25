package com.avito.android.blueprints.range;

import com.avito.android.blueprints.input.MultiStateInputItemView;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemView;
import com.avito.android.util.preferences.db_preferences.Types;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0012\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/avito/android/blueprints/range/RangeItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "showKeyboard", "()V", "", Types.BOOLEAN, "showFromField", "(Z)V", "Lcom/avito/android/blueprints/input/MultiStateInputItemView;", "getToInputView", "()Lcom/avito/android/blueprints/input/MultiStateInputItemView;", "toInputView", "getFromInputView", "fromInputView", "Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemView;", "getSwitcherView", "()Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemView;", "switcherView", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface RangeItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull RangeItemView rangeItemView) {
            ItemView.DefaultImpls.onUnbind(rangeItemView);
        }
    }

    @NotNull
    MultiStateInputItemView getFromInputView();

    @NotNull
    MultiStateSwitcherItemView getSwitcherView();

    @NotNull
    MultiStateInputItemView getToInputView();

    void showFromField(boolean z);

    void showKeyboard();
}
