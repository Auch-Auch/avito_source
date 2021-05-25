package ru.sravni.android.bankproduct.presentation.webview.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.entity.WebViewNavInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0004\u0010\rR\u001c\u0010\u0013\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lru/sravni/android/bankproduct/presentation/webview/viewmodel/WebViewViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/webview/viewmodel/IWebViewViewModel;", "", "isWaiting", "", "setWaiting", "(Z)V", "onBack", "()Z", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "Lru/sravni/android/bankproduct/utils/navigation/entity/WebViewNavInfo;", "d", "Lru/sravni/android/bankproduct/utils/navigation/entity/WebViewNavInfo;", "getWebViewDataInfo", "()Lru/sravni/android/bankproduct/utils/navigation/entity/WebViewNavInfo;", "webViewDataInfo", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "e", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "<init>", "(Lru/sravni/android/bankproduct/utils/navigation/entity/WebViewNavInfo;Lru/sravni/android/bankproduct/utils/navigation/INavigator;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class WebViewViewModel extends ViewModel implements IWebViewViewModel {
    @NotNull
    public final MutableLiveData<Boolean> c = new MutableLiveData<>();
    @NotNull
    public final WebViewNavInfo d;
    public final INavigator e;

    public WebViewViewModel(@NotNull WebViewNavInfo webViewNavInfo, @NotNull INavigator iNavigator) {
        Intrinsics.checkParameterIsNotNull(webViewNavInfo, "webViewDataInfo");
        Intrinsics.checkParameterIsNotNull(iNavigator, "navigator");
        this.d = webViewNavInfo;
        this.e = iNavigator;
    }

    @Override // ru.sravni.android.bankproduct.presentation.webview.viewmodel.IWebViewViewModel
    @NotNull
    public WebViewNavInfo getWebViewDataInfo() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.presentation.webview.viewmodel.IWebViewViewModel
    public boolean onBack() {
        if (getWebViewDataInfo().getBackFragmentId() == null) {
            return false;
        }
        this.e.popBackStack(getWebViewDataInfo().getBackFragmentId().intValue(), false);
        return true;
    }

    @Override // ru.sravni.android.bankproduct.presentation.webview.viewmodel.IWebViewViewModel
    public void setWaiting(boolean z) {
        isWaiting().setValue(Boolean.valueOf(z));
    }

    @Override // ru.sravni.android.bankproduct.presentation.webview.viewmodel.IWebViewViewModel
    @NotNull
    public MutableLiveData<Boolean> isWaiting() {
        return this.c;
    }
}
