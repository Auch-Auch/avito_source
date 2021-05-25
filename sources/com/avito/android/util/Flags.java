package com.avito.android.util;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/util/Flags;", "", "", "flag", "value", "", "contains", "(II)Z", "addFlag", "(II)I", "removeFlag", "<init>", "()V", VKApiConst.LANG}, k = 1, mv = {1, 4, 2})
public final class Flags {
    @NotNull
    public static final Flags INSTANCE = new Flags();

    public final int addFlag(int i, int i2) {
        return i | i2;
    }

    public final boolean contains(int i, int i2) {
        return (i & i2) == i2;
    }

    public final int removeFlag(int i, int i2) {
        return i & (~i2);
    }
}
