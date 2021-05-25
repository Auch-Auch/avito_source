package androidx.navigation;

import androidx.navigation.NavArgument;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@NavDestinationDsl
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R*\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R,\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u000e2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u000e8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R.\u0010!\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Landroidx/navigation/NavArgumentBuilder;", "", "Landroidx/navigation/NavArgument;", "build", "()Landroidx/navigation/NavArgument;", "", "value", "c", "Z", "getNullable", "()Z", "setNullable", "(Z)V", "nullable", "Landroidx/navigation/NavType;", AuthSource.BOOKING_ORDER, "Landroidx/navigation/NavType;", "_type", "getType", "()Landroidx/navigation/NavType;", "setType", "(Landroidx/navigation/NavType;)V", "type", "Landroidx/navigation/NavArgument$Builder;", AuthSource.SEND_ABUSE, "Landroidx/navigation/NavArgument$Builder;", "builder", "d", "Ljava/lang/Object;", "getDefaultValue", "()Ljava/lang/Object;", "setDefaultValue", "(Ljava/lang/Object;)V", "defaultValue", "<init>", "()V", "navigation-common-ktx_release"}, k = 1, mv = {1, 4, 0})
public final class NavArgumentBuilder {
    public final NavArgument.Builder a = new NavArgument.Builder();
    public NavType<?> b;
    public boolean c;
    @Nullable
    public Object d;

    @NotNull
    public final NavArgument build() {
        NavArgument build = this.a.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "builder.build()");
        return build;
    }

    @Nullable
    public final Object getDefaultValue() {
        return this.d;
    }

    public final boolean getNullable() {
        return this.c;
    }

    @NotNull
    public final NavType<?> getType() {
        NavType<?> navType = this.b;
        if (navType != null) {
            return navType;
        }
        throw new IllegalStateException("NavType has not been set on this builder.");
    }

    public final void setDefaultValue(@Nullable Object obj) {
        this.d = obj;
        this.a.setDefaultValue(obj);
    }

    public final void setNullable(boolean z) {
        this.c = z;
        this.a.setIsNullable(z);
    }

    public final void setType(@NotNull NavType<?> navType) {
        Intrinsics.checkParameterIsNotNull(navType, "value");
        this.b = navType;
        this.a.setType(navType);
    }
}
