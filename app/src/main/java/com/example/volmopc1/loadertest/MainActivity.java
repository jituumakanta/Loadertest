package com.example.volmopc1.loadertest;


import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.CursorLoader;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*ContentResolver cr = getContentResolver();
        Uri u = ContactsContract.Contacts.CONTENT_URI;
        Cursor c = cr.query(u, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                Log.d("name", c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
            }
            while (c.moveToNext());
        }*/


        getLoaderManager().initLoader(1, null, this);

    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Toast.makeText(getApplicationContext(), "fff", Toast.LENGTH_LONG).show();
        Log.d("ddd", "lllooooodddeeerr");
        return new CursorLoader(MainActivity.this, ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        Log.d("aaa", "finish");
        if (cursor.moveToFirst()) {
            do {
                Log.d("name", cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
            }
            while (cursor.moveToNext());}
        cursor.moveToFirst();
        StringBuilder res = new StringBuilder();
        while (!cursor.isAfterLast()) {
            res.append("\n" + cursor.getString(21) + "-" + cursor.getString(22));
            Log.d("ddd", cursor.getString(22));
            cursor.moveToNext();
        }


    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        Log.d("ddd", "hhhhhh");
    }
}
