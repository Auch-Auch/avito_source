package com.avito.android.publish.objects;

import android.os.Bundle;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/Navigation;", "navigation", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "objectsParameter", "", "objectIndex", "Lcom/avito/android/publish/objects/FillObjectsFragment;", "createFillObjectsFragment", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;Ljava/lang/Integer;)Lcom/avito/android/publish/objects/FillObjectsFragment;", "publish_release"}, k = 2, mv = {1, 4, 2})
public final class FillObjectsFragmentKt {
    @NotNull
    public static final FillObjectsFragment createFillObjectsFragment(@NotNull Navigation navigation, @NotNull ObjectsParameter objectsParameter, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(objectsParameter, "objectsParameter");
        FillObjectsFragment fillObjectsFragment = new FillObjectsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("navigation", navigation);
        bundle.putParcelable("parameter", objectsParameter);
        if (num != null) {
            bundle.putInt("object_index", num.intValue());
        }
        Unit unit = Unit.INSTANCE;
        fillObjectsFragment.setArguments(bundle);
        return fillObjectsFragment;
    }
}
