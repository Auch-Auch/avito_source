package com.avito.konveyor.blueprint;

import androidx.exifinterface.media.ExifInterface;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemView;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0000*\u00020\u0001*\n\b\u0001\u0010\u0004 \u0000*\u00020\u00032\u00020\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemView;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/avito/konveyor/blueprint/Item;", "I", "", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "getPresenter", "()Lcom/avito/konveyor/blueprint/ItemPresenter;", "presenter", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public interface ItemBlueprint<V extends ItemView, I extends Item> {
    @NotNull
    ItemPresenter<V, I> getPresenter();

    @NotNull
    ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> getViewHolderProvider();

    boolean isRelevantItem(@NotNull Item item);
}
