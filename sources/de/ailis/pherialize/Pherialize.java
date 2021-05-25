package de.ailis.pherialize;

import java.nio.charset.Charset;
public class Pherialize {
    public static String serialize(Object obj, Charset charset) {
        return new Serializer(charset).serialize(obj);
    }

    public static Mixed unserialize(String str, Charset charset) {
        return new Unserializer(str, charset).unserializeObject();
    }

    public static String serialize(Object obj) {
        return new Serializer().serialize(obj);
    }

    public static Mixed unserialize(String str) {
        return new Unserializer(str).unserializeObject();
    }
}
