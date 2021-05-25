package com.avito.android.beduin.core.model.container.component;

import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.form.BeduinModelTransform;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "Landroid/os/Parcelable;", "Lcom/avito/android/beduin/core/form/BeduinModelTransform;", "transform", "apply", "(Lcom/avito/android/beduin/core/form/BeduinModelTransform;)Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "", "", "", "getParameters", "()Ljava/util/Map;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "isValid", "()Z", "", "Lcom/avito/android/beduin/core/action/BeduinAction;", "getActions", "()Ljava/util/List;", "actions", "getId", "()Ljava/lang/String;", "id", "beduin_release"}, k = 1, mv = {1, 4, 2})
public interface BeduinModel extends Parcelable {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static BeduinModel apply(@NotNull BeduinModel beduinModel, @NotNull BeduinModelTransform beduinModelTransform) {
            Intrinsics.checkNotNullParameter(beduinModelTransform, "transform");
            return beduinModel;
        }

        @NotNull
        public static Map<String, Object> getParameters(@NotNull BeduinModel beduinModel) {
            return r.emptyMap();
        }

        public static boolean isValid(@NotNull BeduinModel beduinModel) {
            return true;
        }
    }

    @NotNull
    BeduinModel apply(@NotNull BeduinModelTransform beduinModelTransform);

    @Nullable
    List<BeduinAction> getActions();

    @Nullable
    String getId();

    @NotNull
    Map<String, Object> getParameters();

    boolean isValid();
}
