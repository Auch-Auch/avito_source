package com.avito.android.profile;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.R;
import com.avito.android.profile.cards.CardItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Address;
import com.avito.android.remote.model.Avatar;
import com.avito.android.remote.model.user_profile.SeparateBalance;
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
import com.avito.android.remote.model.user_profile.items.VerificationBanner;
import com.avito.android.remote.model.user_profile.items.VerificationBannerType;
import com.avito.android.remote.model.user_profile.items.VerificationItem;
import com.avito.android.remote.model.user_profile.items.VerificationPlatformItem;
import com.avito.android.remote.model.user_profile.items.VerificationPlatformStatus;
import com.avito.android.remote.model.user_profile.items.VerificationPlatformStatusError;
import com.avito.android.remote.model.user_profile.items.VerificationPlatformStatusInProgress;
import com.avito.android.remote.model.user_profile.items.VerificationPlatformStatusInfo;
import com.avito.android.remote.model.user_profile.items.VerificationPlatformStatusSuccess;
import com.avito.android.remote.model.user_profile.items.VerificationWay;
import com.avito.android.remote.model.user_profile.items.VerifiedProfileItem;
import com.avito.android.remote.model.user_profile.items.WalletItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/profile/UserProfileItemConverterImpl;", "Lcom/avito/android/profile/UserProfileItemConverter;", "", "id", "Lcom/avito/android/remote/model/user_profile/items/UserProfileItem;", "item", "Lcom/avito/android/profile/cards/CardItem;", "convert", "(Ljava/lang/String;Lcom/avito/android/remote/model/user_profile/items/UserProfileItem;)Lcom/avito/android/profile/cards/CardItem;", "Lcom/avito/android/Features;", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class UserProfileItemConverterImpl implements UserProfileItemConverter {
    public final Features a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            VerificationBannerType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            VerificationBannerType verificationBannerType = VerificationBannerType.IN_PROGRESS;
            iArr[0] = 1;
            VerificationBannerType verificationBannerType2 = VerificationBannerType.ERROR;
            iArr[1] = 2;
            VerificationBannerType verificationBannerType3 = VerificationBannerType.WARNING;
            iArr[2] = 3;
        }
    }

    public UserProfileItemConverterImpl(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = features;
    }

    @Override // com.avito.android.profile.UserProfileItemConverter
    @Nullable
    public CardItem convert(@NotNull String str, @NotNull UserProfileItem userProfileItem) {
        CardItem cardItem;
        CardItem.VerificationPlatformCardItem.VerificationStatusDetails verificationStatusDetails;
        int i;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(userProfileItem, "item");
        CardItem.VerificationPlatformCardItem verificationPlatformCardItem = null;
        String str2 = null;
        CardItem.VerificationCardItem.VerificationBanner verificationBanner = null;
        if (userProfileItem instanceof InfoItem) {
            InfoItem infoItem = (InfoItem) userProfileItem;
            Avatar avatar = infoItem.getAvatar();
            String name = infoItem.getName();
            String email = infoItem.getEmail();
            Address address = infoItem.getAddress();
            if (address != null) {
                str2 = address.getTitle();
            }
            cardItem = new CardItem.InfoCardItem(str, avatar, name, email, str2, infoItem.getRegistered(), infoItem.isIncomplete(), infoItem.getType(), infoItem.getManager(), infoItem.getSupport(), infoItem.getShopSite(), infoItem.getRating());
        } else if (userProfileItem instanceof VerificationItem) {
            VerificationItem verificationItem = (VerificationItem) userProfileItem;
            VerificationBanner banner = verificationItem.getBanner();
            if (banner != null) {
                int ordinal = banner.getBannerType().ordinal();
                if (ordinal == 0) {
                    i4 = R.drawable.ic_clock_24;
                    i3 = R.attr.blue600;
                    i2 = R.attr.blue50;
                } else if (ordinal == 1) {
                    i4 = R.drawable.ic_exclamation_24;
                    i3 = R.attr.red;
                    i2 = R.attr.orange50;
                } else if (ordinal == 2) {
                    i4 = R.drawable.ic_exclamation_24;
                    i3 = R.attr.orange700;
                    i2 = R.attr.orange50;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                verificationBanner = new CardItem.VerificationCardItem.VerificationBanner(banner.getTitle(), banner.getDescription(), banner.getDetailsText(), i4, i3, i2);
            }
            String title = verificationItem.getTitle();
            String description = verificationItem.getDescription();
            List<VerificationWay> list = verificationItem.getList();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                String title2 = t.getTitle();
                String description2 = t.getDescription();
                DeepLink deepLink = t.getButton().getDeepLink();
                Boolean enabled = t.getButton().getEnabled();
                boolean booleanValue = enabled != null ? enabled.booleanValue() : true;
                String text = t.getButton().getText();
                String style = t.getButton().getStyle();
                if (style != null && style.hashCode() == -314765822 && style.equals("primary")) {
                    i = R.attr.buttonPrimaryMedium;
                } else {
                    i = R.attr.buttonOutlineMedium;
                }
                arrayList.add(new CardItem.VerificationCardItem.VerificationWay(title2, description2, deepLink, booleanValue, text, i));
            }
            cardItem = new CardItem.VerificationCardItem(str, verificationBanner, title, description, arrayList);
        } else if (userProfileItem instanceof VerifiedProfileItem) {
            cardItem = new CardItem.VerifiedProfileCardItem(str, ((VerifiedProfileItem) userProfileItem).getTitle());
        } else if (userProfileItem instanceof AdvertsItem) {
            AdvertsItem advertsItem = (AdvertsItem) userProfileItem;
            cardItem = new CardItem.AdvertsCardItem(str, advertsItem.getStatus().getActive(), advertsItem.getStatus().getInactive(), advertsItem.getStatus().getRejected());
        } else if (userProfileItem instanceof WalletItem) {
            WalletItem walletItem = (WalletItem) userProfileItem;
            SeparateBalance separate = walletItem.getSeparate();
            if (separate != null) {
                cardItem = new CardItem.SeparateWalletCardItem(str, separate);
            } else {
                cardItem = new CardItem.WalletCardItem(str, walletItem.getBalance());
            }
        } else if (userProfileItem instanceof SocialItem) {
            cardItem = new CardItem.SocialCardItem(str, ((SocialItem) userProfileItem).getSocialNetworks());
        } else if (userProfileItem instanceof PhonesItem) {
            if (!this.a.getPhonesListRedesign().invoke().booleanValue() || !((PhonesItem) userProfileItem).getPhones().isEmpty()) {
                return new CardItem.PhonesCardItem(str, ((PhonesItem) userProfileItem).getPhones());
            }
            return new CardItem.PhonesEmptyCardItem(str);
        } else if (userProfileItem instanceof ReviewsItem) {
            ReviewsItem reviewsItem = (ReviewsItem) userProfileItem;
            return new CardItem.ReviewsCardItem(str, reviewsItem.getTitle(), reviewsItem.getReviews(), reviewsItem.getAction());
        } else if (userProfileItem instanceof ContactsItem) {
            ContactsItem contactsItem = (ContactsItem) userProfileItem;
            return new CardItem.ContactsCardItem(str, contactsItem.getTitle(), contactsItem.getDescription(), contactsItem.getAction());
        } else if (userProfileItem instanceof SubscriptionItem) {
            SubscriptionItem subscriptionItem = (SubscriptionItem) userProfileItem;
            return new CardItem.SubscriptionCardItem(str, subscriptionItem.getTitle(), subscriptionItem.getSubtitle(), null, Intrinsics.areEqual(subscriptionItem.getStatus(), "active"), subscriptionItem.getAction());
        } else if (userProfileItem instanceof TariffItem) {
            TariffItem tariffItem = (TariffItem) userProfileItem;
            return new CardItem.SubscriptionCardItem(str, tariffItem.getTitle(), null, tariffItem.getSubtitle(), Intrinsics.areEqual(tariffItem.getStatus(), "active"), tariffItem.getAction());
        } else if (userProfileItem instanceof LfPackagesItem) {
            LfPackagesItem lfPackagesItem = (LfPackagesItem) userProfileItem;
            return new CardItem.LfPackagesCardItem(str, lfPackagesItem.getTitle(), lfPackagesItem.getSubtitle(), lfPackagesItem.getAction());
        } else if (userProfileItem instanceof ShopSettingsItem) {
            ShopSettingsItem shopSettingsItem = (ShopSettingsItem) userProfileItem;
            return new CardItem.ShopSettingsCardItem(str, shopSettingsItem.getTitle(), shopSettingsItem.getAction());
        } else if (userProfileItem instanceof ExtensionsItem) {
            ExtensionsItem extensionsItem = (ExtensionsItem) userProfileItem;
            return new CardItem.ExtensionsCardItem(str, extensionsItem.getTitle(), extensionsItem.getDescription(), extensionsItem.getExtensionsInfo(), extensionsItem.getActions());
        } else if (userProfileItem instanceof HelpCenterItem) {
            return new CardItem.HelpCenterCardItem(str);
        } else {
            if (userProfileItem instanceof DeliverySettingsItem) {
                DeliverySettingsItem deliverySettingsItem = (DeliverySettingsItem) userProfileItem;
                return new CardItem.DeliverySettingsCardItem(str, deliverySettingsItem.getTitle(), deliverySettingsItem.getSubtitle(), deliverySettingsItem.getUri());
            } else if (userProfileItem instanceof IncomeSettingsItem) {
                IncomeSettingsItem incomeSettingsItem = (IncomeSettingsItem) userProfileItem;
                return new CardItem.IncomeSettingsCardItem(str, incomeSettingsItem.getTitle(), incomeSettingsItem.getSubtitle(), incomeSettingsItem.getUri());
            } else if (userProfileItem instanceof ActionItem) {
                return new CardItem.ActionCardItem(str, ((ActionItem) userProfileItem).getAction());
            } else {
                if (userProfileItem instanceof SubscribersItem) {
                    SubscribersItem subscribersItem = (SubscribersItem) userProfileItem;
                    return new CardItem.SubscribersCardItem(str, subscribersItem.getTitle(), subscribersItem.getDescription(), subscribersItem.getAction());
                } else if (userProfileItem instanceof ProfileSessionsItem) {
                    ProfileSessionsItem profileSessionsItem = (ProfileSessionsItem) userProfileItem;
                    return new CardItem.SessionsCardItem(str, profileSessionsItem.getTitle(), profileSessionsItem.getSubtitle(), profileSessionsItem.getDeeplink());
                } else if (userProfileItem instanceof TfaSettingsItem) {
                    TfaSettingsItem tfaSettingsItem = (TfaSettingsItem) userProfileItem;
                    return new CardItem.TfaSettingsCardItem(str, tfaSettingsItem.getTitle(), tfaSettingsItem.getSubtitle(), tfaSettingsItem.getWarning(), tfaSettingsItem.isEnabled(), tfaSettingsItem.getHighlightSubtitle());
                } else if (userProfileItem instanceof VerificationPlatformItem) {
                    VerificationPlatformItem verificationPlatformItem = (VerificationPlatformItem) userProfileItem;
                    if (!verificationPlatformItem.getStatuses().isEmpty()) {
                        String title3 = verificationPlatformItem.getTitle();
                        String title4 = verificationPlatformItem.getAction().getTitle();
                        DeepLink uri = verificationPlatformItem.getAction().getUri();
                        List<VerificationPlatformStatus> statuses = verificationPlatformItem.getStatuses();
                        ArrayList arrayList2 = new ArrayList();
                        for (T t2 : statuses) {
                            if (t2 instanceof VerificationPlatformStatusInfo) {
                                verificationStatusDetails = new CardItem.VerificationPlatformCardItem.VerificationStatusDetails(t2.getTitle(), R.attr.ic_info24, R.attr.gray28);
                            } else if (t2 instanceof VerificationPlatformStatusError) {
                                verificationStatusDetails = new CardItem.VerificationPlatformCardItem.VerificationStatusDetails(t2.getTitle(), R.attr.ic_attentionRound24, R.attr.red);
                            } else if (t2 instanceof VerificationPlatformStatusSuccess) {
                                verificationStatusDetails = new CardItem.VerificationPlatformCardItem.VerificationStatusDetails(t2.getTitle(), R.attr.ic_checkBold24, R.attr.gray28);
                            } else {
                                verificationStatusDetails = t2 instanceof VerificationPlatformStatusInProgress ? new CardItem.VerificationPlatformCardItem.VerificationStatusDetails(t2.getTitle(), R.attr.ic_time24, R.attr.gray28) : null;
                            }
                            if (verificationStatusDetails != null) {
                                arrayList2.add(verificationStatusDetails);
                            }
                        }
                        verificationPlatformCardItem = new CardItem.VerificationPlatformCardItem(str, title3, title4, uri, arrayList2);
                    }
                    return verificationPlatformCardItem;
                } else {
                    StringBuilder L = a.L("Invalid user profile item type: ");
                    L.append(userProfileItem.getClass().getName());
                    throw new IllegalArgumentException(L.toString());
                }
            }
        }
        return cardItem;
    }
}
