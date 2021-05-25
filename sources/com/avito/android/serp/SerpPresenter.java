package com.avito.android.serp;

import android.os.Parcelable;
import com.avito.android.async_phone.AsyncPhoneAuthRouter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.home.appending_item.retry.RetryItemsLoadingListener;
import com.avito.android.serp.adapter.SerpAdapterListener;
import com.avito.android.serp.adapter.ShortcutBannerItemListener;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.ui.view.retry.RetryView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000bH&¢\u0006\u0004\b\u0014\u0010\u000fJ\u000f\u0010\u0015\u001a\u00020\u000bH&¢\u0006\u0004\b\u0015\u0010\u000fJ\u000f\u0010\u0016\u001a\u00020\u000bH&¢\u0006\u0004\b\u0016\u0010\u000fJ#\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u000bH&¢\u0006\u0004\b$\u0010\u000f¨\u0006%"}, d2 = {"Lcom/avito/android/serp/SerpPresenter;", "Lcom/avito/android/serp/SerpViewPresenter;", "Lcom/avito/android/serp/adapter/SerpAdapterListener;", "Lcom/avito/android/ui/adapter/AppendingListener;", "Lcom/avito/android/home/appending_item/retry/RetryItemsLoadingListener;", "Lcom/avito/android/serp/adapter/ShortcutBannerItemListener;", "Lcom/avito/android/async_phone/AsyncPhoneAuthRouter;", "Lcom/avito/android/serp/SerpPresenterView;", "view", "Lcom/avito/android/ui/view/retry/RetryView;", "retryView", "", "attachView", "(Lcom/avito/android/serp/SerpPresenterView;Lcom/avito/android/ui/view/retry/RetryView;)V", "detachView", "()V", "Lcom/avito/android/serp/SerpRouter;", "router", "attachRouter", "(Lcom/avito/android/serp/SerpRouter;)V", "detachRouter", "onStop", "onResume", "", "success", "Landroid/os/Parcelable;", "authResultData", "onUserAuthorized", "(ZLandroid/os/Parcelable;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onSearchClarified", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/serp/SerpPresenterState;", "onSaveState", "()Lcom/avito/android/serp/SerpPresenterState;", "subscribeToLocationChanges", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface SerpPresenter extends SerpViewPresenter, SerpAdapterListener, AppendingListener, RetryItemsLoadingListener, ShortcutBannerItemListener, AsyncPhoneAuthRouter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onMoreActionsClicked(@NotNull SerpPresenter serpPresenter, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            SerpAdapterListener.DefaultImpls.onMoreActionsClicked(serpPresenter, str);
        }

        public static /* synthetic */ void onUserAuthorized$default(SerpPresenter serpPresenter, boolean z, Parcelable parcelable, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    parcelable = null;
                }
                serpPresenter.onUserAuthorized(z, parcelable);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onUserAuthorized");
        }

        public static void showAuth(@NotNull SerpPresenter serpPresenter, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "src");
            AsyncPhoneAuthRouter.DefaultImpls.showAuth(serpPresenter, str);
        }
    }

    void attachRouter(@NotNull SerpRouter serpRouter);

    void attachView(@NotNull SerpPresenterView serpPresenterView, @NotNull RetryView retryView);

    void detachRouter();

    void detachView();

    void onResume();

    @NotNull
    SerpPresenterState onSaveState();

    void onSearchClarified(@NotNull DeepLink deepLink);

    void onStop();

    void onUserAuthorized(boolean z, @Nullable Parcelable parcelable);

    void subscribeToLocationChanges();
}
