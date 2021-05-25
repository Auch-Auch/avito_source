package com.avito.android.publish.view.publish_button;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.publish.R;
import com.avito.android.publish.view.publish_button.PublishButton;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010#J\u001f\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010 \u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/avito/android/publish/view/publish_button/PublishButtonImpl;", "Lcom/avito/android/publish/view/publish_button/PublishButton;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "getHeight", "()I", "", "text", "setText", "(Ljava/lang/String;)V", "enable", "()V", "disable", "hide", "show", "", "isVisible", "setProgressBarVisible", "(Z)V", "Lcom/avito/android/lib/design/button/Button;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "getButtonView", "()Landroid/view/View;", "buttonView", "view", "<init>", "(Landroid/view/View;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishButtonImpl implements PublishButton {
    public final Button a;
    @Nullable
    public final View b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public PublishButtonImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Button button = (Button) view.findViewById(R.id.main_button);
        this.a = button;
        this.b = button;
    }

    @Override // com.avito.android.publish.view.publish_button.PublishButton
    public void disable() {
        Button button = this.a;
        if (button != null) {
            Views.disable(button);
        }
    }

    @Override // com.avito.android.publish.view.publish_button.PublishButton
    public void enable() {
        Button button = this.a;
        if (button != null) {
            Views.enable(button);
        }
    }

    @Override // com.avito.android.publish.view.publish_button.PublishButton
    @Nullable
    public View getButtonView() {
        return this.b;
    }

    @Override // com.avito.android.publish.view.publish_button.PublishButton
    public int getHeight() {
        Button button = this.a;
        if (button == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return this.a.getHeight() + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    @Override // com.avito.android.publish.view.publish_button.PublishButton
    public void hide() {
        Button button = this.a;
        if (button != null) {
            Views.hide(button);
        }
    }

    @Override // com.avito.android.publish.view.publish_button.PublishButton
    public void setClickListener(@Nullable Function0<Unit> function0) {
        Unit unit;
        if (function0 != null) {
            Button button = this.a;
            if (button != null) {
                button.setOnClickListener(new a(function0));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        Button button2 = this.a;
        if (button2 != null) {
            button2.setOnClickListener(null);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.publish.view.publish_button.PublishButton
    public void setEnabled(boolean z) {
        PublishButton.DefaultImpls.setEnabled(this, z);
    }

    @Override // com.avito.android.publish.view.publish_button.PublishButton
    public void setProgressBarVisible(boolean z) {
        Button button = this.a;
        if (button != null) {
            button.setLoading(z);
        }
    }

    @Override // com.avito.android.publish.view.publish_button.PublishButton
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        Button button = this.a;
        if (button != null) {
            button.setText(str);
        }
    }

    @Override // com.avito.android.publish.view.publish_button.PublishButton
    public void setVisible(boolean z) {
        PublishButton.DefaultImpls.setVisible(this, z);
    }

    @Override // com.avito.android.publish.view.publish_button.PublishButton
    public void show() {
        Button button = this.a;
        if (button != null) {
            Views.show(button);
        }
    }
}
