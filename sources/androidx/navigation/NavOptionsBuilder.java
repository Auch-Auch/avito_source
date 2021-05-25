package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.navigation.NavOptions;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J0\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\t\u0010\nJ&\u0010\r\u001a\u00020\u00062\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015R*\u0010\t\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006*"}, d2 = {"Landroidx/navigation/NavOptionsBuilder;", "", "", "id", "Lkotlin/Function1;", "Landroidx/navigation/PopUpToBuilder;", "", "Lkotlin/ExtensionFunctionType;", "popUpToBuilder", "popUpTo", "(ILkotlin/jvm/functions/Function1;)V", "Landroidx/navigation/AnimBuilder;", "animBuilder", "anim", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/navigation/NavOptions;", "build$navigation_common_ktx_release", "()Landroidx/navigation/NavOptions;", "build", "", AuthSource.BOOKING_ORDER, "Z", "getLaunchSingleTop", "()Z", "setLaunchSingleTop", "(Z)V", "launchSingleTop", "Landroidx/navigation/NavOptions$Builder;", AuthSource.SEND_ABUSE, "Landroidx/navigation/NavOptions$Builder;", "builder", "d", "inclusive", "value", "c", "I", "getPopUpTo", "()I", "setPopUpTo", "(I)V", "<init>", "()V", "navigation-common-ktx_release"}, k = 1, mv = {1, 4, 0})
@NavOptionsDsl
public final class NavOptionsBuilder {
    public final NavOptions.Builder a = new NavOptions.Builder();
    public boolean b;
    @IdRes
    public int c = -1;
    public boolean d;

    public final void anim(@NotNull Function1<? super AnimBuilder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "animBuilder");
        AnimBuilder animBuilder = new AnimBuilder();
        function1.invoke(animBuilder);
        this.a.setEnterAnim(animBuilder.getEnter()).setExitAnim(animBuilder.getExit()).setPopEnterAnim(animBuilder.getPopEnter()).setPopExitAnim(animBuilder.getPopExit());
    }

    @NotNull
    public final NavOptions build$navigation_common_ktx_release() {
        NavOptions.Builder builder = this.a;
        builder.setLaunchSingleTop(this.b);
        builder.setPopUpTo(this.c, this.d);
        NavOptions build = builder.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "builder.apply {\n        … inclusive)\n    }.build()");
        return build;
    }

    public final boolean getLaunchSingleTop() {
        return this.b;
    }

    public final int getPopUpTo() {
        return this.c;
    }

    public final void popUpTo(@IdRes int i, @NotNull Function1<? super PopUpToBuilder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "popUpToBuilder");
        setPopUpTo(i);
        PopUpToBuilder popUpToBuilder = new PopUpToBuilder();
        function1.invoke(popUpToBuilder);
        this.d = popUpToBuilder.getInclusive();
    }

    public final void setLaunchSingleTop(boolean z) {
        this.b = z;
    }

    public final void setPopUpTo(int i) {
        this.c = i;
        this.d = false;
    }
}
