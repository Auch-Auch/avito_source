package com.avito.android.messenger.channels.mvi.common.v3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/PropertyToStringConverter;", "Lcom/avito/android/messenger/channels/mvi/common/v3/ToStringConverter;", "Lkotlin/reflect/KMutableProperty0;", "value", "", "convertToString", "(Lkotlin/reflect/KMutableProperty0;)Ljava/lang/String;", "<init>", "()V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public final class PropertyToStringConverter implements ToStringConverter<KMutableProperty0<?>> {
    @NotNull
    public static final PropertyToStringConverter INSTANCE = new PropertyToStringConverter();

    @NotNull
    public String convertToString(@NotNull KMutableProperty0<?> kMutableProperty0) {
        Intrinsics.checkNotNullParameter(kMutableProperty0, "value");
        return kMutableProperty0.getName();
    }
}
