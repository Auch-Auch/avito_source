package com.avito.android.fees;

import a2.a.a.u0.a;
import a2.a.a.u0.b;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.fees.di.DaggerPackageFeeFragmentComponent;
import com.avito.android.fees.di.PackageFeeComponentDependencies;
import com.avito.android.fees.di.PackageFeeFragmentModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertFeesEntity;
import com.avito.android.remote.model.OwnedPackage;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.ui_components.R;
import com.avito.android.util.Bundles;
import com.avito.android.util.DialogUtils;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Views;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001:B\u0007¢\u0006\u0004\b9\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00192\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u0017J\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u0017J\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\u0017R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/avito/android/fees/PackageFeeFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/fees/PackageFeeView;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "onDetach", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "onLoadingStart", "onLoadingFinish", "", "message", "onLoadingError", "(Ljava/lang/String;)V", AuthSource.SEND_ABUSE, "", "Lcom/avito/android/remote/model/OwnedPackage;", "c", "Ljava/util/List;", "packages", "Landroid/app/Dialog;", "d", "Landroid/app/Dialog;", "dialog", "e", "Ljava/lang/String;", "Lcom/avito/android/fees/PackageFeePresenter;", "packageFeePresenter", "Lcom/avito/android/fees/PackageFeePresenter;", "getPackageFeePresenter", "()Lcom/avito/android/fees/PackageFeePresenter;", "setPackageFeePresenter", "(Lcom/avito/android/fees/PackageFeePresenter;)V", "Lcom/avito/android/fees/PackageFeeListener;", "f", "Lcom/avito/android/fees/PackageFeeListener;", "packageFeeListener", "<init>", "Factory", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class PackageFeeFragment extends BaseFragment implements PackageFeeView {
    public List<OwnedPackage> c;
    public Dialog d;
    public String e;
    public PackageFeeListener f;
    @Inject
    public PackageFeePresenter packageFeePresenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/fees/PackageFeeFragment$Factory;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "Lcom/avito/android/remote/model/OwnedPackage;", "packages", "message", "Lcom/avito/android/fees/PackageFeeFragment;", "create", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/fees/PackageFeeFragment;", "<init>", "()V", "fees_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ List c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, List list) {
                super(1);
                this.a = str;
                this.b = str2;
                this.c = list;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putString("key_fragment_item_id", this.a);
                bundle2.putString("key_fragment_message", this.b);
                Bundles.putParcelableList(bundle2, "key_fragment_packages", this.c);
                return Unit.INSTANCE;
            }
        }

        @NotNull
        public final PackageFeeFragment create(@NotNull String str, @NotNull List<OwnedPackage> list, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            Intrinsics.checkNotNullParameter(list, "packages");
            return (PackageFeeFragment) FragmentsKt.arguments(new PackageFeeFragment(), 3, new a(str, str2, list));
        }
    }

    public final void a() {
        Dialog dialog = this.d;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.d = null;
    }

    @NotNull
    public final PackageFeePresenter getPackageFeePresenter() {
        PackageFeePresenter packageFeePresenter2 = this.packageFeePresenter;
        if (packageFeePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("packageFeePresenter");
        }
        return packageFeePresenter2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.f = (PackageFeeListener) context;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle requireArguments = requireArguments();
        this.e = requireArguments.getString("key_fragment_message");
        List<OwnedPackage> parcelableList = Bundles.getParcelableList(requireArguments, "key_fragment_packages");
        if (parcelableList == null) {
            parcelableList = CollectionsKt__CollectionsKt.emptyList();
        }
        this.c = parcelableList;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fr_fees_packages, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ckages, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        PackageFeePresenter packageFeePresenter2 = this.packageFeePresenter;
        if (packageFeePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("packageFeePresenter");
        }
        packageFeePresenter2.unsubscribe();
        a();
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f = null;
    }

    @Override // com.avito.android.fees.PackageFeeView
    public void onLoadingError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        a();
        Context context = getContext();
        if (context != null) {
            ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
        }
    }

    @Override // com.avito.android.fees.PackageFeeView
    public void onLoadingFinish() {
        a();
        PackageFeeListener packageFeeListener = this.f;
        if (packageFeeListener != null) {
            packageFeeListener.onActivationDone();
        }
    }

    @Override // com.avito.android.fees.PackageFeeView
    public void onLoadingStart() {
        if (this.d == null) {
            this.d = DialogUtils.showSimpleWaitingDialog(getContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        int i;
        boolean z;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.message);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        boolean z2 = false;
        TextViews.bindText$default((TextView) findViewById, this.e, false, 2, null);
        View findViewById2 = view.findViewById(R.id.packages_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) findViewById2;
        float dimension = getResources().getDimension(R.dimen.card_margin);
        LayoutInflater from = LayoutInflater.from(linearLayout.getContext());
        List<OwnedPackage> list = this.c;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("packages");
        }
        for (OwnedPackage ownedPackage : list) {
            Intrinsics.checkNotNullExpressionValue(from, "layoutInflater");
            View inflate = from.inflate(R.layout.owned_package, linearLayout, z2);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            View findViewById3 = inflate.findViewById(R.id.placement_counter);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById3).setText(ownedPackage.getCountDetails());
            View findViewById4 = inflate.findViewById(R.id.days_counter);
            Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById4).setText(ownedPackage.getDaysLeft());
            View findViewById5 = inflate.findViewById(R.id.location);
            Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
            AdvertFeesEntity location = ownedPackage.getLocation();
            ((TextView) findViewById5).setText(location.getTitle());
            List<AdvertFeesEntity> restrictions = ownedPackage.getRestrictions();
            AdvertFeesEntity advertFeesEntity = (AdvertFeesEntity) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) restrictions);
            View findViewById6 = inflate.findViewById(R.id.category);
            Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) findViewById6;
            if (advertFeesEntity == null) {
                Views.hide(textView);
            } else {
                Views.show(textView);
                textView.setText(advertFeesEntity.getTitle());
            }
            View findViewById7 = inflate.findViewById(R.id.expanding_button);
            Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.Button");
            Button button = (Button) findViewById7;
            boolean z3 = true;
            if (ownedPackage.getRestrictions().size() <= 1 && !ownedPackage.getLocation().hasDetails()) {
                List<AdvertFeesEntity> restrictions2 = ownedPackage.getRestrictions();
                if (!(restrictions2 instanceof Collection) || !restrictions2.isEmpty()) {
                    Iterator<T> it = restrictions2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().hasDetails()) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    z3 = false;
                }
            }
            if (z3) {
                Views.show(button);
                button.setOnClickListener(new a(this, location, restrictions));
            } else {
                Views.hide(button);
            }
            View findViewById8 = inflate.findViewById(R.id.placement_progress);
            Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.ProgressBar");
            ProgressBar progressBar = (ProgressBar) findViewById8;
            int countPercentage = ownedPackage.getCountPercentage();
            if (countPercentage >= 0 && 10 >= countPercentage) {
                i = R.drawable.fees_progress_red;
            } else if (11 <= countPercentage && 30 >= countPercentage) {
                i = R.drawable.fees_progress_orange;
            } else {
                i = R.drawable.fees_progress_green;
            }
            progressBar.setProgressDrawable(inflate.getContext().getDrawable(i));
            progressBar.setMax(100);
            progressBar.setProgress((countPercentage * 100) / 100);
            inflate.findViewById(R.id.package_top_container).setOnClickListener(new b(this, ownedPackage));
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = Math.round(dimension);
            linearLayout.addView(inflate, marginLayoutParams);
            z2 = false;
        }
        View findViewById9 = view.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        setSupportActionBar((Toolbar) findViewById9);
        PackageFeePresenter packageFeePresenter2 = this.packageFeePresenter;
        if (packageFeePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("packageFeePresenter");
        }
        packageFeePresenter2.subscribe(this);
    }

    public final void setPackageFeePresenter(@NotNull PackageFeePresenter packageFeePresenter2) {
        Intrinsics.checkNotNullParameter(packageFeePresenter2, "<set-?>");
        this.packageFeePresenter = packageFeePresenter2;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        String string = requireArguments().getString("key_fragment_item_id");
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "requireArguments().getString(KEY_ADVERT_ID)!!");
        DaggerPackageFeeFragmentComponent.builder().dependencies((PackageFeeComponentDependencies) ComponentDependenciesKt.getDependencies(PackageFeeComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).packageFeeFragmentModule(new PackageFeeFragmentModule(string, this)).build().inject(this);
        return true;
    }
}
