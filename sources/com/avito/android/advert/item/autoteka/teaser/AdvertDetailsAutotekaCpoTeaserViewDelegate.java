package com.avito.android.advert.item.autoteka.teaser;

import a2.g.r.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserView;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AutotekaCpoTeaser;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\"\u001a\u00020\u0013\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0016\u0010\u0012\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\tR\u0016\u0010\u001a\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\rR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\tR\u0016\u0010\"\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0015R\u0016\u0010$\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\rR\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\rR\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\rR\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaCpoTeaserViewDelegate;", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaCpoTeaserView;", "Lcom/avito/android/remote/model/AutotekaCpoTeaser;", "teaser", "", "bindCpoTeaserData", "(Lcom/avito/android/remote/model/AutotekaCpoTeaser;)V", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "resultInsightsColumn1", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "cpoTitle", "h", "cpoContainer", "l", "descriptionLink", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "resultContainer", "k", "termsContainer", "c", "resultSubTitle", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserView$Listener;", "n", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "f", "resultInsightsColumn2", AuthSource.OPEN_CHANNEL_LIST, "view", "j", "termsDescription", AuthSource.BOOKING_ORDER, "resultTitle", "d", "resultDescription", "Lcom/avito/android/lib/design/button/Button;", g.a, "Lcom/avito/android/lib/design/button/Button;", "resultButton", "<init>", "(Landroid/view/View;Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserView$Listener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAutotekaCpoTeaserViewDelegate implements AdvertDetailsAutotekaCpoTeaserView {
    public final View a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final LinearLayout e;
    public final LinearLayout f;
    public final Button g;
    public final LinearLayout h;
    public final TextView i;
    public final TextView j;
    public final LinearLayout k;
    public final TextView l;
    public final View m;
    public final AdvertDetailsAutotekaTeaserView.Listener n;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ AdvertDetailsAutotekaCpoTeaserViewDelegate a;
        public final /* synthetic */ AutotekaCpoTeaser b;

        public a(AdvertDetailsAutotekaCpoTeaserViewDelegate advertDetailsAutotekaCpoTeaserViewDelegate, AutotekaCpoTeaser autotekaCpoTeaser) {
            this.a = advertDetailsAutotekaCpoTeaserViewDelegate;
            this.b = autotekaCpoTeaser;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            AdvertDetailsAutotekaTeaserView.Listener listener = this.a.n;
            if (listener != null) {
                listener.onClickShowCpoProgram(this.b.getDescription());
            }
        }
    }

    public AdvertDetailsAutotekaCpoTeaserViewDelegate(@NotNull View view, @Nullable AdvertDetailsAutotekaTeaserView.Listener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.m = view;
        this.n = listener;
        View findViewById = view.findViewById(R.id.result_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        View findViewById2 = findViewById.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = findViewById.findViewById(R.id.sub_title);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById3;
        View findViewById4 = findViewById.findViewById(R.id.description);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById4;
        View findViewById5 = findViewById.findViewById(R.id.insights_column_1);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.e = (LinearLayout) findViewById5;
        this.f = (LinearLayout) findViewById.findViewById(R.id.insights_column_2);
        View findViewById6 = findViewById.findViewById(R.id.button);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.g = (Button) findViewById6;
        View findViewById7 = findViewById.findViewById(R.id.cpo_container);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) findViewById7;
        this.h = linearLayout;
        View findViewById8 = linearLayout.findViewById(R.id.cpo_title);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.i = (TextView) findViewById8;
        View findViewById9 = linearLayout.findViewById(R.id.terms_description);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.widget.TextView");
        this.j = (TextView) findViewById9;
        View findViewById10 = linearLayout.findViewById(R.id.terms_container);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.k = (LinearLayout) findViewById10;
        View findViewById11 = linearLayout.findViewById(R.id.program_description_link);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type android.widget.TextView");
        this.l = (TextView) findViewById11;
    }

    @Override // com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaCpoTeaserView
    public void bindCpoTeaserData(@NotNull AutotekaCpoTeaser autotekaCpoTeaser) {
        Intrinsics.checkNotNullParameter(autotekaCpoTeaser, "teaser");
        Views.show(this.h);
        this.i.setText(autotekaCpoTeaser.getTitle());
        this.j.setText(autotekaCpoTeaser.getSubtitle());
        this.k.removeAllViews();
        for (String str : autotekaCpoTeaser.getTerms()) {
            View inflate = LayoutInflater.from(this.m.getContext()).inflate(R.layout.advert_details_autoteka_cpo_teaser_term, (ViewGroup) this.k, false);
            TextView textView = (TextView) inflate.findViewById(R.id.term);
            Intrinsics.checkNotNullExpressionValue(textView, "textView");
            textView.setText(str);
            this.k.addView(inflate);
        }
        this.l.setText(autotekaCpoTeaser.getProgramLinkText());
        RxView.clicks(this.l).throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, autotekaCpoTeaser));
        this.b.setText(autotekaCpoTeaser.getReportTitle());
        TextViews.bindText$default(this.c, autotekaCpoTeaser.getReportInfo(), false, 2, null);
        Views.show(this.d);
        this.d.setText(autotekaCpoTeaser.getReportIntro());
        this.e.removeAllViews();
        LinearLayout linearLayout = this.f;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        Button button = this.g;
        CharSequence text = this.m.getContext().getText(R.string.autoteka_cpo_report_button);
        Intrinsics.checkNotNullExpressionValue(text, "view.context.getText(R.s…toteka_cpo_report_button)");
        button.setText(text);
    }
}
