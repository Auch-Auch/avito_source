package ru.sravni.android.bankproduct.utils.snackbar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/utils/snackbar/SnackbarViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/utils/snackbar/ISnackBarViewModel;", "Lru/sravni/android/bankproduct/utils/snackbar/SnackbarData;", "snackbarData", "", "showBottomSnackbar", "(Lru/sravni/android/bankproduct/utils/snackbar/SnackbarData;)V", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "getSnackBarMessageLiveData", "()Landroidx/lifecycle/MutableLiveData;", "snackBarMessageLiveData", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SnackbarViewModel extends ViewModel implements ISnackBarViewModel {
    @NotNull
    public final MutableLiveData<SnackbarData> c = new MutableLiveData<>();

    @Override // ru.sravni.android.bankproduct.utils.snackbar.IBottomSnackbarShower
    public void showBottomSnackbar(@NotNull SnackbarData snackbarData) {
        Intrinsics.checkParameterIsNotNull(snackbarData, "snackbarData");
        getSnackBarMessageLiveData().setValue(snackbarData);
    }

    @Override // ru.sravni.android.bankproduct.utils.snackbar.ISnackBarViewModel
    @NotNull
    public MutableLiveData<SnackbarData> getSnackBarMessageLiveData() {
        return this.c;
    }
}
