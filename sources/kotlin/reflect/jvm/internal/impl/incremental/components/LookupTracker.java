package kotlin.reflect.jvm.internal.impl.incremental.components;

import com.vk.sdk.api.VKApiConst;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public interface LookupTracker {

    public static final class DO_NOTHING implements LookupTracker {
        @NotNull
        public static final DO_NOTHING INSTANCE = new DO_NOTHING();

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public boolean getRequiresPosition() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public void record(@NotNull String str, @NotNull Position position, @NotNull String str2, @NotNull ScopeKind scopeKind, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "filePath");
            Intrinsics.checkNotNullParameter(position, VKApiConst.POSITION);
            Intrinsics.checkNotNullParameter(str2, "scopeFqName");
            Intrinsics.checkNotNullParameter(scopeKind, "scopeKind");
            Intrinsics.checkNotNullParameter(str3, "name");
        }
    }

    boolean getRequiresPosition();

    void record(@NotNull String str, @NotNull Position position, @NotNull String str2, @NotNull ScopeKind scopeKind, @NotNull String str3);
}
