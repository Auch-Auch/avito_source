package com.avito.android.blueprints.radiogroup;

import com.avito.android.blueprints.SelectedInfo;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.konveyor.blueprint.PayloadItemPresenter;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemPresenter;", "Lcom/avito/konveyor/blueprint/PayloadItemPresenter;", "Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemView;", "Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", "Lio/reactivex/Observable;", "Lcom/avito/android/blueprints/SelectedInfo;", "getItemSelectedObservable", "()Lio/reactivex/Observable;", "itemSelectedObservable", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface RadioGroupSelectItemPresenter extends PayloadItemPresenter<RadioGroupSelectItemView, ParameterElement.Select.Flat> {
    @NotNull
    Observable<SelectedInfo> getItemSelectedObservable();
}
