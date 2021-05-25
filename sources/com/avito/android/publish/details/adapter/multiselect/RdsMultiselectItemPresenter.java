package com.avito.android.publish.details.adapter.multiselect;

import com.avito.android.blueprints.select.MultiStateSelectItemView;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/details/adapter/multiselect/RdsMultiselectItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/blueprints/select/MultiStateSelectItemView;", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "Lio/reactivex/Observable;", "getClickEventObservable", "()Lio/reactivex/Observable;", "clickEventObservable", "getClearEventObservable", "clearEventObservable", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface RdsMultiselectItemPresenter extends ItemPresenter<MultiStateSelectItemView, ParameterElement.Multiselect> {
    @NotNull
    Observable<ParameterElement.Multiselect> getClearEventObservable();

    @NotNull
    Observable<ParameterElement.Multiselect> getClickEventObservable();
}
