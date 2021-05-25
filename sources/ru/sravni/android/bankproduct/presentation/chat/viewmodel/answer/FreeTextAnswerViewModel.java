package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.card.FreeTextContentCardDomain;
import ru.sravni.android.bankproduct.presentation.chat.entity.TextWithSelectionToEnd;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardTypeConverter;
import ru.sravni.android.bankproduct.utils.string.StringUtilKt;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b-\u0010.J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\u0019R\u0016\u0010%\u001a\u00020\u00038\u0002@\u0002X.¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010\u0019R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010\u0019¨\u0006/"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/FreeTextAnswerViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IFreeTextAnswerViewModel;", "", "conversationID", "Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;", "contentCard", "", "init", "(Ljava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;)V", "text", "Lru/sravni/android/bankproduct/presentation/chat/entity/TextWithSelectionToEnd;", "textChangedAction", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/presentation/chat/entity/TextWithSelectionToEnd;", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "getAnswerInfoDomain", "()Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/FreeTextContentCard;", g.a, "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/FreeTextContentCard;", "freeTextCard", "Landroidx/lifecycle/MutableLiveData;", "f", "Landroidx/lifecycle/MutableLiveData;", "getSuggestText", "()Landroidx/lifecycle/MutableLiveData;", "suggestText", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardTypeConverter;", "i", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardTypeConverter;", "keyboardTypeConverter", "", "c", "getCanAnswer", "canAnswer", "h", "Ljava/lang/String;", "userText", "", "d", "getInputType", "inputType", "e", "getHint", "hint", "<init>", "(Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardTypeConverter;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FreeTextAnswerViewModel extends ViewModel implements IFreeTextAnswerViewModel {
    @NotNull
    public final MutableLiveData<Boolean> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Integer> d = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> e = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> f = new MutableLiveData<>();
    public FreeTextContentCard g;
    public String h;
    public final IKeyboardTypeConverter i;

    public FreeTextAnswerViewModel(@NotNull IKeyboardTypeConverter iKeyboardTypeConverter) {
        Intrinsics.checkParameterIsNotNull(iKeyboardTypeConverter, "keyboardTypeConverter");
        this.i = iKeyboardTypeConverter;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IFreeTextAnswerViewModel
    @NotNull
    public AnswerInfoDomain getAnswerInfoDomain() {
        FreeTextContentCard freeTextContentCard = this.g;
        if (freeTextContentCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("freeTextCard");
        }
        int cardID = freeTextContentCard.getCardID();
        FreeTextContentCard freeTextContentCard2 = this.g;
        if (freeTextContentCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("freeTextCard");
        }
        String conversationID = freeTextContentCard2.getConversationID();
        FreeTextContentCard freeTextContentCard3 = this.g;
        if (freeTextContentCard3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("freeTextCard");
        }
        String fieldContentName = freeTextContentCard3.getFieldContentName();
        String str = this.h;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userText");
        }
        Map mapOf = q.mapOf(TuplesKt.to(fieldContentName, str));
        String str2 = this.h;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userText");
        }
        return new AnswerInfoDomain(cardID, conversationID, str2, mapOf, null, 16, null);
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize
    public void init(@NotNull String str, @Nullable IContentCardDomain iContentCardDomain) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        if (!(iContentCardDomain instanceof FreeTextContentCardDomain)) {
            iContentCardDomain = null;
        }
        FreeTextContentCardDomain freeTextContentCardDomain = (FreeTextContentCardDomain) iContentCardDomain;
        if (freeTextContentCardDomain != null) {
            String suggestText = freeTextContentCardDomain.getSuggestText();
            if (suggestText == null) {
                suggestText = "";
            }
            this.h = suggestText;
            getHint().setValue(freeTextContentCardDomain.getHint());
            MutableLiveData<String> suggestText2 = getSuggestText();
            String str2 = this.h;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userText");
            }
            suggestText2.setValue(str2);
            MutableLiveData<Boolean> canAnswer = getCanAnswer();
            String str3 = this.h;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userText");
            }
            canAnswer.setValue(Boolean.valueOf(str3.length() > 0));
            getInputType().setValue(Integer.valueOf(this.i.convertTextTypeToInputType(freeTextContentCardDomain.getKeyboardType())));
            this.g = new FreeTextContentCard(str, freeTextContentCardDomain.getOrderId(), freeTextContentCardDomain.getFieldContentName());
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IFreeTextAnswerViewModel
    @NotNull
    public TextWithSelectionToEnd textChangedAction(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        Integer value = getInputType().getValue();
        if (value != null && value.intValue() == 2) {
            str = StringUtilKt.textWithoutSpace(str);
        }
        this.h = str;
        MutableLiveData<Boolean> canAnswer = getCanAnswer();
        String str2 = this.h;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userText");
        }
        if (str2 != null) {
            boolean z = true;
            canAnswer.setValue(Boolean.valueOf(StringsKt__StringsKt.trim(str2).toString().length() > 0));
            String str3 = this.h;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userText");
            }
            Integer value2 = getInputType().getValue();
            if (value2 != null && value2.intValue() == 2) {
                str3 = StringUtilKt.textWithThousandSpace(str3);
            }
            Integer value3 = getInputType().getValue();
            if (value3 == null || value3.intValue() != 2) {
                z = false;
            }
            return new TextWithSelectionToEnd(str3, z);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IFreeTextAnswerViewModel
    @NotNull
    public MutableLiveData<Boolean> getCanAnswer() {
        return this.c;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IFreeTextAnswerViewModel
    @NotNull
    public MutableLiveData<String> getHint() {
        return this.e;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IFreeTextAnswerViewModel
    @NotNull
    public MutableLiveData<Integer> getInputType() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IFreeTextAnswerViewModel
    @NotNull
    public MutableLiveData<String> getSuggestText() {
        return this.f;
    }
}
