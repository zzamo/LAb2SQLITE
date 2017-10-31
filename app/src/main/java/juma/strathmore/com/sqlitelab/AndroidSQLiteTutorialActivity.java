package juma.strathmore.com.sqlitelab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

/**
 * Created by Dennis Juma on 17/10/2017.
 */

public class AndroidSQLiteTutorialActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        /**
         *  CRUD Operations
         * */
// Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contacts("Ravi", "9100000000"));
        db.addContact(new Contacts("Srinivas","9199999999"));
        db.addContact(new Contacts("Tommy", "9522222222"));
        db.addContact(new Contacts("Karthik","9533333333"));

        //Reading all contacts

        Log.d("Reading: ","Reading all contacts..");
        List<Contacts> contacts = db.getAllContacts();

        for (Contacts cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + ",phone: " + cn.getPhoneNumber();
Log.d("Name: ", log);
        }

        //Inserting Users
        Log.d("Insert: ", "Inserting..");
        db.addUser(new User("Marcos","Alonso","Thiago","+254724331155"));
        db.addUser(new User("Dennis","Zamoyoni","Juma","+254722914666"));

        //Reading all users
        Log.d("Reading: ", "Reading all Users..");
        List<User> users = db.getAllUsers();

        for (User cn : users) {
            String log = "Id: "+cn.getID()+" ,Fname: " + cn.getFname() + ", Mname: " +cn.get_Mname() + " ,Lname: " +cn.getlname() +",Pnumber: "+cn.getPnumber();
        }

    }

}
