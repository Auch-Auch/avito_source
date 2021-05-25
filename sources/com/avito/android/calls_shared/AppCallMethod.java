package com.avito.android.calls_shared;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/calls_shared/AppCallMethod;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "InAppCall", "None", "PhoneCall", "Lcom/avito/android/calls_shared/AppCallMethod$InAppCall;", "Lcom/avito/android/calls_shared/AppCallMethod$PhoneCall;", "Lcom/avito/android/calls_shared/AppCallMethod$None;", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public abstract class AppCallMethod {
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/AppCallMethod$InAppCall;", "Lcom/avito/android/calls_shared/AppCallMethod;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class InAppCall extends AppCallMethod {
        @NotNull
        public static final InAppCall INSTANCE = new InAppCall();

        public InAppCall() {
            super("InApp", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/AppCallMethod$None;", "Lcom/avito/android/calls_shared/AppCallMethod;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class None extends AppCallMethod {
        @NotNull
        public static final None INSTANCE = new None();

        public None() {
            super("Cancel", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/AppCallMethod$PhoneCall;", "Lcom/avito/android/calls_shared/AppCallMethod;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class PhoneCall extends AppCallMethod {
        @NotNull
        public static final PhoneCall INSTANCE = new PhoneCall();

        public PhoneCall() {
            super("Phone", null);
        }
    }

    public AppCallMethod(String str, j jVar) {
        this.a = str;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }
}
