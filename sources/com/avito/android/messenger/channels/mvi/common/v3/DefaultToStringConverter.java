package com.avito.android.messenger.channels.mvi.common.v3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/DefaultToStringConverter;", "", "T", "Lcom/avito/android/messenger/channels/mvi/common/v3/ToStringConverter;", "value", "", "convertToString", "(Ljava/lang/Object;)Ljava/lang/String;", "<init>", "()V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public final class DefaultToStringConverter<T> implements ToStringConverter<T> {
    @Override // com.avito.android.messenger.channels.mvi.common.v3.ToStringConverter
    @NotNull
    public String convertToString(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "value");
        return t.toString();
    }
}
