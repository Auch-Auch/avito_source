package com.avito.android.serp.adapter.onboarding;

import a2.a.a.n2.w.b.a;
import a2.g.r.g;
import android.os.Handler;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.tooltip.Tooltip;
import com.avito.android.lib.expected.badge_bar.BadgeView;
import com.avito.android.lib.expected.badge_bar.BadgeViewListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.remote.model.badge_bar.SerpBadgeBar;
import com.avito.android.remote.model.badge_bar.SerpBadgeType;
import com.avito.android.util.preferences.Preferences;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001UB+\b\u0007\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010?\u001a\u00020<\u0012\b\u0010R\u001a\u0004\u0018\u00010#¢\u0006\u0004\bS\u0010TJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R.\u00105\u001a\u001a\u0012\b\u0012\u000601R\u00020\u000000j\f\u0012\b\u0012\u000601R\u00020\u0000`28\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u0010.R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>RD\u0010E\u001a0\u0012\f\u0012\n A*\u0004\u0018\u00010\u00040\u0004 A*\u0017\u0012\f\u0012\n A*\u0004\u0018\u00010\u00040\u0004\u0018\u00010@¢\u0006\u0002\bB0@¢\u0006\u0002\bB8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010.R\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010.R\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006V"}, d2 = {"Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandlerImpl;", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "tooltipDetailsLinkClicks", "()Lio/reactivex/rxjava3/core/Observable;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "newState", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "recycler", "bindSerpRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;", "badgeBar", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "bindBadgeListenerToBadgeBar", "(Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;)Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "Landroid/view/View;", "view", "Lcom/avito/android/remote/model/badge_bar/SerpBadgeType;", "type", "deepLink", "onBadgeDataBounded", "(Landroid/view/View;Lcom/avito/android/remote/model/badge_bar/SerpBadgeType;Lcom/avito/android/deep_linking/links/DeepLink;)V", "unbind", "()V", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandlerState;", "onSaveState", "()Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandlerState;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "serpRecycler", "i", "Lio/reactivex/rxjava3/core/Observable;", "deepLinkClicks", "", AuthSource.SEND_ABUSE, "Z", "hasOnboardingBeenShown", "Ljava/util/ArrayList;", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandlerImpl$OnboardingTarget;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "targets", "d", "isOwnerShownNumberExceeded", "Lcom/avito/android/serp/adapter/onboarding/SerpBadgeResourceProvider;", "j", "Lcom/avito/android/serp/adapter/onboarding/SerpBadgeResourceProvider;", "resourcesProvider", "Lcom/avito/android/Features;", "l", "Lcom/avito/android/Features;", "features", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "h", "Lcom/jakewharton/rxrelay3/PublishRelay;", "deepLinkClickRelay", "c", "isImvShownNumberExceeded", "Lcom/avito/android/util/preferences/Preferences;", "k", "Lcom/avito/android/util/preferences/Preferences;", "preferences", AuthSource.BOOKING_ORDER, "hasRecyclerBeenScrolled", "Lcom/avito/android/lib/design/tooltip/Tooltip;", g.a, "Lcom/avito/android/lib/design/tooltip/Tooltip;", "tooltip", "state", "<init>", "(Lcom/avito/android/serp/adapter/onboarding/SerpBadgeResourceProvider;Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/Features;Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandlerState;)V", "OnboardingTarget", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpOnboardingHandlerImpl extends RecyclerView.OnScrollListener implements SerpOnboardingHandler {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public RecyclerView e;
    public final ArrayList<OnboardingTarget> f = new ArrayList<>();
    public Tooltip g;
    public final PublishRelay<DeepLink> h;
    public final Observable<DeepLink> i;
    public final SerpBadgeResourceProvider j;
    public final Preferences k;
    public final Features l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandlerImpl$OnboardingTarget;", "", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Lcom/avito/android/deep_linking/links/DeepLink;", "c", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/remote/model/badge_bar/SerpBadgeType;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/badge_bar/SerpBadgeType;", "getType", "()Lcom/avito/android/remote/model/badge_bar/SerpBadgeType;", "type", "<init>", "(Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandlerImpl;Landroid/view/View;Lcom/avito/android/remote/model/badge_bar/SerpBadgeType;Lcom/avito/android/deep_linking/links/DeepLink;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public final class OnboardingTarget {
        @NotNull
        public final View a;
        @NotNull
        public final SerpBadgeType b;
        @Nullable
        public final DeepLink c;

        public OnboardingTarget(@NotNull SerpOnboardingHandlerImpl serpOnboardingHandlerImpl, @NotNull View view, @Nullable SerpBadgeType serpBadgeType, DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(serpBadgeType, "type");
            this.a = view;
            this.b = serpBadgeType;
            this.c = deepLink;
        }

        @Nullable
        public final DeepLink getDeepLink() {
            return this.c;
        }

        @NotNull
        public final SerpBadgeType getType() {
            return this.b;
        }

        @NotNull
        public final View getView() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            SerpBadgeType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            SerpBadgeType serpBadgeType = SerpBadgeType.IMV_GOOD_PRICE;
            iArr[0] = 1;
            SerpBadgeType serpBadgeType2 = SerpBadgeType.IMV_GREAT_PRICE;
            iArr[1] = 2;
            SerpBadgeType serpBadgeType3 = SerpBadgeType.CAR_OWNER;
            iArr[2] = 3;
            SerpBadgeType.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
            iArr2[2] = 3;
        }
    }

    @Inject
    public SerpOnboardingHandlerImpl(@NotNull SerpBadgeResourceProvider serpBadgeResourceProvider, @NotNull Preferences preferences, @NotNull Features features, @Nullable SerpOnboardingHandlerState serpOnboardingHandlerState) {
        Intrinsics.checkNotNullParameter(serpBadgeResourceProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(features, "features");
        this.j = serpBadgeResourceProvider;
        this.k = preferences;
        this.l = features;
        PublishRelay<DeepLink> create = PublishRelay.create();
        this.h = create;
        Observable<DeepLink> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "deepLinkClickRelay.hide()");
        this.i = hide;
        boolean z = false;
        this.a = serpOnboardingHandlerState != null ? serpOnboardingHandlerState.getHasOnboardingBeenShown() : false;
        this.b = serpOnboardingHandlerState != null ? serpOnboardingHandlerState.getHasRecyclerBeenScrolled() : false;
        this.c = preferences.getInt("KEY_SERP_BADGE_ONBOARDING_IMV_SHOWS_COUNT", 0) >= 3;
        this.d = preferences.getInt("KEY_SERP_BADGE_ONBOARDING_OWNER_SHOWS_COUNT", 0) >= 3 ? true : z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x004e A[EDGE_INSN: B:38:0x004e->B:17:0x004e ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$findTargetAndShowOnboarding(com.avito.android.serp.adapter.onboarding.SerpOnboardingHandlerImpl r14) {
        /*
        // Method dump skipped, instructions count: 260
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.adapter.onboarding.SerpOnboardingHandlerImpl.access$findTargetAndShowOnboarding(com.avito.android.serp.adapter.onboarding.SerpOnboardingHandlerImpl):void");
    }

    @Override // com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler
    @Nullable
    public BadgeViewListener bindBadgeListenerToBadgeBar(@Nullable SerpBadgeBar serpBadgeBar) {
        List<SerpBadge> badges;
        int ordinal;
        T t = null;
        if (this.a || this.b || serpBadgeBar == null || (badges = serpBadgeBar.getBadges()) == null || badges.isEmpty()) {
            return null;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        Iterator<T> it = badges.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            SerpBadgeType type = next.getType();
            boolean z = false;
            if (type != null && ((ordinal = type.ordinal()) == 0 || ordinal == 1 ? !(!this.l.getImvBadgeOnboardingOnSerp().invoke().booleanValue() || !(!this.c)) : !(ordinal != 2 || !this.l.getCarOwnerBadgeOnboardingOnSerp().invoke().booleanValue() || !(!this.d)))) {
                z = true;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            t2.setShouldShowOnboarding(true);
            objectRef.element = (T) new BadgeViewListener(t2, this, objectRef) { // from class: com.avito.android.serp.adapter.onboarding.SerpOnboardingHandlerImpl$bindBadgeListenerToBadgeBar$$inlined$let$lambda$1
                public final /* synthetic */ SerpBadge a;
                public final /* synthetic */ SerpOnboardingHandlerImpl b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // com.avito.android.lib.expected.badge_bar.BadgeViewListener
                public void onBadgeDataBounded(@NotNull BadgeView badgeView) {
                    Intrinsics.checkNotNullParameter(badgeView, "badge");
                    SerpOnboardingHandlerImpl serpOnboardingHandlerImpl = this.b;
                    SerpBadgeType type2 = this.a.getType();
                    Intrinsics.checkNotNull(type2);
                    serpOnboardingHandlerImpl.onBadgeDataBounded(badgeView, type2, this.a.getDeeplink());
                }
            };
        }
        return objectRef.element;
    }

    @Override // com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler
    public void bindSerpRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recycler");
        RecyclerView recyclerView2 = this.e;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this);
        }
        this.e = recyclerView;
        recyclerView.addOnScrollListener(this);
    }

    @Override // com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler
    public void onBadgeDataBounded(@NotNull View view, @NotNull SerpBadgeType serpBadgeType, @Nullable DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(serpBadgeType, "type");
        this.f.add(new OnboardingTarget(this, view, serpBadgeType, deepLink));
    }

    @Override // com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler
    @NotNull
    public SerpOnboardingHandlerState onSaveState() {
        return new SerpOnboardingHandlerState(this.a, this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.b = true;
        unbind();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i2, int i3) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (i3 == 0 && (!this.b)) {
            new Handler().postDelayed(new a(this), 300);
        }
    }

    @Override // com.avito.android.serp.adapter.onboarding.SerpOnboardingTooltipEventsProducer
    @NotNull
    public Observable<DeepLink> tooltipDetailsLinkClicks() {
        return this.i;
    }

    @Override // com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler
    public void unbind() {
        Tooltip tooltip = this.g;
        if (tooltip != null) {
            tooltip.dismiss();
        }
        this.g = null;
        this.f.clear();
        RecyclerView recyclerView = this.e;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this);
        }
        this.e = null;
    }
}
