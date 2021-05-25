package com.avito.android.remote.error;

import android.content.res.Resources;
import com.avito.android.remote.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.Error;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.PretendResultError;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import com.avito.android.util.Throwables;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ:\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00040\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/error/TypedErrorThrowableConverterImpl;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "", "throwable", "Lcom/avito/android/remote/error/TypedError;", "convert", "(Ljava/lang/Throwable;)Lcom/avito/android/remote/error/TypedError;", "Lcom/avito/android/remote/error/SpecialCase;", "specialCase", "convertWithSpecialErrorCase", "(Ljava/lang/Throwable;Lcom/avito/android/remote/error/SpecialCase;)Lcom/avito/android/remote/error/TypedError;", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/Error;", "Lkotlin/ParameterName;", "name", "error", "convertFunc", AuthSource.SEND_ABUSE, "(Ljava/lang/Throwable;Lkotlin/jvm/functions/Function1;)Lcom/avito/android/remote/error/TypedError;", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/Formatter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/Formatter;", "formatter", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/util/Formatter;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class TypedErrorThrowableConverterImpl implements TypedErrorThrowableConverter {
    public final Resources a;
    public final Formatter<Throwable> b;

    public static final class a extends Lambda implements Function1<Error, TypedError> {
        public final /* synthetic */ TypedErrorThrowableConverterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TypedErrorThrowableConverterImpl typedErrorThrowableConverterImpl) {
            super(1);
            this.a = typedErrorThrowableConverterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public TypedError invoke(Error error) {
            Error error2 = error;
            Intrinsics.checkNotNullParameter(error2, "it");
            return TypedErrorThrowableConverterImpl.access$convertFromError(this.a, error2);
        }
    }

    public static final class b extends Lambda implements Function1<Error, TypedError> {
        public final /* synthetic */ TypedErrorThrowableConverterImpl a;
        public final /* synthetic */ SpecialCase b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(TypedErrorThrowableConverterImpl typedErrorThrowableConverterImpl, SpecialCase specialCase) {
            super(1);
            this.a = typedErrorThrowableConverterImpl;
            this.b = specialCase;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public TypedError invoke(Error error) {
            Error error2 = error;
            Intrinsics.checkNotNullParameter(error2, "it");
            TypedError access$mapSpecialCaseError = TypedErrorThrowableConverterImpl.access$mapSpecialCaseError(this.a, error2, this.b);
            return access$mapSpecialCaseError != null ? access$mapSpecialCaseError : TypedErrorThrowableConverterImpl.access$convertFromError(this.a, error2);
        }
    }

    @JvmOverloads
    public TypedErrorThrowableConverterImpl(@NotNull Resources resources) {
        this(resources, null, 2, null);
    }

    @JvmOverloads
    public TypedErrorThrowableConverterImpl(@NotNull Resources resources, @NotNull Formatter<Throwable> formatter) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        this.a = resources;
        this.b = formatter;
    }

    public static final TypedError access$convertFromError(TypedErrorThrowableConverterImpl typedErrorThrowableConverterImpl, Error error) {
        Objects.requireNonNull(typedErrorThrowableConverterImpl);
        String str = "";
        if (error instanceof PretendResultError) {
            PretendResult pretendResult = ((PretendResultError) error).getPretendResult();
            if (pretendResult != null) {
                return new TypedError.PretendError(pretendResult);
            }
            String str2 = error.simpleMessage;
            if (str2 != null) {
                str = str2;
            }
            return new ErrorWithMessage.SimpleMessageError(str);
        } else if (error.isPlural()) {
            Map<String, String> map = error.paramsMessages;
            if (map == null) {
                map = r.emptyMap();
            }
            return new TypedError.ErrorMap(map);
        } else {
            String str3 = error.simpleMessage;
            if (str3 != null) {
                str = str3;
            }
            return new ErrorWithMessage.SimpleMessageError(str);
        }
    }

    public static final TypedError access$mapSpecialCaseError(TypedErrorThrowableConverterImpl typedErrorThrowableConverterImpl, Error error, SpecialCase specialCase) {
        Objects.requireNonNull(typedErrorThrowableConverterImpl);
        Function1<Error, TypedError> function1 = specialCase.getSpecialCases().get(Integer.valueOf(error.code));
        if (function1 != null) {
            return function1.invoke(error);
        }
        return null;
    }

    public final TypedError a(Throwable th, Function1<? super Error, ? extends TypedError> function1) {
        if (Throwables.isCertificatePinningError(th)) {
            String string = this.a.getString(R.string.unsafe_network_message);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…g.unsafe_network_message)");
            return new ErrorWithMessage.NetworkError(string);
        } else if (Throwables.isNetworkProblem(th)) {
            String string2 = this.a.getString(R.string.network_unavailable_snack);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…etwork_unavailable_snack)");
            return new ErrorWithMessage.NetworkError(string2);
        } else if (Throwables.isAuthProblem(th)) {
            return new TypedError.UnauthorizedError();
        } else {
            if (th instanceof ErrorContainer) {
                ErrorContainer errorContainer = (ErrorContainer) th;
                if (errorContainer.getError() != null) {
                    Error error = errorContainer.getError();
                    Intrinsics.checkNotNullExpressionValue(error, "throwable.error");
                    return (TypedError) function1.invoke(error);
                }
            }
            return new ErrorWithMessage.Unknown(this.b.format(th), th);
        }
    }

    @Override // com.avito.android.remote.error.TypedErrorThrowableConverter
    @NotNull
    public TypedError convert(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        return a(th, new a(this));
    }

    @Override // com.avito.android.remote.error.TypedErrorThrowableConverter
    @NotNull
    public TypedError convertWithSpecialErrorCase(@NotNull Throwable th, @NotNull SpecialCase specialCase) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        Intrinsics.checkNotNullParameter(specialCase, "specialCase");
        return a(th, new b(this, specialCase));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TypedErrorThrowableConverterImpl(Resources resources, Formatter formatter, int i, j jVar) {
        this(resources, (i & 2) != 0 ? new ErrorFormatterImpl(resources) : formatter);
    }
}
