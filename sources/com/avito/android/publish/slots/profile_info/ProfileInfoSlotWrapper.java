package com.avito.android.publish.slots.profile_info;

import com.avito.android.publish.ContactsDataSource;
import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.SlotWrapper;
import com.avito.android.publish.slots.contact_info.ContactsData;
import com.avito.android.publish.slots.profile_info.item.UserInfoItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.profile_info.ProfileInfoSlot;
import com.avito.android.remote.model.category_parameters.slot.profile_info.ProfileInfoSlotConfig;
import com.avito.android.util.LoadingState;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/publish/slots/profile_info/ProfileInfoSlotWrapper;", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/profile_info/ProfileInfoSlot;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "", "prepare", "()Lio/reactivex/Observable;", "", "getId", "()Ljava/lang/String;", "", "Lcom/avito/conveyor_item/Item;", "getElements", "()Ljava/util/List;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/category_parameters/slot/profile_info/ProfileInfoSlot;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/slot/profile_info/ProfileInfoSlot;", "slot", "Lcom/avito/android/publish/slots/profile_info/PublishContactsStringProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/slots/profile_info/PublishContactsStringProvider;", "stringProvider", "Lcom/avito/android/publish/ContactsDataSource;", "c", "Lcom/avito/android/publish/ContactsDataSource;", "contactsDataSource", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/profile_info/ProfileInfoSlot;Lcom/avito/android/publish/slots/profile_info/PublishContactsStringProvider;Lcom/avito/android/publish/ContactsDataSource;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileInfoSlotWrapper implements SlotWrapper<ProfileInfoSlot> {
    @NotNull
    public final ProfileInfoSlot a;
    public final PublishContactsStringProvider b;
    public final ContactsDataSource c;

    public ProfileInfoSlotWrapper(@NotNull ProfileInfoSlot profileInfoSlot, @NotNull PublishContactsStringProvider publishContactsStringProvider, @NotNull ContactsDataSource contactsDataSource) {
        Intrinsics.checkNotNullParameter(profileInfoSlot, "slot");
        Intrinsics.checkNotNullParameter(publishContactsStringProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(contactsDataSource, "contactsDataSource");
        this.a = profileInfoSlot;
        this.b = publishContactsStringProvider;
        this.c = contactsDataSource;
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public Observable<LoadingState<SuccessResult>> checkErrors() {
        return SlotWrapper.DefaultImpls.checkErrors(this);
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ConsumeValueChangeResult consumeItemValueChange(@Nullable Item item, @Nullable ParameterSlot parameterSlot) {
        return SlotWrapper.DefaultImpls.consumeItemValueChange(this, item, parameterSlot);
    }

    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public List<Item> getElements() {
        UserInfoItem userInfoItem;
        List<Item> listOf;
        UserIconType userIconType;
        ContactsData contactsData = this.c.getContactsData();
        if (contactsData != null) {
            String name = contactsData.isIncomplete() ? "" : contactsData.getName();
            if (name == null || name.length() == 0) {
                userInfoItem = null;
            } else {
                String id = ((ProfileInfoSlotConfig) getSlot().getWidget().getConfig()).getField().getId();
                if (contactsData.isShop()) {
                    userIconType = UserIconType.SHOP;
                } else if (contactsData.isCompany()) {
                    userIconType = UserIconType.COMPANY;
                } else {
                    userIconType = UserIconType.PRIVATE;
                }
                userInfoItem = new UserInfoItem(id, name, userIconType, contactsData.getAvatar(), contactsData.getRating());
            }
            if (!(userInfoItem == null || (listOf = d.listOf(userInfoItem)) == null)) {
                return listOf;
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public String getId() {
        return getSlot().getId();
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public Observable<LoadingState<Unit>> prepare() {
        return this.c.prepareContactsData(null);
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ProfileInfoSlot getSlot() {
        return this.a;
    }
}
