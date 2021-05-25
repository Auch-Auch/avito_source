package com.avito.android;

import android.content.Intent;
import com.avito.android.remote.model.messenger.message.MessageBody;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ/\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000e\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/MessengerServiceIntentFactory;", "", "", "operationId", "toString", "", "uploadAfterNonRestorableError", "Landroid/content/Intent;", "imageUploadServiceIntent", "(Ljava/lang/String;Ljava/lang/String;Z)Landroid/content/Intent;", "channelId", "text", "isRetry", MessageBody.RANDOM_ID, "sendMessageServiceIntent", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Landroid/content/Intent;", "directReplyKey", "", "notificationId", "notificationTag", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Landroid/content/Intent;", "", "channelSyncOnPushServiceEnqueueWork", "(Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerServiceIntentFactory {
    void channelSyncOnPushServiceEnqueueWork(@NotNull String str);

    @NotNull
    Intent imageUploadServiceIntent(@NotNull String str, @Nullable String str2, boolean z);

    @NotNull
    Intent sendMessageServiceIntent(@NotNull String str, @NotNull String str2, int i, @Nullable String str3);

    @NotNull
    Intent sendMessageServiceIntent(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3);
}
