package com.avito.android.contact_access;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00100\u001a\u00020-¢\u0006\u0004\b3\u00104J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u001e\u0010 \u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0010R\u0016\u0010$\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0010R\u0016\u0010&\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0010R\u0016\u0010(\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0018R\u001e\u0010,\u001a\n \u001d*\u0004\u0018\u00010)0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/avito/android/contact_access/ContactAccessPackageViewImpl;", "Lcom/avito/android/contact_access/ContactAccessPackageView;", "", "showProgress", "()V", "hideProgress", "Lcom/avito/android/contact_access/PresentationCvPackage;", "cvPackage", "setContent", "(Lcom/avito/android/contact_access/PresentationCvPackage;)V", "", "message", "showMessage", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "description", "Landroid/widget/Button;", AuthSource.BOOKING_ORDER, "Landroid/widget/Button;", "cancelButton", "Landroid/widget/ProgressBar;", "i", "Landroid/widget/ProgressBar;", "progressBar", g.a, "payButton", "Landroid/view/View;", "kotlin.jvm.PlatformType", "h", "Landroid/view/View;", "content", "c", "countDetails", "d", ErrorBundle.DETAIL_ENTRY, "j", "title", "e", "placementProgress", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/android/contact_access/ContactAccessPackagePresenter;", "k", "Lcom/avito/android/contact_access/ContactAccessPackagePresenter;", "presenter", "Landroid/view/ViewGroup;", "rootView", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/contact_access/ContactAccessPackagePresenter;)V", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public final class ContactAccessPackageViewImpl implements ContactAccessPackageView {
    public final Context a;
    public final Button b;
    public final TextView c;
    public final TextView d;
    public final ProgressBar e;
    public final TextView f;
    public final Button g;
    public final View h;
    public final ProgressBar i;
    public final TextView j;
    public final ContactAccessPackagePresenter k;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((ContactAccessPackageViewImpl) this.b).k.close();
            } else if (i == 1) {
                ((ContactAccessPackageViewImpl) this.b).k.apply();
            } else {
                throw null;
            }
        }
    }

    public ContactAccessPackageViewImpl(@NotNull ViewGroup viewGroup, @NotNull ContactAccessPackagePresenter contactAccessPackagePresenter) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(contactAccessPackagePresenter, "presenter");
        this.k = contactAccessPackagePresenter;
        this.a = viewGroup.getContext();
        View findViewById = viewGroup.findViewById(R.id.cancel_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.Button");
        Button button = (Button) findViewById;
        this.b = button;
        View findViewById2 = viewGroup.findViewById(R.id.count_details);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.details);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.placement_progress);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.ProgressBar");
        this.e = (ProgressBar) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.description);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.pay_button);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.Button");
        Button button2 = (Button) findViewById6;
        this.g = button2;
        this.h = viewGroup.findViewById(R.id.content);
        View findViewById7 = viewGroup.findViewById(R.id.loading_progress);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.ProgressBar");
        this.i = (ProgressBar) findViewById7;
        View findViewById8 = viewGroup.findViewById(R.id.title);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.j = (TextView) findViewById8;
        button.setOnClickListener(new a(0, this));
        button2.setOnClickListener(new a(1, this));
    }

    @Override // com.avito.android.contact_access.ContactAccessPackageView
    public void hideProgress() {
        Views.show(this.h);
        Views.hide(this.i);
    }

    @Override // com.avito.android.contact_access.ContactAccessPackageView
    public void setContent(@NotNull PresentationCvPackage presentationCvPackage) {
        Intrinsics.checkNotNullParameter(presentationCvPackage, "cvPackage");
        this.c.setText(presentationCvPackage.getCountDetails());
        this.d.setText(presentationCvPackage.getDetails());
        this.f.setText(presentationCvPackage.getDescription());
        this.g.setText(presentationCvPackage.getName());
        this.j.setText(presentationCvPackage.getTitle());
        ProgressBar progressBar = this.e;
        progressBar.setProgressDrawable(progressBar.getResources().getDrawable(presentationCvPackage.getProgressDrawable()));
        this.e.setMax(presentationCvPackage.getMaxValue());
        this.e.setProgress(presentationCvPackage.getProgress());
    }

    @Override // com.avito.android.contact_access.ContactAccessPackageView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.contact_access.ContactAccessPackageView
    public void showProgress() {
        Views.hide(this.h);
        Views.show(this.i);
    }
}
