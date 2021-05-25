package com.avito.android.advert.notes;

import a2.a.a.f.y.l;
import a2.a.a.f.y.m;
import a2.g.r.g;
import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.deprecated_design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.Keyboards;
import com.avito.android.util.SimpleTextWatcher;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.model.VKAttachments;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00100\u001a\u00020#\u0012\u0006\u00101\u001a\u00020\u0005¢\u0006\u0004\b2\u00103J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001e\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010&\u001a\n \u001b*\u0004\u0018\u00010#0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010*\u001a\b\u0012\u0004\u0012\u00020'0\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018R\u001e\u0010.\u001a\n \u001b*\u0004\u0018\u00010+0+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010%¨\u00064"}, d2 = {"Lcom/avito/android/advert/notes/EditAdvertNoteViewImpl;", "Lcom/avito/android/advert/notes/EditAdvertNoteView;", "", "startLoad", "()V", "", VKAttachments.TYPE_NOTE, "showData", "(Ljava/lang/String;)V", "showError", "showKeyboard", PlatformActions.HIDE_KEYBOARD, "", "isEnabled", "setMenuItemEnabled", "(Z)V", "", "text", "showToast", "(I)V", "Lcom/jakewharton/rxrelay3/PublishRelay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay3/PublishRelay;", "getTextChanged", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "textChanged", "Landroidx/appcompat/widget/Toolbar;", "kotlin.jvm.PlatformType", "c", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/view/MenuItem;", "f", "Landroid/view/MenuItem;", "saveNoteMenuItem", "Landroid/view/View;", "e", "Landroid/view/View;", "progressBarContainer", "Lcom/avito/android/advert/notes/EditAdvertNoteScreenNavigation;", AuthSource.SEND_ABUSE, "getNavigationClick", "navigationClick", "Landroid/widget/EditText;", "d", "Landroid/widget/EditText;", "editText", g.a, "view", "title", "<init>", "(Landroid/view/View;Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class EditAdvertNoteViewImpl implements EditAdvertNoteView {
    @NotNull
    public final PublishRelay<EditAdvertNoteScreenNavigation> a;
    @NotNull
    public final PublishRelay<String> b;
    public final Toolbar c;
    public final EditText d;
    public final View e;
    public MenuItem f;
    public final View g;

    public EditAdvertNoteViewImpl(@NotNull View view, @NotNull String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(str, "title");
        this.g = view;
        PublishRelay<EditAdvertNoteScreenNavigation> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        PublishRelay<String> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.b = create2;
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        this.c = toolbar;
        EditText editText = (EditText) view.findViewById(com.avito.android.advert_details.R.id.edit_text);
        this.d = editText;
        this.e = view.findViewById(com.avito.android.advert_details.R.id.progress_bar_container);
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        toolbar.setTitle(str);
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24_blue);
        toolbar.setNavigationOnClickListener(new l(this));
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        if (!toolbar.getMenu().hasVisibleItems()) {
            toolbar.inflateMenu(com.avito.android.advert_details.R.menu.advert_create_note);
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            Toolbars.tintMenuByAttr(toolbar, com.avito.android.lib.design.R.attr.blue);
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            MenuItem findItem = toolbar.getMenu().findItem(com.avito.android.advert_details.R.id.menu_save_note);
            Intrinsics.checkNotNullExpressionValue(findItem, "toolbar.menu.findItem(R.id.menu_save_note)");
            this.f = findItem;
            if (findItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("saveNoteMenuItem");
            }
            findItem.setOnMenuItemClickListener(new m(this));
        }
        editText.addTextChangedListener(new SimpleTextWatcher(this) { // from class: com.avito.android.advert.notes.EditAdvertNoteViewImpl.1
            public final /* synthetic */ EditAdvertNoteViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(charSequence, "s");
                this.a.getTextChanged().accept(charSequence.toString());
            }
        });
    }

    @Override // com.avito.android.advert.notes.EditAdvertNoteView
    public void hideKeyboard() {
        EditText editText = this.d;
        Intrinsics.checkNotNullExpressionValue(editText, "editText");
        Keyboards.hideKeyboard$default(editText, false, 1, null);
    }

    @Override // com.avito.android.advert.notes.EditAdvertNoteView
    public void setMenuItemEnabled(boolean z) {
        MenuItem menuItem = this.f;
        if (menuItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveNoteMenuItem");
        }
        if (menuItem.isEnabled() != z) {
            MenuItem menuItem2 = this.f;
            if (menuItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("saveNoteMenuItem");
            }
            menuItem2.setEnabled(z);
        }
    }

    @Override // com.avito.android.advert.notes.EditAdvertNoteView
    public void showData(@Nullable String str) {
        EditText editText = this.d;
        editText.setEnabled(true);
        editText.setText(str);
        editText.setSelection(str != null ? str.length() : 0);
    }

    @Override // com.avito.android.advert.notes.EditAdvertNoteView
    public void showError() {
        Views.conceal(this.e);
        Views.showSnackBar$default(this.g, com.avito.android.advert_details.R.string.save_note_error_was_occurred, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
        MenuItem menuItem = this.f;
        if (menuItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveNoteMenuItem");
        }
        menuItem.setEnabled(true);
        EditText editText = this.d;
        Intrinsics.checkNotNullExpressionValue(editText, "editText");
        editText.setEnabled(true);
    }

    @Override // com.avito.android.advert.notes.EditAdvertNoteView
    public void showKeyboard() {
        EditText editText = this.d;
        Intrinsics.checkNotNullExpressionValue(editText, "editText");
        Keyboards.showKeyboardDelayed$default(editText, 0, 1, null);
    }

    @Override // com.avito.android.advert.notes.EditAdvertNoteView
    public void showToast(int i) {
        Context context = this.g.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        ToastsKt.showToast(context, i, 0);
    }

    @Override // com.avito.android.advert.notes.EditAdvertNoteView
    public void startLoad() {
        Views.show(this.e);
        MenuItem menuItem = this.f;
        if (menuItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveNoteMenuItem");
        }
        menuItem.setEnabled(false);
        EditText editText = this.d;
        Intrinsics.checkNotNullExpressionValue(editText, "editText");
        editText.setEnabled(false);
    }

    @Override // com.avito.android.advert.notes.EditAdvertNoteView
    @NotNull
    public PublishRelay<EditAdvertNoteScreenNavigation> getNavigationClick() {
        return this.a;
    }

    @Override // com.avito.android.advert.notes.EditAdvertNoteView
    @NotNull
    public PublishRelay<String> getTextChanged() {
        return this.b;
    }
}
