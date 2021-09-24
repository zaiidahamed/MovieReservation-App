package com.example.blueskycinema;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.blueskycinema.Zaid.bookingModel;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class DB_Handler extends SQLiteOpenHelper {

    Context context;

    //Database name
    public static final String DATABASE_NAME = "Movie.db";

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
    public static final String BOOKING_COLUMN_ID = "bookingId";
    public static final String BOOKING_COLUMN_N_TICKETS = "normalTickets";
    public static final String BOOKING_COLUMN_BOX_TICKETS = "boxTickets";
    public static final String BOOKING_COLUMN_DATE = "date";
    public static final String BOOKING_COLUMN_TIME = "time";
    public static final String BOOKING_COLUMN_AMOUNT = "amount";
    public static final String BOOKING_COLUMN_MOVIE_NAME = "movieName";

    //Discount table
    public static final String DISCOUNT_TABLE = "discount_table";
    public static final String DISCOUNT_COLUMN_ID = "discountID";
    public static final String DISCOUNT_COLUMN_CODE = "couponCode";
    public static final String DISCOUNT_COLUMN_PERCENTAGE = "percentage";


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
                        MOVIE_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
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
                        BOOKING_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        BOOKING_COLUMN_N_TICKETS+" TEXT, "+
                        BOOKING_COLUMN_BOX_TICKETS+" TEXT, "+
                        BOOKING_COLUMN_DATE+" TEXT, "+
                        BOOKING_COLUMN_TIME+" TEXT, "+
                        BOOKING_COLUMN_AMOUNT+" TEXT, "+
                        BOOKING_COLUMN_MOVIE_NAME+" TEXT)";

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
            db.execSQL(create_admin_table);

            db.execSQL(create_booking_table);
            db.execSQL(create_discount_table);

            db.execSQL(create_reviews_table);
            db.execSQL(create_rating_table);
            db.execSQL(create_favorite_table);

            //Toast.makeText(context, "Table created successfully!", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            //Toast.makeText(context, "Table creation failed!:", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_admin_table = "DROP TABLE IF EXISTS "+ ADMIN_TABLE;
        String drop_movie_table = "DROP TABLE IF EXISTS "+ MOVIE_TABLE;
        String drop_user_table = "DROP TABLE IF EXISTS "+ USER_TABLE;
        String drop_booking_table = "DROP TABLE IF EXISTS "+ BOOKING_TABLE;
        String drop_discount_table = "DROP TABLE IF EXISTS "+ DISCOUNT_TABLE;
        String drop_reviews_table = "DROP TABLE IF EXISTS "+ REVIEWS_TABLE;
        String drop_rating_table = "DROP TABLE IF EXISTS "+ RATING_TABLE;
        String drop_fav_table = "DROP TABLE IF EXISTS "+ FAVORITE_TABLE;

        db.execSQL(drop_admin_table);
        db.execSQL(drop_movie_table);
        db.execSQL(drop_user_table);
        db.execSQL(drop_booking_table);
        db.execSQL(drop_discount_table);
        db.execSQL(drop_reviews_table);
        db.execSQL(drop_rating_table);
        db.execSQL(drop_fav_table);

        onCreate(db);
    }

    //Zaid function implementation

    public long addBooking(String noOfTckts, String noOfBoxTckts, String date, String time, String amount, String movieName){
        //gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        //create a new map of values, where column names the keys
        ContentValues values = new ContentValues();
        values.put(BOOKING_COLUMN_N_TICKETS, noOfTckts);
        values.put(BOOKING_COLUMN_BOX_TICKETS, noOfBoxTckts);
        values.put(BOOKING_COLUMN_DATE, date);
        values.put(BOOKING_COLUMN_TIME, time);
        values.put(BOOKING_COLUMN_AMOUNT, amount);
        values.put(BOOKING_COLUMN_MOVIE_NAME, movieName);


        //Insert the new raw, returning primary key value of the new raw
        long newBooking = db.insert(BOOKING_TABLE, null, values);
        return newBooking;

    }

    //get all bookings
//    public List getBookingList(String req){
//
//        SQLiteDatabase db = getReadableDatabase();
//
//        //define a projection that specifies which columns from the database
//        String[] projection = {
//                BOOKING_COLUMN_ID,
//                BOOKING_COLUMN_DATE,
//                BOOKING_COLUMN_TIME,
//                BOOKING_COLUMN_AMOUNT,
//                BOOKING_COLUMN_N_TICKETS,
//                BOOKING_COLUMN_BOX_TICKETS,
//                BOOKING_COLUMN_MOVIE_NAME
//        };
//        //filter results WHERE "userName" = 'Kamal'
//        //String selection = UsersMaster.Users.COLUMN_NAME_USERNAME + " = ?";
//        //String[] selectionArgs = {""};
//
//        Cursor cursor = db.query(
//                BOOKING_TABLE,
//                projection,
//                null,
//                null,
//                null,
//                null,
//                null
//        );
//
////        List idList = new ArrayList<>();
//        List dateList = new ArrayList<>();
//        List timeList = new ArrayList<>();
//        List amountList = new ArrayList<>();
//        List nTicketsList = new ArrayList<>();
//        List boxTicketsList = new ArrayList<>();
//        List movieNameList = new ArrayList<>();
//
//        while (cursor.moveToNext()){
//            String id = cursor.getString( cursor.getColumnIndexOrThrow(BOOKING_COLUMN_ID));
//            String date = cursor.getString( cursor.getColumnIndexOrThrow(BOOKING_COLUMN_DATE));
//            String time = cursor.getString( cursor.getColumnIndexOrThrow(BOOKING_COLUMN_TIME));
//            String amount = cursor.getString( cursor.getColumnIndexOrThrow(BOOKING_COLUMN_AMOUNT));
//            String nTickets = cursor.getString( cursor.getColumnIndexOrThrow(BOOKING_COLUMN_N_TICKETS));
//            String boxTickets = cursor.getString( cursor.getColumnIndexOrThrow(BOOKING_COLUMN_BOX_TICKETS));
//            String mNames = cursor.getString( cursor.getColumnIndexOrThrow(BOOKING_COLUMN_MOVIE_NAME));
//
//            //idList.add(id);
//            dateList.add(date);
//            timeList.add(time);
//            amountList.add(amount);
//            nTicketsList.add(nTickets);
//            boxTicketsList.add(boxTickets);
//            movieNameList.add(mNames);
//        }
//        cursor.close();
//
////        Log.i(TAG, "readAllInfo" + userNames);
//
//        if(req == "DATE"){
//            return dateList;
//
//        }else if(req == "TIME"){
//            return timeList;
//
//        }else if(req == "AMOUNT"){
//            return amountList;
//
//        }else if(req == "N_TICKETS"){
//            return nTicketsList;
//
//        }else if(req == "BOX_TICKETS"){
//            return boxTicketsList;
//
//        }else if(req == "MOVIES_NAMES"){
//            return movieNameList;
//
//        }else{
//            return null;
//        }
//
//    }



    public ArrayList<bookingModel> getBookingList(){
        String sql = "select * from " + BOOKING_TABLE;
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<bookingModel> storeBooking = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,null);

        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String noOfTckts = cursor.getString(1);
                String noOfBoxTckts = cursor.getString(2);
                String date = cursor.getString(3);
                String time = cursor.getString(4);
                String amount = cursor.getString(5);
                String movieName = cursor.getString(6);

                storeBooking.add(new bookingModel(id,noOfTckts,noOfBoxTckts,date,time,amount, movieName));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeBooking;
    }


    //delete booking
    public void deleteBooking(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(BOOKING_TABLE, BOOKING_COLUMN_ID + " = ? ", new String[]
                {String.valueOf(id)});
    }




    //Imasha function implementation




    //Hasith function implementation




    //Janani function implementation

}
