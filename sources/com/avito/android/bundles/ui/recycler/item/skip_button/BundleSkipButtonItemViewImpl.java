package com.avito.android.bundles.ui.recycler.item.skip_button;

import android.view.View;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.bundles.R;
import com.avito.android.bundles.ui.recycler.item.skip_button.BundleSkipButtonItemView;
import com.avito.android.lib.design.button.Button;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/bundles/ui/recycler/item/skip_button/BundleSkipButtonItemViewImpl;", "Lcom/avito/android/bundles/ui/recycler/item/skip_button/BundleSkipButtonItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/lib/design/button/Button;", "s", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class BundleSkipButtonItemViewImpl extends BaseViewHolder implements BundleSkipButtonItemView {
    public final Button s;

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public BundleSkipButtonItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.skip_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.s = (Button) findViewById;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        BundleSkipButtonItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.bundles.ui.recycler.item.skip_button.BundleSkipButtonItemView
    public void setButtonClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.bundles.ui.recycler.item.skip_button.BundleSkipButtonItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }
}
