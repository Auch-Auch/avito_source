package ru.sravni.android.bankproduct.domain;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u00028\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"T", "Lru/sravni/android/bankproduct/domain/DataContainer;", "toDataContainer", "(Ljava/lang/Object;)Lru/sravni/android/bankproduct/domain/DataContainer;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class DataContainerKt {
    @NotNull
    public static final <T> DataContainer<T> toDataContainer(T t) {
        return new DataContainer<>(t, null);
    }
}
