package com.avito.android.extended_profile.adapter.contact_bar;

import com.avito.android.advert_core.contactbar.AdvertActionIconFactory;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.public_profile.remote.model.UserProfile;
import com.avito.android.remote.model.AdvertAction;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.SellerReplySpeed;
import com.avito.android.remote.model.advert_details.SellerOnlineStatus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/public_profile/remote/model/UserProfile;", "Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;", "advertActionIconFactory", "Lcom/avito/android/extended_profile/adapter/contact_bar/ContactBarItem;", "toContactBarItem", "(Lcom/avito/android/public_profile/remote/model/UserProfile;Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;)Lcom/avito/android/extended_profile/adapter/contact_bar/ContactBarItem;", "extended-profile_release"}, k = 2, mv = {1, 4, 2})
public final class ContactBarItemKt {
    @NotNull
    public static final ContactBarItem toContactBarItem(@NotNull UserProfile userProfile, @NotNull AdvertActionIconFactory advertActionIconFactory) {
        List list;
        List<AdvertAction> actions;
        ContactBar.ActionType actionType;
        Intrinsics.checkNotNullParameter(userProfile, "$this$toContactBarItem");
        Intrinsics.checkNotNullParameter(advertActionIconFactory, "advertActionIconFactory");
        AdvertActions contacts = userProfile.getContacts();
        if (contacts == null || (actions = contacts.getActions()) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list = new ArrayList(e.collectionSizeOrDefault(actions, 10));
            for (T t : actions) {
                Pair<Integer, Integer> actionIconRes = advertActionIconFactory.getActionIconRes(t);
                int intValue = actionIconRes.component1().intValue();
                int intValue2 = actionIconRes.component2().intValue();
                String title = t.getTitle();
                Integer valueOf = Integer.valueOf(intValue);
                DeepLink deepLink = t.getDeepLink();
                if (deepLink == null) {
                    deepLink = new NoMatchLink();
                }
                boolean z = t instanceof AdvertAction.Phone;
                if (z) {
                    actionType = ContactBar.ActionType.PHONE;
                } else if (t instanceof AdvertAction.Messenger) {
                    actionType = ContactBar.ActionType.MESSENGER;
                } else if (t instanceof AdvertAction.Access) {
                    actionType = ContactBar.ActionType.ACCESS;
                } else if (t instanceof AdvertAction.Buy) {
                    actionType = ContactBar.ActionType.BUY;
                } else if (t instanceof AdvertAction.Cart) {
                    actionType = ContactBar.ActionType.CART;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                Boolean disabled = t.getDisabled();
                list.add(new ContactBar.Action(title, valueOf, intValue2, deepLink, false, actionType, disabled != null ? disabled.booleanValue() : false, z, null, 256, null));
            }
        }
        String name = userProfile.getName();
        SellerReplySpeed replySpeed = userProfile.getReplySpeed();
        return new ContactBarItem(null, null, list, name, new SellerOnlineStatus(false, replySpeed != null ? replySpeed.getText() : null), 3, null);
    }
}
