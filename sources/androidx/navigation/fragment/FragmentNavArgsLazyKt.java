package androidx.navigation.fragment;

import a2.b.a.a.a;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgs;
import androidx.navigation.NavArgsLazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/navigation/NavArgs;", "Args", "Landroidx/fragment/app/Fragment;", "Landroidx/navigation/NavArgsLazy;", "navArgs", "(Landroidx/fragment/app/Fragment;)Landroidx/navigation/NavArgsLazy;", "navigation-fragment-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class FragmentNavArgsLazyKt {
    @MainThread
    @NotNull
    public static final /* synthetic */ <Args extends NavArgs> NavArgsLazy<Args> navArgs(@NotNull Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$navArgs");
        Intrinsics.reifiedOperationMarker(4, "Args");
        return new NavArgsLazy<>(Reflection.getOrCreateKotlinClass(NavArgs.class), new Function0<Bundle>(fragment) { // from class: androidx.navigation.fragment.FragmentNavArgsLazyKt$navArgs$1
            public final /* synthetic */ Fragment a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Bundle invoke() {
                Bundle arguments = this.a.getArguments();
                if (arguments != null) {
                    return arguments;
                }
                StringBuilder L = a.L("Fragment ");
                L.append(this.a);
                L.append(" has null arguments");
                throw new IllegalStateException(L.toString());
            }
        });
    }
}
