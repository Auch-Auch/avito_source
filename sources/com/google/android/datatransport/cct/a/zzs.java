package com.google.android.datatransport.cct.a;

import a2.j.b.a.b.a.f;
import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import java.io.IOException;
import java.io.Reader;
@AutoValue
public abstract class zzs {
    @NonNull
    public static zzs zza(@NonNull Reader reader) throws IOException {
        JsonReader jsonReader = new JsonReader(reader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (!jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    jsonReader.skipValue();
                } else if (jsonReader.peek() == JsonToken.STRING) {
                    return new f(Long.parseLong(jsonReader.nextString()));
                } else {
                    f fVar = new f(jsonReader.nextLong());
                    jsonReader.close();
                    return fVar;
                }
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } finally {
            jsonReader.close();
        }
    }

    public abstract long zza();
}
