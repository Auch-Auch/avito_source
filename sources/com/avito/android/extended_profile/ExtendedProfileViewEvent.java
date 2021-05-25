package com.avito.android.extended_profile;

import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewEvent;", "", "<init>", "()V", "ConfirmCallEvent", "DoNothing", "HideProgressAsDialogEvent", "LoadingErrorEvent", "ShowDataEvent", "ShowProgressAsDialogEvent", "ShowProgressEvent", "ShowUserBannedEvent", "ShowUserRemovedEvent", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$ShowProgressEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$ShowDataEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$ShowProgressAsDialogEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$HideProgressAsDialogEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$DoNothing;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$LoadingErrorEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$ConfirmCallEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$ShowUserBannedEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$ShowUserRemovedEvent;", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class ExtendedProfileViewEvent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$ConfirmCallEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent;", "Lcom/avito/android/deep_linking/links/PhoneLink$Call;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/PhoneLink$Call;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/PhoneLink$Call;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/PhoneLink$Call;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class ConfirmCallEvent extends ExtendedProfileViewEvent {
        @NotNull
        public final PhoneLink.Call a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ConfirmCallEvent(@NotNull PhoneLink.Call call) {
            super(null);
            Intrinsics.checkNotNullParameter(call, "deepLink");
            this.a = call;
        }

        @NotNull
        public final PhoneLink.Call getDeepLink() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$DoNothing;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent;", "<init>", "()V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class DoNothing extends ExtendedProfileViewEvent {
        @NotNull
        public static final DoNothing INSTANCE = new DoNothing();

        public DoNothing() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$HideProgressAsDialogEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent;", "<init>", "()V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class HideProgressAsDialogEvent extends ExtendedProfileViewEvent {
        @NotNull
        public static final HideProgressAsDialogEvent INSTANCE = new HideProgressAsDialogEvent();

        public HideProgressAsDialogEvent() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$LoadingErrorEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class LoadingErrorEvent extends ExtendedProfileViewEvent {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadingErrorEvent(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @NotNull
        public final String getMessage() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$ShowDataEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent;", "<init>", "()V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShowDataEvent extends ExtendedProfileViewEvent {
        @NotNull
        public static final ShowDataEvent INSTANCE = new ShowDataEvent();

        public ShowDataEvent() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$ShowProgressAsDialogEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent;", "<init>", "()V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShowProgressAsDialogEvent extends ExtendedProfileViewEvent {
        @NotNull
        public static final ShowProgressAsDialogEvent INSTANCE = new ShowProgressAsDialogEvent();

        public ShowProgressAsDialogEvent() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$ShowProgressEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent;", "<init>", "()V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShowProgressEvent extends ExtendedProfileViewEvent {
        @NotNull
        public static final ShowProgressEvent INSTANCE = new ShowProgressEvent();

        public ShowProgressEvent() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$ShowUserBannedEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShowUserBannedEvent extends ExtendedProfileViewEvent {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowUserBannedEvent(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @NotNull
        public final String getMessage() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewEvent$ShowUserRemovedEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShowUserRemovedEvent extends ExtendedProfileViewEvent {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowUserRemovedEvent(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @NotNull
        public final String getMessage() {
            return this.a;
        }
    }

    public ExtendedProfileViewEvent() {
    }

    public ExtendedProfileViewEvent(j jVar) {
    }
}
