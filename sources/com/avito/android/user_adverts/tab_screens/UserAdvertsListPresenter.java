package com.avito.android.user_adverts.tab_screens;

import android.content.Intent;
import com.avito.android.component.user_advert.UserAdvertItemClickListener;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.floating_views.FloatingViewsPresenter;
import com.avito.android.serp.adapter.ShortcutBannerItemListener;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\"J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013H&¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter;", "Lcom/avito/android/floating_views/FloatingViewsPresenter$Subscriber;", "Lcom/avito/android/component/user_advert/UserAdvertItemClickListener;", "Lcom/avito/android/serp/adapter/ShortcutBannerItemListener;", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListView;", "view", "", "attachView", "(Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListView;)V", "detachView", "()V", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "invalidate", "refreshTabs", "onRefresh", "(ZZ)V", "", "resultCode", "Landroid/content/Intent;", "data", "onAdvertDetailsResult", "(ILandroid/content/Intent;)V", "", "bannerId", "closeUserAdvertsBanner", "(Ljava/lang/String;)V", "Router", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertsListPresenter extends FloatingViewsPresenter.Subscriber, UserAdvertItemClickListener, ShortcutBannerItemListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onRefresh$default(UserAdvertsListPresenter userAdvertsListPresenter, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z2 = false;
                }
                userAdvertsListPresenter.onRefresh(z, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRefresh");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter$Router;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "showInfoBannerScreen", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "followDeepLink", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followDeepLink(@NotNull DeepLink deepLink);

        void showInfoBannerScreen(@NotNull DeepLink deepLink);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@Nullable UserAdvertsListView userAdvertsListView);

    void closeUserAdvertsBanner(@NotNull String str);

    void detachRouter();

    void detachView();

    void onAdvertDetailsResult(int i, @Nullable Intent intent);

    void onRefresh(boolean z, boolean z2);

    @NotNull
    Kundle onSaveState();
}
