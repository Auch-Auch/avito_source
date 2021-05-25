package com.avito.android.notification_center.landing.recommends;

import android.os.Bundle;
import com.avito.android.util.FragmentsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "id", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsFragment;", "createNotificationCenterLandingRecommendsFragment", "(Ljava/lang/String;)Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsFragment;", "notification-center_release"}, k = 2, mv = {1, 4, 2})
public final class NotificationCenterLandingRecommendsFragmentKt {

    public static final class a extends Lambda implements Function1<Bundle, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bundle bundle) {
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle2, "$receiver");
            bundle2.putString("key_id", this.a);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final NotificationCenterLandingRecommendsFragment createNotificationCenterLandingRecommendsFragment(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return (NotificationCenterLandingRecommendsFragment) FragmentsKt.arguments$default(new NotificationCenterLandingRecommendsFragment(), 0, new a(str), 1, null);
    }
}
