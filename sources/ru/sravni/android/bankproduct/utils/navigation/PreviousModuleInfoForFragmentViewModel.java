package ru.sravni.android.bankproduct.utils.navigation;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R(\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00038V@VX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0013"}, d2 = {"Lru/sravni/android/bankproduct/utils/navigation/PreviousModuleInfoForFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", "", "c", "Ljava/lang/String;", "_currentModuleName", "d", "_previousModuleInfo", "value", "getCurrentModuleName", "()Ljava/lang/String;", "setCurrentModuleName", "(Ljava/lang/String;)V", "currentModuleName", "getPreviousModuleName", "previousModuleName", "initModuleName", "<init>", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class PreviousModuleInfoForFragmentViewModel extends ViewModel implements IPreviousModuleInfoController {
    public String c;
    public String d = "defaultRootModule";

    public PreviousModuleInfoForFragmentViewModel(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "initModuleName");
        this.c = str;
    }

    @Override // ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfoController
    @Nullable
    public String getCurrentModuleName() {
        return this.c;
    }

    @Override // ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo
    @NotNull
    public String getPreviousModuleName() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfoController
    public void setCurrentModuleName(@Nullable String str) {
        if (str != null && (!Intrinsics.areEqual(str, this.c))) {
            this.d = this.c;
            this.c = str;
        }
    }
}
