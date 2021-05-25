package com.avito.android.push.debug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.push.DaggerMessagingComponent;
import com.avito.android.push.MessagingDependencies;
import com.avito.android.push.MessagingServiceDelegate;
import com.avito.android.push.Push;
import com.avito.android.util.Logs;
import com.facebook.share.internal.ShareConstants;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/push/debug/DebugMessagingReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lcom/avito/android/push/MessagingServiceDelegate;", "delegate", "Lcom/avito/android/push/MessagingServiceDelegate;", "getDelegate$push_release", "()Lcom/avito/android/push/MessagingServiceDelegate;", "setDelegate$push_release", "(Lcom/avito/android/push/MessagingServiceDelegate;)V", "<init>", "()V", "push_release"}, k = 1, mv = {1, 4, 2})
public abstract class DebugMessagingReceiver extends BroadcastReceiver {
    @Inject
    public MessagingServiceDelegate delegate;

    @NotNull
    public final MessagingServiceDelegate getDelegate$push_release() {
        MessagingServiceDelegate messagingServiceDelegate = this.delegate;
        if (messagingServiceDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return messagingServiceDelegate;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logs.debug$default("DebugMessagingReceiver", "Received intent: " + intent, null, 4, null);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "appContext");
        DaggerMessagingComponent.factory().create((MessagingDependencies) ComponentDependenciesKt.getDependencies(MessagingDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(applicationContext))).inject(this);
        if (intent != null) {
            Map mapOf = r.mapOf(TuplesKt.to(ShareConstants.MEDIA_URI, intent.getStringExtra(ShareConstants.MEDIA_URI)), TuplesKt.to("notification", intent.getStringExtra("notification")));
            Logs.verbose$default("DebugMessagingReceiver", "data=" + mapOf, null, 4, null);
            Push push = new Push(mapOf, null, 0, 0, 0, 0, 62, null);
            MessagingServiceDelegate messagingServiceDelegate = this.delegate;
            if (messagingServiceDelegate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("delegate");
            }
            messagingServiceDelegate.handlePush(applicationContext, push);
        }
    }

    public final void setDelegate$push_release(@NotNull MessagingServiceDelegate messagingServiceDelegate) {
        Intrinsics.checkNotNullParameter(messagingServiceDelegate, "<set-?>");
        this.delegate = messagingServiceDelegate;
    }
}
