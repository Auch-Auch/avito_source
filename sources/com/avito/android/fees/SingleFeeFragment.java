package com.avito.android.fees;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.deprecated_design.R;
import com.avito.android.fees.utils.FeesAttributedTextUtils;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.SingleFee;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ViewUtils;
import com.avito.android.util.text.AttributedTextFormatterImpl;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b'\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/fees/SingleFeeFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDetach", "()V", "Lcom/avito/android/remote/model/Action;", "d", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/SingleFee;", "c", "Lcom/avito/android/remote/model/SingleFee;", "singleFee", "", "e", "Ljava/lang/String;", "message", "Lcom/avito/android/fees/SingleFeeListener;", "f", "Lcom/avito/android/fees/SingleFeeListener;", "singleFeeListener", "<init>", "Factory", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class SingleFeeFragment extends BaseFragment {
    public SingleFee c;
    public Action d;
    public String e;
    public SingleFeeListener f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/fees/SingleFeeFragment$Factory;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/remote/model/SingleFee;", "singleFee", "message", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/fees/SingleFeeFragment;", "create", "(Ljava/lang/String;Lcom/avito/android/remote/model/SingleFee;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)Lcom/avito/android/fees/SingleFeeFragment;", "<init>", "()V", "fees_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;
            public final /* synthetic */ SingleFee b;
            public final /* synthetic */ String c;
            public final /* synthetic */ Action d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, SingleFee singleFee, String str2, Action action) {
                super(1);
                this.a = str;
                this.b = singleFee;
                this.c = str2;
                this.d = action;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putString("key_fragment_item_id", this.a);
                bundle2.putParcelable("key_fragment_single_fee", this.b);
                bundle2.putString("key_fragment_message", this.c);
                bundle2.putParcelable("key_fragment_action", this.d);
                return Unit.INSTANCE;
            }
        }

        @NotNull
        public final SingleFeeFragment create(@NotNull String str, @NotNull SingleFee singleFee, @Nullable String str2, @NotNull Action action) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            Intrinsics.checkNotNullParameter(singleFee, "singleFee");
            Intrinsics.checkNotNullParameter(action, "action");
            return (SingleFeeFragment) FragmentsKt.arguments(new SingleFeeFragment(), 4, new a(str, singleFee, str2, action));
        }
    }

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
                SingleFeeListener singleFeeListener = ((SingleFeeFragment) this.b).f;
                if (singleFeeListener != null) {
                    singleFeeListener.showInfo();
                }
            } else if (i == 1) {
                SingleFeeListener singleFeeListener2 = ((SingleFeeFragment) this.b).f;
                if (singleFeeListener2 != null) {
                    singleFeeListener2.showPayment(SingleFeeFragment.access$getAction$p((SingleFeeFragment) this.b).getDeepLink());
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ View a;

        public b(View view) {
            this.a = view;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            View view = this.a;
            Intrinsics.checkNotNullExpressionValue(view, "continueBtn");
            view.setEnabled(z);
        }
    }

    public static final /* synthetic */ Action access$getAction$p(SingleFeeFragment singleFeeFragment) {
        Action action = singleFeeFragment.d;
        if (action == null) {
            Intrinsics.throwUninitializedPropertyAccessException("action");
        }
        return action;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.f = (SingleFeeListener) context;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNull(requireArguments.getString("key_fragment_item_id"));
        this.e = requireArguments.getString("key_fragment_message");
        Parcelable parcelable = requireArguments.getParcelable("key_fragment_single_fee");
        Intrinsics.checkNotNull(parcelable);
        this.c = (SingleFee) parcelable;
        Parcelable parcelable2 = requireArguments.getParcelable("key_fragment_action");
        Intrinsics.checkNotNull(parcelable2);
        this.d = (Action) parcelable2;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fr_fees_single, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…single, container, false)");
        return inflate;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f = null;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x005c: APUT  
      (r4v0 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Integer : 0x0058: INVOKE  (r5v2 java.lang.Integer) = 
      (wrap: int : 0x0054: INVOKE  (r5v1 int) = (r5v0 com.avito.android.remote.model.SingleFee) type: VIRTUAL call: com.avito.android.remote.model.SingleFee.getPrice():int)
     type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        setSupportActionBar((Toolbar) findViewById);
        View findViewById2 = view.findViewById(R.id.message);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ViewUtils.INSTANCE.bindText((TextView) findViewById2, this.e);
        view.findViewById(R.id.btn_about_listing_fees).setOnClickListener(new a(0, this));
        View findViewById3 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById3;
        int i = R.string.fees_price_short;
        Object[] objArr = new Object[1];
        SingleFee singleFee = this.c;
        if (singleFee == null) {
            Intrinsics.throwUninitializedPropertyAccessException("singleFee");
        }
        objArr[0] = Integer.valueOf(singleFee.getPrice());
        textView.setText(getString(i, objArr));
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
        View findViewById4 = requireView.findViewById(R.id.agreement_text);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById4;
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        SingleFeeFragment$initializeUserAgreementTextView$onDeepLinkClickListener$1 singleFeeFragment$initializeUserAgreementTextView$onDeepLinkClickListener$1 = new OnDeepLinkClickListener() { // from class: com.avito.android.fees.SingleFeeFragment$initializeUserAgreementTextView$onDeepLinkClickListener$1
            @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
            public void onDeepLinkClick(@NotNull DeepLink deepLink) {
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                SingleFeeListener singleFeeListener = SingleFeeFragment.this.f;
                if (singleFeeListener != null) {
                    singleFeeListener.onDeepLinkClick(deepLink);
                }
            }
        };
        View requireView2 = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView2, "requireView()");
        Resources resources = requireView2.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "requireView().resources");
        textView2.setText(new AttributedTextFormatterImpl().format(FeesAttributedTextUtils.generateFeeAgreementAttributedText(resources, singleFeeFragment$initializeUserAgreementTextView$onDeepLinkClickListener$1)));
        View findViewById5 = view.findViewById(R.id.continue_button);
        findViewById5.setOnClickListener(new a(1, this));
        View findViewById6 = view.findViewById(R.id.agreement_checkbox);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.CheckBox");
        ((CheckBox) findViewById6).setOnCheckedChangeListener(new b(findViewById5));
    }
}
