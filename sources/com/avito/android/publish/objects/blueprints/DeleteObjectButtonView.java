package com.avito.android.publish.objects.blueprints;

import android.view.View;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.publish.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\b\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/publish/objects/blueprints/DeleteObjectButtonView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lkotlin/Function0;", "", "clickListener", "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "onUnbind", "()V", "Lcom/avito/android/lib/design/button/Button;", "s", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "t", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class DeleteObjectButtonView extends BaseViewHolder {
    public final Button s;
    public Function0<Unit> t;

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
    public DeleteObjectButtonView(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.s = (Button) findViewById;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.t;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setOnClickListener(@Nullable Function0<Unit> function0) {
        if (function0 != null) {
            this.s.setOnClickListener(new a(function0));
        } else {
            this.s.setOnClickListener(null);
        }
    }

    public final void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.t = function0;
    }
}
