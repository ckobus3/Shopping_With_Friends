package com.shoppingwithfriends.shoppingwithfriends;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "usersManager";

    // Contacts table name
    private static final String TABLE_USERS = "users";
    private static final String TABLE_FRIENDS = "friends";

    // common column names
    private static final String KEY_ID = "id";

    // users Table Columns names
    private static final String KEY_NAME = "name";
    private static final String KEY_UN = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PW = "password";
    private static final String KEY_NUM_REP = "numReports";
    private static final String KEY_RATE = "rating";
    private static final String KEY_ADMIN = "isAdmin";
    private static final String KEY_LOCK = "isLocked";

    // friends table column names
    private static final String KEY_BASE = "base";
    private static final String KEY_FRIEND = "friend";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_UN + " TEXT," + KEY_PW + " TEXT," + KEY_EMAIL + " TEXT,"
                + KEY_RATE + " INTEGER," + KEY_NUM_REP + " INTEGER," + KEY_ADMIN + " BOOLEAN,"
                + KEY_LOCK + " BOOLEAN" + ")";
        String CREATE_FRIENDS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_BASE + " TEXT,"
                + KEY_FRIEND + " TEXT" + ")";
        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_FRIENDS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRIENDS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new user
    void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName()); // user Name
        values.put(KEY_UN, user.getUsername()); // user username
        values.put(KEY_PW, user.getPassword()); // user pw
        values.put(KEY_EMAIL, ""); // user email
        values.put(KEY_RATE, 0);
        values.put(KEY_NUM_REP, 0);
        values.put(KEY_ADMIN, 0);
        values.put(KEY_LOCK, 0);

        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    User getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USERS, new String[] { KEY_ID,
                        KEY_NAME, KEY_UN, KEY_PW, KEY_EMAIL, KEY_RATE, KEY_NUM_REP,
                        KEY_ADMIN, KEY_LOCK}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        return new User(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)),
                Integer.parseInt(cursor.getString(7)), Integer.parseInt(cursor.getString(8)));
    }

    // Getting All Users
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<User>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_USERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setName(cursor.getString(1));
                user.setUsername(cursor.getString(2));
                user.setPassword(cursor.getString(3));
                user.setEmail(cursor.getString(4));
                user.setRating(Integer.parseInt(cursor.getString(5)));
                user.setNumReports(Integer.parseInt(cursor.getString(6)));
                user.setIsLocked(Integer.parseInt(cursor.getString(7)) == 1);
                user.setIsAdmin(Integer.parseInt(cursor.getString(8))==1);

                // Adding contact to list
                userList.add(user);
            } while (cursor.moveToNext());
        }

        // return contact list
        return userList;
    }

    // Updating single contact
    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName()); // Contact Name
        values.put(KEY_UN, user.getUsername()); // Contact username
        values.put(KEY_PW, user.getPassword()); // Contact pw
        values.put(KEY_EMAIL, user.getEmail()); // Contact email
        values.put(KEY_RATE, user.getRating());
        values.put(KEY_NUM_REP, user.getNumReports());
        values.put(KEY_ADMIN, user.getIsAdmin());
        values.put(KEY_LOCK, user.getIsLocked());

        // updating row
        return db.update(TABLE_USERS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(user.getId()) });
    }

    // Deleting single contact
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_ID + " = ?",
                new String[] { String.valueOf(user.getId()) });
        db.close();
    }


    // Getting contacts Count
    public int getUsersCount() {
        String countQuery = "SELECT  * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    public boolean checkUser(String username) {
        String selectQuery = "SELECT  * FROM " + TABLE_USERS + " WHERE " + KEY_UN + " = \'"
                + username + "\'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        boolean exists = cursor.moveToFirst();
        cursor.close();
        return exists;
    }

}