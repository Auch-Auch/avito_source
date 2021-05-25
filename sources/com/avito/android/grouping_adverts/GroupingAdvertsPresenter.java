package com.avito.android.grouping_adverts;

import android.os.Parcelable;
import com.avito.android.async_phone.AsyncPhoneAuthRouter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/grouping_adverts/GroupingAdvertsPresenter;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/ui/adapter/AppendingListener;", "Lcom/avito/android/serp/adapter/rich_snippets/AdvertRichItemListener;", "Lcom/avito/android/async_phone/AsyncPhoneAuthRouter;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsView;", "view", "", "attachView", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsView;)V", "Lcom/avito/android/grouping_adverts/GroupingAdvertsRouter;", "router", "attachRouter", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsRouter;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onSearchClarified", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "", "success", "Landroid/os/Parcelable;", "authResultData", "onUserAuthorized", "(ZLandroid/os/Parcelable;)V", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface GroupingAdvertsPresenter extends AdvertItemListener, AppendingListener, AdvertRichItemListener, AsyncPhoneAuthRouter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onMoreActionsClicked(@NotNull GroupingAdvertsPresenter groupingAdvertsPresenter, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            AdvertItemListener.DefaultImpls.onMoreActionsClicked(groupingAdvertsPresenter, str);
        }

        public static /* synthetic */ void onUserAuthorized$default(GroupingAdvertsPresenter groupingAdvertsPresenter, boolean z, Parcelable parcelable, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    parcelable = null;
                }
                groupingAdvertsPresenter.onUserAuthorized(z, parcelable);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onUserAuthorized");
        }

        public static void showAuth(@NotNull GroupingAdvertsPresenter groupingAdvertsPresenter, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "src");
            AsyncPhoneAuthRouter.DefaultImpls.showAuth(groupingAdvertsPresenter, str);
        }
    }

    void attachRouter(@NotNull GroupingAdvertsRouter groupingAdvertsRouter);

    void attachView(@NotNull GroupingAdvertsView groupingAdvertsView);

    void detachRouter();

    void detachView();

    @Nullable
    Kundle getState();

    void onSearchClarified(@NotNull DeepLink deepLink);

    void onUserAuthorized(boolean z, @Nullable Parcelable parcelable);
}
