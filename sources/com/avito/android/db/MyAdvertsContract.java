package com.avito.android.db;
public class MyAdvertsContract extends AdvertsContract {
    public static final String TABLE_NAME = "my_adverts";

    public static String getCreateSql() {
        return AdvertsContract.getCreateSql(TABLE_NAME);
    }
}
