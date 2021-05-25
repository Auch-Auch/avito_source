package kotlinx.coroutines.internal;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\u0004¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/internal/Symbol;", "", "", "toString", "()Ljava/lang/String;", "T", "value", "unbox", "(Ljava/lang/Object;)Ljava/lang/Object;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSymbol", "symbol", "<init>", "(Ljava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class Symbol {
    @NotNull
    public final String a;

    public Symbol(@NotNull String str) {
        this.a = str;
    }

    @NotNull
    public final String getSymbol() {
        return this.a;
    }

    @NotNull
    public String toString() {
        return this.a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T unbox(@Nullable Object obj) {
        if (obj == this) {
            return null;
        }
        return obj;
    }
}
