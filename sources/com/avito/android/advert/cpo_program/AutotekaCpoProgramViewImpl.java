package com.avito.android.advert.cpo_program;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.text.HtmlCompat;
import com.avito.android.deprecated_design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CpoDescription;
import com.avito.android.remote.model.CpoIcon;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Toolbars;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramViewImpl;", "Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramView;", "Lcom/avito/android/remote/model/CpoDescription;", "description", "", "showCpoProgram", "(Lcom/avito/android/remote/model/CpoDescription;)V", "Lio/reactivex/rxjava3/core/Observable;", "upButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "c", "title", "Lcom/facebook/drawee/view/SimpleDraweeView;", AuthSource.BOOKING_ORDER, "Lcom/facebook/drawee/view/SimpleDraweeView;", "logo", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaCpoProgramViewImpl implements AutotekaCpoProgramView {
    public final Toolbar a;
    public final SimpleDraweeView b;
    public final TextView c;
    public final TextView d;

    public AutotekaCpoProgramViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.a = (Toolbar) findViewById;
        View findViewById2 = view.findViewById(com.avito.android.advert_details.R.id.logo);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.b = (SimpleDraweeView) findViewById2;
        View findViewById3 = view.findViewById(com.avito.android.advert_details.R.id.title);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(com.avito.android.advert_details.R.id.description);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById4;
    }

    @Override // com.avito.android.advert.cpo_program.AutotekaCpoProgramView
    public void showCpoProgram(@NotNull CpoDescription cpoDescription) {
        Intrinsics.checkNotNullParameter(cpoDescription, "description");
        Uri url = cpoDescription.getLogo().getUrl();
        CpoIcon icon = cpoDescription.getIcon();
        if (icon != null) {
            Resources resources = this.b.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "logo.resources");
            int ceil = (int) ((float) Math.ceil((double) resources.getDisplayMetrics().density));
            if (ceil == 1) {
                url = icon.getX1ScaledLogo();
            } else if (ceil == 2) {
                url = icon.getX2ScaledLogo();
            } else if (ceil != 3) {
                url = icon.getX4ScaledLogo();
            } else {
                url = icon.getX3ScaledLogo();
            }
        }
        SimpleDraweeViewsKt.getRequestBuilder(this.b).uri(url).load();
        this.c.setText(cpoDescription.getTitle());
        this.d.setText(HtmlCompat.fromHtml(cpoDescription.getContent(), 0));
    }

    @Override // com.avito.android.advert.cpo_program.AutotekaCpoProgramView
    @NotNull
    public Observable<Unit> upButtonClicks() {
        return Toolbars.upClicks(this.a);
    }
}
