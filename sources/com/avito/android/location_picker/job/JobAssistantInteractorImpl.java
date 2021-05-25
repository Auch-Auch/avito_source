package com.avito.android.location_picker.job;

import com.avito.android.location_picker.entities.SendLocationResponse;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.facebook.appevents.integrity.IntegrityManager;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J5\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/location_picker/job/JobAssistantInteractorImpl;", "Lcom/avito/android/location_picker/job/JobAssistantInteractor;", "", "channelId", "", "lat", "lng", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/location_picker/entities/SendLocationResponse;", "sendLocation", "(Ljava/lang/String;DDLjava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/LocationApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/LocationApi;", "getLocationApi", "()Lcom/avito/android/remote/LocationApi;", "locationApi", "<init>", "(Lcom/avito/android/remote/LocationApi;)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class JobAssistantInteractorImpl implements JobAssistantInteractor {
    @NotNull
    public final LocationApi a;

    public static final class a<T, R> implements Function<TypedResult<Unit>, SendLocationResponse> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SendLocationResponse apply(TypedResult<Unit> typedResult) {
            TypedResult<Unit> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                return SendLocationResponse.Success.INSTANCE;
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new SendLocationResponse.Error(((TypedResult.OfError) typedResult2).getError().getMessage());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, SendLocationResponse> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SendLocationResponse apply(Throwable th) {
            return new SendLocationResponse.Error(null, 1, null);
        }
    }

    @Inject
    public JobAssistantInteractorImpl(@NotNull LocationApi locationApi) {
        Intrinsics.checkNotNullParameter(locationApi, "locationApi");
        this.a = locationApi;
    }

    @NotNull
    public final LocationApi getLocationApi() {
        return this.a;
    }

    @Override // com.avito.android.location_picker.job.JobAssistantInteractor
    @NotNull
    public Single<SendLocationResponse> sendLocation(@NotNull String str, double d, double d2, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        Single<R> onErrorReturn = this.a.sendLocation(str, d, d2, str2).firstOrError().map(a.a).onErrorReturn(b.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "locationApi.sendLocation…nse.Error()\n            }");
        return onErrorReturn;
    }
}
