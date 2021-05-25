package com.avito.android.messenger.channels.mvi.view;

import a2.a.a.o1.b.b.e.f;
import a2.b.a.a.a;
import a2.g.r.g;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
import com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler;
import com.avito.android.date_time_formatter.RelativeDateFormatter;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.messenger.R;
import com.avito.android.messenger.analytics.DisplayChannelsListEvent;
import com.avito.android.messenger.channels.ChannelsRouter;
import com.avito.android.messenger.channels.analytics.ChannelsTracker;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter;
import com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem;
import com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.Logs;
import com.avito.android.util.ToastsKt;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 {2\u00020\u00012\u00020\u0002:\u0001{B\u0007¢\u0006\u0004\bz\u0010\u0017J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u0017J\u000f\u0010\u001b\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\n8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010>\u001a\u00020=8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\"\u0010I\u001a\u00020H8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010P\u001a\u00020O8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010^\u001a\u00020]8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR#\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00100d8B@\u0002X\u0002¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR1\u0010r\u001a\u001d\u0012\u0013\u0012\u00110k¢\u0006\f\bl\u0012\b\bm\u0012\u0004\b\b(n\u0012\u0004\u0012\u00020o0j8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bp\u0010qR\"\u0010t\u001a\u00020s8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010y¨\u0006|"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/ChannelsListFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onStart", "()V", "onResume", "onPause", "onDestroyView", "scrollToUp", "d", "Landroid/view/ViewGroup;", "rootView", "Lcom/avito/android/messenger/channels/mvi/view/ChannelsListView;", "e", "Lcom/avito/android/messenger/channels/mvi/view/ChannelsListView;", "channelsListView", "Landroidx/lifecycle/MutableLiveData;", "", "h", "Landroidx/lifecycle/MutableLiveData;", "hideSwipeViewsStream", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;", "perfTracker", "Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;", "getPerfTracker", "()Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;", "setPerfTracker", "(Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;)V", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "itemVisibilityTracker", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "getItemVisibilityTracker", "()Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "setItemVisibilityTracker", "(Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;)V", "Lcom/avito/android/messenger/channels/ChannelsRouter;", "router", "Lcom/avito/android/messenger/channels/ChannelsRouter;", "getRouter", "()Lcom/avito/android/messenger/channels/ChannelsRouter;", "setRouter", "(Lcom/avito/android/messenger/channels/ChannelsRouter;)V", "Lio/reactivex/disposables/CompositeDisposable;", "f", "Lio/reactivex/disposables/CompositeDisposable;", "allSubscriptions", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenter;", "channelsListPresenter", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenter;", "getChannelsListPresenter", "()Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenter;", "setChannelsListPresenter", "(Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenter;)V", "Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "supplier", "Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "getSupplier", "()Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "setSupplier", "(Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;)V", "Lcom/avito/android/date_time_formatter/RelativeDateFormatter;", "dateFormatter", "Lcom/avito/android/date_time_formatter/RelativeDateFormatter;", "getDateFormatter", "()Lcom/avito/android/date_time_formatter/RelativeDateFormatter;", "setDateFormatter", "(Lcom/avito/android/date_time_formatter/RelativeDateFormatter;)V", "Lkotlin/Function0;", g.a, "Lkotlin/Lazy;", "getNotificationBannerActionClickListener", "()Lkotlin/jvm/functions/Function0;", "notificationBannerActionClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "dateMillis", "", "c", "Lkotlin/jvm/functions/Function1;", "dateFormatterFunction", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory$messenger_release", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory$messenger_release", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsListFragment extends BaseFragment implements ScrollToUpHandler {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "ChannelsListFragment";
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    public Function1<? super Long, String> c;
    @Inject
    public ChannelsListPresenter channelsListPresenter;
    public ViewGroup d;
    @Inject
    public RelativeDateFormatter dateFormatter;
    public ChannelsListView e;
    public final CompositeDisposable f = new CompositeDisposable();
    @Inject
    public Features features;
    public final Lazy g = c.lazy(LazyThreadSafetyMode.NONE, (Function0) new a(this));
    public final MutableLiveData<Integer> h = new MutableLiveData<>();
    @Inject
    public ItemVisibilityTracker itemVisibilityTracker;
    @Inject
    public ChannelsTracker perfTracker;
    public ChannelsRouter router;
    @Inject
    public FpsStateSupplier supplier;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J}\u0010\n\u001a\u00020\t2\"\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002j\u0002`\u00052&\u0010\u0007\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00052\"\u0010\b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002j\u0002`\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/ChannelsListFragment$Companion;", "", "Lkotlin/Pair;", "Ljava/util/SortedSet;", "", "Lcom/avito/android/messenger/folders/ChatListTags;", "mainTags", "pinnedTags", "mergedTags", "Lcom/avito/android/messenger/channels/mvi/view/ChannelsListFragment;", "create", "(Lkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;)Lcom/avito/android/messenger/channels/mvi/view/ChannelsListFragment;", "KEY_ITEM_VISIBILITY_TRACKER_STATE", "Ljava/lang/String;", "KEY_MAIN_EXCLUDE_TAGS", "KEY_MAIN_INCLUDE_TAGS", "KEY_MERGED_EXCLUDE_TAGS", "KEY_MERGED_INCLUDE_TAGS", "KEY_PINNED_EXCLUDE_TAGS", "KEY_PINNED_INCLUDE_TAGS", "TAG", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ Pair a;
            public final /* synthetic */ Pair b;
            public final /* synthetic */ Pair c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Pair pair, Pair pair2, Pair pair3) {
                super(1);
                this.a = pair;
                this.b = pair2;
                this.c = pair3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putSerializable("mainIncludeTags", new TreeSet((SortedSet) this.a.getFirst()));
                bundle2.putSerializable("mainExcludeTags", new TreeSet((SortedSet) this.a.getSecond()));
                bundle2.putSerializable("mergedIncludeTags", new TreeSet((SortedSet) this.b.getFirst()));
                bundle2.putSerializable("mergedExcludeTags", new TreeSet((SortedSet) this.b.getSecond()));
                Pair pair = this.c;
                if (pair != null) {
                    bundle2.putSerializable("pinnedIncludeTags", new TreeSet((SortedSet) pair.getFirst()));
                    bundle2.putSerializable("pinnedExcludeTags", new TreeSet((SortedSet) pair.getSecond()));
                }
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final ChannelsListFragment create(@NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair, @Nullable Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair2, @NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair3) {
            Intrinsics.checkNotNullParameter(pair, "mainTags");
            Intrinsics.checkNotNullParameter(pair3, "mergedTags");
            return (ChannelsListFragment) FragmentsKt.arguments(new ChannelsListFragment(), 6, new a(pair, pair3, pair2));
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<Function0<? extends Unit>> {
        public final /* synthetic */ ChannelsListFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ChannelsListFragment channelsListFragment) {
            super(0);
            this.a = channelsListFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Function0<? extends Unit> invoke() {
            return new f(this);
        }
    }

    public static final /* synthetic */ ChannelsListView access$getChannelsListView$p(ChannelsListFragment channelsListFragment) {
        ChannelsListView channelsListView = channelsListFragment.e;
        if (channelsListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelsListView");
        }
        return channelsListView;
    }

    public static final /* synthetic */ Function1 access$getDateFormatterFunction$p(ChannelsListFragment channelsListFragment) {
        Function1<? super Long, String> function1 = channelsListFragment.c;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateFormatterFunction");
        }
        return function1;
    }

    public static final Function0 access$getNotificationBannerActionClickListener$p(ChannelsListFragment channelsListFragment) {
        return (Function0) channelsListFragment.g.getValue();
    }

    public static final AbstractListItem access$inject(ChannelsListFragment channelsListFragment, AbstractListItem abstractListItem, int i) {
        Objects.requireNonNull(channelsListFragment);
        if (abstractListItem instanceof ChannelListItem) {
            ChannelListItem channelListItem = (ChannelListItem) abstractListItem;
            ChannelListItem channelListItem2 = new ChannelListItem(channelListItem.id, channelListItem.isActive(), channelListItem.getChatTitle(), channelListItem.getItem(), channelListItem.getFeatureImage(), channelListItem.getDate(), channelListItem.isOnline(), channelListItem.getAvatar(), channelListItem.getLastMessageType(), channelListItem.getLastMessage(), channelListItem.isTyping(), channelListItem.getItemDeliveryStatus());
            channelListItem2.setDateFormatter(access$getDateFormatterFunction$p(channelsListFragment));
            channelListItem2.setLifecycleOwner(new WeakReference<>(channelsListFragment));
            channelListItem2.setHideSwipeViewsStream(channelsListFragment.h);
            channelListItem2.setItemClickListener(new Function0<Unit>(abstractListItem, i) { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$inject$$inlined$apply$lambda$1
                public final /* synthetic */ AbstractListItem b;
                public final /* synthetic */ int c;

                {
                    this.b = r2;
                    this.c = r3;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    ChannelsListFragment.this.getRouter().showChannelScreen(this.b.id, this.c);
                }
            });
            channelListItem2.setLongClickListener(ChannelsListFragment$inject$1$2.INSTANCE);
            channelListItem2.setDeleteClickListener(new View.OnClickListener(channelsListFragment, abstractListItem, i) { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$inject$$inlined$apply$lambda$2
                public final /* synthetic */ ChannelsListFragment b;

                {
                    this.b = r2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.b.getChannelsListPresenter().deleteChannel(ChannelListItem.this.id);
                }
            });
            return channelListItem2;
        } else if (abstractListItem instanceof PinnedSupportChatItem) {
            PinnedSupportChatItem pinnedSupportChatItem = (PinnedSupportChatItem) abstractListItem;
            PinnedSupportChatItem pinnedSupportChatItem2 = new PinnedSupportChatItem(pinnedSupportChatItem.id, pinnedSupportChatItem.getHasNewIncomingUnreadMessages(), pinnedSupportChatItem.getSupportChatTitle(), pinnedSupportChatItem.getSupportChatIcon());
            pinnedSupportChatItem2.setItemClickListener(new Function0<Unit>(abstractListItem, i) { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$inject$$inlined$apply$lambda$3
                public final /* synthetic */ AbstractListItem b;
                public final /* synthetic */ int c;

                {
                    this.b = r2;
                    this.c = r3;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    ChannelsListFragment.this.getRouter().showChannelScreen(this.b.id, this.c);
                }
            });
            return pinnedSupportChatItem2;
        } else if (abstractListItem instanceof ChannelsListBannerItem) {
            ChannelsListBannerItem copy$default = ChannelsListBannerItem.copy$default((ChannelsListBannerItem) abstractListItem, null, 0, 0, 0, null, 31, null);
            copy$default.setActionClickListener(access$getNotificationBannerActionClickListener$p(channelsListFragment));
            return copy$default;
        } else if (!(abstractListItem instanceof ChannelListAdBannerItem)) {
            return abstractListItem;
        } else {
            ChannelListAdBannerItem copy = ((ChannelListAdBannerItem) abstractListItem).copy();
            copy.setLifecycleOwner(new WeakReference<>(channelsListFragment));
            copy.setHideSwipeViewsStream(channelsListFragment.h);
            ChannelsListPresenter channelsListPresenter2 = channelsListFragment.getChannelsListPresenter();
            copy.setCloseListener(new ChannelsListFragment$inject$4$1(channelsListPresenter2));
            copy.setOpenListener(new ChannelsListFragment$inject$4$2(channelsListPresenter2));
            copy.setAnalytics(channelsListFragment.getAnalytics());
            return copy;
        }
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory$messenger_release() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
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
    public final ChannelsListPresenter getChannelsListPresenter() {
        ChannelsListPresenter channelsListPresenter2 = this.channelsListPresenter;
        if (channelsListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelsListPresenter");
        }
        return channelsListPresenter2;
    }

    @NotNull
    public final RelativeDateFormatter getDateFormatter() {
        RelativeDateFormatter relativeDateFormatter = this.dateFormatter;
        if (relativeDateFormatter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateFormatter");
        }
        return relativeDateFormatter;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final ItemVisibilityTracker getItemVisibilityTracker() {
        ItemVisibilityTracker itemVisibilityTracker2 = this.itemVisibilityTracker;
        if (itemVisibilityTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemVisibilityTracker");
        }
        return itemVisibilityTracker2;
    }

    @NotNull
    public final ChannelsTracker getPerfTracker() {
        ChannelsTracker channelsTracker = this.perfTracker;
        if (channelsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("perfTracker");
        }
        return channelsTracker;
    }

    @NotNull
    public final ChannelsRouter getRouter() {
        ChannelsRouter channelsRouter = this.router;
        if (channelsRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        return channelsRouter;
    }

    @NotNull
    public final FpsStateSupplier getSupplier() {
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        return fpsStateSupplier;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.messenger_channels_list, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        this.d = viewGroup2;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) viewGroup2.findViewById(R.id.content_holder);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "contentHolder");
        frameLayout.setForeground(null);
        ViewGroup viewGroup3 = this.d;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        return viewGroup3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ChannelsListView channelsListView = this.e;
        if (channelsListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelsListView");
        }
        channelsListView.onDestroyView();
        Lifecycle lifecycle = getLifecycle();
        ChannelsListView channelsListView2 = this.e;
        if (channelsListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelsListView");
        }
        lifecycle.removeObserver(channelsListView2);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.f.clear();
        ChannelsListPresenter channelsListPresenter2 = this.channelsListPresenter;
        if (channelsListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelsListPresenter");
        }
        channelsListPresenter2.getChannelDeletedStream().removeObservers(getViewLifecycleOwner());
        ChannelsListPresenter channelsListPresenter3 = this.channelsListPresenter;
        if (channelsListPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelsListPresenter");
        }
        channelsListPresenter3.getErrorMessageStream().removeObservers(getViewLifecycleOwner());
        ChannelsTracker channelsTracker = this.perfTracker;
        if (channelsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("perfTracker");
        }
        channelsTracker.detach();
        ChannelsListPresenter channelsListPresenter4 = this.channelsListPresenter;
        if (channelsListPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelsListPresenter");
        }
        channelsListPresenter4.detach();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ChannelsTracker channelsTracker = this.perfTracker;
        if (channelsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("perfTracker");
        }
        channelsTracker.attach();
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        analytics2.track(new DisplayChannelsListEvent());
        getChannelsListPresenter().getChannelDeletedStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$$inlined$observeNotNull$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    ChannelsListFragment channelsListFragment = ChannelsListFragment.this;
                    String string = channelsListFragment.getResources().getString(R.string.channel_deleted);
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.channel_deleted)");
                    Context context = channelsListFragment.getContext();
                    if (context != null) {
                        ToastsKt.showToast(context, string, 0);
                    }
                }
            }
        });
        getChannelsListPresenter().getErrorMessageStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$$inlined$observeNotNull$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    Context context = ChannelsListFragment.this.getContext();
                    if (context != null) {
                        ToastsKt.showToast(context, t2, 0);
                    }
                }
            }
        });
        Disposable subscribe = getChannelsListPresenter().getStateObservable().observeOn(AndroidSchedulers.mainThread()).map(new Function<ChannelsListState, ChannelsListState>() { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$3
            /* JADX DEBUG: Multi-variable search result rejected for r11v1, resolved type: com.avito.android.messenger.channels.mvi.view.PinnedSupportChatItem */
            /* JADX DEBUG: Multi-variable search result rejected for r6v11, resolved type: com.avito.android.messenger.channels.mvi.view.ChannelListItem */
            /* JADX WARN: Multi-variable type inference failed */
            public final ChannelsListState apply(@NotNull ChannelsListState channelsListState) {
                Intrinsics.checkNotNullParameter(channelsListState, "state");
                List<AbstractListItem<?>> list = channelsListState.listItems;
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
                int i = 0;
                for (T t : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    T t2 = t;
                    ChannelsListFragment channelsListFragment = ChannelsListFragment.this;
                    if (t2 instanceof ChannelListItem) {
                        T t3 = t2;
                        ChannelListItem channelListItem = new ChannelListItem(t3.id, t3.isActive(), t3.getChatTitle(), t3.getItem(), t3.getFeatureImage(), t3.getDate(), t3.isOnline(), t3.getAvatar(), t3.getLastMessageType(), t3.getLastMessage(), t3.isTyping(), t3.getItemDeliveryStatus());
                        channelListItem.setDateFormatter(ChannelsListFragment.access$getDateFormatterFunction$p(channelsListFragment));
                        channelListItem.setLifecycleOwner(new WeakReference(channelsListFragment));
                        channelListItem.setHideSwipeViewsStream(channelsListFragment.h);
                        channelListItem.setItemClickListener(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0088: INVOKE  
                              (r6v11 'channelListItem' com.avito.android.messenger.channels.mvi.view.ChannelListItem)
                              (wrap: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$3$inject$$inlined$apply$lambda$1 : 0x0085: CONSTRUCTOR  (r7v6 com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$3$inject$$inlined$apply$lambda$1) = 
                              (r5v1 'channelsListFragment' com.avito.android.messenger.channels.mvi.view.ChannelsListFragment)
                              (r3v3 't2' T)
                              (r2v3 'i' int)
                             call: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$3$inject$$inlined$apply$lambda$1.<init>(com.avito.android.messenger.channels.mvi.view.ChannelsListFragment, com.avito.android.messenger.channels.mvi.view.AbstractListItem, int):void type: CONSTRUCTOR)
                             type: VIRTUAL call: com.avito.android.messenger.channels.mvi.view.ChannelListItem.setItemClickListener(kotlin.jvm.functions.Function0):void in method: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$3.apply(com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState):com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:220)
                            	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0085: CONSTRUCTOR  (r7v6 com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$3$inject$$inlined$apply$lambda$1) = 
                              (r5v1 'channelsListFragment' com.avito.android.messenger.channels.mvi.view.ChannelsListFragment)
                              (r3v3 't2' T)
                              (r2v3 'i' int)
                             call: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$3$inject$$inlined$apply$lambda$1.<init>(com.avito.android.messenger.channels.mvi.view.ChannelsListFragment, com.avito.android.messenger.channels.mvi.view.AbstractListItem, int):void type: CONSTRUCTOR in method: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$3.apply(com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState):com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                            	... 27 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$3$inject$$inlined$apply$lambda$1, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                            	... 33 more
                            */
                        /*
                        // Method dump skipped, instructions count: 304
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$3.apply(com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState):com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState");
                    }
                }).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ChannelsListState>() { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$4
                    public final void accept(ChannelsListState channelsListState) {
                        ChannelsListView access$getChannelsListView$p = ChannelsListFragment.access$getChannelsListView$p(ChannelsListFragment.this);
                        Intrinsics.checkNotNullExpressionValue(channelsListState, "state");
                        access$getChannelsListView$p.render(channelsListState);
                        StringBuilder sb = new StringBuilder();
                        StringBuilder I = a.I('[');
                        Thread currentThread = Thread.currentThread();
                        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                        I.append(currentThread.getName());
                        I.append(']');
                        sb.append(I.toString());
                        sb.append(" Rendered ");
                        sb.append(channelsListState);
                        Logs.info$default(ChannelsListFragment.TAG, sb.toString(), null, 4, null);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(subscribe, "channelsListPresenter.st…ed $state\")\n            }");
                DisposableKt.addTo(subscribe, this.f);
                Disposable subscribe2 = access$getChannelsListView$p(this).getOverlayRefreshClicks().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$5
                    public final void accept(Unit unit) {
                        ChannelsListFragment.this.getChannelsListPresenter().initialDataRequest(true);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(subscribe2, "channelsListView.overlay…try = true)\n            }");
                DisposableKt.addTo(subscribe2, this.f);
                Disposable subscribe3 = access$getChannelsListView$p(this).getSwipeRefreshes().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$6
                    public final void accept(Unit unit) {
                        ChannelsListFragment.this.getChannelsListPresenter().refresh();
                    }
                });
                Intrinsics.checkNotNullExpressionValue(subscribe3, "channelsListView.swipeRe…r.refresh()\n            }");
                DisposableKt.addTo(subscribe3, this.f);
                Disposable subscribe4 = access$getChannelsListView$p(this).getSnackbarRefreshClicks().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$7
                    public final void accept(Unit unit) {
                        ChannelsListFragment.this.getChannelsListPresenter().refresh();
                    }
                });
                Intrinsics.checkNotNullExpressionValue(subscribe4, "channelsListView.snackba…r.refresh()\n            }");
                DisposableKt.addTo(subscribe4, this.f);
                Disposable subscribe5 = access$getChannelsListView$p(this).getPaginationStream().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$8
                    public final void accept(Unit unit) {
                        ChannelsListFragment.this.getChannelsListPresenter().loadNextPage();
                    }
                });
                Intrinsics.checkNotNullExpressionValue(subscribe5, "channelsListView.paginat…dNextPage()\n            }");
                DisposableKt.addTo(subscribe5, this.f);
                Disposable subscribe6 = access$getChannelsListView$p(this).getScrollEvents().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment$bindChannelsList$9
                    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: androidx.lifecycle.MutableLiveData */
                    /* JADX WARN: Multi-variable type inference failed */
                    public final void accept(Unit unit) {
                        ChannelsListFragment.this.h.postValue(0);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(subscribe6, "channelsListView.scrollE…ostValue(0)\n            }");
                DisposableKt.addTo(subscribe6, this.f);
                ChannelsListPresenter channelsListPresenter2 = this.channelsListPresenter;
                if (channelsListPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channelsListPresenter");
                }
                channelsListPresenter2.attach();
            }

            @Override // androidx.fragment.app.Fragment
            public void onSaveInstanceState(@NotNull Bundle bundle) {
                Intrinsics.checkNotNullParameter(bundle, "outState");
                super.onSaveInstanceState(bundle);
                Features features2 = this.features;
                if (features2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("features");
                }
                if (features2.getViewVisibilityTrackingInChannels().invoke().booleanValue()) {
                    ItemVisibilityTracker itemVisibilityTracker2 = this.itemVisibilityTracker;
                    if (itemVisibilityTracker2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("itemVisibilityTracker");
                    }
                    bundle.putBundle("key_item_visibility_tracker_state", itemVisibilityTracker2.onSaveState());
                }
            }

            @Override // androidx.fragment.app.Fragment
            public void onStart() {
                super.onStart();
                Fragment parentFragment = getParentFragment();
                Objects.requireNonNull(parentFragment, "null cannot be cast to non-null type com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler.Host");
                ((ScrollToUpHandler.Host) parentFragment).setScrollToUpHandler(this);
                ChannelsListPresenter channelsListPresenter2 = this.channelsListPresenter;
                if (channelsListPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channelsListPresenter");
                }
                channelsListPresenter2.tryToUpdateAdBanner();
                ChannelsListPresenter channelsListPresenter3 = this.channelsListPresenter;
                if (channelsListPresenter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channelsListPresenter");
                }
                channelsListPresenter3.refreshNotificationBannerState();
            }

            @Override // androidx.fragment.app.Fragment
            public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
                Intrinsics.checkNotNullParameter(view, "view");
                Analytics analytics2 = this.analytics;
                if (analytics2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analytics");
                }
                ChannelsTracker channelsTracker = this.perfTracker;
                if (channelsTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("perfTracker");
                }
                Features features2 = this.features;
                if (features2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("features");
                }
                FpsStateSupplier fpsStateSupplier = this.supplier;
                if (fpsStateSupplier == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("supplier");
                }
                ItemVisibilityTracker itemVisibilityTracker2 = this.itemVisibilityTracker;
                if (itemVisibilityTracker2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemVisibilityTracker");
                }
                this.e = new ChannelsListViewImpl(view, analytics2, channelsTracker, features2, fpsStateSupplier, itemVisibilityTracker2);
                Lifecycle lifecycle = getLifecycle();
                ChannelsListView channelsListView = this.e;
                if (channelsListView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channelsListView");
                }
                lifecycle.addObserver(channelsListView);
                super.onViewCreated(view, bundle);
                ChannelsTracker channelsTracker2 = this.perfTracker;
                if (channelsTracker2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("perfTracker");
                }
                channelsTracker2.trackInit();
            }

            @Override // com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler
            public void scrollToUp() {
                ChannelsListView channelsListView = this.e;
                if (channelsListView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channelsListView");
                }
                channelsListView.scrollToUp();
            }

            public final void setActivityIntentFactory$messenger_release(@NotNull ActivityIntentFactory activityIntentFactory2) {
                Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
                this.activityIntentFactory = activityIntentFactory2;
            }

            public final void setAnalytics(@NotNull Analytics analytics2) {
                Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
                this.analytics = analytics2;
            }

            public final void setChannelsListPresenter(@NotNull ChannelsListPresenter channelsListPresenter2) {
                Intrinsics.checkNotNullParameter(channelsListPresenter2, "<set-?>");
                this.channelsListPresenter = channelsListPresenter2;
            }

            public final void setDateFormatter(@NotNull RelativeDateFormatter relativeDateFormatter) {
                Intrinsics.checkNotNullParameter(relativeDateFormatter, "<set-?>");
                this.dateFormatter = relativeDateFormatter;
            }

            public final void setFeatures(@NotNull Features features2) {
                Intrinsics.checkNotNullParameter(features2, "<set-?>");
                this.features = features2;
            }

            public final void setItemVisibilityTracker(@NotNull ItemVisibilityTracker itemVisibilityTracker2) {
                Intrinsics.checkNotNullParameter(itemVisibilityTracker2, "<set-?>");
                this.itemVisibilityTracker = itemVisibilityTracker2;
            }

            public final void setPerfTracker(@NotNull ChannelsTracker channelsTracker) {
                Intrinsics.checkNotNullParameter(channelsTracker, "<set-?>");
                this.perfTracker = channelsTracker;
            }

            public final void setRouter(@NotNull ChannelsRouter channelsRouter) {
                Intrinsics.checkNotNullParameter(channelsRouter, "<set-?>");
                this.router = channelsRouter;
            }

            public final void setSupplier(@NotNull FpsStateSupplier fpsStateSupplier) {
                Intrinsics.checkNotNullParameter(fpsStateSupplier, "<set-?>");
                this.supplier = fpsStateSupplier;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
                if (r5 != null) goto L_0x0042;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:46:0x0085, code lost:
                if (r8 != null) goto L_0x008e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a3, code lost:
                if (r9 != null) goto L_0x00ac;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
                if (r2 != null) goto L_0x0024;
             */
            @Override // com.avito.android.ui.fragments.BaseFragment
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean setUpFragmentComponent(@org.jetbrains.annotations.Nullable android.os.Bundle r22) {
                /*
                // Method dump skipped, instructions count: 363
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.view.ChannelsListFragment.setUpFragmentComponent(android.os.Bundle):boolean");
            }
        }
