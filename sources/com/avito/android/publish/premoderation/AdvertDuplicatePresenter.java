package com.avito.android.publish.premoderation;

import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/publish/premoderation/AdvertDuplicatePresenter;", "", "Lcom/avito/android/publish/premoderation/AdvertDuplicateView;", "view", "", "attachView", "(Lcom/avito/android/publish/premoderation/AdvertDuplicateView;)V", "Lcom/avito/android/publish/premoderation/AdvertDuplicatePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/publish/premoderation/AdvertDuplicatePresenter$Router;)V", "detachRouter", "()V", "detachView", "Router", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDuplicatePresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/premoderation/AdvertDuplicatePresenter$Router;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onContinueClicked", "()V", "leaveScreen", "publish_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followDeepLink(@NotNull DeepLink deepLink);

        void leaveScreen();

        void onContinueClicked();
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull AdvertDuplicateView advertDuplicateView);

    void detachRouter();

    void detachView();
}
