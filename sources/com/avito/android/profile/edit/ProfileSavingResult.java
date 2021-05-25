package com.avito.android.profile.edit;

import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/profile/edit/ProfileSavingResult;", "", "<init>", "()V", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Invalidate", "ItemsNotActual", "PhoneNotConfirmed", "Lcom/avito/android/profile/edit/ProfileSavingResult$Failed;", "Lcom/avito/android/profile/edit/ProfileSavingResult$Completed;", "Lcom/avito/android/profile/edit/ProfileSavingResult$Invalidate;", "profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class ProfileSavingResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile/edit/ProfileSavingResult$Completed;", "Lcom/avito/android/profile/edit/ProfileSavingResult;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static class Completed extends ProfileSavingResult {
        public Completed() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/profile/edit/ProfileSavingResult$Failed;", "Lcom/avito/android/profile/edit/ProfileSavingResult;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getError", "()Ljava/lang/Throwable;", "error", "<init>", "(Ljava/lang/Throwable;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static class Failed extends ProfileSavingResult {
        @NotNull
        public final Throwable a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failed(@NotNull Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "error");
            this.a = th;
        }

        @NotNull
        public final Throwable getError() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\n\u0010\u000bR%\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/profile/edit/ProfileSavingResult$Invalidate;", "Lcom/avito/android/profile/edit/ProfileSavingResult;", "", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getErrors", "()Ljava/util/Map;", "errors", "<init>", "(Ljava/util/Map;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Invalidate extends ProfileSavingResult {
        @NotNull
        public final Map<Long, String> a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Invalidate(@NotNull Map<Long, String> map) {
            super(null);
            Intrinsics.checkNotNullParameter(map, "errors");
            this.a = map;
        }

        @NotNull
        public final Map<Long, String> getErrors() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/avito/android/profile/edit/ProfileSavingResult$ItemsNotActual;", "Lcom/avito/android/profile/edit/ProfileSavingResult$Failed;", "", "Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "", "error", "<init>", "(Ljava/lang/Throwable;Ljava/util/List;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class ItemsNotActual extends Failed {
        @NotNull
        public final List<EditProfileItem> b;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.profile.edit.refactoring.adapter.EditProfileItem> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemsNotActual(@NotNull Throwable th, @NotNull List<? extends EditProfileItem> list) {
            super(th);
            Intrinsics.checkNotNullParameter(th, "error");
            Intrinsics.checkNotNullParameter(list, "items");
            this.b = list;
        }

        @NotNull
        public final List<EditProfileItem> getItems() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/profile/edit/ProfileSavingResult$PhoneNotConfirmed;", "Lcom/avito/android/profile/edit/ProfileSavingResult$Completed;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhoneNumber", "()Ljava/lang/String;", "phoneNumber", "<init>", "(Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class PhoneNotConfirmed extends Completed {
        @NotNull
        public final String a;

        public PhoneNotConfirmed(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "phoneNumber");
            this.a = str;
        }

        @NotNull
        public final String getPhoneNumber() {
            return this.a;
        }
    }

    public ProfileSavingResult() {
    }

    public ProfileSavingResult(j jVar) {
    }
}
