package a2.a.a.g.b.a;

import com.avito.android.remote.auth.AuthSource;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"La2/a/a/g/b/a/b;", "", "", "bankId", "Ljava/lang/String;", "getBankId", "()Ljava/lang/String;", "bankAlias", AuthSource.SEND_ABUSE, "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class b {
    @SerializedName("bankAlias")
    @NotNull
    private final String bankAlias;
    @SerializedName("bankId")
    @NotNull
    private final String bankId;

    @NotNull
    public final String a() {
        return this.bankAlias;
    }
}
