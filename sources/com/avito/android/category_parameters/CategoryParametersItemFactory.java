package com.avito.android.category_parameters;

import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H$¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H$¢\u0006\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/category_parameters/CategoryParametersItemFactory;", "", "Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "parameter", "Lcom/avito/conveyor_item/Item;", "generateItem", "(Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;)Lcom/avito/conveyor_item/Item;", "", "needCreate", "(Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;)Z", "createItem", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public abstract class CategoryParametersItemFactory {
    @NotNull
    public abstract Item createItem(@NotNull CategoryParameter categoryParameter);

    @Nullable
    public final Item generateItem(@NotNull CategoryParameter categoryParameter) {
        Intrinsics.checkNotNullParameter(categoryParameter, "parameter");
        if (needCreate(categoryParameter)) {
            return createItem(categoryParameter);
        }
        return null;
    }

    public abstract boolean needCreate(@NotNull CategoryParameter categoryParameter);
}
