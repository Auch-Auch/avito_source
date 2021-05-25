package com.avito.android.publish.wizard.blueprint;

import com.avito.android.publish.wizard.WizardItem;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/wizard/blueprint/WizardItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/publish/wizard/blueprint/WizardItemView;", "Lcom/avito/android/publish/wizard/WizardItem;", "Lio/reactivex/Observable;", "getItemClickObservable", "()Lio/reactivex/Observable;", "itemClickObservable", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface WizardItemPresenter extends ItemPresenter<WizardItemView, WizardItem> {
    @NotNull
    Observable<WizardItem> getItemClickObservable();
}
