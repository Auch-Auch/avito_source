package com.avito.android.toggle;

import com.avito.android.toggle.Feature;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002R\u001c\u0010\u0007\u001a\u00028\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/toggle/MutableFeature;", "T", "Lcom/avito/android/toggle/Feature;", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value", "features_release"}, k = 1, mv = {1, 4, 2})
public interface MutableFeature<T> extends Feature<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static <T> T getOriginalValue(@NotNull MutableFeature<T> mutableFeature) {
            return (T) Feature.DefaultImpls.getOriginalValue(mutableFeature);
        }

        public static <T> T invoke(@NotNull MutableFeature<T> mutableFeature) {
            return (T) Feature.DefaultImpls.invoke(mutableFeature);
        }
    }

    @Override // com.avito.android.toggle.Feature
    T getValue();

    void setValue(T t);
}
