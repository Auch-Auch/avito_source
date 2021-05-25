package com.avito.android.remote.interceptor;

import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import dagger.Reusable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Reusable
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/interceptor/SchemaCheckHeaderProvider;", "Lcom/avito/android/remote/interceptor/HeaderProvider;", "", AuthSource.BOOKING_ORDER, "Z", "isMandatory", "()Z", "Lcom/avito/android/util/BuildInfo;", "d", "Lcom/avito/android/util/BuildInfo;", "build", "", "getValue", "()Ljava/lang/String;", "value", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getKey", "key", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;Lcom/avito/android/util/BuildInfo;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public class SchemaCheckHeaderProvider implements HeaderProvider {
    @NotNull
    public final String a = "Schema-Check";
    public final boolean b = true;
    public final Features c;
    public final BuildInfo d;

    @Inject
    public SchemaCheckHeaderProvider(@NotNull Features features, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(buildInfo, "build");
        this.c = features;
        this.d = buildInfo;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @NotNull
    public String getKey() {
        return this.a;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @NotNull
    public String getValue() {
        return (!this.d.isDebug() || !this.c.getSchemaCheckEnabled().invoke().booleanValue()) ? "0" : "1";
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    public boolean isMandatory() {
        return this.b;
    }
}
