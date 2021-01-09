package com.pazar.listem;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DataAccessObject {


    public void VeriEkle(Veritabani vt, String ad) {
        SQLiteDatabase db = vt.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ad", ad);
        db.insertOrThrow("Listem", null, cv);
        db.close();
    }


    public ArrayList<String> VeriyiGoster(Veritabani vt) {
        ArrayList<String> listem = new ArrayList<>();
        SQLiteDatabase db = vt.getReadableDatabase();

        Cursor c = db.rawQuery("Select *from Listem", null);

        c.moveToLast();
        c.moveToNext();
        while (c.moveToPrevious()) {

            String a = c.getString(c.getColumnIndex("ad"));
            listem.add(a);
        }

        return listem;

    }
}
