package com.avito.android.remote.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\t\u001a!\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000b\u001a+\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\n2\b\u0010\b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\f¨\u0006\r"}, d2 = {"", "colorKey", "", "defColor", "Lcom/avito/android/remote/model/UniversalColor;", "universalColorOf", "(Ljava/lang/String;I)Lcom/avito/android/remote/model/UniversalColor;", "defColorLight", "defColorDark", "(Ljava/lang/String;II)Lcom/avito/android/remote/model/UniversalColor;", "Lcom/avito/android/remote/model/Color;", "(Ljava/lang/String;Lcom/avito/android/remote/model/Color;)Lcom/avito/android/remote/model/UniversalColor;", "(Ljava/lang/String;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;)Lcom/avito/android/remote/model/UniversalColor;", "models_release"}, k = 2, mv = {1, 4, 2})
public final class UniversalColorKt {
    @NotNull
    public static final UniversalColor universalColorOf(@Nullable String str, int i) {
        return universalColorOf(str, i, i);
    }

    public static /* synthetic */ UniversalColor universalColorOf$default(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return universalColorOf(str, i);
    }

    @NotNull
    public static final UniversalColor universalColorOf(@Nullable String str, int i, int i2) {
        return new UniversalColor(str, new Color(i), new Color(i2));
    }

    @NotNull
    public static final UniversalColor universalColorOf(@Nullable String str, @Nullable Color color) {
        return universalColorOf(str, color, color);
    }

    @NotNull
    public static final UniversalColor universalColorOf(@Nullable String str, @Nullable Color color, @Nullable Color color2) {
        return new UniversalColor(str, color2, color);
    }
}
