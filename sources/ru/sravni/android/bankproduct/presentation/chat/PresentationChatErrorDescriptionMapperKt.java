package ru.sravni.android.bankproduct.presentation.chat;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.WrongSliderPointError;
import ru.sravni.android.bankproduct.presentation.component.scan.passport.ScanResultStatus;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u000e\"\u0016\u0010\u0003\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0005\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0002\"\u0016\u0010\u0007\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0002\"\u0016\u0010\t\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0002\"\u0016\u0010\u000b\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0002\"\u0016\u0010\r\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0002¨\u0006\u000e"}, d2 = {"Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "tryResentNullAnswerErrorDescription", "e", "nullNavInfoOsagoOrderDescription", "d", "nullChatMessagesWhenApplyDiffDescription", "c", "tryEditWithNullConversationInfoErrorDescription", "f", "nullNavInfoOsagoOffersDescription", AuthSource.BOOKING_ORDER, "noMessagesFromSravniInChatWarnDescription", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class PresentationChatErrorDescriptionMapperKt {
    public static final ErrorDescription a = new ErrorDescription(40, "ReNullAn", "Try resend null answer", null, 8, null);
    public static final ErrorDescription b = new ErrorDescription(41, "NoSrMeInCh", "There is no messages from sravni in chat. Could not get current point.", null, 8, null);
    public static final ErrorDescription c = new ErrorDescription(42, "NullCoIn", "Try edit message with empty ConversationInfo", null, 8, null);
    public static final ErrorDescription d = new ErrorDescription(43, "NuChMe", "Trying count diff with null MessageContainer in ChatViewModel live data", null, 8, null);
    public static final ErrorDescription e = new ErrorDescription(60, "NullNavInfOsOrd", "Null nav info in osago order answer when click button.", null, 8, null);
    public static final ErrorDescription f = new ErrorDescription(61, "NullNavInfOsOff", "Null nav info in osago offers answer when click button.", null, 8, null);

    public static final ErrorDescription access$nullNavInfoCreditError() {
        return new ErrorDescription(70, "NullNavCredErr", "Null info while try to get credit list", null, 8, null);
    }

    public static final ErrorDescription access$nullSuggestCardWhileAskSuggestErrorDescription() {
        return new ErrorDescription(30, "SugNullCardGet", "Null suggest card while try to get suggests", null, 8, null);
    }

    public static final ErrorDescription access$nullSuggestCardWhileSendAnswerErrorDescription() {
        return new ErrorDescription(31, "SugNullCardSent", "Null suggest card while try to sent answer", null, 8, null);
    }

    public static final ErrorDescription access$scanResultWrongDescription(ScanResultStatus scanResultStatus, String str) {
        return new ErrorDescription(50, "ScanErr", "Scan return error with code " + scanResultStatus + " becasue of " + str, null, 8, null);
    }

    public static final ErrorDescription access$sliderWrongPositionErrorDescription(WrongSliderPointError wrongSliderPointError) {
        StringBuilder L = a.L("Error occur while try chose element in ");
        L.append(wrongSliderPointError.getPosition());
        L.append(" for elements ");
        L.append(wrongSliderPointError.getItems());
        return new ErrorDescription(20, "sliderPosition", L.toString(), null, 8, null);
    }
}
