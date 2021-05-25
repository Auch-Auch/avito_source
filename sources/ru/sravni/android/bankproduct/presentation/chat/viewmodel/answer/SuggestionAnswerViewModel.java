package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import a2.g.r.g;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.chat.IChatInteractor;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerSuggestionDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.card.SuggestTextContentCardDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.editional.SuggestAnswerContainer;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardTypeConverter;
import t6.n.e;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u0010P\u001a\u00020O\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u0010N\u001a\u00020K¢\u0006\u0004\bQ\u0010RJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0010\u0010\u000bJ\u0019\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u000bR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\"\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R$\u0010-\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00030\u00030)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010/R\u001c\u00106\u001a\u0002018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R(\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110?0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b@\u0010\u001d\u001a\u0004\bA\u0010\u001fR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\"\u0010J\u001a\b\u0012\u0004\u0012\u00020G0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bH\u0010\u001d\u001a\u0004\bI\u0010\u001fR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010M¨\u0006S"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/SuggestionAnswerViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ISuggestionAnswerViewModel;", "", "conversationID", "Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;", "contentCard", "", "init", "(Ljava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;)V", "needShowSuggestions", "()V", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;", "answerSender", "sendAnswer", "(Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;)V", "onCleared", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/SuggestInfo;", "suggestInfo", "setSuggestInfo", "(Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/SuggestInfo;)V", "c", "Lio/reactivex/disposables/Disposable;", "j", "Lio/reactivex/disposables/Disposable;", "suggestSubscription", "Landroidx/lifecycle/MutableLiveData;", "", "d", "Landroidx/lifecycle/MutableLiveData;", "getCanAnswer", "()Landroidx/lifecycle/MutableLiveData;", "canAnswer", g.a, "getSuggestText", "suggestText", "f", "getHint", "hint", "l", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/SuggestInfo;", "Lio/reactivex/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "k", "Lio/reactivex/subjects/PublishSubject;", "searchTextPublishSubject", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/editional/SuggestAnswerContainer;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/editional/SuggestAnswerContainer;", "suggestAnswerContainer", "Landroid/text/TextWatcher;", "i", "Landroid/text/TextWatcher;", "getTextWatcher", "()Landroid/text/TextWatcher;", "textWatcher", "Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;", "n", "Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;", "chatInteractor", "Lru/sravni/android/bankproduct/domain/chat/entity/card/SuggestTextContentCardDomain;", AuthSource.OPEN_CHANNEL_LIST, "Lru/sravni/android/bankproduct/domain/chat/entity/card/SuggestTextContentCardDomain;", "suggestCard", "", "h", "getSuggestList", "suggestList", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "o", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "", "e", "getInputType", "inputType", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "p", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardTypeConverter;", "keyboardTypeConverter", "<init>", "(Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardTypeConverter;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SuggestionAnswerViewModel extends ViewModel implements ISuggestionAnswerViewModel {
    public final SuggestAnswerContainer c;
    @NotNull
    public final MutableLiveData<Boolean> d;
    @NotNull
    public final MutableLiveData<Integer> e;
    @NotNull
    public final MutableLiveData<String> f;
    @NotNull
    public final MutableLiveData<String> g;
    @NotNull
    public final MutableLiveData<List<SuggestInfo>> h;
    @NotNull
    public final TextWatcher i = new TextWatcher(this) { // from class: ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.SuggestionAnswerViewModel$textWatcher$1
        public final /* synthetic */ SuggestionAnswerViewModel a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i2, int i3, int i4) {
            SuggestionAnswerViewModel.access$textFromKeyboard(this.a, StringsKt__StringsKt.trim(String.valueOf(charSequence)).toString());
        }
    };
    public Disposable j;
    public final PublishSubject<String> k;
    public SuggestInfo l;
    public SuggestTextContentCardDomain m;
    public final IChatInteractor n;
    public final IErrorLogger o;
    public final IThrowableWrapper p;

    public static final class a<T, R> implements Function<T, ObservableSource<? extends R>> {
        public final /* synthetic */ SuggestionAnswerViewModel a;

        public a(SuggestionAnswerViewModel suggestionAnswerViewModel) {
            this.a = suggestionAnswerViewModel;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            String str = (String) obj;
            Intrinsics.checkParameterIsNotNull(str, "searchText");
            SuggestTextContentCardDomain suggestTextContentCardDomain = this.a.m;
            Observable<DataContainer<List<AnswerSuggestionDomain>>> suggestion = suggestTextContentCardDomain != null ? this.a.n.getSuggestion(suggestTextContentCardDomain.getConversationId(), suggestTextContentCardDomain.getOrderId(), suggestTextContentCardDomain.getFieldContentName(), str) : null;
            if (suggestion != null) {
                return suggestion;
            }
            Observable just = Observable.just(new DataContainer(null, this.a.p.wrap(new NullSuggestCardWhileAskSuggestError())));
            Intrinsics.checkExpressionValueIsNotNull(just, "Observable.just(\n       …  )\n                    )");
            return just;
        }
    }

    public static final class b<T> implements Consumer<DataContainer<? extends List<? extends AnswerSuggestionDomain>>> {
        public final /* synthetic */ SuggestionAnswerViewModel a;

        public b(SuggestionAnswerViewModel suggestionAnswerViewModel) {
            this.a = suggestionAnswerViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(DataContainer<? extends List<? extends AnswerSuggestionDomain>> dataContainer) {
            DataContainer<? extends List<? extends AnswerSuggestionDomain>> dataContainer2 = dataContainer;
            if (dataContainer2.getValue() != null) {
                Iterable iterable = (Iterable) dataContainer2.getValue();
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(iterable, 10));
                for (T t : iterable) {
                    arrayList.add(new SuggestInfo(t.getSuggestion(), t.getExtraSuggestion(), t.getOptionalFields(), t.isComplete()));
                }
                this.a.c.setListSuggestInfo(arrayList);
                return;
            }
            this.a.c.hideListSuggest();
            this.a.o.logError(MessagePriority.WARN, this.a.p.wrap(dataContainer2.getError()));
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ SuggestionAnswerViewModel a;

        public c(SuggestionAnswerViewModel suggestionAnswerViewModel) {
            this.a = suggestionAnswerViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.c.hideListSuggest();
            this.a.o.logError(MessagePriority.WARN, this.a.p.wrap(th));
        }
    }

    public SuggestionAnswerViewModel(@NotNull IChatInteractor iChatInteractor, @NotNull IKeyboardTypeConverter iKeyboardTypeConverter, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iChatInteractor, "chatInteractor");
        Intrinsics.checkParameterIsNotNull(iKeyboardTypeConverter, "keyboardTypeConverter");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        this.n = iChatInteractor;
        this.o = iErrorLogger;
        this.p = iThrowableWrapper;
        SuggestAnswerContainer suggestAnswerContainer = new SuggestAnswerContainer(iKeyboardTypeConverter);
        this.c = suggestAnswerContainer;
        this.d = suggestAnswerContainer.getCanAnswer();
        this.e = suggestAnswerContainer.getInputType();
        this.f = suggestAnswerContainer.getHint();
        this.g = suggestAnswerContainer.getSuggestText();
        this.h = suggestAnswerContainer.getSuggestList();
        PublishSubject<String> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<String>()");
        this.k = create;
    }

    public static final void access$textFromKeyboard(SuggestionAnswerViewModel suggestionAnswerViewModel, String str) {
        suggestionAnswerViewModel.c.setTextFromKeyboard(str);
        if (!(str.length() > 0)) {
            SuggestTextContentCardDomain suggestTextContentCardDomain = suggestionAnswerViewModel.m;
            if (!Intrinsics.areEqual(suggestTextContentCardDomain != null ? suggestTextContentCardDomain.getShowSuggestImmediately() : null, Boolean.TRUE)) {
                Disposable disposable = suggestionAnswerViewModel.j;
                if (disposable != null) {
                    disposable.dispose();
                }
                suggestionAnswerViewModel.c.hideListSuggest();
                suggestionAnswerViewModel.c();
                return;
            }
        }
        suggestionAnswerViewModel.k.onNext(str);
    }

    public final void c() {
        this.j = this.k.debounce(200, TimeUnit.MILLISECONDS).switchMap(new a(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISuggestionAnswerViewModel
    @NotNull
    public TextWatcher getTextWatcher() {
        return this.i;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize
    public void init(@NotNull String str, @Nullable IContentCardDomain iContentCardDomain) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        Unit unit = null;
        if (!(iContentCardDomain instanceof SuggestTextContentCardDomain)) {
            iContentCardDomain = null;
        }
        SuggestTextContentCardDomain suggestTextContentCardDomain = (SuggestTextContentCardDomain) iContentCardDomain;
        if (suggestTextContentCardDomain != null) {
            Disposable disposable = this.j;
            if (disposable != null) {
                disposable.dispose();
            }
            c();
            this.c.initSuggestContainer(suggestTextContentCardDomain.getKeyboardType(), suggestTextContentCardDomain.getHint(), suggestTextContentCardDomain.getSuggestText(), suggestTextContentCardDomain.getSuggestMode());
            this.m = suggestTextContentCardDomain;
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.c.hideListSuggest();
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISuggestionAnswerViewModel
    public void needShowSuggestions() {
        String str;
        SuggestTextContentCardDomain suggestTextContentCardDomain = this.m;
        if (Intrinsics.areEqual(suggestTextContentCardDomain != null ? suggestTextContentCardDomain.getShowSuggestImmediately() : null, Boolean.TRUE)) {
            PublishSubject<String> publishSubject = this.k;
            SuggestTextContentCardDomain suggestTextContentCardDomain2 = this.m;
            if (suggestTextContentCardDomain2 == null || (str = suggestTextContentCardDomain2.getSuggestText()) == null) {
                str = "";
            }
            publishSubject.onNext(str);
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onCleared();
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISuggestionAnswerViewModel
    public void sendAnswer(@NotNull INextContentCard iNextContentCard) {
        Map<String, String> optionalFields;
        Intrinsics.checkParameterIsNotNull(iNextContentCard, "answerSender");
        this.c.hideListSuggest();
        String answeredText = this.c.getAnsweredText();
        SuggestTextContentCardDomain suggestTextContentCardDomain = this.m;
        Unit unit = null;
        if (suggestTextContentCardDomain != null) {
            int orderId = suggestTextContentCardDomain.getOrderId();
            String conversationId = suggestTextContentCardDomain.getConversationId();
            Map mutableMapOf = r.mutableMapOf(TuplesKt.to(suggestTextContentCardDomain.getFieldContentName(), answeredText));
            SuggestInfo suggestInfo = this.l;
            if (!(suggestInfo == null || (optionalFields = suggestInfo.getOptionalFields()) == null)) {
                for (Map.Entry<String, String> entry : optionalFields.entrySet()) {
                    mutableMapOf.put(entry.getKey(), entry.getValue());
                }
            }
            iNextContentCard.nextCard(new AnswerInfoDomain(orderId, conversationId, answeredText, mutableMapOf, null, 16, null));
            Disposable disposable = this.j;
            if (disposable != null) {
                disposable.dispose();
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            this.o.logError(MessagePriority.ERROR, this.p.wrap(new NullSuggestCardWhileSendAnswerError()));
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISetSuggestion
    public void setSuggestInfo(@Nullable SuggestInfo suggestInfo) {
        this.l = suggestInfo;
        if (suggestInfo != null) {
            this.c.setTextFromSuggestList(suggestInfo.getSuggest());
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.editional.ISuggestAnswerParam
    @NotNull
    public MutableLiveData<Boolean> getCanAnswer() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.editional.ISuggestAnswerParam
    @NotNull
    public MutableLiveData<String> getHint() {
        return this.f;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.editional.ISuggestAnswerParam
    @NotNull
    public MutableLiveData<Integer> getInputType() {
        return this.e;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.editional.ISuggestAnswerParam
    @NotNull
    public MutableLiveData<List<SuggestInfo>> getSuggestList() {
        return this.h;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.editional.ISuggestAnswerParam
    @NotNull
    public MutableLiveData<String> getSuggestText() {
        return this.g;
    }
}
