package developer.abdulaziz.my_live_templates.SharedPreferences

object List {
    private var sp: SharedPreferences? = null
    fun init(c: Context) {
        sp = c.getSharedPreferences("name", Context.MODE_PRIVATE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var sharedList: ArrayList<Type>
        get() = gsonStringToList(sharedPreferences.getString("keyList", "[]")!!)
        set(value) = sharedPreferences.edit {
            it.putString("keyList", listToGsonString(value))
        }

    private fun gsonStringToList(gsonString: String): ArrayList<Type> =
        Gson().fromJson(gsonString, object : TypeToken<ArrayList<Type>>() {}.type)

    private fun listToGsonString(list: ArrayList<Type>): String = Gson().toJson(list)
}