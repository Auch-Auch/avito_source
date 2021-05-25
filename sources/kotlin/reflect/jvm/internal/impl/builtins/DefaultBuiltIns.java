package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
public final class DefaultBuiltIns extends KotlinBuiltIns {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final DefaultBuiltIns f = new DefaultBuiltIns(false, 1, null);

    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final DefaultBuiltIns getInstance() {
            return DefaultBuiltIns.f;
        }

        public Companion(j jVar) {
        }
    }

    public DefaultBuiltIns() {
        this(false, 1, null);
    }

    public DefaultBuiltIns(boolean z) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (z) {
            createBuiltInsModule(false);
        }
    }

    @NotNull
    public static final DefaultBuiltIns getInstance() {
        return Companion.getInstance();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultBuiltIns(boolean z, int i, j jVar) {
        this((i & 1) != 0 ? true : z);
    }
}
