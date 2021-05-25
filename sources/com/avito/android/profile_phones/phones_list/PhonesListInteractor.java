package com.avito.android.profile_phones.phones_list;

import com.avito.android.profile_phones.phones_list.list_item.PhoneListItem;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListInteractor;", "", "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem;", "getPhonesList", "()Lio/reactivex/rxjava3/core/Single;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public interface PhonesListInteractor {
    @NotNull
    Single<List<PhoneListItem>> getPhonesList();
}
