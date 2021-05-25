package com.avito.android.grouping_adverts;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.AuthIntentFactoryKt;
import com.avito.android.FiltersIntentFactory;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.GroupingAdvertsScreen;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.module.RichStateProvider;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.filter.FilterCommons;
import com.avito.android.grouping_adverts.di.DaggerGroupingAdvertsComponent;
import com.avito.android.grouping_adverts.di.GroupingAdvertsComponent;
import com.avito.android.grouping_adverts.di.GroupingAdvertsDependencies;
import com.avito.android.grouping_adverts.tracker.GroupingAdvertsTracker;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProvider;
import com.avito.android.ui.adapter.AppendingHandler;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Constants;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Kundle;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ¶\u00012\u00020\u00012\u00020\u0002:\u0002¶\u0001B\b¢\u0006\u0005\bµ\u0001\u0010\u0011J+\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0011J!\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJc\u0010-\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010\u001f2\b\u0010$\u001a\u0004\u0018\u00010\u001f2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J!\u00102\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u001f2\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103J3\u00109\u001a\u00020\r2\u0006\u00105\u001a\u0002042\f\u00107\u001a\b\u0012\u0004\u0012\u00020\r062\f\u00108\u001a\b\u0012\u0004\u0012\u00020\r06H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020+2\u0006\u0010;\u001a\u000204H\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\rH\u0016¢\u0006\u0004\b>\u0010\u0011J\u000f\u0010?\u001a\u00020\rH\u0016¢\u0006\u0004\b?\u0010\u0011J\u0017\u0010A\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u0007H\u0016¢\u0006\u0004\bA\u0010BJ)\u0010G\u001a\u00020\r2\u0006\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020)2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0004\bG\u0010HJ\u0019\u0010I\u001a\u00020+2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\bI\u0010JR\"\u0010L\u001a\u00020K8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010S\u001a\u00020R8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010Z\u001a\u00020Y8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010a\u001a\u00020`8\u0006@\u0006X.¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010h\u001a\u00020g8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010o\u001a\u00020n8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\"\u0010v\u001a\u00020u8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R%\u0010}\u001a\u00020|8\u0006@\u0006X.¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010¦\u0001\u001a\u00030\u00018\u0014@\u0014X\u000e¢\u0006\u0018\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R*\u0010¨\u0001\u001a\u00030§\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010­\u0001R*\u0010¯\u0001\u001a\u00030®\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001\"\u0006\b³\u0001\u0010´\u0001¨\u0006·\u0001"}, d2 = {"Lcom/avito/android/grouping_adverts/GroupingAdvertsFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsRouter;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroyView", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "leaveScreen", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/remote/model/search/map/Area;", "searchArea", "showFiltersScreen", "(Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/search/map/Area;)V", "", "itemId", "context", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "", "galleryPosition", "", "isMarketplace", "openFastAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/Integer;Z)V", "src", "Landroid/os/Parcelable;", "successAuthResultData", "showAuth", "(Ljava/lang/String;Landroid/os/Parcelable;)V", "Lcom/avito/android/deep_linking/links/PhoneLink;", "link", "Lkotlin/Function0;", "successHandler", "failureHandler", "followPhoneLink", "(Lcom/avito/android/deep_linking/links/PhoneLink;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "phoneLink", "dialPhone", "(Lcom/avito/android/deep_linking/links/PhoneLink;)Z", "onResume", "onPause", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "getGridPositionProvider", "()Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "setGridPositionProvider", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;)V", "Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "richSnippetStateProvider", "Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "getRichSnippetStateProvider", "()Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "setRichSnippetStateProvider", "(Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "asyncPhonePresenter", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "getAsyncPhonePresenter", "()Lcom/avito/android/async_phone/AsyncPhonePresenter;", "setAsyncPhonePresenter", "(Lcom/avito/android/async_phone/AsyncPhonePresenter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "getViewedAdvertsPresenter", "()Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "setViewedAdvertsPresenter", "(Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;)V", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanLookup", "()Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "setSpanLookup", "(Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)V", "Lcom/avito/android/ui/adapter/AppendingHandler;", "appendingHandler", "Lcom/avito/android/ui/adapter/AppendingHandler;", "getAppendingHandler", "()Lcom/avito/android/ui/adapter/AppendingHandler;", "setAppendingHandler", "(Lcom/avito/android/ui/adapter/AppendingHandler;)V", "Lcom/avito/android/grouping_adverts/tracker/GroupingAdvertsTracker;", "tracker", "Lcom/avito/android/grouping_adverts/tracker/GroupingAdvertsTracker;", "getTracker", "()Lcom/avito/android/grouping_adverts/tracker/GroupingAdvertsTracker;", "setTracker", "(Lcom/avito/android/grouping_adverts/tracker/GroupingAdvertsTracker;)V", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "getFavoriteAdvertsPresenter", "()Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "setFavoriteAdvertsPresenter", "(Lcom/avito/android/favorite/FavoriteAdvertsPresenter;)V", "Lcom/avito/android/grouping_adverts/GroupingAdvertsPresenter;", "presenter", "Lcom/avito/android/grouping_adverts/GroupingAdvertsPresenter;", "getPresenter", "()Lcom/avito/android/grouping_adverts/GroupingAdvertsPresenter;", "setPresenter", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsPresenter;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "j", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "Companion", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class GroupingAdvertsFragment extends TabBaseFragment implements GroupingAdvertsRouter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public AppendingHandler appendingHandler;
    @Inject
    public AsyncPhonePresenter asyncPhonePresenter;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public FavoriteAdvertsPresenter favoriteAdvertsPresenter;
    @Inject
    public SpannedGridPositionProvider gridPositionProvider;
    @Inject
    public ItemBinder itemBinder;
    @NotNull
    public NavigationState j = new NavigationState(false);
    @Inject
    public GroupingAdvertsPresenter presenter;
    @Inject
    @RichStateProvider
    public RichSnippetStateProvider richSnippetStateProvider;
    @Inject
    public GridLayoutManager.SpanSizeLookup spanLookup;
    @Inject
    public GroupingAdvertsTracker tracker;
    @Inject
    public ViewedAdvertsPresenter viewedAdvertsPresenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/grouping_adverts/GroupingAdvertsFragment$Companion;", "", "Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments;", "arguments", "Lcom/avito/android/grouping_adverts/GroupingAdvertsFragment;", "newInstance", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments;)Lcom/avito/android/grouping_adverts/GroupingAdvertsFragment;", "<init>", "()V", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ GroupingAdvertsArguments a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(GroupingAdvertsArguments groupingAdvertsArguments) {
                super(1);
                this.a = groupingAdvertsArguments;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable("arguments", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final GroupingAdvertsFragment newInstance(@NotNull GroupingAdvertsArguments groupingAdvertsArguments) {
            Intrinsics.checkNotNullParameter(groupingAdvertsArguments, "arguments");
            return (GroupingAdvertsFragment) FragmentsKt.arguments$default(new GroupingAdvertsFragment(), 0, new a(groupingAdvertsArguments), 1, null);
        }

        public Companion(j jVar) {
        }
    }

    @Override // com.avito.android.serp.adapter.advert_xl.PhoneCallRouter
    public boolean dialPhone(@NotNull PhoneLink phoneLink) {
        Intrinsics.checkNotNullParameter(phoneLink, "phoneLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(phoneLink);
        if (intent == null) {
            return false;
        }
        try {
            startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsRouter
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivity(intent);
        }
    }

    @Override // com.avito.android.serp.adapter.advert_xl.PhoneCallRouter
    public void followPhoneLink(@NotNull PhoneLink phoneLink, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(phoneLink, "link");
        Intrinsics.checkNotNullParameter(function0, "successHandler");
        Intrinsics.checkNotNullParameter(function02, "failureHandler");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(phoneLink);
        if (intent != null) {
            try {
                startActivity(IntentsKt.makeSafeForExternalApps(intent));
                function0.invoke();
            } catch (Exception unused) {
                function02.invoke();
            }
        }
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final AppendingHandler getAppendingHandler() {
        AppendingHandler appendingHandler2 = this.appendingHandler;
        if (appendingHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appendingHandler");
        }
        return appendingHandler2;
    }

    @NotNull
    public final AsyncPhonePresenter getAsyncPhonePresenter() {
        AsyncPhonePresenter asyncPhonePresenter2 = this.asyncPhonePresenter;
        if (asyncPhonePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("asyncPhonePresenter");
        }
        return asyncPhonePresenter2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final FavoriteAdvertsPresenter getFavoriteAdvertsPresenter() {
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        return favoriteAdvertsPresenter2;
    }

    @NotNull
    public final SpannedGridPositionProvider getGridPositionProvider() {
        SpannedGridPositionProvider spannedGridPositionProvider = this.gridPositionProvider;
        if (spannedGridPositionProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridPositionProvider");
        }
        return spannedGridPositionProvider;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.j;
    }

    @NotNull
    public final GroupingAdvertsPresenter getPresenter() {
        GroupingAdvertsPresenter groupingAdvertsPresenter = this.presenter;
        if (groupingAdvertsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return groupingAdvertsPresenter;
    }

    @NotNull
    public final RichSnippetStateProvider getRichSnippetStateProvider() {
        RichSnippetStateProvider richSnippetStateProvider2 = this.richSnippetStateProvider;
        if (richSnippetStateProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("richSnippetStateProvider");
        }
        return richSnippetStateProvider2;
    }

    @NotNull
    public final GridLayoutManager.SpanSizeLookup getSpanLookup() {
        GridLayoutManager.SpanSizeLookup spanSizeLookup = this.spanLookup;
        if (spanSizeLookup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanLookup");
        }
        return spanSizeLookup;
    }

    @NotNull
    public final GroupingAdvertsTracker getTracker() {
        GroupingAdvertsTracker groupingAdvertsTracker = this.tracker;
        if (groupingAdvertsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return groupingAdvertsTracker;
    }

    @NotNull
    public final ViewedAdvertsPresenter getViewedAdvertsPresenter() {
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        return viewedAdvertsPresenter2;
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsRouter
    public void leaveScreen() {
        if (!features().getGroupingAdvertsWithoutActivity().invoke().booleanValue() || (getActivity() instanceof GroupingAdvertsActivity)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        boolean z = true;
        if (i == 1 && i2 == -1 && intent != null) {
            DeepLink result = new FilterCommons().getResult(intent);
            GroupingAdvertsPresenter groupingAdvertsPresenter = this.presenter;
            if (groupingAdvertsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            groupingAdvertsPresenter.onSearchClarified(result);
            return;
        }
        if (i2 != -1) {
            z = false;
        }
        if (i == 0) {
            GroupingAdvertsPresenter groupingAdvertsPresenter2 = this.presenter;
            if (groupingAdvertsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            groupingAdvertsPresenter2.onUserAuthorized(z, intent != null ? AuthIntentFactoryKt.getSuccessAuthResultData(intent) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.grouping_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…agment, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        favoriteAdvertsPresenter2.detachViews();
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        viewedAdvertsPresenter2.detachView();
        GroupingAdvertsPresenter groupingAdvertsPresenter = this.presenter;
        if (groupingAdvertsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        groupingAdvertsPresenter.detachView();
        AsyncPhonePresenter asyncPhonePresenter2 = this.asyncPhonePresenter;
        if (asyncPhonePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("asyncPhonePresenter");
        }
        asyncPhonePresenter2.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        GroupingAdvertsTracker groupingAdvertsTracker = this.tracker;
        if (groupingAdvertsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        groupingAdvertsTracker.detach();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        GroupingAdvertsTracker groupingAdvertsTracker = this.tracker;
        if (groupingAdvertsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        groupingAdvertsTracker.attach();
        super.onResume();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        if (features().getGroupingAdvertsWithoutActivity().invoke().booleanValue()) {
            Bundle bundle2 = new Bundle();
            GroupingAdvertsPresenter groupingAdvertsPresenter = this.presenter;
            if (groupingAdvertsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            bundle2.putParcelable("key_state", groupingAdvertsPresenter.getState());
            RichSnippetStateProvider richSnippetStateProvider2 = this.richSnippetStateProvider;
            if (richSnippetStateProvider2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("richSnippetStateProvider");
            }
            bundle2.putParcelable("key_rich_snippets_state", richSnippetStateProvider2.onSaveState());
            Unit unit = Unit.INSTANCE;
            saveInRetainStorage(bundle2);
            return;
        }
        GroupingAdvertsPresenter groupingAdvertsPresenter2 = this.presenter;
        if (groupingAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("key_state", groupingAdvertsPresenter2.getState());
        RichSnippetStateProvider richSnippetStateProvider3 = this.richSnippetStateProvider;
        if (richSnippetStateProvider3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("richSnippetStateProvider");
        }
        bundle.putParcelable("key_rich_snippets_state", richSnippetStateProvider3.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        GroupingAdvertsPresenter groupingAdvertsPresenter = this.presenter;
        if (groupingAdvertsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        groupingAdvertsPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        GroupingAdvertsPresenter groupingAdvertsPresenter = this.presenter;
        if (groupingAdvertsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        groupingAdvertsPresenter.detachRouter();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        AppendingHandler appendingHandler2 = this.appendingHandler;
        if (appendingHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appendingHandler");
        }
        GridLayoutManager.SpanSizeLookup spanSizeLookup = this.spanLookup;
        if (spanSizeLookup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanLookup");
        }
        GroupingAdvertsViewImpl groupingAdvertsViewImpl = new GroupingAdvertsViewImpl(view, analytics2, adapterPresenter2, itemBinder2, appendingHandler2, spanSizeLookup);
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        favoriteAdvertsPresenter2.attachView(groupingAdvertsViewImpl);
        FavoriteAdvertsPresenter favoriteAdvertsPresenter3 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        favoriteAdvertsPresenter3.attachErrorMessageView(groupingAdvertsViewImpl);
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        viewedAdvertsPresenter2.attachView(groupingAdvertsViewImpl);
        GroupingAdvertsPresenter groupingAdvertsPresenter = this.presenter;
        if (groupingAdvertsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        groupingAdvertsPresenter.attachView(groupingAdvertsViewImpl);
        AsyncPhonePresenter asyncPhonePresenter2 = this.asyncPhonePresenter;
        if (asyncPhonePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("asyncPhonePresenter");
        }
        asyncPhonePresenter2.attachView(groupingAdvertsViewImpl);
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsRouter
    public void openFastAdvertDetails(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable Integer num, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str3, "title");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        Intent advertDetailsIntent$default = AdvertDetailsIntentFactory.DefaultImpls.advertDetailsIntent$default(activityIntentFactory2, str, str2, str3, str4, str5, image, z, treeClickStreamParent, SystemClock.elapsedRealtime(), num, currentTab(), null, 2048, null);
        ActivityIntentFactory activityIntentFactory3 = this.activityIntentFactory;
        if (activityIntentFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        Intent putExtra = advertDetailsIntent$default.putExtra(Constants.UP_INTENT, activityIntentFactory3.homeIntent());
        Intrinsics.checkNotNullExpressionValue(putExtra, "activityIntentFactory.ad…tentFactory.homeIntent())");
        startActivity(putExtra);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAppendingHandler(@NotNull AppendingHandler appendingHandler2) {
        Intrinsics.checkNotNullParameter(appendingHandler2, "<set-?>");
        this.appendingHandler = appendingHandler2;
    }

    public final void setAsyncPhonePresenter(@NotNull AsyncPhonePresenter asyncPhonePresenter2) {
        Intrinsics.checkNotNullParameter(asyncPhonePresenter2, "<set-?>");
        this.asyncPhonePresenter = asyncPhonePresenter2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setFavoriteAdvertsPresenter(@NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter2, "<set-?>");
        this.favoriteAdvertsPresenter = favoriteAdvertsPresenter2;
    }

    public final void setGridPositionProvider(@NotNull SpannedGridPositionProvider spannedGridPositionProvider) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "<set-?>");
        this.gridPositionProvider = spannedGridPositionProvider;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.j = navigationState;
    }

    public final void setPresenter(@NotNull GroupingAdvertsPresenter groupingAdvertsPresenter) {
        Intrinsics.checkNotNullParameter(groupingAdvertsPresenter, "<set-?>");
        this.presenter = groupingAdvertsPresenter;
    }

    public final void setRichSnippetStateProvider(@NotNull RichSnippetStateProvider richSnippetStateProvider2) {
        Intrinsics.checkNotNullParameter(richSnippetStateProvider2, "<set-?>");
        this.richSnippetStateProvider = richSnippetStateProvider2;
    }

    public final void setSpanLookup(@NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        Intrinsics.checkNotNullParameter(spanSizeLookup, "<set-?>");
        this.spanLookup = spanSizeLookup;
    }

    public final void setTracker(@NotNull GroupingAdvertsTracker groupingAdvertsTracker) {
        Intrinsics.checkNotNullParameter(groupingAdvertsTracker, "<set-?>");
        this.tracker = groupingAdvertsTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        GroupingAdvertsArguments groupingAdvertsArguments;
        if (features().getGroupingAdvertsWithoutActivity().invoke().booleanValue()) {
            bundle = retainStorage();
        }
        Bundle arguments = getArguments();
        if (arguments == null || (groupingAdvertsArguments = (GroupingAdvertsArguments) arguments.getParcelable("arguments")) == null) {
            throw new IllegalArgumentException("GroupingAdvertsArguments must be specified");
        }
        Kundle kundle = bundle != null ? (Kundle) bundle.getParcelable("key_state") : null;
        Kundle kundle2 = bundle != null ? (Kundle) bundle.getParcelable("key_rich_snippets_state") : null;
        GroupingAdvertsComponent.Builder withScreen = DaggerGroupingAdvertsComponent.builder().dependentOn((GroupingAdvertsDependencies) ComponentDependenciesKt.getDependencies(GroupingAdvertsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withScreen(GroupingAdvertsScreen.INSTANCE);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        withScreen.withResources(resources).withSearchParams(groupingAdvertsArguments).withPresenterState(kundle).withRichGalleryState(kundle2).withRichSnippetRecycledViewPool(new RecyclerView.RecycledViewPool()).withSerpOnboardingHandler(null).build().inject(this);
        return true;
    }

    public final void setViewedAdvertsPresenter(@NotNull ViewedAdvertsPresenter viewedAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter2, "<set-?>");
        this.viewedAdvertsPresenter = viewedAdvertsPresenter2;
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsRouter
    public void showAuth(@NotNull String str, @Nullable Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(str, "src");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, str, parcelable, 1, null), 0);
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsRouter
    public void showFiltersScreen(@NotNull SearchParams searchParams, @Nullable Area area) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        Intent searchIntent$default = FiltersIntentFactory.DefaultImpls.searchIntent$default(activityIntentFactory2, searchParams, area, null, true, null, currentTab(), false, 84, null);
        if (!features().getFiltersWithoutActivity().invoke().booleanValue() || (getActivity() instanceof GroupingAdvertsActivity)) {
            startActivityForResult(searchIntent$default, 1);
        } else {
            startForResult(searchIntent$default, 1);
        }
    }
}
