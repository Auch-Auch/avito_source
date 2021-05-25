package com.avito.konveyor.blueprint;

import androidx.exifinterface.media.ExifInterface;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0000*\u00020\u0001*\n\b\u0001\u0010\u0004 \u0000*\u00020\u00032\u00020\u0005J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00012\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemView;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/avito/konveyor/blueprint/Item;", "I", "", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/konveyor/blueprint/ItemView;Lcom/avito/konveyor/blueprint/Item;I)V", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public interface ItemPresenter<V extends ItemView, I extends Item> {
    void bindView(@NotNull V v, @NotNull I i, int i2);
}
