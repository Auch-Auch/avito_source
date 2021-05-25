package com.sumsub.sns.presentation.screen.documents.require;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.R;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.data.model.LogType;
import com.sumsub.sns.core.domain.SendLogUseCase;
import com.sumsub.sns.core.domain.model.Either;
import com.sumsub.sns.core.presentation.base.ActionLiveData;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.presentation.screen.documents.SNSBaseListDocumentsViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\f0\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u000e¨\u0006 "}, d2 = {"Lcom/sumsub/sns/presentation/screen/documents/require/SNSRequireDocumentsViewModel;", "Lcom/sumsub/sns/presentation/screen/documents/SNSBaseListDocumentsViewModel;", "", "onContinueClicked", "()V", "Landroid/content/Context;", "context", "", "type", "onTermsLinksClicked", "(Landroid/content/Context;Ljava/lang/String;)V", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "Lcom/sumsub/sns/core/presentation/base/Event;", "n", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "_showBottomSheetWithTermsActionLiveData", "Lcom/sumsub/sns/core/domain/SendLogUseCase;", "o", "Lcom/sumsub/sns/core/domain/SendLogUseCase;", "sendLogUseCase", "getShowBottomSheetWithTerms", "()Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "showBottomSheetWithTerms", "Landroidx/lifecycle/LiveData;", "", "getShowDocumentScreen", "()Landroidx/lifecycle/LiveData;", "showDocumentScreen", AuthSource.OPEN_CHANNEL_LIST, "_showDocumentScreenActionLiveData", "<init>", "(Lcom/sumsub/sns/core/domain/SendLogUseCase;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSRequireDocumentsViewModel extends SNSBaseListDocumentsViewModel {
    public final ActionLiveData<Event<Object>> m = new ActionLiveData<>();
    public final ActionLiveData<Event<String>> n = new ActionLiveData<>();
    public final SendLogUseCase o;

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.documents.require.SNSRequireDocumentsViewModel$onTermsLinksClicked$1", f = "SNSRequireDocumentsViewModel.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ SNSRequireDocumentsViewModel c;
        public final /* synthetic */ Exception d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSRequireDocumentsViewModel sNSRequireDocumentsViewModel, Exception exc, Continuation continuation) {
            super(2, continuation);
            this.c = sNSRequireDocumentsViewModel;
            this.d = exc;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new a(this.c, this.d, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new a(this.c, this.d, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SendLogUseCase sendLogUseCase = this.c.o;
                SendLogUseCase.Params params = new SendLogUseCase.Params(LogType.Error, this.d, "An error when a user clicks on terms links...");
                this.b = 1;
                if (sendLogUseCase.run(params, (Continuation<? super Either<? extends Exception, ? extends Object>>) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public SNSRequireDocumentsViewModel(@NotNull SendLogUseCase sendLogUseCase) {
        Intrinsics.checkNotNullParameter(sendLogUseCase, "sendLogUseCase");
        this.o = sendLogUseCase;
        Timber.i("RequireDocumentsViewModel is created", new Object[0]);
        get_showProgressLiveData().setValue(Boolean.FALSE);
    }

    @NotNull
    public final ActionLiveData<Event<String>> getShowBottomSheetWithTerms() {
        return this.n;
    }

    @NotNull
    public final LiveData<Event<Object>> getShowDocumentScreen() {
        return this.m;
    }

    public final void onContinueClicked() {
        get_showProgressLiveData().setValue(Boolean.TRUE);
        this.m.setValue(new Event<>(new Object()));
    }

    public final void onTermsLinksClicked(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "type");
        try {
            int hashCode = str.hashCode();
            boolean z = true;
            if (hashCode != 3584) {
                if (hashCode == 102678) {
                    if (str.equals(SNSConstants.LinkType.GTC)) {
                        String stringResource$default = ExtensionsKt.getStringResource$default(context, R.string.sns_tos_GTC_html, (String) null, 2, (Object) null);
                        String stringResource$default2 = ExtensionsKt.getStringResource$default(context, R.string.sns_tos_GTC_url, (String) null, 2, (Object) null);
                        if (stringResource$default.length() > 0) {
                            this.n.setValue(new Event<>(stringResource$default));
                            return;
                        }
                        if (stringResource$default2.length() <= 0) {
                            z = false;
                        }
                        if (z) {
                            get_showWebUrlActionLiveData().setValue(new Event<>(Uri.parse(stringResource$default2)));
                            return;
                        }
                        return;
                    }
                }
            } else if (str.equals(SNSConstants.LinkType.PP)) {
                String stringResource$default3 = ExtensionsKt.getStringResource$default(context, R.string.sns_tos_PP_html, (String) null, 2, (Object) null);
                String stringResource$default4 = ExtensionsKt.getStringResource$default(context, R.string.sns_tos_PP_url, (String) null, 2, (Object) null);
                if (stringResource$default3.length() > 0) {
                    this.n.setValue(new Event<>(stringResource$default3));
                    return;
                }
                if (stringResource$default4.length() <= 0) {
                    z = false;
                }
                if (z) {
                    get_showWebUrlActionLiveData().setValue(new Event<>(Uri.parse(stringResource$default4)));
                    return;
                }
                return;
            }
            get_showWebUrlActionLiveData().setValue(new Event<>(Uri.parse(str)));
        } catch (Exception e) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), NonCancellable.INSTANCE, null, new a(this, e, null), 2, null);
            Timber.e(e, "An error when a user clicks on terms links...", new Object[0]);
        }
    }
}
