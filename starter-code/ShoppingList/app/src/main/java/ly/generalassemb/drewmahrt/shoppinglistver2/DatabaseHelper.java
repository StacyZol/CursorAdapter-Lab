package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by stacyzolnikov on 7/12/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = DatabaseHelper.class.getCanonicalName();

    private static DatabaseHelper instance;
    private static final int DATABASE_VERSION = 7;
    private static final String DATABASE_NAME = "SHOPPING_DB";
    private static final String SHOPPING_LIST_TABLE_NAME = "SHOPPING_LIST";

    public static final String COL_ID ="_id";
    public static final String COL_ITEM_NAME = "ITEM_NAME";
    public static final String COL_ITEM_DESCRIPTION = "DESCRIPTION";
    public static final String COL_ITEM_TYPE = "TYPE";
    public static final String COL_ITEM_PRICE = "PRICE";

    public static final String[] SHOPPING_LIST_COLUMNS = {COL_ID,COL_ITEM_NAME, COL_ITEM_DESCRIPTION, COL_ITEM_TYPE, COL_ITEM_PRICE};


    public static final String CREATE_SHOPPING_LIST_TABLE = "CREATE TABLE " + SHOPPING_LIST_TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY," + COL_ITEM_NAME + " TEXT," + COL_ITEM_DESCRIPTION + " TEXT," + COL_ITEM_TYPE + " TEXT" + COL_ITEM_PRICE + " TEXT )";

    public static DatabaseHelper getInstance(Context context){
        if (instance ==null) {
            instance = new DatabaseHelper(context);
        }
        return instance;
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_SHOPPING_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS " + SHOPPING_LIST_TABLE_NAME);
        this.onCreate(db);
    }

    public Cursor getShoppingList() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(SHOPPING_LIST_TABLE_NAME, SHOPPING_LIST_COLUMNS, null, null, null, null, null);
        return cursor;
    }




}
