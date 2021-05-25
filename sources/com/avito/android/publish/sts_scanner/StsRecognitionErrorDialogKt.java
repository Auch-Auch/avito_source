package com.avito.android.publish.sts_scanner;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/avito/android/publish/sts_scanner/StsRecognitionErrorDialogListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showStsRecognitionErrorDialogFragment", "(Landroidx/fragment/app/FragmentManager;Lcom/avito/android/publish/sts_scanner/StsRecognitionErrorDialogListener;)V", "publish_release"}, k = 2, mv = {1, 4, 2})
public final class StsRecognitionErrorDialogKt {
    public static final void showStsRecognitionErrorDialogFragment(@NotNull FragmentManager fragmentManager, @NotNull StsRecognitionErrorDialogListener stsRecognitionErrorDialogListener) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(stsRecognitionErrorDialogListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag("sts_recognition_error_dialog");
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
        }
        beginTransaction.addToBackStack(null);
        new StsRecognitionErrorDialog().setListener(stsRecognitionErrorDialogListener).show(beginTransaction, "sts_recognition_error_dialog");
    }
}
