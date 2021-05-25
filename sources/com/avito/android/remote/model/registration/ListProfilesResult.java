package com.avito.android.remote.model.registration;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/registration/ListProfilesResult;", "", "<init>", "()V", "Failure", "Ok", "Lcom/avito/android/remote/model/registration/ListProfilesResult$Ok;", "Lcom/avito/android/remote/model/registration/ListProfilesResult$Failure;", "profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class ListProfilesResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/registration/ListProfilesResult$Failure;", "Lcom/avito/android/remote/model/registration/ListProfilesResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Failure extends ListProfilesResult {
        @SerializedName("message")
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failure(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/registration/ListProfilesResult$Ok;", "Lcom/avito/android/remote/model/registration/ListProfilesResult;", "", "Lcom/avito/android/remote/model/registration/RegisteredProfile;", "profiles", "Ljava/util/List;", "getProfiles", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends ListProfilesResult {
        @SerializedName("profiles")
        @NotNull
        private final List<RegisteredProfile> profiles;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull List<RegisteredProfile> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "profiles");
            this.profiles = list;
        }

        @NotNull
        public final List<RegisteredProfile> getProfiles() {
            return this.profiles;
        }
    }

    private ListProfilesResult() {
    }

    public /* synthetic */ ListProfilesResult(j jVar) {
        this();
    }
}
