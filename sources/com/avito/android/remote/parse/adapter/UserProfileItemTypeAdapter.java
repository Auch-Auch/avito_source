package com.avito.android.remote.parse.adapter;

import com.avito.android.Features;
import com.avito.android.favorite_sellers.interactor.SubscribersReadInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import com.avito.android.remote.model.user_profile.items.ActionItem;
import com.avito.android.remote.model.user_profile.items.AdvertsItem;
import com.avito.android.remote.model.user_profile.items.ContactsItem;
import com.avito.android.remote.model.user_profile.items.DeliverySettingsItem;
import com.avito.android.remote.model.user_profile.items.ExtensionsItem;
import com.avito.android.remote.model.user_profile.items.HelpCenterItem;
import com.avito.android.remote.model.user_profile.items.IncomeSettingsItem;
import com.avito.android.remote.model.user_profile.items.InfoItem;
import com.avito.android.remote.model.user_profile.items.LfPackagesItem;
import com.avito.android.remote.model.user_profile.items.PhonesItem;
import com.avito.android.remote.model.user_profile.items.ProfileSessionsItem;
import com.avito.android.remote.model.user_profile.items.ReviewsItem;
import com.avito.android.remote.model.user_profile.items.ShopSettingsItem;
import com.avito.android.remote.model.user_profile.items.SocialItem;
import com.avito.android.remote.model.user_profile.items.SubscribersItem;
import com.avito.android.remote.model.user_profile.items.SubscriptionItem;
import com.avito.android.remote.model.user_profile.items.TariffItem;
import com.avito.android.remote.model.user_profile.items.TfaSettingsItem;
import com.avito.android.remote.model.user_profile.items.UserProfileItem;
import com.avito.android.remote.model.user_profile.items.VerificationItem;
import com.avito.android.remote.model.user_profile.items.VerificationPlatformItem;
import com.avito.android.remote.model.user_profile.items.VerifiedProfileItem;
import com.avito.android.remote.model.user_profile.items.WalletItem;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R(\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/parse/adapter/UserProfileItemTypeAdapter;", "Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapter;", "Lcom/avito/android/remote/model/user_profile/items/UserProfileItem;", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "", "", "Ljava/lang/reflect/Type;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getMapping", "()Ljava/util/Map;", "mapping", "<init>", "(Lcom/avito/android/Features;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class UserProfileItemTypeAdapter extends RuntimeTypeAdapter<UserProfileItem> {
    @NotNull
    public final Map<String, Type> a;
    public final Features b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserProfileItemTypeAdapter(@NotNull Features features) {
        super(null, SDKConstants.PARAM_A2U_BODY, null, 5, null);
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = features;
        Map<String, Type> mutableMapOf = r.mutableMapOf(TuplesKt.to("info", InfoItem.class), TuplesKt.to("adverts", AdvertsItem.class), TuplesKt.to(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_WALLET, WalletItem.class), TuplesKt.to("phones", PhonesItem.class), TuplesKt.to("reviews", ReviewsItem.class), TuplesKt.to("social", SocialItem.class), TuplesKt.to("serviceSubscription", SubscriptionItem.class), TuplesKt.to("extensions", ExtensionsItem.class), TuplesKt.to("lfPackages", LfPackagesItem.class), TuplesKt.to("delivery", DeliverySettingsItem.class), TuplesKt.to("helpCenter", HelpCenterItem.class), TuplesKt.to("contacts", ContactsItem.class), TuplesKt.to("income", IncomeSettingsItem.class), TuplesKt.to("shopSettings", ShopSettingsItem.class), TuplesKt.to("tfa", TfaSettingsItem.class), TuplesKt.to("tariff", TariffItem.class), TuplesKt.to("sessionsList", ProfileSessionsItem.class));
        if (features.getIdentityVerification().invoke().booleanValue()) {
            mutableMapOf.put("verification", VerificationItem.class);
            mutableMapOf.put("verifiedProfile", VerifiedProfileItem.class);
        }
        if (features.getVerificationPlatform().invoke().booleanValue()) {
            mutableMapOf.put("verificationInfo", VerificationPlatformItem.class);
        }
        if (features.getEnableProfileSubscriberList().invoke().booleanValue()) {
            mutableMapOf.put(SubscribersReadInteractor.TYPE, SubscribersItem.class);
        }
        if (features.getPasswordChange().invoke().booleanValue()) {
            mutableMapOf.put("passwordChange", ActionItem.class);
        }
        if (features.getPasswordSet().invoke().booleanValue()) {
            mutableMapOf.put("passwordSet", ActionItem.class);
        }
        this.a = mutableMapOf;
    }

    @Override // com.avito.android.remote.parse.adapter.RuntimeTypeAdapter
    @NotNull
    public Map<String, Type> getMapping() {
        return this.a;
    }
}
