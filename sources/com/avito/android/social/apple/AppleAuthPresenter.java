package com.avito.android.social.apple;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/social/apple/AppleAuthPresenter;", "", "Lcom/avito/android/social/apple/AppleAuthView;", "view", "", "attachView", "(Lcom/avito/android/social/apple/AppleAuthView;)V", "detachView", "()V", "Lcom/avito/android/social/apple/AppleAuthPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/social/apple/AppleAuthPresenter$Router;)V", "detachRouter", "loadAuthPage", "Router", "social_release"}, k = 1, mv = {1, 4, 2})
public interface AppleAuthPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/social/apple/AppleAuthPresenter$Router;", "", "Lcom/avito/android/social/apple/AppleAuthResult;", "result", "", "sendResult", "(Lcom/avito/android/social/apple/AppleAuthResult;)V", "social_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void sendResult(@Nullable AppleAuthResult appleAuthResult);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull AppleAuthView appleAuthView);

    void detachRouter();

    void detachView();

    void loadAuthPage();
}
