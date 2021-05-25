package com.avito.android.util;

import android.content.res.Resources;
import android.text.TextUtils;
import com.avito.android.remote.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorContainer;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.Error;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR$\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u000e0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/util/ErrorFormatterImpl;", "Lcom/avito/android/util/ErrorFormatter;", "", "value", "", "format", "(Ljava/lang/Throwable;)Ljava/lang/String;", "Lkotlin/Function1;", "unknownErrorHandler", "(Ljava/lang/Throwable;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", "onError", "<init>", "(Landroid/content/res/Resources;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class ErrorFormatterImpl implements ErrorFormatter {
    public final Function1<Throwable, Unit> a = b.a;
    public final Resources b;

    public static final class a extends Lambda implements Function1<Throwable, String> {
        public final /* synthetic */ ErrorFormatterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ErrorFormatterImpl errorFormatterImpl) {
            super(1);
            this.a = errorFormatterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public String invoke(Throwable th) {
            String string = this.a.b.getString(R.string.unknown_server_error);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.unknown_server_error)");
            return string;
        }
    }

    public static final class b extends Lambda implements Function1<Throwable, Unit> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            Logs.error("ErrorFormatter", "Cannot format error", th);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ErrorFormatterImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.b = resources;
    }

    @NotNull
    public String format(@Nullable Throwable th) {
        return format(th, new a(this));
    }

    @Override // com.avito.android.util.ErrorFormatter
    @NotNull
    public String format(@Nullable Throwable th, @NotNull Function1<? super Throwable, String> function1) {
        Intrinsics.checkNotNullParameter(function1, "unknownErrorHandler");
        if (Throwables.isCertificatePinningError(th)) {
            String string = this.b.getString(R.string.unsafe_network_message);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…g.unsafe_network_message)");
            return string;
        } else if (Throwables.isNetworkProblem(th)) {
            String string2 = this.b.getString(R.string.network_unavailable_snack);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…etwork_unavailable_snack)");
            return string2;
        } else {
            if (th instanceof TypedResultException) {
                TypedResultException typedResultException = (TypedResultException) th;
                if (!(typedResultException.getErrorResult() instanceof ErrorResult.UnknownStatusError)) {
                    if (typedResultException.getMessage().length() > 0) {
                        return typedResultException.getMessage();
                    }
                }
            }
            if (th instanceof ErrorContainer) {
                ErrorContainer errorContainer = (ErrorContainer) th;
                if (!TextUtils.isEmpty(errorContainer.getError().simpleMessage)) {
                    Error error = errorContainer.getError();
                    Logs.error("ErrorFormatter", "Exception, error = " + error, th);
                    String str = error.simpleMessage;
                    if (str == null) {
                        str = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "error.simpleMessage ?: \"\"");
                    return str;
                }
            }
            Logs.error("ErrorFormatter", "unknown exception", th);
            this.a.invoke(th);
            return function1.invoke(th);
        }
    }
}
