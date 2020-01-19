package sg.edu.rp.c346.workouttracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "users.db";
    public static final String TABLE_NAME = "user_data";

    private static final String COL1 = "ID";
    private static final String COL2 = "workoutname";
    private static final String COL3 = "sets";
    private static final String COL4 = "reps";



     public DatabaseHelper(Context context) {
                 super(context, DATABASE_NAME, null, 2);
             }


             @Override
     public void onCreate(SQLiteDatabase db) {
                 String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                 " workoutname TEXT, sets TEXT ,reps TEXT)";
                 db.execSQL(createTable);
             }


             @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                 db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
                 onCreate(db);
             }


             public boolean addData(String tworkoutname,String tsets , String treps) {
                 SQLiteDatabase db = this.getWritableDatabase();
                 ContentValues contentValues = new ContentValues();
                 contentValues.put(COL2, tworkoutname);
                 contentValues.put(COL3, tsets);
                 contentValues.put(COL4, treps);





                 long result = db.insert(TABLE_NAME, null, contentValues);


                 //if date as inserted incorrectly it will return -1
                 if (result == -1) {
                         return false;
                     } else {
                         return true;
                     }
             }


             //query for 1 week repeats
             public Cursor getListContents() {
                 SQLiteDatabase db = this.getWritableDatabase();
                 Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                 return data;
             }
    public void deleteItem(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] whereArgs = new String[] { name };
        db.delete(TABLE_NAME, "workoutname"+ "=?", whereArgs);
        db.close();
    }
    public void deleteItembyid(long pos)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COL1 + " = ?",new String[]{Long.toString(pos)} );
        db.close();
    }
    public void deleteall(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " +  TABLE_NAME ); //delete all rows in a table
    }

}
