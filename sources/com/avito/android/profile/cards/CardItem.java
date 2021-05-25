package com.avito.android.profile.cards;

import a2.b.a.a.a;
import a2.g.r.g;
import android.net.Uri;
import androidx.annotation.AttrRes;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Avatar;
import com.avito.android.remote.model.ProfileRating;
import com.avito.android.remote.model.social.SocialNetwork;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.user_profile.Phone;
import com.avito.android.remote.model.user_profile.SeparateBalance;
import com.avito.android.remote.model.user_profile.Support;
import com.avito.android.remote.model.user_profile.items.AdvertsItem;
import com.avito.android.remote.model.user_profile.items.ExtensionsItem;
import com.avito.conveyor_item.Item;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.sumsub.sns.core.common.SNSConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0018\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0018 !\"#$%&'()*+,-./01234567¨\u00068"}, d2 = {"Lcom/avito/android/profile/cards/CardItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "ActionCardItem", "AdvertsCardItem", "ContactsCardItem", "DeliverySettingsCardItem", "ExtensionsCardItem", "HelpCenterCardItem", "IncomeSettingsCardItem", "InfoCardItem", "LfPackagesCardItem", "LogoutCardItem", "PhonesCardItem", "PhonesEmptyCardItem", "ReviewsCardItem", "SeparateWalletCardItem", "SessionsCardItem", "ShopSettingsCardItem", "SocialCardItem", "SubscribersCardItem", "SubscriptionCardItem", "TfaSettingsCardItem", "VerificationCardItem", "VerificationPlatformCardItem", "VerifiedProfileCardItem", "WalletCardItem", "Lcom/avito/android/profile/cards/CardItem$InfoCardItem;", "Lcom/avito/android/profile/cards/CardItem$VerifiedProfileCardItem;", "Lcom/avito/android/profile/cards/CardItem$VerificationCardItem;", "Lcom/avito/android/profile/cards/CardItem$AdvertsCardItem;", "Lcom/avito/android/profile/cards/CardItem$WalletCardItem;", "Lcom/avito/android/profile/cards/CardItem$SeparateWalletCardItem;", "Lcom/avito/android/profile/cards/CardItem$SocialCardItem;", "Lcom/avito/android/profile/cards/CardItem$PhonesCardItem;", "Lcom/avito/android/profile/cards/CardItem$PhonesEmptyCardItem;", "Lcom/avito/android/profile/cards/CardItem$ReviewsCardItem;", "Lcom/avito/android/profile/cards/CardItem$ContactsCardItem;", "Lcom/avito/android/profile/cards/CardItem$SubscriptionCardItem;", "Lcom/avito/android/profile/cards/CardItem$LfPackagesCardItem;", "Lcom/avito/android/profile/cards/CardItem$ShopSettingsCardItem;", "Lcom/avito/android/profile/cards/CardItem$ExtensionsCardItem;", "Lcom/avito/android/profile/cards/CardItem$HelpCenterCardItem;", "Lcom/avito/android/profile/cards/CardItem$DeliverySettingsCardItem;", "Lcom/avito/android/profile/cards/CardItem$IncomeSettingsCardItem;", "Lcom/avito/android/profile/cards/CardItem$ActionCardItem;", "Lcom/avito/android/profile/cards/CardItem$LogoutCardItem;", "Lcom/avito/android/profile/cards/CardItem$SubscribersCardItem;", "Lcom/avito/android/profile/cards/CardItem$SessionsCardItem;", "Lcom/avito/android/profile/cards/CardItem$TfaSettingsCardItem;", "Lcom/avito/android/profile/cards/CardItem$VerificationPlatformCardItem;", "profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class CardItem implements Item {
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$ActionCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "Lcom/avito/android/remote/model/Action;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", "", "id", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class ActionCardItem extends CardItem {
        @NotNull
        public final Action b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ActionCardItem(@NotNull String str, @NotNull Action action) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(action, "action");
            this.b = action;
        }

        @NotNull
        public final Action getAction() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$AdvertsCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$StatusItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$StatusItem;", "getActive", "()Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$StatusItem;", "active", "d", "getRejected", "rejected", "c", "getInactive", "inactive", "", "id", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$StatusItem;Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$StatusItem;Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$StatusItem;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class AdvertsCardItem extends CardItem {
        @NotNull
        public final AdvertsItem.StatusItem b;
        @Nullable
        public final AdvertsItem.StatusItem c;
        @Nullable
        public final AdvertsItem.StatusItem d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AdvertsCardItem(@NotNull String str, @NotNull AdvertsItem.StatusItem statusItem, @Nullable AdvertsItem.StatusItem statusItem2, @Nullable AdvertsItem.StatusItem statusItem3) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(statusItem, "active");
            this.b = statusItem;
            this.c = statusItem2;
            this.d = statusItem3;
        }

        @NotNull
        public final AdvertsItem.StatusItem getActive() {
            return this.b;
        }

        @Nullable
        public final AdvertsItem.StatusItem getInactive() {
            return this.c;
        }

        @Nullable
        public final AdvertsItem.StatusItem getRejected() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$ContactsCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "c", "getDescription", "description", "Lcom/avito/android/remote/model/Action;", "d", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class ContactsCardItem extends CardItem {
        @NotNull
        public final String b;
        @Nullable
        public final String c;
        @Nullable
        public final Action d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ContactsCardItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Action action) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.b = str2;
            this.c = str3;
            this.d = action;
        }

        @Nullable
        public final Action getAction() {
            return this.d;
        }

        @Nullable
        public final String getDescription() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$DeliverySettingsCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", "c", "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, "Landroid/net/Uri;", "d", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", ShareConstants.MEDIA_URI, AuthSource.BOOKING_ORDER, "getTitle", "title", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class DeliverySettingsCardItem extends CardItem {
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @NotNull
        public final Uri d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeliverySettingsCardItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Uri uri) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, MessengerShareContentUtility.SUBTITLE);
            Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
            this.b = str2;
            this.c = str3;
            this.d = uri;
        }

        @NotNull
        public final String getSubtitle() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        @NotNull
        public final Uri getUri() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018R!\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR!\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$ExtensionsCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", "Lcom/avito/android/remote/model/user_profile/items/ExtensionsItem$ExtensionInfo;", "d", "Ljava/util/List;", "getExtensionsInfo", "()Ljava/util/List;", "extensionsInfo", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "c", "getDescription", "description", "Lcom/avito/android/remote/model/Action;", "e", "getActions", "actions", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class ExtensionsCardItem extends CardItem {
        @NotNull
        public final String b;
        @Nullable
        public final String c;
        @Nullable
        public final List<ExtensionsItem.ExtensionInfo> d;
        @Nullable
        public final List<Action> e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ExtensionsCardItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable List<ExtensionsItem.ExtensionInfo> list, @Nullable List<Action> list2) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.b = str2;
            this.c = str3;
            this.d = list;
            this.e = list2;
        }

        @Nullable
        public final List<Action> getActions() {
            return this.e;
        }

        @Nullable
        public final String getDescription() {
            return this.c;
        }

        @Nullable
        public final List<ExtensionsItem.ExtensionInfo> getExtensionsInfo() {
            return this.d;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$HelpCenterCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", "id", "<init>", "(Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class HelpCenterCardItem extends CardItem {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HelpCenterCardItem(@NotNull String str) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$IncomeSettingsCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "Lcom/avito/android/deep_linking/links/DeepLink;", "d", "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, "", "c", "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, AuthSource.BOOKING_ORDER, "getTitle", "title", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class IncomeSettingsCardItem extends CardItem {
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @NotNull
        public final DeepLink d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IncomeSettingsCardItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull DeepLink deepLink) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, MessengerShareContentUtility.SUBTITLE);
            Intrinsics.checkNotNullParameter(deepLink, ShareConstants.MEDIA_URI);
            this.b = str2;
            this.c = str3;
            this.d = deepLink;
        }

        @NotNull
        public final String getSubtitle() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        @NotNull
        public final DeepLink getUri() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u00101\u001a\u00020\u0019\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010$\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010'\u001a\u00020\u0019\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010!\u001a\u00020\u0019\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\b\u00100\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b2\u00103R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010!\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u0019\u0010$\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001dR\u0019\u0010'\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001dR\u001b\u0010*\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010\u001dR\u001b\u0010-\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u001b\u001a\u0004\b,\u0010\u001dR\u001b\u00100\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010\u001d¨\u00064"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$InfoCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "Lcom/avito/android/remote/model/ProfileRating;", "l", "Lcom/avito/android/remote/model/ProfileRating;", "getRating", "()Lcom/avito/android/remote/model/ProfileRating;", "rating", "", g.a, "Z", "isIncomplete", "()Z", "Lcom/avito/android/remote/model/Avatar;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Avatar;", "getAvatar", "()Lcom/avito/android/remote/model/Avatar;", "avatar", "Lcom/avito/android/remote/model/user_profile/Support;", "j", "Lcom/avito/android/remote/model/user_profile/Support;", "getSupport", "()Lcom/avito/android/remote/model/user_profile/Support;", SNSConstants.LinkType.SUPPORT, "", "d", "Ljava/lang/String;", "getEmail", "()Ljava/lang/String;", "email", "h", "getType", "type", "c", "getName", "name", "f", "getRegistered", "registered", "e", "getAddress", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "i", "getManager", "manager", "k", "getShopSite", "shopSite", "id", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Avatar;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/user_profile/Support;Ljava/lang/String;Lcom/avito/android/remote/model/ProfileRating;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class InfoCardItem extends CardItem {
        @Nullable
        public final Avatar b;
        @NotNull
        public final String c;
        @Nullable
        public final String d;
        @Nullable
        public final String e;
        @NotNull
        public final String f;
        public final boolean g;
        @NotNull
        public final String h;
        @Nullable
        public final String i;
        @Nullable
        public final Support j;
        @Nullable
        public final String k;
        @Nullable
        public final ProfileRating l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InfoCardItem(@NotNull String str, @Nullable Avatar avatar, @NotNull String str2, @Nullable String str3, @Nullable String str4, @NotNull String str5, boolean z, @NotNull String str6, @Nullable String str7, @Nullable Support support, @Nullable String str8, @Nullable ProfileRating profileRating) {
            super(str, null);
            a.b1(str, "id", str2, "name", str5, "registered", str6, "type");
            this.b = avatar;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = z;
            this.h = str6;
            this.i = str7;
            this.j = support;
            this.k = str8;
            this.l = profileRating;
        }

        @Nullable
        public final String getAddress() {
            return this.e;
        }

        @Nullable
        public final Avatar getAvatar() {
            return this.b;
        }

        @Nullable
        public final String getEmail() {
            return this.d;
        }

        @Nullable
        public final String getManager() {
            return this.i;
        }

        @NotNull
        public final String getName() {
            return this.c;
        }

        @Nullable
        public final ProfileRating getRating() {
            return this.l;
        }

        @NotNull
        public final String getRegistered() {
            return this.f;
        }

        @Nullable
        public final String getShopSite() {
            return this.k;
        }

        @Nullable
        public final Support getSupport() {
            return this.j;
        }

        @NotNull
        public final String getType() {
            return this.h;
        }

        public final boolean isIncomplete() {
            return this.g;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$LfPackagesCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", "c", "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", "setSubtitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, AuthSource.BOOKING_ORDER, "getTitle", "title", "Lcom/avito/android/remote/model/Action;", "d", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class LfPackagesCardItem extends CardItem {
        @NotNull
        public final String b;
        @NotNull
        public String c;
        @Nullable
        public final Action d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LfPackagesCardItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Action action) {
            super(str, null);
            a.Z0(str, "id", str2, "title", str3, MessengerShareContentUtility.SUBTITLE);
            this.b = str2;
            this.c = str3;
            this.d = action;
        }

        @Nullable
        public final Action getAction() {
            return this.d;
        }

        @NotNull
        public final String getSubtitle() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        public final void setSubtitle(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.c = str;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$LogoutCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", "id", "<init>", "(Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class LogoutCardItem extends CardItem {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LogoutCardItem(@NotNull String str) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$PhonesCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", "Lcom/avito/android/remote/model/user_profile/Phone;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getPhones", "()Ljava/util/List;", "phones", "", "id", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class PhonesCardItem extends CardItem {
        @NotNull
        public final List<Phone> b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PhonesCardItem(@NotNull String str, @NotNull List<Phone> list) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(list, "phones");
            this.b = list;
        }

        @NotNull
        public final List<Phone> getPhones() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$PhonesEmptyCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", "id", "<init>", "(Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class PhonesEmptyCardItem extends CardItem {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PhonesEmptyCardItem(@NotNull String str) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$ReviewsCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", "c", "Ljava/lang/String;", "getReviews", "()Ljava/lang/String;", "reviews", "Lcom/avito/android/remote/model/Action;", "d", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", AuthSource.BOOKING_ORDER, "getTitle", "title", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class ReviewsCardItem extends CardItem {
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @NotNull
        public final Action d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ReviewsCardItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Action action) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "reviews");
            Intrinsics.checkNotNullParameter(action, "action");
            this.b = str2;
            this.c = str3;
            this.d = action;
        }

        @NotNull
        public final Action getAction() {
            return this.d;
        }

        @NotNull
        public final String getReviews() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$SeparateWalletCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "Lcom/avito/android/remote/model/user_profile/SeparateBalance;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/user_profile/SeparateBalance;", "getBalance", "()Lcom/avito/android/remote/model/user_profile/SeparateBalance;", "balance", "", "id", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/user_profile/SeparateBalance;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class SeparateWalletCardItem extends CardItem {
        @NotNull
        public final SeparateBalance b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SeparateWalletCardItem(@NotNull String str, @NotNull SeparateBalance separateBalance) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(separateBalance, "balance");
            this.b = separateBalance;
        }

        @NotNull
        public final SeparateBalance getBalance() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$SessionsCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "c", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/deep_linking/links/DeepLink;", "d", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class SessionsCardItem extends CardItem {
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @Nullable
        public final DeepLink d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SessionsCardItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable DeepLink deepLink) {
            super(str, null);
            a.Z0(str, "id", str2, "title", str3, MessengerShareContentUtility.SUBTITLE);
            this.b = str2;
            this.c = str3;
            this.d = deepLink;
        }

        @Nullable
        public final DeepLink getDeeplink() {
            return this.d;
        }

        @NotNull
        public final String getSubtitle() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$ShopSettingsCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "Lcom/avito/android/remote/model/Action;", "c", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShopSettingsCardItem extends CardItem {
        @NotNull
        public final String b;
        @Nullable
        public final Action c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShopSettingsCardItem(@NotNull String str, @NotNull String str2, @Nullable Action action) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.b = str2;
            this.c = action;
        }

        @Nullable
        public final Action getAction() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$SocialCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", "Lcom/avito/android/remote/model/social/SocialNetwork;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getSocialNetworks", "()Ljava/util/List;", "socialNetworks", "", "id", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class SocialCardItem extends CardItem {
        @NotNull
        public final List<SocialNetwork> b;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.social.SocialNetwork> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SocialCardItem(@NotNull String str, @NotNull List<? extends SocialNetwork> list) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(list, "socialNetworks");
            this.b = list;
        }

        @NotNull
        public final List<SocialNetwork> getSocialNetworks() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$SubscribersCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", "c", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", "Lcom/avito/android/remote/model/Action;", "d", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", AuthSource.BOOKING_ORDER, "getTitle", "title", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class SubscribersCardItem extends CardItem {
        @NotNull
        public final String b;
        @Nullable
        public final String c;
        @Nullable
        public final Action d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SubscribersCardItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Action action) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.b = str2;
            this.c = str3;
            this.d = action;
        }

        @Nullable
        public final Action getAction() {
            return this.d;
        }

        @Nullable
        public final String getDescription() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001a\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$SubscriptionCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", "c", "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, AuthSource.BOOKING_ORDER, "getTitle", "title", "Lcom/avito/android/remote/model/Action;", "f", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/text/AttributedText;", "d", "Lcom/avito/android/remote/model/text/AttributedText;", "getSubtitleAttributed", "()Lcom/avito/android/remote/model/text/AttributedText;", "subtitleAttributed", "", "e", "Z", "isActive", "()Z", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;ZLcom/avito/android/remote/model/Action;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class SubscriptionCardItem extends CardItem {
        @NotNull
        public final String b;
        @Nullable
        public final String c;
        @Nullable
        public final AttributedText d;
        public final boolean e;
        @Nullable
        public final Action f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SubscriptionCardItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable AttributedText attributedText, boolean z, @Nullable Action action) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.b = str2;
            this.c = str3;
            this.d = attributedText;
            this.e = z;
            this.f = action;
        }

        @Nullable
        public final Action getAction() {
            return this.f;
        }

        @Nullable
        public final String getSubtitle() {
            return this.c;
        }

        @Nullable
        public final AttributedText getSubtitleAttributed() {
            return this.d;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        public final boolean isActive() {
            return this.e;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$TfaSettingsCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", "f", "Ljava/lang/Boolean;", "getHighlightSubtitle", "()Ljava/lang/Boolean;", "highlightSubtitle", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "c", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "e", "Z", "isEnabled", "()Z", "d", "getWarning", "warning", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class TfaSettingsCardItem extends CardItem {
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @Nullable
        public final String d;
        public final boolean e;
        @Nullable
        public final Boolean f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TfaSettingsCardItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, boolean z, @Nullable Boolean bool) {
            super(str, null);
            a.Z0(str, "id", str2, "title", str3, MessengerShareContentUtility.SUBTITLE);
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = z;
            this.f = bool;
        }

        @Nullable
        public final Boolean getHighlightSubtitle() {
            return this.f;
        }

        @NotNull
        public final String getSubtitle() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        @Nullable
        public final String getWarning() {
            return this.d;
        }

        public final boolean isEnabled() {
            return this.e;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB9\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$VerificationCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", "d", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", "Lcom/avito/android/profile/cards/CardItem$VerificationCardItem$VerificationBanner;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile/cards/CardItem$VerificationCardItem$VerificationBanner;", "getBanner", "()Lcom/avito/android/profile/cards/CardItem$VerificationCardItem$VerificationBanner;", "banner", "", "Lcom/avito/android/profile/cards/CardItem$VerificationCardItem$VerificationWay;", "e", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "c", "getTitle", "title", "id", "<init>", "(Ljava/lang/String;Lcom/avito/android/profile/cards/CardItem$VerificationCardItem$VerificationBanner;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "VerificationBanner", "VerificationWay", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class VerificationCardItem extends CardItem {
        @Nullable
        public final VerificationBanner b;
        @NotNull
        public final String c;
        @Nullable
        public final String d;
        @NotNull
        public final List<VerificationWay> e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$VerificationCardItem$VerificationBanner;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "Lcom/avito/android/remote/model/text/AttributedText;", "c", "Lcom/avito/android/remote/model/text/AttributedText;", "getDetailsText", "()Lcom/avito/android/remote/model/text/AttributedText;", "detailsText", "", "f", "I", "getBackgroundTintColor", "()I", "backgroundTintColor", "d", "getIconRes", "iconRes", AuthSource.BOOKING_ORDER, "getDescription", "description", "e", "getIconTintColor", "iconTintColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;III)V", "profile_release"}, k = 1, mv = {1, 4, 2})
        public static final class VerificationBanner {
            @Nullable
            public final String a;
            @Nullable
            public final String b;
            @Nullable
            public final AttributedText c;
            public final int d;
            public final int e;
            public final int f;

            public VerificationBanner(@Nullable String str, @Nullable String str2, @Nullable AttributedText attributedText, int i, int i2, int i3) {
                this.a = str;
                this.b = str2;
                this.c = attributedText;
                this.d = i;
                this.e = i2;
                this.f = i3;
            }

            public final int getBackgroundTintColor() {
                return this.f;
            }

            @Nullable
            public final String getDescription() {
                return this.b;
            }

            @Nullable
            public final AttributedText getDetailsText() {
                return this.c;
            }

            public final int getIconRes() {
                return this.d;
            }

            public final int getIconTintColor() {
                return this.e;
            }

            @Nullable
            public final String getTitle() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b \u0010!R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006¨\u0006\""}, d2 = {"Lcom/avito/android/profile/cards/CardItem$VerificationCardItem$VerificationWay;", "", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", AuthSource.SEND_ABUSE, "getTitle", "title", "", "f", "I", "getButtonStyleAttr", "()I", "buttonStyleAttr", "Lcom/avito/android/deep_linking/links/DeepLink;", "c", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "d", "Z", "getButtonEnabled", "()Z", "buttonEnabled", "e", "getButtonText", "buttonText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;ZLjava/lang/String;I)V", "profile_release"}, k = 1, mv = {1, 4, 2})
        public static final class VerificationWay {
            @Nullable
            public final String a;
            @Nullable
            public final String b;
            @NotNull
            public final DeepLink c;
            public final boolean d;
            @NotNull
            public final String e;
            public final int f;

            public VerificationWay(@Nullable String str, @Nullable String str2, @NotNull DeepLink deepLink, boolean z, @NotNull String str3, int i) {
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                Intrinsics.checkNotNullParameter(str3, "buttonText");
                this.a = str;
                this.b = str2;
                this.c = deepLink;
                this.d = z;
                this.e = str3;
                this.f = i;
            }

            public final boolean getButtonEnabled() {
                return this.d;
            }

            public final int getButtonStyleAttr() {
                return this.f;
            }

            @NotNull
            public final String getButtonText() {
                return this.e;
            }

            @NotNull
            public final DeepLink getDeepLink() {
                return this.c;
            }

            @Nullable
            public final String getDescription() {
                return this.b;
            }

            @Nullable
            public final String getTitle() {
                return this.a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VerificationCardItem(@NotNull String str, @Nullable VerificationBanner verificationBanner, @NotNull String str2, @Nullable String str3, @NotNull List<VerificationWay> list) {
            super(str, null);
            a.c1(str, "id", str2, "title", list, "items");
            this.b = verificationBanner;
            this.c = str2;
            this.d = str3;
            this.e = list;
        }

        @Nullable
        public final VerificationBanner getBanner() {
            return this.b;
        }

        @Nullable
        public final String getDescription() {
            return this.d;
        }

        @NotNull
        public final List<VerificationWay> getItems() {
            return this.e;
        }

        @NotNull
        public final String getTitle() {
            return this.c;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u001bB5\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$VerificationPlatformCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", "c", "Ljava/lang/String;", "getActionTitle", "()Ljava/lang/String;", "actionTitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "d", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "Lcom/avito/android/profile/cards/CardItem$VerificationPlatformCardItem$VerificationStatusDetails;", "e", "Ljava/util/List;", "getStatuses", "()Ljava/util/List;", "statuses", AuthSource.BOOKING_ORDER, "getTitle", "title", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/util/List;)V", "VerificationStatusDetails", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class VerificationPlatformCardItem extends CardItem {
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @NotNull
        public final DeepLink d;
        @NotNull
        public final List<VerificationStatusDetails> e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0010\u001a\u00020\b\u0012\b\b\u0001\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$VerificationPlatformCardItem$VerificationStatusDetails;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "c", "I", "getIconTintColor", "()I", "iconTintColor", AuthSource.BOOKING_ORDER, "getIconRes", "iconRes", "<init>", "(Ljava/lang/String;II)V", "profile_release"}, k = 1, mv = {1, 4, 2})
        public static final class VerificationStatusDetails {
            @NotNull
            public final String a;
            public final int b;
            public final int c;

            public VerificationStatusDetails(@NotNull String str, @AttrRes int i, @AttrRes int i2) {
                Intrinsics.checkNotNullParameter(str, "title");
                this.a = str;
                this.b = i;
                this.c = i2;
            }

            public final int getIconRes() {
                return this.b;
            }

            public final int getIconTintColor() {
                return this.c;
            }

            @NotNull
            public final String getTitle() {
                return this.a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VerificationPlatformCardItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull DeepLink deepLink, @NotNull List<VerificationStatusDetails> list) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "actionTitle");
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            Intrinsics.checkNotNullParameter(list, "statuses");
            this.b = str2;
            this.c = str3;
            this.d = deepLink;
            this.e = list;
        }

        @NotNull
        public final String getActionTitle() {
            return this.c;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.d;
        }

        @NotNull
        public final List<VerificationStatusDetails> getStatuses() {
            return this.e;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$VerifiedProfileCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class VerifiedProfileCardItem extends CardItem {
        @NotNull
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VerifiedProfileCardItem(@NotNull String str, @NotNull String str2) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.b = str2;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/profile/cards/CardItem$WalletCardItem;", "Lcom/avito/android/profile/cards/CardItem;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getBalance", "()Ljava/lang/String;", "balance", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class WalletCardItem extends CardItem {
        @NotNull
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WalletCardItem(@NotNull String str, @NotNull String str2) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "balance");
            this.b = str2;
        }

        @NotNull
        public final String getBalance() {
            return this.b;
        }
    }

    public CardItem(String str, j jVar) {
        this.a = str;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }
}
