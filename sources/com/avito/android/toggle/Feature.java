package com.avito.android.toggle;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00028\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\tR\u0016\u0010\u0011\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/avito/android/toggle/Feature;", "T", "", "invoke", "()Ljava/lang/Object;", "getOriginalValue", "originalValue", "", "getApiToggleId", "()Ljava/lang/String;", "apiToggleId", "", "isRemote", "()Z", "getDescription", "description", "getValue", "value", "getKey", "key", "features_release"}, k = 1, mv = {1, 4, 2})
public interface Feature<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static <T> T getOriginalValue(@NotNull Feature<? extends T> feature) {
            return (T) feature.getValue();
        }

        public static <T> T invoke(@NotNull Feature<? extends T> feature) {
            return (T) feature.getValue();
        }
    }

    @Nullable
    String getApiToggleId();

    @NotNull
    String getDescription();

    @NotNull
    String getKey();

    T getOriginalValue();

    T getValue();

    T invoke();

    boolean isRemote();
}
