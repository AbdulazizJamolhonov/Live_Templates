package developer.abdulaziz.my_live_templates.Room

@Database(entities = [MyRoom::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun myDao(): MyDao

    companion object {
        private var appDatabase: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (appDatabase == null) {
                appDatabase =
                    Room.databaseBuilder(context, AppDatabase::class.java, "user_data")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return appDatabase!!
        }
    }
}