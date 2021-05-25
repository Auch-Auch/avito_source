package kotlin.reflect.jvm.internal.impl.descriptors;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public abstract class Visibility {
    @NotNull
    public final String a;
    public final boolean b;

    public Visibility(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.a = str;
        this.b = z;
    }

    @Nullable
    public Integer compareTo(@NotNull Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY);
        return Visibilities.INSTANCE.compareLocal$compiler_common(this, visibility);
    }

    @NotNull
    public String getInternalDisplayName() {
        return this.a;
    }

    public final boolean isPublicAPI() {
        return this.b;
    }

    @NotNull
    public Visibility normalize() {
        return this;
    }

    @NotNull
    public final String toString() {
        return getInternalDisplayName();
    }
}
