package com.avito.android.messenger.channels.mvi.view.banneritems;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.view.AbstractListItem;
import com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.ad.BannerInfoContainer;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiUserFull;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.viewholders.FlexibleViewHolder;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.rambler.libs.swipe_layout.SwipeLayout;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002DEB\u0017\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010\"\u001a\u00020\u001d¢\u0006\u0004\bB\u0010CJ9\u0010\r\u001a\u00020\f2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u000f\u001a\u00020\f2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0000H&¢\u0006\u0004\b\u0014\u0010\u0015R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00168\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\u00020\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R(\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R4\u00103\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R(\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0007098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006F"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "Lcom/avito/android/messenger/channels/mvi/view/AbstractListItem;", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;", "Lcom/avito/android/serp/ad/BannerInfoContainer;", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "holder", "", VKApiConst.POSITION, "", "", "payloads", "", "bindViewHolder", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;ILjava/util/List;)V", "bindAd", "onAdOpened", "(I)V", "onAdClosed", "()V", "copy", "()Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "Lkotlin/Function0;", "closeListener", "Lkotlin/jvm/functions/Function0;", "getCloseListener", "()Lkotlin/jvm/functions/Function0;", "setCloseListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/serp/ad/BannerInfo;", "f", "Lcom/avito/android/serp/ad/BannerInfo;", "getBannerInfo", "()Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "Ljava/lang/ref/WeakReference;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Ljava/lang/ref/WeakReference;", "getLifecycleOwner", "()Ljava/lang/ref/WeakReference;", "setLifecycleOwner", "(Ljava/lang/ref/WeakReference;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lkotlin/Function2;", "openListener", "Lkotlin/jvm/functions/Function2;", "getOpenListener", "()Lkotlin/jvm/functions/Function2;", "setOpenListener", "(Lkotlin/jvm/functions/Function2;)V", "Landroidx/lifecycle/MutableLiveData;", "hideSwipeViewsStream", "Landroidx/lifecycle/MutableLiveData;", "getHideSwipeViewsStream", "()Landroidx/lifecycle/MutableLiveData;", "setHideSwipeViewsStream", "(Landroidx/lifecycle/MutableLiveData;)V", "", "id", "<init>", "(Ljava/lang/String;Lcom/avito/android/serp/ad/BannerInfo;)V", "Companion", "ViewHolder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class ChannelListAdBannerItem extends AbstractListItem<ViewHolder> implements BannerInfoContainer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public Analytics analytics;
    public Function0<Unit> closeListener;
    @NotNull
    public final BannerInfo f;
    public MutableLiveData<Integer> hideSwipeViewsStream;
    public WeakReference<LifecycleOwner> lifecycleOwner;
    public Function2<? super BannerInfo, ? super Integer, Unit> openListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$Companion;", "", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, "Landroid/view/ViewGroup;", "createSwipableContainer", "(Landroid/view/View;)Landroid/view/ViewGroup;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ViewGroup createSwipableContainer(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, VKApiUserFull.RelativeType.CHILD);
            Context context = view.getContext();
            SwipeLayout swipeLayout = new SwipeLayout(context);
            swipeLayout.setId(R.id.swipe_layout);
            swipeLayout.setClickable(true);
            swipeLayout.setFocusable(true);
            swipeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            view.setLayoutParams(new SwipeLayout.LayoutParams(-1, -2));
            swipeLayout.addView(view);
            LayoutInflater.from(context).inflate(R.layout.chat_list_ad_banner_right_view, (ViewGroup) swipeLayout, true);
            return swipeLayout;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\u001f¢\u0006\u0004\b!\u0010\"R\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\b8F@\u0006X\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u00020\u00138F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006#"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "", "x", "Lkotlin/Lazy;", "getHash", "()I", "hash", "Landroid/widget/Button;", "y", "getCloseButton", "()Landroid/widget/Button;", "closeButton", "Landroidx/lifecycle/Observer;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroidx/lifecycle/Observer;", "getHideSwipeViewsStreamObserver", "()Landroidx/lifecycle/Observer;", "hideSwipeViewsStreamObserver", "Lru/rambler/libs/swipe_layout/SwipeLayout;", "w", "getSwipeLayout", "()Lru/rambler/libs/swipe_layout/SwipeLayout;", "swipeLayout", "Ljava/lang/ref/WeakReference;", "Landroid/animation/ObjectAnimator;", "z", "Ljava/lang/ref/WeakReference;", "animatorReference", "Landroid/view/View;", "view", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "<init>", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewHolder extends FlexibleViewHolder {
        @NotNull
        public final Observer<Integer> A;
        @NotNull
        public final Lazy w;
        @NotNull
        public final Lazy x = t6.c.lazy(new b(this));
        @NotNull
        public final Lazy y;
        public WeakReference<ObjectAnimator> z;

        public static final class a extends Lambda implements Function0<Button> {
            public final /* synthetic */ View a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(View view) {
                super(0);
                this.a = view;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Button invoke() {
                return (Button) this.a.findViewById(R.id.chat_list_banner_element_close_button);
            }
        }

        public static final class b extends Lambda implements Function0<Integer> {
            public final /* synthetic */ ViewHolder a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(ViewHolder viewHolder) {
                super(0);
                this.a = viewHolder;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Integer invoke() {
                return Integer.valueOf(this.a.getSwipeLayout().hashCode());
            }
        }

        public static final class c<T> implements Observer<Integer> {
            public final /* synthetic */ ViewHolder a;

            public c(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // androidx.lifecycle.Observer
            public void onChanged(Integer num) {
                Integer num2 = num;
                int hash = this.a.getHash();
                if ((num2 == null || hash != num2.intValue()) && this.a.getSwipeLayout().getOffset() != 0) {
                    ViewHolder viewHolder = this.a;
                    ObjectAnimator objectAnimator = (ObjectAnimator) viewHolder.z.get();
                    if (objectAnimator != null) {
                        viewHolder.z.clear();
                        if (objectAnimator.isRunning()) {
                            objectAnimator.end();
                        }
                    }
                    ObjectAnimator objectAnimator2 = new ObjectAnimator();
                    objectAnimator2.setTarget(viewHolder.getSwipeLayout());
                    objectAnimator2.setPropertyName("offset");
                    objectAnimator2.setInterpolator(new AccelerateInterpolator());
                    objectAnimator2.setIntValues(viewHolder.getSwipeLayout().getOffset(), 0);
                    objectAnimator2.setDuration(200L);
                    objectAnimator2.start();
                    viewHolder.z = new WeakReference(objectAnimator2);
                }
            }
        }

        public static final class d extends Lambda implements Function0<SwipeLayout> {
            public final /* synthetic */ View a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(View view) {
                super(0);
                this.a = view;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public SwipeLayout invoke() {
                return (SwipeLayout) this.a.findViewById(R.id.swipe_layout);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter) {
            super(view, flexibleAdapter);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
            this.w = t6.c.lazy(new d(view));
            this.y = t6.c.lazy(new a(view));
            this.z = new WeakReference<>(null);
            this.A = new c(this);
        }

        public static final void access$animateCloseSwipeView(ViewHolder viewHolder) {
            Objects.requireNonNull(viewHolder);
            ObjectAnimator objectAnimator = (ObjectAnimator) viewHolder.z.get();
            if (objectAnimator != null) {
                viewHolder.z.clear();
                if (objectAnimator.isRunning()) {
                    objectAnimator.end();
                }
            }
            ObjectAnimator objectAnimator2 = new ObjectAnimator();
            objectAnimator2.setTarget(viewHolder.getSwipeLayout());
            objectAnimator2.setPropertyName("offset");
            objectAnimator2.setInterpolator(new AccelerateInterpolator());
            objectAnimator2.setIntValues(viewHolder.getSwipeLayout().getOffset(), 0);
            objectAnimator2.setDuration(200L);
            objectAnimator2.start();
            Unit unit = Unit.INSTANCE;
            viewHolder.z = new WeakReference(objectAnimator2);
        }

        public static final void access$finishAnimator(ViewHolder viewHolder) {
            Objects.requireNonNull(viewHolder);
            ObjectAnimator objectAnimator = (ObjectAnimator) viewHolder.z.get();
            if (objectAnimator != null) {
                viewHolder.z.clear();
                if (objectAnimator.isRunning()) {
                    objectAnimator.end();
                }
            }
        }

        @NotNull
        public final Button getCloseButton() {
            return (Button) this.y.getValue();
        }

        public final int getHash() {
            return ((Number) this.x.getValue()).intValue();
        }

        @NotNull
        public final Observer<Integer> getHideSwipeViewsStreamObserver() {
            return this.A;
        }

        @NotNull
        public final SwipeLayout getSwipeLayout() {
            return (SwipeLayout) this.w.getValue();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelListAdBannerItem(@NotNull String str, @NotNull BannerInfo bannerInfo) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        this.f = bannerInfo;
    }

    public abstract void bindAd(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull ViewHolder viewHolder, int i, @NotNull List<? extends Object> list);

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ void bindViewHolder(FlexibleAdapter flexibleAdapter, RecyclerView.ViewHolder viewHolder, int i, List list) {
        bindViewHolder((FlexibleAdapter<?>) flexibleAdapter, (ViewHolder) viewHolder, i, (List<? extends Object>) list);
    }

    @NotNull
    public abstract ChannelListAdBannerItem copy();

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @Override // com.avito.android.serp.ad.BannerInfoContainer
    @NotNull
    public BannerInfo getBannerInfo() {
        return this.f;
    }

    @NotNull
    public final Function0<Unit> getCloseListener() {
        Function0<Unit> function0 = this.closeListener;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeListener");
        }
        return function0;
    }

    @NotNull
    public final MutableLiveData<Integer> getHideSwipeViewsStream() {
        MutableLiveData<Integer> mutableLiveData = this.hideSwipeViewsStream;
        if (mutableLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hideSwipeViewsStream");
        }
        return mutableLiveData;
    }

    @NotNull
    public final WeakReference<LifecycleOwner> getLifecycleOwner() {
        WeakReference<LifecycleOwner> weakReference = this.lifecycleOwner;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        }
        return weakReference;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super com.avito.android.serp.ad.BannerInfo, ? super java.lang.Integer, kotlin.Unit>, kotlin.jvm.functions.Function2<com.avito.android.serp.ad.BannerInfo, java.lang.Integer, kotlin.Unit> */
    @NotNull
    public final Function2<BannerInfo, Integer, Unit> getOpenListener() {
        Function2 function2 = this.openListener;
        if (function2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("openListener");
        }
        return function2;
    }

    @Override // com.avito.android.serp.ad.BannerInfoContainer, com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item
    public long getTrackId() {
        return BannerInfoContainer.DefaultImpls.getTrackId(this);
    }

    public final void onAdClosed() {
        MutableLiveData<Integer> mutableLiveData = this.hideSwipeViewsStream;
        if (mutableLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hideSwipeViewsStream");
        }
        mutableLiveData.postValue(0);
        Function0<Unit> function0 = this.closeListener;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeListener");
        }
        function0.invoke();
    }

    public final void onAdOpened(int i) {
        MutableLiveData<Integer> mutableLiveData = this.hideSwipeViewsStream;
        if (mutableLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hideSwipeViewsStream");
        }
        mutableLiveData.postValue(0);
        Function2<? super BannerInfo, ? super Integer, Unit> function2 = this.openListener;
        if (function2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("openListener");
        }
        function2.invoke(getBannerInfo(), Integer.valueOf(i));
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setCloseListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.closeListener = function0;
    }

    public final void setHideSwipeViewsStream(@NotNull MutableLiveData<Integer> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.hideSwipeViewsStream = mutableLiveData;
    }

    public final void setLifecycleOwner(@NotNull WeakReference<LifecycleOwner> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.lifecycleOwner = weakReference;
    }

    public final void setOpenListener(@NotNull Function2<? super BannerInfo, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.openListener = function2;
    }

    public void bindViewHolder(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull ViewHolder viewHolder, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        bindAd(flexibleAdapter, viewHolder, i, list);
        WeakReference<LifecycleOwner> weakReference = this.lifecycleOwner;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        }
        LifecycleOwner lifecycleOwner2 = weakReference.get();
        if (lifecycleOwner2 != null) {
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "lifecycleOwner");
            MutableLiveData<Integer> mutableLiveData = this.hideSwipeViewsStream;
            if (mutableLiveData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hideSwipeViewsStream");
            }
            mutableLiveData.removeObserver(viewHolder.getHideSwipeViewsStreamObserver());
            MutableLiveData<Integer> mutableLiveData2 = this.hideSwipeViewsStream;
            if (mutableLiveData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hideSwipeViewsStream");
            }
            mutableLiveData2.observe(lifecycleOwner2, viewHolder.getHideSwipeViewsStreamObserver());
            viewHolder.getSwipeLayout().setOnSwipeListener(new SwipeLayout.OnSwipeListener(this, lifecycleOwner2) { // from class: com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem$bindViewHolder$$inlined$apply$lambda$1
                public final /* synthetic */ ChannelListAdBannerItem b;
                public final /* synthetic */ LifecycleOwner c;

                {
                    this.b = r2;
                    this.c = r3;
                }

                @Override // ru.rambler.libs.swipe_layout.SwipeLayout.OnSwipeListener
                public void onBeginSwipe(@Nullable SwipeLayout swipeLayout, boolean z) {
                    this.b.getHideSwipeViewsStream().postValue(Integer.valueOf(ChannelListAdBannerItem.ViewHolder.this.getHash()));
                }

                @Override // ru.rambler.libs.swipe_layout.SwipeLayout.OnSwipeListener
                public void onLeftStickyEdge(@Nullable SwipeLayout swipeLayout, boolean z) {
                }

                @Override // ru.rambler.libs.swipe_layout.SwipeLayout.OnSwipeListener
                public void onRightStickyEdge(@Nullable SwipeLayout swipeLayout, boolean z) {
                }

                @Override // ru.rambler.libs.swipe_layout.SwipeLayout.OnSwipeListener
                public void onSwipeClampReached(@Nullable SwipeLayout swipeLayout, boolean z) {
                }
            });
        }
    }
}
