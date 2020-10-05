package db;

import android.provider.BaseColumns;

public class DatabaseContract {

    static String TABLE_NAME = "DaftarFavorite";
    static final class NoteColumns implements BaseColumns {
        static String LOGIN = "login";
        static String AVATAR_URL = "avatar_url";
//        static String DATE = "date";
    }
}
