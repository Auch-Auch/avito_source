package ru.sravni.android.bankproduct.presentation.main.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010¨\u0006\u001b"}, d2 = {"Lru/sravni/android/bankproduct/presentation/main/viewmodel/ErrorViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/main/viewmodel/IErrorViewModel;", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "error", "", "handleError", "(Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;)V", "", "message", "showDialog", "(Ljava/lang/String;)V", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "getShowSnackBarError", "()Landroidx/lifecycle/MutableLiveData;", "showSnackBarError", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "e", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "c", "getShowDialogError", "showDialogError", "<init>", "(Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ErrorViewModel extends ViewModel implements IErrorViewModel {
    @NotNull
    public final MutableLiveData<String> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<SravniError> d = new MutableLiveData<>();
    public final IErrorLogger e;

    public ErrorViewModel(@NotNull IErrorLogger iErrorLogger) {
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        this.e = iErrorLogger;
    }

    @Override // ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandler
    public void handleError(@NotNull SravniError sravniError) {
        Intrinsics.checkParameterIsNotNull(sravniError, "error");
        if (sravniError.getError() instanceof SocketTimeoutException) {
            showDialog(sravniError.getErrDescription().getDescription());
            return;
        }
        this.e.logError(MessagePriority.ERROR, sravniError);
        getShowSnackBarError().postValue(sravniError);
    }

    @Override // ru.sravni.android.bankproduct.domain.IDialogShower
    public void showDialog(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        getShowDialogError().postValue(str);
    }

    @Override // ru.sravni.android.bankproduct.presentation.main.viewmodel.IErrorViewModel
    @NotNull
    public MutableLiveData<String> getShowDialogError() {
        return this.c;
    }

    @Override // ru.sravni.android.bankproduct.presentation.main.viewmodel.IErrorViewModel
    @NotNull
    public MutableLiveData<SravniError> getShowSnackBarError() {
        return this.d;
    }
}
