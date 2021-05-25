package kotlin.reflect.jvm.internal.impl.types.model;

import com.vk.sdk.api.VKApiConst;
import org.jetbrains.annotations.NotNull;
public enum TypeVariance {
    IN("in"),
    OUT(VKApiConst.OUT),
    INV("");
    
    @NotNull
    public final String a;

    /* access modifiers changed from: public */
    TypeVariance(String str) {
        this.a = str;
    }

    @Override // java.lang.Enum, java.lang.Object
    @NotNull
    public String toString() {
        return this.a;
    }
}
