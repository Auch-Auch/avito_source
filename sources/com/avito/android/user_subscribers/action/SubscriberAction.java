package com.avito.android.user_subscribers.action;

import android.net.Uri;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/user_subscribers/action/SubscriberAction;", "", "<init>", "()V", "LoadPage", "OpenDeepLink", "Retry", "Lcom/avito/android/user_subscribers/action/SubscriberAction$OpenDeepLink;", "Lcom/avito/android/user_subscribers/action/SubscriberAction$LoadPage;", "Lcom/avito/android/user_subscribers/action/SubscriberAction$Retry;", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
public abstract class SubscriberAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/user_subscribers/action/SubscriberAction$LoadPage;", "Lcom/avito/android/user_subscribers/action/SubscriberAction;", "Landroid/net/Uri;", AuthSource.SEND_ABUSE, "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", ShareConstants.MEDIA_URI, "<init>", "(Landroid/net/Uri;)V", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
    public static final class LoadPage extends SubscriberAction {
        @Nullable
        public final Uri a;

        public LoadPage(@Nullable Uri uri) {
            super(null);
            this.a = uri;
        }

        @Nullable
        public final Uri getUri() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/user_subscribers/action/SubscriberAction$OpenDeepLink;", "Lcom/avito/android/user_subscribers/action/SubscriberAction;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
    public static final class OpenDeepLink extends SubscriberAction {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OpenDeepLink(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/user_subscribers/action/SubscriberAction$Retry;", "Lcom/avito/android/user_subscribers/action/SubscriberAction;", "Landroid/net/Uri;", AuthSource.SEND_ABUSE, "Landroid/net/Uri;", "getFailedUri", "()Landroid/net/Uri;", "failedUri", "<init>", "(Landroid/net/Uri;)V", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
    public static final class Retry extends SubscriberAction {
        @Nullable
        public final Uri a;

        public Retry(@Nullable Uri uri) {
            super(null);
            this.a = uri;
        }

        @Nullable
        public final Uri getFailedUri() {
            return this.a;
        }
    }

    public SubscriberAction() {
    }

    public SubscriberAction(j jVar) {
    }
}
