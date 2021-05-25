package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.card.PassportScanContentCardDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandler;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010G\u001a\u00020D¢\u0006\u0004\b[\u0010\\J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00190\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u0017R\"\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00190\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017R\u0016\u0010*\u001a\u00020\u00038\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\n8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b3\u0010\u001eR\"\u00106\u001a\b\u0012\u0004\u0012\u00020\u00190\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b5\u0010\u0015\u001a\u0004\b6\u0010\u0017R\u0016\u00108\u001a\u00020\n8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b7\u0010\u001eR\u0016\u0010:\u001a\u00020\u00038\u0002@\u0002X.¢\u0006\u0006\n\u0004\b9\u0010)R\"\u0010=\u001a\b\u0012\u0004\u0012\u00020\n0\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b;\u0010\u0015\u001a\u0004\b<\u0010\u0017R\"\u0010@\u001a\b\u0012\u0004\u0012\u00020\n0\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b>\u0010\u0015\u001a\u0004\b?\u0010\u0017R\"\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00190\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bA\u0010\u0015\u001a\u0004\bB\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010)R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\"\u0010N\u001a\b\u0012\u0004\u0012\u00020\n0\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bL\u0010\u0015\u001a\u0004\bM\u0010\u0017R\u0016\u0010P\u001a\u00020\n8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bO\u0010\u001eR\u001c\u0010V\u001a\u00020Q8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\"\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00190\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bW\u0010\u0015\u001a\u0004\bX\u0010\u0017R\u0016\u0010Z\u001a\u00020\u00038\u0002@\u0002X.¢\u0006\u0006\n\u0004\bY\u0010)¨\u0006]"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/PassportScanAnswerViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IPassportScanAnswerViewModel;", "", "conversationID", "Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;", "contentCard", "", "init", "(Ljava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;)V", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfo;", "documentFieldInfo", "setNewValue", "(Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfo;)V", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "getAnswerInfoDomain", "()Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "onCleared", "()V", "Landroidx/lifecycle/MutableLiveData;", "e", "Landroidx/lifecycle/MutableLiveData;", "getIssueDate", "()Landroidx/lifecycle/MutableLiveData;", "issueDate", "", "c", "getPassportScanSignal", "passportScanSignal", "o", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfo;", "seriesNumberDocInfo", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "w", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "h", "isMaskFilledSeriesNumber", "k", "isMaskFilledBirthDate", "s", "Ljava/lang/String;", "fio", "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", "y", "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", "resourceProvider", "", AuthSource.OPEN_CHANNEL_LIST, "I", "cardOrderID", "p", "issueDateDocInfo", "l", "isCompleteFields", "r", "birthDateDocInfo", "u", "authorityName", "f", "getAuthorityCode", "authorityCode", g.a, "getBirthDate", "birthDate", "i", "isMaskFilledIssueDate", "n", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "z", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "x", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "errorHandler", "d", "getSeriesNumber", "seriesNumber", VKApiConst.Q, "authorityCodeDocInfo", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandler;", VKApiConst.VERSION, "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandler;", "getMaskTextErrorHandler", "()Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandler;", "maskTextErrorHandler", "j", "isMaskFilledAuthorityCode", "t", "birthPlace", "<init>", "(Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class PassportScanAnswerViewModel extends ViewModel implements IPassportScanAnswerViewModel {
    @NotNull
    public final MutableLiveData<Boolean> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<DocumentFieldInfo> d = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<DocumentFieldInfo> e = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<DocumentFieldInfo> f = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<DocumentFieldInfo> g = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> h = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> i = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> j = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> k = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> l = new MutableLiveData<>();
    public int m;
    public String n = "";
    public DocumentFieldInfo o;
    public DocumentFieldInfo p;
    public DocumentFieldInfo q;
    public DocumentFieldInfo r;
    public String s;
    public String t;
    public String u;
    @NotNull
    public final IErrorHandler v = UtilFunctionsKt.errorHandlerAction(new a(this));
    public final IThrowableWrapper w;
    public final IErrorHandlerWithShow x;
    public final IResourceProvider y;
    public final IErrorLogger z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            DocumentFieldInfoEnum.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            DocumentFieldInfoEnum documentFieldInfoEnum = DocumentFieldInfoEnum.SERIES_NUMBER;
            iArr[0] = 1;
            DocumentFieldInfoEnum documentFieldInfoEnum2 = DocumentFieldInfoEnum.ISSUE_NUMBER;
            iArr[1] = 2;
            DocumentFieldInfoEnum documentFieldInfoEnum3 = DocumentFieldInfoEnum.AUTHORITY_CODE;
            iArr[2] = 3;
            DocumentFieldInfoEnum documentFieldInfoEnum4 = DocumentFieldInfoEnum.BIRTH_DATE;
            iArr[3] = 4;
        }
    }

    public static final class a extends Lambda implements Function1<SravniError, Unit> {
        public final /* synthetic */ PassportScanAnswerViewModel a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PassportScanAnswerViewModel passportScanAnswerViewModel) {
            super(1);
            this.a = passportScanAnswerViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SravniError sravniError) {
            SravniError sravniError2 = sravniError;
            Intrinsics.checkParameterIsNotNull(sravniError2, "error");
            this.a.z.logError(MessagePriority.WARN, sravniError2);
            return Unit.INSTANCE;
        }
    }

    public PassportScanAnswerViewModel(@NotNull IThrowableWrapper iThrowableWrapper, @NotNull IErrorHandlerWithShow iErrorHandlerWithShow, @NotNull IResourceProvider iResourceProvider, @NotNull IErrorLogger iErrorLogger) {
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        Intrinsics.checkParameterIsNotNull(iErrorHandlerWithShow, "errorHandler");
        Intrinsics.checkParameterIsNotNull(iResourceProvider, "resourceProvider");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        this.w = iThrowableWrapper;
        this.x = iErrorHandlerWithShow;
        this.y = iResourceProvider;
        this.z = iErrorLogger;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0026: APUT  
      (r0v1 kotlin.Pair[])
      (0 ??[int, short, byte, char])
      (wrap: kotlin.Pair : 0x0021: INVOKE  (r3v2 kotlin.Pair) = 
      (r3v1 java.lang.String)
      (wrap: java.lang.String : 0x001d: INVOKE  (r4v1 java.lang.String) = (r5v0 ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.DocumentFieldInfo) type: VIRTUAL call: ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.DocumentFieldInfo.getData():java.lang.String)
     type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel
    @NotNull
    public AnswerInfoDomain getAnswerInfoDomain() {
        int i2 = this.m;
        String str = this.n;
        Pair[] pairArr = new Pair[7];
        DocumentFieldInfo documentFieldInfo = this.o;
        if (documentFieldInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seriesNumberDocInfo");
        }
        String key = documentFieldInfo.getKey();
        DocumentFieldInfo documentFieldInfo2 = this.o;
        if (documentFieldInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seriesNumberDocInfo");
        }
        pairArr[0] = TuplesKt.to(key, documentFieldInfo2.getData());
        DocumentFieldInfo documentFieldInfo3 = this.p;
        if (documentFieldInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("issueDateDocInfo");
        }
        String key2 = documentFieldInfo3.getKey();
        DocumentFieldInfo documentFieldInfo4 = this.p;
        if (documentFieldInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("issueDateDocInfo");
        }
        pairArr[1] = TuplesKt.to(key2, documentFieldInfo4.getData());
        DocumentFieldInfo documentFieldInfo5 = this.q;
        if (documentFieldInfo5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorityCodeDocInfo");
        }
        String key3 = documentFieldInfo5.getKey();
        DocumentFieldInfo documentFieldInfo6 = this.q;
        if (documentFieldInfo6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorityCodeDocInfo");
        }
        pairArr[2] = TuplesKt.to(key3, documentFieldInfo6.getData());
        DocumentFieldInfo documentFieldInfo7 = this.r;
        if (documentFieldInfo7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("birthDateDocInfo");
        }
        String key4 = documentFieldInfo7.getKey();
        DocumentFieldInfo documentFieldInfo8 = this.r;
        if (documentFieldInfo8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("birthDateDocInfo");
        }
        pairArr[3] = TuplesKt.to(key4, documentFieldInfo8.getData());
        String str2 = this.s;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fio");
        }
        pairArr[4] = TuplesKt.to("cv_fio", str2);
        String str3 = this.t;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("birthPlace");
        }
        pairArr[5] = TuplesKt.to("cv_birthplace", str3);
        String str4 = this.u;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorityName");
        }
        pairArr[6] = TuplesKt.to("cv_pass_organization", str4);
        return new AnswerInfoDomain(i2, str, this.y.getString(R.string.send_data), r.mapOf(pairArr), null, 16, null);
    }

    @Override // ru.sravni.android.bankproduct.utils.masktext.IMaskTextErrorHandler
    @NotNull
    public IErrorHandler getMaskTextErrorHandler() {
        return this.v;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize
    public void init(@NotNull String str, @Nullable IContentCardDomain iContentCardDomain) {
        boolean z2;
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        if (!(iContentCardDomain instanceof PassportScanContentCardDomain)) {
            iContentCardDomain = null;
        }
        PassportScanContentCardDomain passportScanContentCardDomain = (PassportScanContentCardDomain) iContentCardDomain;
        if (passportScanContentCardDomain != null) {
            getPassportScanSignal().postValue(Boolean.TRUE);
            this.n = str;
            this.m = passportScanContentCardDomain.getOrderId();
            this.o = new DocumentFieldInfo("", "[0000] [000000]", UtilFunctionsKt.isCompleteMask("", "[0000] [000000]"), "pass_id", DocumentFieldInfoEnum.SERIES_NUMBER);
            MutableLiveData<DocumentFieldInfo> seriesNumber = getSeriesNumber();
            DocumentFieldInfo documentFieldInfo = this.o;
            if (documentFieldInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seriesNumberDocInfo");
            }
            seriesNumber.setValue(documentFieldInfo);
            MutableLiveData<Boolean> isMaskFilledSeriesNumber = isMaskFilledSeriesNumber();
            DocumentFieldInfo documentFieldInfo2 = this.o;
            if (documentFieldInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seriesNumberDocInfo");
            }
            isMaskFilledSeriesNumber.setValue(Boolean.valueOf(documentFieldInfo2.isComplete()));
            this.p = new DocumentFieldInfo("", "[00]{.}[00]{.}[0000]", UtilFunctionsKt.isCompleteMask("", "[00]{.}[00]{.}[0000]"), "date_received", DocumentFieldInfoEnum.ISSUE_NUMBER);
            MutableLiveData<DocumentFieldInfo> issueDate = getIssueDate();
            DocumentFieldInfo documentFieldInfo3 = this.p;
            if (documentFieldInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("issueDateDocInfo");
            }
            issueDate.setValue(documentFieldInfo3);
            MutableLiveData<Boolean> isMaskFilledIssueDate = isMaskFilledIssueDate();
            DocumentFieldInfo documentFieldInfo4 = this.p;
            if (documentFieldInfo4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("issueDateDocInfo");
            }
            isMaskFilledIssueDate.setValue(Boolean.valueOf(documentFieldInfo4.isComplete()));
            this.q = new DocumentFieldInfo("", "[000]-[000]", UtilFunctionsKt.isCompleteMask("", "[000]-[000]"), "code_pass_office", DocumentFieldInfoEnum.AUTHORITY_CODE);
            MutableLiveData<DocumentFieldInfo> authorityCode = getAuthorityCode();
            DocumentFieldInfo documentFieldInfo5 = this.q;
            if (documentFieldInfo5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorityCodeDocInfo");
            }
            authorityCode.setValue(documentFieldInfo5);
            MutableLiveData<Boolean> isMaskFilledAuthorityCode = isMaskFilledAuthorityCode();
            DocumentFieldInfo documentFieldInfo6 = this.q;
            if (documentFieldInfo6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorityCodeDocInfo");
            }
            isMaskFilledAuthorityCode.setValue(Boolean.valueOf(documentFieldInfo6.isComplete()));
            this.r = new DocumentFieldInfo("", "[00]{.}[00]{.}[0000]", UtilFunctionsKt.isCompleteMask("", "[00]{.}[00]{.}[0000]"), "birthday", DocumentFieldInfoEnum.BIRTH_DATE);
            MutableLiveData<DocumentFieldInfo> birthDate = getBirthDate();
            DocumentFieldInfo documentFieldInfo7 = this.r;
            if (documentFieldInfo7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("birthDateDocInfo");
            }
            birthDate.setValue(documentFieldInfo7);
            MutableLiveData<Boolean> isMaskFilledBirthDate = isMaskFilledBirthDate();
            DocumentFieldInfo documentFieldInfo8 = this.r;
            if (documentFieldInfo8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("birthDateDocInfo");
            }
            isMaskFilledBirthDate.setValue(Boolean.valueOf(documentFieldInfo8.isComplete()));
            this.s = "";
            this.t = "";
            this.u = "";
            MutableLiveData<Boolean> isCompleteFields = isCompleteFields();
            DocumentFieldInfo documentFieldInfo9 = this.o;
            if (documentFieldInfo9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seriesNumberDocInfo");
            }
            if (documentFieldInfo9.isComplete()) {
                DocumentFieldInfo documentFieldInfo10 = this.p;
                if (documentFieldInfo10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("issueDateDocInfo");
                }
                if (documentFieldInfo10.isComplete()) {
                    DocumentFieldInfo documentFieldInfo11 = this.q;
                    if (documentFieldInfo11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("authorityCodeDocInfo");
                    }
                    if (documentFieldInfo11.isComplete()) {
                        DocumentFieldInfo documentFieldInfo12 = this.r;
                        if (documentFieldInfo12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("birthDateDocInfo");
                        }
                        if (documentFieldInfo12.isComplete()) {
                            z2 = true;
                            isCompleteFields.setValue(Boolean.valueOf(z2));
                        }
                    }
                }
            }
            z2 = false;
            isCompleteFields.setValue(Boolean.valueOf(z2));
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009e, code lost:
        if (r0.isComplete() != false) goto L_0x00a2;
     */
    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setNewValue(@org.jetbrains.annotations.NotNull ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.DocumentFieldInfo r4) {
        /*
            r3 = this;
            java.lang.String r0 = "documentFieldInfo"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.DocumentFieldInfoEnum r0 = r4.getType()
            int r0 = r0.ordinal()
            r1 = 1
            if (r0 == 0) goto L_0x004f
            if (r0 == r1) goto L_0x003d
            r2 = 2
            if (r0 == r2) goto L_0x002b
            r2 = 3
            if (r0 == r2) goto L_0x0019
            goto L_0x0060
        L_0x0019:
            r3.r = r4
            androidx.lifecycle.MutableLiveData r0 = r3.isMaskFilledBirthDate()
            boolean r4 = r4.isComplete()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r0.setValue(r4)
            goto L_0x0060
        L_0x002b:
            r3.q = r4
            androidx.lifecycle.MutableLiveData r0 = r3.isMaskFilledAuthorityCode()
            boolean r4 = r4.isComplete()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r0.setValue(r4)
            goto L_0x0060
        L_0x003d:
            r3.p = r4
            androidx.lifecycle.MutableLiveData r0 = r3.isMaskFilledIssueDate()
            boolean r4 = r4.isComplete()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r0.setValue(r4)
            goto L_0x0060
        L_0x004f:
            r3.o = r4
            androidx.lifecycle.MutableLiveData r0 = r3.isMaskFilledSeriesNumber()
            boolean r4 = r4.isComplete()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r0.setValue(r4)
        L_0x0060:
            androidx.lifecycle.MutableLiveData r4 = r3.isCompleteFields()
            ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.DocumentFieldInfo r0 = r3.o
            if (r0 != 0) goto L_0x006d
            java.lang.String r2 = "seriesNumberDocInfo"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x006d:
            boolean r0 = r0.isComplete()
            if (r0 == 0) goto L_0x00a1
            ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.DocumentFieldInfo r0 = r3.p
            if (r0 != 0) goto L_0x007c
            java.lang.String r2 = "issueDateDocInfo"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x007c:
            boolean r0 = r0.isComplete()
            if (r0 == 0) goto L_0x00a1
            ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.DocumentFieldInfo r0 = r3.q
            if (r0 != 0) goto L_0x008b
            java.lang.String r2 = "authorityCodeDocInfo"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x008b:
            boolean r0 = r0.isComplete()
            if (r0 == 0) goto L_0x00a1
            ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.DocumentFieldInfo r0 = r3.r
            if (r0 != 0) goto L_0x009a
            java.lang.String r2 = "birthDateDocInfo"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x009a:
            boolean r0 = r0.isComplete()
            if (r0 == 0) goto L_0x00a1
            goto L_0x00a2
        L_0x00a1:
            r1 = 0
        L_0x00a2:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r4.setValue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.PassportScanAnswerViewModel.setNewValue(ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.DocumentFieldInfo):void");
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel
    @NotNull
    public MutableLiveData<DocumentFieldInfo> getAuthorityCode() {
        return this.f;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel
    @NotNull
    public MutableLiveData<DocumentFieldInfo> getBirthDate() {
        return this.g;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel
    @NotNull
    public MutableLiveData<DocumentFieldInfo> getIssueDate() {
        return this.e;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel
    @NotNull
    public MutableLiveData<Boolean> getPassportScanSignal() {
        return this.c;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel
    @NotNull
    public MutableLiveData<DocumentFieldInfo> getSeriesNumber() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel
    @NotNull
    public MutableLiveData<Boolean> isCompleteFields() {
        return this.l;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel
    @NotNull
    public MutableLiveData<Boolean> isMaskFilledAuthorityCode() {
        return this.j;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel
    @NotNull
    public MutableLiveData<Boolean> isMaskFilledBirthDate() {
        return this.k;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel
    @NotNull
    public MutableLiveData<Boolean> isMaskFilledIssueDate() {
        return this.i;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel
    @NotNull
    public MutableLiveData<Boolean> isMaskFilledSeriesNumber() {
        return this.h;
    }
}
