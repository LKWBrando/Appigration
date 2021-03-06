package example.assignmentone.cp3406.app_igration;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDatabase extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private Context context;

    UserDatabase(Context context){
        super(context, "usernamelist.db", null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usernamelist (_id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT NOT NULL, userpass TEXT NOT NULL, usernum TEXT NOT NULL, useremail TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usernamelist");
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}