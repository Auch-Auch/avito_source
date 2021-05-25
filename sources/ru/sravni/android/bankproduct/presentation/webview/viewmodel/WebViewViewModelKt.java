package ru.sravni.android.bankproduct.presentation.webview.viewmodel;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.navigation.entity.WebViewNavInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0019\u0010\u0005\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lru/sravni/android/bankproduct/utils/navigation/entity/WebViewNavInfo;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/utils/navigation/entity/WebViewNavInfo;", "getWebViewNavInfoError", "()Lru/sravni/android/bankproduct/utils/navigation/entity/WebViewNavInfo;", "webViewNavInfoError", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class WebViewViewModelKt {
    @NotNull
    public static final WebViewNavInfo a = new WebViewNavInfo("", "", null, 4, null);

    @NotNull
    public static final WebViewNavInfo getWebViewNavInfoError() {
        return a;
    }
}
