package com.example.blueskycinema;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    //Food table
    public static final String FOOD_TABLE = "food_table";
    public static final String COLUMN_1 = "foodID";
    public static final String COLUMN_2 = "name";
    public static final String COLUMN_3 = "image";
    public static final String COLUMN_4 = "price";

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

        //create food table
        String create_food_table =
                "CREATE TABLE "+FOOD_TABLE+" ( "+
                        COLUMN_1+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_2+" TEXT, "+
                        COLUMN_3+" TEXT, "+
                        COLUMN_4+" FLOAT)";


        //execute tables
        db.execSQL(create_movies_table);
        db.execSQL(create_users_table);
        db.execSQL(create_food_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Zaid function implementation



    //Imasha function implementation




    //Hasith function implementation




    //Janani function implementation
    public boolean insertData(String name, String image, String marks) {
        return true;
    }


}
