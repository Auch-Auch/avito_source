package com.avito.android.html_editor;

import android.text.Editable;
import android.text.Spannable;
import com.avito.android.html_formatter.DeleteOperation;
import com.avito.android.html_formatter.EditorOperation;
import com.avito.android.html_formatter.InsertOperation;
import com.avito.android.html_formatter.ReplaceOperation;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ/\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/html_editor/InputOperationFactoryImpl;", "Lcom/avito/android/html_editor/InputOperationFactory;", "Landroid/text/Spannable;", "text", "", Tracker.Events.CREATIVE_START, "count", "after", "", "beforeTextChanged", "(Landroid/text/Spannable;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "", "Lcom/avito/android/html_formatter/EditorOperation;", "getOperationsList", "(Landroid/text/Editable;)Ljava/util/List;", "clearCachedOperations", "(Landroid/text/Spannable;)V", "Lcom/avito/android/html_formatter/DeleteOperation;", AuthSource.SEND_ABUSE, "Lcom/avito/android/html_formatter/DeleteOperation;", "deleteOperation", "<init>", "()V", "html-editor_release"}, k = 1, mv = {1, 4, 2})
public final class InputOperationFactoryImpl implements InputOperationFactory {
    public DeleteOperation a;

    public static final class a {
    }

    @Override // com.avito.android.html_editor.InputOperationFactory
    public void beforeTextChanged(@NotNull Spannable spannable, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(spannable, "text");
        if (i2 != 0) {
            this.a = new DeleteOperation(i, i2 + i);
        }
    }

    @Override // com.avito.android.html_editor.InputOperationFactory
    public void clearCachedOperations(@Nullable Spannable spannable) {
        this.a = null;
        if (spannable != null) {
            a[] aVarArr = (a[]) spannable.getSpans(0, spannable.length(), a.class);
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    spannable.removeSpan(aVar);
                }
            }
        }
    }

    @Override // com.avito.android.html_editor.InputOperationFactory
    @NotNull
    public List<EditorOperation> getOperationsList(@NotNull Editable editable) {
        InsertOperation insertOperation;
        List<EditorOperation> list;
        Intrinsics.checkNotNullParameter(editable, "text");
        Object[] spans = editable.getSpans(0, editable.length(), a.class);
        Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(0, text.le…tingInterval::class.java)");
        a aVar = (a) ArraysKt___ArraysKt.firstOrNull(spans);
        if (aVar != null) {
            int spanStart = editable.getSpanStart(aVar);
            insertOperation = new InsertOperation(spanStart, editable.subSequence(spanStart, editable.getSpanEnd(aVar)).toString());
        } else {
            insertOperation = null;
        }
        DeleteOperation deleteOperation = this.a;
        if (deleteOperation == null || insertOperation == null) {
            ArrayList arrayList = new ArrayList();
            if (deleteOperation != null) {
                arrayList.add(deleteOperation);
            }
            if (insertOperation != null) {
                arrayList.add(insertOperation);
            }
            list = arrayList;
        } else {
            list = d.listOf(new ReplaceOperation(deleteOperation, d.listOf(insertOperation)));
        }
        clearCachedOperations(editable);
        return list;
    }

    @Override // com.avito.android.html_editor.InputOperationFactory
    public void onTextChanged(@NotNull Spannable spannable, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(spannable, "text");
        if (i3 != 0) {
            spannable.setSpan(new a(), i, i3 + i, 33);
        }
    }
}
