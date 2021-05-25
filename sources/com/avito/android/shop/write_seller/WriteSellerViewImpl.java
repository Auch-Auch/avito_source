package com.avito.android.shop.write_seller;

import a2.g.r.g;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.lastclick.LastClick;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.shop.R;
import com.avito.android.shop.write_seller.WriteSellerView;
import com.avito.android.ui.view.FieldView;
import com.avito.android.ui.view.InputView;
import com.avito.android.util.DialogUtils;
import com.avito.android.util.Keyboards;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Toolbars;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b8\u00109J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\rJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\rJ\u0019\u0010\u0015\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\rJ\u0019\u0010\u0016\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\rJ\u0019\u0010\u0017\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\rJ\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\nJ\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\nJ\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\nJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\nR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u0010.R\u0016\u00107\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u0010.¨\u0006:"}, d2 = {"Lcom/avito/android/shop/write_seller/WriteSellerViewImpl;", "Lcom/avito/android/shop/write_seller/WriteSellerView;", "", "title", "Landroid/graphics/drawable/Drawable;", "icon", "", "setToolbar", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V", "showNetworkProblem", "()V", "message", "showMessage", "(Ljava/lang/String;)V", "showProgress", "hideProgress", "name", "setNameInputValue", "email", "setEmailInputValue", "setMessageInputValue", "highlightNameError", "highlightEmailError", "highlightMessageError", "clearNameError", "clearEmailError", "clearMessageError", PlatformActions.HIDE_KEYBOARD, "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/content/Context;", g.a, "Landroid/content/Context;", "context", "Lcom/avito/android/shop/write_seller/WriteSellerView$Callback;", "h", "Lcom/avito/android/shop/write_seller/WriteSellerView$Callback;", "callback", "Landroid/view/View;", "f", "Landroid/view/View;", "view", "Lcom/avito/android/ui/view/InputView;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ui/view/InputView;", "nameInput", "Landroid/app/Dialog;", "e", "Landroid/app/Dialog;", "progressDialog", "c", "emailInput", "d", "messageInput", "<init>", "(Landroid/view/View;Landroid/content/Context;Lcom/avito/android/shop/write_seller/WriteSellerView$Callback;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class WriteSellerViewImpl implements WriteSellerView {
    public final Toolbar a;
    public InputView b;
    public InputView c;
    public InputView d;
    public Dialog e;
    public final View f;
    public final Context g;
    public final WriteSellerView.Callback h;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements FieldView.OnFieldValueChangeListener<Object> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // com.avito.android.ui.view.FieldView.OnFieldValueChangeListener
        public final void onFieldValueChanged(FieldView<Object> fieldView, @Nullable Object obj) {
            int i = this.a;
            if (i == 0) {
                WriteSellerView.Callback callback = ((WriteSellerViewImpl) this.b).h;
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                callback.onNameEntered((String) obj);
            } else if (i == 1) {
                WriteSellerView.Callback callback2 = ((WriteSellerViewImpl) this.b).h;
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                callback2.onEmailEntered((String) obj);
            } else if (i == 2) {
                WriteSellerView.Callback callback3 = ((WriteSellerViewImpl) this.b).h;
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                callback3.onMessageEntered((String) obj);
            } else {
                throw null;
            }
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ WriteSellerViewImpl a;

        public b(WriteSellerViewImpl writeSellerViewImpl) {
            this.a = writeSellerViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.h.onBackClicked();
        }
    }

    public static final class c implements Toolbar.OnMenuItemClickListener {
        public final /* synthetic */ WriteSellerViewImpl a;

        public c(WriteSellerViewImpl writeSellerViewImpl) {
            this.a = writeSellerViewImpl;
        }

        @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            Intrinsics.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_send) {
                return false;
            }
            this.a.h.onSendClicked();
            return true;
        }
    }

    public static final class d implements DialogInterface.OnCancelListener {
        public final /* synthetic */ WriteSellerViewImpl a;

        public d(WriteSellerViewImpl writeSellerViewImpl) {
            this.a = writeSellerViewImpl;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            LastClick.Updater.update();
            this.a.h.onProgressDialogCanceled();
        }
    }

    public WriteSellerViewImpl(@NotNull View view, @NotNull Context context, @NotNull WriteSellerView.Callback callback) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f = view;
        this.g = context;
        this.h = callback;
        View findViewById = view.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.a = toolbar;
        View findViewById2 = view.findViewById(R.id.edit_name);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.ui.view.InputView");
        this.b = (InputView) findViewById2;
        View findViewById3 = view.findViewById(R.id.edit_email);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.ui.view.InputView");
        this.c = (InputView) findViewById3;
        View findViewById4 = view.findViewById(R.id.edit_message);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.ui.view.InputView");
        this.d = (InputView) findViewById4;
        this.b.setOnFieldValueChangedListener(new a(0, this));
        this.c.setOnFieldValueChangedListener(new a(1, this));
        this.d.setOnFieldValueChangedListener(new a(2, this));
        toolbar.setNavigationOnClickListener(new b(this));
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView
    public void clearEmailError() {
        this.c.clearError();
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView
    public void clearMessageError() {
        this.d.clearError();
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView
    public void clearNameError() {
        this.b.clearError();
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.f, false, 1, null);
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView
    public void hideProgress() {
        Dialog dialog = this.e;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.e = null;
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView
    public void highlightEmailError(@Nullable String str) {
        this.c.highlightError(str);
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView
    public void highlightMessageError(@Nullable String str) {
        this.d.highlightError(str);
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView
    public void highlightNameError(@Nullable String str) {
        this.b.highlightError(str);
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView
    public void setEmailInputValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        this.c.setValue(str);
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView
    public void setMessageInputValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.d.setValue(str);
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView
    public void setNameInputValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.b.setValue(str);
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView
    public void setToolbar(@NotNull String str, @NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(drawable, "icon");
        Toolbars.setSpannedTitle(this.a, str);
        this.a.setNavigationIcon(drawable);
        this.a.inflateMenu(R.menu.write_seller);
        Toolbars.tintMenuByAttr(this.a, com.avito.android.lib.design.R.attr.blue);
        this.a.setOnMenuItemClickListener(new c(this));
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        ToastsKt.showToast$default(this.g, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView
    public void showNetworkProblem() {
        String string = this.g.getString(com.avito.android.remote.R.string.network_unavailable_snack);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(remote…etwork_unavailable_snack)");
        showMessage(string);
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView
    public void showProgress() {
        Dialog showSimpleWaitingDialog = DialogUtils.showSimpleWaitingDialog(this.g);
        this.e = showSimpleWaitingDialog;
        if (showSimpleWaitingDialog != null) {
            showSimpleWaitingDialog.setOnCancelListener(new d(this));
        }
    }
}
