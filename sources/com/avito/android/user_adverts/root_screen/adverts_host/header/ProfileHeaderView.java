package com.avito.android.user_adverts.root_screen.adverts_host.header;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ProfileInfo;
import com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.ProfileHeaderMenuPanelView;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/ProfileHeaderMenuPanelView;", "", "isVisible", "", "showItemsSearch", "(Z)V", "Lcom/avito/android/remote/model/ProfileInfo;", "info", "setProfileInfo", "(Lcom/avito/android/remote/model/ProfileInfo;)V", "", "unreadCount", "updateNotificationCounter", "(I)V", "isInitialized", "()Z", "Lio/reactivex/Observable;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "getClicks", "()Lio/reactivex/Observable;", "clicks", "ClickTarget", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileHeaderView extends ProfileHeaderMenuPanelView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "", "<init>", "()V", "CloseSmbOnboarding", "CloseSoaOnboarding", "Notifications", "Orders", "Profile", "SOAInfo", "Search", "Settings", "SmbStats", "StartPublish", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$Profile;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$Settings;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$Notifications;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$StartPublish;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$SOAInfo;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$SmbStats;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$Orders;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$Search;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$CloseSoaOnboarding;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$CloseSmbOnboarding;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ClickTarget {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$CloseSmbOnboarding;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class CloseSmbOnboarding extends ClickTarget {
            @NotNull
            public static final CloseSmbOnboarding INSTANCE = new CloseSmbOnboarding();

            public CloseSmbOnboarding() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$CloseSoaOnboarding;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class CloseSoaOnboarding extends ClickTarget {
            @NotNull
            public static final CloseSoaOnboarding INSTANCE = new CloseSoaOnboarding();

            public CloseSoaOnboarding() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$Notifications;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class Notifications extends ClickTarget {
            @NotNull
            public static final Notifications INSTANCE = new Notifications();

            public Notifications() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$Orders;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component1", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "copy", "(Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$Orders;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class Orders extends ClickTarget {
            @NotNull
            public final DeepLink a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Orders(@NotNull DeepLink deepLink) {
                super(null);
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                this.a = deepLink;
            }

            public static /* synthetic */ Orders copy$default(Orders orders, DeepLink deepLink, int i, Object obj) {
                if ((i & 1) != 0) {
                    deepLink = orders.a;
                }
                return orders.copy(deepLink);
            }

            @NotNull
            public final DeepLink component1() {
                return this.a;
            }

            @NotNull
            public final Orders copy(@NotNull DeepLink deepLink) {
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                return new Orders(deepLink);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Orders) && Intrinsics.areEqual(this.a, ((Orders) obj).a);
                }
                return true;
            }

            @NotNull
            public final DeepLink getDeepLink() {
                return this.a;
            }

            public int hashCode() {
                DeepLink deepLink = this.a;
                if (deepLink != null) {
                    return deepLink.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a.m(a.L("Orders(deepLink="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$Profile;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class Profile extends ClickTarget {
            @NotNull
            public static final Profile INSTANCE = new Profile();

            public Profile() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$SOAInfo;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class SOAInfo extends ClickTarget {
            @NotNull
            public static final SOAInfo INSTANCE = new SOAInfo();

            public SOAInfo() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$Search;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class Search extends ClickTarget {
            @NotNull
            public static final Search INSTANCE = new Search();

            public Search() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$Settings;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class Settings extends ClickTarget {
            @NotNull
            public static final Settings INSTANCE = new Settings();

            public Settings() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$SmbStats;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component1", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "copy", "(Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$SmbStats;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class SmbStats extends ClickTarget {
            @NotNull
            public final DeepLink a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SmbStats(@NotNull DeepLink deepLink) {
                super(null);
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                this.a = deepLink;
            }

            public static /* synthetic */ SmbStats copy$default(SmbStats smbStats, DeepLink deepLink, int i, Object obj) {
                if ((i & 1) != 0) {
                    deepLink = smbStats.a;
                }
                return smbStats.copy(deepLink);
            }

            @NotNull
            public final DeepLink component1() {
                return this.a;
            }

            @NotNull
            public final SmbStats copy(@NotNull DeepLink deepLink) {
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                return new SmbStats(deepLink);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof SmbStats) && Intrinsics.areEqual(this.a, ((SmbStats) obj).a);
                }
                return true;
            }

            @NotNull
            public final DeepLink getDeepLink() {
                return this.a;
            }

            public int hashCode() {
                DeepLink deepLink = this.a;
                if (deepLink != null) {
                    return deepLink.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a.m(a.L("SmbStats(deepLink="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget$StartPublish;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class StartPublish extends ClickTarget {
            @NotNull
            public static final StartPublish INSTANCE = new StartPublish();

            public StartPublish() {
                super(null);
            }
        }

        public ClickTarget() {
        }

        public ClickTarget(j jVar) {
        }
    }

    @NotNull
    Observable<ClickTarget> getClicks();

    boolean isInitialized();

    void setProfileInfo(@NotNull ProfileInfo profileInfo);

    void showItemsSearch(boolean z);

    void updateNotificationCounter(int i);
}
