package com.avito.android.blueprints.publish;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/blueprints/publish/SelectItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/blueprints/publish/SelectItemView;", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "ClearListener", "ClickListener", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface SelectItemPresenter extends ItemPresenter<SelectItemView, ParameterElement.Select> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/blueprints/publish/SelectItemPresenter$ClearListener;", "", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "element", "", "onClearClicked", "(Lcom/avito/android/category_parameters/ParameterElement$Select;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public interface ClearListener {
        void onClearClicked(@NotNull ParameterElement.Select select);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/blueprints/publish/SelectItemPresenter$ClickListener;", "", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "element", "", "onItemClicked", "(Lcom/avito/android/category_parameters/ParameterElement$Select;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public interface ClickListener {
        void onItemClicked(@NotNull ParameterElement.Select select);
    }
}
