package org.kodein.di;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H¦\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lorg/kodein/di/LazyDelegate;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "receiver", "Lkotlin/reflect/KProperty;", "prop", "Lkotlin/Lazy;", "provideDelegate", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Lkotlin/Lazy;", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface LazyDelegate<V> {
    @NotNull
    Lazy<V> provideDelegate(@Nullable Object obj, @NotNull KProperty<? extends Object> kProperty);
}
