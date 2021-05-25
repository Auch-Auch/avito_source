package arrow.core;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Larrow/core/None;", "Larrow/core/Option;", "", "get", "()Ljava/lang/Void;", "", "isEmpty", "()Z", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
public final class None extends Option {
    public static final None INSTANCE = new None();

    public None() {
        super(null);
    }

    @Override // arrow.core.Option
    public boolean isEmpty() {
        return true;
    }

    @NotNull
    public String toString() {
        return "None";
    }

    @Override // arrow.core.Option
    @NotNull
    public Void get() {
        throw new NoSuchElementException("None.get");
    }
}
