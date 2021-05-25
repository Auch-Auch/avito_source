package com.google.gson;

import a2.b.a.a.a;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
public final class DefaultDateTypeAdapter extends TypeAdapter<Date> {
    public final Class<? extends Date> a;
    public final List<DateFormat> b;

    public DefaultDateTypeAdapter(Class<? extends Date> cls, String str) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        a(cls);
        this.a = cls;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(new SimpleDateFormat(str));
        }
    }

    public static Class<? extends Date> a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.gson.TypeAdapter
    public Date read(JsonReader jsonReader) throws IOException {
        Date date;
        Date date2;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        synchronized (this.b) {
            Iterator<DateFormat> it = this.b.iterator();
            while (true) {
                if (it.hasNext()) {
                    try {
                        date = it.next().parse(nextString);
                        break;
                    } catch (ParseException unused) {
                    }
                } else {
                    try {
                        date = ISO8601Utils.parse(nextString, new ParsePosition(0));
                        break;
                    } catch (ParseException e) {
                        throw new JsonSyntaxException(nextString, e);
                    }
                }
            }
        }
        Class<? extends Date> cls = this.a;
        if (cls == Date.class) {
            return date;
        }
        if (cls == Timestamp.class) {
            date2 = new Timestamp(date.getTime());
        } else if (cls == java.sql.Date.class) {
            date2 = new java.sql.Date(date.getTime());
        } else {
            throw new AssertionError();
        }
        return date2;
    }

    public String toString() {
        DateFormat dateFormat = this.b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            StringBuilder L = a.L("DefaultDateTypeAdapter(");
            L.append(((SimpleDateFormat) dateFormat).toPattern());
            L.append(')');
            return L.toString();
        }
        StringBuilder L2 = a.L("DefaultDateTypeAdapter(");
        L2.append(dateFormat.getClass().getSimpleName());
        L2.append(')');
        return L2.toString();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.gson.stream.JsonWriter, java.lang.Object] */
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        Date date2 = date;
        if (date2 == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this.b) {
            jsonWriter.value(this.b.get(0).format(date2));
        }
    }

    public DefaultDateTypeAdapter(Class<? extends Date> cls, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        a(cls);
        this.a = cls;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i, i2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateTimeFormat(i, i2));
        }
    }
}
