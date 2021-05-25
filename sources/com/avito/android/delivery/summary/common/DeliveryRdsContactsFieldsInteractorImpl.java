package com.avito.android.delivery.summary.common;

import a2.a.a.k0.e.i0.b;
import a2.a.a.k0.e.i0.c;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.util.LoadingState;
import com.avito.android.validation.LocalPretendInteractor;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractorImpl;", "Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractor;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "fields", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "", "", "validateFields", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorConverter", "Lcom/avito/android/validation/LocalPretendInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/validation/LocalPretendInteractor;", "localPretendInteractor", "<init>", "(Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/validation/LocalPretendInteractor;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsContactsFieldsInteractorImpl implements DeliveryRdsContactsFieldsInteractor {
    public final TypedErrorThrowableConverter a;
    public final LocalPretendInteractor b;

    public static final class a<T, R> implements Function<Throwable, LoadingState<? super Map<String, ? extends String>>> {
        public final /* synthetic */ DeliveryRdsContactsFieldsInteractorImpl a;

        public a(DeliveryRdsContactsFieldsInteractorImpl deliveryRdsContactsFieldsInteractorImpl) {
            this.a = deliveryRdsContactsFieldsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super Map<String, ? extends String>> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public DeliveryRdsContactsFieldsInteractorImpl(@NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull LocalPretendInteractor localPretendInteractor) {
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "errorConverter");
        Intrinsics.checkNotNullParameter(localPretendInteractor, "localPretendInteractor");
        this.a = typedErrorThrowableConverter;
        this.b = localPretendInteractor;
    }

    @Override // com.avito.android.delivery.summary.common.DeliveryRdsContactsFieldsInteractor
    @NotNull
    public Observable<LoadingState<Map<String, String>>> validateFields(@NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(parametersTree, "fields");
        Observable map = Observable.just(parametersTree).flatMap(new a2.a.a.k0.e.i0.a(this)).map(b.a).map(c.a);
        Intrinsics.checkNotNullExpressionValue(map, "Observable.just(fields)\n…tate.Loaded(it.toMap()) }");
        Observable<LoadingState<Map<String, String>>> onErrorReturn = map.onErrorReturn(new a(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "localFieldsValidate(fiel…rConverter.convert(it)) }");
        return onErrorReturn;
    }
}
