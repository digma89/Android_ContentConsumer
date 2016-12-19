package rodriguez.diego.com.lab8_contentconsumer;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentValues values = new ContentValues();
        values.put("firstname", "J.K._app2");
        values.put("lastname", "Rowling");

        // this app (Lab8ContentConsumer) has no database, check ADM if you do not believe :)
        // here we actually insert data in the SQLite database belonging Lab8ContentProvider app
        // we do this via the content provider defined in that app
        getContentResolver().insert(Uri.parse("content://com.centennialcollege.comp304.authorsprovider/author"), values);

        values.clear();
        values.put("firstname", "Mark_app2");
        values.put("lastname", "Twain");
        getContentResolver().insert(Uri.parse("content://com.centennialcollege.comp304.authorsprovider/author"), values);

        // here we retrieve the whole content of table authors from provider app
        Cursor c = getContentResolver().query(
                Uri.parse("content://com.centennialcollege.comp304.authorsprovider/author"), null, null, null, null);

        String result = "";

        while (c.moveToNext()) {
            result += c.getString(1);
        }
        System.out.println("RESULT CLIENT APP : " + result);

    }
}
