package com.avito.android.profile.header;

import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.profile.cards.UserProfileResourceProvider;
import com.avito.android.public_profile.analytics.event.ProfileShareEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Sharing;
import com.avito.android.util.ActionMenu;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBar;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001LB\u0017\u0012\u0006\u00103\u001a\u00020.\u0012\u0006\u00109\u001a\u000206¢\u0006\u0004\bJ\u0010KJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\fJ\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\fJ\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001f\u001a\u00020\u001eH$¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H$¢\u0006\u0004\b\"\u0010\u0015J\u000f\u0010#\u001a\u00020\u0004H$¢\u0006\u0004\b#\u0010\fJ\u000f\u0010$\u001a\u00020\u0004H\u0004¢\u0006\u0004\b$\u0010\fJ\u0017\u0010%\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001cH\u0004¢\u0006\u0004\b%\u0010&R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010\u0010R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b,\u0010-R\u001c\u00103\u001a\u00020.8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001d\u0010>\u001a\u00020\u00178D@\u0004X\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010-R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR$\u0010I\u001a\u0010\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F\u0018\u00010E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006M"}, d2 = {"Lcom/avito/android/profile/header/ProfileHeaderPresenter;", "", "Lcom/avito/android/remote/model/user_profile/UserProfileResult;", "userProfile", "", "setup", "(Lcom/avito/android/remote/model/user_profile/UserProfileResult;)V", "", VKApiConst.POSITION, "onActionClicked", "(I)V", "onResume", "()V", "Lcom/avito/android/profile/header/ProfileHeaderPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/profile/header/ProfileHeaderPresenter$Router;)V", "detachRouter", "Lru/avito/component/appbar/AppBar;", "view", "attachView", "(Lru/avito/component/appbar/AppBar;)V", "detachView", "Lcom/avito/android/util/ActionMenu;", "action", "handleMenuActionClick", "(Lcom/avito/android/util/ActionMenu;)V", "", "Lcom/avito/android/remote/model/Action;", "actions", "", "sharingEnabled", "createMenuActions", "(Ljava/util/List;Z)Ljava/util/List;", "onViewAttached", "onViewDetached", "onShareActionClicked", "convertActionToMenuAction", "(Lcom/avito/android/remote/model/Action;)Lcom/avito/android/util/ActionMenu;", AuthSource.SEND_ABUSE, "Lcom/avito/android/profile/header/ProfileHeaderPresenter$Router;", "getRouter", "()Lcom/avito/android/profile/header/ProfileHeaderPresenter$Router;", "setRouter", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "Lcom/avito/android/profile/cards/UserProfileResourceProvider;", "h", "Lcom/avito/android/profile/cards/UserProfileResourceProvider;", "getResourceProvider", "()Lcom/avito/android/profile/cards/UserProfileResourceProvider;", "resourceProvider", "d", "Lru/avito/component/appbar/AppBar;", "Lcom/avito/android/analytics/Analytics;", "i", "Lcom/avito/android/analytics/Analytics;", "analytics", g.a, "Lkotlin/Lazy;", "getShareMenuAction", "()Lcom/avito/android/util/ActionMenu;", "shareMenuAction", "c", "menuActions", "Lcom/avito/android/remote/model/Sharing;", "f", "Lcom/avito/android/remote/model/Sharing;", "sharingModel", "", "", "e", "Ljava/util/Map;", "analyticsEvents", "<init>", "(Lcom/avito/android/profile/cards/UserProfileResourceProvider;Lcom/avito/android/analytics/Analytics;)V", "Router", "profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class ProfileHeaderPresenter {
    @Nullable
    public Router a;
    public List<Action> b;
    public List<ActionMenu> c;
    public AppBar d;
    public Map<String, String> e;
    public Sharing f;
    @NotNull
    public final Lazy g = c.lazy(new a(this));
    @NotNull
    public final UserProfileResourceProvider h;
    public final Analytics i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/profile/header/ProfileHeaderPresenter$Router;", "", "", "title", "text", "", "openShareDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "openSettings", "()V", "openNotificationCenter", "onBackPressed", "profile_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followDeepLink(@NotNull DeepLink deepLink);

        void onBackPressed();

        void openNotificationCenter();

        void openSettings();

        void openShareDialog(@NotNull String str, @NotNull String str2);
    }

    public static final class a extends Lambda implements Function0<ActionMenu> {
        public final /* synthetic */ ProfileHeaderPresenter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ProfileHeaderPresenter profileHeaderPresenter) {
            super(0);
            this.a = profileHeaderPresenter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ActionMenu invoke() {
            return new ActionMenu(this.a.getResourceProvider().shareMenuTitle(), 2, Integer.valueOf(this.a.getResourceProvider().shareMenuIcon()), Integer.valueOf(this.a.getResourceProvider().menuTintColorAttr()), null, 16, null);
        }
    }

    public ProfileHeaderPresenter(@NotNull UserProfileResourceProvider userProfileResourceProvider, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(userProfileResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.h = userProfileResourceProvider;
        this.i = analytics;
    }

    public final void attachRouter(@NotNull Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.a = router;
    }

    public final void attachView(@NotNull AppBar appBar) {
        Intrinsics.checkNotNullParameter(appBar, "view");
        this.d = appBar;
        onViewAttached(appBar);
    }

    @NotNull
    public final ActionMenu convertActionToMenuAction(@NotNull Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return new ActionMenu(action.getTitle(), 0, null, null, null, 28, null);
    }

    @NotNull
    public abstract List<ActionMenu> createMenuActions(@NotNull List<Action> list, boolean z);

    public final void detachRouter() {
        this.a = null;
    }

    public final void detachView() {
        this.d = null;
        onViewDetached();
    }

    @NotNull
    public final UserProfileResourceProvider getResourceProvider() {
        return this.h;
    }

    @Nullable
    public final Router getRouter() {
        return this.a;
    }

    @NotNull
    public final ActionMenu getShareMenuAction() {
        return (ActionMenu) this.g.getValue();
    }

    public abstract void handleMenuActionClick(@NotNull ActionMenu actionMenu);

    public final void onActionClicked(int i2) {
        List<ActionMenu> list = this.c;
        if (list != null) {
            int size = list.size();
            List<Action> list2 = this.b;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actions");
            }
            int size2 = size - list2.size();
            if (i2 < size2) {
                handleMenuActionClick(list.get(i2));
                return;
            }
            List<Action> list3 = this.b;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actions");
            }
            Action action = list3.get(i2 - size2);
            Router router = this.a;
            if (router != null) {
                router.followDeepLink(action.getDeepLink());
            }
        }
    }

    public abstract void onResume();

    public final void onShareActionClicked() {
        String str;
        Router router;
        Sharing sharing = this.f;
        if (!(sharing == null || (router = this.a) == null)) {
            router.openShareDialog(sharing.getTitle(), sharing.getText());
        }
        Map<String, String> map = this.e;
        if (map != null && (str = map.get("sharing")) != null) {
            this.i.track(new ProfileShareEvent(str));
        }
    }

    public abstract void onViewAttached(@NotNull AppBar appBar);

    public abstract void onViewDetached();

    public final void setRouter(@Nullable Router router) {
        this.a = router;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0045 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.avito.android.profile.header.ProfileHeaderPresenter] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.avito.android.remote.model.Action>, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setup(@org.jetbrains.annotations.Nullable com.avito.android.remote.model.user_profile.UserProfileResult r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0008
            com.avito.android.remote.model.Sharing r1 = r6.getSharing()
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            r5.f = r1
            if (r6 == 0) goto L_0x0012
            java.util.Map r1 = r6.getAnalytics()
            goto L_0x0013
        L_0x0012:
            r1 = r0
        L_0x0013:
            r5.e = r1
            if (r6 == 0) goto L_0x001c
            java.util.List r1 = r6.getActions()
            goto L_0x001d
        L_0x001c:
            r1 = r0
        L_0x001d:
            if (r1 == 0) goto L_0x0041
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x0028:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0045
            java.lang.Object r3 = r1.next()
            r4 = r3
            com.avito.android.remote.model.Action r4 = (com.avito.android.remote.model.Action) r4
            com.avito.android.deep_linking.links.DeepLink r4 = r4.getDeepLink()
            boolean r4 = r4 instanceof com.avito.android.deep_linking.links.NoMatchLink
            if (r4 != 0) goto L_0x0028
            r2.add(r3)
            goto L_0x0028
        L_0x0041:
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0045:
            r5.b = r2
            if (r2 != 0) goto L_0x004e
            java.lang.String r1 = "actions"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x004e:
            if (r6 == 0) goto L_0x0054
            com.avito.android.remote.model.Sharing r0 = r6.getSharing()
        L_0x0054:
            r6 = 1
            if (r0 == 0) goto L_0x0059
            r0 = 1
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            java.util.List r0 = r5.createMenuActions(r2, r0)
            boolean r1 = r0.isEmpty()
            r6 = r6 ^ r1
            if (r6 == 0) goto L_0x006c
            ru.avito.component.appbar.AppBar r6 = r5.d
            if (r6 == 0) goto L_0x006c
            r6.showActionsMenu(r0)
        L_0x006c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r5.c = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.profile.header.ProfileHeaderPresenter.setup(com.avito.android.remote.model.user_profile.UserProfileResult):void");
    }
}
