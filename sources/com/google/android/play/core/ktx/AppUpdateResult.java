package com.google.android.play.core.ktx;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.install.InstallState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult;", "", "<init>", "()V", "Available", "Downloaded", "InProgress", "NotAvailable", "Lcom/google/android/play/core/ktx/AppUpdateResult$NotAvailable;", "Lcom/google/android/play/core/ktx/AppUpdateResult$Available;", "Lcom/google/android/play/core/ktx/AppUpdateResult$InProgress;", "Lcom/google/android/play/core/ktx/AppUpdateResult$Downloaded;", "tmp.9f4bIqL_release"}, k = 1, mv = {1, 4, 0})
public abstract class AppUpdateResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult$Downloaded;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "", "completeUpdate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", AuthSource.SEND_ABUSE, "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "appUpdateManager", "<init>", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;)V", "tmp.9f4bIqL_release"}, k = 1, mv = {1, 4, 0})
    public static final class Downloaded extends AppUpdateResult {
        public final AppUpdateManager a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Downloaded(@NotNull AppUpdateManager appUpdateManager) {
            super(null);
            Intrinsics.checkParameterIsNotNull(appUpdateManager, "appUpdateManager");
            this.a = appUpdateManager;
        }

        @Nullable
        public final Object completeUpdate(@NotNull Continuation<? super Unit> continuation) {
            return AppUpdateManagerKtxKt.requestCompleteUpdate(this.a, continuation);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult$InProgress;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "Lcom/google/android/play/core/install/InstallState;", AuthSource.SEND_ABUSE, "Lcom/google/android/play/core/install/InstallState;", "getInstallState", "()Lcom/google/android/play/core/install/InstallState;", "installState", "<init>", "(Lcom/google/android/play/core/install/InstallState;)V", "tmp.9f4bIqL_release"}, k = 1, mv = {1, 4, 0})
    public static final class InProgress extends AppUpdateResult {
        @NotNull
        public final InstallState a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InProgress(@NotNull InstallState installState) {
            super(null);
            Intrinsics.checkParameterIsNotNull(installState, "installState");
            this.a = installState;
        }

        @NotNull
        public final InstallState getInstallState() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult$NotAvailable;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "<init>", "()V", "tmp.9f4bIqL_release"}, k = 1, mv = {1, 4, 0})
    public static final class NotAvailable extends AppUpdateResult {
        public static final NotAvailable INSTANCE = new NotAvailable();

        public NotAvailable() {
            super(null);
        }
    }

    public AppUpdateResult() {
    }

    public AppUpdateResult(j jVar) {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u000bJ\u001d\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\bJ\u001d\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult$Available;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "Landroid/app/Activity;", "activity", "", "requestCode", "", "startFlexibleUpdate", "(Landroid/app/Activity;I)Z", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;I)Z", "startImmediateUpdate", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", AuthSource.BOOKING_ORDER, "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "getUpdateInfo", "()Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "updateInfo", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", AuthSource.SEND_ABUSE, "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "appUpdateManager", "<init>", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;Lcom/google/android/play/core/appupdate/AppUpdateInfo;)V", "tmp.9f4bIqL_release"}, k = 1, mv = {1, 4, 0})
    public static final class Available extends AppUpdateResult {
        public final AppUpdateManager a;
        @NotNull
        public final AppUpdateInfo b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Available(@NotNull AppUpdateManager appUpdateManager, @NotNull AppUpdateInfo appUpdateInfo) {
            super(null);
            Intrinsics.checkParameterIsNotNull(appUpdateManager, "appUpdateManager");
            Intrinsics.checkParameterIsNotNull(appUpdateInfo, "updateInfo");
            this.a = appUpdateManager;
            this.b = appUpdateInfo;
        }

        @NotNull
        public final AppUpdateInfo getUpdateInfo() {
            return this.b;
        }

        public final boolean startFlexibleUpdate(@NotNull Activity activity, int i) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            return this.a.startUpdateFlowForResult(this.b, 0, activity, i);
        }

        public final boolean startImmediateUpdate(@NotNull Activity activity, int i) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            return this.a.startUpdateFlowForResult(this.b, 1, activity, i);
        }

        public final boolean startFlexibleUpdate(@NotNull Fragment fragment, int i) {
            Intrinsics.checkParameterIsNotNull(fragment, "fragment");
            return AppUpdateManagerKtxKt.startUpdateFlowForResult(this.a, this.b, 0, fragment, i);
        }

        public final boolean startImmediateUpdate(@NotNull Fragment fragment, int i) {
            Intrinsics.checkParameterIsNotNull(fragment, "fragment");
            return AppUpdateManagerKtxKt.startUpdateFlowForResult(this.a, this.b, 1, fragment, i);
        }
    }
}
