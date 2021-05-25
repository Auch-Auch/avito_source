package com.avito.android.lib.design.deprecated.select;

import android.content.Context;
import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/lib/design/deprecated/select/DrawableHolderFactory;", "", "Lcom/avito/android/lib/design/deprecated/select/SelectMode;", "mode", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/lib/design/deprecated/select/DrawableHolder;", "createBackgroundHolder", "(Lcom/avito/android/lib/design/deprecated/select/SelectMode;Landroid/content/res/Resources;)Lcom/avito/android/lib/design/deprecated/select/DrawableHolder;", "Landroid/content/Context;", "context", "createClearDrawableHolder", "(Landroid/content/Context;)Lcom/avito/android/lib/design/deprecated/select/DrawableHolder;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class DrawableHolderFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SelectMode.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    @NotNull
    public final DrawableHolder createBackgroundHolder(@NotNull SelectMode selectMode, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(selectMode, "mode");
        Intrinsics.checkNotNullParameter(resources, "resources");
        int ordinal = selectMode.ordinal();
        if (ordinal == 0) {
            return new InputDrawableHolder(resources);
        }
        if (ordinal == 1) {
            return new SelectDrawableHolder(resources);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final DrawableHolder createClearDrawableHolder(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ClearDrawableHolder(context);
    }
}
