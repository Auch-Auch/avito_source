package com.avito.android.blueprints;

import com.avito.android.items.BasicInputItem;
import com.avito.android.items.InputItem;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rR(\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/avito/android/blueprints/InputItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/blueprints/InputItemView;", "Lcom/avito/android/items/InputItem;", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "Lcom/avito/android/items/BasicInputItem;", "getFocusChangesObservable", "()Lio/reactivex/Observable;", "focusChangesObservable", "getValueChangesObservable", "valueChangesObservable", "Listener", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface InputItemPresenter extends ItemPresenter<InputItemView, InputItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/blueprints/InputItemPresenter$Listener;", "", "Lcom/avito/conveyor_item/Item;", "element", "", "newValue", "", "onElementValueChanged", "(Lcom/avito/conveyor_item/Item;Ljava/lang/String;)V", "Lcom/avito/android/items/InputItem;", "onElementErrorDismissed", "(Lcom/avito/android/items/InputItem;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onElementErrorDismissed(@NotNull InputItem inputItem);

        void onElementValueChanged(@NotNull Item item, @NotNull String str);
    }

    @NotNull
    Observable<Pair<Boolean, BasicInputItem>> getFocusChangesObservable();

    @NotNull
    Observable<BasicInputItem> getValueChangesObservable();
}
