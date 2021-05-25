package com.avito.android.home;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.home.HomeAdapterListener;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.serp.adapter.witcher.WitcherItemListener;
import com.avito.android.stories.adapter.StoriesItemListener;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.ui.view.retry.RetryView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001&J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u000bH&¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u000bH&¢\u0006\u0004\b\u0012\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000bH&¢\u0006\u0004\b\u0017\u0010\u000fJ\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000bH&¢\u0006\u0004\b\u001f\u0010\u000fJ\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u001bH&¢\u0006\u0004\b%\u0010\u001e¨\u0006'"}, d2 = {"Lcom/avito/android/home/HomePresenter;", "Lcom/avito/android/home/HomeViewPresenter;", "Lcom/avito/android/ui/adapter/AppendingListener;", "Lcom/avito/android/home/HomeAdapterListener;", "Lcom/avito/android/home/SectionTabsViewPresenter;", "Lcom/avito/android/stories/adapter/StoriesItemListener;", "Lcom/avito/android/serp/adapter/witcher/WitcherItemListener;", "Lcom/avito/android/home/HomeView;", "view", "Lcom/avito/android/ui/view/retry/RetryView;", "retryView", "", "attachView", "(Lcom/avito/android/home/HomeView;Lcom/avito/android/ui/view/retry/RetryView;)V", "detachView", "()V", "onResume", "onStop", "onPause", "Lcom/avito/android/home/HomePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/home/HomePresenter$Router;)V", "detachRouter", "Lcom/avito/android/home/HomePresenterState;", "onSaveState", "()Lcom/avito/android/home/HomePresenterState;", "", "message", "onActionResultReceived", "(Ljava/lang/String;)V", "onResetPageState", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onSearchClarified", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "storyId", "updateCurrentStoryId", "Router", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface HomePresenter extends HomeViewPresenter, AppendingListener, HomeAdapterListener, SectionTabsViewPresenter, StoriesItemListener, WitcherItemListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onMoreActionsClicked(@NotNull HomePresenter homePresenter, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            HomeAdapterListener.DefaultImpls.onMoreActionsClicked(homePresenter, str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u000e\u0010\u0012J_\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u001f\u0010 J#\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b#\u0010$J-\u0010)\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070&2\u0006\u0010(\u001a\u00020\u0007H&¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/avito/android/home/HomePresenter$Router;", "", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "showClarifyScreen", "(Lcom/avito/android/remote/model/SearchParams;)V", "", "locationId", "geoSessionId", "showLocationsListScreen", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "itemId", "feedId", "context", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "", "isMarketplace", "openAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Z)V", "showSearchScreen", "(Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "Lcom/avito/android/remote/model/Location;", "location", "showAllCategories", "(Lcom/avito/android/remote/model/Location;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "url", "", "stories", "storyId", "openStory", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followDeepLink(@NotNull DeepLink deepLink);

        void followDeepLink(@NotNull DeepLink deepLink, @NotNull TreeClickStreamParent treeClickStreamParent);

        void openAdvertDetails(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @Nullable String str5, @Nullable String str6, @Nullable Image image, @NotNull TreeClickStreamParent treeClickStreamParent, boolean z);

        void openStory(@NotNull String str, @NotNull List<String> list, @NotNull String str2);

        void showAllCategories(@Nullable Location location, @Nullable TreeClickStreamParent treeClickStreamParent);

        void showClarifyScreen(@NotNull SearchParams searchParams);

        void showLocationsListScreen(@NotNull String str, @Nullable String str2);

        void showSearchScreen(@NotNull SearchParams searchParams, @NotNull TreeClickStreamParent treeClickStreamParent);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull HomeView homeView, @NotNull RetryView retryView);

    void detachRouter();

    void detachView();

    void onActionResultReceived(@NotNull String str);

    void onPause();

    void onResetPageState();

    void onResume();

    @NotNull
    HomePresenterState onSaveState();

    void onSearchClarified(@NotNull DeepLink deepLink);

    void onStop();

    void updateCurrentStoryId(@NotNull String str);
}
