package com.avito.android.public_profile.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/public_profile/remote/model/PublicProfileResult;", "", "<init>", "()V", "FailedWithMessage", "Ok", "UserBanned", "UserRemoved", "Lcom/avito/android/public_profile/remote/model/PublicProfileResult$Ok;", "Lcom/avito/android/public_profile/remote/model/PublicProfileResult$FailedWithMessage;", "Lcom/avito/android/public_profile/remote/model/PublicProfileResult$UserBanned;", "Lcom/avito/android/public_profile/remote/model/PublicProfileResult$UserRemoved;", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class PublicProfileResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/public_profile/remote/model/PublicProfileResult$FailedWithMessage;", "Lcom/avito/android/public_profile/remote/model/PublicProfileResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class FailedWithMessage extends PublicProfileResult {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/public_profile/remote/model/PublicProfileResult$Ok;", "Lcom/avito/android/public_profile/remote/model/PublicProfileResult;", "Lcom/avito/android/public_profile/remote/model/PublicUserProfile;", "profile", "Lcom/avito/android/public_profile/remote/model/PublicUserProfile;", "getProfile", "()Lcom/avito/android/public_profile/remote/model/PublicUserProfile;", "<init>", "(Lcom/avito/android/public_profile/remote/model/PublicUserProfile;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends PublicProfileResult {
        @SerializedName("profile")
        @NotNull
        private final PublicUserProfile profile;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull PublicUserProfile publicUserProfile) {
            super(null);
            Intrinsics.checkNotNullParameter(publicUserProfile, "profile");
            this.profile = publicUserProfile;
        }

        @NotNull
        public final PublicUserProfile getProfile() {
            return this.profile;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/public_profile/remote/model/PublicProfileResult$UserBanned;", "Lcom/avito/android/public_profile/remote/model/PublicProfileResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserBanned extends PublicProfileResult {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/public_profile/remote/model/PublicProfileResult$UserRemoved;", "Lcom/avito/android/public_profile/remote/model/PublicProfileResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserRemoved extends PublicProfileResult {
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

    public PublicProfileResult() {
    }

    public PublicProfileResult(j jVar) {
    }
}
