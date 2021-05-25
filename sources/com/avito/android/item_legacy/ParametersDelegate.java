package com.avito.android.item_legacy;

import com.avito.android.remote.model.category_parameters.CategoryParameters;
import kotlin.Metadata;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H¦\u0002¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\n\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0005H¦\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/item_legacy/ParametersDelegate;", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "getValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "value", "", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface ParametersDelegate {
    @Nullable
    CategoryParameters getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty);

    void setValue(@Nullable Object obj, @NotNull KProperty<?> kProperty, @Nullable CategoryParameters categoryParameters);
}
