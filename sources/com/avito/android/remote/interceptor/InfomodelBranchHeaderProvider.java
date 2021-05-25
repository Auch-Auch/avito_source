package com.avito.android.remote.interceptor;

import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import dagger.Reusable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Reusable
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/interceptor/InfomodelBranchHeaderProvider;", "Lcom/avito/android/remote/interceptor/HeaderProvider;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "", "c", "Z", "isMandatory", "()Z", AuthSource.BOOKING_ORDER, "getValue", "value", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/BuildInfo;", "build", "<init>", "(Lcom/avito/android/Features;Lcom/avito/android/util/BuildInfo;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public class InfomodelBranchHeaderProvider implements HeaderProvider {
    @NotNull
    public final String a = "X-Infm-Version";
    @Nullable
    public final String b;
    public final boolean c;

    @Inject
    public InfomodelBranchHeaderProvider(@NotNull Features features, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(buildInfo, "build");
        String value = features.getInfomodelBranch().getValue();
        this.b = !((m.isBlank(value) ^ true) && buildInfo.isDebug()) ? null : value;
        this.c = true;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @NotNull
    public String getKey() {
        return this.a;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @Nullable
    public String getValue() {
        return this.b;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    public boolean isMandatory() {
        return this.c;
    }
}
