package com.avito.android.publish.uploading_dialog;

import com.avito.android.publish.uploading_dialog.UploadingErrorPresenter;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/publish/uploading_dialog/UploadingErrorPresenterImpl;", "Lcom/avito/android/publish/uploading_dialog/UploadingErrorPresenter;", "Lcom/avito/android/publish/uploading_dialog/UploadingErrorPresenter$Router;", "router", "", "onAttached", "(Lcom/avito/android/publish/uploading_dialog/UploadingErrorPresenter$Router;)V", "onDetached", "()V", "onRetryClicked", "onSkipClicked", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/uploading_dialog/UploadingErrorPresenter$Router;", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class UploadingErrorPresenterImpl implements UploadingErrorPresenter {
    public UploadingErrorPresenter.Router a;

    @Override // com.avito.android.publish.uploading_dialog.UploadingErrorPresenter
    public void onAttached(@NotNull UploadingErrorPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.a = router;
    }

    @Override // com.avito.android.publish.uploading_dialog.UploadingErrorPresenter
    public void onDetached() {
        this.a = null;
    }

    @Override // com.avito.android.publish.uploading_dialog.UploadingErrorView.Presenter
    public void onRetryClicked() {
        UploadingErrorPresenter.Router router = this.a;
        if (router != null) {
            router.showRetry();
        }
        UploadingErrorPresenter.Router router2 = this.a;
        if (router2 != null) {
            router2.leaveScreen();
        }
    }

    @Override // com.avito.android.publish.uploading_dialog.UploadingErrorView.Presenter
    public void onSkipClicked() {
        UploadingErrorPresenter.Router router = this.a;
        if (router != null) {
            router.showSkip();
        }
        UploadingErrorPresenter.Router router2 = this.a;
        if (router2 != null) {
            router2.leaveScreen();
        }
    }
}
