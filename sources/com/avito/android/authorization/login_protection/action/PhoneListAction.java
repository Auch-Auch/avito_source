package com.avito.android.authorization.login_protection.action;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/authorization/login_protection/action/PhoneListAction;", "", "<init>", "()V", "AnotherPhoneClickAction", "PhoneClickAction", "Lcom/avito/android/authorization/login_protection/action/PhoneListAction$PhoneClickAction;", "Lcom/avito/android/authorization/login_protection/action/PhoneListAction$AnotherPhoneClickAction;", "authorization_release"}, k = 1, mv = {1, 4, 2})
public abstract class PhoneListAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/authorization/login_protection/action/PhoneListAction$AnotherPhoneClickAction;", "Lcom/avito/android/authorization/login_protection/action/PhoneListAction;", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public static final class AnotherPhoneClickAction extends PhoneListAction {
        @NotNull
        public static final AnotherPhoneClickAction INSTANCE = new AnotherPhoneClickAction();

        public AnotherPhoneClickAction() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/authorization/login_protection/action/PhoneListAction$PhoneClickAction;", "Lcom/avito/android/authorization/login_protection/action/PhoneListAction;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "phone", "<init>", "(Ljava/lang/String;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public static final class PhoneClickAction extends PhoneListAction {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PhoneClickAction(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "phone");
            this.a = str;
        }

        @NotNull
        public final String getPhone() {
            return this.a;
        }
    }

    public PhoneListAction() {
    }

    public PhoneListAction(j jVar) {
    }
}
