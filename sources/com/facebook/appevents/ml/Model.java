package com.facebook.appevents.ml;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public final class Model {
    public MTensor a;
    public MTensor b;
    public MTensor c;
    public MTensor d;
    public MTensor e;
    public MTensor f;
    public MTensor g;
    public MTensor h;
    public MTensor i;
    public MTensor j;
    public MTensor k;
    public final Map<String, MTensor> l = new HashMap();

    public class a extends HashSet<String> {
        public a(Model model) {
            add(ModelManager.Task.MTML_INTEGRITY_DETECT.toKey());
            add(ModelManager.Task.MTML_APP_EVENT_PREDICTION.toKey());
        }
    }

    public Model(Map<String, MTensor> map) {
        this.a = map.get("embed.weight");
        this.b = AppCompatDelegateImpl.i.c2(map.get("convs.0.weight"));
        this.c = AppCompatDelegateImpl.i.c2(map.get("convs.1.weight"));
        this.d = AppCompatDelegateImpl.i.c2(map.get("convs.2.weight"));
        this.e = map.get("convs.0.bias");
        this.f = map.get("convs.1.bias");
        this.g = map.get("convs.2.bias");
        this.h = AppCompatDelegateImpl.i.b2(map.get("fc1.weight"));
        this.i = AppCompatDelegateImpl.i.b2(map.get("fc2.weight"));
        this.j = map.get("fc1.bias");
        this.k = map.get("fc2.bias");
        Iterator it = new a(this).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String c3 = a2.b.a.a.a.c3(str, ".weight");
            String c32 = a2.b.a.a.a.c3(str, ".bias");
            MTensor mTensor = map.get(c3);
            MTensor mTensor2 = map.get(c32);
            if (mTensor != null) {
                this.l.put(c3, AppCompatDelegateImpl.i.b2(mTensor));
            }
            if (mTensor2 != null) {
                this.l.put(c32, mTensor2);
            }
        }
    }

    @Nullable
    public static Model build(File file) {
        HashMap hashMap;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int available = fileInputStream.available();
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            byte[] bArr = new byte[available];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            if (available >= 4) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, 4);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                int i2 = wrap.getInt();
                int i3 = i2 + 4;
                if (available >= i3) {
                    JSONObject jSONObject = new JSONObject(new String(bArr, 4, i2));
                    JSONArray names = jSONObject.names();
                    int length = names.length();
                    String[] strArr = new String[length];
                    for (int i4 = 0; i4 < length; i4++) {
                        strArr[i4] = names.getString(i4);
                    }
                    Arrays.sort(strArr);
                    hashMap = new HashMap();
                    a2.g.k.z.a aVar = new a2.g.k.z.a();
                    int i5 = 0;
                    while (true) {
                        if (i5 < length) {
                            String str = strArr[i5];
                            JSONArray jSONArray = jSONObject.getJSONArray(str);
                            int length2 = jSONArray.length();
                            int[] iArr = new int[length2];
                            int i6 = 1;
                            for (int i7 = 0; i7 < length2; i7++) {
                                iArr[i7] = jSONArray.getInt(i7);
                                i6 *= iArr[i7];
                            }
                            int i8 = i6 * 4;
                            int i9 = i3 + i8;
                            if (i9 > available) {
                                break;
                            }
                            ByteBuffer wrap2 = ByteBuffer.wrap(bArr, i3, i8);
                            wrap2.order(ByteOrder.LITTLE_ENDIAN);
                            MTensor mTensor = new MTensor(iArr);
                            wrap2.asFloatBuffer().get(mTensor.getData(), 0, i6);
                            if (aVar.containsKey(str)) {
                                str = (String) aVar.get(str);
                            }
                            hashMap.put(str, mTensor);
                            i5++;
                            i3 = i9;
                        }
                        return new Model(hashMap);
                    }
                }
            }
        } catch (Exception unused) {
        }
        hashMap = null;
        try {
            return new Model(hashMap);
        } catch (Exception unused2) {
            return null;
        }
    }

    @Nullable
    public MTensor predictOnMTML(MTensor mTensor, String[] strArr, String str) {
        MTensor mTensor2 = this.a;
        int length = strArr.length;
        int shape = mTensor2.getShape(1);
        MTensor mTensor3 = new MTensor(new int[]{length, 128, shape});
        float[] data = mTensor3.getData();
        float[] data2 = mTensor2.getData();
        for (int i2 = 0; i2 < length; i2++) {
            int[] iArr = new int[128];
            byte[] bytes = TextUtils.join(" ", strArr[i2].trim().split("\\s+")).getBytes(Charset.forName("UTF-8"));
            for (int i3 = 0; i3 < 128; i3++) {
                if (i3 < bytes.length) {
                    iArr[i3] = bytes[i3] & 255;
                } else {
                    iArr[i3] = 0;
                }
            }
            for (int i4 = 0; i4 < 128; i4++) {
                System.arraycopy(data2, iArr[i4] * shape, data, (shape * i4) + (shape * 128 * i2), shape);
            }
        }
        MTensor P = AppCompatDelegateImpl.i.P(mTensor3, this.b);
        AppCompatDelegateImpl.i.h(P, this.e);
        AppCompatDelegateImpl.i.P1(P);
        MTensor P2 = AppCompatDelegateImpl.i.P(P, this.c);
        AppCompatDelegateImpl.i.h(P2, this.f);
        AppCompatDelegateImpl.i.P1(P2);
        MTensor h1 = AppCompatDelegateImpl.i.h1(P2, 2);
        MTensor P3 = AppCompatDelegateImpl.i.P(h1, this.d);
        AppCompatDelegateImpl.i.h(P3, this.g);
        AppCompatDelegateImpl.i.P1(P3);
        int i5 = 1;
        MTensor h12 = AppCompatDelegateImpl.i.h1(P, P.getShape(1));
        MTensor h13 = AppCompatDelegateImpl.i.h1(h1, h1.getShape(1));
        MTensor h14 = AppCompatDelegateImpl.i.h1(P3, P3.getShape(1));
        AppCompatDelegateImpl.i.m0(h12, 1);
        AppCompatDelegateImpl.i.m0(h13, 1);
        AppCompatDelegateImpl.i.m0(h14, 1);
        MTensor[] mTensorArr = {h12, h13, h14, mTensor};
        int shape2 = mTensorArr[0].getShape(0);
        int i6 = 0;
        for (int i7 = 0; i7 < 4; i7++) {
            i6 += mTensorArr[i7].getShape(1);
        }
        MTensor mTensor4 = new MTensor(new int[]{shape2, i6});
        float[] data3 = mTensor4.getData();
        int i8 = 0;
        while (i8 < shape2) {
            int i9 = i8 * i6;
            int i10 = 0;
            while (i10 < 4) {
                float[] data4 = mTensorArr[i10].getData();
                int shape3 = mTensorArr[i10].getShape(i5);
                System.arraycopy(data4, i8 * shape3, data3, i9, shape3);
                i9 += shape3;
                i10++;
                i5 = 1;
            }
            i8++;
            i5 = 1;
        }
        MTensor d0 = AppCompatDelegateImpl.i.d0(mTensor4, this.h, this.j);
        AppCompatDelegateImpl.i.P1(d0);
        MTensor d02 = AppCompatDelegateImpl.i.d0(d0, this.i, this.k);
        AppCompatDelegateImpl.i.P1(d02);
        Map<String, MTensor> map = this.l;
        MTensor mTensor5 = map.get(str + ".weight");
        Map<String, MTensor> map2 = this.l;
        MTensor mTensor6 = map2.get(str + ".bias");
        if (mTensor5 == null || mTensor6 == null) {
            return null;
        }
        MTensor d03 = AppCompatDelegateImpl.i.d0(d02, mTensor5, mTensor6);
        int shape4 = d03.getShape(0);
        int shape5 = d03.getShape(1);
        float[] data5 = d03.getData();
        for (int i11 = 0; i11 < shape4; i11++) {
            int i12 = i11 * shape5;
            int i13 = i12 + shape5;
            float f2 = Float.MIN_VALUE;
            float f3 = 0.0f;
            for (int i14 = i12; i14 < i13; i14++) {
                if (data5[i14] > f2) {
                    f2 = data5[i14];
                }
            }
            for (int i15 = i12; i15 < i13; i15++) {
                data5[i15] = (float) Math.exp((double) (data5[i15] - f2));
            }
            for (int i16 = i12; i16 < i13; i16++) {
                f3 += data5[i16];
            }
            while (i12 < i13) {
                data5[i12] = data5[i12] / f3;
                i12++;
            }
        }
        return d03;
    }
}
