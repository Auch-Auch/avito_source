package com.avito.android.developments_catalog.items.buildingProgress;

import com.avito.android.remote.model.Image;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/developments_catalog/items/buildingProgress/BuildingProgressImageClickListener;", "", "", VKApiConst.POSITION, "", "Lcom/avito/android/remote/model/Image;", "images", "", "onPhotoClicked", "(ILjava/util/List;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface BuildingProgressImageClickListener {
    void onPhotoClicked(int i, @NotNull List<Image> list);
}
