package com.avito.android.profile_phones.phones_list.actions;

import com.avito.android.profile_phones.phones_list.actions.items.ActionItem;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionItemsConverterImpl;", "Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionItemsConverter;", "", "phone", "", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem$Action;", "actions", "Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItem;", "convert", "(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneActionItemsConverterImpl implements PhoneActionItemsConverter {
    @Override // com.avito.android.profile_phones.phones_list.actions.PhoneActionItemsConverter
    @NotNull
    public List<ActionItem> convert(@NotNull String str, @NotNull List<PhoneListItem.Action> list) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(list, "actions");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new ActionItem(String.valueOf(i), str, t));
            i = i2;
        }
        return arrayList;
    }
}
