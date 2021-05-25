package com.avito.android.profile.header;

import com.avito.android.analytics.Analytics;
import com.avito.android.notification_center.counter.NotificationCenterCounterInteractor;
import com.avito.android.profile.cards.UserProfileResourceProvider;
import com.avito.android.profile.header.ProfileHeaderPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.notification.NotificationsCount;
import com.avito.android.remote.model.user_profile.UserProfileResult;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBar;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u00104\u001a\u000201¢\u0006\u0004\b9\u0010:J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010$\u001a\u00020\u00028B@\u0002X\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010'\u001a\u00020\u00028B@\u0002X\u0002¢\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010#R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010*R\u001e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u0006;"}, d2 = {"Lcom/avito/android/profile/header/RootProfileHeaderPresenter;", "Lcom/avito/android/profile/header/ProfileHeaderPresenter;", "Lcom/avito/android/util/ActionMenu;", "action", "", "handleMenuActionClick", "(Lcom/avito/android/util/ActionMenu;)V", "", "Lcom/avito/android/remote/model/Action;", "actions", "", "sharingEnabled", "createMenuActions", "(Ljava/util/List;Z)Ljava/util/List;", "Lcom/avito/android/remote/model/user_profile/UserProfileResult;", "userProfile", "setup", "(Lcom/avito/android/remote/model/user_profile/UserProfileResult;)V", "Lru/avito/component/appbar/AppBar;", "view", "onViewAttached", "(Lru/avito/component/appbar/AppBar;)V", "onViewDetached", "()V", "onResume", AuthSource.BOOKING_ORDER, "j", "Lru/avito/component/appbar/AppBar;", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", "p", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", "notificationCenterCounterInteractor", "n", "Lkotlin/Lazy;", "getSettingsMenuAction", "()Lcom/avito/android/util/ActionMenu;", "settingsMenuAction", "o", AuthSource.SEND_ABUSE, "notificationMenuAction", "Lio/reactivex/rxjava3/disposables/Disposable;", "k", "Lio/reactivex/rxjava3/disposables/Disposable;", "shareClicksDisposable", "l", "notificationsDisposable", AuthSource.OPEN_CHANNEL_LIST, "Ljava/util/List;", "menuActions", "Lcom/avito/android/util/SchedulersFactory3;", VKApiConst.Q, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/profile/cards/UserProfileResourceProvider;", "resourceProvider", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/profile/cards/UserProfileResourceProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;Lcom/avito/android/util/SchedulersFactory3;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class RootProfileHeaderPresenter extends ProfileHeaderPresenter {
    public AppBar j;
    public Disposable k;
    public Disposable l;
    public List<ActionMenu> m;
    public final Lazy n;
    public final Lazy o;
    public final NotificationCenterCounterInteractor p;
    public final SchedulersFactory3 q;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<ActionMenu> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final ActionMenu invoke() {
            int i = this.a;
            if (i == 0) {
                return new ActionMenu(((UserProfileResourceProvider) this.b).notificationMenuTitle(), 1, Integer.valueOf(((UserProfileResourceProvider) this.b).notificationMenuIcon()), Integer.valueOf(((UserProfileResourceProvider) this.b).menuTintColorAttr()), null, 16, null);
            }
            if (i == 1) {
                return new ActionMenu(((UserProfileResourceProvider) this.b).settingsMenuTitle(), 2, Integer.valueOf(((UserProfileResourceProvider) this.b).settingsMenuIcon()), Integer.valueOf(((UserProfileResourceProvider) this.b).menuTintColorAttr()), null, 16, null);
            }
            throw null;
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ RootProfileHeaderPresenter a;

        public b(RootProfileHeaderPresenter rootProfileHeaderPresenter) {
            this.a = rootProfileHeaderPresenter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.onShareActionClicked();
        }
    }

    public static final class c<T> implements Consumer<NotificationsCount> {
        public final /* synthetic */ RootProfileHeaderPresenter a;

        public c(RootProfileHeaderPresenter rootProfileHeaderPresenter) {
            this.a = rootProfileHeaderPresenter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(NotificationsCount notificationsCount) {
            AppBar appBar;
            NotificationsCount notificationsCount2 = notificationsCount;
            List list = this.a.m;
            int indexOf = list != null ? list.indexOf(this.a.a()) : -1;
            if (indexOf != -1 && (appBar = this.a.j) != null) {
                RootProfileHeaderPresenter rootProfileHeaderPresenter = this.a;
                Intrinsics.checkNotNullExpressionValue(notificationsCount2, "it");
                int access$toNotificationIcon = RootProfileHeaderPresenter.access$toNotificationIcon(rootProfileHeaderPresenter, notificationsCount2, this.a.getResourceProvider());
                RootProfileHeaderPresenter rootProfileHeaderPresenter2 = this.a;
                appBar.setActionMenuItemIcon(indexOf, access$toNotificationIcon, RootProfileHeaderPresenter.access$toNotificationColor(rootProfileHeaderPresenter2, notificationsCount2, rootProfileHeaderPresenter2.getResourceProvider()));
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed on observe notification center", th);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public RootProfileHeaderPresenter(@NotNull UserProfileResourceProvider userProfileResourceProvider, @NotNull Analytics analytics, @NotNull NotificationCenterCounterInteractor notificationCenterCounterInteractor, @NotNull SchedulersFactory3 schedulersFactory3) {
        super(userProfileResourceProvider, analytics);
        Intrinsics.checkNotNullParameter(userProfileResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(notificationCenterCounterInteractor, "notificationCenterCounterInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.p = notificationCenterCounterInteractor;
        this.q = schedulersFactory3;
        this.n = t6.c.lazy(new a(1, userProfileResourceProvider));
        this.o = t6.c.lazy(new a(0, userProfileResourceProvider));
    }

    public static final Integer access$toNotificationColor(RootProfileHeaderPresenter rootProfileHeaderPresenter, NotificationsCount notificationsCount, UserProfileResourceProvider userProfileResourceProvider) {
        Objects.requireNonNull(rootProfileHeaderPresenter);
        if (notificationsCount.getUnread() == 0) {
            return Integer.valueOf(userProfileResourceProvider.menuTintColorAttr());
        }
        return null;
    }

    public static final int access$toNotificationIcon(RootProfileHeaderPresenter rootProfileHeaderPresenter, NotificationsCount notificationsCount, UserProfileResourceProvider userProfileResourceProvider) {
        Objects.requireNonNull(rootProfileHeaderPresenter);
        if (notificationsCount.getUnread() == 0) {
            return userProfileResourceProvider.notificationMenuIcon();
        }
        return userProfileResourceProvider.unreadNotificationMenuIcon();
    }

    public final ActionMenu a() {
        return (ActionMenu) this.o.getValue();
    }

    public final void b() {
        Disposable disposable = this.l;
        if (disposable != null) {
            disposable.dispose();
        }
        this.l = this.p.getCount().observeOn(this.q.mainThread()).subscribe(new c(this), d.a);
    }

    @Override // com.avito.android.profile.header.ProfileHeaderPresenter
    @NotNull
    public List<ActionMenu> createMenuActions(@NotNull List<Action> list, boolean z) {
        ArrayList i0 = a2.b.a.a.a.i0(list, "actions");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(convertActionToMenuAction(it.next()));
        }
        i0.addAll(arrayList);
        i0.add(a());
        i0.add((ActionMenu) this.n.getValue());
        this.m = i0;
        return i0;
    }

    @Override // com.avito.android.profile.header.ProfileHeaderPresenter
    public void handleMenuActionClick(@NotNull ActionMenu actionMenu) {
        ProfileHeaderPresenter.Router router;
        Intrinsics.checkNotNullParameter(actionMenu, "action");
        if (Intrinsics.areEqual(actionMenu, (ActionMenu) this.n.getValue())) {
            ProfileHeaderPresenter.Router router2 = getRouter();
            if (router2 != null) {
                router2.openSettings();
            }
        } else if (Intrinsics.areEqual(actionMenu, a()) && (router = getRouter()) != null) {
            router.openNotificationCenter();
        }
    }

    @Override // com.avito.android.profile.header.ProfileHeaderPresenter
    public void onResume() {
        b();
    }

    @Override // com.avito.android.profile.header.ProfileHeaderPresenter
    public void onViewAttached(@NotNull AppBar appBar) {
        Intrinsics.checkNotNullParameter(appBar, "view");
        this.j = appBar;
        this.k = appBar.navigationCallbacks().subscribe(new b(this));
    }

    @Override // com.avito.android.profile.header.ProfileHeaderPresenter
    public void onViewDetached() {
        Disposable disposable = this.k;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.l;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.j = null;
    }

    @Override // com.avito.android.profile.header.ProfileHeaderPresenter
    public void setup(@Nullable UserProfileResult userProfileResult) {
        AppBar appBar;
        super.setup(userProfileResult);
        if (!((userProfileResult != null ? userProfileResult.getSharing() : null) == null || (appBar = this.j) == null)) {
            appBar.setNavigationIcon(getResourceProvider().shareMenuIcon(), Integer.valueOf(getResourceProvider().menuTintColorAttr()));
        }
        b();
    }
}
