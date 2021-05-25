package com.sumsub.sns.camera.photo.presentation;

import a2.g.r.g;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelKt;
import com.avito.android.remote.auth.AuthSource;
import com.google.gson.Gson;
import com.sumsub.sns.core.data.model.IdentityType;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.domain.SendLogUseCase;
import com.sumsub.sns.core.presentation.base.SNSBaseViewModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\u0006R;\u0010\u0012\u001a$\u0012 \u0012\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R%\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00140\u00138\u0002@\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR(\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00140\u000b8\u0006@\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R-\u0010$\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f0\u00138\u0002@\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b#\u0010\u0016R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010&R0\u0010,\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f0\u000b8\u0006@\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b*\u0010\u000f\u001a\u0004\b+\u0010\u0011R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"Lcom/sumsub/sns/camera/photo/presentation/SNSDocumentSelectorViewModel;", "Lcom/sumsub/sns/core/presentation/base/SNSBaseViewModel;", "", "countryName", "", "onCountrySelected", "(Ljava/lang/String;)V", "Lcom/sumsub/sns/core/data/model/IdentityType;", "document", "onDocumentSelected-wYDFDDU", "onDocumentSelected", "Landroidx/lifecycle/LiveData;", "Lkotlin/Pair;", "", "h", "Landroidx/lifecycle/LiveData;", "getCountries", "()Landroidx/lifecycle/LiveData;", "countries", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "i", "Lkotlinx/coroutines/flow/MutableStateFlow;", "documentsFlow", "Lcom/google/gson/Gson;", "n", "Lcom/google/gson/Gson;", "gson", "j", "getDocuments", "documents", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "o", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "k", "selectionFlow", "p", "Ljava/lang/String;", "flowName", g.a, "currentCountryKey", "l", "getSelection", "selection", "Landroidx/lifecycle/SavedStateHandle;", AuthSource.OPEN_CHANNEL_LIST, "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "Lcom/sumsub/sns/core/domain/SendLogUseCase;", "sendLogUseCase", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Lcom/google/gson/Gson;Lcom/sumsub/sns/core/data/source/common/CommonRepository;Ljava/lang/String;Lcom/sumsub/sns/core/domain/SendLogUseCase;)V", "sns-camera-photo-document-picker_release"}, k = 1, mv = {1, 4, 2})
public final class SNSDocumentSelectorViewModel extends SNSBaseViewModel {
    public String g;
    @NotNull
    public final LiveData<Pair<Map<String, String>, String>> h = FlowLiveDataConversions.asLiveData$default(FlowKt.flow(new a(this, null)), (CoroutineContext) null, 0, 3, (Object) null);
    public final MutableStateFlow<List<IdentityType>> i;
    @NotNull
    public final LiveData<List<IdentityType>> j;
    public final MutableStateFlow<Pair<String, IdentityType>> k;
    @NotNull
    public final LiveData<Pair<String, IdentityType>> l;
    public final SavedStateHandle m;
    public final Gson n;
    public final CommonRepository o;
    public final String p;

    @DebugMetadata(c = "com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorViewModel$countries$1", f = "SNSDocumentSelectorViewModel.kt", i = {0, 1, 1}, l = {33, 37, 39}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "result"}, s = {"L$0", "L$0", "L$1"})
    public static final class a extends SuspendLambda implements Function2<FlowCollector<? super Pair<? extends Map<String, ? extends String>, ? extends String>>, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object b;
        public Object c;
        public int d;
        public final /* synthetic */ SNSDocumentSelectorViewModel e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSDocumentSelectorViewModel sNSDocumentSelectorViewModel, Continuation continuation) {
            super(2, continuation);
            this.e = sNSDocumentSelectorViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            a aVar = new a(this.e, continuation);
            aVar.b = obj;
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Pair<? extends Map<String, ? extends String>, ? extends String>> flowCollector, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            a aVar = new a(this.e, continuation2);
            aVar.b = flowCollector;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0134, code lost:
            if (kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10).booleanValue() != false) goto L_0x0138;
         */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00ce  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x011e A[EDGE_INSN: B:71:0x011e->B:49:0x011e ?: BREAK  ] */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0123 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0152 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r20) {
            /*
            // Method dump skipped, instructions count: 359
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorViewModel.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorViewModel$onCountrySelected$1", f = "SNSDocumentSelectorViewModel.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ SNSDocumentSelectorViewModel c;
        public final /* synthetic */ String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SNSDocumentSelectorViewModel sNSDocumentSelectorViewModel, String str, Continuation continuation) {
            super(2, continuation);
            this.c = sNSDocumentSelectorViewModel;
            this.d = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new b(this.c, this.d, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new b(this.c, this.d, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x00dc  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0112  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x011d  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0123  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0128  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
            /*
            // Method dump skipped, instructions count: 401
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorViewModel.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public SNSDocumentSelectorViewModel(@NotNull SavedStateHandle savedStateHandle, @NotNull Gson gson, @NotNull CommonRepository commonRepository, @NotNull String str, @NotNull SendLogUseCase sendLogUseCase) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(str, "flowName");
        Intrinsics.checkNotNullParameter(sendLogUseCase, "sendLogUseCase");
        this.m = savedStateHandle;
        this.n = gson;
        this.o = commonRepository;
        this.p = str;
        MutableStateFlow<List<IdentityType>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt__CollectionsKt.emptyList());
        this.i = MutableStateFlow;
        this.j = FlowLiveDataConversions.asLiveData$default(MutableStateFlow, (CoroutineContext) null, 0, 3, (Object) null);
        MutableStateFlow<Pair<String, IdentityType>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this.k = MutableStateFlow2;
        this.l = FlowLiveDataConversions.asLiveData$default(MutableStateFlow2, (CoroutineContext) null, 0, 3, (Object) null);
    }

    @NotNull
    public final LiveData<Pair<Map<String, String>, String>> getCountries() {
        return this.h;
    }

    @NotNull
    public final LiveData<List<IdentityType>> getDocuments() {
        return this.j;
    }

    @NotNull
    public final LiveData<Pair<String, IdentityType>> getSelection() {
        return this.l;
    }

    public final void onCountrySelected(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "countryName");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new b(this, str, null), 3, null);
    }

    /* renamed from: onDocumentSelected-wYDFDDU  reason: not valid java name */
    public final void m190onDocumentSelectedwYDFDDU(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "document");
        String str2 = this.g;
        if (str2 != null) {
            this.k.setValue(new Pair<>(str2, IdentityType.m201boximpl(str)));
        }
    }
}
