package com.avito.android.remote.error;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Error;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR4\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/error/LocationsNotFoundErrorCase;", "Lcom/avito/android/remote/error/SpecialCase;", "", "", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/Error;", "Lcom/avito/android/remote/error/TypedError;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getSpecialCases", "()Ljava/util/Map;", "specialCases", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class LocationsNotFoundErrorCase implements SpecialCase {
    @NotNull
    public final Map<Integer, Function1<Error, TypedError>> a = q.mapOf(TuplesKt.to(404, a.a));

    public static final class a extends Lambda implements Function1<Error, LocationsNotFoundError> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public LocationsNotFoundError invoke(Error error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new LocationsNotFoundError();
        }
    }

    @Override // com.avito.android.remote.error.SpecialCase
    @NotNull
    public Map<Integer, Function1<Error, TypedError>> getSpecialCases() {
        return this.a;
    }
}
