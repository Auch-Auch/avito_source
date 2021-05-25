package com.avito.android.beduin.core.model.container;

import com.avito.android.beduin.core.form.BeduinModelTransform;
import com.avito.android.beduin.core.model.BedionContainerIndent;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/avito/android/beduin/core/model/container/BeduinContainerModel;", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "Lcom/avito/android/beduin/core/model/BedionContainerIndent;", "getMargin", "()Lcom/avito/android/beduin/core/model/BedionContainerIndent;", "margin", "", "getInterItemSpacing", "()Ljava/lang/Integer;", "interItemSpacing", "Lcom/avito/android/beduin/core/model/container/BeduinContainerBackground;", "getBackground", "()Lcom/avito/android/beduin/core/model/container/BeduinContainerBackground;", "background", "getPadding", "padding", "beduin_release"}, k = 1, mv = {1, 4, 2})
public interface BeduinContainerModel extends BeduinModel {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static BeduinModel apply(@NotNull BeduinContainerModel beduinContainerModel, @NotNull BeduinModelTransform beduinModelTransform) {
            Intrinsics.checkNotNullParameter(beduinModelTransform, "transform");
            return BeduinModel.DefaultImpls.apply(beduinContainerModel, beduinModelTransform);
        }

        @NotNull
        public static Map<String, Object> getParameters(@NotNull BeduinContainerModel beduinContainerModel) {
            return BeduinModel.DefaultImpls.getParameters(beduinContainerModel);
        }

        public static boolean isValid(@NotNull BeduinContainerModel beduinContainerModel) {
            return BeduinModel.DefaultImpls.isValid(beduinContainerModel);
        }
    }

    @Nullable
    BeduinContainerBackground getBackground();

    @Nullable
    Integer getInterItemSpacing();

    @Nullable
    BedionContainerIndent getMargin();

    @Nullable
    BedionContainerIndent getPadding();
}
