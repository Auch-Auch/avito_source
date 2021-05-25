package a7.c.a.a.n.f;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.profile.response.v2.ProfileDocumentInfoResponse;
public final class e<T, R> implements Function<T, R> {
    public static final e a = new e();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        ProfileDocumentInfoResponse profileDocumentInfoResponse = (ProfileDocumentInfoResponse) obj;
        Intrinsics.checkParameterIsNotNull(profileDocumentInfoResponse, "it");
        return profileDocumentInfoResponse.getItem().toProfileDocumentInfoRepo();
    }
}
