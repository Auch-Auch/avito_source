package ru.sravni.android.bankproduct.presentation.webview.viewmodel;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.navigation.entity.WebViewNavInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/presentation/webview/viewmodel/IWebViewViewModel;", "", "", "onBack", "()Z", "isWaiting", "", "setWaiting", "(Z)V", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "Lru/sravni/android/bankproduct/utils/navigation/entity/WebViewNavInfo;", "getWebViewDataInfo", "()Lru/sravni/android/bankproduct/utils/navigation/entity/WebViewNavInfo;", "webViewDataInfo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IWebViewViewModel {
    @NotNull
    WebViewNavInfo getWebViewDataInfo();

    @NotNull
    LiveData<Boolean> isWaiting();

    boolean onBack();

    void setWaiting(boolean z);
}
