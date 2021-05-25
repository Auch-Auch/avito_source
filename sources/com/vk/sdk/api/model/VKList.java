package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.vk.sdk.api.model.Identifiable;
import com.vk.sdk.api.model.VKApiModel;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
public class VKList<T extends VKApiModel & Parcelable & Identifiable> extends VKApiModel implements List<T>, Parcelable {
    public static Parcelable.Creator<VKList> CREATOR = new a();
    public ArrayList<T> c = new ArrayList<>();
    public int d = -1;

    public interface Parser<D> {
        D parseObject(JSONObject jSONObject) throws Exception;
    }

    public static final class ReflectParser<D extends VKApiModel> implements Parser<D> {
        public final Class<? extends D> a;

        public ReflectParser(Class<? extends D> cls) {
            this.a = cls;
        }

        @Override // com.vk.sdk.api.model.VKList.Parser
        public D parseObject(JSONObject jSONObject) throws Exception {
            try {
                Constructor<? extends D> constructor = this.a.getConstructor(JSONObject.class);
                if (constructor != null) {
                    return (D) ((VKApiModel) constructor.newInstance(jSONObject));
                }
            } catch (Exception unused) {
            }
            return (D) ((VKApiModel) this.a.newInstance()).parse(jSONObject);
        }
    }

    public static class a implements Parcelable.Creator<VKList> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKList createFromParcel(Parcel parcel) {
            return new VKList(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKList[] newArray(int i) {
            return new VKList[i];
        }
    }

    public VKList() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.vk.sdk.api.model.VKList<T extends com.vk.sdk.api.model.VKApiModel & android.os.Parcelable & com.vk.sdk.api.model.Identifiable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        add(i, (int) ((VKApiModel) obj));
    }

    public void addAfter(int i, T t) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (get(i2).getId() > i || i2 == size - 1) {
                add(i2 + 1, (int) t);
                return;
            }
        }
    }

    @Override // java.util.List
    public boolean addAll(int i, @NonNull Collection<? extends T> collection) {
        return this.c.addAll(i, collection);
    }

    public void addBefore(int i, T t) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (get(i2).getId() > i || i2 == size - 1) {
                add(i2, (int) t);
                return;
            }
        }
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.c.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.c.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.c.containsAll(collection);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object, java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return getClass().equals(obj.getClass()) && this.c.equals(obj);
    }

    public void fill(JSONObject jSONObject, Class<? extends T> cls) {
        if (jSONObject.has(CommonKt.EXTRA_RESPONSE)) {
            JSONArray optJSONArray = jSONObject.optJSONArray(CommonKt.EXTRA_RESPONSE);
            if (optJSONArray != null) {
                fill(optJSONArray, cls);
            } else {
                fill(jSONObject.optJSONObject(CommonKt.EXTRA_RESPONSE), cls);
            }
        } else {
            fill(jSONObject, new ReflectParser(cls));
        }
    }

    public T getById(int i) {
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (next.getId() == i) {
                return next;
            }
        }
        return null;
    }

    public int getCount() {
        int i = this.d;
        return i != -1 ? i : size();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.c.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NonNull
    public Iterator<T> iterator() {
        return this.c.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.c.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.c.listIterator();
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiModel parse(JSONObject jSONObject) throws JSONException {
        throw new JSONException("Operation is not supported while class is generic");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        return this.c.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        return this.c.retainAll(collection);
    }

    public VKList<T> search(String str) {
        VKList<T> vKList = new VKList<>();
        Pattern compile = Pattern.compile("(?i).*\\b" + str + ".*");
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (compile.matcher(next.toString()).find()) {
                vKList.add((VKList<T>) next);
            }
        }
        return vKList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.vk.sdk.api.model.VKList<T extends com.vk.sdk.api.model.VKApiModel & android.os.Parcelable & com.vk.sdk.api.model.Identifiable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        return set(i, (int) ((VKApiModel) obj));
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.c.size();
    }

    @Override // java.util.List
    @NonNull
    public List<T> subList(int i, int i2) {
        return this.c.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    @NonNull
    public Object[] toArray() {
        return this.c.toArray();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.c.size());
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            parcel.writeParcelable(it.next(), i);
        }
        parcel.writeInt(this.d);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.vk.sdk.api.model.VKList<T extends com.vk.sdk.api.model.VKApiModel & android.os.Parcelable & com.vk.sdk.api.model.Identifiable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((VKList<T>) ((VKApiModel) obj));
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NonNull Collection<? extends T> collection) {
        return this.c.addAll(collection);
    }

    @Override // java.util.List
    public T get(int i) {
        return this.c.get(i);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<T> listIterator(int i) {
        return this.c.listIterator(i);
    }

    @Override // java.util.List
    public T remove(int i) {
        return this.c.remove(i);
    }

    public T set(int i, T t) {
        return this.c.set(i, t);
    }

    @Override // java.util.List, java.util.Collection
    @NonNull
    public <T1> T1[] toArray(@NonNull T1[] t1Arr) {
        return (T1[]) this.c.toArray(t1Arr);
    }

    public void add(int i, T t) {
        this.c.add(i, t);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.c.remove(obj);
    }

    public VKList(List<? extends T> list) {
        this.c = new ArrayList<>(list);
    }

    public boolean add(T t) {
        return this.c.add(t);
    }

    public void fill(JSONArray jSONArray, Class<? extends T> cls) {
        fill(jSONArray, new ReflectParser(cls));
    }

    public void fill(JSONObject jSONObject, Parser<? extends T> parser) {
        if (jSONObject != null) {
            fill(jSONObject.optJSONArray("items"), parser);
            this.d = jSONObject.optInt("count", this.d);
        }
    }

    public VKList(JSONObject jSONObject, Class<? extends T> cls) {
        fill(jSONObject, cls);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.ArrayList<T extends com.vk.sdk.api.model.VKApiModel & android.os.Parcelable & com.vk.sdk.api.model.Identifiable> */
    /* JADX WARN: Multi-variable type inference failed */
    public void fill(JSONArray jSONArray, Parser<? extends T> parser) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    VKApiModel vKApiModel = (VKApiModel) parser.parseObject(jSONArray.getJSONObject(i));
                    if (vKApiModel != null) {
                        this.c.add(vKApiModel);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public VKList(JSONArray jSONArray, Class<? extends T> cls) {
        fill(jSONArray, cls);
    }

    public VKList(JSONObject jSONObject, Parser<T> parser) {
        fill(jSONObject, parser);
    }

    public VKList(JSONArray jSONArray, Parser<T> parser) {
        fill(jSONArray, parser);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.ArrayList<T extends com.vk.sdk.api.model.VKApiModel & android.os.Parcelable & com.vk.sdk.api.model.Identifiable> */
    /* JADX WARN: Multi-variable type inference failed */
    public VKList(Parcel parcel) {
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.c.add((VKApiModel) parcel.readParcelable(getClass().getClassLoader()));
        }
        this.d = parcel.readInt();
    }
}
