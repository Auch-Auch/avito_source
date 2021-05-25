package com.yandex.metrica.profile;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ade;
import com.yandex.metrica.impl.ob.adl;
import com.yandex.metrica.impl.ob.ug;
import com.yandex.metrica.impl.ob.uh;
public class Attribute {
    @NonNull
    public static BirthDateAttribute birthDate() {
        return new BirthDateAttribute();
    }

    @NonNull
    public static BooleanAttribute customBoolean(@NonNull String str) {
        return new BooleanAttribute(str, new ug(), new uh(new ade(100)));
    }

    @NonNull
    public static CounterAttribute customCounter(@NonNull String str) {
        return new CounterAttribute(str, new ug(), new uh(new ade(100)));
    }

    @NonNull
    public static NumberAttribute customNumber(@NonNull String str) {
        return new NumberAttribute(str, new ug(), new uh(new ade(100)));
    }

    @NonNull
    public static StringAttribute customString(@NonNull String str) {
        return new StringAttribute(str, new adl(200, a.e3("String attribute \"", str, "\"")), new ug(), new uh(new ade(100)));
    }

    @NonNull
    public static GenderAttribute gender() {
        return new GenderAttribute();
    }

    @NonNull
    public static NameAttribute name() {
        return new NameAttribute();
    }

    @NonNull
    public static NotificationsEnabledAttribute notificationsEnabled() {
        return new NotificationsEnabledAttribute();
    }
}
