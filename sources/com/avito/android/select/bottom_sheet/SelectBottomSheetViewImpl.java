package com.avito.android.select.bottom_sheet;

import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.input.Input;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.select.R;
import com.avito.android.select.SelectVariantsView;
import com.avito.android.select.SelectVariantsViewImpl;
import com.avito.android.util.Contexts;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Logs;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010N\u001a\u00020-\u0012\u0006\u0010g\u001a\u00020f\u0012\f\u0010j\u001a\b\u0012\u0004\u0012\u00020i0h\u0012\b\u0010H\u001a\u0004\u0018\u000105¢\u0006\u0004\bk\u0010lJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u000bJ\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0005J\u0017\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001c\u0010\u0012J\u0010\u0010\u001d\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u001d\u0010\u0005J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u001f\u0010\u0012R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"RD\u0010)\u001a0\u0012\f\u0012\n %*\u0004\u0018\u00010\u00030\u0003 %*\u0017\u0012\f\u0012\n %*\u0004\u0018\u00010\u00030\u0003\u0018\u00010$¢\u0006\u0002\b&0$¢\u0006\u0002\b&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u00103R\"\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030;8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CRD\u0010F\u001a0\u0012\f\u0012\n %*\u0004\u0018\u00010\u000f0\u000f %*\u0017\u0012\f\u0012\n %*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010$¢\u0006\u0002\b&0$¢\u0006\u0002\b&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010(R\u0018\u0010H\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u00107R\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010/RD\u0010P\u001a0\u0012\f\u0012\n %*\u0004\u0018\u00010\b0\b %*\u0017\u0012\f\u0012\n %*\u0004\u0018\u00010\b0\b\u0018\u00010$¢\u0006\u0002\b&0$¢\u0006\u0002\b&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010(R\"\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00030;8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bQ\u0010=\u001a\u0004\bR\u0010?R\u0018\u0010U\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010\"R\"\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00030;8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bV\u0010=\u001a\u0004\bW\u0010?R\"\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00030;8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bY\u0010=\u001a\u0004\bZ\u0010?RD\u0010]\u001a0\u0012\f\u0012\n %*\u0004\u0018\u00010\u00030\u0003 %*\u0017\u0012\f\u0012\n %*\u0004\u0018\u00010\u00030\u0003\u0018\u00010$¢\u0006\u0002\b&0$¢\u0006\u0002\b&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010(R\"\u0010`\u001a\b\u0012\u0004\u0012\u00020\u000f0;8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b^\u0010=\u001a\u0004\b_\u0010?RD\u0010b\u001a0\u0012\f\u0012\n %*\u0004\u0018\u00010\u00030\u0003 %*\u0017\u0012\f\u0012\n %*\u0004\u0018\u00010\u00030\u0003\u0018\u00010$¢\u0006\u0002\b&0$¢\u0006\u0002\b&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010(R\"\u0010e\u001a\b\u0012\u0004\u0012\u00020\b0;8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bc\u0010=\u001a\u0004\bd\u0010?¨\u0006m"}, d2 = {"Lcom/avito/android/select/bottom_sheet/SelectBottomSheetViewImpl;", "Lcom/avito/android/select/bottom_sheet/SelectBottomSheetView;", "Lcom/avito/android/select/SelectVariantsView;", "", "fixViewHeight", "()V", "showSearchView", "hideSearchView", "", "title", "showSubmitButton", "(Ljava/lang/String;)V", "hideSubmitButton", "actionTitle", "showClearAction", "", "enabled", "setClearActionEnabled", "(Z)V", "hideClearAction", "setSubmitButtonEnabled", "text", "setSearchText", PlatformActions.HIDE_KEYBOARD, "setTitle", "requestSearchViewFocus", "clearSearchTextAndHideKeyboard", "isVisible", "setExitSearchButtonVisibility", "onDataChanged", "visible", "setEmptyViewVisible", "Lcom/avito/android/lib/design/input/Input;", "c", "Lcom/avito/android/lib/design/input/Input;", "searchView", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "i", "Lcom/jakewharton/rxrelay3/PublishRelay;", "clearSearchRelay", "n", "Z", "fixHeightNeeded", "Landroid/view/ViewGroup;", AuthSource.SEND_ABUSE, "Landroid/view/ViewGroup;", "container", "", "h", "I", "gray28Color", "Lcom/avito/android/lib/design/button/Button;", "e", "Lcom/avito/android/lib/design/button/Button;", "clearSearchButton", g.a, "blueColor", "Lio/reactivex/rxjava3/core/Observable;", "r", "Lio/reactivex/rxjava3/core/Observable;", "getMainButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "mainButtonClicks", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "clearActionButton", "j", "searchActiveRelay", VKApiConst.VERSION, "mainButton", "Landroid/text/TextWatcher;", AuthSource.BOOKING_ORDER, "Landroid/text/TextWatcher;", "valueChangedTextWatcher", "u", "rootView", "k", "searchTextRelay", "t", "getClearButtonClicks", "clearButtonClicks", "d", "searchInputView", "o", "getClearSearchEvents", "clearSearchEvents", "s", "getBackClickEvents", "backClickEvents", "l", "mainButtonRelay", "p", "getSearchActiveEvents", "searchActiveEvents", AuthSource.OPEN_CHANNEL_LIST, "clearClicksRelay", VKApiConst.Q, "getSearchTextChanges", "searchTextChanges", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "viewHolderBuilder", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;Lcom/avito/android/lib/design/button/Button;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectBottomSheetViewImpl implements SelectBottomSheetView, SelectVariantsView {
    public final ViewGroup a;
    public TextWatcher b;
    public Input c;
    public Input d;
    public Button e;
    public TextView f;
    public final int g;
    public final int h;
    public final PublishRelay<Unit> i;
    public final PublishRelay<Boolean> j;
    public final PublishRelay<String> k;
    public final PublishRelay<Unit> l;
    public final PublishRelay<Unit> m;
    public boolean n;
    @NotNull
    public final Observable<Unit> o;
    @NotNull
    public final Observable<Boolean> p;
    @NotNull
    public final Observable<String> q;
    @NotNull
    public final Observable<Unit> r;
    @NotNull
    public final Observable<Unit> s;
    @NotNull
    public final Observable<Unit> t;
    public final ViewGroup u;
    public final Button v;
    public final /* synthetic */ SelectVariantsViewImpl w;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SelectBottomSheetViewImpl a;

        public a(SelectBottomSheetViewImpl selectBottomSheetViewImpl) {
            this.a = selectBottomSheetViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.m.accept(Unit.INSTANCE);
        }
    }

    public static final class b implements View.OnFocusChangeListener {
        public final /* synthetic */ SelectBottomSheetViewImpl a;

        public b(SelectBottomSheetViewImpl selectBottomSheetViewImpl) {
            this.a = selectBottomSheetViewImpl;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            this.a.j.accept(Boolean.valueOf(z));
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ SelectBottomSheetViewImpl a;

        public c(SelectBottomSheetViewImpl selectBottomSheetViewImpl) {
            this.a = selectBottomSheetViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.i.accept(Unit.INSTANCE);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ SelectBottomSheetViewImpl a;

        public d(SelectBottomSheetViewImpl selectBottomSheetViewImpl, String str) {
            this.a = selectBottomSheetViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.l.accept(Unit.INSTANCE);
        }
    }

    public static final class e implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ SelectBottomSheetViewImpl a;
        public final /* synthetic */ RecyclerView b;
        public final /* synthetic */ Ref.IntRef c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;

        public e(SelectBottomSheetViewImpl selectBottomSheetViewImpl, RecyclerView recyclerView, Ref.IntRef intRef, int i, int i2, int i3, int i4) {
            this.a = selectBottomSheetViewImpl;
            this.b = recyclerView;
            this.c = intRef;
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            Ref.IntRef intRef;
            int i;
            try {
                Rect rect = new Rect();
                this.a.u.getWindowVisibleDisplayFrame(rect);
                Context context = this.a.u.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                Resources resources = context.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "rootView.context.resources");
                int i2 = resources.getDisplayMetrics().heightPixels - rect.bottom;
                if (i2 > 0) {
                    int paddingBottom = this.b.getPaddingBottom();
                    int i3 = this.c.element;
                    if (paddingBottom != i2 + i3) {
                        this.b.setPadding(this.d, this.e, this.f, i2 + i3);
                        return;
                    }
                    return;
                }
                if (i2 < 0 && (i = (intRef = this.c).element) == this.g) {
                    intRef.element = i + Math.abs(i2);
                }
                int paddingBottom2 = this.b.getPaddingBottom();
                int i4 = this.g;
                if (paddingBottom2 != i4) {
                    this.b.setPadding(this.d, this.e, this.f, i4);
                } else if (this.a.n) {
                    this.a.n = false;
                    this.a.u.getLayoutParams().height = this.a.u.getHeight();
                    this.a.u.requestLayout();
                }
            } catch (Exception e2) {
                Logs.error("Failed to fix view height in bottom sheet select", e2);
            }
        }
    }

    public SelectBottomSheetViewImpl(@NotNull ViewGroup viewGroup, @NotNull AdapterPresenter adapterPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, @Nullable Button button) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderBuilder");
        this.w = new SelectVariantsViewImpl(viewGroup, adapterPresenter, viewHolderBuilder);
        this.u = viewGroup;
        this.v = button;
        View findViewById = viewGroup.findViewById(R.id.select_sheet_content);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        this.a = (ViewGroup) findViewById;
        View findViewById2 = viewGroup.findViewById(com.avito.android.lib.design.R.id.bottom_sheet_action_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById2;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.g = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.blue);
        Context context2 = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "rootView.context");
        this.h = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.gray28);
        PublishRelay<Unit> create = PublishRelay.create();
        this.i = create;
        PublishRelay<Boolean> create2 = PublishRelay.create();
        this.j = create2;
        PublishRelay<String> create3 = PublishRelay.create();
        this.k = create3;
        PublishRelay<Unit> create4 = PublishRelay.create();
        this.l = create4;
        PublishRelay<Unit> create5 = PublishRelay.create();
        this.m = create5;
        Observable<Unit> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "clearSearchRelay.hide()");
        this.o = hide;
        Observable<Boolean> hide2 = create2.hide();
        Intrinsics.checkNotNullExpressionValue(hide2, "searchActiveRelay.hide()");
        this.p = hide2;
        Observable<String> hide3 = create3.hide();
        Intrinsics.checkNotNullExpressionValue(hide3, "searchTextRelay.hide()");
        this.q = hide3;
        Observable<Unit> hide4 = create4.hide();
        Intrinsics.checkNotNullExpressionValue(hide4, "mainButtonRelay.hide()");
        this.r = hide4;
        Observable<Unit> empty = Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
        this.s = empty;
        Observable<Unit> hide5 = create5.hide();
        Intrinsics.checkNotNullExpressionValue(hide5, "clearClicksRelay.hide()");
        this.t = hide5;
        View findViewById3 = viewGroup.findViewById(R.id.variant_list);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        int paddingTop = recyclerView.getPaddingTop();
        int paddingLeft = recyclerView.getPaddingLeft();
        int paddingRight = recyclerView.getPaddingRight();
        int paddingBottom = recyclerView.getPaddingBottom();
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = paddingBottom;
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new e(this, recyclerView, intRef, paddingLeft, paddingTop, paddingRight, paddingBottom));
    }

    @Override // com.avito.android.select.SelectDialogView
    public void clearSearchTextAndHideKeyboard() {
        Input input = this.d;
        if (input != null) {
            Input.setText$default(input, "", false, 2, null);
            Keyboards.hideKeyboard$default(input, false, 1, null);
            input.clearFocus();
        }
    }

    @Override // com.avito.android.select.bottom_sheet.HeightFixableView
    public void fixViewHeight() {
        this.n = true;
    }

    @Override // com.avito.android.select.SelectDialogView
    @NotNull
    public Observable<Unit> getBackClickEvents() {
        return this.s;
    }

    @Override // com.avito.android.select.SelectDialogView
    @NotNull
    public Observable<Unit> getClearButtonClicks() {
        return this.t;
    }

    @Override // com.avito.android.select.SelectDialogView
    @NotNull
    public Observable<Unit> getClearSearchEvents() {
        return this.o;
    }

    @Override // com.avito.android.select.SelectDialogView
    @NotNull
    public Observable<Unit> getMainButtonClicks() {
        return this.r;
    }

    @Override // com.avito.android.select.SelectDialogView
    @NotNull
    public Observable<Boolean> getSearchActiveEvents() {
        return this.p;
    }

    @Override // com.avito.android.select.SelectDialogView
    @NotNull
    public Observable<String> getSearchTextChanges() {
        return this.q;
    }

    @Override // com.avito.android.select.SelectDialogView
    public void hideClearAction() {
        Views.hide(this.f);
        this.f.setOnClickListener(null);
    }

    @Override // com.avito.android.select.SelectDialogView
    public void hideKeyboard() {
        Input input = this.c;
        if (input != null) {
            Keyboards.hideKeyboard$default(input, false, 1, null);
        }
    }

    @Override // com.avito.android.select.SelectDialogView
    public void hideSearchView() {
        Input input;
        Input input2 = this.c;
        if (input2 != null) {
            this.u.removeView(input2);
            TextWatcher textWatcher = this.b;
            if (!(textWatcher == null || (input = this.d) == null)) {
                input.removeTextChangedListener(textWatcher);
            }
            Button button = this.e;
            if (button != null) {
                button.setOnClickListener(null);
            }
            Input input3 = this.d;
            if (input3 != null) {
                input3.setFocusChangeListener(null);
            }
            this.c = null;
            this.d = null;
            this.e = null;
        }
    }

    @Override // com.avito.android.select.SelectDialogView
    public void hideSubmitButton() {
        Button button = this.v;
        if (button != null) {
            button.setOnClickListener(null);
            Views.setVisible(button, false);
        }
    }

    @Override // com.avito.android.select.SelectVariantsView
    public void onDataChanged() {
        this.w.onDataChanged();
    }

    @Override // com.avito.android.select.SelectDialogView
    public void requestSearchViewFocus() {
        Input input = this.c;
        if (input != null) {
            input.requestFocus();
        }
    }

    @Override // com.avito.android.select.SelectDialogView
    public void setClearActionEnabled(boolean z) {
        this.f.setClickable(z);
        if (z) {
            this.f.setTextColor(this.g);
        } else {
            this.f.setTextColor(this.h);
        }
    }

    @Override // com.avito.android.select.SelectVariantsView
    public void setEmptyViewVisible(boolean z) {
        this.w.setEmptyViewVisible(z);
    }

    @Override // com.avito.android.select.SelectDialogView
    public void setExitSearchButtonVisibility(boolean z) {
        Views.setVisible(this.e, z);
    }

    @Override // com.avito.android.select.SelectDialogView
    public void setSearchText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        Input input = this.c;
        if (input != null) {
            Input.setText$default(input, str, false, 2, null);
        }
    }

    @Override // com.avito.android.select.SelectDialogView
    public void setSubmitButtonEnabled(boolean z) {
        Button button = this.v;
        if (button != null) {
            button.setEnabled(z);
        }
    }

    @Override // com.avito.android.select.SelectDialogView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
    }

    @Override // com.avito.android.select.SelectDialogView
    public void showClearAction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "actionTitle");
        TextViews.bindText$default(this.f, str, false, 2, null);
        this.f.setOnClickListener(new a(this));
    }

    @Override // com.avito.android.select.SelectDialogView
    public void showSearchView() {
        View inflate = LayoutInflater.from(this.u.getContext()).inflate(R.layout.select_sheet_dialog_search_view, this.a, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "searchView");
        View findViewById = inflate.findViewById(R.id.select_dialog_search_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        Input input = (Input) findViewById;
        View findViewById2 = inflate.findViewById(R.id.clear_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById2;
        this.a.addView(inflate, 0);
        SelectBottomSheetViewImpl$showSearchView$$inlined$addDeformattedTextChangedListener$1 selectBottomSheetViewImpl$showSearchView$$inlined$addDeformattedTextChangedListener$1 = new TextWatcher(input, this) { // from class: com.avito.android.select.bottom_sheet.SelectBottomSheetViewImpl$showSearchView$$inlined$addDeformattedTextChangedListener$1
            public String a;
            public final /* synthetic */ Input b;
            public final /* synthetic */ SelectBottomSheetViewImpl c;

            {
                this.b = r1;
                this.c = r2;
                this.a = r1.getDeformattedText();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                String deformattedText = this.b.getDeformattedText();
                if (!Intrinsics.areEqual(deformattedText, this.a)) {
                    this.c.k.accept(deformattedText);
                    this.a = deformattedText;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i2, int i3, int i4) {
            }
        };
        input.addTextChangedListener(selectBottomSheetViewImpl$showSearchView$$inlined$addDeformattedTextChangedListener$1);
        this.b = selectBottomSheetViewImpl$showSearchView$$inlined$addDeformattedTextChangedListener$1;
        input.setFocusChangeListener(new b(this));
        button.setOnClickListener(new c(this));
        this.c = input;
        this.d = input;
        this.e = button;
    }

    @Override // com.avito.android.select.SelectDialogView
    public void showSubmitButton(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        Button button = this.v;
        if (button != null) {
            button.setText(str);
            Views.setVisible(button, true);
            button.setOnClickListener(new d(this, str));
        }
    }
}
