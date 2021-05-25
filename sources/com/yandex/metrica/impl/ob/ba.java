package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.metrica.IParamsCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ba implements Parcelable {
    public static final Parcelable.Creator<ba> CREATOR = new Parcelable.Creator<ba>() { // from class: com.yandex.metrica.impl.ob.ba.1
        /* renamed from: a */
        public ba createFromParcel(Parcel parcel) {
            return new ba(parcel);
        }

        /* renamed from: a */
        public ba[] newArray(int i) {
            return new ba[i];
        }
    };
    @Nullable
    private ResultReceiver a;
    @Nullable
    private List<String> b;
    @NonNull
    private Map<String, String> c;

    public ba(@Nullable List<String> list, @Nullable Map<String, String> map, @Nullable ResultReceiver resultReceiver) {
        HashMap hashMap;
        this.b = list;
        this.a = resultReceiver;
        if (map != null) {
            hashMap = new HashMap(map);
        }
        this.c = hashMap;
    }

    public boolean a(@Nullable yb ybVar) {
        boolean isEmpty;
        boolean equals;
        if (dl.a((Collection) this.b)) {
            return true;
        }
        if (ybVar == null) {
            return false;
        }
        boolean z = true;
        for (String str : this.b) {
            if ("yandex_mobile_metrica_device_id".equals(str)) {
                isEmpty = TextUtils.isEmpty(ybVar.b);
            } else if ("yandex_mobile_metrica_uuid".equals(str)) {
                isEmpty = TextUtils.isEmpty(ybVar.a);
            } else if ("appmetrica_device_id_hash".equals(str)) {
                isEmpty = TextUtils.isEmpty(ybVar.d);
            } else if ("yandex_mobile_metrica_report_ad_url".equals(str)) {
                isEmpty = TextUtils.isEmpty(ybVar.g);
            } else if ("yandex_mobile_metrica_get_ad_url".equals(str)) {
                isEmpty = TextUtils.isEmpty(ybVar.f);
            } else if (IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS.equals(str)) {
                equals = this.c.equals(abq.a(ybVar.n));
                z &= equals;
            }
            equals = !isEmpty;
            z &= equals;
        }
        return z;
    }

    @NonNull
    public Map<String, String> b() {
        return this.c;
    }

    @Nullable
    public ResultReceiver c() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.yandex.metrica.CounterConfiguration.receiver", this.a);
        if (this.b != null) {
            bundle.putStringArrayList("com.yandex.metrica.CounterConfiguration.identifiersList", new ArrayList<>(this.b));
        }
        Map<String, String> map = this.c;
        if (map != null) {
            bundle.putString("com.yandex.metrica.CounterConfiguration.clidsForVerification", abq.a(map));
        }
        parcel.writeBundle(bundle);
    }

    public ba(Parcel parcel) {
        Bundle readBundle = parcel.readBundle(ab.class.getClassLoader());
        if (readBundle != null) {
            this.a = (ResultReceiver) readBundle.getParcelable("com.yandex.metrica.CounterConfiguration.receiver");
            this.b = readBundle.getStringArrayList("com.yandex.metrica.CounterConfiguration.identifiersList");
            this.c = abq.a(readBundle.getString("com.yandex.metrica.CounterConfiguration.clidsForVerification"));
            return;
        }
        this.c = new HashMap();
    }

    @Nullable
    public List<String> a() {
        return this.b;
    }
}
