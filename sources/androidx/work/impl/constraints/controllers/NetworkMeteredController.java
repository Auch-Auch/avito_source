package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
public class NetworkMeteredController extends ConstraintController<NetworkState> {
    public static final String e = Logger.tagWithPrefix("NetworkMeteredCtrlr");

    public NetworkMeteredController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.getInstance(context, taskExecutor).getNetworkStateTracker());
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean a(@NonNull WorkSpec workSpec) {
        return workSpec.constraints.getRequiredNetworkType() == NetworkType.METERED;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean b(@NonNull NetworkState networkState) {
        NetworkState networkState2 = networkState;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 26) {
            Logger.get().debug(e, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
            return !networkState2.isConnected();
        }
        if (networkState2.isConnected() && networkState2.isMetered()) {
            z = false;
        }
        return z;
    }
}
