package com.avito.android.public_profile.remote.model;

import com.avito.android.remote.auth.AuthSource;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/public_profile/remote/model/LegacyPublicProfileResult;", "", "<init>", "()V", "FailedWithMessage", "Ok", "UserBanned", "UserRemoved", "Lcom/avito/android/public_profile/remote/model/LegacyPublicProfileResult$Ok;", "Lcom/avito/android/public_profile/remote/model/LegacyPublicProfileResult$FailedWithMessage;", "Lcom/avito/android/public_profile/remote/model/LegacyPublicProfileResult$UserBanned;", "Lcom/avito/android/public_profile/remote/model/LegacyPublicProfileResult$UserRemoved;", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class LegacyPublicProfileResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/public_profile/remote/model/LegacyPublicProfileResult$FailedWithMessage;", "Lcom/avito/android/public_profile/remote/model/LegacyPublicProfileResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class FailedWithMessage extends LegacyPublicProfileResult {
        @SerializedName("message")
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FailedWithMessage(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/public_profile/remote/model/LegacyPublicProfileResult$Ok;", "Lcom/avito/android/public_profile/remote/model/LegacyPublicProfileResult;", "Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;", AuthSource.SEND_ABUSE, "Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;", "getProfile", "()Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;", "profile", "<init>", "(Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends LegacyPublicProfileResult {
        @NotNull
        public final DefaultPublicUserProfile a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull DefaultPublicUserProfile defaultPublicUserProfile) {
            super(null);
            Intrinsics.checkNotNullParameter(defaultPublicUserProfile, "profile");
            this.a = defaultPublicUserProfile;
        }

        @NotNull
        public final DefaultPublicUserProfile getProfile() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/public_profile/remote/model/LegacyPublicProfileResult$UserBanned;", "Lcom/avito/android/public_profile/remote/model/LegacyPublicProfileResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserBanned extends LegacyPublicProfileResult {
        @SerializedName("message")
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UserBanned(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/public_profile/remote/model/LegacyPublicProfileResult$UserRemoved;", "Lcom/avito/android/public_profile/remote/model/LegacyPublicProfileResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserRemoved extends LegacyPublicProfileResult {
        @SerializedName("message")
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UserRemoved(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    public LegacyPublicProfileResult() {
    }

    public LegacyPublicProfileResult(j jVar) {
    }
}
