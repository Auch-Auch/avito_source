package a2.a.a.c2.e;

import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class e<T> implements Consumer<CodeInfo> {
    public final /* synthetic */ PhoneManagementPresenterImpl a;

    public e(PhoneManagementPresenterImpl phoneManagementPresenterImpl) {
        this.a = phoneManagementPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CodeInfo codeInfo) {
        CodeInfo codeInfo2 = codeInfo;
        PhoneManagementPresenterImpl phoneManagementPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(codeInfo2, "it");
        PhoneManagementPresenterImpl.access$handleCodeRequested(phoneManagementPresenterImpl, codeInfo2);
    }
}
