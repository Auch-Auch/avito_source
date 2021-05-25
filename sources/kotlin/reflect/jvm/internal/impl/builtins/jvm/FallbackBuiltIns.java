package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
public final class FallbackBuiltIns extends KotlinBuiltIns {
    @NotNull
    public static final Companion f = new Companion(null);
    @NotNull
    public static final KotlinBuiltIns g = new FallbackBuiltIns();

    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final KotlinBuiltIns getInstance() {
            return FallbackBuiltIns.g;
        }

        public Companion(j jVar) {
        }
    }

    public FallbackBuiltIns() {
        super(new LockBasedStorageManager("FallbackBuiltIns"));
        createBuiltInsModule(true);
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return PlatformDependentDeclarationFilter.All.INSTANCE;
    }
}
