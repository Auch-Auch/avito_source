package com.avito.android.payment.top_up.form;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.payment.top_up.TopUpForm;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/payment/top_up/form/TopUpFormInteractor;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/payment/top_up/TopUpForm;", "getTopUpForm", "()Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/remote/model/PretendResult;", "validateUserInput", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lio/reactivex/Observable;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface TopUpFormInteractor {
    @NotNull
    Observable<LoadingState<TopUpForm>> getTopUpForm();

    @Override // com.avito.android.payment.caching_interactor.CachingInteractor
    @NotNull
    Kundle onSaveState();

    @NotNull
    Observable<PretendResult> validateUserInput(@NotNull ParametersTree parametersTree);
}
