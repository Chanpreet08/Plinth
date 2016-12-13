package com.lnmiit.plinth.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lnmiit.plinth.Model.Data;

import java.util.ArrayList;

/**
 * Created by chanpreet on 13/12/16.
 */

public class Dbhelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION= 1;

    private static final String DATABASE_NAME = "plinth";

    private static final String TABLE_NAME = "data";

    private static final String KEY_ID = "id";

    private static final String KEY_TITLE = "title";

    private static final String KEY_DESCRIPTION = "descrption";

    private Context context;

    private SQLiteDatabase db = getWritableDatabase();

    public Dbhelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase dbname) {
        db = dbname;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_TITLE
                + " TEXT, " + KEY_DESCRIPTION+ " TEXT)";
        dbname.execSQL(sql);

        Data data1 =new Data("Astronomy","Universe- unimaginably large and still right down to being incredibly small.");
        addData(data1);
        Data data2 = new Data("Coding","Coders are the ones who can storm off their brains and come up with a new solution to each problem that exists.");
        addData(data2);
        Data data3 = new Data("Robotics","Robots are fun to play with; robots are even much more fun to build.");
        addData(data3);
        Data data4 = new Data("Quizzing","You think you know this world? You think you know this world?");
        addData(data4);
        Data data5 = new Data("Literature","Bring alive the artist in you and heave yourself in the ocean of literature");
        addData(data5);
        Data data6 = new Data("Management","From the street fairs to the global economy, we are filled to the brim with hustle and bustle every now and then.");
        addData(data6);

    }

    public void addData(Data data)
    {
        ContentValues cv = new ContentValues();
        cv.put(KEY_TITLE,data.getTitles());
        cv.put(KEY_DESCRIPTION,data.getDescription());
        db.insert(TABLE_NAME,null,cv);
    }


    public ArrayList<Data> getData()
    {
        ArrayList<Data> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String selected= "SELECT * FROM "+ TABLE_NAME;

        Cursor cursor = db.rawQuery(selected,null);

        if(cursor.moveToFirst()) {
            do {
                Data d = new Data();
                d.setId(cursor.getInt(0));
                d.setTitles(cursor.getString(1));
                d.setDescription(cursor.getString(2));
                list.add(d);
            }
            while(cursor.moveToNext());
        }
        return list;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
