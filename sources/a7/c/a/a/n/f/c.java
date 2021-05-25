package a7.c.a.a.n.f;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.profile.response.v2.ProfileDetailedInfoResponse;
public final class c<T, R> implements Function<T, R> {
    public static final c a = new c();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        ProfileDetailedInfoResponse profileDetailedInfoResponse = (ProfileDetailedInfoResponse) obj;
        Intrinsics.checkParameterIsNotNull(profileDetailedInfoResponse, "it");
        return profileDetailedInfoResponse.getItem().toProfileDetailedInfoRepo();
    }
}
