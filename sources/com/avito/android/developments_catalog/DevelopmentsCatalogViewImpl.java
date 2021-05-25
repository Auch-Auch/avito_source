package com.avito.android.developments_catalog;

import a2.g.r.g;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.advert_core.RetryListener;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.deprecated_design.R;
import com.avito.android.developments_catalog.items.contactbar.ContactsItem;
import com.avito.android.developments_catalog.items.contactbar.ContactsView;
import com.avito.android.developments_catalog.items.contactbar.PhoneCallListener;
import com.avito.android.lastclick.LastClick;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.DialogUtils;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.Formatter;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding3.view.RxMenuItem;
import com.jakewharton.rxbinding3.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010.\u001a\u00020+\u0012\b\u0010c\u001a\u0004\u0018\u00010`\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010D\u001a\u00020A\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00150'\u0012\u0006\u0010S\u001a\u00020P¢\u0006\u0004\bk\u0010lJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001d\u0010\f\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0005J\u0019\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0005J%\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00150'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010-R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\n0L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020\n0\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010j\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010i¨\u0006m"}, d2 = {"Lcom/avito/android/developments_catalog/DevelopmentsCatalogViewImpl;", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogView;", "Lio/reactivex/Observable;", "", "upButtonClicks", "()Lio/reactivex/Observable;", "showError", "()V", "setupToolbar", "", "Lcom/avito/conveyor_item/Item;", "items", "bindItems", "(Ljava/util/List;)V", "Lcom/avito/android/deep_linking/links/PhoneLink;", "phoneLink", "Lcom/avito/android/developments_catalog/items/contactbar/PhoneCallListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showPhoneCallConfirmation", "(Lcom/avito/android/deep_linking/links/PhoneLink;Lcom/avito/android/developments_catalog/items/contactbar/PhoneCallListener;)V", "shareButtonClicks", "", "title", "initContactButton", "(Ljava/lang/String;)V", "contactButtonClicks", "message", "Lkotlin/Function0;", "dismissCallback", "showLegalDisclaimerDialog", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "", "visible", AuthSource.SEND_ABUSE, "(Z)V", "Landroidx/appcompat/app/AlertDialog;", g.a, "Landroidx/appcompat/app/AlertDialog;", "phoneCallDialog", "Lcom/avito/android/util/Formatter;", "r", "Lcom/avito/android/util/Formatter;", "phoneNumberFormatter", "Landroid/view/View;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/view/View;", "view", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "contactButtonText", "d", "contactButton", "Landroidx/recyclerview/widget/LinearLayoutManager;", "f", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "", "i", "I", "contactBarOffset", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "p", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", VKApiConst.Q, "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "recyclerAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "", "k", "Ljava/util/List;", "recyclerItems", "Lcom/avito/android/advert_core/RetryListener;", "s", "Lcom/avito/android/advert_core/RetryListener;", "retryListener", "Landroid/app/Dialog;", "h", "Landroid/app/Dialog;", "legalDisclaimerDialog", "Lcom/avito/android/util/DialogRouter;", "o", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/konveyor/data_source/ListDataSource;", "l", "Lcom/avito/konveyor/data_source/ListDataSource;", "itemsDatasource", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;", "n", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;", "router", "Landroid/widget/FrameLayout;", "c", "Landroid/widget/FrameLayout;", "contactBar", "j", "Z", "isContactBarShown", "<init>", "(Landroid/view/View;Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;Lcom/avito/android/util/DialogRouter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/base/SafeRecyclerAdapter;Lcom/avito/android/util/Formatter;Lcom/avito/android/advert_core/RetryListener;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class DevelopmentsCatalogViewImpl implements DevelopmentsCatalogView {
    public final RecyclerView a;
    public final Toolbar b;
    public final FrameLayout c;
    public final View d;
    public final TextView e;
    public final LinearLayoutManager f;
    public AlertDialog g;
    public Dialog h;
    public int i;
    public boolean j;
    public List<Item> k;
    public final ListDataSource<Item> l;
    public final View m;
    public final DevelopmentsCatalogRouter n;
    public final DialogRouter o;
    public final AdapterPresenter p;
    public final SafeRecyclerAdapter q;
    public final Formatter<String> r;
    public final RetryListener s;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DevelopmentsCatalogViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DevelopmentsCatalogViewImpl developmentsCatalogViewImpl) {
            super(0);
            this.a = developmentsCatalogViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.s.onRetry();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DevelopmentsCatalogViewImpl a;
        public final /* synthetic */ Function0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(DevelopmentsCatalogViewImpl developmentsCatalogViewImpl, Function0 function0) {
            super(0);
            this.a = developmentsCatalogViewImpl;
            this.b = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Dialog dialog = this.a.h;
            if (dialog != null) {
                dialog.dismiss();
            }
            this.a.h = null;
            this.b.invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class c implements DialogInterface.OnDismissListener {
        public final /* synthetic */ DevelopmentsCatalogViewImpl a;
        public final /* synthetic */ Function0 b;

        public c(DevelopmentsCatalogViewImpl developmentsCatalogViewImpl, Function0 function0) {
            this.a = developmentsCatalogViewImpl;
            this.b = function0;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            this.b.invoke();
            this.a.h = null;
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ DevelopmentsCatalogViewImpl a;
        public final /* synthetic */ PhoneCallListener b;
        public final /* synthetic */ PhoneLink c;

        public d(DevelopmentsCatalogViewImpl developmentsCatalogViewImpl, PhoneCallListener phoneCallListener, PhoneLink phoneLink) {
            this.a = developmentsCatalogViewImpl;
            this.b = phoneCallListener;
            this.c = phoneLink;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            LastClick.Updater.update();
            this.b.onPhoneCallConfirmed();
            DevelopmentsCatalogRouter developmentsCatalogRouter = this.a.n;
            if (developmentsCatalogRouter != null) {
                developmentsCatalogRouter.makeCallSafely(this.c);
            }
        }
    }

    public static final class e implements DialogInterface.OnDismissListener {
        public final /* synthetic */ PhoneCallListener a;

        public e(PhoneCallListener phoneCallListener) {
            this.a = phoneCallListener;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            this.a.onPhoneCallDismissed();
            LastClick.Updater.update();
        }
    }

    public DevelopmentsCatalogViewImpl(@NotNull View view, @Nullable DevelopmentsCatalogRouter developmentsCatalogRouter, @NotNull DialogRouter dialogRouter, @NotNull AdapterPresenter adapterPresenter, @NotNull SafeRecyclerAdapter safeRecyclerAdapter, @NotNull Formatter<String> formatter, @NotNull RetryListener retryListener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(safeRecyclerAdapter, "recyclerAdapter");
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberFormatter");
        Intrinsics.checkNotNullParameter(retryListener, "retryListener");
        this.m = view;
        this.n = developmentsCatalogRouter;
        this.o = dialogRouter;
        this.p = adapterPresenter;
        this.q = safeRecyclerAdapter;
        this.r = formatter;
        this.s = retryListener;
        View findViewById = view.findViewById(R.id.developments_catalog_recycler);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.d…opments_catalog_recycler)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        View findViewById2 = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.b = (Toolbar) findViewById2;
        View findViewById3 = view.findViewById(R.id.floating_contact_bar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.c = (FrameLayout) findViewById3;
        View findViewById4 = view.findViewById(R.id.contact_bar_button);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.contact_bar_button)");
        this.d = findViewById4;
        View findViewById5 = view.findViewById(com.avito.android.ui_components.R.id.button_text);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(ui_components_R.id.button_text)");
        this.e = (TextView) findViewById5;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 1, false);
        this.f = linearLayoutManager;
        ArrayList arrayList = new ArrayList();
        this.k = arrayList;
        this.l = new ListDataSource<>(arrayList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(null);
    }

    public static final void access$updateContactBarState(DevelopmentsCatalogViewImpl developmentsCatalogViewImpl) {
        Integer buttonsVisibilityPercents;
        Iterator<Item> it = developmentsCatalogViewImpl.k.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (it.next() instanceof ContactsItem) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            int findFirstVisibleItemPosition = developmentsCatalogViewImpl.f.findFirstVisibleItemPosition();
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = developmentsCatalogViewImpl.a.findViewHolderForLayoutPosition(i2);
            if (!(findViewHolderForLayoutPosition instanceof ContactsView)) {
                findViewHolderForLayoutPosition = null;
            }
            ContactsView contactsView = (ContactsView) findViewHolderForLayoutPosition;
            int intValue = (contactsView == null || (buttonsVisibilityPercents = contactsView.getButtonsVisibilityPercents()) == null) ? 0 : buttonsVisibilityPercents.intValue();
            if (findFirstVisibleItemPosition < i2 || intValue != 0) {
                developmentsCatalogViewImpl.a(false);
            } else {
                developmentsCatalogViewImpl.a(true);
            }
        }
    }

    public final void a(boolean z) {
        float f2;
        if (this.j != z && this.c.getHeight() != 0 && !(!Views.isVisible(this.c))) {
            this.j = z;
            if (z) {
                f2 = 0.0f;
            } else {
                f2 = (float) this.i;
            }
            ViewPropertyAnimatorCompat duration = ViewCompat.animate(this.c).translationY(f2).setDuration(100);
            Intrinsics.checkNotNullExpressionValue(duration, "it");
            duration.setInterpolator(new LinearInterpolator());
            duration.start();
        }
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogView
    public void bindItems(@NotNull List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.k.clear();
        this.k.addAll(list);
        if (this.a.getAdapter() == null) {
            this.p.onDataSourceChanged(this.l);
            this.a.setAdapter(this.q);
            return;
        }
        RecyclerView.Adapter adapter = this.a.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogView
    @NotNull
    public Observable<Unit> contactButtonClicks() {
        return RxView.clicks(this.d);
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogView
    public void initContactButton(@Nullable String str) {
        if (str != null) {
            Views.setBackgroundCompat(this.d, com.avito.android.ui_components.R.drawable.bg_btn_flat_rds_green);
            this.e.setText(str);
            Context context = this.m.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            int colorByAttr = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.constantWhite);
            Drawable drawable = this.m.getContext().getDrawable(com.avito.android.ui_components.R.drawable.ic_rds_call_20);
            this.e.setCompoundDrawablesWithIntrinsicBounds(drawable != null ? DrawablesKt.wrapForTinting(drawable, colorByAttr) : null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.a.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.avito.android.developments_catalog.DevelopmentsCatalogViewImpl$initContactButton$1
                public final /* synthetic */ DevelopmentsCatalogViewImpl a;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.a = r1;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NotNull RecyclerView recyclerView, int i2, int i3) {
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    super.onScrolled(recyclerView, i2, i3);
                    DevelopmentsCatalogViewImpl.access$updateContactBarState(this.a);
                }
            });
        }
        this.c.measure(0, 0);
        int dimensionPixelSize = a2.b.a.a.a.u1(this.m, "view.context").getDimensionPixelSize(com.avito.android.ui_components.R.dimen.contact_bar_bottom_padding) + this.c.getMeasuredHeight();
        this.i = dimensionPixelSize;
        this.c.setTranslationY((float) dimensionPixelSize);
        Views.show(this.c);
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogView
    public void setupToolbar() {
        Toolbars.setBackIconByAttr(this.b, com.avito.android.lib.design.R.attr.black);
        if (!this.b.getMenu().hasVisibleItems()) {
            this.b.inflateMenu(R.menu.developments_catalog);
            Toolbars.tintMenuByAttr(this.b, com.avito.android.lib.design.R.attr.blue);
        }
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogView
    @NotNull
    public Observable<Unit> shareButtonClicks() {
        MenuItem findItem = this.b.getMenu().findItem(R.id.menu_share);
        if (findItem != null) {
            return RxMenuItem.clicks$default(findItem, null, 1, null);
        }
        throw new IllegalArgumentException("Toolbar was not inflated".toString());
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogView
    public void showError() {
        View view = this.m;
        String string = view.getResources().getString(R.string.network_retry_message_developments_catalog);
        Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString…age_developments_catalog)");
        Views.showCustomSnackbar$default(view, com.avito.android.advert_core.R.layout.network_retry, string, -2, com.avito.android.advert_core.R.id.advert_network_error_text, com.avito.android.advert_core.R.id.advert_network_error_retry, null, new a(this), 32, null);
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogView
    public void showLegalDisclaimerDialog(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(function0, "dismissCallback");
        if (!DialogUtils.isShowing(this.h)) {
            DialogRouter dialogRouter = this.o;
            String string = this.m.getResources().getString(R.string.disclaimer_clear);
            Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString….string.disclaimer_clear)");
            Dialog showNotifyingDialog$default = DialogRouter.DefaultImpls.showNotifyingDialog$default(dialogRouter, null, true, str, string, new b(this, function0), null, null, 97, null);
            this.h = showNotifyingDialog$default;
            if (showNotifyingDialog$default != null) {
                showNotifyingDialog$default.setOnDismissListener(new c(this, function0));
            }
        }
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogView
    public void showPhoneCallConfirmation(@NotNull PhoneLink phoneLink, @NotNull PhoneCallListener phoneCallListener) {
        Intrinsics.checkNotNullParameter(phoneLink, "phoneLink");
        Intrinsics.checkNotNullParameter(phoneCallListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!DialogUtils.isShowing(this.g)) {
            AlertDialog create = new AlertDialog.Builder(this.m.getContext()).setTitle(com.avito.android.advert_core.R.string.phone).setMessage(this.r.format(phoneLink.getPhone())).setPositiveButton(com.avito.android.ui_components.R.string.call, new d(this, phoneCallListener, phoneLink)).setOnDismissListener(new e(phoneCallListener)).create();
            this.g = create;
            if (create != null) {
                create.show();
            }
            phoneCallListener.onPhoneCallShown(phoneLink);
        }
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogView
    @NotNull
    public Observable<Unit> upButtonClicks() {
        return InteropKt.toV2(Toolbars.upClicks(this.b));
    }
}
