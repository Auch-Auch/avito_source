package com.avito.android.blocked_ip;

import com.avito.android.blocked_ip.BlockedIpDialogPresenter;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0016\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/avito/android/blocked_ip/BlockedIpDialogPresenterImpl;", "Lcom/avito/android/blocked_ip/BlockedIpDialogPresenter;", "Lcom/avito/android/blocked_ip/BlockedIpDialogView;", "view", "", "attachView", "(Lcom/avito/android/blocked_ip/BlockedIpDialogView;)V", "detachView", "()V", "Lcom/avito/android/blocked_ip/BlockedIpDialogPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/blocked_ip/BlockedIpDialogPresenter$Router;)V", "detachRouter", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", AuthSource.BOOKING_ORDER, "Lcom/avito/android/blocked_ip/BlockedIpDialogView;", "c", "Lcom/avito/android/blocked_ip/BlockedIpDialogPresenter$Router;", "<init>", "blocked-ip_release"}, k = 1, mv = {1, 4, 2})
public final class BlockedIpDialogPresenterImpl implements BlockedIpDialogPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public BlockedIpDialogView b;
    public BlockedIpDialogPresenter.Router c;

    @Override // com.avito.android.blocked_ip.BlockedIpDialogPresenter
    public void attachRouter(@NotNull BlockedIpDialogPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.c = router;
    }

    @Override // com.avito.android.blocked_ip.BlockedIpDialogPresenter
    public void attachView(@NotNull BlockedIpDialogView blockedIpDialogView) {
        Intrinsics.checkNotNullParameter(blockedIpDialogView, "view");
        this.b = blockedIpDialogView;
        if (blockedIpDialogView != null) {
            blockedIpDialogView.showDialog(R.drawable.ic_blocked_ip, R.string.blocked_ip_dialog_title, R.string.blocked_ip_dialog_body, R.string.blocked_ip_dialog_secondary_button, R.string.blocked_ip_dialog_primary_button, new c4(0, this), new c4(1, this));
        }
    }

    @Override // com.avito.android.blocked_ip.BlockedIpDialogPresenter
    public void detachRouter() {
        this.c = null;
    }

    @Override // com.avito.android.blocked_ip.BlockedIpDialogPresenter
    public void detachView() {
        this.a.clear();
        this.b = null;
    }
}
