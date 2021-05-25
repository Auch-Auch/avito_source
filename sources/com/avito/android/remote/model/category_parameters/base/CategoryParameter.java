package com.avito.android.remote.model.category_parameters.base;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "Lcom/avito/android/remote/model/category_parameters/base/BaseParameter;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class CategoryParameter implements ParameterSlot, BaseParameter {
    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(obj != null ? obj.getClass() : null, getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.remote.model.category_parameters.base.CategoryParameter");
        return !(Intrinsics.areEqual(getId(), ((CategoryParameter) obj).getId()) ^ true);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getId().hashCode();
    }
}
