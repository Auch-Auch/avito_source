package kotlin.reflect.jvm.internal.impl.resolve.sam;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNullableValues;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
public final class SamConversionResolverImpl implements SamConversionResolver {
    @NotNull
    public final Iterable<Object> a;
    @NotNull
    public final CacheWithNullableValues<ClassDescriptor, SimpleType> b;

    public SamConversionResolverImpl(@NotNull StorageManager storageManager, @NotNull Iterable<? extends Object> iterable) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(iterable, "samWithReceiverResolvers");
        this.a = iterable;
        this.b = storageManager.createCacheWithNullableValues();
    }
}
