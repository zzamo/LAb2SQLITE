package juma.strathmore.com.sqlitelab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dennis Juma on 17/10/2017.
 */


public class DatabaseHandler extends SQLiteOpenHelper{
// All static variables
    //Database Version
private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    //Conatcts table name
    private static final String TABLE_CONTACTS = "contacts";

    //contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static  final String KEY_PH_NO = "phone_number";
    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE" + TABLE_CONTACTS +"(" +KEY_ID +"INTEGER PRIMARY KEY," + KEY_NAME + "TEXT," +KEY_PH_NO + "TEXT" + ")";
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_CONTACTS);
        //create table again
        onCreate(db);
    }



    //Adding new contact

    public void addContact(Contacts contact ) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());//contact name
        values.put(KEY_PH_NO, contact.getPhoneNumber());//contact phone number

        //inserting row
        db.insert(TABLE_CONTACTS, null, values);
        db.close();//closing database connection
    }

    // Getting single contact
    public Contacts getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{
                KEY_ID, KEY_NAME, KEY_PH_NO}, KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null,null);
        if (cursor != null)
            cursor.moveToFirst();
        Contacts contacts = new Contacts(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2));
        //return contact
        return contacts;

    }

    //Getting all contacts
    public List<Contacts> getAllContacts() {
        List<Contacts> contactsList = new ArrayList<Contacts>();
        ///select all query
        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;
    SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contacts contacts = new Contacts();
                contacts.setID(Integer.parseInt(cursor.getString(0)));
                contacts.setName(cursor.getString(1));
                contacts.setPhoneNumber(cursor.getString(2));
                //adding contact to list
                contactsList.add(contacts);
            } while (cursor.moveToNext());
        }
        return contactsList;
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();


    }

    //updating single contacts
    public int updateContact(Contacts contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        //updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",new String[] {String.valueOf(contact.getID())} );
    }

    //deleting single contact
    public void deleteContact(Contacts contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?", new String[] {String.valueOf(contact.getID())});
        db.close();

    }



    //User table name
    private static final String TABLE_USER = "user";

    //Contacts Table Columns
    private static final String KEY_USER_ID = "id";
    private static final String KEY_FNAME = "_First_Name";
    private static final String KEY_MNAME = "_Middle_Name";
    private static final String KEY_LNAME = "_last_Name";
    private static final String KEY_PHO_NO = "phone_number";

    //creating Tables



        String CREATE_USER_TABLE ="CREATE TABLE" + TABLE_USER +"("+ KEY_USER_ID +"INT PRIMARY KEY,"
            + KEY_FNAME +"TEXT," +KEY_MNAME + "TEXT," +KEY_LNAME +"TEXT," + KEY_PHO_NO +"TEXT PRIMARY KEY" + ")";
    db.execSQL(CREATE_USER_TABLE);

    //Upgrading
    @Override
public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_USER);

        //Create table again
        onCreate(db);
    }
    //adding new user
    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER_ID, user.getuser_Id());
        values.put(KEY_FNAME, user.get_First_Name());
        values.put(KEY_MNAME, user.get_Mname());
        values.put(KEY_LNAME, user.get_last_Name());
        values.put(KEY_PHO_NO, user.get_Phone_Number());

        //Inserting Row
        db.insert(TABLE_USER,null,values);
        db.close(); //closing database connection
    }

    //Getting single User
    public User getUser(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER, new String[]{KEY_USER_ID,KEY_FNAME,KEY_MNAME,KEY_LNAME,KEY_PHO_NO},KEY_FNAME + "=?",
        new String [] {String.valueOf(id)}, null, null,null, null);
        if (cursor !=null)
            cursor.moveToFirst();

        User user = new User(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));

        //return User
        return user;
    }

    //Getting All Users
    public List<User> getAllUsers () {
        List<User> userList = new ArrayList<User>();
        //Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                User.set_user_Id(Integer.parseInt(cursor.getString(0)));
                User.set_First_Name(cursor.getString(1));
                User.set_Middle_Name(cursor.getString(2));
                User.set_last_Name(cursor.getString(3));
                User.set_Phone_Number(cursor.getString(4));
            } while (cursor.moveToNext());
        }
            //return contact list
            return userList;
    }

    //Getting users count
    public String getUsersCount(){
        public String getUserCount() {
            String countQuery = "SELECT * FROM " + TABLE_USER;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(countQuery, null);
            cursor.close();

            //return count
            return String.valueOf(cursor.getCount());
        }
    }

    //updating single user
    public String updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USER_ID, user._user_Id);
        values.put(KEY_FNAME, user.get_First_Name());
        values.put(KEY_MNAME, user.get_Mname());
        values.put(KEY_LNAME, user.get_last_Name());
        values.put(KEY_PH_NO, user.get_Phone_Number());

        //updating row
        return db.update(TABLE_USER,values,KEY_ID + "= ?",
                new String[]{ String.valueOf(user.getuser_Id()});
    }

    //Deleting single user
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, KEY_ID + "= ?",
                new String[] {String.valueOf(user.getuser_Id())});
        db.close();

    }

}
