package com.avito.android.booking.info;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.booking.remote.model.BookingInfoActionStyle;
import com.avito.android.deprecated_design.R;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.button.Button;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.facebook.internal.AnalyticsEvents;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010O\u001a\u00020L¢\u0006\u0004\bX\u0010YJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\tJ-\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0017\u0010\tJ\u0010\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0003H\u0001¢\u0006\u0004\b\u001c\u0010\u0006J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0001¢\u0006\u0004\b\u001d\u0010\u0006J.\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001b2\b\b\u0001\u0010\u001f\u001a\u00020\u001b2\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u001bH\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010(\u001a\u00020\u00042\b\b\u0001\u0010'\u001a\u00020\u001bH\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010+\u001a\u00020\u00042\b\b\u0001\u0010*\u001a\u00020\u001bH\u0001¢\u0006\u0004\b+\u0010)J\u001a\u0010-\u001a\u00020\u00042\b\b\u0001\u0010,\u001a\u00020\u001bH\u0001¢\u0006\u0004\b-\u0010)J&\u00100\u001a\u00020\u00042\b\b\u0001\u0010.\u001a\u00020\u001b2\n\b\u0003\u0010/\u001a\u0004\u0018\u00010\u001bH\u0001¢\u0006\u0004\b0\u00101J\u0018\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0018H\u0001¢\u0006\u0004\b3\u00104J\u0018\u00106\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u000205H\u0001¢\u0006\u0004\b6\u00107J\u001a\u00106\u001a\u00020\u00042\b\b\u0001\u00108\u001a\u00020\u001bH\u0001¢\u0006\u0004\b6\u0010)J\u0018\u00109\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0018H\u0001¢\u0006\u0004\b9\u00104J\u001e\u0010=\u001a\u00020\u00042\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:H\u0001¢\u0006\u0004\b=\u0010>J\u0010\u0010?\u001a\u00020\u0004H\u0001¢\u0006\u0004\b?\u0010\tR\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006Z"}, d2 = {"Lcom/avito/android/booking/info/BookingInfoViewImpl;", "Lcom/avito/android/booking/info/BookingInfoView;", "Lru/avito/component/appbar/AppBar;", "Lio/reactivex/rxjava3/core/Observable;", "", "backClicks", "()Lio/reactivex/rxjava3/core/Observable;", "retryClicks", "showLoading", "()V", "showContent", "", "error", "showError", "(Ljava/lang/String;)V", "notifyDataChanged", "title", "Lcom/avito/android/booking/remote/model/BookingInfoActionStyle;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lkotlin/Function0;", "onClick", "showActionButton", "(Ljava/lang/String;Lcom/avito/android/booking/remote/model/BookingInfoActionStyle;Lkotlin/jvm/functions/Function0;)V", "hideActionsMenu", "", "isVisible", "()Z", "", "menuCallbacks", "navigationCallbacks", "itemPosition", "icon", "tintColorAttr", "setActionMenuItemIcon", "(IILjava/lang/Integer;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setIcon", "(Lcom/avito/android/image_loader/Picture;)V", "menuId", "setMenu", "(I)V", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "drawableRes", "tintColorAttrId", "setNavigationIcon", "(ILjava/lang/Integer;)V", "visible", "setShadowVisible", "(Z)V", "", "setTitle", "(Ljava/lang/CharSequence;)V", "stringRes", "setVisible", "", "Lcom/avito/android/util/ActionMenu;", "actions", "showActionsMenu", "(Ljava/util/List;)V", "showToolbar", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "d", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/view/View;", "e", "Landroid/view/View;", "rootView", "Lcom/avito/android/lib/design/button/Button;", "c", "Lcom/avito/android/lib/design/button/Button;", "actionButton", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "f", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingInfoViewImpl implements BookingInfoView, AppBar {
    public final Toolbar a;
    public final RecyclerView b;
    public final Button c;
    public ProgressOverlay d;
    public final View e;
    public final SimpleRecyclerAdapter f;
    public final /* synthetic */ AppBarImpl g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            BookingInfoActionStyle.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public static final class a<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ BookingInfoViewImpl a;

        /* renamed from: com.avito.android.booking.info.BookingInfoViewImpl$a$a  reason: collision with other inner class name */
        public static final class View$OnClickListenerC0134a implements View.OnClickListener {
            public final /* synthetic */ ObservableEmitter a;

            public View$OnClickListenerC0134a(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onNext(Unit.INSTANCE);
            }
        }

        public a(BookingInfoViewImpl bookingInfoViewImpl) {
            this.a = bookingInfoViewImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
            this.a.a.setNavigationOnClickListener(new View$OnClickListenerC0134a(observableEmitter));
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public BookingInfoViewImpl(@NotNull View view, @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        this.g = new AppBarImpl(view, null, false, 4, null);
        this.e = view;
        this.f = simpleRecyclerAdapter;
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.a = toolbar;
        int i = com.avito.android.booking.R.id.recycler;
        View findViewById2 = view.findViewById(i);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.b = recyclerView;
        View findViewById3 = view.findViewById(com.avito.android.booking.R.id.floating_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.c = (Button) findViewById3;
        View findViewById4 = view.findViewById(com.avito.android.booking.R.id.content_container);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.ViewGroup");
        this.d = new ProgressOverlay((ViewGroup) findViewById4, i, null, false, 0, 28, null);
        simpleRecyclerAdapter.setHasStableIds(true);
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24_black);
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override // com.avito.android.booking.info.BookingInfoView
    @NotNull
    public Observable<Unit> backClicks() {
        Observable<Unit> create = Observable.create(new a(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…ext(Unit)\n        }\n    }");
        return create;
    }

    @Override // ru.avito.component.appbar.AppBar
    public void hideActionsMenu() {
        this.g.hideActionsMenu();
    }

    @Override // ru.avito.component.appbar.AppBar
    public boolean isVisible() {
        return this.g.isVisible();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public Observable<Integer> menuCallbacks() {
        return this.g.menuCallbacks();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public Observable<Unit> navigationCallbacks() {
        return this.g.navigationCallbacks();
    }

    @Override // com.avito.android.booking.info.BookingInfoView
    public void notifyDataChanged() {
        this.f.notifyDataSetChanged();
    }

    @Override // com.avito.android.booking.info.BookingInfoView
    @NotNull
    public Observable<Unit> retryClicks() {
        return InteropKt.toV3(this.d.refreshes());
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setActionMenuItemIcon(int i, @DrawableRes int i2, @AttrRes @Nullable Integer num) {
        this.g.setActionMenuItemIcon(i, i2, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setIcon(@Nullable Picture picture) {
        this.g.setIcon(picture);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenu(@MenuRes int i) {
        this.g.setMenu(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColor(@ColorRes int i) {
        this.g.setMenuTintColor(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColorAttr(@AttrRes int i) {
        this.g.setMenuTintColorAttr(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setNavigationIcon(@DrawableRes int i, @AttrRes @Nullable Integer num) {
        this.g.setNavigationIcon(i, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setShadowVisible(boolean z) {
        this.g.setShadowVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@StringRes int i) {
        this.g.setTitle(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.g.setTitle(charSequence);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setVisible(boolean z) {
        this.g.setVisible(z);
    }

    @Override // com.avito.android.booking.info.BookingInfoView
    public void showActionButton(@NotNull String str, @NotNull BookingInfoActionStyle bookingInfoActionStyle, @NotNull Function0<Unit> function0) {
        int i;
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(bookingInfoActionStyle, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.c.setText(str);
        int ordinal = bookingInfoActionStyle.ordinal();
        if (ordinal == 0) {
            i = com.avito.android.lib.design.R.attr.buttonDefaultLarge;
        } else if (ordinal == 1) {
            i = com.avito.android.lib.design.R.attr.buttonPrimaryLarge;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.c.setAppearanceFromAttr(i);
        this.c.setOnClickListener(new b(function0));
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showActionsMenu(@NotNull List<ActionMenu> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        this.g.showActionsMenu(list);
    }

    @Override // com.avito.android.booking.info.BookingInfoView
    public void showContent() {
        this.d.showContent();
    }

    @Override // com.avito.android.booking.info.BookingInfoView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.d.showLoadingProblem(str);
    }

    @Override // com.avito.android.booking.info.BookingInfoView
    public void showLoading() {
        this.d.showLoading();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showToolbar() {
        this.g.showToolbar();
    }
}
