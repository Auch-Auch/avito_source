package com.avito.android.remote.model.category_parameters.base;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/base/HasHtmlValueSupport;", "Lcom/avito/android/remote/model/category_parameters/base/TextParameter;", "", "getRenderedHtmlValue", "()Ljava/lang/String;", "setRenderedHtmlValue", "(Ljava/lang/String;)V", "renderedHtmlValue", "models_release"}, k = 1, mv = {1, 4, 2})
public interface HasHtmlValueSupport extends TextParameter {
    @Nullable
    String getRenderedHtmlValue();

    void setRenderedHtmlValue(@Nullable String str);
}
