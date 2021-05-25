package com.avito.android.publish;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001:\u0001\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\u0019\u0010\u0014J\u000f\u0010\u001a\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\u0014J\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010 \u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u0010H&¢\u0006\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/avito/android/publish/SubmissionPresenter;", "", "Lcom/avito/android/publish/PublishViewModel;", "viewModel", "", "setPublishViewModel", "(Lcom/avito/android/publish/PublishViewModel;)V", "Lcom/avito/android/publish/PublishedAdvertData;", "publishedAdvertData", "onAdvertPublished", "(Lcom/avito/android/publish/PublishedAdvertData;)V", "", "requestCode", "resultCode", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "onResult", "(IILjava/lang/String;)Z", "detachRouter", "()V", "Lcom/avito/android/publish/SubmissionPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/publish/SubmissionPresenter$Router;)V", "onViewCreated", "onViewDestroyed", "isFinishing", "shouldSaveOnClose", "detachView", "(ZZ)V", "showInfoMessages", "saveDraftIfNeeded", "(Z)Z", "Router", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface SubmissionPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ boolean saveDraftIfNeeded$default(SubmissionPresenter submissionPresenter, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return submissionPresenter.saveDraftIfNeeded(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveDraftIfNeeded");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish/SubmissionPresenter$Router;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "showListingFeesScreen", "(Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "statusMessage", "", "isPublishSuccessful", "showItemScreen", "(Ljava/lang/String;Ljava/lang/String;Z)V", "navigateToAuth", "()V", "Result", "publish_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static /* synthetic */ void showItemScreen$default(Router router, String str, String str2, boolean z, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        str2 = null;
                    }
                    if ((i & 4) != 0) {
                        z = true;
                    }
                    router.showItemScreen(str, str2, z);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showItemScreen");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/avito/android/publish/SubmissionPresenter$Router$Result;", "", "", "REQ_SELL_FAST", "I", "REQ_FEES", "REQ_LOGIN", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class Result {
            @NotNull
            public static final Result INSTANCE = new Result();
            public static final int REQ_FEES = 1;
            public static final int REQ_LOGIN = 0;
            public static final int REQ_SELL_FAST = 2;
        }

        void navigateToAuth();

        @Override // com.avito.android.dialog.DialogWithDeeplinkActionsRouter
        void openDeepLink(@NotNull DeepLink deepLink);

        void showItemScreen(@NotNull String str, @Nullable String str2, boolean z);

        void showListingFeesScreen(@NotNull String str);
    }

    void attachRouter(@NotNull Router router);

    void detachRouter();

    void detachView(boolean z, boolean z2);

    void onAdvertPublished(@NotNull PublishedAdvertData publishedAdvertData);

    boolean onResult(int i, int i2, @Nullable String str);

    void onViewCreated();

    void onViewDestroyed();

    boolean saveDraftIfNeeded(boolean z);

    void setPublishViewModel(@NotNull PublishViewModel publishViewModel);
}
