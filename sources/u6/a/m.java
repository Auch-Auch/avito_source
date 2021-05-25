package u6.a;

import a2.b.a.a.a;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.NodeList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class m implements Incomplete {
    public final boolean a;

    public m(boolean z) {
        this.a = z;
    }

    @Override // kotlinx.coroutines.Incomplete
    @Nullable
    public NodeList getList() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return this.a;
    }

    @NotNull
    public String toString() {
        return a.s(a.L("Empty{"), this.a ? "Active" : "New", '}');
    }
}
