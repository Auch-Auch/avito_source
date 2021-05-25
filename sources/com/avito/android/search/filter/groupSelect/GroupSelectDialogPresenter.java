package com.avito.android.search.filter.groupSelect;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.search.filter.DialogDismissListener;
import com.avito.android.select.group_select.GroupSelectView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J=\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogPresenter;", "", "Lcom/avito/android/select/group_select/GroupSelectView;", "view", "Lcom/avito/android/search/filter/DialogDismissListener;", "dismissListener", "Lkotlin/Function1;", "", "", "selectionStateListener", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "item", "bindView", "(Lcom/avito/android/select/group_select/GroupSelectView;Lcom/avito/android/search/filter/DialogDismissListener;Lkotlin/jvm/functions/Function1;Lcom/avito/android/category_parameters/ParameterElement$Multiselect;)V", "unbind", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
public interface GroupSelectDialogPresenter {
    void bindView(@NotNull GroupSelectView groupSelectView, @NotNull DialogDismissListener dialogDismissListener, @Nullable Function1<? super Boolean, Unit> function1, @NotNull ParameterElement.Multiselect multiselect);

    void unbind();
}
