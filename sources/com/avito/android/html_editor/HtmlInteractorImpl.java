package com.avito.android.html_editor;

import android.text.Spanned;
import androidx.annotation.MainThread;
import com.avito.android.html_editor.HtmlInteractor;
import com.avito.android.html_formatter.EditorOperation;
import com.avito.android.html_formatter.FormatChange;
import com.avito.android.html_formatter.FormatOperation;
import com.avito.android.html_formatter.HtmlNode;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.html_formatter.InsertOperation;
import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.html_formatter.ReplaceOperation;
import com.avito.android.html_formatter.span.NodeSpan;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BB\u0012\u0006\u0010-\u001a\u00020+\u0012\u0006\u0010>\u001a\u00020<\u0012\u0006\u00104\u001a\u000202\u0012!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110&¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u001505¢\u0006\u0004\b?\u0010@J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\nJ-\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0017¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0017¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00102\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001e\u001a\u00020\u001d*\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0002¢\u0006\u0004\b \u0010!J!\u0010#\u001a\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0005\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$R\"\u0010*\u001a\b\u0012\u0004\u0012\u00020&0%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010,R:\u00101\u001a&\u0012\f\u0012\n /*\u0004\u0018\u00010&0& /*\u0012\u0012\f\u0012\n /*\u0004\u0018\u00010&0&\u0018\u00010.0.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u00100R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u00103R1\u0010;\u001a\u001d\u0012\u0013\u0012\u00110&¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u0015058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010=¨\u0006A"}, d2 = {"Lcom/avito/android/html_editor/HtmlInteractorImpl;", "Lcom/avito/android/html_editor/HtmlInteractor;", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "rootNode", "Landroid/text/Spanned;", "textBeforeChanges", "Lcom/avito/android/html_formatter/EditorOperation;", "operation", "Lcom/avito/android/html_editor/HtmlInteractor$OperationResult;", "applyOperation", "(Lcom/avito/android/html_formatter/MutableHtmlNode;Landroid/text/Spanned;Lcom/avito/android/html_formatter/EditorOperation;)Lcom/avito/android/html_editor/HtmlInteractor$OperationResult;", "", "operations", "applyOperationsList", "(Lcom/avito/android/html_formatter/MutableHtmlNode;Landroid/text/Spanned;Ljava/util/List;)Lcom/avito/android/html_editor/HtmlInteractor$OperationResult;", "text", "", "selectionStart", "selectionEnd", "getFormat", "(Landroid/text/Spanned;II)I", "", "removePendingOperations", "()V", "e", "(Lcom/avito/android/html_formatter/MutableHtmlNode;Landroid/text/Spanned;Lcom/avito/android/html_formatter/EditorOperation;II)I", AuthSource.BOOKING_ORDER, "(Ljava/util/List;)I", "flag", "", AuthSource.SEND_ABUSE, "(II)Z", "d", "(Ljava/util/List;)Z", "", "c", "(Ljava/util/List;Ljava/lang/String;)Z", "Lio/reactivex/Observable;", "Lcom/avito/android/html_editor/HistorySnapshot;", "Lio/reactivex/Observable;", "getHistorySnapshots", "()Lio/reactivex/Observable;", "historySnapshots", "Lcom/avito/android/html_editor/OperationTreeDisassembler;", "Lcom/avito/android/html_editor/OperationTreeDisassembler;", "operationTreeDisassembler", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "Lcom/jakewharton/rxrelay2/PublishRelay;", "snapshotStream", "Lcom/avito/android/html_editor/EditorState;", "Lcom/avito/android/html_editor/EditorState;", "state", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "snapshot", "f", "Lkotlin/jvm/functions/Function1;", "snapshotListener", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "renderOptions", "<init>", "(Lcom/avito/android/html_editor/OperationTreeDisassembler;Lcom/avito/android/html_formatter/HtmlRenderOptions;Lcom/avito/android/html_editor/EditorState;Lkotlin/jvm/functions/Function1;)V", "html-editor_release"}, k = 1, mv = {1, 4, 2})
public final class HtmlInteractorImpl implements HtmlInteractor {
    public final PublishRelay<HistorySnapshot> a;
    @NotNull
    public final Observable<HistorySnapshot> b;
    public final OperationTreeDisassembler c;
    public final HtmlRenderOptions d;
    public final EditorState e;
    public final Function1<HistorySnapshot, Unit> f;

    public static final class a extends Lambda implements Function4<Integer, NodeSpan, Integer, Integer, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Ref.IntRef intRef, int i2) {
            super(4);
            this.a = i;
            this.b = intRef;
            this.c = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function4
        public Unit invoke(Integer num, NodeSpan nodeSpan, Integer num2, Integer num3) {
            MutableHtmlNode mutableHtmlNode;
            int i;
            int i2;
            int i3;
            int i4;
            MutableHtmlNode asMutable;
            int intValue = num.intValue();
            NodeSpan nodeSpan2 = nodeSpan;
            num2.intValue();
            int intValue2 = num3.intValue();
            Intrinsics.checkNotNullParameter(nodeSpan2, "span");
            if (this.a == 0 && intValue == 0 && nodeSpan2.getNode().isBlock()) {
                HtmlNode leftSiblingBlock = nodeSpan2.getNode().getLeftSiblingBlock();
                if (leftSiblingBlock == null || (mutableHtmlNode = leftSiblingBlock.asMutable()) == null) {
                    mutableHtmlNode = nodeSpan2.getNode().asMutable();
                }
            } else {
                mutableHtmlNode = nodeSpan2.getNode().asMutable();
            }
            Ref.IntRef intRef = this.b;
            if (mutableHtmlNode.isBlock() && (intValue2 != (i4 = this.c) || this.a == i4)) {
                HtmlNode firstChildTextNode = mutableHtmlNode.getFirstChildTextNode();
                if (firstChildTextNode == null) {
                    firstChildTextNode = mutableHtmlNode.getFirstBlankRow();
                }
                if (firstChildTextNode == null || (asMutable = firstChildTextNode.asMutable()) == null) {
                    i = this.b.element;
                    intRef.element = i;
                    return Unit.INSTANCE;
                }
                i3 = asMutable.getFormat();
                i2 = this.b.element;
            } else if (!mutableHtmlNode.isBlock()) {
                i2 = this.b.element;
                i3 = mutableHtmlNode.getFormat();
            } else {
                i = this.b.element;
                intRef.element = i;
                return Unit.INSTANCE;
            }
            i = i3 & i2;
            intRef.element = i;
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.html_editor.HistorySnapshot, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public HtmlInteractorImpl(@NotNull OperationTreeDisassembler operationTreeDisassembler, @NotNull HtmlRenderOptions htmlRenderOptions, @NotNull EditorState editorState, @NotNull Function1<? super HistorySnapshot, Unit> function1) {
        Intrinsics.checkNotNullParameter(operationTreeDisassembler, "operationTreeDisassembler");
        Intrinsics.checkNotNullParameter(htmlRenderOptions, "renderOptions");
        Intrinsics.checkNotNullParameter(editorState, "state");
        Intrinsics.checkNotNullParameter(function1, "snapshotListener");
        this.c = operationTreeDisassembler;
        this.d = htmlRenderOptions;
        this.e = editorState;
        this.f = function1;
        PublishRelay<HistorySnapshot> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "snapshotStream");
        this.b = create;
    }

    public final boolean a(int i, int i2) {
        return (i & i2) == i2;
    }

    @Override // com.avito.android.html_editor.HtmlInteractor
    @MainThread
    @NotNull
    public HtmlInteractor.OperationResult applyOperation(@NotNull MutableHtmlNode mutableHtmlNode, @NotNull Spanned spanned, @NotNull EditorOperation editorOperation) {
        Intrinsics.checkNotNullParameter(mutableHtmlNode, "rootNode");
        Intrinsics.checkNotNullParameter(spanned, "textBeforeChanges");
        Intrinsics.checkNotNullParameter(editorOperation, "operation");
        return applyOperationsList(mutableHtmlNode, spanned, d.listOf(editorOperation));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0115, code lost:
        if (r0 != false) goto L_0x0117;
     */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x007c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x02cc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0093  */
    @Override // com.avito.android.html_editor.HtmlInteractor
    @androidx.annotation.MainThread
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.html_editor.HtmlInteractor.OperationResult applyOperationsList(@org.jetbrains.annotations.NotNull com.avito.android.html_formatter.MutableHtmlNode r19, @org.jetbrains.annotations.NotNull android.text.Spanned r20, @org.jetbrains.annotations.NotNull java.util.List<? extends com.avito.android.html_formatter.EditorOperation> r21) {
        /*
        // Method dump skipped, instructions count: 969
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.html_editor.HtmlInteractorImpl.applyOperationsList(com.avito.android.html_formatter.MutableHtmlNode, android.text.Spanned, java.util.List):com.avito.android.html_editor.HtmlInteractor$OperationResult");
    }

    public final int b(List<? extends EditorOperation> list) {
        int i;
        int i2 = 0;
        for (T t : list) {
            if (t instanceof InsertOperation) {
                i = t.getContent().length();
            } else {
                i = t instanceof ReplaceOperation ? b(t.getInsertOperations()) : 0;
            }
            i2 += i;
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(java.util.List<? extends com.avito.android.html_formatter.EditorOperation> r5, java.lang.String r6) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof java.util.Collection
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000e
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L_0x000e
        L_0x000c:
            r1 = 0
            goto L_0x0039
        L_0x000e:
            java.util.Iterator r5 = r5.iterator()
        L_0x0012:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r5.next()
            com.avito.android.html_formatter.EditorOperation r0 = (com.avito.android.html_formatter.EditorOperation) r0
            boolean r3 = r0 instanceof com.avito.android.html_formatter.DeleteOperation
            if (r3 == 0) goto L_0x0036
            com.avito.android.html_formatter.DeleteOperation r0 = (com.avito.android.html_formatter.DeleteOperation) r0
            int r3 = r0.getFrom()
            if (r3 != 0) goto L_0x0036
            int r0 = r0.getTo()
            int r3 = r6.length()
            if (r0 != r3) goto L_0x0036
            r0 = 1
            goto L_0x0037
        L_0x0036:
            r0 = 0
        L_0x0037:
            if (r0 == 0) goto L_0x0012
        L_0x0039:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.html_editor.HtmlInteractorImpl.c(java.util.List, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0069, code lost:
        if ((!r3.isEmpty()) != false) goto L_0x006b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0070 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(java.util.List<? extends com.avito.android.html_formatter.EditorOperation> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof java.util.Collection
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000e
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L_0x000e
        L_0x000c:
            r1 = 0
            goto L_0x0070
        L_0x000e:
            java.util.Iterator r8 = r8.iterator()
        L_0x0012:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r8.next()
            com.avito.android.html_formatter.EditorOperation r0 = (com.avito.android.html_formatter.EditorOperation) r0
            boolean r3 = r0 instanceof com.avito.android.html_formatter.InsertOperation
            r4 = 10
            if (r3 == 0) goto L_0x0031
            r3 = r0
            com.avito.android.html_formatter.InsertOperation r3 = (com.avito.android.html_formatter.InsertOperation) r3
            java.lang.String r3 = r3.getContent()
            char r3 = kotlin.text.StringsKt___StringsKt.last(r3)
            if (r3 == r4) goto L_0x006b
        L_0x0031:
            boolean r3 = r0 instanceof com.avito.android.html_formatter.ReplaceOperation
            if (r3 == 0) goto L_0x006d
            com.avito.android.html_formatter.ReplaceOperation r0 = (com.avito.android.html_formatter.ReplaceOperation) r0
            java.util.List r0 = r0.getInsertOperations()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0044:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0064
            java.lang.Object r5 = r0.next()
            r6 = r5
            com.avito.android.html_formatter.InsertOperation r6 = (com.avito.android.html_formatter.InsertOperation) r6
            java.lang.String r6 = r6.getContent()
            char r6 = kotlin.text.StringsKt___StringsKt.last(r6)
            if (r6 != r4) goto L_0x005d
            r6 = 1
            goto L_0x005e
        L_0x005d:
            r6 = 0
        L_0x005e:
            if (r6 == 0) goto L_0x0044
            r3.add(r5)
            goto L_0x0044
        L_0x0064:
            boolean r0 = r3.isEmpty()
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x006d
        L_0x006b:
            r0 = 1
            goto L_0x006e
        L_0x006d:
            r0 = 0
        L_0x006e:
            if (r0 == 0) goto L_0x0012
        L_0x0070:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.html_editor.HtmlInteractorImpl.d(java.util.List):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00fd, code lost:
        if (r19 == r20) goto L_0x0104;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int e(com.avito.android.html_formatter.MutableHtmlNode r16, android.text.Spanned r17, com.avito.android.html_formatter.EditorOperation r18, int r19, int r20) {
        /*
        // Method dump skipped, instructions count: 261
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.html_editor.HtmlInteractorImpl.e(com.avito.android.html_formatter.MutableHtmlNode, android.text.Spanned, com.avito.android.html_formatter.EditorOperation, int, int):int");
    }

    @Override // com.avito.android.html_editor.HtmlInteractor
    @MainThread
    public int getFormat(@NotNull Spanned spanned, int i, int i2) {
        Intrinsics.checkNotNullParameter(spanned, "text");
        int min = Math.min(i, i2);
        int max = Math.max(i, i2);
        int coerceAtLeast = min == max ? e.coerceAtLeast(min - 1, 0) : min;
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 31;
        SpannedUtilsKt.iterateThroughSpansInOrder(spanned, coerceAtLeast, max, NodeSpan.class, new a(min, intRef, max));
        if ((intRef.element & 16) == 16) {
            intRef.element = 0;
        }
        List<FormatOperation> pendingFormatOperations = this.e.getPendingFormatOperations();
        int i3 = intRef.element;
        Iterator<T> it = pendingFormatOperations.iterator();
        while (it.hasNext()) {
            FormatChange formatChange = it.next().getFormatChange();
            FormatChange.Type type = formatChange.getType();
            FormatChange.Type type2 = FormatChange.Type.ADD;
            if (type != type2 || !a(i3, formatChange.getValue())) {
                if (formatChange.getType() != type2 || a(i3, formatChange.getValue())) {
                    FormatChange.Type type3 = formatChange.getType();
                    FormatChange.Type type4 = FormatChange.Type.REMOVE;
                    if (type3 == type4 && a(i3, formatChange.getValue())) {
                        i3 -= formatChange.getValue();
                    } else if (formatChange.getType() == type4) {
                        a(i3, formatChange.getValue());
                    }
                } else {
                    i3 = formatChange.getValue() + i3;
                }
            }
        }
        intRef.element = i3;
        return i3;
    }

    @Override // com.avito.android.html_editor.HtmlInteractor
    @NotNull
    public Observable<HistorySnapshot> getHistorySnapshots() {
        return this.b;
    }

    @Override // com.avito.android.html_editor.HtmlInteractor
    @MainThread
    public void removePendingOperations() {
        this.e.getPendingFormatOperations().clear();
    }
}
