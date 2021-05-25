package com.avito.android.fees;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.deprecated_design.R;
import com.avito.android.remote.model.AdvertFeesEntity;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.Bundles;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.TextViews;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00128\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/avito/android/fees/PackageParamsFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "Lcom/avito/android/remote/model/AdvertFeesEntity;", "d", "Ljava/util/List;", "restrictions", "c", "Lcom/avito/android/remote/model/AdvertFeesEntity;", "location", "<init>", "()V", "Factory", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class PackageParamsFragment extends BaseFragment {
    public AdvertFeesEntity c;
    public List<AdvertFeesEntity> d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/fees/PackageParamsFragment$Factory;", "", "Lcom/avito/android/remote/model/AdvertFeesEntity;", "location", "", "restrictions", "Lcom/avito/android/fees/PackageParamsFragment;", "create", "(Lcom/avito/android/remote/model/AdvertFeesEntity;Ljava/util/List;)Lcom/avito/android/fees/PackageParamsFragment;", "<init>", "()V", "fees_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ AdvertFeesEntity a;
            public final /* synthetic */ List b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(AdvertFeesEntity advertFeesEntity, List list) {
                super(1);
                this.a = advertFeesEntity;
                this.b = list;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable("key_fragment_location", this.a);
                Bundles.putParcelableList(bundle2, "key_fragment_restrictions", this.b);
                return Unit.INSTANCE;
            }
        }

        @NotNull
        public final PackageParamsFragment create(@NotNull AdvertFeesEntity advertFeesEntity, @NotNull List<AdvertFeesEntity> list) {
            Intrinsics.checkNotNullParameter(advertFeesEntity, "location");
            Intrinsics.checkNotNullParameter(list, "restrictions");
            return (PackageParamsFragment) FragmentsKt.arguments(new PackageParamsFragment(), 2, new a(advertFeesEntity, list));
        }
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle requireArguments = requireArguments();
        Parcelable parcelable = requireArguments.getParcelable("key_fragment_location");
        Intrinsics.checkNotNull(parcelable);
        this.c = (AdvertFeesEntity) parcelable;
        List<AdvertFeesEntity> parcelableList = Bundles.getParcelableList(requireArguments, "key_fragment_restrictions");
        if (parcelableList == null) {
            parcelableList = CollectionsKt__CollectionsKt.emptyList();
        }
        this.d = parcelableList;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.package_params, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        View findViewById = inflate.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        AdvertFeesEntity advertFeesEntity = this.c;
        if (advertFeesEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("location");
        }
        textView.setText(advertFeesEntity.getTitle());
        View findViewById2 = inflate.findViewById(R.id.details);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById2;
        AdvertFeesEntity advertFeesEntity2 = this.c;
        if (advertFeesEntity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("location");
        }
        TextViews.bindText$default(textView2, advertFeesEntity2.getDetails(), false, 2, null);
        View findViewById3 = inflate.findViewById(R.id.linear_layout);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) findViewById3;
        List<AdvertFeesEntity> list = this.d;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restrictions");
        }
        for (AdvertFeesEntity advertFeesEntity3 : list) {
            View inflate2 = layoutInflater.inflate(R.layout.package_params_item, (ViewGroup) linearLayout, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "itemView");
            View findViewById4 = inflate2.findViewById(R.id.title);
            Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById4).setText(advertFeesEntity3.getTitle());
            View findViewById5 = inflate2.findViewById(R.id.details);
            Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
            TextViews.bindText$default((TextView) findViewById5, advertFeesEntity3.getDetails(), false, 2, null);
            linearLayout.addView(inflate2);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        setSupportActionBar((Toolbar) findViewById);
    }
}
