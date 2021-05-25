package com.avito.android.toggle;

import android.content.SharedPreferences;
import com.avito.android.toggle.MutableFeatures;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/avito/android/toggle/MutableFeatures$1$1", "Lcom/avito/android/toggle/PrefsFeature;", "", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "features_release"}, k = 1, mv = {1, 4, 2})
public final class MutableFeatures$1$1 extends PrefsFeature<Object> {
    public final /* synthetic */ MutableFeatures.a c;
    public final /* synthetic */ Feature d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutableFeatures$1$1(MutableFeatures.a aVar, Feature feature, Feature feature2, SharedPreferences sharedPreferences) {
        super(feature2, sharedPreferences);
        this.c = aVar;
        this.d = feature;
    }

    @Override // com.avito.android.toggle.PrefsFeature, com.avito.android.toggle.MutableFeature, com.avito.android.toggle.Feature
    @NotNull
    public Object getValue() {
        return super.getValue();
    }

    @Override // com.avito.android.toggle.PrefsFeature, com.avito.android.toggle.MutableFeature
    public void setValue(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        if (this.c.a.isValueValid(this.d, obj)) {
            super.setValue(obj);
            return;
        }
        throw new IllegalArgumentException("Value " + obj + " for feature " + getKey() + " is not valid");
    }
}
