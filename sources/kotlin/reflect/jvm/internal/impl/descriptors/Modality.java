package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
public enum Modality {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;
    
    @NotNull
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Modality convertFromFlags(boolean z, boolean z2, boolean z3) {
            if (z) {
                return Modality.SEALED;
            }
            if (z2) {
                return Modality.ABSTRACT;
            }
            if (z3) {
                return Modality.OPEN;
            }
            return Modality.FINAL;
        }

        public Companion(j jVar) {
        }
    }
}
