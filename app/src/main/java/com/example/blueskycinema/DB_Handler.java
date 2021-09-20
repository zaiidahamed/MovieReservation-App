package com.example.blueskycinema;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DB_Handler extends SQLiteOpenHelper {

    Context context;
    
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

    //Reviews table
    public static final String REVIEWS_TABLE = "reviews_table";
    public static final String REVIEWS_COLUMN_ID = "revID";
    public static final String REVIEWS_COLUMN_USERID = "userID";
    public static final String REVIEWS_COLUMN_MESSAGE = "message";
    public static final String REVIEWS_COLUMN_DATE = "date";

    //Rating table
    public static final String RATING_TABLE = "rating_table";
    public static final String RATING_COLUMN_ID = "ratingID";
    public static final String RATING_COLUMN_USERID = "userID";
    public static final String RATING_COLUMN_COUNT = "count";
    public static final String RATING_COLUMN_DATE = "date";

    //Favorite table
    public static final String FAVORITE_TABLE = "favorite_table";
    public static final String FAVORITE_COLUMN_ID = "favID";
    public static final String FAVORITE_COLUMN_USERID = "userID";
    public static final String FAVORITE_COLUMN_MOVIE_ID = "movieID";



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

        //create review table
        String create_reviews_table =
                "CREATE TABLE "+REVIEWS_TABLE+" ( "+
                        REVIEWS_COLUMN_ID+" INTEGER PRIMARY KEY, " +
                        REVIEWS_COLUMN_USERID+" INTEGER, "+
                        REVIEWS_COLUMN_MESSAGE+" TEXT, "+
                        REVIEWS_COLUMN_DATE+" DATE)";

        //create rating table
        String create_rating_table =
                "CREATE TABLE "+RATING_TABLE+" ( "+
                        RATING_COLUMN_ID+" INTEGER PRIMARY KEY, " +
                        RATING_COLUMN_USERID+" INTEGER, "+
                        RATING_COLUMN_COUNT+" INTEGER, "+
                        RATING_COLUMN_DATE+" DATE)";

        //create favorite table
        String create_favorite_table =
                "CREATE TABLE "+FAVORITE_TABLE+" ( "+
                        FAVORITE_COLUMN_ID+" INTEGER PRIMARY KEY, " +
                        FAVORITE_COLUMN_USERID+" INTEGER, "+
                        FAVORITE_COLUMN_MOVIE_ID+" INTEGER)";


        //execute tables

        try {
            db.execSQL(create_movies_table);
            db.execSQL(create_users_table);

            Toast.makeText(context, "Table created successfully!", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(context, "Table creation failed!:"+ e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        db.execSQL(create_movies_table);
        db.execSQL(create_users_table);
        db.execSQL(create_reviews_table);
        db.execSQL(create_rating_table);
        db.execSQL(create_favorite_table);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Zaid function implementation123



    //Imasha function implementation




    //Hasith function implementation




    //Janani function implementation

}
