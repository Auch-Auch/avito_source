package com.avito.android.beduin.ui.fragment;

import a2.a.a.s.a.a.b;
import a2.a.a.s.a.a.d;
import a2.a.a.s.a.a.e;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.beduin.R;
import com.avito.android.beduin.di.BeduinDependencies;
import com.avito.android.beduin.di.DaggerBeduinFragmentComponent;
import com.avito.android.beduin.ui.adapter.BeduinAdapter;
import com.avito.android.beduin.ui.viewmodel.BeduinViewModel;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.ui.fragments.BaseFragment;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 02\u00020\u0001:\u000201B\u0007¢\u0006\u0004\b.\u0010/J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001d\u0010-\u001a\u00020(8B@\u0002X\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u00062"}, d2 = {"Lcom/avito/android/beduin/ui/fragment/BeduinFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/avito/android/beduin/ui/adapter/BeduinAdapter;", "beduinAdapter", "Lcom/avito/android/beduin/ui/adapter/BeduinAdapter;", "getBeduinAdapter$beduin_release", "()Lcom/avito/android/beduin/ui/adapter/BeduinAdapter;", "setBeduinAdapter$beduin_release", "(Lcom/avito/android/beduin/ui/adapter/BeduinAdapter;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "d", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/appcompat/widget/Toolbar;", "e", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/beduin/ui/viewmodel/BeduinViewModel;", "beduinViewModel", "Lcom/avito/android/beduin/ui/viewmodel/BeduinViewModel;", "getBeduinViewModel", "()Lcom/avito/android/beduin/ui/viewmodel/BeduinViewModel;", "setBeduinViewModel", "(Lcom/avito/android/beduin/ui/viewmodel/BeduinViewModel;)V", "Lcom/avito/android/beduin/ui/fragment/BeduinFragment$Params;", "c", "Lkotlin/Lazy;", "getParams", "()Lcom/avito/android/beduin/ui/fragment/BeduinFragment$Params;", "params", "<init>", "()V", "Companion", "Params", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public BeduinAdapter beduinAdapter;
    @Inject
    public BeduinViewModel beduinViewModel;
    public final Lazy c = c.lazy(new a(this));
    public ProgressOverlay d;
    public Toolbar e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/beduin/ui/fragment/BeduinFragment$Companion;", "", "Lcom/avito/android/beduin/ui/fragment/BeduinFragment$Params;", "params", "Lcom/avito/android/beduin/ui/fragment/BeduinFragment;", "create", "(Lcom/avito/android/beduin/ui/fragment/BeduinFragment$Params;)Lcom/avito/android/beduin/ui/fragment/BeduinFragment;", "<init>", "()V", "beduin_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final BeduinFragment create(@NotNull Params params) {
            Intrinsics.checkNotNullParameter(params, "params");
            BeduinFragment beduinFragment = new BeduinFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_params", params);
            Unit unit = Unit.INSTANCE;
            beduinFragment.setArguments(bundle);
            return beduinFragment;
        }

        public Companion(j jVar) {
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007¨\u0006#"}, d2 = {"Lcom/avito/android/beduin/ui/fragment/BeduinFragment$Params;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "url", "backIcon", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/avito/android/beduin/ui/fragment/BeduinFragment$Params;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUrl", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getBackIcon", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params implements Parcelable {
        public static final Parcelable.Creator<Params> CREATOR = new Creator();
        @NotNull
        public final String a;
        @Nullable
        public final Integer b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Params> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Params createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Params(parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Params[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(@NotNull String str, @DrawableRes @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(str, "url");
            this.a = str;
            this.b = num;
        }

        public static /* synthetic */ Params copy$default(Params params, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.a;
            }
            if ((i & 2) != 0) {
                num = params.b;
            }
            return params.copy(str, num);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final Integer component2() {
            return this.b;
        }

        @NotNull
        public final Params copy(@NotNull String str, @DrawableRes @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(str, "url");
            return new Params(str, num);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.a, params.a) && Intrinsics.areEqual(this.b, params.b);
        }

        @Nullable
        public final Integer getBackIcon() {
            return this.b;
        }

        @NotNull
        public final String getUrl() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.b;
            if (num != null) {
                i = num.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Params(url=");
            L.append(this.a);
            L.append(", backIcon=");
            return a2.b.a.a.a.p(L, this.b, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            Integer num = this.b;
            if (num != null) {
                parcel.writeInt(1);
                i2 = num.intValue();
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Params(String str, Integer num, int i, j jVar) {
            this(str, (i & 2) != 0 ? null : num);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            BeduinViewModel.BeduinEvent.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public static final class a extends Lambda implements Function0<Params> {
        public final /* synthetic */ BeduinFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BeduinFragment beduinFragment) {
            super(0);
            this.a = beduinFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Params invoke() {
            Parcelable parcelable = this.a.requireArguments().getParcelable("key_params");
            Intrinsics.checkNotNull(parcelable);
            return (Params) parcelable;
        }
    }

    public static final /* synthetic */ ProgressOverlay access$getProgressOverlay$p(BeduinFragment beduinFragment) {
        ProgressOverlay progressOverlay = beduinFragment.d;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        return progressOverlay;
    }

    public static final /* synthetic */ Toolbar access$getToolbar$p(BeduinFragment beduinFragment) {
        Toolbar toolbar = beduinFragment.e;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        return toolbar;
    }

    public static final String access$toErrorMessage(BeduinFragment beduinFragment, TypedError typedError) {
        Objects.requireNonNull(beduinFragment);
        return typedError instanceof ErrorWithMessage ? ((ErrorWithMessage) typedError).getMessage() : typedError.toString();
    }

    @NotNull
    public final BeduinAdapter getBeduinAdapter$beduin_release() {
        BeduinAdapter beduinAdapter2 = this.beduinAdapter;
        if (beduinAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beduinAdapter");
        }
        return beduinAdapter2;
    }

    @NotNull
    public final BeduinViewModel getBeduinViewModel() {
        BeduinViewModel beduinViewModel2 = this.beduinViewModel;
        if (beduinViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beduinViewModel");
        }
        return beduinViewModel2;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.beduin_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…agment, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        int i = R.id.beduin_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        Intrinsics.checkNotNullExpressionValue(recyclerView, "this");
        BeduinAdapter beduinAdapter2 = this.beduinAdapter;
        if (beduinAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beduinAdapter");
        }
        recyclerView.setAdapter(beduinAdapter2);
        View findViewById = view.findViewById(R.id.beduin_toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.beduin_toolbar)");
        Toolbar toolbar = (Toolbar) findViewById;
        this.e = toolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        setSupportActionBar(toolbar);
        toolbar.setTitle((CharSequence) null);
        Integer backIcon = ((Params) this.c.getValue()).getBackIcon();
        if (backIcon != null) {
            toolbar.setNavigationIcon(backIcon.intValue());
        }
        toolbar.setNavigationOnClickListener(new e(this));
        View findViewById2 = view.findViewById(R.id.beduin_content);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.beduin_content)");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById2, i, null, false, 0, 28, null);
        this.d = progressOverlay;
        progressOverlay.setOnRefreshListener(new d(this));
        BeduinViewModel beduinViewModel2 = this.beduinViewModel;
        if (beduinViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beduinViewModel");
        }
        beduinViewModel2.getScreenStateChanges().observe(getViewLifecycleOwner(), new a2.a.a.s.a.a.a(this));
        BeduinViewModel beduinViewModel3 = this.beduinViewModel;
        if (beduinViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beduinViewModel");
        }
        beduinViewModel3.getEvents().observe(getViewLifecycleOwner(), new b(this));
        BeduinViewModel beduinViewModel4 = this.beduinViewModel;
        if (beduinViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beduinViewModel");
        }
        beduinViewModel4.getFormUpdates().observe(getViewLifecycleOwner(), new a2.a.a.s.a.a.c(this));
    }

    public final void setBeduinAdapter$beduin_release(@NotNull BeduinAdapter beduinAdapter2) {
        Intrinsics.checkNotNullParameter(beduinAdapter2, "<set-?>");
        this.beduinAdapter = beduinAdapter2;
    }

    public final void setBeduinViewModel(@NotNull BeduinViewModel beduinViewModel2) {
        Intrinsics.checkNotNullParameter(beduinViewModel2, "<set-?>");
        this.beduinViewModel = beduinViewModel2;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        DaggerBeduinFragmentComponent.factory().create(this, ((Params) this.c.getValue()).getUrl(), (BeduinDependencies) ComponentDependenciesKt.getDependencies(BeduinDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        return true;
    }
}
