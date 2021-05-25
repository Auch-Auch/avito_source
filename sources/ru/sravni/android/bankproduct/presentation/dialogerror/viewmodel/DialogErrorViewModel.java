package ru.sravni.android.bankproduct.presentation.dialogerror.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0014"}, d2 = {"Lru/sravni/android/bankproduct/presentation/dialogerror/viewmodel/DialogErrorViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/dialogerror/viewmodel/IDialogErrorViewModel;", "", "clickButtonOk", "()V", "Landroidx/lifecycle/MutableLiveData;", "", "d", "Landroidx/lifecycle/MutableLiveData;", "getDialogErrorIntent", "()Landroidx/lifecycle/MutableLiveData;", "dialogErrorIntent", "", "c", "getErrorMessage", "errorMessage", "message", "<init>", "(Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DialogErrorViewModel extends ViewModel implements IDialogErrorViewModel {
    @NotNull
    public final MutableLiveData<String> c;
    @NotNull
    public final MutableLiveData<Integer> d = new MutableLiveData<>();

    public DialogErrorViewModel(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(str);
        this.c = mutableLiveData;
    }

    @Override // ru.sravni.android.bankproduct.presentation.dialogerror.viewmodel.IDialogErrorViewModel
    public void clickButtonOk() {
        getDialogErrorIntent().setValue(Integer.valueOf(R.id.ok_click_dialog));
    }

    @Override // ru.sravni.android.bankproduct.presentation.dialogerror.viewmodel.IDialogErrorViewModel
    @NotNull
    public MutableLiveData<Integer> getDialogErrorIntent() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.presentation.dialogerror.viewmodel.IDialogErrorViewModel
    @NotNull
    public MutableLiveData<String> getErrorMessage() {
        return this.c;
    }
}
