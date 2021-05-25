package com.avito.android.util;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
@Deprecated
public interface BundlePersistable {
    void onRestoreState(@Nullable Bundle bundle);

    @Nullable
    Bundle onSaveState();

    void onSaveState(@NonNull Bundle bundle);
}
