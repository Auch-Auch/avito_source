package com.avito.android.profile_phones.phones_list;

import com.avito.android.profile_phones.phones_list.list_item.PhoneListItem;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesConverterImpl;", "Lcom/avito/android/profile_phones/phones_list/PhonesConverter;", "", "Lcom/avito/android/remote/model/user_profile/Phone;", "phones", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem;", "convert", "(Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/profile_phones/phones_list/PhonesListResourceProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/profile_phones/phones_list/PhonesListResourceProvider;", "resourcesProvider", "<init>", "(Lcom/avito/android/profile_phones/phones_list/PhonesListResourceProvider;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhonesConverterImpl implements PhonesConverter {
    public final PhonesListResourceProvider a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PhoneListItem.Status.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[2] = 1;
            iArr[0] = 2;
            iArr[1] = 3;
        }
    }

    @Inject
    public PhonesConverterImpl(@NotNull PhonesListResourceProvider phonesListResourceProvider) {
        Intrinsics.checkNotNullParameter(phonesListResourceProvider, "resourcesProvider");
        this.a = phonesListResourceProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.profile_phones.phones_list.PhonesConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.avito.android.profile_phones.phones_list.list_item.PhoneListItem> convert(@org.jetbrains.annotations.NotNull java.util.List<com.avito.android.remote.model.user_profile.Phone> r18) {
        /*
        // Method dump skipped, instructions count: 246
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.profile_phones.phones_list.PhonesConverterImpl.convert(java.util.List):java.util.List");
    }
}
