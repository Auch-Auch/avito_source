package com.avito.android.serp.adapter.witcher;

import android.os.Parcelable;
import com.avito.android.util.Kundle;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/serp/adapter/witcher/WitcherItemView;", "Lcom/avito/android/serp/adapter/witcher/WitcherItem;", "Landroid/os/Parcelable;", "parcel", "", "getSavedState", "(Landroid/os/Parcelable;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "invalidateState", "()V", "", "hasCarousel", "()Z", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface WitcherItemPresenter extends ItemPresenter<WitcherItemView, WitcherItem> {
    void getSavedState(@Nullable Parcelable parcelable);

    boolean hasCarousel();

    void invalidateState();

    @NotNull
    Kundle onSaveState();
}
