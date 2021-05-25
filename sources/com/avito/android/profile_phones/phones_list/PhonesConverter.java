package com.avito.android.profile_phones.phones_list;

import com.avito.android.profile_phones.phones_list.list_item.PhoneListItem;
import com.avito.android.remote.model.user_profile.Phone;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesConverter;", "", "", "Lcom/avito/android/remote/model/user_profile/Phone;", "phones", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem;", "convert", "(Ljava/util/List;)Ljava/util/List;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public interface PhonesConverter {
    @NotNull
    List<PhoneListItem> convert(@NotNull List<Phone> list);
}
