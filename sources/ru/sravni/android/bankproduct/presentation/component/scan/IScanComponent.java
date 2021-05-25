package ru.sravni.android.bankproduct.presentation.component.scan;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lru/sravni/android/bankproduct/presentation/component/scan/IScanComponent;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "startScan", "(Landroidx/fragment/app/Fragment;)V", "", "requestCode", "resultCode", "Landroid/os/Bundle;", "data", "onScanResult", "(IILandroid/os/Bundle;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IScanComponent {
    void onScanResult(int i, int i2, @Nullable Bundle bundle);

    void startScan(@NotNull Fragment fragment);
}
