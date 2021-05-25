package com.avito.android.blueprints.video;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.BasicInputItem;
import com.avito.android.items.ItemWithAdditionalButton;
import com.avito.konveyor.blueprint.PayloadItemPresenter;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R(\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t0\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/avito/android/blueprints/video/VideoItemPresenter;", "Lcom/avito/konveyor/blueprint/PayloadItemPresenter;", "Lcom/avito/android/blueprints/video/VideoItemView;", "Lcom/avito/android/category_parameters/ParameterElement$Video;", "Lio/reactivex/Observable;", "Lcom/avito/android/items/BasicInputItem;", "getValueChangesObservable", "()Lio/reactivex/Observable;", "valueChangesObservable", "Lkotlin/Pair;", "", "getFocusChangesObservable", "focusChangesObservable", "Lcom/avito/android/items/ItemWithAdditionalButton;", "getRightIconClickObservable", "rightIconClickObservable", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface VideoItemPresenter extends PayloadItemPresenter<VideoItemView, ParameterElement.Video> {
    @NotNull
    Observable<Pair<Boolean, BasicInputItem>> getFocusChangesObservable();

    @NotNull
    Observable<ItemWithAdditionalButton> getRightIconClickObservable();

    @NotNull
    Observable<BasicInputItem> getValueChangesObservable();
}
