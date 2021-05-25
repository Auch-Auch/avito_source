package com.avito.android.extended_profile;

import a2.a.a.q0.c;
import a2.a.a.q0.e;
import a2.a.a.q0.f;
import a2.a.a.q0.h;
import a2.a.a.q0.i;
import a2.a.a.q0.j;
import a2.a.a.q0.k;
import a2.a.a.q0.l;
import a2.a.a.q0.m;
import a2.a.a.q0.n;
import a2.a.a.q0.o;
import a2.g.r.g;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.Features;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.advert_core.contactbar.AdvertContactsBindListener;
import com.avito.android.advert_core.contactbar.AdvertContactsView;
import com.avito.android.advert_core.contactbar.AdvertContactsViewImpl;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.extended_profile.ExtendedProfileView;
import com.avito.android.extended_profile.ExtendedProfileViewModel;
import com.avito.android.extended_profile.adapter.CategoryAdvertGridItemDecoration;
import com.avito.android.extended_profile.adapter.ExtendedProfileListItem;
import com.avito.android.extended_profile.adapter.ExtendedProfileSpanLookup;
import com.avito.android.extended_profile.adapter.contact_bar.ContactBarItem;
import com.avito.android.extended_profile.adapter.contact_bar.ContactBarItemView;
import com.avito.android.extended_profile.tracker.ExtendedProfileTracker;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile_stuff.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.PaddingListDecoration;
import com.avito.android.util.Contexts;
import com.avito.android.util.ContextsKt;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Formatter;
import com.avito.android.util.RecyclerViewsKt;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TextViews;
import com.avito.android.util.Toolbars;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0001\u0012\u0006\u0010t\u001a\u000207\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010_\u001a\u00020\\\u0012\u0006\u0010c\u001a\u00020`\u0012\u0006\u0010~\u001a\u00020{\u0012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\t0\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010g\u001a\u00020d\u0012\u0006\u0010.\u001a\u00020\u000b\u0012\f\u0010L\u001a\b\u0012\u0004\u0012\u00020I0H\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u00102\u001a\u00020/\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012JY\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u000b2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000bH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\bR\u001e\u0010'\u001a\n %*\u0004\u0018\u00010$0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010<R\u0016\u0010?\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u00109R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020I0H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020R0Q8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010j\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010t\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u00109R\u0016\u0010v\u001a\u00020d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bu\u0010fR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010~\u001a\u00020{8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\u0017\u0010\u0001\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u00105R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0007\u0010\u0001R\u0018\u0010\u0001\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00109R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\t0\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewImpl;", "Lcom/avito/android/extended_profile/ExtendedProfileView;", "Lcom/avito/android/advert_core/contactbar/AdvertContactsBindListener;", "Landroid/view/MenuItem;", AuthSource.SEND_ABUSE, "()Landroid/view/MenuItem;", "", "c", "()V", "", "message", "", "maxWidthRes", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;I)V", "Lcom/avito/android/extended_profile/ExtendedProfileViewModel;", "viewModel", "observe", "(Lcom/avito/android/extended_profile/ExtendedProfileViewModel;)V", "text", "textResId", "actionText", "actionTextResId", "Lkotlin/Function0;", "onActionClick", "duration", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "type", "showSnackbar", "(Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)V", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "onContactBarBind", "(I)V", "clear", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "Landroid/content/res/Resources;", "resources", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "t", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "rvAdapter", "C", "I", "columnCount", "Lcom/avito/android/util/SchedulersFactory3;", "F", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory3", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "stubText", "Landroid/view/View;", "h", "Landroid/view/View;", "progress", "Landroid/content/Context;", "Landroid/content/Context;", "context", "k", "stubContainer", "Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", "contactsView", "Lio/reactivex/rxjava3/disposables/Disposable;", "s", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "Ldagger/Lazy;", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup;", "D", "Ldagger/Lazy;", "spanLookup", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileListItem;", "p", "Ljava/util/List;", "items", VKApiConst.VERSION, "Lcom/avito/android/extended_profile/ExtendedProfileViewModel;", "Landroidx/appcompat/app/AlertDialog;", "o", "Landroidx/appcompat/app/AlertDialog;", "phoneCallDialog", "Lcom/avito/android/extended_profile/ExtendedProfileView$Router;", "w", "Lcom/avito/android/extended_profile/ExtendedProfileView$Router;", "router", "Landroidx/lifecycle/LifecycleOwner;", "x", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "B", "Z", "isTablet", "r", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup;", "extendedProfileSpanLookup", "Landroid/app/Dialog;", "n", "Landroid/app/Dialog;", "progressDialog", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "e", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "rvLayoutManager", "u", "rootView", VKApiConst.Q, "isContactBarInitialized", "Lcom/avito/android/lib/design/button/Button;", "j", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "y", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "i", "errorMessage", "Lcom/avito/android/util/DialogRouter;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "refreshLayout", g.a, "errorContainer", "Landroidx/appcompat/widget/Toolbar;", "f", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/util/Formatter;", "z", "Lcom/avito/android/util/Formatter;", "phoneNumberFormatter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/view/View;Lcom/avito/android/extended_profile/ExtendedProfileViewModel;Lcom/avito/android/extended_profile/ExtendedProfileView$Router;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;Lcom/avito/android/util/Formatter;Lcom/avito/android/util/DialogRouter;ZILdagger/Lazy;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/Features;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileViewImpl implements ExtendedProfileView, AdvertContactsBindListener {
    public final DialogRouter A;
    public final boolean B;
    public final int C;
    public final Lazy<ExtendedProfileSpanLookup> D;
    public final AdapterPresenter E;
    public final SchedulersFactory3 F;
    public final Context a;
    public final Resources b;
    public final SwipeRefreshLayout c;
    public final RecyclerView d;
    public final RecyclerView.LayoutManager e;
    public final Toolbar f;
    public final View g;
    public final View h;
    public final TextView i;
    public final Button j;
    public final View k;
    public final TextView l;
    public final AdvertContactsView m;
    public Dialog n;
    public AlertDialog o;
    public List<? extends ExtendedProfileListItem> p = CollectionsKt__CollectionsKt.emptyList();
    public boolean q;
    public ExtendedProfileSpanLookup r;
    public Disposable s;
    public final SimpleRecyclerAdapter t;
    public final View u;
    public final ExtendedProfileViewModel v;
    public final ExtendedProfileView.Router w;
    public final LifecycleOwner x;
    public final CompositeSnackbarPresenter y;
    public final Formatter<String> z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            ExtendedProfileTracker.TrackFlow.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[2] = 2;
            iArr[3] = 3;
            ExtendedProfileTracker.TrackFlow.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[2] = 2;
            iArr2[3] = 3;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ExtendedProfileViewImpl a;

        public a(ExtendedProfileViewImpl extendedProfileViewImpl) {
            this.a = extendedProfileViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ExtendedProfileViewModel.DefaultImpls.loadData$default(this.a.v, false, 1, null);
        }
    }

    public static final class b implements MenuItem.OnMenuItemClickListener {
        public final /* synthetic */ ExtendedProfileViewImpl a;

        public b(ExtendedProfileViewImpl extendedProfileViewImpl) {
            this.a = extendedProfileViewImpl;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            return this.a.v.onShareMenuClick();
        }
    }

    public ExtendedProfileViewImpl(@NotNull View view, @NotNull ExtendedProfileViewModel extendedProfileViewModel, @NotNull ExtendedProfileView.Router router, @NotNull LifecycleOwner lifecycleOwner, @NotNull CompositeSnackbarPresenter compositeSnackbarPresenter, @NotNull Formatter<String> formatter, @NotNull DialogRouter dialogRouter, boolean z2, int i2, @NotNull Lazy<ExtendedProfileSpanLookup> lazy, @NotNull AdapterPresenter adapterPresenter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ItemBinder itemBinder, @NotNull Features features) {
        GridLayoutManager gridLayoutManager;
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(extendedProfileViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "snackbarPresenter");
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberFormatter");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        Intrinsics.checkNotNullParameter(lazy, "spanLookup");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory3");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(features, "features");
        this.u = view;
        this.v = extendedProfileViewModel;
        this.w = router;
        this.x = lifecycleOwner;
        this.y = compositeSnackbarPresenter;
        this.z = formatter;
        this.A = dialogRouter;
        this.B = z2;
        this.C = i2;
        this.D = lazy;
        this.E = adapterPresenter;
        this.F = schedulersFactory3;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.a = context;
        this.b = view.getResources();
        View findViewById = view.findViewById(R.id.swipe_refresh_layout);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById;
        this.c = swipeRefreshLayout;
        View findViewById2 = view.findViewById(R.id.recycler_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.d = recyclerView;
        View findViewById3 = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById3;
        this.f = toolbar;
        View findViewById4 = view.findViewById(R.id.info_container);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.g = findViewById4;
        View findViewById5 = view.findViewById(R.id.progress_container);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.h = findViewById5;
        View findViewById6 = view.findViewById(R.id.message);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.i = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.refresh_button);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById7;
        this.j = button;
        View findViewById8 = view.findViewById(R.id.stub_container);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.view.View");
        this.k = findViewById8;
        View findViewById9 = view.findViewById(R.id.stub_text);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.widget.TextView");
        this.l = (TextView) findViewById9;
        this.t = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        if (z2) {
            GridLayoutManager gridLayoutManager2 = new GridLayoutManager(context, i2, 1, false);
            ExtendedProfileSpanLookup extendedProfileSpanLookup = lazy.get();
            this.r = extendedProfileSpanLookup;
            gridLayoutManager2.setSpanSizeLookup(extendedProfileSpanLookup);
            gridLayoutManager = gridLayoutManager2;
        } else {
            gridLayoutManager = new LinearLayoutManager(context, 1, false);
        }
        this.e = gridLayoutManager;
        Context context2 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int[] pullRefreshColorScheme = ContextsKt.getPullRefreshColorScheme(context2);
        swipeRefreshLayout.setColorSchemeColors(Arrays.copyOf(pullRefreshColorScheme, pullRefreshColorScheme.length));
        Context context3 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context3, com.avito.android.lib.design.R.attr.white));
        swipeRefreshLayout.setOnRefreshListener(new a2.a.a.q0.b(this));
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new PaddingListDecoration(ViewSizeKt.getDp(0), ViewSizeKt.getDp(112), 0, 0, 12, null));
        if (z2) {
            recyclerView.addItemDecoration(new CategoryAdvertGridItemDecoration(i2, ViewSizeKt.getDp(16)));
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.avito.android.extended_profile.ExtendedProfileViewImpl$initRecyclerView$$inlined$with$lambda$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int i3, int i4) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrolled(recyclerView2, i3, i4);
                ExtendedProfileViewImpl.this.c();
            }
        });
        toolbar.inflateMenu(R.menu.extended_profile_menu);
        Toolbars.tintMenuByAttr(toolbar, com.avito.android.lib.design.R.attr.blue);
        toolbar.setNavigationOnClickListener(new c(this));
        this.m = new AdvertContactsViewImpl(view, false, true, this, features, null, null, 96, null);
        button.setOnClickListener(new a(this));
        a().setOnMenuItemClickListener(new b(this));
        observe(extendedProfileViewModel);
    }

    public static final void access$hideProgressAsDialog(ExtendedProfileViewImpl extendedProfileViewImpl) {
        extendedProfileViewImpl.u.post(new a2.a.a.q0.a(extendedProfileViewImpl));
    }

    public static final void access$onStartDraw(ExtendedProfileViewImpl extendedProfileViewImpl, ExtendedProfileTracker.TrackFlow trackFlow) {
        ExtendedProfileViewModel extendedProfileViewModel = extendedProfileViewImpl.v;
        int ordinal = trackFlow.ordinal();
        if (ordinal == 0) {
            extendedProfileViewModel.startProfileDraw();
        } else if (ordinal == 2) {
            extendedProfileViewModel.startExtendedProfileDraw();
        } else if (ordinal == 3) {
            extendedProfileViewModel.startExtendedProfileDraw();
        }
    }

    public static final void access$showData(ExtendedProfileViewImpl extendedProfileViewImpl) {
        Views.show(extendedProfileViewImpl.d);
        Views.hide(extendedProfileViewImpl.h);
        Views.hide(extendedProfileViewImpl.g);
        Views.hide(extendedProfileViewImpl.k);
        extendedProfileViewImpl.c.setRefreshing(false);
    }

    public static final void access$showError(ExtendedProfileViewImpl extendedProfileViewImpl, CharSequence charSequence) {
        Views.hide(extendedProfileViewImpl.d);
        Views.hide(extendedProfileViewImpl.h);
        Views.show(extendedProfileViewImpl.g);
        Views.hide(extendedProfileViewImpl.k);
        extendedProfileViewImpl.m.hide();
        TextViews.bindText$default(extendedProfileViewImpl.i, charSequence, false, 2, null);
        extendedProfileViewImpl.c.setRefreshing(false);
    }

    public static final void access$showItemsWithDiffUtil(ExtendedProfileViewImpl extendedProfileViewImpl, List list, ExtendedProfileTracker.TrackFlow trackFlow) {
        extendedProfileViewImpl.v.trackProfileDraw();
        extendedProfileViewImpl.v.trackExtendedProfileDraw();
        Disposable disposable = extendedProfileViewImpl.s;
        if (disposable != null) {
            disposable.dispose();
        }
        extendedProfileViewImpl.s = Observable.fromCallable(new j(extendedProfileViewImpl, list)).doOnSubscribe(new k(extendedProfileViewImpl, trackFlow)).subscribeOn(extendedProfileViewImpl.F.computation()).observeOn(extendedProfileViewImpl.F.mainThread()).subscribe(new l(extendedProfileViewImpl, list, trackFlow));
    }

    public static final void access$showPhoneCallConfirmation(ExtendedProfileViewImpl extendedProfileViewImpl, PhoneLink.Call call) {
        AlertDialog alertDialog = extendedProfileViewImpl.o;
        if (alertDialog == null || !alertDialog.isShowing()) {
            AlertDialog create = new AlertDialog.Builder(extendedProfileViewImpl.a).setTitle(com.avito.android.advert_core.R.string.phone).setMessage(extendedProfileViewImpl.z.format(call.getPhone())).setPositiveButton(com.avito.android.ui_components.R.string.call, new m(extendedProfileViewImpl, call)).setOnDismissListener(new n(extendedProfileViewImpl)).setOnCancelListener(new o(extendedProfileViewImpl)).create();
            extendedProfileViewImpl.o = create;
            if (create != null) {
                create.show();
            }
        }
    }

    public static final void access$showProgress(ExtendedProfileViewImpl extendedProfileViewImpl) {
        Views.hide(extendedProfileViewImpl.d);
        Views.show(extendedProfileViewImpl.h);
        Views.hide(extendedProfileViewImpl.g);
        Views.hide(extendedProfileViewImpl.k);
        extendedProfileViewImpl.m.hide();
        extendedProfileViewImpl.c.setRefreshing(false);
    }

    public static final void access$showProgressAsDialog(ExtendedProfileViewImpl extendedProfileViewImpl) {
        if (extendedProfileViewImpl.n == null) {
            extendedProfileViewImpl.n = extendedProfileViewImpl.A.showSimpleWaitingDialog();
        }
    }

    public static final void access$showUserBanned(ExtendedProfileViewImpl extendedProfileViewImpl, String str) {
        extendedProfileViewImpl.b(str, R.dimen.user_banned_message_width);
    }

    public static final void access$showUserRemoved(ExtendedProfileViewImpl extendedProfileViewImpl, String str) {
        extendedProfileViewImpl.b(str, R.dimen.user_removed_message_width);
    }

    public static final void access$trackDraw(ExtendedProfileViewImpl extendedProfileViewImpl, ExtendedProfileTracker.TrackFlow trackFlow) {
        ExtendedProfileViewModel extendedProfileViewModel = extendedProfileViewImpl.v;
        int ordinal = trackFlow.ordinal();
        if (ordinal == 0) {
            extendedProfileViewModel.trackProfileDraw();
        } else if (ordinal == 2) {
            extendedProfileViewModel.trackExtendedProfileDraw();
        } else if (ordinal == 3) {
            extendedProfileViewModel.trackExtendedProfileErrorDraw();
        }
    }

    public static final void access$updateItems(ExtendedProfileViewImpl extendedProfileViewImpl, List list) {
        ExtendedProfileSpanLookup extendedProfileSpanLookup;
        extendedProfileViewImpl.p = list;
        if (extendedProfileViewImpl.B && (extendedProfileSpanLookup = extendedProfileViewImpl.r) != null) {
            extendedProfileSpanLookup.setItems(list);
        }
        extendedProfileViewImpl.E.onDataSourceChanged(new ListDataSource(extendedProfileViewImpl.p));
        extendedProfileViewImpl.c.setRefreshing(false);
        RecyclerViewsKt.invalidateItemDecorationsSafely(extendedProfileViewImpl.d);
    }

    public final MenuItem a() {
        MenuItem findItem = this.f.getMenu().findItem(R.id.menu_share);
        if (findItem != null) {
            return findItem;
        }
        throw new IllegalArgumentException("Toolbar was not inflated".toString());
    }

    public final void b(String str, @DimenRes int i2) {
        Views.hide(this.d);
        Views.hide(this.h);
        Views.hide(this.g);
        this.c.setRefreshing(false);
        Views.show(this.k);
        this.m.hide();
        this.l.setMaxWidth(this.b.getDimensionPixelSize(i2));
        TextViews.bindText$default(this.l, str, false, 2, null);
    }

    public final void c() {
        Iterator<? extends ExtendedProfileListItem> it = this.p.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (((ExtendedProfileListItem) it.next()) instanceof ContactBarItem) {
                break;
            } else {
                i2++;
            }
        }
        if (this.q && i2 != -1) {
            RecyclerView.LayoutManager layoutManager = this.e;
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.d.findViewHolderForLayoutPosition(i2);
            if (!(findViewHolderForLayoutPosition instanceof ContactBarItemView)) {
                findViewHolderForLayoutPosition = null;
            }
            ContactBarItemView contactBarItemView = (ContactBarItemView) findViewHolderForLayoutPosition;
            int buttonsVisibilityPercents = contactBarItemView != null ? contactBarItemView.getButtonsVisibilityPercents() : 0;
            if (findFirstVisibleItemPosition < i2 || buttonsVisibilityPercents >= 1) {
                AdvertContactsView.DefaultImpls.animateShowHide$default(this.m, false, false, 2, null);
            } else {
                AdvertContactsView.DefaultImpls.animateShowHide$default(this.m, true, false, 2, null);
            }
        }
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileView
    public void clear() {
        Disposable disposable = this.s;
        if (disposable != null) {
            disposable.dispose();
        }
        this.s = null;
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileView
    public void observe(@NotNull ExtendedProfileViewModel extendedProfileViewModel) {
        Intrinsics.checkNotNullParameter(extendedProfileViewModel, "viewModel");
        extendedProfileViewModel.getDataToDisplayChanges().observe(this.x, new f(this));
        extendedProfileViewModel.getChangedItemsIndexes().observe(this.x, new a2.a.a.q0.g(this));
        extendedProfileViewModel.getViewEvents().observe(this.x, new i(this));
        extendedProfileViewModel.getSingleLiveEvents().observe(this.x, new h(this));
        extendedProfileViewModel.getContactActions().observe(this.x, new e(this));
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsBindListener
    public void onContactBarBind(int i2) {
        FrameLayout frameLayout;
        if (this.B && (frameLayout = (FrameLayout) this.u.findViewById(R.id.extended_profile_contact_bar)) != null) {
            frameLayout.setPadding(ViewSizeKt.getDp(6), 0, ViewSizeKt.getDp(6), ViewSizeKt.getDp(6));
        }
        this.q = true;
        c();
    }

    @Override // com.avito.android.lib.design.snackbar.util.SnackbarElementView
    public void showSnackbar(@NotNull String str, int i2, @Nullable String str2, int i3, @Nullable Function0<Unit> function0, int i4, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(snackbarType, "type");
        SnackbarExtensionsKt.showSnackbar(this.u, str, i2, str2, i3, function0, i4, snackbarPosition, snackbarType);
    }
}
