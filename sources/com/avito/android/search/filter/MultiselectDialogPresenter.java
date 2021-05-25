package com.avito.android.search.filter;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.SelectableItem;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.list_dialog.ListDialog;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/search/filter/MultiselectDialogPresenter;", "", "Lru/avito/component/list_dialog/ListDialog;", "listDialog", "Lcom/avito/android/search/filter/DialogDismissListener;", "dismissListener", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "item", "", "bindDialog", "(Lru/avito/component/list_dialog/ListDialog;Lcom/avito/android/search/filter/DialogDismissListener;Lcom/avito/android/category_parameters/ParameterElement$Multiselect;)V", "unbindDialog", "()V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/items/SelectableItem;", "selectableItemChangeConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "filter_release"}, k = 1, mv = {1, 4, 2})
public interface MultiselectDialogPresenter {
    void bindDialog(@NotNull ListDialog listDialog, @NotNull DialogDismissListener dialogDismissListener, @NotNull ParameterElement.Multiselect multiselect);

    @NotNull
    Consumer<SelectableItem> selectableItemChangeConsumer();

    void unbindDialog();
}
