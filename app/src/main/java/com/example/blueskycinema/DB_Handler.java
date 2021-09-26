package com.example.blueskycinema;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.blueskycinema.Imasha.Reviews;

import java.util.ArrayList;
import java.util.List;

public class DB_Handler extends SQLiteOpenHelper {

    Context context;
    
    //Database name
    public static final String DATABASE_NAME = "Movie.db";

    //No of seats in the theater
    public static final int NO_OF_SEATS = 200;
    public static final int NO_OF_BOX_SEATS = 15;

    //Movie table
    public static final String MOVIE_TABLE = "movies_table";
    public static final String MOVIE_COLUMN_ID = "movieID";
    public static final String MOVIE_COLUMN_NAME = "name";
    public static final String MOVIE_COLUMN_GENRE = "genre";
    public static final String MOVIE_COLUMN_DURATION = "duration";
    public static final String MOVIE_COLUMN_YEAR = "year";
    public static final String MOVIE_COLUMN_DESCRIPTION = "description";
    public static final String MOVIE_COLUMN_POSTER = "poster";
    public static final String MOVIE_COLUMN_COVER = "coverImage";
    public static final String MOVIE_COLUMN_TRAILER = "trailerLink";
    public static final String MOVIE_COLUMN_PRICE = "ticketPrice";

    //User table
    public static final String USER_TABLE = "users_table";
    public static final String USER_COLUMN_ID = "userID";
    public static final String USER_COLUMN_USERNAME = "username";
    public static final String USER_COLUMN_EMAIL = "email";
    public static final String USER_COLUMN_PASSWORD = "password";
    public static final String USER_COLUMN_CONTACT = "contact";
    public static final String USER_COLUMN_IMAGE = "image";

    //Admin table
    public static final String ADMIN_TABLE = "admin_table";
    public static final String ADMIN_COLUMN_ID = "adminID";
    public static final String ADMIN_COLUMN_NAME = "name";
    public static final String ADMIN_COLUMN_USERNAME = "username";
    public static final String ADMIN_COLUMN_PASSWORD = "password";

    //Booking table
    public static final String BOOKING_TABLE = "booking_table";
    public static final String BOOKING_COLUMN_N_TICKETS = "normalTickets";
    public static final String BOOKING_COLUMN_BOX_TICKETS = "boxTickets";
    public static final String BOOKING_COLUMN_DATE = "date";
    public static final String BOOKING_COLUMN_TIME = "time";
    public static final String BOOKING_COLUMN_AMOUNT = "amount";
    public static final String BOOKING_COLUMN_MOVIE_ID = "movieID";

    //Discount table
    public static final String DISCOUNT_TABLE = "discount_table";
    public static final String DISCOUNT_COLUMN_ID = "discountID";
    public static final String DISCOUNT_COLUMN_CODE = "couponCode";
    public static final String DISCOUNT_COLUMN_PERCENTAGE = "percentage";


    //Reviews table
    public static final String REVIEWS_TABLE = "reviews_table";
    public static final String REVIEWS_COLUMN_ID = "revID";
    public static final String REVIEWS_COLUMN_USERID = "userID";
    public static final String REVIEWS_COLUMN_SCOUNT = "count";
    public static final String REVIEWS_COLUMN_MESSAGE = "message";
    public static final String REVIEWS_COLUMN_DATE = "date";



    //Theater Rating table
    public static final String THEATER_RATING_TABLE = "theater_rating_table";
    public static final String THEATER_RATING_COLUMN_ID = "ratingID";
    public static final String THEATER_RATING_COLUMN_USERID = "userID";
    public static final String THEATER_RATING_COLUMN_COUNT = "count";
    public static final String THEATER_RATING_COLUMN_MESSAGE = "message";
    public static final String THEATER_RATING_COLUMN_DATE = "date";

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
                        MOVIE_COLUMN_GENRE+" TEXT, "+
                        MOVIE_COLUMN_DURATION+" TEXT, "+
                        MOVIE_COLUMN_YEAR+" INTEGER, "+
                        MOVIE_COLUMN_DESCRIPTION+" TEXT, "+
                        MOVIE_COLUMN_POSTER+" BLOB, "+
                        MOVIE_COLUMN_COVER+" BLOB, "+
                        MOVIE_COLUMN_TRAILER+" TEXT, "+
                        MOVIE_COLUMN_PRICE+" REAL)";

        //create user table
        String create_users_table =
                "CREATE TABLE "+USER_TABLE+" ( "+
                        USER_COLUMN_ID+" INTEGER PRIMARY KEY, " +
                        USER_COLUMN_USERNAME+" TEXT, "+
                        USER_COLUMN_EMAIL+" TEXT, "+
                        USER_COLUMN_PASSWORD+" TEXT, "+
                        USER_COLUMN_CONTACT+" TEXT, "+
                        USER_COLUMN_IMAGE+" BLOB)";

        //create admin table
        String create_admin_table =
                "CREATE TABLE "+ADMIN_TABLE+" ( "+
                        ADMIN_COLUMN_ID+" INTEGER PRIMARY KEY, " +
                        ADMIN_COLUMN_NAME+" TEXT, "+
                        ADMIN_COLUMN_USERNAME+" TEXT, "+
                        ADMIN_COLUMN_PASSWORD+" TEXT)";

        //create booking table
        String create_booking_table =
                "CREATE TABLE "+BOOKING_TABLE+" ( "+
                        BOOKING_COLUMN_N_TICKETS+" INTEGER PRIMARY KEY, " +
                        BOOKING_COLUMN_BOX_TICKETS+" INTEGER, "+
                        BOOKING_COLUMN_DATE+" DATE, "+
                        BOOKING_COLUMN_TIME+" DATETIME, "+
                        BOOKING_COLUMN_AMOUNT+" REAL, "+
                        BOOKING_COLUMN_MOVIE_ID+" INTEGER)";

        //create discount table
        String create_discount_table =
                "CREATE TABLE "+DISCOUNT_TABLE+" ( "+
                        DISCOUNT_COLUMN_ID+" INTEGER PRIMARY KEY, " +
                        ADMIN_COLUMN_NAME+" TEXT, "+
                        DISCOUNT_COLUMN_CODE+" TEXT, "+
                        DISCOUNT_COLUMN_PERCENTAGE+" INTEGER)";

        //create review table
        String create_reviews_table =
                "CREATE TABLE "+REVIEWS_TABLE+" ( "+
                        REVIEWS_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        REVIEWS_COLUMN_USERID+" INTEGER, "+
                        REVIEWS_COLUMN_SCOUNT+" TEXT, "+
                        REVIEWS_COLUMN_MESSAGE+" TEXT, "+
                        REVIEWS_COLUMN_DATE+" DATE)";


        //create theater rating table
        String create_theater_rating_table =
                "CREATE TABLE "+THEATER_RATING_TABLE+" ( "+
                        THEATER_RATING_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        THEATER_RATING_COLUMN_USERID+" INTEGER, "+
                        THEATER_RATING_COLUMN_COUNT+" INTEGER, "+
                        THEATER_RATING_COLUMN_MESSAGE+" TEXT,"+
                        THEATER_RATING_COLUMN_DATE+" DATE)";

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
            db.execSQL(create_admin_table);

            db.execSQL(create_booking_table);
            db.execSQL(create_discount_table);

            db.execSQL(create_reviews_table);
            db.execSQL(create_theater_rating_table);
            db.execSQL(create_favorite_table);

            //Toast.makeText(context, "Table created successfully!", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            //Toast.makeText(context, "Table creation failed!:"+ e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Zaid function implementation123


    //**********************************************************************************************
    //Imasha function implementation

    //add review
    public long addReview(String rev, String date, String rt){
    //gets the data repository in write mode
        SQLiteDatabase myDB = getWritableDatabase();

        //create a new map of values, where column names the keys
        ContentValues values = new ContentValues();
        values.put(REVIEWS_COLUMN_MESSAGE, rev);
        values.put(REVIEWS_COLUMN_DATE, date);
        values.put(REVIEWS_COLUMN_SCOUNT, rt);

        //Insert the new raw, returning primary key value of the new raw
        long newReview = myDB.insert(REVIEWS_TABLE, null, values);
        return newReview;
    }

    //add theater review
    public long addTheterRev(String trev, String rt, String date){
        //gets the data repository in write mode
        SQLiteDatabase myDB = getWritableDatabase();

        //create a new map of values, where column names the keys
        ContentValues values = new ContentValues();
        values.put(THEATER_RATING_COLUMN_MESSAGE, trev);
        values.put(THEATER_RATING_COLUMN_COUNT, rt);
        values.put(THEATER_RATING_COLUMN_DATE, date);

        //Insert the new raw, returning primary key value of the new raw
        long newTReview = myDB.insert(THEATER_RATING_TABLE, null, values);
        return newTReview;
    }

    //get reviews count
    public int countReviews(){
        SQLiteDatabase myDB = getReadableDatabase();
        String query = "SELECT * FROM "+ REVIEWS_TABLE;

        Cursor cursor = myDB.rawQuery(query,null);
        return cursor.getCount();
    }

    //get total rating value
    public float countRating() {
        SQLiteDatabase myDB = getReadableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT SUM(" + REVIEWS_COLUMN_SCOUNT + ") as Total FROM " + REVIEWS_TABLE, null);

        float total = 0;
        if (cursor.moveToFirst()) {

            total = cursor.getInt(cursor.getColumnIndex("Total"));// get final total
        }
        return total;
       
    }
    //get all reviews
    public ArrayList<Reviews> getAllReviews(String orderBy) {
        ArrayList<Reviews> arrayList = new ArrayList<>();
        //Select all info in database
        String selectQuery = "SELECT * FROM " + REVIEWS_TABLE + " ORDER BY " + orderBy;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        //Get the data from columns
        if (cursor.moveToNext()) {
            do {
                Reviews model = new Reviews(
                        ""+cursor.getInt(cursor.getColumnIndex(REVIEWS_COLUMN_ID)),
                        ""+cursor.getString(cursor.getColumnIndex(REVIEWS_COLUMN_MESSAGE)),
                        ""+cursor.getString(cursor.getColumnIndex(REVIEWS_COLUMN_DATE)),
                        ""+cursor.getString(cursor.getColumnIndex(REVIEWS_COLUMN_SCOUNT))

                );
                arrayList.add(model);
            } while (cursor.moveToNext());
        }
        db.close();
        return arrayList;
    }

    //delete a review

    public void deleteReview(String id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(REVIEWS_TABLE,"revID =?",new String[]{String.valueOf(id)});
        db.close();
    }

    //update review
    public int updateReview(Reviews model) {

        SQLiteDatabase db = getWritableDatabase();

        //create a new map of values, where column names the keys
        ContentValues values = new ContentValues();

        values.put(REVIEWS_COLUMN_ID, model.getId());
        values.put(REVIEWS_COLUMN_SCOUNT, model.getScount());
        values.put(REVIEWS_COLUMN_DATE, model.getDate());
        values.put(REVIEWS_COLUMN_MESSAGE, model.getReview());


        int status = db.update(REVIEWS_TABLE, values, REVIEWS_COLUMN_ID +" =? ", new String[]{String.valueOf(model.getId())});

        db.close();
        return status;
    }
    //**********************************************************************************************
    //Hasith function implementation




    //Janani function implementation

}
