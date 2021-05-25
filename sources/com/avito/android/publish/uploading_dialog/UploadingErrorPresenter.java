package com.avito.android.publish.uploading_dialog;

import com.avito.android.publish.uploading_dialog.UploadingErrorView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/uploading_dialog/UploadingErrorPresenter;", "Lcom/avito/android/publish/uploading_dialog/UploadingErrorView$Presenter;", "Lcom/avito/android/publish/uploading_dialog/UploadingErrorPresenter$Router;", "router", "", "onAttached", "(Lcom/avito/android/publish/uploading_dialog/UploadingErrorPresenter$Router;)V", "onDetached", "()V", "Router", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface UploadingErrorPresenter extends UploadingErrorView.Presenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/publish/uploading_dialog/UploadingErrorPresenter$Router;", "", "", "showRetry", "()V", "showSkip", "leaveScreen", "publish_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void leaveScreen();

        void showRetry();

        void showSkip();
    }

    void onAttached(@NotNull Router router);

    void onDetached();
}
