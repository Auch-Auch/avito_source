package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
@VisibleForTesting
public interface zak {
    @Nullable
    Bundle getConnectionHint();

    boolean isConnected();
}
