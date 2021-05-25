package com.avito.android.publish.sts_scanner;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Dimension;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/avito/android/publish/sts_scanner/StsScannerFragment;", "createStsScannerFragment", "()Lcom/avito/android/publish/sts_scanner/StsScannerFragment;", "Lcom/avito/android/util/Dimension;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/Dimension;", "PHOTO_SIZE", "publish_release"}, k = 2, mv = {1, 4, 2})
public final class StsScannerFragmentKt {
    public static final Dimension a = new Dimension(960, 1280);

    @NotNull
    public static final StsScannerFragment createStsScannerFragment() {
        return new StsScannerFragment();
    }
}
