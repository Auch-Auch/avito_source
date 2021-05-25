package com.avito.android;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushService;
import com.avito.android.messenger.service.direct_reply.DirectReplyIntentServiceKt;
import com.avito.android.photo_picker.legacy.service.ImageUploadServiceKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ/\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/MessengerServiceIntentFactoryImpl;", "Lcom/avito/android/MessengerServiceIntentFactory;", "", "operationId", "toString", "", "uploadAfterNonRestorableError", "Landroid/content/Intent;", "imageUploadServiceIntent", "(Ljava/lang/String;Ljava/lang/String;Z)Landroid/content/Intent;", "channelId", "text", "isRetry", MessageBody.RANDOM_ID, "sendMessageServiceIntent", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Landroid/content/Intent;", "directReplyKey", "", "notificationId", "notificationTag", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Landroid/content/Intent;", "", "channelSyncOnPushServiceEnqueueWork", "(Ljava/lang/String;)V", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerServiceIntentFactoryImpl implements MessengerServiceIntentFactory {
    public final Context a;

    @Inject
    public MessengerServiceIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.a = applicationContext;
    }

    @Override // com.avito.android.MessengerServiceIntentFactory
    public void channelSyncOnPushServiceEnqueueWork(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        ChannelSyncOnPushService.Companion.enqueueWork(this.a, str);
    }

    @Override // com.avito.android.MessengerServiceIntentFactory
    @NotNull
    public Intent imageUploadServiceIntent(@NotNull String str, @Nullable String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "operationId");
        return ImageUploadServiceKt.createImageUploadServiceIntent(this.a, str, str2, z);
    }

    @Override // com.avito.android.MessengerServiceIntentFactory
    @NotNull
    public Intent sendMessageServiceIntent(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3) {
        a.Z0(str, "channelId", str2, "text", str3, MessageBody.RANDOM_ID);
        return DirectReplyIntentServiceKt.createSendMessageServiceIntent(this.a, str, str2, z, str3);
    }

    @Override // com.avito.android.MessengerServiceIntentFactory
    @NotNull
    public Intent sendMessageServiceIntent(@NotNull String str, @NotNull String str2, int i, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "directReplyKey");
        return DirectReplyIntentServiceKt.createSendMessageServiceIntent(this.a, str, str2, i, str3);
    }
}
