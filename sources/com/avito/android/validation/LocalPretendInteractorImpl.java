package com.avito.android.validation;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.validation.ValidationResult;
import io.reactivex.rxjava3.core.Observable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/validation/LocalPretendInteractorImpl;", "Lcom/avito/android/validation/LocalPretendInteractor;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/PretendResult;", "pretend", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/validation/ParametersValidator;", AuthSource.SEND_ABUSE, "Lcom/avito/android/validation/ParametersValidator;", "validator", "<init>", "(Lcom/avito/android/validation/ParametersValidator;)V", "validation_release"}, k = 1, mv = {1, 4, 2})
public final class LocalPretendInteractorImpl implements LocalPretendInteractor {
    public final ParametersValidator a;

    public static final class a<V> implements Callable<PretendResult> {
        public final /* synthetic */ LocalPretendInteractorImpl a;
        public final /* synthetic */ ParametersTree b;

        public a(LocalPretendInteractorImpl localPretendInteractorImpl, ParametersTree parametersTree) {
            this.a = localPretendInteractorImpl;
            this.b = parametersTree;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public PretendResult call() {
            return LocalPretendInteractorImpl.access$doPretend(this.a, this.b);
        }
    }

    public LocalPretendInteractorImpl(@NotNull ParametersValidator parametersValidator) {
        Intrinsics.checkNotNullParameter(parametersValidator, "validator");
        this.a = parametersValidator;
    }

    public static final PretendResult access$doPretend(LocalPretendInteractorImpl localPretendInteractorImpl, ParametersTree parametersTree) {
        Objects.requireNonNull(localPretendInteractorImpl);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = parametersTree.iterator();
        boolean z = true;
        while (it.hasNext()) {
            ParameterSlot parameterSlot = (ParameterSlot) it.next();
            if (parameterSlot instanceof EditableParameter) {
                ValidationResult validate = localPretendInteractorImpl.a.validate((EditableParameter) parameterSlot, parametersTree);
                if (validate instanceof ValidationResult.Failure.Error) {
                    z = false;
                    linkedHashMap.put(validate.getId(), new PretendErrorValue.Message(((ValidationResult.Failure.Error) validate).getText()));
                }
            }
        }
        return new PretendResult(z, linkedHashMap);
    }

    @Override // com.avito.android.validation.LocalPretendInteractor
    @NotNull
    public Observable<PretendResult> pretend(@NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(parametersTree, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        Observable<PretendResult> fromCallable = Observable.fromCallable(new a(this, parametersTree));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable …end(parameters)\n        }");
        return fromCallable;
    }
}
