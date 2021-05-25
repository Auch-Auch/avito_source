package com.avito.android.profile.sessions.list;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.profile.R;
import com.avito.android.profile.sessions.adapter.session.SessionItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.Disposables;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\bQ\u0010RJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJY\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00132\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010\"R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010@\u001a\b\u0012\u0004\u0012\u00020;0:8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?RD\u0010F\u001a0\u0012\f\u0012\n B*\u0004\u0018\u00010;0; B*\u0017\u0012\f\u0012\n B*\u0004\u0018\u00010;0;\u0018\u00010A¢\u0006\u0002\bC0A¢\u0006\u0002\bC8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u00100R\u0018\u0010L\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u00100R\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006S"}, d2 = {"Lcom/avito/android/profile/sessions/list/SessionsMenuViewImpl;", "Lcom/avito/android/profile/sessions/list/SessionsMenuView;", "", "Lcom/avito/android/profile/sessions/adapter/session/SessionItem$Action;", "actions", "", "showMenu", "(Ljava/util/List;)V", "closeMenu", "()V", "", "isInProgress", "showLogoutInProgress", "(Z)V", "isShowing", "()Z", "canShowSnackbar", "", "text", "", "textResId", "actionText", "actionTextResId", "Lkotlin/Function0;", "onActionClick", "duration", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "type", "showSnackbar", "(Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)V", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "alarmTitle", "Landroid/content/Context;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/content/Context;", "context", "h", "logoutTitle", "Landroid/widget/ProgressBar;", "j", "Landroid/widget/ProgressBar;", "logoutProgress", "Landroid/view/View;", "d", "Landroid/view/View;", "menuContainer", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "dialog", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "logoutIcon", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "l", "Lio/reactivex/rxjava3/core/Observable;", "getActionClicks", "()Lio/reactivex/rxjava3/core/Observable;", "actionClicks", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "actionRelay", "c", "Ljava/util/List;", "e", "alarmItem", g.a, "logoutItem", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "k", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "<init>", "(Landroid/content/Context;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsMenuViewImpl implements SessionsMenuView {
    public final PublishRelay<DeepLink> a;
    public BottomSheetDialog b;
    public List<SessionItem.Action> c;
    public View d;
    public View e;
    public TextView f;
    public View g;
    public TextView h;
    public ImageView i;
    public ProgressBar j;
    public final CompositeDisposable k = new CompositeDisposable();
    @NotNull
    public final Observable<DeepLink> l;
    public final Context m;

    public SessionsMenuViewImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.m = context;
        PublishRelay<DeepLink> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "actionRelay");
        this.l = create;
    }

    public static final void access$clearViews(SessionsMenuViewImpl sessionsMenuViewImpl) {
        sessionsMenuViewImpl.d = null;
        sessionsMenuViewImpl.e = null;
        sessionsMenuViewImpl.f = null;
        sessionsMenuViewImpl.g = null;
        sessionsMenuViewImpl.i = null;
        sessionsMenuViewImpl.h = null;
        sessionsMenuViewImpl.j = null;
    }

    @Override // com.avito.android.lib.design.snackbar.util.OptionalSnackbarElementView
    public boolean canShowSnackbar() {
        return isShowing();
    }

    @Override // com.avito.android.profile.sessions.list.SessionsMenuView
    public void closeMenu() {
        BottomSheetDialog bottomSheetDialog = this.b;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.dismiss();
        }
    }

    @Override // com.avito.android.profile.sessions.list.SessionsMenuView
    @NotNull
    public Observable<DeepLink> getActionClicks() {
        return this.l;
    }

    @Override // com.avito.android.profile.sessions.list.SessionsMenuView
    public boolean isShowing() {
        BottomSheetDialog bottomSheetDialog = this.b;
        if (bottomSheetDialog != null) {
            return bottomSheetDialog.isShowing();
        }
        return false;
    }

    @Override // com.avito.android.profile.sessions.list.SessionsMenuView
    public void showLogoutInProgress(boolean z) {
        Views.setVisible(this.i, !z);
        Views.setVisible(this.j, z);
        View view = this.g;
        if (view != null) {
            view.setEnabled(!z);
        }
        View view2 = this.e;
        if (view2 != null) {
            view2.setEnabled(!z);
        }
    }

    @Override // com.avito.android.profile.sessions.list.SessionsMenuView
    public void showMenu(@NotNull List<SessionItem.Action> list) {
        T t;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(list, "actions");
        this.c = list;
        T t2 = null;
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.m, 0, 2, null);
        bottomSheetDialog.setContentView(R.layout.session_control_menu);
        View findViewById = bottomSheetDialog.findViewById(R.id.sessions_menu_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        this.d = findViewById;
        View findViewById2 = bottomSheetDialog.findViewById(R.id.not_me_item);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
        this.e = findViewById2;
        View findViewById3 = bottomSheetDialog.findViewById(R.id.not_me_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(id)");
        this.f = (TextView) findViewById3;
        View findViewById4 = bottomSheetDialog.findViewById(R.id.logout_item);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(id)");
        this.g = findViewById4;
        View findViewById5 = bottomSheetDialog.findViewById(R.id.logout_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(id)");
        this.i = (ImageView) findViewById5;
        View findViewById6 = bottomSheetDialog.findViewById(R.id.logout_title);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(id)");
        this.h = (TextView) findViewById6;
        View findViewById7 = bottomSheetDialog.findViewById(R.id.logout_progress);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(id)");
        this.j = (ProgressBar) findViewById7;
        Context context = bottomSheetDialog.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        bottomSheetDialog.setPeekHeight(Contexts.getDisplayHeight(context));
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog, null, null, false, true, 2, null);
        bottomSheetDialog.setOnDismissListener(new a2.a.a.b2.h1.a.g(this));
        List<SessionItem.Action> list2 = this.c;
        if (list2 != null) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                t = it.next();
                if (t.getType() == SessionItem.Action.Type.ALARM) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        t = null;
        if (t != null) {
            Views.show(this.e);
            View view = this.e;
            if (view != null) {
                CompositeDisposable compositeDisposable = this.k;
                Disposable subscribe = RxView.clicks(view).subscribe(new f0(0, this, t));
                Intrinsics.checkNotNullExpressionValue(subscribe, "it.clicks().subscribe { ….accept(alarm.deeplink) }");
                Disposables.plusAssign(compositeDisposable, subscribe);
            }
            TextView textView = this.f;
            if (textView != null) {
                textView.setText(t.getTitle());
            }
        } else {
            Views.hide(this.e);
        }
        List<SessionItem.Action> list3 = this.c;
        if (list3 != null) {
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                t2 = it2.next();
                if (t2.getType() == SessionItem.Action.Type.LOGOUT) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        if (t2 != null) {
            Views.show(this.g);
            View view2 = this.g;
            if (view2 != null) {
                CompositeDisposable compositeDisposable2 = this.k;
                Disposable subscribe2 = RxView.clicks(view2).subscribe(new f0(1, this, t2));
                Intrinsics.checkNotNullExpressionValue(subscribe2, "it.clicks().subscribe { …accept(logout.deeplink) }");
                Disposables.plusAssign(compositeDisposable2, subscribe2);
            }
            TextView textView2 = this.h;
            if (textView2 != null) {
                textView2.setText(t2.getTitle());
            }
            showLogoutInProgress(t2.isLoading());
        } else {
            Views.hide(this.g);
        }
        bottomSheetDialog.show();
        this.b = bottomSheetDialog;
    }

    @Override // com.avito.android.lib.design.snackbar.util.SnackbarElementView
    public void showSnackbar(@NotNull String str, int i2, @Nullable String str2, int i3, @Nullable Function0<Unit> function0, int i4, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(snackbarType, "type");
        View view = this.d;
        if (view != null) {
            SnackbarExtensionsKt.showSnackbar(view, str, i2, str2, i3, function0, i4, snackbarPosition, snackbarType);
        }
    }
}
