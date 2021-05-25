package com.avito.android.authorization.smart_lock;

import android.app.Activity;
import android.app.PendingIntent;
import androidx.fragment.app.Fragment;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.api.ResolvableApiException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u000bR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/authorization/smart_lock/ResolvableResult;", "", "Landroid/app/Activity;", "activity", "", "requestId", "", "resolve", "(Landroid/app/Activity;I)V", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;I)V", "Lkotlin/Function0;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "onSuccess", "Lcom/google/android/gms/common/api/ResolvableApiException;", AuthSource.SEND_ABUSE, "Lcom/google/android/gms/common/api/ResolvableApiException;", "resolvableApiException", "<init>", "(Lcom/google/android/gms/common/api/ResolvableApiException;Lkotlin/jvm/functions/Function0;)V", "smartlock_release"}, k = 1, mv = {1, 4, 2})
public final class ResolvableResult {
    public final ResolvableApiException a;
    public final Function0<Unit> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    public ResolvableResult(@NotNull ResolvableApiException resolvableApiException, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(resolvableApiException, "resolvableApiException");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        this.a = resolvableApiException;
        this.b = function0;
    }

    public final void resolve(@NotNull Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b.invoke();
        this.a.startResolutionForResult(activity, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResolvableResult(ResolvableApiException resolvableApiException, Function0 function0, int i, j jVar) {
        this(resolvableApiException, (i & 2) != 0 ? a.a : function0);
    }

    public final void resolve(@NotNull Fragment fragment, int i) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.b.invoke();
        PendingIntent resolution = this.a.getResolution();
        Intrinsics.checkNotNullExpressionValue(resolution, "resolvableApiException.resolution");
        fragment.startIntentSenderForResult(resolution.getIntentSender(), i, null, 0, 0, 0, null);
    }
}
