package com.example.blueskycinema;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB_Handler extends SQLiteOpenHelper {

    //Database name
    public static final String DATABASE_NAME = "Movie.db";

    //Movie table
    public static final String MOVIE_TABLE = "movies_table";
    public static final String MOVIE_COLUMN_ID = "movieID";
    public static final String MOVIE_COLUMN_NAME = "name";
    public static final String MOVIE_COLUMN_DESCRIPTION = "description";

    //User table
    public static final String USER_TABLE = "users_table";
    public static final String USER_COLUMN_ID = "userID";
    public static final String USER_COLUMN_NAME = "name";
    public static final String USER_COLUMN_EMAIL = "email";
    public static final String USER_COLUMN_PASSWORD = "password";


    public DB_Handler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //create movie table
        String create_movies_table =
                "CREATE TABLE "+MOVIE_TABLE+" ( "+
                    MOVIE_COLUMN_ID+" INTEGER PRIMARY KEY, " +
                    MOVIE_COLUMN_NAME+" TEXT, "+
                    MOVIE_COLUMN_DESCRIPTION+" TEXT)";

        //create user table
        String create_users_table =
                "CREATE TABLE "+USER_TABLE+" ( "+
                        USER_COLUMN_ID+" INTEGER PRIMARY KEY, " +
                        USER_COLUMN_NAME+" TEXT, "+
                        USER_COLUMN_EMAIL+" TEXT, "+
                        USER_COLUMN_PASSWORD+" TEXT)";

        //execute tables
        db.execSQL(create_movies_table);
        db.execSQL(create_users_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
