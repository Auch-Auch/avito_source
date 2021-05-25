package com.avito.android.deep_linking;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/avito/android/deep_linking/AppLinkPresenter;", "", "Lcom/avito/android/deep_linking/AppLinkView;", "view", "", "attachView", "(Lcom/avito/android/deep_linking/AppLinkView;)V", "Lcom/avito/android/deep_linking/AppLinkRouter;", "router", "attachRouter", "(Lcom/avito/android/deep_linking/AppLinkRouter;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "referrerUri", "setDeepLinkUriParams", "(Landroid/net/Uri;Landroid/net/Uri;)V", "detachRouter", "()V", "detachView", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
public interface AppLinkPresenter {
    void attachRouter(@NotNull AppLinkRouter appLinkRouter);

    void attachView(@NotNull AppLinkView appLinkView);

    void detachRouter();

    void detachView();

    void setDeepLinkUriParams(@Nullable Uri uri, @Nullable Uri uri2);
}
