package com.avito.konveyor.blueprint;

import androidx.exifinterface.media.ExifInterface;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemView;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0000*\u00020\u0001*\n\b\u0001\u0010\u0004 \u0000*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005J5\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00012\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/konveyor/blueprint/PayloadItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemView;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/avito/konveyor/blueprint/Item;", "I", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "view", "item", "", VKApiConst.POSITION, "", "", "payloads", "", "bindView", "(Lcom/avito/konveyor/blueprint/ItemView;Lcom/avito/konveyor/blueprint/Item;ILjava/util/List;)V", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public interface PayloadItemPresenter<V extends ItemView, I extends Item> extends ItemPresenter<V, I> {
    void bindView(@NotNull V v, @NotNull I i, int i2, @NotNull List<? extends Object> list);
}
