package com.avito.android.short_term_rent.hotels;

import a2.g.r.g;
import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.analytics.Analytics;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.input.Input;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.OnRefreshListener;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.hotels.DiscountBanner;
import com.avito.android.remote.model.hotels.HotelsLocation;
import com.avito.android.remote.model.hotels.Information;
import com.avito.android.short_term_rent.R;
import com.avito.android.short_term_rent.hotels.data.FiltersData;
import com.avito.android.short_term_rent.hotels.data.FiltersDataKt;
import com.avito.android.str_calendar.utils.StrDateUtilsKt;
import com.avito.android.util.Contexts;
import com.google.android.material.snackbar.Snackbar;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.AppBarLayoutWithTextAction;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010P\u001a\u00020O\u0012\u0006\u0010R\u001a\u00020Q¢\u0006\u0004\bS\u0010TJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0007J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0007J\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J/\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u0019\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010'R\u0016\u00100\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010'R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010'R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010'R\u0016\u0010>\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010'R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u00103R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u00103R\u0016\u0010L\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010'R\u0016\u0010N\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010'¨\u0006U"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/HotelsViewImpl;", "Lcom/avito/android/short_term_rent/hotels/HotelsView;", "", "stopLoading", "()V", "Lio/reactivex/rxjava3/core/Observable;", "retryLoadingClicks", "()Lio/reactivex/rxjava3/core/Observable;", "upButtonClicks", "findButtonClicks", "dateFilterClicks", "locationFilterClicks", "guestsFilterClicks", "Lcom/avito/android/short_term_rent/hotels/data/FiltersData;", "filtersData", "fillFiltersWithData", "(Lcom/avito/android/short_term_rent/hotels/data/FiltersData;)V", "showLocationError", "", "title", "", "Lcom/avito/android/remote/model/hotels/Information;", "information", "Lcom/avito/android/remote/model/hotels/DiscountBanner;", "discountBanner", "fillFormWithData", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/hotels/DiscountBanner;)V", "showProgress", "showRetry", "showContent", "errorMessage", "showErrorInSnackBar", "(Ljava/lang/String;)V", "Lru/avito/component/toolbar/AppBarLayoutWithTextAction;", AuthSource.BOOKING_ORDER, "Lru/avito/component/toolbar/AppBarLayoutWithTextAction;", "appBar", "Landroid/widget/TextView;", "j", "Landroid/widget/TextView;", "info2Subtitle", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", AuthSource.SEND_ABUSE, "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "rootView", "n", "discountBannerTitle", "o", "discountBannerDescription", "Lcom/avito/android/lib/design/input/Input;", "f", "Lcom/avito/android/lib/design/input/Input;", "peopleFilter", "l", "info3Subtitle", "Landroid/widget/RelativeLayout;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/widget/RelativeLayout;", "discountBannerView", "k", "info3Title", "i", "info2Title", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "p", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "e", "datesFilter", "Lcom/avito/android/lib/design/button/Button;", "c", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "d", "locationFilter", g.a, "info1Title", "h", "info1Subtitle", "Landroid/view/View;", "view", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/analytics/Analytics;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsViewImpl implements HotelsView {
    public final CoordinatorLayout a;
    public AppBarLayoutWithTextAction b;
    public Button c;
    public Input d;
    public Input e;
    public Input f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public RelativeLayout m;
    public TextView n;
    public TextView o;
    public final ProgressOverlay p;

    public static final class a<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ HotelsViewImpl a;

        /* renamed from: com.avito.android.short_term_rent.hotels.HotelsViewImpl$a$a  reason: collision with other inner class name */
        public static final class C0159a implements Cancellable {
            public final /* synthetic */ a a;

            public C0159a(a aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.e.setOnClickListener(null);
            }
        }

        public static final class b implements View.OnClickListener {
            public final /* synthetic */ ObservableEmitter a;

            public b(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onNext(Unit.INSTANCE);
            }
        }

        public a(HotelsViewImpl hotelsViewImpl) {
            this.a = hotelsViewImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
            observableEmitter.setCancellable(new C0159a(this));
            this.a.e.setOnClickListener(new b(observableEmitter));
        }
    }

    public static final class b<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ HotelsViewImpl a;

        public static final class a implements Cancellable {
            public final /* synthetic */ b a;

            public a(b bVar) {
                this.a = bVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.c.setOnClickListener(null);
            }
        }

        /* renamed from: com.avito.android.short_term_rent.hotels.HotelsViewImpl$b$b  reason: collision with other inner class name */
        public static final class View$OnClickListenerC0160b implements View.OnClickListener {
            public final /* synthetic */ b a;
            public final /* synthetic */ ObservableEmitter b;

            public View$OnClickListenerC0160b(b bVar, ObservableEmitter observableEmitter) {
                this.a = bVar;
                this.b = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a.c.setLoading(true);
                this.b.onNext(Unit.INSTANCE);
            }
        }

        public b(HotelsViewImpl hotelsViewImpl) {
            this.a = hotelsViewImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
            observableEmitter.setCancellable(new a(this));
            this.a.c.setOnClickListener(new View$OnClickListenerC0160b(this, observableEmitter));
        }
    }

    public static final class c<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ HotelsViewImpl a;

        public static final class a implements Cancellable {
            public final /* synthetic */ c a;

            public a(c cVar) {
                this.a = cVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.f.setOnClickListener(null);
            }
        }

        public static final class b implements View.OnClickListener {
            public final /* synthetic */ ObservableEmitter a;

            public b(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onNext(Unit.INSTANCE);
            }
        }

        public c(HotelsViewImpl hotelsViewImpl) {
            this.a = hotelsViewImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
            observableEmitter.setCancellable(new a(this));
            this.a.f.setOnClickListener(new b(observableEmitter));
        }
    }

    public static final class d<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ HotelsViewImpl a;

        public static final class a implements Cancellable {
            public final /* synthetic */ d a;

            public a(d dVar) {
                this.a = dVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.d.setOnClickListener(null);
            }
        }

        public static final class b implements View.OnClickListener {
            public final /* synthetic */ ObservableEmitter a;

            public b(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onNext(Unit.INSTANCE);
            }
        }

        public d(HotelsViewImpl hotelsViewImpl) {
            this.a = hotelsViewImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
            observableEmitter.setCancellable(new a(this));
            this.a.d.setOnClickListener(new b(observableEmitter));
        }
    }

    public static final class e<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ HotelsViewImpl a;

        public static final class a implements Cancellable {
            public final /* synthetic */ e a;

            public a(e eVar) {
                this.a = eVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.p.setOnRefreshListener((OnRefreshListener) null);
            }
        }

        public static final class b extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ObservableEmitter a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(ObservableEmitter observableEmitter) {
                super(0);
                this.a = observableEmitter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                ObservableEmitter observableEmitter = this.a;
                Unit unit = Unit.INSTANCE;
                observableEmitter.onNext(unit);
                return unit;
            }
        }

        public e(HotelsViewImpl hotelsViewImpl) {
            this.a = hotelsViewImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
            observableEmitter.setCancellable(new a(this));
            this.a.p.setOnRefreshListener(new b(observableEmitter));
        }
    }

    public HotelsViewImpl(@NotNull View view, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        View findViewById = view.findViewById(R.id.hotels_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.hotels_root)");
        this.a = (CoordinatorLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.hotels_app_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.hotels_app_bar)");
        this.b = (AppBarLayoutWithTextAction) findViewById2;
        View findViewById3 = view.findViewById(R.id.hotels_find_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.hotels_find_button)");
        this.c = (Button) findViewById3;
        View findViewById4 = view.findViewById(R.id.select_city);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.select_city)");
        this.d = (Input) findViewById4;
        View findViewById5 = view.findViewById(R.id.select_dates);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.select_dates)");
        this.e = (Input) findViewById5;
        View findViewById6 = view.findViewById(R.id.select_guests);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.select_guests)");
        this.f = (Input) findViewById6;
        View findViewById7 = view.findViewById(R.id.hotels_info_1_title);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.hotels_info_1_title)");
        this.g = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.hotels_info_1_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.hotels_info_1_subtitle)");
        this.h = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.hotels_info_2_title);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.hotels_info_2_title)");
        this.i = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.hotels_info_2_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.hotels_info_2_subtitle)");
        this.j = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.hotels_info_3_title);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.hotels_info_3_title)");
        this.k = (TextView) findViewById11;
        View findViewById12 = view.findViewById(R.id.hotels_info_3_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.hotels_info_3_subtitle)");
        this.l = (TextView) findViewById12;
        View findViewById13 = view.findViewById(R.id.hotels_discount_banner);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "view.findViewById(R.id.hotels_discount_banner)");
        this.m = (RelativeLayout) findViewById13;
        View findViewById14 = view.findViewById(R.id.hotels_discount_banner_title);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "view.findViewById(R.id.h…ls_discount_banner_title)");
        this.n = (TextView) findViewById14;
        View findViewById15 = view.findViewById(R.id.hotels_discount_banner_description);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "view.findViewById(R.id.h…count_banner_description)");
        this.o = (TextView) findViewById15;
        View findViewById16 = view.findViewById(R.id.progress_view_container);
        Objects.requireNonNull(findViewById16, "null cannot be cast to non-null type android.view.ViewGroup");
        this.p = new ProgressOverlay((ViewGroup) findViewById16, R.id.hotels_content, analytics, false, 0, 24, null);
    }

    @Override // com.avito.android.short_term_rent.hotels.HotelsView
    @NotNull
    public Observable<Unit> dateFilterClicks() {
        Observable<Unit> create = Observable.create(new a(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…ext(Unit)\n        }\n    }");
        return create;
    }

    @Override // com.avito.android.short_term_rent.hotels.HotelsView
    public void fillFiltersWithData(@NotNull FiltersData filtersData) {
        String str;
        Intrinsics.checkNotNullParameter(filtersData, "filtersData");
        Input input = this.d;
        HotelsLocation location = filtersData.getLocation();
        if (location == null || (str = location.getName()) == null) {
            str = "";
        }
        Input.setText$default(input, str, false, 2, null);
        this.d.setState(Input.Companion.getSTATE_NORMAL());
        Input input2 = this.e;
        SpannableString spannableString = new SpannableString(StrDateUtilsKt.getHotelsFilterText(filtersData.getDates()));
        int calculateNightsBetween = StrDateUtilsKt.calculateNightsBetween(filtersData.getDates());
        SpannableString spannableString2 = new SpannableString(this.a.getResources().getQuantityString(R.plurals.hotels_plurals_nights, calculateNightsBetween, Integer.valueOf(calculateNightsBetween)));
        Context context = this.a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        spannableString2.setSpan(new ForegroundColorSpan(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray48)), 0, spannableString2.length(), 33);
        SpannableStringBuilder append = new SpannableStringBuilder().append((CharSequence) spannableString).append((CharSequence) spannableString2);
        Intrinsics.checkNotNullExpressionValue(append, "SpannableStringBuilder()…      .append(nightsText)");
        input2.setTextWithoutWatcher(append);
        int calculateGuests = FiltersDataKt.calculateGuests(filtersData.getPeople());
        this.f.setTextWithoutWatcher(this.a.getResources().getQuantityString(R.plurals.hotels_plurals_guests, calculateGuests, Integer.valueOf(calculateGuests)));
    }

    @Override // com.avito.android.short_term_rent.hotels.HotelsView
    public void fillFormWithData(@NotNull String str, @NotNull List<Information> list, @Nullable DiscountBanner discountBanner) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "information");
        this.b.setTitle(str);
        this.g.setText(list.get(0).getTitle());
        this.h.setText(list.get(0).getSubtitle());
        this.i.setText(list.get(1).getTitle());
        this.j.setText(list.get(1).getSubtitle());
        this.k.setText(list.get(2).getTitle());
        this.l.setText(list.get(2).getSubtitle());
        if (discountBanner != null) {
            this.m.setVisibility(0);
            this.n.setText(discountBanner.getTitle());
            this.o.setText(discountBanner.getDescription());
        }
    }

    @Override // com.avito.android.short_term_rent.hotels.HotelsView
    @NotNull
    public Observable<Unit> findButtonClicks() {
        Observable<Unit> create = Observable.create(new b(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…ext(Unit)\n        }\n    }");
        return create;
    }

    @Override // com.avito.android.short_term_rent.hotels.HotelsView
    @NotNull
    public Observable<Unit> guestsFilterClicks() {
        Observable<Unit> create = Observable.create(new c(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…ext(Unit)\n        }\n    }");
        return create;
    }

    @Override // com.avito.android.short_term_rent.hotels.HotelsView
    @NotNull
    public Observable<Unit> locationFilterClicks() {
        Observable<Unit> create = Observable.create(new d(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…ext(Unit)\n        }\n    }");
        return create;
    }

    @Override // com.avito.android.short_term_rent.hotels.HotelsView
    @NotNull
    public Observable<Unit> retryLoadingClicks() {
        Observable<Unit> create = Observable.create(new e(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…tter.onNext(Unit) }\n    }");
        return create;
    }

    @Override // com.avito.android.short_term_rent.hotels.HotelsView
    public void showContent() {
        this.p.showContent();
    }

    @Override // com.avito.android.short_term_rent.hotels.HotelsView
    public void showErrorInSnackBar(@Nullable String str) {
        Context context = this.a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        String string = context.getResources().getString(R.string.str_has_error_occurred);
        Intrinsics.checkNotNullExpressionValue(string, "rootView.context.resourc…g.str_has_error_occurred)");
        CoordinatorLayout coordinatorLayout = this.a;
        if (str == null) {
            str = string;
        }
        Snackbar.make(coordinatorLayout, str, -1).show();
    }

    @Override // com.avito.android.short_term_rent.hotels.HotelsView
    public void showLocationError() {
        this.d.setState(Input.Companion.getSTATE_ERROR());
        stopLoading();
    }

    @Override // com.avito.android.short_term_rent.hotels.HotelsView
    public void showProgress() {
        this.p.showLoading();
    }

    @Override // com.avito.android.short_term_rent.hotels.HotelsView
    public void showRetry() {
        this.b.setExpanded(false);
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.p, null, 1, null);
    }

    @Override // com.avito.android.short_term_rent.hotels.HotelsView
    public void stopLoading() {
        this.c.setLoading(false);
    }

    @Override // com.avito.android.short_term_rent.hotels.HotelsView
    @NotNull
    public Observable<Unit> upButtonClicks() {
        Observable<Unit> create = Observable.create(new HotelsViewImpl$upButtonClicks$1(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…        }\n        }\n    }");
        return create;
    }
}
