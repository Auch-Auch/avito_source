package a2.j.f.a.m;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
public class a extends ReflectiveTypeAdapterFactory.a {
    public final /* synthetic */ Field d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ TypeAdapter f;
    public final /* synthetic */ Gson g;
    public final /* synthetic */ TypeToken h;
    public final /* synthetic */ boolean i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory, String str, boolean z, boolean z2, Field field, boolean z3, TypeAdapter typeAdapter, Gson gson, TypeToken typeToken, boolean z4) {
        super(str, z, z2);
        this.d = field;
        this.e = z3;
        this.f = typeAdapter;
        this.g = gson;
        this.h = typeToken;
        this.i = z4;
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.a
    public void a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
        Object read = this.f.read(jsonReader);
        if (read != null || !this.i) {
            this.d.set(obj, read);
        }
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.a
    public void b(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
        TypeAdapter typeAdapter;
        Object obj2 = this.d.get(obj);
        if (this.e) {
            typeAdapter = this.f;
        } else {
            typeAdapter = new TypeAdapterRuntimeTypeWrapper(this.g, this.f, this.h.getType());
        }
        typeAdapter.write(jsonWriter, obj2);
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.a
    public boolean c(Object obj) throws IOException, IllegalAccessException {
        if (this.b && this.d.get(obj) != obj) {
            return true;
        }
        return false;
    }
}
