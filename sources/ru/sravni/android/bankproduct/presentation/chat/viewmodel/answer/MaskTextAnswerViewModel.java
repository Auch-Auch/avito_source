package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.card.MaskTextContentCardDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandler;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardTypeConverter;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017R\u0016\u0010\"\u001a\u00020\u00038\u0002@\u0002X.¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010,\u001a\u00020'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u00061"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/MaskTextAnswerViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IMaskTextAnswerViewModel;", "", "conversationID", "Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;", "contentCard", "", "init", "(Ljava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;)V", "text", "", "maskFilled", "setTextChange", "(Ljava/lang/String;Z)V", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "getAnswerInfoDomain", "()Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "Landroidx/lifecycle/MutableLiveData;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/InitMaskElementInfo;", "c", "Landroidx/lifecycle/MutableLiveData;", "getInitMaskElement", "()Landroidx/lifecycle/MutableLiveData;", "initMaskElement", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardTypeConverter;", "h", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardTypeConverter;", "keyboardTypeConverter", "d", "getCanAnswer", "canAnswer", "f", "Ljava/lang/String;", "userText", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/MaskTextContentCard;", "e", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/MaskTextContentCard;", "maskTextCard", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandler;", g.a, "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandler;", "getMaskTextErrorHandler", "()Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandler;", "maskTextErrorHandler", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "<init>", "(Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardTypeConverter;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class MaskTextAnswerViewModel extends ViewModel implements IMaskTextAnswerViewModel {
    @NotNull
    public final MutableLiveData<InitMaskElementInfo> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> d = new MutableLiveData<>();
    public MaskTextContentCard e;
    public String f;
    @NotNull
    public final IErrorHandler g;
    public final IKeyboardTypeConverter h;

    public static final class a extends Lambda implements Function1<SravniError, Unit> {
        public final /* synthetic */ IErrorLogger a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(IErrorLogger iErrorLogger) {
            super(1);
            this.a = iErrorLogger;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SravniError sravniError) {
            SravniError sravniError2 = sravniError;
            Intrinsics.checkParameterIsNotNull(sravniError2, "error");
            this.a.logError(MessagePriority.WARN, sravniError2);
            return Unit.INSTANCE;
        }
    }

    public MaskTextAnswerViewModel(@NotNull IKeyboardTypeConverter iKeyboardTypeConverter, @NotNull IErrorLogger iErrorLogger) {
        Intrinsics.checkParameterIsNotNull(iKeyboardTypeConverter, "keyboardTypeConverter");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        this.h = iKeyboardTypeConverter;
        this.g = UtilFunctionsKt.errorHandlerAction(new a(iErrorLogger));
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IMaskTextAnswerViewModel
    @NotNull
    public AnswerInfoDomain getAnswerInfoDomain() {
        String str;
        MaskTextContentCard maskTextContentCard = this.e;
        if (maskTextContentCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maskTextCard");
        }
        if (maskTextContentCard.isPhone()) {
            MaskTextContentCard maskTextContentCard2 = this.e;
            if (maskTextContentCard2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskTextCard");
            }
            String mask = maskTextContentCard2.getMask();
            String str2 = this.f;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userText");
            }
            str = UtilFunctionsKt.getExtractedText(mask, str2);
        } else {
            str = this.f;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userText");
            }
        }
        MaskTextContentCard maskTextContentCard3 = this.e;
        if (maskTextContentCard3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maskTextCard");
        }
        int cardID = maskTextContentCard3.getCardID();
        MaskTextContentCard maskTextContentCard4 = this.e;
        if (maskTextContentCard4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maskTextCard");
        }
        String conversationID = maskTextContentCard4.getConversationID();
        MaskTextContentCard maskTextContentCard5 = this.e;
        if (maskTextContentCard5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maskTextCard");
        }
        Map mapOf = q.mapOf(TuplesKt.to(maskTextContentCard5.getFieldContentName(), str));
        String str3 = this.f;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userText");
        }
        return new AnswerInfoDomain(cardID, conversationID, str3, mapOf, null, 16, null);
    }

    @Override // ru.sravni.android.bankproduct.utils.masktext.IMaskTextErrorHandler
    @NotNull
    public IErrorHandler getMaskTextErrorHandler() {
        return this.g;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize
    public void init(@NotNull String str, @Nullable IContentCardDomain iContentCardDomain) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        if (!(iContentCardDomain instanceof MaskTextContentCardDomain)) {
            iContentCardDomain = null;
        }
        MaskTextContentCardDomain maskTextContentCardDomain = (MaskTextContentCardDomain) iContentCardDomain;
        if (maskTextContentCardDomain != null) {
            String mask = maskTextContentCardDomain.getMask();
            String suggestText = maskTextContentCardDomain.getSuggestText();
            String str2 = "";
            if (suggestText == null) {
                suggestText = str2;
            }
            this.f = UtilFunctionsKt.getFormattedText(mask, suggestText);
            MutableLiveData<Boolean> canAnswer = getCanAnswer();
            String str3 = this.f;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userText");
            }
            canAnswer.setValue(Boolean.valueOf(str3.length() > 0));
            MutableLiveData<InitMaskElementInfo> initMaskElement = getInitMaskElement();
            String hint = maskTextContentCardDomain.getHint();
            if (hint != null) {
                str2 = hint;
            }
            String mask2 = maskTextContentCardDomain.getMask();
            String str4 = this.f;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userText");
            }
            initMaskElement.setValue(new InitMaskElementInfo(str2, mask2, this.h.convertTextTypeToInputType(maskTextContentCardDomain.getKeyboardType()), str4));
            this.e = new MaskTextContentCard(str, maskTextContentCardDomain.getOrderId(), maskTextContentCardDomain.getFieldContentName(), maskTextContentCardDomain.getMask(), this.h.isTextTypePhone(maskTextContentCardDomain.getKeyboardType()));
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IMaskTextAnswerViewModel
    public void setTextChange(@NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        if (z) {
            if (StringsKt__StringsKt.trim(str).toString().length() > 0) {
                getCanAnswer().setValue(Boolean.TRUE);
                this.f = str;
                return;
            }
        }
        getCanAnswer().setValue(Boolean.FALSE);
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IMaskTextAnswerViewModel
    @NotNull
    public MutableLiveData<Boolean> getCanAnswer() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IMaskTextAnswerViewModel
    @NotNull
    public MutableLiveData<InitMaskElementInfo> getInitMaskElement() {
        return this.c;
    }
}
