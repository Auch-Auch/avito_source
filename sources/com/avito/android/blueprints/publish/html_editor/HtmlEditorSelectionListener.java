package com.avito.android.blueprints.publish.html_editor;

import android.text.SpannableString;
import android.text.Spanned;
import com.avito.android.html_editor.HtmlInteractor;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorSelectionListener;", "", "", "text", "", "selStart", "selEnd", "", "onSelectionChanged", "(Ljava/lang/CharSequence;II)V", AuthSource.BOOKING_ORDER, "I", "oldSelectEnd", AuthSource.SEND_ABUSE, "oldSelectStart", "Lcom/avito/android/html_editor/HtmlInteractor;", "c", "Lcom/avito/android/html_editor/HtmlInteractor;", "htmlInteractor", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "d", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "htmlEditorViewModel", "initialFrom", "initialTo", "<init>", "(IILcom/avito/android/html_editor/HtmlInteractor;Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class HtmlEditorSelectionListener {
    public int a;
    public int b;
    public final HtmlInteractor c;
    public final HtmlEditorViewModel d;

    public HtmlEditorSelectionListener(int i, int i2, @NotNull HtmlInteractor htmlInteractor, @NotNull HtmlEditorViewModel htmlEditorViewModel) {
        Intrinsics.checkNotNullParameter(htmlInteractor, "htmlInteractor");
        Intrinsics.checkNotNullParameter(htmlEditorViewModel, "htmlEditorViewModel");
        this.c = htmlInteractor;
        this.d = htmlEditorViewModel;
        this.a = i;
        this.b = i2;
    }

    public final void onSelectionChanged(@Nullable CharSequence charSequence, int i, int i2) {
        if (!(i == this.a && i2 == this.b)) {
            this.c.removePendingOperations();
        }
        HtmlEditorViewModel htmlEditorViewModel = this.d;
        HtmlInteractor htmlInteractor = this.c;
        if (!(charSequence instanceof Spanned)) {
            charSequence = null;
        }
        Spanned spanned = (Spanned) charSequence;
        if (spanned == null) {
            spanned = new SpannableString("");
        }
        htmlEditorViewModel.setFormat(htmlInteractor.getFormat(spanned, i, i2));
        this.a = i;
        this.b = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HtmlEditorSelectionListener(int i, int i2, HtmlInteractor htmlInteractor, HtmlEditorViewModel htmlEditorViewModel, int i3, j jVar) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, htmlInteractor, htmlEditorViewModel);
    }
}
