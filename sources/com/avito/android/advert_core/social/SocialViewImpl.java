package com.avito.android.advert_core.social;

import a2.a.a.g.n.c;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageButton;
import androidx.core.content.ContextCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.R;
import com.avito.android.social.button.SocialButton;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u001d\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010 \u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/advert_core/social/SocialViewImpl;", "Lcom/avito/android/advert_core/social/SocialView;", "", "showError", "()V", "showConnectivityError", "showUnknownError", "", "Lcom/avito/android/social/button/SocialButton;", MessengerShareContentUtility.BUTTONS, "showButtons", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", AuthSource.BOOKING_ORDER, "Landroid/view/ViewGroup;", "buttonsContainer", "Landroid/view/View;", "d", "Landroid/view/View;", "view", "", "c", "I", "buttonLayoutId", "", "e", "Z", "isRedesign", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/view/LayoutInflater;", "layoutInflater", "<init>", "(Landroid/view/View;Z)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class SocialViewImpl implements SocialView {
    public final LayoutInflater a;
    public ViewGroup b;
    public final int c;
    public final View d;
    public final boolean e;

    public SocialViewImpl(@NotNull View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.d = view;
        this.e = z;
        this.a = LayoutInflater.from(view.getContext());
        this.c = z ? R.layout.rds_social_button : R.layout.share_social_button;
    }

    @Override // com.avito.android.advert_core.social.SocialView
    public void showButtons(@NotNull List<SocialButton> list) {
        View view;
        Drawable drawable;
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.BUTTONS);
        ViewStub viewStub = (ViewStub) this.d.findViewById(com.avito.android.advert_core.R.id.social_stub);
        if (viewStub == null || (view = viewStub.inflate()) == null) {
            view = this.d.findViewById(com.avito.android.ui_components.R.id.horizontal_scroll_view);
            Intrinsics.checkNotNullExpressionValue(view, "view.findViewById(ui_R.id.horizontal_scroll_view)");
        }
        View findViewById = view.findViewById(com.avito.android.ui_components.R.id.share_buttons_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.b = viewGroup;
        if (viewGroup != null && viewGroup.getChildCount() == 0) {
            if (!this.e) {
                ViewGroup viewGroup2 = (ViewGroup) view.findViewById(com.avito.android.ui_components.R.id.horizontal_scroll_view);
                Intrinsics.checkNotNullExpressionValue(viewGroup2, "container");
                int dimensionPixelSize = viewGroup2.getResources().getDimensionPixelSize(com.avito.android.ui_components.R.dimen.content_horizontal_padding) - viewGroup2.getResources().getDimensionPixelSize(com.avito.android.advert_core.R.dimen.item_details_social_buttons_padding);
                Views.changePadding$default(viewGroup2, dimensionPixelSize, 0, dimensionPixelSize, 0, 10, null);
            }
            ViewGroup viewGroup3 = this.b;
            if (viewGroup3 != null) {
                viewGroup3.removeAllViews();
                for (T t : list) {
                    View inflate = this.a.inflate(this.c, viewGroup3, false);
                    Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.ImageButton");
                    ImageButton imageButton = (ImageButton) inflate;
                    imageButton.setBackgroundResource(t.getBackground());
                    Integer tint = t.getTint();
                    if (tint == null) {
                        drawable = imageButton.getContext().getDrawable(t.getIcon());
                    } else {
                        Drawable drawable2 = imageButton.getContext().getDrawable(t.getIcon());
                        drawable = drawable2 != null ? DrawablesKt.wrapForTinting(drawable2, ContextCompat.getColor(imageButton.getContext(), tint.intValue())) : null;
                    }
                    imageButton.setImageDrawable(drawable);
                    imageButton.setOnClickListener(new c(t));
                    viewGroup3.addView(imageButton);
                }
            }
        }
    }

    @Override // com.avito.android.advert_core.social.SocialView
    public void showConnectivityError() {
        View view = this.d;
        String string = view.getResources().getString(com.avito.android.remote.R.string.network_unavailable_snack);
        Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString…etwork_unavailable_snack)");
        Views.showSnackBar$default(view, string, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.advert_core.social.SocialView
    public void showError() {
        View view = this.d;
        String string = view.getResources().getString(R.string.social_error_authentication);
        Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString…ial_error_authentication)");
        Views.showSnackBar$default(view, string, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.advert_core.social.SocialView
    public void showUnknownError() {
        View view = this.d;
        String string = view.getResources().getString(com.avito.android.remote.R.string.unknown_server_error);
        Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString…ing.unknown_server_error)");
        Views.showSnackBar$default(view, string, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SocialViewImpl(View view, boolean z, int i, j jVar) {
        this(view, (i & 2) != 0 ? false : z);
    }
}
