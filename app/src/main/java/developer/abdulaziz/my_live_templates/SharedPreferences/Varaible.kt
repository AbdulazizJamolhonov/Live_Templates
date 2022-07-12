package developer.abdulaziz.my_live_templates.SharedPreferences

object Varaible {
    private var sp: SharedPreferences? = null
    fun init(c: Context) {
        sp = c.getSharedPreferences("name", Context.MODE_PRIVATE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var name: String?
        get() = sp.getString("name", "")
        set(value) = sp.edit { it.putString("name", value) }
}