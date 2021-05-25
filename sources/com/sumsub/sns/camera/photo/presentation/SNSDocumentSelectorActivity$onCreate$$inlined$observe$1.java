package com.sumsub.sns.camera.photo.presentation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import androidx.lifecycle.Observer;
import com.sumsub.sns.camera.photo.R;
import com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorActivity;
import com.sumsub.sns.core.common.ExtensionsKt;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "com/sumsub/sns/core/common/ExtensionsKt$observe$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SNSDocumentSelectorActivity$onCreate$$inlined$observe$1<T> implements Observer<T> {
    public final /* synthetic */ SNSDocumentSelectorActivity a;

    public static final class a implements View.OnFocusChangeListener {
        public final /* synthetic */ SNSDocumentSelectorActivity$onCreate$$inlined$observe$1 a;

        public a(SNSDocumentSelectorActivity$onCreate$$inlined$observe$1 sNSDocumentSelectorActivity$onCreate$$inlined$observe$1) {
            this.a = sNSDocumentSelectorActivity$onCreate$$inlined$observe$1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            if (z) {
                SNSDocumentSelectorActivity.access$getEdCountry$p(this.a.a).setText((CharSequence) null);
            }
        }
    }

    public static final class b implements AdapterView.OnItemClickListener {
        public final /* synthetic */ SNSDocumentSelectorActivity$onCreate$$inlined$observe$1 a;

        public b(SNSDocumentSelectorActivity$onCreate$$inlined$observe$1 sNSDocumentSelectorActivity$onCreate$$inlined$observe$1) {
            this.a = sNSDocumentSelectorActivity$onCreate$$inlined$observe$1;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ExtensionsKt.hideKeyboard(SNSDocumentSelectorActivity.access$getEdCountry$p(this.a.a));
        }
    }

    public SNSDocumentSelectorActivity$onCreate$$inlined$observe$1(SNSDocumentSelectorActivity sNSDocumentSelectorActivity) {
        this.a = sNSDocumentSelectorActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        List list;
        Collection values;
        if (t != null) {
            T t2 = t;
            Map map = (Map) t2.component1();
            String str = (String) t2.component2();
            SNSDocumentSelectorActivity.access$getEdCountry$p(this.a).addTextChangedListener(new TextWatcher(this) { // from class: com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorActivity$onCreate$$inlined$observe$1$lambda$1
                public final /* synthetic */ SNSDocumentSelectorActivity$onCreate$$inlined$observe$1 a;

                {
                    this.a = r1;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(@Nullable Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
                    this.a.a.getViewModel().onCountrySelected(SNSDocumentSelectorActivity.access$getEdCountry$p(this.a.a).getText().toString());
                }
            });
            SNSDocumentSelectorActivity sNSDocumentSelectorActivity = this.a;
            int i = R.layout.sns_list_item;
            if (map == null || (values = map.values()) == null || (list = CollectionsKt___CollectionsKt.toList(values)) == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            SNSDocumentSelectorActivity.access$getEdCountry$p(this.a).setAdapter(new SNSDocumentSelectorActivity.BitapFilterAdapter(sNSDocumentSelectorActivity, i, list, 0, 8));
            SNSDocumentSelectorActivity.access$getEdCountry$p(this.a).setText(map != null ? (String) map.get(str) : null);
            SNSDocumentSelectorActivity.access$getEdCountry$p(this.a).setOnFocusChangeListener(new a(this));
            SNSDocumentSelectorActivity.access$getEdCountry$p(this.a).setOnItemClickListener(new b(this));
        }
    }
}
