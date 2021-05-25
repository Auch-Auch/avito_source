package a2.a.a.b2;

import com.avito.android.code_confirmation.Source;
import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.UserProfilePresenterImpl;
import com.avito.android.remote.model.user_profile.Phone;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c1<T> implements Consumer<CodeInfo> {
    public final /* synthetic */ UserProfilePresenterImpl a;
    public final /* synthetic */ Phone b;

    public c1(UserProfilePresenterImpl userProfilePresenterImpl, Phone phone) {
        this.a = userProfilePresenterImpl;
        this.b = phone;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CodeInfo codeInfo) {
        CodeInfo codeInfo2 = codeInfo;
        UserProfilePresenter.Router router = this.a.b;
        if (router != null) {
            Phone phone = this.b;
            Intrinsics.checkNotNullExpressionValue(codeInfo2, "code");
            router.openVerifyPhone(phone, codeInfo2, Source.PHONE_VERIFICATION);
        }
    }
}
