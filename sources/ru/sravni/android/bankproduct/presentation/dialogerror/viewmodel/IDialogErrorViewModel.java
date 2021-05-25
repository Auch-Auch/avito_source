package ru.sravni.android.bankproduct.presentation.dialogerror.viewmodel;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lru/sravni/android/bankproduct/presentation/dialogerror/viewmodel/IDialogErrorViewModel;", "", "", "clickButtonOk", "()V", "Landroidx/lifecycle/LiveData;", "", "getDialogErrorIntent", "()Landroidx/lifecycle/LiveData;", "dialogErrorIntent", "", "getErrorMessage", "errorMessage", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IDialogErrorViewModel {
    void clickButtonOk();

    @NotNull
    LiveData<Integer> getDialogErrorIntent();

    @NotNull
    LiveData<String> getErrorMessage();
}
