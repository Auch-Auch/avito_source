package com.avito.android.social;

import android.app.Activity;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/social/SharingManager;", "Lcom/avito/android/social/IsSocialNetwork;", "Landroid/app/Activity;", "activity", "", "shouldRestoreShare", "(Landroid/app/Activity;)Z", "", "link", "Lkotlin/Function1;", "Lcom/avito/android/social/SharingManager$ShareError;", "", "errorListener", "share", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "ShareError", "social_release"}, k = 1, mv = {1, 4, 2})
public interface SharingManager extends IsSocialNetwork {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.social.SharingManager */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void share$default(SharingManager sharingManager, Activity activity, String str, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                sharingManager.share(activity, str, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: share");
        }

        public static boolean shouldRestoreShare(@NotNull SharingManager sharingManager, @NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return false;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/social/SharingManager$ShareError;", "", "<init>", "()V", "NoConnection", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lcom/avito/android/social/SharingManager$ShareError$NoConnection;", "Lcom/avito/android/social/SharingManager$ShareError$Unknown;", "social_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ShareError {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/social/SharingManager$ShareError$NoConnection;", "Lcom/avito/android/social/SharingManager$ShareError;", "<init>", "()V", "social_release"}, k = 1, mv = {1, 4, 2})
        public static final class NoConnection extends ShareError {
            public NoConnection() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/social/SharingManager$ShareError$Unknown;", "Lcom/avito/android/social/SharingManager$ShareError;", "<init>", "()V", "social_release"}, k = 1, mv = {1, 4, 2})
        public static final class Unknown extends ShareError {
            public Unknown() {
                super(null);
            }
        }

        public ShareError() {
        }

        public ShareError(j jVar) {
        }
    }

    void share(@NotNull Activity activity, @NotNull String str, @Nullable Function1<? super ShareError, Unit> function1);

    boolean shouldRestoreShare(@NotNull Activity activity);
}
