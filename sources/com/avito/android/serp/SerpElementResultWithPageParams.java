package com.avito.android.serp;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpElementResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/serp/SerpElementResultWithPageParams;", "", "Lcom/avito/android/remote/model/SerpElementResult;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/SerpElementResult;", "getSerpElementResult", "()Lcom/avito/android/remote/model/SerpElementResult;", "serpElementResult", "Lcom/avito/android/serp/SerpPageParams;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/SerpPageParams;", "getSerpPageParams", "()Lcom/avito/android/serp/SerpPageParams;", "serpPageParams", "<init>", "(Lcom/avito/android/remote/model/SerpElementResult;Lcom/avito/android/serp/SerpPageParams;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpElementResultWithPageParams {
    @NotNull
    public final SerpElementResult a;
    @NotNull
    public final SerpPageParams b;

    public SerpElementResultWithPageParams(@NotNull SerpElementResult serpElementResult, @NotNull SerpPageParams serpPageParams) {
        Intrinsics.checkNotNullParameter(serpElementResult, "serpElementResult");
        Intrinsics.checkNotNullParameter(serpPageParams, "serpPageParams");
        this.a = serpElementResult;
        this.b = serpPageParams;
    }

    @NotNull
    public final SerpElementResult getSerpElementResult() {
        return this.a;
    }

    @NotNull
    public final SerpPageParams getSerpPageParams() {
        return this.b;
    }
}
