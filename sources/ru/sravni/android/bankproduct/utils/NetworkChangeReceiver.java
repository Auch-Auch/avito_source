package ru.sravni.android.bankproduct.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.snackbar.ITopSnackbarShower;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/utils/NetworkChangeReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lru/sravni/android/bankproduct/utils/snackbar/ITopSnackbarShower;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/utils/snackbar/ITopSnackbarShower;", "topSnackbarShower", "<init>", "(Lru/sravni/android/bankproduct/utils/snackbar/ITopSnackbarShower;)V", "Companion", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class NetworkChangeReceiver extends BroadcastReceiver {
    @NotNull
    public static final String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final Companion Companion = new Companion(null);
    public final ITopSnackbarShower a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lru/sravni/android/bankproduct/utils/NetworkChangeReceiver$Companion;", "", "", "CONNECTIVITY_ACTION", "Ljava/lang/String;", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public NetworkChangeReceiver(@NotNull ITopSnackbarShower iTopSnackbarShower) {
        Intrinsics.checkParameterIsNotNull(iTopSnackbarShower, "topSnackbarShower");
        this.a = iTopSnackbarShower;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                this.a.removeTopSnackbar();
            } else {
                this.a.showTopSnackbar(-2, "Проверьте соединение с интернетом");
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
    }
}
