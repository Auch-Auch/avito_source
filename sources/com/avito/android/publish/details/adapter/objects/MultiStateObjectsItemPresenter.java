package com.avito.android.publish.details.adapter.objects;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001R(\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00050\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/details/adapter/objects/MultiStateObjectsItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/publish/details/adapter/objects/MultiStateObjectsItemView;", "Lcom/avito/android/category_parameters/ParameterElement$Objects;", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "getObjectItemClicks", "()Lio/reactivex/Observable;", "objectItemClicks", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface MultiStateObjectsItemPresenter extends ItemPresenter<MultiStateObjectsItemView, ParameterElement.Objects> {
    @NotNull
    Observable<Pair<ParameterElement.Objects, Integer>> getObjectItemClicks();
}
