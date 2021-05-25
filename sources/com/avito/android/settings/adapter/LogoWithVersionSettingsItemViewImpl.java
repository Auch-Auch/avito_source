package com.avito.android.settings.adapter;

import android.view.View;
import android.widget.TextView;
import com.avito.android.settings.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/avito/android/settings/adapter/LogoWithVersionSettingsItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/settings/adapter/LogoWithVersionSettingsItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setLogoActionListener", "(Lkotlin/jvm/functions/Function0;)V", "setVersionActionListener", "", "version", "setVersion", "(Ljava/lang/String;)V", "Landroid/view/View;", "s", "Landroid/view/View;", "logoView", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "versionView", "rootView", "<init>", "(Landroid/view/View;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class LogoWithVersionSettingsItemViewImpl extends BaseViewHolder implements LogoWithVersionSettingsItemView {
    public final View s;
    public final TextView t;

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LogoWithVersionSettingsItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.logo);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.s = findViewById;
        View findViewById2 = view.findViewById(R.id.version);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
    }

    @Override // com.avito.android.settings.adapter.LogoWithVersionSettingsItemView
    public void setLogoActionListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.settings.adapter.LogoWithVersionSettingsItemView
    public void setVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "version");
        this.t.setText(str);
    }

    @Override // com.avito.android.settings.adapter.LogoWithVersionSettingsItemView
    public void setVersionActionListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setOnClickListener(new b(function0));
    }
}
