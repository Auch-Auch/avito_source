package t6;

import kotlin.InitializedLazyImpl;
import kotlin.Lazy;
import org.jetbrains.annotations.NotNull;
public class d extends c {
    @NotNull
    public static final <T> Lazy<T> lazyOf(T t) {
        return new InitializedLazyImpl(t);
    }
}
