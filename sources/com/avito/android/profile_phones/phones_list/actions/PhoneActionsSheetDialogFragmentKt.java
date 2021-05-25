package com.avito.android.profile_phones.phones_list.actions;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionsSheetDialogArguments;", "arguments", "Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionsSheetDialogFragment;", "createPhoneActionsSheetDialogFragment", "(Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionsSheetDialogArguments;)Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionsSheetDialogFragment;", "profile-phones_release"}, k = 2, mv = {1, 4, 2})
public final class PhoneActionsSheetDialogFragmentKt {
    @NotNull
    public static final PhoneActionsSheetDialogFragment createPhoneActionsSheetDialogFragment(@NotNull PhoneActionsSheetDialogArguments phoneActionsSheetDialogArguments) {
        Intrinsics.checkNotNullParameter(phoneActionsSheetDialogArguments, "arguments");
        PhoneActionsSheetDialogFragment phoneActionsSheetDialogFragment = new PhoneActionsSheetDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arguments", phoneActionsSheetDialogArguments);
        phoneActionsSheetDialogFragment.setArguments(bundle);
        return phoneActionsSheetDialogFragment;
    }
}
