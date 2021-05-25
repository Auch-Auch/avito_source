package com.avito.android.location_picker.providers;

import com.avito.android.remote.LocationApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.location_picker.AddressValidationResult;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/location_picker/providers/AddressValidationProviderImpl;", "Lcom/avito/android/location_picker/providers/AddressValidationProvider;", "", AddressParameter.Value.JSON_WEB_TOKEN, "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "validationRules", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/location_picker/AddressValidationResult;", "validateAddress", "(Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/LocationApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/LocationApi;", "getApi", "()Lcom/avito/android/remote/LocationApi;", "api", "<init>", "(Lcom/avito/android/remote/LocationApi;)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class AddressValidationProviderImpl implements AddressValidationProvider {
    @NotNull
    public final LocationApi a;

    public static final class a<T, R> implements Function<TypedResult<AddressValidationResult.Ok>, AddressValidationResult> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public AddressValidationResult apply(TypedResult<AddressValidationResult.Ok> typedResult) {
            TypedResult<AddressValidationResult.Ok> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                return (AddressValidationResult) ((TypedResult.OfResult) typedResult2).getResult();
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                TypedResult.OfError ofError = (TypedResult.OfError) typedResult2;
                if (ofError.getError() instanceof ErrorResult.NetworkIOError) {
                    return AddressValidationResult.NetworkError.INSTANCE;
                }
                return new AddressValidationResult.Error(ofError.getError().getMessage());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, AddressValidationResult> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public AddressValidationResult apply(Throwable th) {
            return AddressValidationResult.NetworkError.INSTANCE;
        }
    }

    @Inject
    public AddressValidationProviderImpl(@NotNull LocationApi locationApi) {
        Intrinsics.checkNotNullParameter(locationApi, "api");
        this.a = locationApi;
    }

    @NotNull
    public final LocationApi getApi() {
        return this.a;
    }

    @Override // com.avito.android.location_picker.providers.AddressValidationProvider
    @NotNull
    public Single<AddressValidationResult> validateAddress(@NotNull String str, @NotNull AddressParameter.ValidationRules validationRules) {
        Intrinsics.checkNotNullParameter(str, AddressParameter.Value.JSON_WEB_TOKEN);
        Intrinsics.checkNotNullParameter(validationRules, "validationRules");
        Single<R> onErrorReturn = this.a.validateAddress(str, validationRules.convertToFieldMap()).firstOrError().map(a.a).onErrorReturn(b.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.validateAddress(jwt,…etworkError\n            }");
        return onErrorReturn;
    }
}
