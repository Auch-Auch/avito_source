package com.avito.android.lib.design.deprecated.select;

import android.content.Context;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/lib/design/deprecated/select/DrawableHolder;", "", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "Lcom/avito/android/lib/design/deprecated/select/SelectState;", "state", "Landroid/content/Context;", "context", "", "setState", "(Lcom/avito/android/lib/design/deprecated/select/SelectState;Landroid/content/Context;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public interface DrawableHolder {
    @NotNull
    Drawable getDrawable();

    void setState(@NotNull SelectState selectState, @NotNull Context context);
}
