package com.avito.android.remote.model.category_parameters.base;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/base/BaseEditableParameter;", "T", "", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value", "", "getUpdatesForm", "()Ljava/lang/Boolean;", "updatesForm", "models_release"}, k = 1, mv = {1, 4, 2})
public interface BaseEditableParameter<T> {
    @Nullable
    Boolean getUpdatesForm();

    @Nullable
    T getValue();

    void setValue(@Nullable T t);
}
