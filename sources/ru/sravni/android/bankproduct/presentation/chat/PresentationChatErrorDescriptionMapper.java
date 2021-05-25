package ru.sravni.android.bankproduct.presentation.chat;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableErrorDescriptionMapper;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.NoMessagesFromSravniInChatWarn;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.NullChatMessagesWhenApplyDiff;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.TryEditWithNullConversationInfoError;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.TryResentNullAnswerError;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.NullNavInfoOsagoOffersError;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.NullNavInfoOsagoOrderError;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.NullSuggestCardWhileAskSuggestError;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.NullSuggestCardWhileSendAnswerError;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ScanResultWrongThrowable;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.WrongSliderPointError;
import ru.sravni.android.bankproduct.presentation.component.scan.passport.ScanResultStatus;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016XD¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/PresentationChatErrorDescriptionMapper;", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableErrorDescriptionMapper;", "", "throwable", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "mapToError", "(Ljava/lang/Throwable;)Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getDomain", "()Ljava/lang/String;", "domain", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class PresentationChatErrorDescriptionMapper implements IThrowableErrorDescriptionMapper {
    @NotNull
    public final String a = "PRCH";

    @Override // ru.sravni.android.bankproduct.domain.sravnierror.IThrowableErrorDescriptionMapper
    @NotNull
    public String getDomain() {
        return this.a;
    }

    @Override // ru.sravni.android.bankproduct.domain.sravnierror.IThrowableErrorDescriptionMapper
    @Nullable
    public ErrorDescription mapToError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        if (th instanceof WrongSliderPointError) {
            return PresentationChatErrorDescriptionMapperKt.access$sliderWrongPositionErrorDescription((WrongSliderPointError) th);
        }
        if (th instanceof NullSuggestCardWhileAskSuggestError) {
            return PresentationChatErrorDescriptionMapperKt.access$nullSuggestCardWhileAskSuggestErrorDescription();
        }
        if (th instanceof NullSuggestCardWhileSendAnswerError) {
            return PresentationChatErrorDescriptionMapperKt.access$nullSuggestCardWhileSendAnswerErrorDescription();
        }
        if (th instanceof TryResentNullAnswerError) {
            return PresentationChatErrorDescriptionMapperKt.a;
        }
        if (th instanceof NoMessagesFromSravniInChatWarn) {
            return PresentationChatErrorDescriptionMapperKt.b;
        }
        if (th instanceof TryEditWithNullConversationInfoError) {
            return PresentationChatErrorDescriptionMapperKt.c;
        }
        if (th instanceof NullChatMessagesWhenApplyDiff) {
            return PresentationChatErrorDescriptionMapperKt.d;
        }
        if (th instanceof ScanResultWrongThrowable) {
            ScanResultWrongThrowable scanResultWrongThrowable = (ScanResultWrongThrowable) th;
            ScanResultStatus scanCode = scanResultWrongThrowable.getScanCode();
            String scanMessage = scanResultWrongThrowable.getScanMessage();
            if (scanMessage == null) {
                scanMessage = "";
            }
            return PresentationChatErrorDescriptionMapperKt.access$scanResultWrongDescription(scanCode, scanMessage);
        } else if (th instanceof NullNavInfoOsagoOrderError) {
            return PresentationChatErrorDescriptionMapperKt.e;
        } else {
            if (th instanceof NullNavInfoOsagoOffersError) {
                return PresentationChatErrorDescriptionMapperKt.f;
            }
            if (th instanceof NullNavInfoCreditError) {
                return PresentationChatErrorDescriptionMapperKt.access$nullNavInfoCreditError();
            }
            return null;
        }
    }
}
