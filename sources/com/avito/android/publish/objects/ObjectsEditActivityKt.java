package com.avito.android.publish.objects;

import android.content.Context;
import android.content.Intent;
import com.avito.android.publish.objects.FillObjectsFragment;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/remote/model/Navigation;", "navigation", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "objectsParameter", "", "objectIndex", "Landroid/content/Intent;", "createObjectsEditIntent", "(Landroid/content/Context;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;Ljava/lang/Integer;)Landroid/content/Intent;", "publish_release"}, k = 2, mv = {1, 4, 2})
public final class ObjectsEditActivityKt {
    @NotNull
    public static final Intent createObjectsEditIntent(@NotNull Context context, @NotNull Navigation navigation, @NotNull ObjectsParameter objectsParameter, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(objectsParameter, "objectsParameter");
        Intent putExtra = new Intent(context, ObjectsEditActivity.class).putExtra("arguments", new FillObjectsFragment.Arguments(navigation, objectsParameter, num));
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, ObjectsE…x\n            )\n        )");
        return putExtra;
    }

    public static /* synthetic */ Intent createObjectsEditIntent$default(Context context, Navigation navigation, ObjectsParameter objectsParameter, Integer num, int i, Object obj) {
        if ((i & 8) != 0) {
            num = null;
        }
        return createObjectsEditIntent(context, navigation, objectsParameter, num);
    }
}
