package isetb.TP6.hellostudent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_Name = "user_db";
    public static final String TABLE_USER = "user";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_PHONE = "phone";
    public static final String CREATE_user_TABLE = "CREATE TABLE " + TABLE_USER + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " TEXT NOT NULL, " + COL_PHONE + " TEXT) ";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_Name,  null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DB","Table create SQL: " + CREATE_user_TABLE);
        db.execSQL(CREATE_user_TABLE);
        Log.d("DB","DB created!");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_USER);
        onCreate(db);

    }




    private SQLiteDatabase db;

    public SQLiteDatabase open() {
        db = this.getWritableDatabase();
        return db;
    }


    public void adduser(isetb.tp6.hellostudent.user s) {
        open();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, s.getName());
        values.put(COL_PHONE, s.getPhone());
        db.insert(TABLE_USER, null, values);
    }

    public void updateuser(isetb.tp6.hellostudent.user s, int id) {
        open();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, s.getName());
        values.put(COL_PHONE, s.getPhone());
        db.update(TABLE_USER, values, COL_ID + "=?", new String[]{String.valueOf(id)});

    }

    public void removeuser(int id) {
        open();
        db.delete(TABLE_USER, COL_ID + "=?", new String[]{String.valueOf((id))});
    }

    public ArrayList<isetb.tp6.hellostudent.user> getAllStudent() {
        db = this.getReadableDatabase();
        ArrayList<isetb.tp6.hellostudent.user> list = new ArrayList<isetb.tp6.hellostudent.user>();
        Cursor c = db.query(TABLE_USER, new String[]{COL_ID, COL_NAME, COL_PHONE}, null, null, null, null, null);
        c.moveToFirst();
        do {
            isetb.tp6.hellostudent.user s = new isetb.tp6.hellostudent.user(c.getInt(0), c.getString(1), c.getString(2));
            list.add(s);
        } while (c.moveToNext());
        return list;
    }

    public int getuserCount() {
        db =this.getReadableDatabase();
        Cursor c = db.query(TABLE_USER, new String[]{COL_ID,COL_NAME,COL_PHONE},null,null,null,null,null);
        return c.getCount();

    }}