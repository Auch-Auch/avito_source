package ru.sravni.android.bankproduct.presentation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lru/sravni/android/bankproduct/presentation/RequestPermissionViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/IRequestPermissionViewModel;", "", "fragmentStartAction", "()V", "Landroidx/lifecycle/MutableLiveData;", "", "c", "Landroidx/lifecycle/MutableLiveData;", "getAskPermission", "()Landroidx/lifecycle/MutableLiveData;", "askPermission", "d", "Z", "permissionAsked", "<init>", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class RequestPermissionViewModel extends ViewModel implements IRequestPermissionViewModel {
    @NotNull
    public final MutableLiveData<Boolean> c = new MutableLiveData<>();
    public boolean d;

    @Override // ru.sravni.android.bankproduct.presentation.IRequestPermissionViewModel
    public void fragmentStartAction() {
        if (!this.d) {
            this.d = true;
            getAskPermission().setValue(Boolean.TRUE);
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.IRequestPermissionViewModel
    @NotNull
    public MutableLiveData<Boolean> getAskPermission() {
        return this.c;
    }
}
