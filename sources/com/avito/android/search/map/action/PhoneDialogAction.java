package com.avito.android.search.map.action;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/PhoneDialogAction;", "Lcom/avito/android/search/map/action/MapAction;", "<init>", "()V", "CallUnavailable", "UserCancelCall", "UserMakeCall", "Lcom/avito/android/search/map/action/PhoneDialogAction$UserMakeCall;", "Lcom/avito/android/search/map/action/PhoneDialogAction$UserCancelCall;", "Lcom/avito/android/search/map/action/PhoneDialogAction$CallUnavailable;", "map_release"}, k = 1, mv = {1, 4, 2})
public abstract class PhoneDialogAction implements MapAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/PhoneDialogAction$CallUnavailable;", "Lcom/avito/android/search/map/action/PhoneDialogAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class CallUnavailable extends PhoneDialogAction {
        public CallUnavailable() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/PhoneDialogAction$UserCancelCall;", "Lcom/avito/android/search/map/action/PhoneDialogAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserCancelCall extends PhoneDialogAction {
        public UserCancelCall() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/PhoneDialogAction$UserMakeCall;", "Lcom/avito/android/search/map/action/PhoneDialogAction;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAdvertId", "()Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Ljava/lang/String;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserMakeCall extends PhoneDialogAction {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UserMakeCall(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            this.a = str;
        }

        @NotNull
        public final String getAdvertId() {
            return this.a;
        }
    }

    public PhoneDialogAction() {
    }

    public PhoneDialogAction(j jVar) {
    }
}
