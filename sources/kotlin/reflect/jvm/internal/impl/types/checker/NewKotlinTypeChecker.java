package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
public interface NewKotlinTypeChecker extends KotlinTypeChecker {
    @NotNull
    public static final Companion Companion = Companion.a;

    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();
        @NotNull
        public static final NewKotlinTypeCheckerImpl b = new NewKotlinTypeCheckerImpl(KotlinTypeRefiner.Default.INSTANCE);

        @NotNull
        public final NewKotlinTypeCheckerImpl getDefault() {
            return b;
        }
    }

    @NotNull
    KotlinTypeRefiner getKotlinTypeRefiner();

    @NotNull
    OverridingUtil getOverridingUtil();
}
