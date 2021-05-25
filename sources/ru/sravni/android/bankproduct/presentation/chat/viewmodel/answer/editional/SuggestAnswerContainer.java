package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.editional;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.chat.entity.card.SuggestModeEnum;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.SuggestInfo;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardTypeConverter;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010/\u001a\u00020,¢\u0006\u0004\b8\u00109J3\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\fJ\u001b\u0010\u0011\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u001dR(\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u001dR\"\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010\u001dR\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010\"R\u0013\u00104\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/editional/SuggestAnswerContainer;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/editional/ISuggestAnswerParam;", "", "keyboard", "hint", "text", "Lru/sravni/android/bankproduct/domain/chat/entity/card/SuggestModeEnum;", "mode", "", "initSuggestContainer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/card/SuggestModeEnum;)V", "setTextFromKeyboard", "(Ljava/lang/String;)V", "setTextFromSuggestList", "", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/SuggestInfo;", "listSuggestInfo", "setListSuggestInfo", "(Ljava/util/List;)V", "hideListSuggest", "()V", "", AuthSource.SEND_ABUSE, "()Z", "Landroidx/lifecycle/MutableLiveData;", "", AuthSource.BOOKING_ORDER, "Landroidx/lifecycle/MutableLiveData;", "getInputType", "()Landroidx/lifecycle/MutableLiveData;", "inputType", "getCanAnswer", "canAnswer", "f", "Ljava/lang/String;", "inputText", "c", "getHint", "e", "getSuggestList", "suggestList", "d", "getSuggestText", "suggestText", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardTypeConverter;", "i", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardTypeConverter;", "keyboardTypeConverter", g.a, "autoText", "getAnsweredText", "()Ljava/lang/String;", "answeredText", "h", "Lru/sravni/android/bankproduct/domain/chat/entity/card/SuggestModeEnum;", "suggestMode", "<init>", "(Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardTypeConverter;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SuggestAnswerContainer implements ISuggestAnswerParam {
    @NotNull
    public final MutableLiveData<Boolean> a = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Integer> b = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> d = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<List<SuggestInfo>> e = new MutableLiveData<>();
    public String f = "";
    public String g = "";
    public SuggestModeEnum h = SuggestModeEnum.MODE_FREE;
    public final IKeyboardTypeConverter i;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SuggestModeEnum.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            SuggestModeEnum suggestModeEnum = SuggestModeEnum.MODE_FREE;
            iArr[0] = 1;
            SuggestModeEnum suggestModeEnum2 = SuggestModeEnum.MODE_STRICT;
            iArr[1] = 2;
            SuggestModeEnum suggestModeEnum3 = SuggestModeEnum.MODE_PARTIAL_TAIL;
            iArr[2] = 3;
        }
    }

    public SuggestAnswerContainer(@NotNull IKeyboardTypeConverter iKeyboardTypeConverter) {
        Intrinsics.checkParameterIsNotNull(iKeyboardTypeConverter, "keyboardTypeConverter");
        this.i = iKeyboardTypeConverter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d8, code lost:
        if (r0 != false) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x010f, code lost:
        if (r10.f.length() > 0) goto L_0x0111;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0117 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
        // Method dump skipped, instructions count: 281
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.editional.SuggestAnswerContainer.a():boolean");
    }

    @NotNull
    public final String getAnsweredText() {
        return this.f;
    }

    public final void hideListSuggest() {
        getSuggestList().setValue(CollectionsKt__CollectionsKt.emptyList());
    }

    public final void initSuggestContainer(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull SuggestModeEnum suggestModeEnum) {
        Intrinsics.checkParameterIsNotNull(suggestModeEnum, "mode");
        String str4 = "";
        this.f = str3 != null ? str3 : str4;
        if (str3 != null) {
            str4 = str3;
        }
        this.g = str4;
        this.h = suggestModeEnum;
        getInputType().setValue(Integer.valueOf(this.i.convertTextTypeToInputType(str)));
        getHint().setValue(str2);
        getSuggestText().setValue(str3);
        getCanAnswer().setValue(Boolean.valueOf(a()));
        hideListSuggest();
    }

    public final void setListSuggestInfo(@NotNull List<SuggestInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "listSuggestInfo");
        getSuggestList().setValue(list);
        getCanAnswer().setValue(Boolean.valueOf(a()));
    }

    public final void setTextFromKeyboard(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        this.f = str;
        getCanAnswer().setValue(Boolean.valueOf(a()));
    }

    public final void setTextFromSuggestList(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        this.f = str;
        getSuggestText().setValue(str);
        getCanAnswer().setValue(Boolean.valueOf(a()));
        hideListSuggest();
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.editional.ISuggestAnswerParam
    @NotNull
    public MutableLiveData<Boolean> getCanAnswer() {
        return this.a;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.editional.ISuggestAnswerParam
    @NotNull
    public MutableLiveData<String> getHint() {
        return this.c;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.editional.ISuggestAnswerParam
    @NotNull
    public MutableLiveData<Integer> getInputType() {
        return this.b;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.editional.ISuggestAnswerParam
    @NotNull
    public MutableLiveData<List<SuggestInfo>> getSuggestList() {
        return this.e;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.editional.ISuggestAnswerParam
    @NotNull
    public MutableLiveData<String> getSuggestText() {
        return this.d;
    }
}
