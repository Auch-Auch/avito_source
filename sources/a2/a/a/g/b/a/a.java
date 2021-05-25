package a2.a.a.g.b.a;

import com.avito.android.remote.auth.AuthSource;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"La2/a/a/g/b/a/a;", "", "La2/a/a/g/b/a/b;", "bankData", "La2/a/a/g/b/a/b;", AuthSource.SEND_ABUSE, "()La2/a/a/g/b/a/b;", "", "requestId", "Ljava/lang/String;", AuthSource.BOOKING_ORDER, "()Ljava/lang/String;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class a {
    @SerializedName("bankData")
    @NotNull
    private final b bankData;
    @SerializedName("requestId")
    @NotNull
    private final String requestId;

    @NotNull
    public final b a() {
        return this.bankData;
    }

    @NotNull
    public final String b() {
        return this.requestId;
    }
}
