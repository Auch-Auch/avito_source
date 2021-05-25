package com.avito.android.tariff.routing;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/tariff/routing/RoutingAction;", "", "<init>", "()V", "ActivityRoutingAction", "FragmentRoutingAction", "Lcom/avito/android/tariff/routing/RoutingAction$ActivityRoutingAction;", "Lcom/avito/android/tariff/routing/RoutingAction$FragmentRoutingAction;", "tariff_release"}, k = 1, mv = {1, 4, 2})
public abstract class RoutingAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/tariff/routing/RoutingAction$ActivityRoutingAction;", "Lcom/avito/android/tariff/routing/RoutingAction;", "", AuthSource.BOOKING_ORDER, "Z", "getShouldFinish", "()Z", "shouldFinish", "Landroid/content/Intent;", AuthSource.SEND_ABUSE, "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "intent", "<init>", "(Landroid/content/Intent;Z)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class ActivityRoutingAction extends RoutingAction {
        @Nullable
        public final Intent a;
        public final boolean b;

        public ActivityRoutingAction(@Nullable Intent intent, boolean z) {
            super(null);
            this.a = intent;
            this.b = z;
        }

        @Nullable
        public final Intent getIntent() {
            return this.a;
        }

        public final boolean getShouldFinish() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/tariff/routing/RoutingAction$FragmentRoutingAction;", "Lcom/avito/android/tariff/routing/RoutingAction;", "Landroidx/fragment/app/Fragment;", AuthSource.SEND_ABUSE, "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class FragmentRoutingAction extends RoutingAction {
        @NotNull
        public final Fragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FragmentRoutingAction(@NotNull Fragment fragment) {
            super(null);
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.a = fragment;
        }

        @NotNull
        public final Fragment getFragment() {
            return this.a;
        }
    }

    public RoutingAction() {
    }

    public RoutingAction(j jVar) {
    }
}
