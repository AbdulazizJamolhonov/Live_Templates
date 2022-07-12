package developer.abdulaziz.my_live_templates.Database

interface DBInterface {
    fun createUser(user: User)
    fun readUser(): ArrayList<User>
    fun updateUser(user: User): Int
    fun deleteUser(user: User)
}