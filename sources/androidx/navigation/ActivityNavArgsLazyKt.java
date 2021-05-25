package androidx.navigation;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.MainThread;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/navigation/NavArgs;", "Args", "Landroid/app/Activity;", "Landroidx/navigation/NavArgsLazy;", "navArgs", "(Landroid/app/Activity;)Landroidx/navigation/NavArgsLazy;", "navigation-runtime-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class ActivityNavArgsLazyKt {
    @MainThread
    @NotNull
    public static final /* synthetic */ <Args extends NavArgs> NavArgsLazy<Args> navArgs(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "$this$navArgs");
        Intrinsics.reifiedOperationMarker(4, "Args");
        return new NavArgsLazy<>(Reflection.getOrCreateKotlinClass(NavArgs.class), new Function0<Bundle>(activity) { // from class: androidx.navigation.ActivityNavArgsLazyKt$navArgs$1
            public final /* synthetic */ Activity a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Bundle invoke() {
                Intent intent = this.a.getIntent();
                if (intent != null) {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        return extras;
                    }
                    StringBuilder L = a.L("Activity ");
                    L.append(this.a);
                    L.append(" has null extras in ");
                    L.append(intent);
                    throw new IllegalStateException(L.toString());
                }
                StringBuilder L2 = a.L("Activity ");
                L2.append(this.a);
                L2.append(" has a null Intent");
                throw new IllegalStateException(L2.toString());
            }
        });
    }
}
