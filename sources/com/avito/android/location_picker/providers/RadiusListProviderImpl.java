package com.avito.android.location_picker.providers;

import com.avito.android.remote.SearchRadiusApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.location_picker.RadiusListResult;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/location_picker/providers/RadiusListProviderImpl;", "Lcom/avito/android/location_picker/providers/RadiusListProvider;", "", "radiusId", "categoryId", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/location_picker/RadiusListResult;", "getRadiusList", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/SearchRadiusApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/SearchRadiusApi;", "getApi", "()Lcom/avito/android/remote/SearchRadiusApi;", "api", "<init>", "(Lcom/avito/android/remote/SearchRadiusApi;)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class RadiusListProviderImpl implements RadiusListProvider {
    @NotNull
    public final SearchRadiusApi a;

    public static final class a<T, R> implements Function<TypedResult<RadiusListResult.Ok>, RadiusListResult> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public RadiusListResult apply(TypedResult<RadiusListResult.Ok> typedResult) {
            TypedResult<RadiusListResult.Ok> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                return (RadiusListResult) ((TypedResult.OfResult) typedResult2).getResult();
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                TypedResult.OfError ofError = (TypedResult.OfError) typedResult2;
                if (ofError.getError() instanceof ErrorResult.NetworkIOError) {
                    return new RadiusListResult.NetworkError();
                }
                return new RadiusListResult.Error(ofError.getError().getMessage());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Inject
    public RadiusListProviderImpl(@NotNull SearchRadiusApi searchRadiusApi) {
        Intrinsics.checkNotNullParameter(searchRadiusApi, "api");
        this.a = searchRadiusApi;
    }

    @NotNull
    public final SearchRadiusApi getApi() {
        return this.a;
    }

    @Override // com.avito.android.location_picker.providers.RadiusListProvider
    @NotNull
    public Single<RadiusListResult> getRadiusList(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "radiusId");
        Intrinsics.checkNotNullParameter(str2, "categoryId");
        Single<R> map = this.a.getSearchRadiusList(str, str2).firstOrError().map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getSearchRadiusList(…         }\n\n            }");
        return map;
    }
}
