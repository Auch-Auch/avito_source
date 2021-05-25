package com.avito.android.job.cv_packages;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0016\u0010\b\u001a\u00020\u00078\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/Context;", "context", "", "resumeId", "Landroid/content/Intent;", "createCvPackagesActivityIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "", "PAYMENT_REQUEST_CODE", "I", "cv-packages_release"}, k = 2, mv = {1, 4, 2})
public final class JobCvPackagesActivityKt {
    public static final int PAYMENT_REQUEST_CODE = 1;

    @NotNull
    public static final Intent createCvPackagesActivityIntent(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "resumeId");
        Intent intent = new Intent(context, JobCvPackagesActivity.class);
        intent.putExtra("extra_resume_id", str);
        return intent;
    }
}
