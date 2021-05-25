package com.avito.android.push;

import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.avito.android.NotificationWorkFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.AppleSignInManagerKt;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/push/NotificationWorkFactoryImpl;", "Lcom/avito/android/NotificationWorkFactory;", "Lcom/avito/android/push/PushToken;", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "", "enqueuePushTokenUpdate", "(Lcom/avito/android/push/PushToken;)V", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "push_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationWorkFactoryImpl implements NotificationWorkFactory {
    public final Context a;

    @Inject
    public NotificationWorkFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.a = applicationContext;
    }

    @Override // com.avito.android.NotificationWorkFactory
    public void enqueuePushTokenUpdate(@Nullable PushToken pushToken) {
        Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        Intrinsics.checkNotNullExpressionValue(build, "Constraints.Builder()\n  …TED)\n            .build()");
        WorkRequest build2 = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(UpdateInstanceIdWorker.class).setConstraints(build)).addTag(UpdateInstanceIdWorker.WORK_TAG)).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 10000, TimeUnit.MILLISECONDS)).setInputData(UpdateInstanceIdWorker.Companion.createInputData(pushToken))).build();
        Intrinsics.checkNotNullExpressionValue(build2, "OneTimeWorkRequest.Build…en))\n            .build()");
        WorkManager.getInstance(this.a).beginUniqueWork(UpdateInstanceIdWorker.WORK_NAME, ExistingWorkPolicy.REPLACE, (OneTimeWorkRequest) build2).enqueue();
    }
}
