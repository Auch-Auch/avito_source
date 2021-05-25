package com.avito.android.developments_catalog.items.buildingProgress;

import com.avito.android.remote.model.BuildingProgress;
import com.avito.android.remote.model.Image;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\f\u001a\u00020\u00042\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u00040\u0007H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/developments_catalog/items/buildingProgress/BuildingProgressView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/BuildingProgress;", "progress", "", "setData", "(Lcom/avito/android/remote/model/BuildingProgress;)V", "Lkotlin/Function2;", "", "", "Lcom/avito/android/remote/model/Image;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setBuildingProgressImageClickListener", "(Lkotlin/jvm/functions/Function2;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface BuildingProgressView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull BuildingProgressView buildingProgressView) {
            ItemView.DefaultImpls.onUnbind(buildingProgressView);
        }
    }

    void setBuildingProgressImageClickListener(@NotNull Function2<? super Integer, ? super List<Image>, Unit> function2);

    void setData(@NotNull BuildingProgress buildingProgress);
}
