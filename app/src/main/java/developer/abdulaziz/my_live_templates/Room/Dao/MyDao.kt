package developer.abdulaziz.my_live_templates.Room.Dao

@Dao
interface MyDao {
    @Insert
    fun create(myRoom: MyRoom)

    @Query("select * from myRoom")
    fun read(): List<MyRoom>

    @Update
    fun update(myRoom: MyRoom)

    @Delete
    fun delete(myRoom: MyRoom)
}