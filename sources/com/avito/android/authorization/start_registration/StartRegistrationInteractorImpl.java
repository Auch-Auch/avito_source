package com.avito.android.authorization.start_registration;

import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.code_confirmation.model.ConfirmedCodeInfo;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\b\u0010\tJ2\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/authorization/start_registration/StartRegistrationInteractorImpl;", "Lcom/avito/android/authorization/start_registration/StartRegistrationInteractor;", "Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "", "id", "src", "Lio/reactivex/Observable;", "Lcom/avito/android/code_confirmation/model/CodeInfo;", "requestCode", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "login", "code", "Lcom/avito/android/code_confirmation/model/ConfirmedCodeInfo;", "sendCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", AuthSource.SEND_ABUSE, "Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "codeConfirmationInteractor", "<init>", "(Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class StartRegistrationInteractorImpl implements StartRegistrationInteractor, CodeConfirmationInteractor {
    public final CodeConfirmationInteractor a;

    @Inject
    public StartRegistrationInteractorImpl(@NotNull CodeConfirmationInteractor codeConfirmationInteractor) {
        Intrinsics.checkNotNullParameter(codeConfirmationInteractor, "codeConfirmationInteractor");
        this.a = codeConfirmationInteractor;
    }

    @Override // com.avito.android.code_confirmation.RequestCodeInteractor
    @NotNull
    public Observable<CodeInfo> requestCode(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        return this.a.requestCode(str, str2);
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationInteractor
    @NotNull
    public Observable<ConfirmedCodeInfo> sendCode(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "code");
        return this.a.sendCode(str, str2, str3);
    }
}
