package com.avito.android.select.bottom_sheet;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.avito.android.select.Arguments;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/fragment/app/Fragment;", "targetFragment", "Lcom/avito/android/select/Arguments;", "arguments", "Lcom/avito/android/select/bottom_sheet/SelectBottomSheetFragment;", "createSelectSheetDialogFragment", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/select/Arguments;)Lcom/avito/android/select/bottom_sheet/SelectBottomSheetFragment;", "select_release"}, k = 2, mv = {1, 4, 2})
public final class SelectBottomSheetFragmentKt {
    @NotNull
    public static final SelectBottomSheetFragment createSelectSheetDialogFragment(@Nullable Fragment fragment, @NotNull Arguments arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        SelectBottomSheetFragment selectBottomSheetFragment = new SelectBottomSheetFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arguments", arguments);
        selectBottomSheetFragment.setArguments(bundle);
        selectBottomSheetFragment.setTargetFragment(fragment, 0);
        return selectBottomSheetFragment;
    }
}
