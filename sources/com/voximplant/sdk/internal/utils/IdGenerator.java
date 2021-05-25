package com.voximplant.sdk.internal.utils;

import java.util.Random;
public class IdGenerator {
    public String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public String get(int i) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        while (i > 0) {
            i--;
            sb.append(this.a.charAt(random.nextInt(this.a.length())));
        }
        return sb.toString();
    }
}
