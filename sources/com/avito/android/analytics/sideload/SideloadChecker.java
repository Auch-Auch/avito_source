package com.avito.android.analytics.sideload;

import android.app.Application;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.play.core.missingsplits.MissingSplitsManager;
import com.google.android.play.core.missingsplits.MissingSplitsManagerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u0003\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/analytics/sideload/SideloadChecker;", "", "", "isSideload", "()Z", AuthSource.SEND_ABUSE, "Ljava/lang/Boolean;", "cacheValue", "Landroid/app/Application;", AuthSource.BOOKING_ORDER, "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "<init>", "(Landroid/app/Application;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class SideloadChecker {
    public Boolean a;
    public final Application b;

    public SideloadChecker(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        this.b = application;
    }

    public final boolean isSideload() {
        Boolean bool = this.a;
        if (bool == null) {
            MissingSplitsManager create = MissingSplitsManagerFactory.create(this.b);
            Intrinsics.checkNotNullExpressionValue(create, "MissingSplitsManagerFactory.create(application)");
            Boolean valueOf = Boolean.valueOf(create.isMissingRequiredSplits());
            this.a = valueOf;
            Intrinsics.checkNotNull(valueOf);
            return valueOf.booleanValue();
        }
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }
}
