package com.avito.android.advert_core.delivery;

import a2.a.a.g.f.a;
import a2.a.a.g.f.b;
import a2.a.a.g.f.d;
import a2.a.a.g.f.e;
import a2.a.a.g.f.f;
import android.content.Context;
import android.net.Uri;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.SnackBarListener;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlock;
import com.avito.android.component.switch_list_element.SwitchListElement;
import com.avito.android.component.switch_list_element.SwitchListElementImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001@B1\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010\r\u001a\u00020;\u0012\b\b\u0002\u0010.\u001a\u00020\u0005¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\b\u0010\u0007J\"\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u000e\u001a\u00020\u00022\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0011\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00022\b\b\u0001\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u001b\u0010\u0015J&\u0010 \u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\"\u0010\u0015J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u001cH\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002H\u0001¢\u0006\u0004\b&\u0010\u0004R\u001e\u0010+\u001a\n (*\u0004\u0018\u00010'0'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010\r\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView;", "Lcom/avito/android/component/switch_list_element/SwitchListElement;", "", "hideToggle", "()V", "", "isChecked", "()Z", "isSaveEnabled", "withAnimation", "setChecked", "(ZZ)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCheckedChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "isEnabled", "setEnabled", "(Z)V", "", "resId", "setIcon", "(I)V", "enabled", "setSaveEnabled", "", MessengerShareContentUtility.SUBTITLE, "Landroid/text/method/MovementMethod;", "movementMethod", "setSubtitle", "(Ljava/lang/CharSequence;Landroid/text/method/MovementMethod;)V", "setSwitchEnabled", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "showToggle", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "f", "Z", "isRedesign", "Landroidx/lifecycle/LifecycleOwner;", "d", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "view", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModel;", "c", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModel;", "viewModel", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView$Listener;", "e", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView$Listener;", "<init>", "(Landroid/view/View;Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModel;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView$Listener;Z)V", "Listener", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDeliveryBlockView implements SwitchListElement {
    public final Context a;
    public final View b;
    public final AdvertDeliveryBlockViewModel c;
    public final LifecycleOwner d;
    public final Listener e;
    public final boolean f;
    public final /* synthetic */ SwitchListElementImpl g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView$Listener;", "Lcom/avito/android/advert_core/SnackBarListener;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "followUri", "(Landroid/net/Uri;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener extends SnackBarListener {
        void followUri(@NotNull Uri uri);
    }

    public AdvertDeliveryBlockView(@NotNull View view, @NotNull AdvertDeliveryBlockViewModel advertDeliveryBlockViewModel, @NotNull LifecycleOwner lifecycleOwner, @NotNull Listener listener, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(advertDeliveryBlockViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.g = new SwitchListElementImpl(view);
        this.b = view;
        this.c = advertDeliveryBlockViewModel;
        this.d = lifecycleOwner;
        this.e = listener;
        this.f = z;
        this.a = view.getContext();
        setSaveEnabled(false);
        advertDeliveryBlockViewModel.getDataChanges().removeObservers(lifecycleOwner);
        advertDeliveryBlockViewModel.getDataChanges().observe(lifecycleOwner, new b(this));
        advertDeliveryBlockViewModel.getSwitchProgressChanges().removeObservers(lifecycleOwner);
        advertDeliveryBlockViewModel.getSwitchProgressChanges().observe(lifecycleOwner, new d(this));
    }

    public static final void access$bindDeliveryBlock(AdvertDeliveryBlockView advertDeliveryBlockView, View view, AdvertDeliveryBlock advertDeliveryBlock) {
        Objects.requireNonNull(advertDeliveryBlockView);
        if (advertDeliveryBlock.getInfo() != null) {
            AdvertDeliveryBlock.Info info = advertDeliveryBlock.getInfo();
            advertDeliveryBlockView.hideToggle();
            advertDeliveryBlockView.setIcon(advertDeliveryBlockView.f ? R.drawable.rds_delivery_24 : com.avito.android.ui_components.R.drawable.ic_delivery_24);
            advertDeliveryBlockView.setTitle(info.getTitle());
            SwitchListElement.DefaultImpls.setSubtitle$default(advertDeliveryBlockView, info.getSubtitle(), null, 2, null);
            Uri uri = info.getUri();
            if (uri != null) {
                advertDeliveryBlockView.setClickListener(new a(uri, advertDeliveryBlockView));
            }
            Views.show(view);
        } else if (advertDeliveryBlock.getSwitcher() != null) {
            AdvertDeliveryBlock.Switcher switcher = advertDeliveryBlock.getSwitcher();
            advertDeliveryBlockView.setIcon(advertDeliveryBlockView.f ? R.drawable.rds_delivery_24 : com.avito.android.ui_components.R.drawable.ic_delivery_24);
            advertDeliveryBlockView.setTitle(switcher.getTitle());
            advertDeliveryBlockView.setSubtitle(switcher.getSubtitle(), LinkMovementMethod.getInstance());
            boolean value = switcher.getValue();
            advertDeliveryBlockView.setCheckedChangeListener(e.a);
            SwitchListElement.DefaultImpls.setChecked$default(advertDeliveryBlockView, value, false, 2, null);
            advertDeliveryBlockView.setCheckedChangeListener(new f(advertDeliveryBlockView));
            Views.show(view);
        }
    }

    public static final void access$setToggleValue(AdvertDeliveryBlockView advertDeliveryBlockView, boolean z) {
        Objects.requireNonNull(advertDeliveryBlockView);
        advertDeliveryBlockView.setCheckedChangeListener(e.a);
        SwitchListElement.DefaultImpls.setChecked$default(advertDeliveryBlockView, z, false, 2, null);
        advertDeliveryBlockView.setCheckedChangeListener(new f(advertDeliveryBlockView));
    }

    public static final String access$toErrorMessage(AdvertDeliveryBlockView advertDeliveryBlockView, TypedError typedError) {
        Objects.requireNonNull(advertDeliveryBlockView);
        if (typedError instanceof ErrorResult) {
            return ((ErrorResult) typedError).getMessage();
        }
        String string = advertDeliveryBlockView.a.getString(R.string.has_error_occurred);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.has_error_occurred)");
        return string;
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void hideToggle() {
        this.g.hideToggle();
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public boolean isChecked() {
        return this.g.isChecked();
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public boolean isSaveEnabled() {
        return this.g.isSaveEnabled();
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setChecked(boolean z, boolean z2) {
        this.g.setChecked(z, z2);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setCheckedChangeListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.g.setCheckedChangeListener(function1);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.g.setClickListener(function0);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setEnabled(boolean z) {
        this.g.setEnabled(z);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setIcon(@DrawableRes int i) {
        this.g.setIcon(i);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setSaveEnabled(boolean z) {
        this.g.setSaveEnabled(z);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setSubtitle(@Nullable CharSequence charSequence, @Nullable MovementMethod movementMethod) {
        this.g.setSubtitle(charSequence, movementMethod);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setSwitchEnabled(boolean z) {
        this.g.setSwitchEnabled(z);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.g.setTitle(charSequence);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void showToggle() {
        this.g.showToggle();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertDeliveryBlockView(View view, AdvertDeliveryBlockViewModel advertDeliveryBlockViewModel, LifecycleOwner lifecycleOwner, Listener listener, boolean z, int i, j jVar) {
        this(view, advertDeliveryBlockViewModel, lifecycleOwner, listener, (i & 16) != 0 ? false : z);
    }
}
