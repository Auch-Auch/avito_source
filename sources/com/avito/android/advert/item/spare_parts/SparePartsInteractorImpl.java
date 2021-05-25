package com.avito.android.advert.item.spare_parts;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SparePartsParameters;
import com.avito.android.remote.models.SparePartsResponse;
import com.avito.android.spare_parts.remote.SparePartsApi;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert/item/spare_parts/SparePartsInteractorImpl;", "Lcom/avito/android/advert/item/spare_parts/SparePartsInteractor;", "Lcom/avito/android/advert/item/spare_parts/SparePartsItemType;", "type", "Lcom/avito/android/remote/model/SparePartsParameters;", "params", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/models/SparePartsResponse;", "loadSpareParts", "(Lcom/avito/android/advert/item/spare_parts/SparePartsItemType;Lcom/avito/android/remote/model/SparePartsParameters;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/spare_parts/remote/SparePartsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/spare_parts/remote/SparePartsApi;", "api", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "converter", "<init>", "(Lcom/avito/android/spare_parts/remote/SparePartsApi;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SparePartsInteractorImpl implements SparePartsInteractor {
    public final SparePartsApi a;
    public final TypedErrorThrowableConverter b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SparePartsItemType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public static final class a<T, R> implements Function<SparePartsResponse, LoadingState<? super SparePartsResponse>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SparePartsResponse> apply(SparePartsResponse sparePartsResponse) {
            return new LoadingState.Loaded(sparePartsResponse);
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super SparePartsResponse>> {
        public final /* synthetic */ SparePartsInteractorImpl a;

        public b(SparePartsInteractorImpl sparePartsInteractorImpl) {
            this.a = sparePartsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SparePartsResponse> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.b;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public SparePartsInteractorImpl(@NotNull SparePartsApi sparePartsApi, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(sparePartsApi, "api");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "converter");
        this.a = sparePartsApi;
        this.b = typedErrorThrowableConverter;
    }

    @Override // com.avito.android.advert.item.spare_parts.SparePartsInteractor
    @NotNull
    public Observable<LoadingState<SparePartsResponse>> loadSpareParts(@NotNull SparePartsItemType sparePartsItemType, @NotNull SparePartsParameters sparePartsParameters) {
        Observable<SparePartsResponse> observable;
        Intrinsics.checkNotNullParameter(sparePartsItemType, "type");
        Intrinsics.checkNotNullParameter(sparePartsParameters, "params");
        int ordinal = sparePartsItemType.ordinal();
        if (ordinal == 0) {
            observable = this.a.getReplacements(sparePartsParameters.getMicrocategoryId(), sparePartsParameters.getVendorId(), sparePartsParameters.getPartNumber());
        } else if (ordinal == 1) {
            observable = this.a.getCompatibilities(sparePartsParameters.getMicrocategoryId(), sparePartsParameters.getVendorId(), sparePartsParameters.getPartNumber());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Observable<LoadingState<SparePartsResponse>> startWithItem = observable.map(a.a).onErrorReturn(new b(this)).startWithItem(LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWithItem, "loadingObservable\n      …tem(LoadingState.Loading)");
        return startWithItem;
    }
}
