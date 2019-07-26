package com.hfad.samplewebapi.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hfad.samplewebapi.model.FavData;

import java.util.ArrayList;
import java.util.List;

public class SQliteDatabase  extends SQLiteOpenHelper {


        public static final String TABLE_NAME = "CRIMES";
        public static final String LOCATION_TYPE = "LocationType";
        public static final String MONTH = "Month";
        public static final String CATEGORY = "Category";
        public static final String CRIME_ID = "CrimeID";
        public static final String TABLEID = "TID";
        private static final int DATABASE_VERSION = 8;
        public static final String ID = "id";

        public SQliteDatabase(Context context) {
        super(context,TABLE_NAME,null, DATABASE_VERSION);
    }

    @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_TABLES = "CREATE TABLE " + TABLE_NAME + " ( "+TABLEID+ " INTEGER PRIMARY KEY AUTOINCREMENT , " + ID + " INTEGER  , " + CATEGORY + " VARCHAR " + " , " + LOCATION_TYPE + " VARCHAR " + ", " + CRIME_ID +" INTEGER"+" , "+ MONTH + " VARCHAR);";
            db.execSQL(CREATE_TABLES);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+" ;");
            onCreate(db);
        }


        public void InsertData(String locationtype,String category,String month,Integer crimeid) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(LOCATION_TYPE,locationtype);
            contentValues.put(CATEGORY,category);
            contentValues.put(MONTH,month);
            contentValues.put(CRIME_ID,crimeid);
            db.insert(TABLE_NAME,null,contentValues);

        };

        public List<FavData> getData()
        {   List<FavData> mListFavData=new ArrayList<>();
            SQLiteDatabase db=this.getReadableDatabase();
            String getfav="SELECT *  FROM "+TABLE_NAME;
            Cursor mcursor=db.rawQuery(getfav,null);
            while(mcursor.moveToNext())
            {
                String month=mcursor.getString(mcursor.getColumnIndex("Month"));
                String locationtype=mcursor.getString(mcursor.getColumnIndex("LocationType"));
                String category=mcursor.getString(mcursor.getColumnIndex("Category"));
                Integer id =mcursor.getInt(mcursor.getColumnIndex("CrimeID"));
                FavData mFavData=new FavData(month,locationtype,category,id);
                mListFavData.add(mFavData);
            }
            mcursor.close();
            db.close();
            return mListFavData;
        }


    }


