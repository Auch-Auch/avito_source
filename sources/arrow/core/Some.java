package arrow.core;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J \u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\f\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\f\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Larrow/core/Some;", "T", "Larrow/core/Option;", "get", "()Ljava/lang/Object;", "", "isEmpty", "()Z", "", "toString", "()Ljava/lang/String;", "component1", "t", "copy", "(Ljava/lang/Object;)Larrow/core/Some;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getT", "<init>", "(Ljava/lang/Object;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
public final class Some<T> extends Option<T> {
    public final T a;

    public Some(T t) {
        super(null);
        this.a = t;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: arrow.core.Some */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static /* bridge */ /* synthetic */ Some copy$default(Some some, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = some.a;
        }
        return some.copy(obj);
    }

    public final T component1() {
        return this.a;
    }

    @NotNull
    public final Some<T> copy(T t) {
        return new Some<>(t);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Some) && Intrinsics.areEqual(this.a, ((Some) obj).a);
        }
        return true;
    }

    @Override // arrow.core.Option
    public T get() {
        return this.a;
    }

    public final T getT() {
        return this.a;
    }

    public int hashCode() {
        T t = this.a;
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    @Override // arrow.core.Option
    public boolean isEmpty() {
        return false;
    }

    @NotNull
    public String toString() {
        return a.q(a.L("Some("), this.a, ')');
    }
}
