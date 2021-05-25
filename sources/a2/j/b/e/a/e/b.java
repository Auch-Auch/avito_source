package a2.j.b.e.a.e;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class b implements InstallStateUpdatedListener {
    @NotNull
    public final InstallStateUpdatedListener a;
    @NotNull
    public final Function1<b, Unit> b;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super a2.j.b.e.a.e.b, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull InstallStateUpdatedListener installStateUpdatedListener, @NotNull Function1<? super b, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(installStateUpdatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkParameterIsNotNull(function1, "disposeAction");
        this.a = installStateUpdatedListener;
        this.b = function1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.play.core.listener.StateUpdatedListener
    public void onStateUpdate(InstallState installState) {
        InstallState installState2 = installState;
        Intrinsics.checkParameterIsNotNull(installState2, "state");
        this.a.onStateUpdate(installState2);
        int installStatus = installState2.installStatus();
        if (installStatus == 0 || installStatus == 11 || installStatus == 5 || installStatus == 6) {
            this.b.invoke(this);
        }
    }
}
