package kotlin.reflect.jvm.internal.impl.types;

import com.vk.sdk.api.VKApiConst;
import org.jetbrains.annotations.NotNull;
public enum Variance {
    INVARIANT("", true, true, 0),
    IN_VARIANCE("in", true, false, -1),
    OUT_VARIANCE(VKApiConst.OUT, false, true, 1);
    
    @NotNull
    public final String a;
    public final boolean b;

    /* access modifiers changed from: public */
    Variance(String str, boolean z, boolean z2, int i) {
        this.a = str;
        this.b = z2;
    }

    public final boolean getAllowsOutPosition() {
        return this.b;
    }

    @NotNull
    public final String getLabel() {
        return this.a;
    }

    @Override // java.lang.Enum, java.lang.Object
    @NotNull
    public String toString() {
        return this.a;
    }
}
