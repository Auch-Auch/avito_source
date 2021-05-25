package com.avito.android.messenger.conversation.mvi.send;

import android.net.Uri;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;", "", "Landroid/net/Uri;", "sourceUri", "keep", "(Landroid/net/Uri;)Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "exists", "(Landroid/net/Uri;)Z", "", PhoneActionStrings.REMOVE, "(Landroid/net/Uri;)V", "", "timestamp", "deleteFilesModifiedBefore", "(J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerPhotoStorage {
    void delete(@NotNull Uri uri);

    void deleteFilesModifiedBefore(long j);

    boolean exists(@NotNull Uri uri);

    @Nullable
    Uri keep(@NotNull Uri uri);
}
