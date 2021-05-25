package com.avito.android.select;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.deprecated_design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.Keyboards;
import com.avito.android.util.SimpleTextWatcher;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010S\u001a\u00020R\u0012\f\u0010V\u001a\b\u0012\u0004\u0012\u00020U0T\u0012\u0006\u0010W\u001a\u00020\u000e¢\u0006\u0004\bX\u0010YJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\nJ\u000f\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0005J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\nJ\u000f\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u0005J\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u0011J\u0010\u0010\u001c\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u001c\u0010\u0005J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u001e\u0010\u0011RD\u0010$\u001a0\u0012\f\u0012\n  *\u0004\u0018\u00010\u00030\u0003  *\u0017\u0012\f\u0012\n  *\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u001f¢\u0006\u0002\b!0\u001f¢\u0006\u0002\b!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-RD\u00100\u001a0\u0012\f\u0012\n  *\u0004\u0018\u00010\u00070\u0007  *\u0017\u0012\f\u0012\n  *\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u001f¢\u0006\u0002\b!0\u001f¢\u0006\u0002\b!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010#R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107RD\u0010:\u001a0\u0012\f\u0012\n  *\u0004\u0018\u00010\u000e0\u000e  *\u0017\u0012\f\u0012\n  *\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u001f¢\u0006\u0002\b!0\u001f¢\u0006\u0002\b!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010#RD\u0010<\u001a0\u0012\f\u0012\n  *\u0004\u0018\u00010\u00030\u0003  *\u0017\u0012\f\u0012\n  *\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u001f¢\u0006\u0002\b!0\u001f¢\u0006\u0002\b!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010#R\"\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000e0%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u0010'\u001a\u0004\b>\u0010)R\"\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b@\u0010'\u001a\u0004\bA\u0010)R\"\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00030%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bC\u0010'\u001a\u0004\bD\u0010)R\"\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bF\u0010'\u001a\u0004\bG\u0010)R\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KRD\u0010N\u001a0\u0012\f\u0012\n  *\u0004\u0018\u00010\u00030\u0003  *\u0017\u0012\f\u0012\n  *\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u001f¢\u0006\u0002\b!0\u001f¢\u0006\u0002\b!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010#R\"\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00030%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bO\u0010'\u001a\u0004\bP\u0010)¨\u0006Z"}, d2 = {"Lcom/avito/android/select/SelectDialogViewImpl;", "Lcom/avito/android/select/SelectDialogView;", "Lcom/avito/android/select/SelectVariantsView;", "", "showSearchView", "()V", "hideSearchView", "", "title", "showSubmitButton", "(Ljava/lang/String;)V", "hideSubmitButton", "actionTitle", "showClearAction", "", "enabled", "setClearActionEnabled", "(Z)V", "hideClearAction", "setSubmitButtonEnabled", "text", "setSearchText", PlatformActions.HIDE_KEYBOARD, "setTitle", "requestSearchViewFocus", "clearSearchTextAndHideKeyboard", "isVisible", "setExitSearchButtonVisibility", "onDataChanged", "visible", "setEmptyViewVisible", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "e", "Lcom/jakewharton/rxrelay3/PublishRelay;", "backClicksRelay", "Lio/reactivex/rxjava3/core/Observable;", "h", "Lio/reactivex/rxjava3/core/Observable;", "getSearchTextChanges", "()Lio/reactivex/rxjava3/core/Observable;", "searchTextChanges", "Landroid/widget/ImageButton;", "l", "Landroid/widget/ImageButton;", "clearButton", "c", "searchTextRelay", "Landroid/widget/EditText;", "n", "Landroid/widget/EditText;", "searchView", "Landroid/view/ViewGroup;", "o", "Landroid/view/ViewGroup;", "rootView", AuthSource.BOOKING_ORDER, "searchActiveRelay", "d", "mainButtonRelay", g.a, "getSearchActiveEvents", "searchActiveEvents", "i", "getMainButtonClicks", "mainButtonClicks", "f", "getClearSearchEvents", "clearSearchEvents", "k", "getClearButtonClicks", "clearButtonClicks", "Landroidx/appcompat/widget/Toolbar;", AuthSource.OPEN_CHANNEL_LIST, "Landroidx/appcompat/widget/Toolbar;", "toolbar", AuthSource.SEND_ABUSE, "clearSearchRelay", "j", "getBackClickEvents", "backClickEvents", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "viewHolderBuilder", "isRedesign", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;Z)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectDialogViewImpl implements SelectDialogView, SelectVariantsView {
    public final PublishRelay<Unit> a;
    public final PublishRelay<Boolean> b;
    public final PublishRelay<String> c;
    public final PublishRelay<Unit> d;
    public final PublishRelay<Unit> e;
    @NotNull
    public final Observable<Unit> f;
    @NotNull
    public final Observable<Boolean> g;
    @NotNull
    public final Observable<String> h;
    @NotNull
    public final Observable<Unit> i;
    @NotNull
    public final Observable<Unit> j;
    @NotNull
    public final Observable<Unit> k;
    public ImageButton l;
    public final Toolbar m;
    public EditText n;
    public final ViewGroup o;
    public final /* synthetic */ SelectVariantsViewImpl p;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SelectDialogViewImpl a;

        public a(SelectDialogViewImpl selectDialogViewImpl) {
            this.a = selectDialogViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.e.accept(Unit.INSTANCE);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SelectDialogViewImpl a;

        public b(SelectDialogViewImpl selectDialogViewImpl) {
            this.a = selectDialogViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.a.accept(Unit.INSTANCE);
        }
    }

    public static final class c implements MenuItem.OnMenuItemClickListener {
        public final /* synthetic */ SelectDialogViewImpl a;

        public c(SelectDialogViewImpl selectDialogViewImpl) {
            this.a = selectDialogViewImpl;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.a.d.accept(Unit.INSTANCE);
            return true;
        }
    }

    public SelectDialogViewImpl(@NotNull ViewGroup viewGroup, @NotNull AdapterPresenter adapterPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, boolean z) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderBuilder");
        this.p = new SelectVariantsViewImpl(viewGroup, adapterPresenter, viewHolderBuilder);
        this.o = viewGroup;
        PublishRelay<Unit> create = PublishRelay.create();
        this.a = create;
        PublishRelay<Boolean> create2 = PublishRelay.create();
        this.b = create2;
        PublishRelay<String> create3 = PublishRelay.create();
        this.c = create3;
        PublishRelay<Unit> create4 = PublishRelay.create();
        this.d = create4;
        PublishRelay<Unit> create5 = PublishRelay.create();
        this.e = create5;
        PublishRelay.create();
        Observable<Unit> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "clearSearchRelay.hide()");
        this.f = hide;
        Observable<Boolean> hide2 = create2.hide();
        Intrinsics.checkNotNullExpressionValue(hide2, "searchActiveRelay.hide()");
        this.g = hide2;
        Observable<String> hide3 = create3.hide();
        Intrinsics.checkNotNullExpressionValue(hide3, "searchTextRelay.hide()");
        this.h = hide3;
        Observable<Unit> hide4 = create4.hide();
        Intrinsics.checkNotNullExpressionValue(hide4, "mainButtonRelay.hide()");
        this.i = hide4;
        Observable<Unit> hide5 = create5.hide();
        Intrinsics.checkNotNullExpressionValue(hide5, "backClicksRelay.hide()");
        this.j = hide5;
        Observable<Unit> empty = Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
        this.k = empty;
        View findViewById = viewGroup.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.m = toolbar;
        toolbar.setNavigationOnClickListener(new a(this));
        if (z) {
            Toolbars.setBackIconByAttr(toolbar, com.avito.android.lib.design.R.attr.black);
            return;
        }
        Drawable drawable2 = toolbar.getContext().getDrawable(com.avito.android.ui_components.R.drawable.ic_close_24);
        if (drawable2 != null) {
            Context context = toolbar.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "toolbar.context");
            drawable = DrawablesKt.wrapForTinting(drawable2, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.blue));
        } else {
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    @Override // com.avito.android.select.SelectDialogView
    public void clearSearchTextAndHideKeyboard() {
        EditText editText = this.n;
        if (editText != null) {
            editText.setText("");
        }
        EditText editText2 = this.n;
        if (editText2 != null) {
            Keyboards.hideKeyboard$default(editText2, false, 1, null);
        }
    }

    @Override // com.avito.android.select.SelectDialogView
    @NotNull
    public Observable<Unit> getBackClickEvents() {
        return this.j;
    }

    @Override // com.avito.android.select.SelectDialogView
    @NotNull
    public Observable<Unit> getClearButtonClicks() {
        return this.k;
    }

    @Override // com.avito.android.select.SelectDialogView
    @NotNull
    public Observable<Unit> getClearSearchEvents() {
        return this.f;
    }

    @Override // com.avito.android.select.SelectDialogView
    @NotNull
    public Observable<Unit> getMainButtonClicks() {
        return this.i;
    }

    @Override // com.avito.android.select.SelectDialogView
    @NotNull
    public Observable<Boolean> getSearchActiveEvents() {
        return this.g;
    }

    @Override // com.avito.android.select.SelectDialogView
    @NotNull
    public Observable<String> getSearchTextChanges() {
        return this.h;
    }

    @Override // com.avito.android.select.SelectDialogView
    public void hideClearAction() {
    }

    @Override // com.avito.android.select.SelectDialogView
    public void hideKeyboard() {
        EditText editText = this.n;
        if (editText != null) {
            Keyboards.hideKeyboard$default(editText, false, 1, null);
        }
    }

    @Override // com.avito.android.select.SelectDialogView
    public void hideSearchView() {
        EditText editText = this.n;
        if (editText != null) {
            this.m.removeView(editText);
            this.n = null;
        }
    }

    @Override // com.avito.android.select.SelectDialogView
    public void hideSubmitButton() {
        Menu menu = this.m.getMenu();
        int i2 = R.id.menu_submit;
        MenuItem findItem = menu.findItem(i2);
        if (findItem != null) {
            findItem.setOnMenuItemClickListener(null);
            this.m.getMenu().removeItem(i2);
        }
    }

    @Override // com.avito.android.select.SelectVariantsView
    public void onDataChanged() {
        this.p.onDataChanged();
    }

    @Override // com.avito.android.select.SelectDialogView
    public void requestSearchViewFocus() {
        EditText editText = this.n;
        if (editText != null) {
            editText.requestFocus();
        }
    }

    @Override // com.avito.android.select.SelectDialogView
    public void setClearActionEnabled(boolean z) {
    }

    @Override // com.avito.android.select.SelectVariantsView
    public void setEmptyViewVisible(boolean z) {
        this.p.setEmptyViewVisible(z);
    }

    @Override // com.avito.android.select.SelectDialogView
    public void setExitSearchButtonVisibility(boolean z) {
        Views.setVisible(this.l, z);
    }

    @Override // com.avito.android.select.SelectDialogView
    public void setSearchText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        EditText editText = this.n;
        if (editText != null) {
            editText.setText(str);
        }
    }

    @Override // com.avito.android.select.SelectDialogView
    public void setSubmitButtonEnabled(boolean z) {
        MenuItem findItem = this.m.getMenu().findItem(R.id.menu_submit);
        if (findItem != null) {
            findItem.setEnabled(z);
        }
    }

    @Override // com.avito.android.select.SelectDialogView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        EditText editText = this.n;
        if (editText == null) {
            this.m.setTitle(str);
        } else if (editText != null) {
            editText.setHint(str);
        }
    }

    @Override // com.avito.android.select.SelectDialogView
    public void showClearAction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "actionTitle");
    }

    @Override // com.avito.android.select.SelectDialogView
    public void showSearchView() {
        View inflate = LayoutInflater.from(this.o.getContext()).inflate(R.layout.select_dialog_search_view, (ViewGroup) this.m, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "toolBarSearchView");
        View findViewById = inflate.findViewById(R.id.select_dialog_search_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.EditText");
        EditText editText = (EditText) findViewById;
        View findViewById2 = inflate.findViewById(R.id.select_dialog_search_view_clear);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageButton");
        this.l = (ImageButton) findViewById2;
        editText.addTextChangedListener(new SimpleTextWatcher(this) { // from class: com.avito.android.select.SelectDialogViewImpl$showSearchView$1
            public final /* synthetic */ SelectDialogViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable editable) {
                Intrinsics.checkNotNullParameter(editable, "s");
                this.a.c.accept(editable.toString());
                this.a.b.accept(Boolean.valueOf(editable.length() > 0));
            }
        });
        ImageButton imageButton = this.l;
        if (imageButton != null) {
            imageButton.setOnClickListener(new b(this));
        }
        this.n = editText;
    }

    @Override // com.avito.android.select.SelectDialogView
    public void showSubmitButton(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        MenuItem add = this.m.getMenu().add(0, R.id.menu_submit, 0, str);
        add.setShowAsAction(2);
        add.setOnMenuItemClickListener(new c(this));
    }
}
