package com.avito.android.certificate_pinning;

import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\bJ\u0019\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenter;", "", "Lcom/avito/android/certificate_pinning/UnsafeNetworkView;", "view", "", "attachView", "(Lcom/avito/android/certificate_pinning/UnsafeNetworkView;)V", "detachView", "()V", "Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onBackPressed", "", "autoCheck", "checkNetwork", "(Z)V", "Router", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
public interface UnsafeNetworkPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void checkNetwork$default(UnsafeNetworkPresenter unsafeNetworkPresenter, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                unsafeNetworkPresenter.checkNetwork(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkNetwork");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenter$Router;", "", "", "url", "", "openBrowser", "(Ljava/lang/String;)V", "closeScreen", "()V", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void closeScreen();

        void openBrowser(@NotNull String str);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull UnsafeNetworkView unsafeNetworkView);

    void checkNetwork(boolean z);

    void detachRouter();

    void detachView();

    void onBackPressed();

    @NotNull
    Kundle onSaveState();
}
