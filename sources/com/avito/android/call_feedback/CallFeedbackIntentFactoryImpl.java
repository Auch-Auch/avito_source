package com.avito.android.call_feedback;

import android.app.Application;
import android.content.Intent;
import com.avito.android.CallFeedbackIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/call_feedback/CallFeedbackIntentFactoryImpl;", "Lcom/avito/android/CallFeedbackIntentFactory;", "", "id", "Landroid/content/Intent;", "callFeedbackIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
public final class CallFeedbackIntentFactoryImpl implements CallFeedbackIntentFactory {
    public final Application a;

    @Inject
    public CallFeedbackIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @Override // com.avito.android.CallFeedbackIntentFactory
    @NotNull
    public Intent callFeedbackIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return CallFeedbackActivityKt.createCallFeedbackActivityIntent(this.a, str);
    }
}
