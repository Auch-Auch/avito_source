package com.avito.android.remote.model.category_parameters.base;

import com.avito.android.remote.model.category_parameters.DisplayingOptions;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/base/TextParameter;", "Lcom/avito/android/remote/model/category_parameters/base/HasConstraints;", "Lcom/avito/android/remote/model/category_parameters/base/HasPlaceholder;", "", "getHint", "()Ljava/lang/String;", "getHint$annotations", "()V", "hint", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "getDisplayingOptions", "()Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "displayingOptions", "models_release"}, k = 1, mv = {1, 4, 2})
public interface TextParameter extends HasConstraints, HasPlaceholder {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @Deprecated(message = "Use placeholder instead")
        public static /* synthetic */ void getHint$annotations() {
        }
    }

    @Nullable
    DisplayingOptions getDisplayingOptions();

    @Nullable
    String getHint();
}
