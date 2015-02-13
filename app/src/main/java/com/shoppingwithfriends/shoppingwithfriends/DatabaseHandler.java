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

    /**
     * Creates databases with two tables
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_UN + " TEXT," + KEY_PW + " TEXT," + KEY_EMAIL + " TEXT,"
                + KEY_RATE + " INTEGER," + KEY_NUM_REP + " INTEGER," + KEY_ADMIN + " BOOLEAN,"
                + KEY_LOCK + " BOOLEAN" + ")";
        String CREATE_FRIENDS_TABLE = "CREATE TABLE " + TABLE_FRIENDS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_BASE + " INTEGER,"
                + KEY_FRIEND + " INTEGER" + ")";
        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_FRIENDS_TABLE);
    }

    /**
     * upgrades database
     * @param db db to be upgraded
     * @param oldVersion old version
     * @param newVersion new version
     */
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

    /**
     * Add user to the database
     * @param user user to be added
     */
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

    /**
     * returns user from id
     * @param id
     * @return user
     */
    public User getUser(int id) {
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

    /**
     * return a list of all users
     * @return list of all users
     */
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
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

                // Adding user to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        // return user list
        return userList;
    }

    /**
     * updates a given user in the database
     * @param user user to be updated
     * @return number of rows affected
     */
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

    /**
     * deleted a single user
     * @param user user to be deleted
     */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_ID + " = ?",
                new String[] { String.valueOf(user.getId()) });
        db.close();
    }


    /**
     * gets count of users
     * @return number of users
     */
    public int getUsersCount() {
        String countQuery = "SELECT  * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    /**
     * checks the username is in the db
     * @param username username to be checked
     * @return true if its in the system
     */
    public boolean checkUser(String username) {
        String selectQuery = "SELECT  * FROM " + TABLE_USERS + " WHERE " + KEY_UN + " = \'"
                + username + "\'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        boolean exists = cursor.moveToFirst();
        cursor.close();
        return exists;
    }

    //Begin Friend table methods

    /**
     * adds a friend to the friend table
     * @param base user with a friend
     * @param friend new friend of the user
     */
    void addFriend(User base, User friend) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_BASE, base.getId()); // user Name
        values.put(KEY_FRIEND, friend.getId()); // user username

        // Inserting Row
        db.insert(TABLE_FRIENDS, null, values);
        db.close(); // Closing database connection
    }

    /**
     * returns all friends of a user
     * @param user user to get friends of
     * @return list of friends of user
     */
    public List<User> getAllFriends(User user) {

        int id = user.getId();

        List<User> friendList = new ArrayList<>();
        // select friends of a user from table
        String friendQuery = "SELECT  * FROM " + TABLE_FRIENDS + " WHERE "
                + KEY_BASE + " = \'" + id + "\'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(friendQuery, null);

        // looping through all rows of friends
        if (cursor.moveToFirst()) {
            do {
                //get each friend from the user table
                String friendId = (cursor.getString(2));
                String selectQuery = "SELECT  * FROM " + TABLE_USERS + " WHERE "
                        + KEY_ID + " = " + friendId;

                SQLiteDatabase userDb = this.getWritableDatabase();
                Cursor userCursor = userDb.rawQuery(selectQuery, null);

                //add friend to list
                if (userCursor.moveToFirst()) {
                    User friend = new User();

                    friend.setId(Integer.parseInt(userCursor.getString(0)));
                    friend.setName(userCursor.getString(1));
                    friend.setUsername(userCursor.getString(2));
                    friend.setPassword(userCursor.getString(3));
                    friend.setEmail(userCursor.getString(4));
                    friend.setRating(Integer.parseInt(userCursor.getString(5)));
                    friend.setNumReports(Integer.parseInt(userCursor.getString(6)));
                    friend.setIsLocked(Integer.parseInt(userCursor.getString(7)) == 1);
                    friend.setIsAdmin(Integer.parseInt(userCursor.getString(8))==1);

                    // Adding friend to list
                    friendList.add(friend);
                }
                userCursor.close();

            } while (cursor.moveToNext());
        }
        cursor.close();
        // return friend list
        return friendList;
    }

    /**
     * deleted a row from the friend database
     * @param user user to be deleted
     * @param friend friend to be deleted
     */
    public void deleteFriend(User user, User friend) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FRIENDS, KEY_BASE + " = ? AND " + KEY_FRIEND + " = ?",
                new String[] { String.valueOf(user.getId()), String.valueOf(friend.getId()) });
        db.close();
    }

}