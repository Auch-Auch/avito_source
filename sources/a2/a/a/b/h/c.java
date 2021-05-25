package a2.a.a.b.h;

import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.remote.model.ResetPasswordResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<CodeInfo, ResetPasswordResult> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ResetPasswordResult apply(CodeInfo codeInfo) {
        CodeInfo codeInfo2 = codeInfo;
        Intrinsics.checkNotNullParameter(codeInfo2, "it");
        return new ResetPasswordResult.ViaCode(codeInfo2.getText(), codeInfo2.getTimeout(), codeInfo2.getLength());
    }
}
