package com.avito.android.publish.wizard;

import android.os.Bundle;
import com.avito.android.remote.model.Navigation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aU\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\f\u0010\r\"\u0016\u0010\u000e\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u0016\u0010\u0010\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"", "itemId", "Lcom/avito/android/remote/model/Navigation;", "navigation", "", "showAlwaysArrow", "", "rootLevel", "", "leaves", "stepId", "Lcom/avito/android/publish/wizard/WizardFragment;", "createWizardFragment", "(Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;ZLjava/lang/Integer;Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/publish/wizard/WizardFragment;", "LEVEL_VERTICALS", "I", "LEVEL_ROOT", "publish_release"}, k = 2, mv = {1, 4, 2})
public final class WizardFragmentKt {
    public static final int LEVEL_ROOT = 0;
    public static final int LEVEL_VERTICALS = 1;

    @NotNull
    public static final WizardFragment createWizardFragment(@Nullable String str, @NotNull Navigation navigation, boolean z, @Nullable Integer num, @Nullable List<Navigation> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_always_arrow", z);
        bundle.putString("key_item_id", str);
        bundle.putParcelable("key_navigation", navigation);
        if (num != null) {
            num.intValue();
            bundle.putInt("key_root_level", num.intValue());
        }
        if (list != null) {
            bundle.putParcelableArrayList("key_leaves", new ArrayList<>(list));
        }
        if (str2 != null) {
            bundle.putString("key_step_id", str2);
        }
        WizardFragment wizardFragment = new WizardFragment();
        wizardFragment.setArguments(bundle);
        return wizardFragment;
    }

    public static /* synthetic */ WizardFragment createWizardFragment$default(String str, Navigation navigation, boolean z, Integer num, List list, String str2, int i, Object obj) {
        return createWizardFragment((i & 1) != 0 ? null : str, navigation, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : str2);
    }
}
