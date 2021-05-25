package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/CountResult;", "", "<init>", "()V", "Ok", "Unauthenticated", "Lcom/avito/android/remote/model/CountResult$Ok;", "Lcom/avito/android/remote/model/CountResult$Unauthenticated;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public abstract class CountResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/CountResult$Ok;", "Lcom/avito/android/remote/model/CountResult;", "", "count", "I", "getCount", "()I", "<init>", "(I)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends CountResult {
        private final int count;

        public Ok(int i) {
            super(null);
            this.count = i;
        }

        public final int getCount() {
            return this.count;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/CountResult$Unauthenticated;", "Lcom/avito/android/remote/model/CountResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Unauthenticated extends CountResult {
        @SerializedName("message")
        @Nullable
        private final String message;

        public Unauthenticated(@Nullable String str) {
            super(null);
            this.message = str;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }
    }

    private CountResult() {
    }

    public /* synthetic */ CountResult(j jVar) {
        this();
    }
}
