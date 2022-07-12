package developer.abdulaziz.my_live_templates.Database

class DBService(context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, VERSION), MyDBInterface {

    companion object {
        const val DB_NAME = "Database"
        const val TABLE_NAME = "MyTable"
        const val VERSION = 1
        const val ID = "id"
        const val NAME = "name"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val query =
            "CREATE TABLE $TABLE_NAME ($ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, $NAME TEXT NOT NULL)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(p0)
    }

    override fun createUser(user: User) {
        val contentValue = ContentValues().apply {
            put(NAME, user.name)
        }
        writableDatabase.insert(TABLE_NAME, null, contentValue).close()
    }

    override fun readUser(): ArrayList<User> {
        val list = ArrayList<User>()
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = readableDatabase.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                list.add(User(cursor.getInt(0), cursor.getString(1)))
            } while (cursor.moveToNext())
        }
        return list
    }

    override fun updateUser(user: User): Int {
        val cv = ContentValues().apply {
            put(ID, user.id)
            put(NAME, user.name)
        }
        return writableDatabase.update(TABLE_NAME, cv, "$ID = ?", arrayOf("${user.id}"))
    }

    override fun deleteUser(user: User) {
        writableDatabase.delete(TABLE_NAME, "$ID = ?", arrayOf("${user.id}")).close()
    }
}