package com.avito.android.user_advert.advert;

import android.net.Uri;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0004J#\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsViewPresenter;", "", "", "onRefresh", "()V", "", "currentPosition", "onGalleryFullScreenClicked", "(I)V", "Landroid/net/Uri;", "url", "onContractButtonClicked", "(Landroid/net/Uri;)V", "onVerificationButtonClicked", "onSupportButtonClicked", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction;", "processedAction", "", "showAppRater", "showAdditionalDialogs", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction;Z)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface MyAdvertDetailsViewPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void showAdditionalDialogs$default(MyAdvertDetailsViewPresenter myAdvertDetailsViewPresenter, MyAdvertDetailsPresenter.ProcessedAction processedAction, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    processedAction = MyAdvertDetailsPresenter.ProcessedAction.Default.INSTANCE;
                }
                if ((i & 2) != 0) {
                    z = false;
                }
                myAdvertDetailsViewPresenter.showAdditionalDialogs(processedAction, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAdditionalDialogs");
        }
    }

    void onContractButtonClicked(@NotNull Uri uri);

    void onGalleryFullScreenClicked(int i);

    void onRefresh();

    void onSupportButtonClicked();

    void onVerificationButtonClicked();

    void showAdditionalDialogs(@NotNull MyAdvertDetailsPresenter.ProcessedAction processedAction, boolean z);
}
