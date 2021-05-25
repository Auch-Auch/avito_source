package org.kodein.di.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0000¢\u0006\u0004\b\u0007\u0010\u000b\u001a.\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\b¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "newConcurrentMap", "()Ljava/util/Map;", "T", "", "newLinkedList", "()Ljava/util/List;", "", "c", "(Ljava/util/Collection;)Ljava/util/List;", "R", "", "lock", "Lkotlin/Function0;", "block", "maySynchronized", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class LangKt {
    public static final <R> R maySynchronized(@Nullable Object obj, @NotNull Function0<? extends R> function0) {
        R r;
        Intrinsics.checkParameterIsNotNull(function0, "block");
        if (obj == null) {
            return (R) function0.invoke();
        }
        synchronized (obj) {
            try {
                r = (R) function0.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return r;
    }

    @NotNull
    public static final <K, V> Map<K, V> newConcurrentMap() {
        return new ConcurrentHashMap();
    }

    @NotNull
    public static final <T> List<T> newLinkedList() {
        return new LinkedList();
    }

    @NotNull
    public static final <T> List<T> newLinkedList(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "c");
        return new LinkedList(collection);
    }
}
