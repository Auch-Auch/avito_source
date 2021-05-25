package com.avito.android.certificate_pinning;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0003H&¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0003H&¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0003H&¢\u0006\u0004\b\r\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/certificate_pinning/UnsafeNetworkView;", "", "Lio/reactivex/Observable;", "", "checkAgainButtonClicks", "()Lio/reactivex/Observable;", "authenticateButtonClicks", "showLoading", "()V", "showUnsafeNetwork", "showStillUnsafeNetworkError", "showUnknownSafetyCheckingError", "showNetworkError", "showAuthorizationRequired", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
public interface UnsafeNetworkView {
    @NotNull
    Observable<Unit> authenticateButtonClicks();

    @NotNull
    Observable<Unit> checkAgainButtonClicks();

    void showAuthorizationRequired();

    void showLoading();

    void showNetworkError();

    void showStillUnsafeNetworkError();

    void showUnknownSafetyCheckingError();

    void showUnsafeNetwork();
}
