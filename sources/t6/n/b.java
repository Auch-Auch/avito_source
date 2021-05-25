package t6.n;

import a2.b.a.a.a;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class b {
    @NotNull
    public static final <T> T[] arrayOfNulls(@NotNull T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "reference");
        Object newInstance = Array.newInstance(tArr.getClass().getComponentType(), i);
        Objects.requireNonNull(newInstance, "null cannot be cast to non-null type kotlin.Array<T>");
        return (T[]) ((Object[]) newInstance);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "contentDeepHashCode")
    @PublishedApi
    public static final <T> int contentDeepHashCode(@Nullable T[] tArr) {
        return Arrays.deepHashCode(tArr);
    }

    @SinceKotlin(version = "1.3")
    public static final void copyOfRangeToIndexCheck(int i, int i2) {
        if (i > i2) {
            throw new IndexOutOfBoundsException(a.S2("toIndex (", i, ") is greater than size (", i2, ")."));
        }
    }

    public static final /* synthetic */ <T> T[] orEmpty(T[] tArr) {
        if (tArr != null) {
            return tArr;
        }
        Intrinsics.reifiedOperationMarker(0, "T?");
        return (T[]) new Object[0];
    }

    public static final /* synthetic */ <T> T[] toTypedArray(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$toTypedArray");
        Intrinsics.reifiedOperationMarker(0, "T?");
        T[] tArr = (T[]) collection.toArray(new Object[0]);
        Objects.requireNonNull(tArr, "null cannot be cast to non-null type kotlin.Array<T>");
        return tArr;
    }
}
