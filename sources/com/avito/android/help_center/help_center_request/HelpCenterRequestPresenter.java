package com.avito.android.help_center.help_center_request;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenter;", "", "Lcom/avito/android/help_center/help_center_request/HelpCenterRequestView;", "view", "", "attachView", "(Lcom/avito/android/help_center/help_center_request/HelpCenterRequestView;)V", "detachView", "()V", "Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenter$Router;)V", "detachRouter", "", "handleBack", "()Z", "Router", "help-center_release"}, k = 1, mv = {1, 4, 2})
public interface HelpCenterRequestPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenter$Router;", "", "", "closeActivity", "()V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "openUriViewIntent", "(Landroid/net/Uri;)V", "help-center_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void closeActivity();

        void openUriViewIntent(@NotNull Uri uri);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull HelpCenterRequestView helpCenterRequestView);

    void detachRouter();

    void detachView();

    boolean handleBack();
}
