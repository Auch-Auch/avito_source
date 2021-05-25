package com.avito.android.publish.view.html_editor_toolbar;

import a2.g.r.g;
import android.view.View;
import androidx.annotation.DrawableRes;
import com.avito.android.html_editor.EditorNavigationEvent;
import com.avito.android.html_formatter.FormatChange;
import com.avito.android.html_formatter.InlineFormatChange;
import com.avito.android.html_formatter.ParagraphFormatChange;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.chips.Chipable;
import com.avito.android.lib.design.chips.Chips;
import com.avito.android.publish.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Views;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001;B\u000f\u0012\u0006\u00108\u001a\u000200¢\u0006\u0004\b9\u0010:J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0019\u001a\n \u0012*\u0004\u0018\u00010\u00160\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR:\u0010#\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010 0  \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010 0 \u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010)\u001a\b\u0012\u0004\u0012\u00020 0$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001e\u0010+\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0014R\"\u0010/\u001a\b\u0012\u0004\u0012\u00020,0$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b.\u0010(R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R:\u00105\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010,0, \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010,0,\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010\"R\u001e\u00107\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010\u0014¨\u0006<"}, d2 = {"Lcom/avito/android/publish/view/html_editor_toolbar/HtmlEditorToolbarImpl;", "Lcom/avito/android/publish/view/html_editor_toolbar/HtmlEditorToolbar;", "", "show", "()V", "hide", "", "isVisible", "()Z", "", "flags", "setEditorToolbarStateFlags", "(I)V", "undoEnabled", "redoEnabled", "setNavigationButtonsStates", "(ZZ)V", "Lcom/avito/android/lib/design/button/Button;", "kotlin.jvm.PlatformType", "c", "Lcom/avito/android/lib/design/button/Button;", "keyboardButton", "Lcom/avito/android/lib/design/chips/Chips;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/chips/Chips;", "chipsContainer", "", "Lcom/avito/android/publish/view/html_editor_toolbar/HtmlEditorToolbarImpl$TextFormat;", "h", "Ljava/util/List;", "styles", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/html_formatter/FormatChange;", "f", "Lcom/jakewharton/rxrelay2/PublishRelay;", "stateFlagsStream", "Lio/reactivex/Observable;", "i", "Lio/reactivex/Observable;", "getEditorToolbarStateFlagsObservable", "()Lio/reactivex/Observable;", "editorToolbarStateFlagsObservable", "e", "redoButton", "Lcom/avito/android/html_editor/EditorNavigationEvent;", "j", "getEditorToolbarNavigationEventObservable", "editorToolbarNavigationEventObservable", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "root", g.a, "navigationStream", "d", "undoButton", "view", "<init>", "(Landroid/view/View;)V", "TextFormat", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class HtmlEditorToolbarImpl implements HtmlEditorToolbar {
    public final View a;
    public final Chips b;
    public final Button c;
    public final Button d;
    public final Button e;
    public final PublishRelay<FormatChange> f;
    public final PublishRelay<EditorNavigationEvent> g;
    public final List<TextFormat> h;
    @NotNull
    public final Observable<FormatChange> i;
    @NotNull
    public final Observable<EditorNavigationEvent> j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u001b\b\u0002\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\u00020\u00128\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/publish/view/html_editor_toolbar/HtmlEditorToolbarImpl$TextFormat;", "", "Lcom/avito/android/lib/design/chips/Chipable;", "", "getImageRes", "()Ljava/lang/Integer;", "", "other", "", "equalsAsChipable", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "iconResource", AuthSource.BOOKING_ORDER, "getFlag", "()I", "flag", "", "chipTitle", "Ljava/lang/String;", "getChipTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;III)V", "BOLD", "ITALIC", "LIST", "NUMERIC_LIST", "publish_release"}, k = 1, mv = {1, 4, 2})
    public enum TextFormat implements Chipable {
        BOLD(R.drawable.ic_bold_24, 1),
        ITALIC(R.drawable.ic_italic_24, 2),
        LIST(R.drawable.ic_list_bulleted_24, 4),
        NUMERIC_LIST(R.drawable.ic_list_numeric_24, 8);
        
        public final int a;
        public final int b;

        /* access modifiers changed from: public */
        TextFormat(@DrawableRes int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // com.avito.android.lib.design.chips.Chipable
        public boolean equalsAsChipable(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "other");
            if ((obj instanceof TextFormat) && this.b == ((TextFormat) obj).b) {
                return true;
            }
            return false;
        }

        @Override // com.avito.android.lib.design.chips.Chipable
        @NotNull
        public String getChipTitle() {
            return "";
        }

        public final int getFlag() {
            return this.b;
        }

        @Override // com.avito.android.lib.design.chips.Chipable
        @Nullable
        public Integer getImageRes() {
            return Integer.valueOf(this.a);
        }

        @Override // com.avito.android.lib.design.chips.Chipable
        @DrawableRes
        @Nullable
        public Integer getLeftImageRes() {
            return Chipable.DefaultImpls.getLeftImageRes(this);
        }

        @Override // com.avito.android.lib.design.chips.Chipable
        @DrawableRes
        @Nullable
        public Integer getRightImageRes() {
            return Chipable.DefaultImpls.getRightImageRes(this);
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                Keyboards.hideKeyboard$default((View) this.b, false, 1, null);
            } else if (i == 1) {
                ((HtmlEditorToolbarImpl) this.b).g.accept(EditorNavigationEvent.UNDO);
            } else if (i == 2) {
                ((HtmlEditorToolbarImpl) this.b).g.accept(EditorNavigationEvent.REDO);
            } else {
                throw null;
            }
        }
    }

    public HtmlEditorToolbarImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = view;
        Chips chips = (Chips) view.findViewById(R.id.style_chips);
        this.b = chips;
        Button button = (Button) view.findViewById(R.id.keyboard);
        this.c = button;
        Button button2 = (Button) view.findViewById(R.id.undo);
        this.d = button2;
        Button button3 = (Button) view.findViewById(R.id.redo);
        this.e = button3;
        PublishRelay<FormatChange> create = PublishRelay.create();
        this.f = create;
        PublishRelay<EditorNavigationEvent> create2 = PublishRelay.create();
        this.g = create2;
        List<TextFormat> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new TextFormat[]{TextFormat.BOLD, TextFormat.ITALIC, TextFormat.LIST, TextFormat.NUMERIC_LIST});
        this.h = listOf;
        chips.setData(listOf);
        chips.setChipsSelectedListener(new Chips.ChipSelectedListener(this) { // from class: com.avito.android.publish.view.html_editor_toolbar.HtmlEditorToolbarImpl.1
            public final /* synthetic */ HtmlEditorToolbarImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.lib.design.chips.Chips.ChipSelectedListener
            public void onChipSelected(@NotNull Chipable chipable) {
                Intrinsics.checkNotNullParameter(chipable, "item");
                this.a.f.accept(HtmlEditorToolbarImpl.access$createFormatChange(this.a, (TextFormat) chipable, true));
            }

            @Override // com.avito.android.lib.design.chips.Chips.ChipSelectedListener
            public void onChipUnSelected(@NotNull Chipable chipable) {
                Intrinsics.checkNotNullParameter(chipable, "item");
                this.a.f.accept(HtmlEditorToolbarImpl.access$createFormatChange(this.a, (TextFormat) chipable, false));
            }
        });
        button.setOnClickListener(new a(0, view));
        button2.setOnClickListener(new a(1, this));
        button3.setOnClickListener(new a(2, this));
        Intrinsics.checkNotNullExpressionValue(create, "stateFlagsStream");
        this.i = create;
        Intrinsics.checkNotNullExpressionValue(create2, "navigationStream");
        this.j = create2;
    }

    public static final FormatChange access$createFormatChange(HtmlEditorToolbarImpl htmlEditorToolbarImpl, TextFormat textFormat, boolean z) {
        Objects.requireNonNull(htmlEditorToolbarImpl);
        int flag = textFormat.getFlag();
        if (flag == 1 || flag == 2) {
            return new InlineFormatChange(textFormat.getFlag(), z ? FormatChange.Type.ADD : FormatChange.Type.REMOVE);
        } else if (flag != 4 && flag != 8) {
            return null;
        } else {
            return new ParagraphFormatChange(textFormat.getFlag(), z ? FormatChange.Type.ADD : FormatChange.Type.REMOVE);
        }
    }

    @Override // com.avito.android.publish.view.html_editor_toolbar.HtmlEditorToolbar
    @NotNull
    public Observable<EditorNavigationEvent> getEditorToolbarNavigationEventObservable() {
        return this.j;
    }

    @Override // com.avito.android.publish.view.html_editor_toolbar.HtmlEditorToolbar
    @NotNull
    public Observable<FormatChange> getEditorToolbarStateFlagsObservable() {
        return this.i;
    }

    @Override // com.avito.android.publish.view.html_editor_toolbar.HtmlEditorToolbar
    public void hide() {
        Views.hide(this.a);
    }

    @Override // com.avito.android.publish.view.html_editor_toolbar.HtmlEditorToolbar
    public boolean isVisible() {
        return Views.isVisible(this.a);
    }

    @Override // com.avito.android.publish.view.html_editor_toolbar.HtmlEditorToolbar
    public void setEditorToolbarStateFlags(int i2) {
        ArrayList arrayList = new ArrayList();
        for (T t : this.h) {
            if ((t.getFlag() & i2) == t.getFlag()) {
                arrayList.add(t);
            }
        }
        if (!Intrinsics.areEqual(this.b.selected(), arrayList)) {
            this.b.clearSelected();
            this.b.select(arrayList);
        }
    }

    @Override // com.avito.android.publish.view.html_editor_toolbar.HtmlEditorToolbar
    public void setNavigationButtonsStates(boolean z, boolean z2) {
        Button button = this.d;
        Intrinsics.checkNotNullExpressionValue(button, "undoButton");
        button.setEnabled(z);
        Button button2 = this.e;
        Intrinsics.checkNotNullExpressionValue(button2, "redoButton");
        button2.setEnabled(z2);
    }

    @Override // com.avito.android.publish.view.html_editor_toolbar.HtmlEditorToolbar
    public void show() {
        Views.show(this.a);
    }
}
