package com.example.android.pets.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.PetContract.PetEntry;

public class PetDbHelper extends SQLiteOpenHelper {

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "pet.db";
    /**
     * Dataase version. If change the database schema, must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String NOT_NULL_TYPE = " NOT NULL";
    private static final String COMMA_SEP = ",";
    // Create a String that contains the SQL statement to create the pets table
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + PetEntry.TABLE_NAME + " ("
            + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + PetEntry.COLUMN_PET_NAME + TEXT_TYPE + " NOT NULL" + COMMA_SEP
            + PetEntry.COLUMN_PET_BREED + TEXT_TYPE + COMMA_SEP
            + PetEntry.COLUMN_PET_GENDER + INTEGER_TYPE + NOT_NULL_TYPE + COMMA_SEP
            + PetEntry.COLUMN_PET_WEIGHT + INTEGER_TYPE + NOT_NULL_TYPE + " DEFAULT 0);";

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
