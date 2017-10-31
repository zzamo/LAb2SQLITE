package juma.strathmore.com.sqlitelab;

/**
 * Created by Dennis Juma on 31/10/2017.
 */

public class User {
        //private variables
    int _user_Id;



    String _First_Name;
    String _Middle_Name;
    String _last_Name;
    String _Phone_Number;

    //Empty User


    //constructor
    public User (int _user_Id,String _First_Name,String _Middle_Name, String _last_Name,String _Phone_Number) {
        this._user_Id = _user_Id;
        this._First_Name = _First_Name;
        this._Middle_Name = _Middle_Name;
        this._last_Name = _last_Name;
        this._Phone_Number = _Phone_Number;
    }
    //getting UserId
    public int getuser_Id(){
        return this._user_Id;
    }
    //setting userid
    public void set_user_Id(int _user_Id){
        this._user_Id=_user_Id;
    }

    //getting fname
    public String get_First_Name(){
        return this._First_Name;
    }
    //setting fname
    public void set_First_Name(String _First_Name){
        this._First_Name = _First_Name;
    }

    //getting mname
    public String get_Mname() {
        return this._Middle_Name;
    }
//setting Mname
    public void set_Middle_Name(String _Middle_Name){
        this._Middle_Name = _Middle_Name;
    }
    //getting lname
    public String get_last_Name() {
        return this._last_Name;
    }
    //setting lname
    public void set_last_Name(String _last_Name){
        this._last_Name = _last_Name;
    }
    //getting phone number
    public String get_Phone_Number() {
        return this._Phone_Number;
    }
    //setting Mname
    public void set_Phone_Number(String Pnumber){
        this._Phone_Number = _Phone_Number;
    }
}
